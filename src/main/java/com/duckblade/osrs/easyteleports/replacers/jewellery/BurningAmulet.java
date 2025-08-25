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
public class BurningAmulet implements Replacer
{

	private static final String BURNING_AMULET_DIALOGUE_HEADER = "Teleport to...";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableBurningAmulet();

		replacements.clear();
		replacements.add(new TeleportReplacement("Chaos Temple", config.replacementBurningChaosTemple()));
		replacements.add(new TeleportReplacement("Bandit Camp", config.replacementBurningBanditCamp()));
		replacements.add(new TeleportReplacement("Lava Maze", config.replacementBurningLavaMaze()));
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
			BURNING_AMULET_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.BURNING_AMULET_5 ||
			itemId == ItemID.BURNING_AMULET_4 ||
			itemId == ItemID.BURNING_AMULET_3 ||
			itemId == ItemID.BURNING_AMULET_2 ||
			itemId == ItemID.BURNING_AMULET_1;
	}
}