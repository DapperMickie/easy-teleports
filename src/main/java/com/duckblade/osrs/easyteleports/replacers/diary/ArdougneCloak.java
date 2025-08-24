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
public class ArdougneCloak implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableArdougneCloak();

		replacements.clear();
		replacements.add(new TeleportReplacement("Kandarin Monastery", config.replacementArdougneCloakKandarinMonastery()));
		replacements.add(new TeleportReplacement("Monastery Teleport", config.replacementArdougneCloakKandarinMonastery()));
		replacements.add(new TeleportReplacement("Ardougne Farm", config.replacementArdougneCloakArdougneFarm()));
		replacements.add(new TeleportReplacement("Farm Teleport", config.replacementArdougneCloakArdougneFarm()));
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
		return itemId == ItemID.ARDY_CAPE_EASY ||
			itemId == ItemID.ARDY_CAPE_MEDIUM ||
			itemId == ItemID.ARDY_CAPE_HARD ||
			itemId == ItemID.ARDY_CAPE_ELITE;
	}
}