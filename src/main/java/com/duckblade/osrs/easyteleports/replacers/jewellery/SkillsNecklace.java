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
import net.runelite.client.game.ItemMapping;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class SkillsNecklace implements Replacer
{

	private static final String ADVENTURE_LOG_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableSkillsNecklace();

		replacements.clear();
		replacements.add(new TeleportReplacement("Fishing Guild", config.replacementSkillsFishingGuild()));
		replacements.add(new TeleportReplacement("Mining Guild", config.replacementSkillsMiningGuild()));
		replacements.add(new TeleportReplacement("Crafting Guild", config.replacementSkillsCraftingGuild()));
		replacements.add(new TeleportReplacement("Cooking Guild", config.replacementSkillsCookingGuild()));
		replacements.add(new TeleportReplacement("Woodcutting Guild", config.replacementSkillsWoodcuttingGuild()));
		replacements.add(new TeleportReplacement("Farming Guild", config.replacementSkillsFarmingGuild()));
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
				ADVENTURE_LOG_HEADER.equals(root.getText());
	}

	@Override
	public boolean isApplicableToJewelleryBox()
	{
		return true;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		Collection<ItemMapping> itemMappings = ItemMapping.map(itemId);
		return itemId == ItemID.JEWL_NECKLACE_OF_SKILLS_4
				|| itemId == ItemID.JEWL_NECKLACE_OF_SKILLS_6
				|| (itemMappings != null && itemMappings.contains(ItemMapping.ITEM_SKILLS_NECKLACE));
	}
}