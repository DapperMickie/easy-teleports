package com.duckblade.osrs.easyteleports.replacers;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
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

		replacements.add(new TeleportReplacement("The Darkfrost", config.replacementDarkfrost()));
		replacements.add(new TeleportReplacement("Twilight Temple", config.replacementTwilightTemple()));
		replacements.add(new TeleportReplacement("Ralos' Rise", config.replacementRalosRise()));
		replacements.add(new TeleportReplacement("North Aldarin", config.replacementNorthAldarin()));
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
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.PENDANT_OF_ATES;
	}
}