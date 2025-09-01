package com.duckblade.osrs.easyteleports.replacers.jewellery;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

public class SlayerRing implements Replacer
{

	private static final String SLAYER_RING_DIALOG_HEADER = "Select an Option";
	private static final String ETERNAL_SLAYER_RING_DIALOG_HEADER = "Select an option";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableSlayerRing();

		// More specific/longer replacements should be placed higher; you can run into sub-string replacement issues if
		// one replacement contains the same string as another, for example:
		// "Teleport to the Stronghold Slayer Cave" and "Stronghold"
		replacements.clear();
		replacements.add(new TeleportReplacement("Teleport to the Stronghold Slayer Cave", config.replacementSlayerStronghold()));
		replacements.add(new TeleportReplacement("Stronghold", config.replacementSlayerStronghold()));
		replacements.add(new TeleportReplacement("Teleport to the Morytania Slayer Tower", config.replacementSlayerTower()));
		replacements.add(new TeleportReplacement("Teleport to the Rellekka Slayer Caves", config.replacementSlayerRellekka()));
		replacements.add(new TeleportReplacement("Slayer Tower", config.replacementSlayerTower()));
		replacements.add(new TeleportReplacement("Teleport to the Fremennik Slayer Dungeon", config.replacementSlayerRellekka()));
		replacements.add(new TeleportReplacement("Fremennik Dungeon", config.replacementSlayerRellekka()));
		replacements.add(new TeleportReplacement("Teleport to Tarn's Lair", config.replacementTarns()));
		replacements.add(new TeleportReplacement("Tarn's Lair", config.replacementTarns()));
		replacements.add(new TeleportReplacement("Teleport to Dark Beasts", config.replacementDarkBeasts()));
		replacements.add(new TeleportReplacement("Dark Beasts", config.replacementDarkBeasts()));
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
			(SLAYER_RING_DIALOG_HEADER.equals(children[0].getText())
				|| ETERNAL_SLAYER_RING_DIALOG_HEADER.equals(children[0].getText()));
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.RING;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		// There is no ItemMapping for this right now

		return itemId == ItemID.SLAYER_RING_1
			|| itemId == ItemID.SLAYER_RING_2
			|| itemId == ItemID.SLAYER_RING_3
			|| itemId == ItemID.SLAYER_RING_4
			|| itemId == ItemID.SLAYER_RING_5
			|| itemId == ItemID.SLAYER_RING_6
			|| itemId == ItemID.SLAYER_RING_7
			|| itemId == ItemID.SLAYER_RING_8
			|| itemId == ItemID.SLAYER_RING_ETERNAL;
	}
}