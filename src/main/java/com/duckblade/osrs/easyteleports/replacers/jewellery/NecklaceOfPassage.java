package com.duckblade.osrs.easyteleports.replacers.jewellery;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class NecklaceOfPassage implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(3);
	private static final String NECKLACE_OF_PASSGE_DIALOG_HEADER = "Teleport to...";

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableNecklaceOfPassage();

		replacements.clear();
		replacements.add(new TeleportReplacement("Wizards' Tower", config.replacementWizardsTower()));
		replacements.add(new TeleportReplacement("The Outpost", config.replacementOutpost()));
		replacements.add(new TeleportReplacement("Eagles' Eyrie", config.replacementEagleEyrie()));
		replacements.add(new TeleportReplacement("Eagle's Eyrie", config.replacementEagleEyrie()));
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
			children.length >= 4 &&
			NECKLACE_OF_PASSGE_DIALOG_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.NECKLACE_OF_PASSAGE_1
			|| itemId == ItemID.NECKLACE_OF_PASSAGE_2
			|| itemId == ItemID.NECKLACE_OF_PASSAGE_3
			|| itemId == ItemID.NECKLACE_OF_PASSAGE_4
			|| itemId == ItemID.NECKLACE_OF_PASSAGE_5;
	}
}