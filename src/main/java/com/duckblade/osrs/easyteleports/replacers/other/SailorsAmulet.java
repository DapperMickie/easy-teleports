package com.duckblade.osrs.easyteleports.replacers.other;

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
public class SailorsAmulet implements Replacer
{

	private static final String SAILORS_AMULET_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(8);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableSailorsAmulet();

		replacements.clear();
		replacements.add(new TeleportReplacement("The Pandemonium", config.replacementSailorsPandemonium()));
		replacements.add(new TeleportReplacement("The Pandemonium.", config.replacementSailorsPandemonium()));
		replacements.add(new TeleportReplacement("Port Roberts", config.replacementSailorsPortRoberts()));
		replacements.add(new TeleportReplacement("Port Roberts.", config.replacementSailorsPortRoberts()));
		replacements.add(new TeleportReplacement("Deepfin Point", config.replacementSailorsDeepfinPoint()));
		replacements.add(new TeleportReplacement("Deepfin Point.", config.replacementSailorsDeepfinPoint()));
		replacements.add(new TeleportReplacement("Red Rock", config.replacementSailorsRedRock()));
		replacements.add(new TeleportReplacement("Red Rock.", config.replacementSailorsRedRock()));
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
			SAILORS_AMULET_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		return itemId == ItemID.SAILORS_AMULET;
	}
}
