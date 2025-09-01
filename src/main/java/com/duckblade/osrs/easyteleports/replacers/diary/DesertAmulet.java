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
public class DesertAmulet implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableDesertAmulet();

		replacements.clear();
		replacements.add(new TeleportReplacement("Nardah", config.replacementDesertNardah()));
		replacements.add(new TeleportReplacement("Kalphite cave", config.replacementDesertKalphiteCave()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.DESERT_AMULET_EASY ||
			itemId == ItemID.DESERT_AMULET_MEDIUM ||
			itemId == ItemID.DESERT_AMULET_HARD ||
			itemId == ItemID.DESERT_AMULET_ELITE;
	}
}