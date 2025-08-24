package com.duckblade.osrs.easyteleports.replacers.other;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;

import static com.duckblade.osrs.easyteleports.EasyTeleportsPlugin.PENDANT_OF_ATES_MAIN_TELEPORT_SCRIPT_ID;
import static com.duckblade.osrs.easyteleports.EasyTeleportsPlugin.PENDANT_OF_ATES_TEXT_TELEPORT_SCRIPT_ID;

import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.gameval.InterfaceID;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PendantOfAtes implements Replacer
{
	private static final String PENDANT_DIALOG_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(4);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enablePendantOfAtes();
		replacements.clear();

		replacements.add(new TeleportReplacement("Darkfrost", config.replacementDarkfrost()));
		replacements.add(new TeleportReplacement("Twilight Temple", config.replacementTwilightTemple()));
		replacements.add(new TeleportReplacement("Ralos' Rise", config.replacementRalosRise()));
		replacements.add(new TeleportReplacement("North Aldarin", config.replacementNorthAldarin()));
		replacements.add(new TeleportReplacement("Kastori", config.replacementKastori()));
		replacements.add(new TeleportReplacement("Nemus Retreat", config.replacementNemusRetreat()));
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
			PENDANT_DIALOG_HEADER.equals(children[0].getText());
	}

	@Override
	public boolean isApplicableToAdventureLog(Widget root)
	{
		return root.getId() == InterfaceID.PendantOfAtes.TELEPORT_LAYER;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToScriptId(int scriptId)
	{
		return scriptId == PENDANT_OF_ATES_MAIN_TELEPORT_SCRIPT_ID || scriptId == PENDANT_OF_ATES_TEXT_TELEPORT_SCRIPT_ID;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.PENDANT_OF_ATES;
	}
}