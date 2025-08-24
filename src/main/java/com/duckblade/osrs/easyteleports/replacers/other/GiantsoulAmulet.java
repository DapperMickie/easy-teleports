package com.duckblade.osrs.easyteleports.replacers.other;

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
public class GiantsoulAmulet implements Replacer
{

	private static final String GIANTSOUL_AMULET_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableGiantsoulAmulet();

		replacements.clear();
		// chat dialog
		replacements.add(new TeleportReplacement("Bryophyta's lair", config.replacementBryophyta()));
		replacements.add(new TeleportReplacement("Obor's lair", config.replacementObor()));
		replacements.add(new TeleportReplacement("Branda and Eldric's lair", config.replacementBrandaAndEldric()));

		// sub menus
		replacements.add(new TeleportReplacement("Bryophyta", config.replacementBryophyta()));
		replacements.add(new TeleportReplacement("Obor", config.replacementObor()));
		replacements.add(new TeleportReplacement("Branda and Eldric", config.replacementBrandaAndEldric()));
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
			GIANTSOUL_AMULET_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.GIANTSOUL_AMULET_CHARGED;
	}
}