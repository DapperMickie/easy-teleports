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

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DrakansMedallion implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableDrakans();
		replacements.clear();

		replacements.add(new TeleportReplacement("Ver Sinhaza", config.replacementVerSinhaza()));
		replacements.add(new TeleportReplacement("Darkmeyer", config.replacementDarkmeyer()));
		replacements.add(new TeleportReplacement("Slepe", config.replacementSlepe()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.DRAKANS_MEDALLION;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}
}