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

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PortalNexus implements Replacer
{

	private final List<TeleportReplacement> replacements = new ArrayList<>(24);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enablePortalNexus();
		replacements.clear();

		// Standard spellbook
		replacements.add(new TeleportReplacement("Varrock", config.replacementPortalNexusVarrock()));
		replacements.add(new TeleportReplacement("Lumbridge", config.replacementPortalNexusLumbridge()));
		replacements.add(new TeleportReplacement("Falador", config.replacementPortalNexusFalador()));
		replacements.add(new TeleportReplacement("Camelot", config.replacementPortalNexusCamelot()));
		replacements.add(new TeleportReplacement("Ardougne", config.replacementPortalNexusArdougne()));
		replacements.add(new TeleportReplacement("Civitas illa Fortis", config.replacementPortalNexusCivitasIllaFortis()));
		replacements.add(new TeleportReplacement("Watchtower/Yanille", config.replacementPortalNexusWatchtower()));
		replacements.add(new TeleportReplacement("West Ardougne", config.replacementPortalNexusWestArdougne()));
		replacements.add(new TeleportReplacement("Marim (Ape Atoll)", config.replacementPortalNexusMarim()));

		// Ancient Magicks
		replacements.add(new TeleportReplacement("Senntisten (Digsite)", config.replacementPortalNexusSenntisten()));
		replacements.add(new TeleportReplacement("Kharyrll (Canifis)", config.replacementPortalNexusKharyrll()));
		replacements.add(new TeleportReplacement("Carrallanger (Graveyard of Shadows)", config.replacementPortalNexusCarrallanger()));
		replacements.add(new TeleportReplacement("Annakarl (Demonic Ruins)", config.replacementPortalNexusAnnakarl()));
		replacements.add(new TeleportReplacement("Ghorrock (Frozen Waste Plateau)", config.replacementPortalNexusGhorrock()));

		// Lunar spellbook
		replacements.add(new TeleportReplacement("Lunar Isle", config.replacementPortalNexusLunarIsle()));
		replacements.add(new TeleportReplacement("Waterbirth Island", config.replacementPortalNexusWaterbirth()));
		replacements.add(new TeleportReplacement("Fishing Guild", config.replacementPortalNexusFishingGuild()));
		replacements.add(new TeleportReplacement("Catherby", config.replacementPortalNexusCatherby()));
		replacements.add(new TeleportReplacement("Ape Atoll Dungeon", config.replacementPortalNexusApeAtollDungeon()));

		// Arceuus spellbook
		replacements.add(new TeleportReplacement("Harmony Island", config.replacementPortalNexusHarmonyIsland()));
		replacements.add(new TeleportReplacement("The Forgotten Cemetery", config.replacementPortalNexusForgottenCemetery()));
		replacements.add(new TeleportReplacement("Barrows", config.replacementPortalNexusBarrows()));
		replacements.add(new TeleportReplacement("Troll Stronghold", config.replacementPortalNexusTrollStronghold()));
		replacements.add(new TeleportReplacement("Weiss", config.replacementPortalNexusWeiss()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToPortalNexus()
	{
		return true;
	}

}
