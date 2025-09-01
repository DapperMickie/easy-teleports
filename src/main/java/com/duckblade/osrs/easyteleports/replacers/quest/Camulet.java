package com.duckblade.osrs.easyteleports.replacers.quest;

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
public class Camulet implements Replacer
{

	private static final String CAMULET_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableCamulet();

		replacements.clear();
		// chat dialog
		replacements.add(new TeleportReplacement("Enakhra's Temple.", config.replacementCamuletEnakhrasTemple()));
		replacements.add(new TeleportReplacement("Enakhra's Temple Entrance.", config.replacementCamuletEnakhrasTempleEntrance()));
		// inventory
		replacements.add(new TeleportReplacement("Enakhra's Temple", config.replacementCamuletEnakhrasTemple()));
		replacements.add(new TeleportReplacement("Enakhra's Temple Entrance", config.replacementCamuletEnakhrasTempleEntrance()));
		// equipped
		replacements.add(new TeleportReplacement("Temple", config.replacementCamuletEnakhrasTemple()));
		replacements.add(new TeleportReplacement("Surface", config.replacementCamuletEnakhrasTempleEntrance()));
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
			CAMULET_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.CAMULET;
	}
}