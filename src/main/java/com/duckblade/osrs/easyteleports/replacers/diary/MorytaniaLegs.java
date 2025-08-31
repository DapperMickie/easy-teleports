package com.duckblade.osrs.easyteleports.replacers.diary;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class MorytaniaLegs implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableMorytaniaLegs();

		replacements.clear();
		replacements.add(new TeleportReplacement("Ectofuntus Pit", config.replacementMorytaniaEctofuntus()));
		replacements.add(new TeleportReplacement("Ecto Teleport", config.replacementMorytaniaEctofuntus()));
		replacements.add(new TeleportReplacement("Burgh de Rott", config.replacementMorytaniaBurgh()));
		replacements.add(new TeleportReplacement("Burgh Teleport", config.replacementMorytaniaBurgh()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.MORYTANIA_LEGS_EASY ||
			itemId == ItemID.MORYTANIA_LEGS_MEDIUM ||
			itemId == ItemID.MORYTANIA_LEGS_HARD ||
			itemId == ItemID.MORYTANIA_LEGS_ELITE;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.LEGS;
	}
}