package com.duckblade.osrs.easyteleports.replacers.quest;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class RingOfShadows implements Replacer
{

	private static final String RING_OF_SHADOWS_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(6);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableRingOfShadows();

		replacements.clear();
		replacements.add(new TeleportReplacement("The Ancient Vault", config.replacementAncientVault())); // dialogue
		replacements.add(new TeleportReplacement("Ancient Vault", config.replacementAncientVault())); // equipped
		replacements.add(new TeleportReplacement("Ghorrock Dungeon", config.replacementGhorrockDungeon()));
		replacements.add(new TeleportReplacement("The Scar", config.replacementScar()));
		replacements.add(new TeleportReplacement("Lassar Undercity", config.replacementLassarUndercity()));
		replacements.add(new TeleportReplacement("The Stranglewood", config.replacementStranglewood()));
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
			RING_OF_SHADOWS_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.RING;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.RING_OF_SHADOWS;
	}
}