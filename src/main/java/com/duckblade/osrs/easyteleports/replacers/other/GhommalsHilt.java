package com.duckblade.osrs.easyteleports.replacers.other;

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
public class GhommalsHilt implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableGhommalsHilt();
		replacements.clear();

		replacements.add(new TeleportReplacement("Trollheim", config.replacementGhommalTrollheim()));
		replacements.add(new TeleportReplacement("Mor Ul Rek", config.replacementGhommalMorUlRek()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.CA_OFFHAND_EASY ||
			itemId == ItemID.CA_OFFHAND_MEDIUM ||
			itemId == ItemID.CA_OFFHAND_HARD ||
			itemId == ItemID.CA_OFFHAND_ELITE ||
			itemId == ItemID.CA_OFFHAND_MASTER ||
			itemId == ItemID.CA_OFFHAND_GRANDMASTER ||
			itemId == ItemID.INFERNAL_DEFENDER_GHOMMAL_5 ||
			itemId == ItemID.INFERNAL_DEFENDER_GHOMMAL_6 ||
			itemId == ItemID.INFERNAL_DEFENDER_GHOMMAL_5_TROUVER ||
			itemId == ItemID.INFERNAL_DEFENDER_GHOMMAL_6_TROUVER;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.SHIELD;
	}
}