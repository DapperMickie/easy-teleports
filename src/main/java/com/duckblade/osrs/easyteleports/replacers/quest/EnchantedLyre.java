package com.duckblade.osrs.easyteleports.replacers.quest;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class EnchantedLyre implements Replacer
{

	private static final String ENCHANTED_LYRE_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableEnchantedLyre();

		replacements.clear();
		replacements.add(new TeleportReplacement("Rellekka", config.replacementLyreRellekka()));
		replacements.add(new TeleportReplacement("Waterbirth Island", config.replacementLyreWaterbirthIsland()));
		replacements.add(new TeleportReplacement("Neitiznot", config.replacementLyreNeitiznot()));
		replacements.add(new TeleportReplacement("Jatizso", config.replacementLyreJatizso()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToDialog(Widget root)
	{
		Widget[] children = root.getChildren();
		return children != null &&
			children.length >= 5 &&
			ENCHANTED_LYRE_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.WEAPON;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.MAGIC_STRUNG_LYRE ||
			itemId == ItemID.MAGIC_STRUNG_LYRE_2 ||
			itemId == ItemID.MAGIC_STRUNG_LYRE_3 ||
			itemId == ItemID.MAGIC_STRUNG_LYRE_4 ||
			itemId == ItemID.MAGIC_STRUNG_LYRE_5 ||
			itemId == ItemID.MAGIC_STRUNG_LYRE_INFINITE;
	}
}