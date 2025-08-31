package com.duckblade.osrs.easyteleports.replacers.quest;

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
public class KharedstMemoirs implements Replacer
{

	private static final String KHAREDST_DIALOG_HEADER = "What would you like to remember?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableKharedstsMemoirs();

		// More specific/longer replacements should be placed higher; you can run into sub-string replacement issues if
		// one replacement contains the same string as another, for example:
		// "Lunch by the Lancalliums" and "'Lunch by the Lancalliums' - Hosidius"
		replacements.clear();
		// equipped
		replacements.add(new TeleportReplacement("Lunch by the Lancalliums", config.replacementLancalliums()));
		replacements.add(new TeleportReplacement("The Fisher's Flute", config.replacementFishers()));
		replacements.add(new TeleportReplacement("History and Hearsay", config.replacementHistory()));
		replacements.add(new TeleportReplacement("Jewellery of Jubilation", config.replacementJubilation()));
		replacements.add(new TeleportReplacement("A Dark Disposition", config.replacementDisposition()));

		// dialog
		replacements.add(new TeleportReplacement("'Lunch by the Lancalliums' - Hosidius", config.replacementLancalliums()));
		replacements.add(new TeleportReplacement("'The Fisher's Flute' - Piscarilius", config.replacementFishers()));
		replacements.add(new TeleportReplacement("'History and Hearsay' - Shayzien", config.replacementHistory()));
		replacements.add(new TeleportReplacement("'Jewellery of Jubilation' - Lovakengj", config.replacementJubilation()));
		replacements.add(new TeleportReplacement("'A Dark Disposition' - Arceuus", config.replacementDisposition()));
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
			KHAREDST_DIALOG_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.SHIELD;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.VEOS_KHAREDSTS_MEMOIRS || itemId == ItemID.BOOK_OF_THE_DEAD;
	}
}