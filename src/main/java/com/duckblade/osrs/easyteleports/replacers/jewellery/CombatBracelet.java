package com.duckblade.osrs.easyteleports.replacers.jewellery;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CombatBracelet implements Replacer
{

	private static final String COMBAT_BRACELET_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableCombatBracelet();

		replacements.clear();
		replacements.add(new TeleportReplacement("Warriors' Guild", config.replacementCombatWarriorsGuild()));
		replacements.add(new TeleportReplacement("Champions' Guild", config.replacementCombatChampionsGuild()));
		replacements.add(new TeleportReplacement("Monastery", config.replacementCombatMonastery()));
		replacements.add(new TeleportReplacement("Ranging Guild", config.replacementCombatRangingGuild()));
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
			COMBAT_BRACELET_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public boolean isApplicableToJewelleryBox()
	{
		return true;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.GLOVES;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.JEWL_BRACELET_OF_COMBAT_6 ||
				itemId == ItemID.JEWL_BRACELET_OF_COMBAT_5 ||
				itemId == ItemID.JEWL_BRACELET_OF_COMBAT_4 ||
				itemId == ItemID.JEWL_BRACELET_OF_COMBAT_3 ||
				itemId == ItemID.JEWL_BRACELET_OF_COMBAT_2 ||
				itemId == ItemID.JEWL_BRACELET_OF_COMBAT_1;
	}
}