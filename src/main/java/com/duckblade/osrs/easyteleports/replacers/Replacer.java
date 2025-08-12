package com.duckblade.osrs.easyteleports.replacers;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;

import java.util.List;

import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.widgets.Widget;

public interface Replacer
{

	void onConfigChanged(EasyTeleportsConfig config);

	boolean isEnabled();

	List<TeleportReplacement> getReplacements();

	default boolean isApplicableToDialog(Widget root)
	{
		return false;
	}

	default boolean isApplicableToAdventureLog(Widget root)
	{
		return false;
	}

	default boolean isApplicableToJewelleryBox()
	{
		return false;
	}

	default boolean isApplicableToInventory(int itemId)
	{
		return false;
	}

	default boolean isApplicableToScriptId(int scriptId)
	{
		return false;
	}

	default EquipmentInventorySlot getEquipmentSlot()
	{
		return null;
	}

}