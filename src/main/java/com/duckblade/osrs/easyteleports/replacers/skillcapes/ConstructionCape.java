package com.duckblade.osrs.easyteleports.replacers.skillcapes;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

import java.util.ArrayList;
import java.util.List;

public class ConstructionCape implements Replacer
{

	private static final String ADVENTURE_LOG_HEADER = "House portal teleports";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableConstructionCape();

		replacements.clear();
		replacements.add(new TeleportReplacement("Tele to POH", config.replacementConstructCapeHome()));
		replacements.add(new TeleportReplacement("Home", config.replacementConstructCapeHome()));
		replacements.add(new TeleportReplacement("Rimmington", config.replacementConstructCapeRimmington()));
		replacements.add(new TeleportReplacement("Taverley", config.replacementConstructCapeTaverley()));
		replacements.add(new TeleportReplacement("Pollnivneach", config.replacementConstructCapePollnivneach()));
		replacements.add(new TeleportReplacement("Hosidius", config.replacementConstructCapeHosidius()));
		replacements.add(new TeleportReplacement("Aldarin", config.replacementConstructCapeAldarin()));
		replacements.add(new TeleportReplacement("Rellekka", config.replacementConstructCapeRellekka()));
		replacements.add(new TeleportReplacement("Brimhaven", config.replacementConstructCapeBrimhaven()));
		replacements.add(new TeleportReplacement("Yanille", config.replacementConstructCapeYanille()));
		replacements.add(new TeleportReplacement("Prifddinas", config.replacementConstructCapePrifddinas()));
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
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.CAPE;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.SKILLCAPE_CONSTRUCTION ||
				itemId == ItemID.SKILLCAPE_CONSTRUCTION_TRIMMED;
	}
}