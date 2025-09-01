package com.duckblade.osrs.easyteleports.replacers.jewellery;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.ItemMapping;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class RingOfDueling implements Replacer
{

	private static final String RING_OF_DUELING_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableRingOfDueling();

		replacements.clear();
		// chat dialog
		replacements.add(new TeleportReplacement("Emir's Arena.", config.replacementEmirsArena()));
		replacements.add(new TeleportReplacement("Castle Wars Arena.", config.replacementCastleWars()));
		replacements.add(new TeleportReplacement("Ferox Enclave.", config.replacementFeroxEnclave()));
		replacements.add(new TeleportReplacement("Fortis Colosseum.", config.replacementFortisColosseum()));
		// sub menus
		replacements.add(new TeleportReplacement("Emir's Arena", config.replacementEmirsArena()));
		replacements.add(new TeleportReplacement("Castle Wars", config.replacementCastleWars()));
		replacements.add(new TeleportReplacement("Ferox Enclave", config.replacementFeroxEnclave()));
		replacements.add(new TeleportReplacement("Fortis Colosseum", config.replacementFortisColosseum()));
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
			RING_OF_DUELING_DIALOGUE_HEADER.equals(children[0].getText());
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
		return itemId == ItemID.RING_OF_DUELING_8 || (itemMappings != null && itemMappings.contains(ItemMapping.ITEM_RING_OF_DUELING));
	}
}