package com.duckblade.osrs.easyteleports.replacers.skillcapes;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;

import java.util.ArrayList;
import java.util.List;

public class FishingCape implements Replacer
{
	private final List<TeleportReplacement> replacements = new ArrayList<>(2);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableFishingCape();

		replacements.clear();
		replacements.add(new TeleportReplacement("Fishing Guild", config.replacementFishingCapeFishingGuild()));
		replacements.add(new TeleportReplacement("Otto's Grotto", config.replacementFishingCapeOttosGrotto()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.CAPE;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.SKILLCAPE_FISHING ||
				itemId == ItemID.SKILLCAPE_FISHING_TRIMMED;
	}
}