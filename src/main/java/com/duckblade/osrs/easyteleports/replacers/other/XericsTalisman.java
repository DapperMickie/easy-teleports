package com.duckblade.osrs.easyteleports.replacers.other;

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
public class XericsTalisman implements Replacer
{

	private static final Set<String> TALISMAN_ADVENTURE_LOG_HEADER_PREFIXES = ImmutableSet.of(
		"The talisman has",
		"Xeric's Talisman teleports",
		"Xeric's Talisman left click"
	);

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableXericsTalisman();

		replacements.clear();
		replacements.add(new TeleportReplacement("Xeric's Lookout", config.replacementLookout()));
		replacements.add(new TeleportReplacement("Xeric's Glade", config.replacementGlade()));
		replacements.add(new TeleportReplacement("Xeric's Inferno", config.replacementInferno()));
		replacements.add(new TeleportReplacement("Xeric's Heart", config.replacementHeart()));
		replacements.add(new TeleportReplacement("Xeric's Honour", config.replacementHonour()));
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
			TALISMAN_ADVENTURE_LOG_HEADER_PREFIXES.stream()
				.anyMatch(s -> root.getText().startsWith(s));
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.XERIC_TALISMAN;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}
}