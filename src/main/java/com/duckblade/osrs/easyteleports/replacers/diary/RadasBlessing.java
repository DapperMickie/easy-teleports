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
public class RadasBlessing implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableRadasBlessing();

		replacements.clear();
		replacements.add(new TeleportReplacement("Kourend Woodland", config.replacementRadasKourendWoodland()));
		replacements.add(new TeleportReplacement("Mount Karuulm", config.replacementRadasMountKaruulm()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.ZEAH_BLESSING_EASY ||
			itemId == ItemID.ZEAH_BLESSING_MEDIUM ||
			itemId == ItemID.ZEAH_BLESSING_HARD ||
			itemId == ItemID.ZEAH_BLESSING_ELITE;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMMO;
	}
}