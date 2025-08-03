package com.duckblade.osrs.easyteleports;

import com.duckblade.osrs.easyteleports.replacers.*;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Easy Teleports",
        tags = {"Pharaoh's", "sceptre", "Xeric's", "talisman", "Kharedst's", "memoirs", "dueling", "achievement", "diary", "cape", "slayer", "ring", "Drakan's", "medallion", "shadows", "necklace", "passage", "pendant", "ates", "digsite", "max", "giantsoul", "elements", "teleport"}
)
@Singleton
public class EasyTeleportsPlugin extends Plugin {

    private static final Map<Integer, EquipmentInventorySlot> ACTION_PARAM_1_TO_EQUIPMENT_SLOT =
            ImmutableMap.<Integer, EquipmentInventorySlot>builder()
                    .put(25362447, EquipmentInventorySlot.HEAD)
                    .put(25362448, EquipmentInventorySlot.CAPE)
                    .put(25362449, EquipmentInventorySlot.AMULET)
                    .put(25362457, EquipmentInventorySlot.AMMO)
                    .put(25362450, EquipmentInventorySlot.WEAPON)
                    .put(25362451, EquipmentInventorySlot.BODY)
                    .put(25362452, EquipmentInventorySlot.SHIELD)
                    .put(25362453, EquipmentInventorySlot.LEGS)
                    .put(25362454, EquipmentInventorySlot.GLOVES)
                    .put(25362455, EquipmentInventorySlot.BOOTS)
                    .put(25362456, EquipmentInventorySlot.RING)
                    .build();

    private static final int ACTION_PARAM_1_INVENTORY = 9764864;

    private static final int GROUP_ID_JEWELLERY_BOX = 590;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private EasyTeleportsConfig config;

    @Inject
    private Set<Replacer> replacers;

    @Override
    public void configure(Binder binder) {
        Multibinder<Replacer> replacers = Multibinder.newSetBinder(binder, Replacer.class);
        replacers.addBinding().to(DiaryCape.class);
        replacers.addBinding().to(DrakansMedallion.class);
        replacers.addBinding().to(KharedstMemoirs.class);
        replacers.addBinding().to(PharaohSceptre.class);
        replacers.addBinding().to(RingOfDueling.class);
        replacers.addBinding().to(RingOfShadows.class);
        replacers.addBinding().to(SlayerRing.class);
        replacers.addBinding().to(XericsTalisman.class);
        replacers.addBinding().to(NecklaceOfPassage.class);
        replacers.addBinding().to(PendantOfAtes.class);
        replacers.addBinding().to(DigsitePendant.class);
        replacers.addBinding().to(RingOfTheElements.class);
        replacers.addBinding().to(GiantsoulAmulet.class);
        replacers.addBinding().to(MaxCape.class);
    }

    @Override
    protected void startUp() {
        propagateConfig();
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged e) {
        if (e.getGroup().equals(EasyTeleportsConfig.CONFIG_GROUP)) {
            propagateConfig();
        }
    }

    private void propagateConfig() {
        this.replacers.forEach(r -> r.onConfigChanged(config));
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded e) {
        // chatbox dialog
        if (e.getGroupId() == InterfaceID.CHATMENU) {
            //InterfaceID.DIALOG_OPTION
            Widget chatbox = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
            clientThread.invokeLater(() -> replaceWidgetChildren(chatbox, Replacer::isApplicableToDialog, config.enableShadowedText()));
        }

        if (e.getGroupId() == InterfaceID.PENDANT_OF_ATES) {
            Widget pendant = client.getWidget(InterfaceID.PendantOfAtes.TELEPORT_LAYER);
            clientThread.invokeLater(() -> replacePendantWidgetChildren(pendant, Replacer::isApplicableToAdventureLog, false));
        }

        // the scroll thing that xeric's talisman uses
        // annoyingly, the header text and teleport entries share a groupId (187.0 vs 187.3),
        // but don't share a parent with that same groupId, their parent is 164.16
        if (e.getGroupId() == InterfaceID.MENU) {
            clientThread.invokeLater(() ->
            {
                Widget advLogHeader = getAdventureLogHeader();
                replaceWidgetChildren(InterfaceID.Menu.LJ_LAYER2, 3, (r, w) -> r.isApplicableToAdventureLog(advLogHeader));
                // Fix for Xeric's talisman in poh
                Widget pohWidget = client.getWidget(InterfaceID.Menu.LJ_LAYER1);
                replaceWidgetChildren(pohWidget, (r, w) -> r.isApplicableToAdventureLog(advLogHeader));
            });
            return;
        }

        // jewellery box
        if (e.getGroupId() == GROUP_ID_JEWELLERY_BOX) {
            clientThread.invokeLater(() ->
            {
                Widget jewelleryBoxRoot = client.getWidget(GROUP_ID_JEWELLERY_BOX, 0);
                if (jewelleryBoxRoot == null) {
                    return;
                }

                for (int i = 0; i < 6; i++) {
                    replaceWidgetChildren(GROUP_ID_JEWELLERY_BOX, 2 + i, (r, w) -> r.isApplicableToJewelleryBox());
                }
            });
        }
    }


    public static final int PENDANT_OF_ATES_MAIN_TELEPORT_SCRIPT_ID = 6645;
    public static final int PENDANT_OF_ATES_TEXT_TELEPORT_SCRIPT_ID = 6646;

    @Subscribe
    private void onScriptPreFired(ScriptPreFired scriptPreFired) {
        if (scriptPreFired.getScriptId() == PENDANT_OF_ATES_TEXT_TELEPORT_SCRIPT_ID) {
            final Object[] stringStack = client.getObjectStack();
            final int stringStackSize = client.getObjectStackSize();
            if (stringStackSize == 1) {
                final String textToReplace = stringStack[0].toString();

                for (TeleportReplacement replacement : getApplicableReplacements(r -> r.isApplicableToScriptId(scriptPreFired.getScriptId()))) {
                    if (textToReplace.contains(replacement.getOriginal())) {
                        final String newText = textToReplace.replace(replacement.getOriginal(), replacement.getReplacement());
                        stringStack[0] = newText;
                    }
                }
            }
        }
    }

    @Subscribe
    public void onScriptPostFired(ScriptPostFired scriptPostFired) {
        if (scriptPostFired.getScriptId() == PENDANT_OF_ATES_MAIN_TELEPORT_SCRIPT_ID) {
            Widget pendant = client.getWidget(InterfaceID.PendantOfAtes.TELEPORT_LAYER);
            clientThread.invokeLater(() -> replacePendantWidgetChildren(pendant, Replacer::isApplicableToAdventureLog, false));
        }
    }

    private void replaceWidgetChildren(int groupId, int entriesChildId, BiPredicate<Replacer, Widget> filterSelector) {
        Widget root = client.getWidget(groupId, entriesChildId);
        if (root == null) {
            return;
        }

        replaceWidgetChildren(root, filterSelector);
    }

    private void replacePendantWidgetChildren(Widget root, BiPredicate<Replacer, Widget> filterSelector, boolean shadowedText) {
        Widget[] children = root.getStaticChildren();

        if (children == null) {
            return;
        }

        List<TeleportReplacement> applicableReplacements = getApplicableReplacements(r -> filterSelector.test(r, root));
        for (Widget child : children) {
            applyReplacement(applicableReplacements, child, Widget::getName, Widget::setName, shadowedText);
            Widget[] actualChildren = child.getChildren();
            if (actualChildren == null) {
                return;
            }

            for (Widget actualChild : actualChildren) {
                applyReplacement(applicableReplacements, actualChild, Widget::getName, Widget::setName, shadowedText);
                applyReplacement(applicableReplacements, actualChild, Widget::getText, Widget::setText, shadowedText);

                Widget[] actualActualChildren = actualChild.getChildren();
                if (actualActualChildren == null) {
                    continue;
                }

                for (Widget actualActualChild : actualActualChildren) {
                    applyReplacement(applicableReplacements, actualActualChild, Widget::getName, Widget::setName, shadowedText);
                    applyReplacement(applicableReplacements, actualActualChild, Widget::getText, Widget::setText, shadowedText);
                }
            }
        }
    }

    private void replaceWidgetChildren(Widget root, BiPredicate<Replacer, Widget> filterSelector) {
        replaceWidgetChildren(root, filterSelector, false);
    }

    private void replaceWidgetChildren(Widget root, BiPredicate<Replacer, Widget> filterSelector, boolean shadowedText) {
        Widget[] children = root.getChildren();
        if (children == null) {
            children = root.getStaticChildren();
        }

        if (children == null) {
            return;
        }

        List<TeleportReplacement> applicableReplacements = getApplicableReplacements(r -> filterSelector.test(r, root));
        for (Widget child : children) {
            applyReplacement(applicableReplacements, child, Widget::getText, Widget::setText, shadowedText);
        }
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded e) {
        if (e.getActionParam1() == ACTION_PARAM_1_INVENTORY) {
            List<TeleportReplacement> applicableReplacements = getApplicableReplacements(r -> r.isApplicableToInventory(e.getMenuEntry().getItemId()));
            clientThread.invokeLater(() -> applyReplacement(applicableReplacements, e.getMenuEntry(), MenuEntry::getOption, MenuEntry::setOption));
            return;
        }

        EquipmentInventorySlot equipmentSlot = ACTION_PARAM_1_TO_EQUIPMENT_SLOT.get(e.getActionParam1());
        if (equipmentSlot != null) {
            List<TeleportReplacement> applicableReplacements = getApplicableReplacements(r -> r.getEquipmentSlot() == equipmentSlot);
            applyReplacement(applicableReplacements, e.getMenuEntry(), MenuEntry::getOption, MenuEntry::setOption);
        }
    }

    private List<TeleportReplacement> getApplicableReplacements(Predicate<Replacer> filter) {
        return replacers.stream()
                .filter(Replacer::isEnabled)
                .filter(filter)
                .flatMap(r -> r.getReplacements().stream())
                .collect(Collectors.toList());
    }

    private Widget getAdventureLogHeader() {
        Widget adventureLogRoot = client.getWidget(InterfaceID.Menu.LJ_LAYER2);
        if (adventureLogRoot == null) {
            return null;
        }

        Widget[] children = adventureLogRoot.getChildren();
        if (children == null || children.length < 2) {
            return null;
        }

        return children[1];
    }

    @Provides
    public EasyTeleportsConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EasyTeleportsConfig.class);
    }

    private static <T> void applyReplacement(List<TeleportReplacement> replacements, T entry, Function<T, String> getter, BiConsumer<T, String> setter) {
        applyReplacement(replacements, entry, getter, setter, false);
    }

    private static <T> void applyReplacement(List<TeleportReplacement> replacements, T entry, Function<T, String> getter, BiConsumer<T, String> setter, boolean shadowedText) {
        String entryText = null;
        try {
            entryText = getter.apply(entry);
            if (Strings.isNullOrEmpty(entryText)) {
                return;
            }

            for (TeleportReplacement replacement : replacements) {
                if (entryText.contains(replacement.getOriginal())) {
                    if ((replacement.getReplacement().contains("</col>") || replacement.getReplacement().contains("<col=")) && shadowedText && entry instanceof Widget) {
                        Widget wEntry = ((Widget) entry);
                        wEntry.setTextShadowed(true);
                        wEntry.revalidate();
                    }
                    String newText = entryText.replace(replacement.getOriginal(), replacement.getReplacement());
                    setter.accept(entry, newText);
                }
            }
        } catch (Exception e) {
            log.error("Failed to replace option [{}] on entry [{}]", entryText, entry.toString());
        }
    }


}