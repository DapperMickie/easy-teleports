package com.duckblade.osrs.easyteleports.replacers;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

import java.util.ArrayList;
import java.util.List;

public class MaxCape implements Replacer
{

	private static final String ADVENTURE_LOG_HEADER = "Select a destination";
	private static final String ADVENTURE_LOG_HEADER_POH = "House portal teleports";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableMaxCape();

		replacements.clear();
		replacements.add(new TeleportReplacement("Warrior's Guild", config.replacementMaxCapeWarriorsGuild()));
		replacements.add(new TeleportReplacement("Fishing Guild", config.replacementMaxCapeFishingGuild()));
		replacements.add(new TeleportReplacement("Crafting Guild", config.replacementMaxCapeCraftingGuild()));
		replacements.add(new TeleportReplacement("Farming Guild", config.replacementMaxCapeFarmingGuild()));
		replacements.add(new TeleportReplacement("Otto's Grotto", config.replacementMaxCapeOttosGrotto()));
		replacements.add(new TeleportReplacement("Feldip Hills", config.replacementMaxCapeFeldipHills()));
		replacements.add(new TeleportReplacement("Carnivorous chinchompas", config.replacementMaxCapeFeldipHills()));
		replacements.add(new TeleportReplacement("Black chinchompas", config.replacementMaxCapeBlackChincompas()));
		replacements.add(new TeleportReplacement("Black Chinchompas", config.replacementMaxCapeBlackChincompas()));
		replacements.add(new TeleportReplacement("Hunter Guild", config.replacementMaxCapeHunterGuild()));
		replacements.add(new TeleportReplacement("Home", config.replacementMaxCapeHome()));
		replacements.add(new TeleportReplacement("Rimmington", config.replacementMaxCapeRimmington()));
		replacements.add(new TeleportReplacement("Taverley", config.replacementMaxCapeTaverley()));
		replacements.add(new TeleportReplacement("Pollnivneach", config.replacementMaxCapePollnivneach()));
		replacements.add(new TeleportReplacement("Hosidius", config.replacementMaxCapeHosidius()));
		replacements.add(new TeleportReplacement("Aldarin", config.replacementMaxCapeAldarin()));
		replacements.add(new TeleportReplacement("Rellekka", config.replacementMaxCapeRellekka()));
		replacements.add(new TeleportReplacement("Brimhaven", config.replacementMaxCapeBrimhaven()));
		replacements.add(new TeleportReplacement("Yanille", config.replacementMaxCapeYanille()));
		replacements.add(new TeleportReplacement("Prifddinas", config.replacementMaxCapePrifddinas()));
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
				(ADVENTURE_LOG_HEADER.equals(root.getText()) || ADVENTURE_LOG_HEADER_POH.equals(root.getText()));
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.CAPE;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.SKILLCAPE_MAX;
	}
}