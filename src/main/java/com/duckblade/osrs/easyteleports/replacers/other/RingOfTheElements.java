package com.duckblade.osrs.easyteleports.replacers.other;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class RingOfTheElements implements Replacer
{

	private static final String RING_OF_THE_ELEMENTS_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableRingOfTheElements();

		replacements.clear();
		replacements.add(new TeleportReplacement("Air Altar", config.replacementAirAltar()));
		replacements.add(new TeleportReplacement("Water Altar", config.replacementWaterAltar()));
		replacements.add(new TeleportReplacement("Earth Altar", config.replacementEarthAltar()));
		replacements.add(new TeleportReplacement("Fire Altar", config.replacementFireAltar()));
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
			RING_OF_THE_ELEMENTS_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.RING;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.RING_OF_ELEMENTS_CHARGED;
	}
}