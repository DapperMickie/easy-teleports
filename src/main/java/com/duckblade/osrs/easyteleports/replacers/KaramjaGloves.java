package com.duckblade.osrs.easyteleports.replacers;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
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
public class KaramjaGloves implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableKaramjaGloves();
		replacements.clear();

		replacements.add(new TeleportReplacement("Gem Mine", config.replacementKaramjaGemMine()));
		replacements.add(new TeleportReplacement("Slayer Master", config.replacementKaramjaSlayerMaster()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.ATJUN_GLOVES_EASY ||
			itemId == ItemID.ATJUN_GLOVES_MED ||
			itemId == ItemID.ATJUN_GLOVES_HARD ||
			itemId == ItemID.ATJUN_GLOVES_ELITE;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.GLOVES;
	}
}