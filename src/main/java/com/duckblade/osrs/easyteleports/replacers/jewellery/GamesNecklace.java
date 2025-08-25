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
public class GamesNecklace implements Replacer
{

	private static final String GAMES_NECKLACE_DIALOGUE_HEADER = "Where would you like to teleport to?";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableGamesNecklace();

		replacements.clear();
		replacements.add(new TeleportReplacement("Burthorpe.", config.replacementGamesBurthorpe()));
		replacements.add(new TeleportReplacement("Burthorpe", config.replacementGamesBurthorpe()));
		replacements.add(new TeleportReplacement("Barbarian Outpost.", config.replacementGamesBarbarianOutpost()));
		replacements.add(new TeleportReplacement("Barbarian Outpost", config.replacementGamesBarbarianOutpost()));
		replacements.add(new TeleportReplacement("Corporeal Beast.", config.replacementGamesCorporealBeast()));
		replacements.add(new TeleportReplacement("Corporeal Beast", config.replacementGamesCorporealBeast()));
		replacements.add(new TeleportReplacement("Tears of Guthix.", config.replacementGamesTearsOfGuthix()));
		replacements.add(new TeleportReplacement("Tears of Guthix", config.replacementGamesTearsOfGuthix()));
		replacements.add(new TeleportReplacement("Wintertodt Camp.", config.replacementGamesWintertodtCamp()));
		replacements.add(new TeleportReplacement("Wintertodt Camp", config.replacementGamesWintertodtCamp()));
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
			GAMES_NECKLACE_DIALOGUE_HEADER.equals(children[0].getText());
	}

	@Override
	public boolean isApplicableToJewelleryBox()
	{
		return true;
	}

	@Override
	public EquipmentInventorySlot getEquipmentSlot()
	{
		return EquipmentInventorySlot.AMULET;
	}

	@Override
	public boolean isApplicableToInventory(int itemId)
	{
		Collection<ItemMapping> itemMappings = ItemMapping.map(itemId);
		return itemId == ItemID.NECKLACE_OF_MINIGAMES_8 || (itemMappings != null && itemMappings.contains(ItemMapping.ITEM_GAMES_NECKLACE));
	}
}