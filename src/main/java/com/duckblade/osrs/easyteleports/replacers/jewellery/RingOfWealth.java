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
public class RingOfWealth implements Replacer
{

	private static final String RING_OF_WEALTH_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableRingOfWealth();

		// More specific/longer replacements should be placed higher; you can run into sub-string replacement issues if
		// one replacement contains the same string as another, for example:
		// "Falador Park" and "Falador"
		replacements.clear();
		replacements.add(new TeleportReplacement("Miscellania", config.replacementWealthMiscellania()));
		replacements.add(new TeleportReplacement("Grand Exchange", config.replacementWealthGrandExchange()));
		replacements.add(new TeleportReplacement("Falador Park", config.replacementWealthFalador()));
		replacements.add(new TeleportReplacement("Falador", config.replacementWealthFalador()));
		replacements.add(new TeleportReplacement("Dondakan's Rock", config.replacementWealthDondakan()));
		replacements.add(new TeleportReplacement("Dondakan", config.replacementWealthDondakan()));
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
			RING_OF_WEALTH_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public boolean isApplicableToJewelleryBox()
	{
		return true;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.RING;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		Collection<ItemMapping> itemMappings = ItemMapping.map(itemId);
		return itemId == ItemID.RING_OF_WEALTH_5
				|| (itemMappings != null && itemMappings.contains(ItemMapping.ITEM_RING_OF_WEALTH))
				|| (itemMappings != null && itemMappings.contains(ItemMapping.ITEM_RING_OF_WEALTH_SCROLL));
	}
}