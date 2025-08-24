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

public class HunterCape implements Replacer
{
	private static final String HUNTER_CAPE_DIALOGUE_HEADER = "Which hunting location would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(2);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableHunterCape();

		replacements.clear();
		replacements.add(new TeleportReplacement("Hunter Guild", config.replacementHunterCapeHunterGuild()));
		replacements.add(new TeleportReplacement("Carnivorous Chinchompas (Feldip Hills)", config.replacementHunterCapeFeldipHills()));
		replacements.add(new TeleportReplacement("Carnivorous Chinchompas", config.replacementHunterCapeFeldipHills()));
		replacements.add(new TeleportReplacement("Black Chinchompas (Wilderness)", config.replacementHunterCapeBlackChinchompas()));
		replacements.add(new TeleportReplacement("Black Chinchompas", config.replacementHunterCapeBlackChinchompas()));
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
				HUNTER_CAPE_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.CAPE;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.SKILLCAPE_HUNTING ||
				itemId == ItemID.SKILLCAPE_HUNTING_TRIMMED;
	}
}