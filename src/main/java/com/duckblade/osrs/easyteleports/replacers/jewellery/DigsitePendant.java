package com.duckblade.osrs.easyteleports.replacers.jewellery;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DigsitePendant implements Replacer
{

	private static final Set<String> DIGSITE_PENDANT_ADVENTURE_LOG_HEADER_PREFIXES = ImmutableSet.of(
		"Digsite Pendant teleport",
		"Where would you like to teleport to?",
		"Digsite Pendant left click"
	);

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableDigsitePendant();

		replacements.clear();
		replacements.add(new TeleportReplacement("Digsite", config.replacementDigsite()));
		replacements.add(new TeleportReplacement("Fossil Island", config.replacementFossilIsland()));
		replacements.add(new TeleportReplacement("Lithkren Dungeon", config.replacementLithkren()));
		replacements.add(new TeleportReplacement("Lithkren", config.replacementLithkren()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToAdventureLog(Widget root)
	{
		return root != null &&
			root.getText() != null &&
			DIGSITE_PENDANT_ADVENTURE_LOG_HEADER_PREFIXES.stream()
				.anyMatch(s -> root.getText().startsWith(s));
	}

	@Override
	public boolean isApplicableToDialog(Widget root)
	{
		Widget[] children = root.getChildren();
		return children != null &&
			children.length >= 5 &&
			DIGSITE_PENDANT_ADVENTURE_LOG_HEADER_PREFIXES.stream()
				.anyMatch(s -> children[0].getText().startsWith(s));
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.NECKLACE_OF_DIGSITE_1 ||
			itemId == ItemID.NECKLACE_OF_DIGSITE_2 ||
			itemId == ItemID.NECKLACE_OF_DIGSITE_3 ||
			itemId == ItemID.NECKLACE_OF_DIGSITE_4 ||
			itemId == ItemID.NECKLACE_OF_DIGSITE_5;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}
}