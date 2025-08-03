package com.duckblade.osrs.easyteleports;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(EasyTeleportsConfig.CONFIG_GROUP)
public interface EasyTeleportsConfig extends Config {

    String CONFIG_GROUP = "easyteleports";
    int DISPLAY_OPTIONS = 100;
    int POSITION_TEXT_SHADOWED = DISPLAY_OPTIONS + 100;
    int POSITION_FLAGS = POSITION_TEXT_SHADOWED + 100;
    int POSITION_PHARAOHS_SCEPTRE = POSITION_FLAGS + 100;
    int POSITION_KHAREDSTS_MEMOIRS = POSITION_PHARAOHS_SCEPTRE + 100;
    int POSITION_XERICS_TALISMAN = POSITION_KHAREDSTS_MEMOIRS + 100;
    int POSITION_RING_OF_DUELING = POSITION_XERICS_TALISMAN + 100;
    int POSITION_DIARY_CAPE = POSITION_RING_OF_DUELING + 100;
    int POSITION_SLAYER_RING = POSITION_DIARY_CAPE + 100;
    int POSITION_DRAKANS = POSITION_SLAYER_RING + 100;
    int POSITION_RING_OF_SHADOWS = POSITION_DRAKANS + 100;
    int POSITION_NECKLACE_OF_PASSAGE = POSITION_RING_OF_SHADOWS + 100;
    int POSITION_PENDANT_OF_ATES = POSITION_NECKLACE_OF_PASSAGE + 100;
    int POSITION_DIGSITE_PENDANT = POSITION_PENDANT_OF_ATES + 100;
    int POSITION_BURNING_AMULET = POSITION_DIGSITE_PENDANT + 100;
    int POSITION_ENCHANTED_LYRE = POSITION_BURNING_AMULET + 100;
    int POSITION_GHOMMALS_HILT = POSITION_ENCHANTED_LYRE + 100;
    int POSITION_CAMULET = POSITION_GHOMMALS_HILT + 100;
    int POSITION_ETERNAL_TELEPORT_CRYSTAL = POSITION_CAMULET + 100;
    int POSITION_GRAND_SEED_POD = POSITION_ETERNAL_TELEPORT_CRYSTAL + 100;
    int POSITION_RADAS_BLESSING = POSITION_GRAND_SEED_POD + 100;
    int POSITION_KARAMJA_GLOVES = POSITION_RADAS_BLESSING + 100;
    int POSITION_MORYTANIA_LEGS = POSITION_KARAMJA_GLOVES + 100;
    int POSITION_DESERT_AMULET = POSITION_MORYTANIA_LEGS + 100;
    int POSITION_RING_OF_THE_ELEMENTS = POSITION_DESERT_AMULET + 100;
    int POSITION_GIANTSOUL_AMULET = POSITION_RING_OF_THE_ELEMENTS + 100;
    int POSITION_MAX_CAPE = POSITION_GIANTSOUL_AMULET + 100;

    // General plugin options
    @ConfigSection(
            name = "Display options",
            description = "General text and display options.",
            position = DISPLAY_OPTIONS
    )
    String SECTION_DISPLAY_OPTIONS = "displayOptions";

    @ConfigItem(
            section = SECTION_DISPLAY_OPTIONS,
            keyName = "enableShadowedText",
            name = "Text shadow",
            description = "Render a shadow under re-colored text to make them more readable.",
            position = DISPLAY_OPTIONS + (POSITION_TEXT_SHADOWED / 100)
    )
    default boolean enableShadowedText() {
        return true;
    }

    @ConfigSection(
            name = "Toggles",
            description = "Toggle teleport replacements for specific items.",
            position = POSITION_FLAGS
    )
    String SECTION_ENABLE_FLAGS = "enableFlags";

    // Pharaoh's sceptre
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enablePharaohSceptre",
            name = "Pharaoh's sceptre",
            description = "Replace teleport entries on the Pharaoh's sceptre with new names.",
            position = POSITION_FLAGS + (POSITION_PHARAOHS_SCEPTRE / 100)
    )
    default boolean enablePharaohSceptre() {
        return true;
    }

    @ConfigSection(
            name = "Pharaoh's sceptre",
            description = "Replacement text for the Pharaoh's sceptre teleport locations.",
            position = POSITION_PHARAOHS_SCEPTRE,
            closedByDefault = true
    )
    String SECTION_PHARAOHS_SCEPTRE = "sectionCustomReplacements"; // legacy config name

    @ConfigItem(
            keyName = "replacementJalsavrah",
            name = "Jalsavrah",
            description = "Replace Jalsavrah",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 1
    )
    default String replacementJalsavrah() {
        return "Pyramid Plunder";
    }

    @ConfigItem(
            keyName = "replacementJaleustrophos",
            name = "Jaleustrophos",
            description = "Replace Jaleustrophos",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 2
    )
    default String replacementJaleustrophos() {
        return "Agility Pyramid";
    }

    @ConfigItem(
            keyName = "replacementJaldraocht",
            name = "Jaldraocht",
            description = "Replace Jaldraocht",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 3
    )
    default String replacementJaldraocht() {
        return "Ancients Pyramid";
    }

    @ConfigItem(
            keyName = "replacementJaltevas",
            name = "Jaltevas",
            description = "Replace Jaltevas",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 4
    )
    default String replacementJaltevas() {
        return "Necropolis";
    }

    // Kharedst's memoirs/Book of the dead
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableKharedstsMemoirs",
            name = "Kharedst's memoirs/Book of the dead",
            description = "Replace teleport entries on the Kharedst's memoirs/Book of the dead with new names.",
            position = POSITION_FLAGS + (POSITION_KHAREDSTS_MEMOIRS / 100)
    )
    default boolean enableKharedstsMemoirs() {
        return false;
    }

    @ConfigSection(
            name = "Kharedst's memoirs/Book of the dead",
            description = "Replacement text for the Kharedst's memoirs/Book of the dead teleport locations.",
            position = POSITION_KHAREDSTS_MEMOIRS,
            closedByDefault = true
    )
    String SECTION_KHAREDSTS_MEMOIRS = "sectionKharedstsMemoirs";

    @ConfigItem(
            keyName = "replacementLancalliums",
            name = "Lunch by the Lancalliums",
            description = "Replace Lunch by the Lancalliums",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 1
    )
    default String replacementLancalliums() {
        return "<col=2aae4f>Hosidius</col>";
    }

    @ConfigItem(
            keyName = "replacementFishers",
            name = "The Fisher's Flute",
            description = "Replace The Fisher's Flute",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 2
    )
    default String replacementFishers() {
        return "<col=2a94ae>Port Piscarilius</col>";
    }

    @ConfigItem(
            keyName = "replacementHistory",
            name = "History and Hearsay",
            description = "Replace History and Hearsay",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 3
    )
    default String replacementHistory() {
        return "<col=ae2a2a>Shayzien</col>";
    }

    @ConfigItem(
            keyName = "replacementJubilation",
            name = "Jewellery of Jubilation",
            description = "Replace Jewellery of Jubilation",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 4
    )
    default String replacementJubilation() {
        return "<col=ae842a>Lovakengj</col>";
    }

    @ConfigItem(
            keyName = "replacementDisposition",
            name = "A Dark Disposition",
            description = "Replace A Dark Disposition",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 5
    )
    default String replacementDisposition() {
        return "<col=8800ff>Arceuus</col>";
    }

    // Xeric's talisman
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableXericsTalisman",
            name = "Xeric's talisman",
            description = "Replace teleport entries on the Xeric's talisman with new names.",
            position = POSITION_FLAGS + (POSITION_XERICS_TALISMAN / 100)
    )
    default boolean enableXericsTalisman() {
        return false;
    }

    @ConfigSection(
            name = "Xeric's talisman",
            description = "Replacement text for the Xeric's talisman teleport locations.",
            position = POSITION_XERICS_TALISMAN,
            closedByDefault = true
    )
    String SECTION_XERICS_TALISMAN = "sectionXericsTalisman";

    @ConfigItem(
            keyName = "replacementLookout",
            name = "Xeric's Look-out",
            description = "Replace Xeric's Look-out",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 1
    )
    default String replacementLookout() {
        return "Shayzien";
    }

    @ConfigItem(
            keyName = "replacementGlade",
            name = "Xeric's Glade",
            description = "Replace Xeric's Glade",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 2
    )
    default String replacementGlade() {
        return "Hosidius";
    }

    @ConfigItem(
            keyName = "replacementInferno",
            name = "Xeric's Inferno",
            description = "Replace Xeric's Inferno",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 3
    )
    default String replacementInferno() {
        return "Lovakengj";
    }

    @ConfigItem(
            keyName = "replacementHeart",
            name = "Xeric's Heart",
            description = "Replace Xeric's Heart",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 4
    )
    default String replacementHeart() {
        return "Kourend Castle";
    }

    @ConfigItem(
            keyName = "replacementHonour",
            name = "Xeric's Honour",
            description = "Replace Xeric's Honour",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 5
    )
    default String replacementHonour() {
        return "Chambers of Xeric";
    }

    // Ring of dueling
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableRingOfDueling",
            name = "Ring of dueling",
            description = "Replace teleport entries on the Ring of Dueling with new names.",
            position = POSITION_FLAGS + (POSITION_RING_OF_DUELING / 100)
    )
    default boolean enableRingOfDueling() {
        return false;
    }

    @ConfigSection(
            name = "Ring of dueling",
            description = "Replacement text for the ring of dueling teleport locations.",
            position = POSITION_RING_OF_DUELING,
            closedByDefault = true
    )
    String SECTION_RING_OF_DUELING = "sectionRingOfDueling";

    @ConfigItem(
            keyName = "replacementPvPArena",
            name = "Emir's Arena",
            description = "Replace Emir's Arena",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 1
    )
    default String replacementEmirsArena() {
        return "Emir's Arena";
    }

    @ConfigItem(
            keyName = "replacementCastleWars",
            name = "Castle Wars",
            description = "Replace Castle Wars",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 2
    )
    default String replacementCastleWars() {
        return "Castle Wars";
    }

    @ConfigItem(
            keyName = "replacementFeroxEnclave",
            name = "Ferox Enclave",
            description = "Replace Ferox Enclave",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 3
    )
    default String replacementFeroxEnclave() {
        return "Ferox Enclave";
    }

    @ConfigItem(
            keyName = "replacementFortisColosseum",
            name = "Fortis Colosseum",
            description = "Replace Fortis Colosseum",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 4
    )
    default String replacementFortisColosseum() {
        return "Fortis Colosseum";
    }

    // Achievement diary cape
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableDiaryCape",
            name = "Achievement diary cape",
            description = "Replace teleport entries on the Achievement diary cape with new names.",
            position = POSITION_FLAGS + (POSITION_DIARY_CAPE / 100)
    )
    default boolean enableDiaryCape() {
        return false;
    }

    @ConfigSection(
            name = "Achievement diary cape",
            description = "Replacement text for the Achievement diary cape teleport locations.",
            position = POSITION_DIARY_CAPE,
            closedByDefault = true
    )
    String SECTION_DIARY_CAPE = "sectionDiaryCape";

    @ConfigItem(
            keyName = "replacementArdougne",
            name = "Ardougne: Two-pints",
            description = "Replace Ardougne: Two-pints",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 1
    )
    default String replacementArdougne() {
        return "Ardougne: Bar";
    }

    @ConfigItem(
            keyName = "replacementDesert",
            name = "Desert: Jarr",
            description = "Replace Desert: Jarr",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 2
    )
    default String replacementDesert() {
        return "Desert: Shantay Pass";
    }

    @ConfigItem(
            keyName = "replacementFalador",
            name = "Falador: Sir Rebral",
            description = "Replace Falador: Sir Rebral",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 3
    )
    default String replacementFalador() {
        return "Falador: Castle";
    }

    @ConfigItem(
            keyName = "replacementFremennik",
            name = "Fremennik: Thorodin",
            description = "Replace Fremennik: Thorodin",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 4
    )
    default String replacementFremennik() {
        return "Fremennik: POH Portal";
    }

    @ConfigItem(
            keyName = "replacementKandarin",
            name = "Kandarin: Flax keeper",
            description = "Replace Kandarin: Flax keeper",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 5
    )
    default String replacementKandarin() {
        return "Kandarin: Flax";
    }

    @ConfigItem(
            keyName = "replacementKaramjaJackie",
            name = "Karamja: Pirate Jackie the Fruit",
            description = "Replace Karamja: Pirate Jackie the Fruit",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 6
    )
    default String replacementKaramjaJackie() {
        return "Karamja: Agility Arena";
    }

    @ConfigItem(
            keyName = "replacementKaramjaKaleb",
            name = "Karamja: Kaleb Paramaya (retired)",
            description = "Replace Karamja: Kaleb Paramaya (retired)",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 7
    )
    default String replacementKaramjaKaleb() {
        return "Karamja: Shilo Village";
    }

    @ConfigItem(
            keyName = "replacementKaramjaForester",
            name = "Karamja: Jungle forester (retired)",
            description = "Replace Karamja: Jungle forester (retired)",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 8
    )
    default String replacementKaramjaForester() {
        return "Karamja: Kharazi Jungle";
    }

    @ConfigItem(
            keyName = "replacementKaramjaTzhaar",
            name = "Karamja: TzHaar-Mej (retired)",
            description = "Replace Karamja: TzHaar-Mej (retired)",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 9
    )
    default String replacementKaramjaTzhaar() {
        return "Karamja: Mor-Ul-Rek";
    }

    @ConfigItem(
            keyName = "replacementKourend",
            name = "Kourend & Kebos: Elise",
            description = "Replace Kourend & Kebos: Elise",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 10
    )
    default String replacementKourend() {
        return "Kourend: Castle";
    }

    @ConfigItem(
            keyName = "replacementLumbridge",
            name = "Lumbridge & Draynor: Hatius Cosaintus",
            description = "Replace Lumbridge & Draynor: Hatius Cosaintus",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 11
    )
    default String replacementLumbridge() {
        return "Lumbridge: Town Square";
    }

    @ConfigItem(
            keyName = "replacementMorytania",
            name = "Morytania: Le-sabrè",
            description = "Replace Morytania: Le-sabrè",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 12
    )
    default String replacementMorytania() {
        return "Morytania: Canifis";
    }

    @ConfigItem(
            keyName = "replacementVarrock",
            name = "Varrock: Toby",
            description = "Replace Varrock: Toby",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 13
    )
    default String replacementVarrock() {
        return "Varrock: Rooftops";
    }

    @ConfigItem(
            keyName = "replacementWilderness",
            name = "Wilderness: Lesser Fanatic",
            description = "Wilderness: Lesser Fanatic",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 14
    )
    default String replacementWilderness() {
        return "Wilderness: Edgeville";
    }

    @ConfigItem(
            keyName = "replacementWestern",
            name = "Western Provinces: Elder Gnome Child",
            description = "Replace Western Provinces: Elder Gnome Child",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 15
    )
    default String replacementWestern() {
        return "Western: Gnome Stronghold";
    }

    @ConfigItem(
            keyName = "replacementTwiggy",
            name = "Twiggy O'Korn",
            description = "Replace Twiggy O'Korn",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 16
    )
    default String replacementTwiggy() {
        return "Diary Master: Draynor Village";
    }

    // Slayer ring
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableSlayerRing",
            name = "Slayer ring",
            description = "Replace teleport entries on the Slayer ring with new names.",
            position = POSITION_FLAGS + (POSITION_SLAYER_RING / 100)
    )
    default boolean enableSlayerRing() {
        return false;
    }

    @ConfigSection(
            name = "Slayer ring",
            description = "Replacement text for the Slayer ring teleport locations.",
            position = POSITION_SLAYER_RING,
            closedByDefault = true
    )
    String SECTION_SLAYER_RING = "sectionSlayerRing";

    @ConfigItem(
            keyName = "replacementSlayerStronghold",
            name = "Stronghold Slayer Cave",
            description = "Replace Stronghold Slayer Cave",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 1
    )
    default String replacementSlayerStronghold() {
        return "Gnome Stronghold Caves";
    }

    @ConfigItem(
            keyName = "replacementSlayerTower",
            name = "Morytania Slayer Tower",
            description = "Replace Morytania Slayer Tower",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 2
    )
    default String replacementSlayerTower() {
        return "Slayer Tower";
    }

    @ConfigItem(
            keyName = "replacementSlayerRellekka",
            name = "Rellekka Slayer Caves",
            description = "Replace Rellekka Slayer Caves",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 3
    )
    default String replacementSlayerRellekka() {
        return "Rellekka Caves";
    }

    @ConfigItem(
            keyName = "replacementTarns",
            name = "Tarn's Lair",
            description = "Replace Tarn's Lair",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 4
    )
    default String replacementTarns() {
        return "Haunted Mine";
    }

    @ConfigItem(
            keyName = "replacementDarkBeasts",
            name = "Dark Beasts",
            description = "Replace Dark Beasts",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 5
    )
    default String replacementDarkBeasts() {
        return "ME2 Caves";
    }

    // Drakan's medallion
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableDrakans",
            name = "Drakan's medallion",
            description = "Replace teleport entries on Drakan's medallion with new names.",
            position = POSITION_FLAGS + (POSITION_DRAKANS / 100)
    )
    default boolean enableDrakans() {
        return false;
    }

    @ConfigSection(
            name = "Drakan's medallion",
            description = "Replacement text for Drakan's medallion teleport locations.",
            position = POSITION_DRAKANS,
            closedByDefault = true
    )
    String SECTION_DRAKANS = "sectionDrakans";

    @ConfigItem(
            keyName = "replacementVerSinhaza",
            name = "Ver Sinhaza",
            description = "Replace Ver Sinhaza",
            section = SECTION_DRAKANS,
            position = POSITION_DRAKANS + 1
    )
    default String replacementVerSinhaza() {
        return "Theatre of Blood";
    }

    @ConfigItem(
            keyName = "replacementDarkmeyer",
            name = "Darkmeyer",
            description = "Replace Darkmeyer",
            section = SECTION_DRAKANS,
            position = POSITION_DRAKANS + 2
    )
    default String replacementDarkmeyer() {
        return "Vampyre City";
    }

    @ConfigItem(
            keyName = "replacementSlepe",
            name = "Slepe",
            description = "Replace Slepe",
            section = SECTION_DRAKANS,
            position = POSITION_DRAKANS + 3
    )
    default String replacementSlepe() {
        return "Nightmare";
    }

    // Ring of shadows
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableRingOfShadows",
            name = "Ring of shadows",
            description = "Replace teleport entries on the ring of shadows with new names.",
            position = POSITION_FLAGS + (POSITION_RING_OF_SHADOWS / 100)
    )
    default boolean enableRingOfShadows() {
        return false;
    }

    @ConfigSection(
            name = "Ring of shadows (DT2)",
            description = "Replacement text for the Ring of shadows (DT2) teleport locations.",
            position = POSITION_RING_OF_SHADOWS,
            closedByDefault = true
    )
    String SECTION_RING_OF_SHADOWS = "sectionRingOfShadows";

    @ConfigItem(
            keyName = "replacementAncientVault",
            name = "The Ancient Vault",
            description = "Replace The Ancient Vault",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 1
    )
    default String replacementAncientVault() {
        return "<col=aea92a>DT2 Vault</col>";
    }

    @ConfigItem(
            keyName = "replacementGhorrockDungeon",
            name = "Ghorrock Dungeon",
            description = "Replace Ghorrock Dungeon",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 2
    )
    default String replacementGhorrockDungeon() {
        return "<col=2a94ae>Duke Sucellus</col>";
    }

    @ConfigItem(
            keyName = "replacementScar",
            name = "The Scar",
            description = "Replace The Scar",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 3
    )
    default String replacementScar() {
        return "<col=ae2a43>Leviathan</col>";
    }

    @ConfigItem(
            keyName = "replacementLassarUndercity",
            name = "Lassar Undercity",
            description = "Replace Lassar Undercity",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 4
    )
    default String replacementLassarUndercity() {
        return "<col=5f2aae>Whisperer</col>";
    }

    @ConfigItem(
            keyName = "replacementStranglewood",
            name = "The Stranglewood",
            description = "Replace The Stranglewood",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 5
    )
    default String replacementStranglewood() {
        return "<col=ae2a2a>Vardorvis</col>";
    }

    // Necklace of Passage
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableNecklaceOfPassage",
            name = "Necklace of passage",
            description = "Replace teleport entries on the Necklace of passage with new names.",
            position = POSITION_FLAGS + (POSITION_NECKLACE_OF_PASSAGE / 100)
    )
    default boolean enableNecklaceOfPassage() {
        return false;
    }

    @ConfigSection(
            name = "Necklace Of Passage",
            description = "Replacement text for the Necklace of Passage teleport locations.",
            position = POSITION_NECKLACE_OF_PASSAGE,
            closedByDefault = true
    )
    String SECTION_NECKLACE_OF_PASSAGE = "sectionNecklaceOfPassage";

    @ConfigItem(
            keyName = "replacementWizardTower",
            name = "Wizard's Tower",
            description = "Replace Wizard's Tower",
            section = SECTION_NECKLACE_OF_PASSAGE,
            position = POSITION_NECKLACE_OF_PASSAGE + 1
    )
    default String replacementWizardsTower() {
        return "Wizard's Tower";
    }

    @ConfigItem(
            keyName = "replacementOutpost",
            name = "The Outpost",
            description = "Replace The Outpost",
            section = SECTION_NECKLACE_OF_PASSAGE,
            position = POSITION_NECKLACE_OF_PASSAGE + 2
    )
    default String replacementOutpost() {
        return "NW of West Ardougne";
    }

    @ConfigItem(
            keyName = "replacementEagleEyrie",
            name = "Eagle's Eyrie",
            description = "Replace Eagle's Eyrie",
            section = SECTION_NECKLACE_OF_PASSAGE,
            position = POSITION_NECKLACE_OF_PASSAGE + 3
    )
    default String replacementEagleEyrie() {
        return "NW of Uzer (Desert)";
    }

    // Pendant of ates
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enablePendantOfAtes",
            name = "Pendant of ates",
            description = "Replace teleport entries on the Pendant of ates with new names.",
            position = POSITION_FLAGS + (POSITION_PENDANT_OF_ATES / 100)
    )
    default boolean enablePendantOfAtes() {
        return true;
    }

    @ConfigSection(
            name = "Pendant of ates",
            description = "Replacement text for Pendant of ates teleport locations.",
            position = POSITION_PENDANT_OF_ATES,
            closedByDefault = true
    )
    String SECTION_PENDANT_OF_ATES = "sectionPendantOfAtes";

    @ConfigItem(
            keyName = "replacementDarkfrost",
            name = "The Darkfrost",
            description = "Replace The Darkfrost (west of base camp)",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 1
    )
    default String replacementDarkfrost() {
        return "<col=2a94ae>Hueycoatl</col>";
    }

    @ConfigItem(
            keyName = "replacementTwilightTemple",
            name = "Twilight Temple",
            description = "Replace Twilight Temple (east of Tower of Ascension)",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 2
    )
    default String replacementTwilightTemple() {
        return "<col=ae2a2a>Amoxliatl</col>";
    }

    @ConfigItem(
            keyName = "replacementRalosRise",
            name = "Ralos' Rise",
            description = "Replace Ralos' Rise (east of exposed altar)",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 3
    )
    default String replacementRalosRise() {
        return "<col=ae8b2a>Moons of Peril</col>";
    }

    @ConfigItem(
            keyName = "replacementNorthAldarin",
            name = "North Aldarin",
            description = "Replace North Aldarin (north of market)",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 4
    )
    default String replacementNorthAldarin() {
        return "<col=8800ff>Mastering Mixology</col>";
    }

    @ConfigItem(
            keyName = "replacementKastori",
            name = "Kastori",
            description = "Replace Kastori (east of Tlati Rainforest)",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 5
    )
    default String replacementKastori() {
        return "<col=65684f>Gemstone Crab</col>";
    }

    @ConfigItem(
            keyName = "replacementNemusRetreat",
            name = "Nemus Retreat",
            description = "Replace Nemus Retreat (south of Auburnvale)",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 6
    )
    default String replacementNemusRetreat() {
        return "<col=80b37c>Vale Totems</col>";
    }

    // Digsite Pendant
    @ConfigItem(
            keyName = "enableDigsitePendant",
            name = "Digsite Pendant",
            description = "Replace teleport entries on the Digsite Pendant with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_DIGSITE_PENDANT / 100)
    )
    default boolean enableDigsitePendant() {
        return true;
    }

    @ConfigSection(
            name = "Digsite Pendant",
            description = "Replacement text for Digsite Pendant teleport locations.",
            position = POSITION_DIGSITE_PENDANT,
            closedByDefault = true
    )
    String SECTION_DIGSITE_PENDANT = "sectionDigsitePendant";

    @ConfigItem(
            keyName = "replacementDigsite",
            name = "Digsite",
            description = "Replace Digsite teleport location.",
            section = SECTION_DIGSITE_PENDANT,
            position = POSITION_DIGSITE_PENDANT + 1
    )
    default String replacementDigsite() {
        return "Digsite";
    }

    @ConfigItem(
            keyName = "replacementFossilIsland",
            name = "Fossil Island",
            description = "Replace Fossil Island teleport location.",
            section = SECTION_DIGSITE_PENDANT,
            position = POSITION_DIGSITE_PENDANT + 2
    )
    default String replacementFossilIsland() {
        return "Fossil Island";
    }

    @ConfigItem(
            keyName = "replacementLithkren",
            name = "Lithkren",
            description = "Replace Lithkren teleport location.",
            section = SECTION_DIGSITE_PENDANT,
            position = POSITION_DIGSITE_PENDANT + 3
    )
    default String replacementLithkren() {
        return "Lithkren";
    }

    // Burning amulet
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableBurningAmulet",
            name = "Burning amulet",
            description = "Replace teleport entries on the Burning amulet with new names.",
            position = POSITION_FLAGS + (POSITION_BURNING_AMULET / 100)
    )
    default boolean enableBurningAmulet() {
        return false;
    }

    @ConfigSection(
            name = "Burning amulet",
            description = "Replacement text for Burning amulet teleport locations.",
            position = POSITION_BURNING_AMULET,
            closedByDefault = true
    )
    String SECTION_BURNING_AMULET = "sectionBurningAmulet";

    @ConfigItem(
            keyName = "replacementBurningChaosTemple",
            name = "Chaos Temple",
            description = "Replace Chaos Temple teleport location.",
            section = SECTION_BURNING_AMULET,
            position = POSITION_BURNING_AMULET + 1
    )
    default String replacementBurningChaosTemple() {
        return "Chaos Temple";
    }

    @ConfigItem(
            keyName = "replacementBurningBanditCamp",
            name = "Bandit Camp",
            description = "Replace Bandit Camp teleport location.",
            section = SECTION_BURNING_AMULET,
            position = POSITION_BURNING_AMULET + 2
    )
    default String replacementBurningBanditCamp() {
        return "Bandit Camp";
    }

    @ConfigItem(
            keyName = "replacementBurningLavaMaze",
            name = "Lava Maze",
            description = "Replace Lava Maze teleport location.",
            section = SECTION_BURNING_AMULET,
            position = POSITION_BURNING_AMULET + 3
    )
    default String replacementBurningLavaMaze() {
        return "Lava Maze";
    }

    // Enchanted lyre
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableEnchantedLyre",
            name = "Enchanted lyre",
            description = "Replace teleport entries on the Enchanted lyre with new names.",
            position = POSITION_FLAGS + (POSITION_ENCHANTED_LYRE / 100)
    )
    default boolean enableEnchantedLyre() {
        return false;
    }

    @ConfigSection(
            name = "Enchanted lyre",
            description = "Replacement text for Enchanted lyre teleport locations.",
            position = POSITION_ENCHANTED_LYRE,
            closedByDefault = true
    )
    String SECTION_ENCHANTED_LYRE = "sectionEnchantedLyre";

    @ConfigItem(
            keyName = "replacementLyreRellekka",
            name = "Rellekka",
            description = "Replace Rellekka teleport location.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 1
    )
    default String replacementLyreRellekka() {
        return "Rellekka";
    }

    @ConfigItem(
            keyName = "replacementLyreWaterbirthIsland",
            name = "Waterbirth Island",
            description = "Replace Waterbirth Island teleport location.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 2
    )
    default String replacementLyreWaterbirthIsland() {
        return "Waterbirth Island";
    }

    @ConfigItem(
            keyName = "replacementLyreNeitiznot",
            name = "Neitiznot",
            description = "Replace Neitiznot teleport location.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 3
    )
    default String replacementLyreNeitiznot() {
        return "Neitiznot";
    }

    @ConfigItem(
            keyName = "replacementLyreJatizso",
            name = "Jatizso",
            description = "Replace Jatizso teleport location.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 4
    )
    default String replacementLyreJatizso() {
        return "Jatizso";
    }

    // Ghommal's hilt
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableGhommalsHilt",
            name = "Ghommal's hilt",
            description = "Replace teleport entries on the Ghommal's hilt with new names.",
            position = POSITION_FLAGS + (POSITION_GHOMMALS_HILT / 100)
    )
    default boolean enableGhommalsHilt() {
        return false;
    }

    @ConfigSection(
            name = "Ghommal's hilt",
            description = "Replacement text for Ghommal's hilt teleport locations.",
            position = POSITION_GHOMMALS_HILT,
            closedByDefault = true
    )
    String SECTION_GHOMMALS_HILT = "sectionGhommalsHilt";

    @ConfigItem(
            keyName = "replacementGhommalTrollheim",
            name = "Trollheim",
            description = "Replace Trollheim teleport location.",
            section = SECTION_GHOMMALS_HILT,
            position = POSITION_GHOMMALS_HILT + 1
    )
    default String replacementGhommalTrollheim() {
        return "<col=2a94ae>God Wars</col>";
    }

    @ConfigItem(
            keyName = "replacementGhommalMorUlRek",
            name = "Mor Ul Rek",
            description = "Replace Mor Ul Rek teleport location.",
            section = SECTION_GHOMMALS_HILT,
            position = POSITION_GHOMMALS_HILT + 2
    )
    default String replacementGhommalMorUlRek() {
        return "<col=ae2a2a>The Inferno</col>";
    }

    // Camulet
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableCamulet",
            name = "Camulet",
            description = "Replace teleport entries on the Camulet with new names.",
            position = POSITION_FLAGS + (POSITION_CAMULET / 100)
    )
    default boolean enableCamulet() {
        return false;
    }

    @ConfigSection(
            name = "Camulet",
            description = "Replacement text for Camulet teleport locations.",
            position = POSITION_CAMULET,
            closedByDefault = true
    )
    String SECTION_CAMULET = "sectionCamulet";

    @ConfigItem(
            keyName = "replacementCamuletEnakhrasTemple",
            name = "Enakhra's Temple",
            description = "Replace Enakhra's Temple teleport location.",
            section = SECTION_CAMULET,
            position = POSITION_CAMULET + 1
    )
    default String replacementCamuletEnakhrasTemple() {
        return "Inside Enakhra's Temple";
    }

    @ConfigItem(
            keyName = "replacementCamuletEnakhrasTempleEntrance",
            name = " Enakhra's Temple Entrance",
            description = "Replace Enakhra's Temple Entrance teleport location.",
            section = SECTION_CAMULET,
            position = POSITION_CAMULET + 2
    )
    default String replacementCamuletEnakhrasTempleEntrance() {
        return "Bandit Camp Quarry";
    }

    // Eternal teleport crystal
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableEternalTeleportCrystal",
            name = "Eternal teleport crystal",
            description = "Replace teleport entries on the Eternal teleport crystal with new names.",
            position = POSITION_FLAGS + (POSITION_ETERNAL_TELEPORT_CRYSTAL / 100)
    )
    default boolean enableEternalTeleportCrystal() {
        return false;
    }

    @ConfigSection(
            name = "Eternal teleport crystal",
            description = "Replacement text for Eternal teleport crystal teleport locations.",
            position = POSITION_ETERNAL_TELEPORT_CRYSTAL,
            closedByDefault = true
    )
    String SECTION_ETERNAL_TELEPORT_CRYSTAL = "sectionEternalTeleportCrystal";

    @ConfigItem(
            keyName = "replacementEternalPrifddinas",
            name = "Prifddinas",
            description = "Replace Prifddinas teleport location.",
            section = SECTION_ETERNAL_TELEPORT_CRYSTAL,
            position = POSITION_ETERNAL_TELEPORT_CRYSTAL + 1
    )
    default String replacementEternalPrifddinas() {
        return "Prifddinas";
    }

    @ConfigItem(
            keyName = "replacementEternalLletya",
            name = " Lletya",
            description = "Replace Lletya teleport location.",
            section = SECTION_ETERNAL_TELEPORT_CRYSTAL,
            position = POSITION_ETERNAL_TELEPORT_CRYSTAL + 2
    )
    default String replacementEternalLletya() {
        return "Lletya";
    }

    // Grand seed pod
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableGrandSeedPod",
            name = "Grand seed pod",
            description = "Replace teleport entries on the Grand seed pod with new names.",
            position = POSITION_FLAGS + (POSITION_GRAND_SEED_POD / 100)
    )
    default boolean enableGrandSeedPod() {
        return false;
    }

    @ConfigSection(
            name = "Grand seed pod",
            description = "Replacement text for Grand seed pod teleport locations.",
            position = POSITION_GRAND_SEED_POD,
            closedByDefault = true
    )
    String SECTION_GRAND_SEED_POD = "sectionGrandSeedPod";

    @ConfigItem(
            keyName = "replacementPodLaunch",
            name = "Launch",
            description = "Replace Launch teleport location.",
            section = SECTION_GRAND_SEED_POD,
            position = POSITION_GRAND_SEED_POD + 1
    )
    default String replacementPodLaunch() {
        return "Gnome Glider";
    }

    @ConfigItem(
            keyName = "replacementPodSquash",
            name = "Squash",
            description = "Replace Squash teleport location.",
            section = SECTION_GRAND_SEED_POD,
            position = POSITION_GRAND_SEED_POD + 2
    )
    default String replacementPodSquash() {
        return "Grand Tree (King Narnode)";
    }

    // Rada's blessing
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableRadasBlessing",
            name = "Rada's blessing",
            description = "Replace teleport entries on the Rada's blessing with new names.",
            position = POSITION_FLAGS + (POSITION_RADAS_BLESSING / 100)
    )
    default boolean enableRadasBlessing() {
        return false;
    }

    @ConfigSection(
            name = "Rada's blessing",
            description = "Replacement text for Rada's blessing teleport locations.",
            position = POSITION_RADAS_BLESSING,
            closedByDefault = true
    )
    String SECTION_RADAS_BLESSING = "sectionRadasBlessing";

    @ConfigItem(
            keyName = "replacementRadasKourendWoodland",
            name = "Kourend Woodland",
            description = "Replace Kourend Woodland teleport location.",
            section = SECTION_RADAS_BLESSING,
            position = POSITION_RADAS_BLESSING + 1
    )
    default String replacementRadasKourendWoodland() {
        return "Kourend Woodland";
    }

    @ConfigItem(
            keyName = "replacementRadasMountKaruulm",
            name = "Mount Karuulm",
            description = "Replace Mount Karuulm teleport location.",
            section = SECTION_RADAS_BLESSING,
            position = POSITION_RADAS_BLESSING + 2
    )
    default String replacementRadasMountKaruulm() {
        return "Konar";
    }

    // Karamja gloves
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableKaramjaGloves",
            name = "Karamja gloves",
            description = "Replace teleport entries on the Karamja gloves with new names.",
            position = POSITION_FLAGS + (POSITION_KARAMJA_GLOVES / 100)
    )
    default boolean enableKaramjaGloves() {
        return false;
    }

    @ConfigSection(
            name = "Karamja gloves",
            description = "Replacement text for Karamja gloves teleport locations.",
            position = POSITION_KARAMJA_GLOVES,
            closedByDefault = true
    )
    String SECTION_KARAMJA_GLOVES = "sectionKaramjaGloves";

    @ConfigItem(
            keyName = "replacementKaramjaGemMine",
            name = "Gem Mine",
            description = "Replace Gem Mine teleport location.",
            section = SECTION_KARAMJA_GLOVES,
            position = POSITION_KARAMJA_GLOVES + 1
    )
    default String replacementKaramjaGemMine() {
        return "Gem Mine";
    }

    @ConfigItem(
            keyName = "replacementKaramjaSlayerMaster",
            name = "Slayer Master",
            description = "Replace Slayer Master teleport location.",
            section = SECTION_KARAMJA_GLOVES,
            position = POSITION_KARAMJA_GLOVES + 2
    )
    default String replacementKaramjaSlayerMaster() {
        return "Duradel";
    }

    // Morytania legs
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableMorytaniaLegs",
            name = "Morytania legs",
            description = "Replace teleport entries on the Morytania legs with new names.",
            position = POSITION_FLAGS + (POSITION_MORYTANIA_LEGS / 100)
    )
    default boolean enableMorytaniaLegs() {
        return false;
    }

    @ConfigSection(
            name = "Morytania legs",
            description = "Replacement text for Morytania legs teleport locations.",
            position = POSITION_MORYTANIA_LEGS,
            closedByDefault = true
    )
    String SECTION_MORYTANIA_LEGS = "sectionMorytaniaLegs";

    @ConfigItem(
            keyName = "replacementMorytaniaEctofuntus",
            name = "Ecto Teleport",
            description = "Replace Ecto Teleport teleport location.",
            section = SECTION_MORYTANIA_LEGS,
            position = POSITION_MORYTANIA_LEGS + 1
    )
    default String replacementMorytaniaEctofuntus() {
        return "Ectofuntus";
    }

    @ConfigItem(
            keyName = "replacementMorytaniaBurgh",
            name = "Burgh Teleport",
            description = "Replace Burgh Teleport teleport location.",
            section = SECTION_MORYTANIA_LEGS,
            position = POSITION_MORYTANIA_LEGS + 2
    )
    default String replacementMorytaniaBurgh() {
        return "Burgh de Rott";
    }

    // Desert amulet
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableDesertAmulet",
            name = "Desert amulet",
            description = "Replace teleport entries on the Desert amulet with new names.",
            position = POSITION_FLAGS + (POSITION_DESERT_AMULET / 100)
    )
    default boolean enableDesertAmulet() {
        return false;
    }

    @ConfigSection(
            name = "Desert amulet",
            description = "Replacement text for Desert amulet teleport locations.",
            position = POSITION_DESERT_AMULET,
            closedByDefault = true
    )
    String SECTION_DESERT_AMULET = "sectionDesertAmulet";

    @ConfigItem(
            keyName = "replacementDesertNardah",
            name = "Nardah",
            description = "Replace Nardah teleport location.",
            section = SECTION_DESERT_AMULET,
            position = POSITION_DESERT_AMULET + 1
    )
    default String replacementDesertNardah() {
        return "Nardah";
    }

    @ConfigItem(
            keyName = "replacementDesertKalphiteCave",
            name = "Kalphite cave",
            description = "Replace Kalphite cave teleport location.",
            section = SECTION_DESERT_AMULET,
            position = POSITION_DESERT_AMULET + 2
    )
    default String replacementDesertKalphiteCave() {
        return "Kalphite Cave";
    }

    // Ring of the elements
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableRingOfTheElements",
            name = "Ring of the elements",
            description = "Replace teleport entries on the Ring of the elements with new names.",
            position = POSITION_FLAGS + (POSITION_RING_OF_THE_ELEMENTS / 100)
    )
    default boolean enableRingOfTheElements() {
        return false;
    }

    @ConfigSection(
            name = "Ring of the elements",
            description = "Replacement text for Ring of the elements teleport locations.",
            position = POSITION_RING_OF_THE_ELEMENTS,
            closedByDefault = true
    )
    String SECTION_RING_OF_THE_ELEMENTS = "sectionRingOfTheElements";

    @ConfigItem(
            keyName = "replacementAirAltar",
            name = "Air Altar",
            description = "Replace Air Altar teleport location.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 1
    )
    default String replacementAirAltar() {
        return "<col=ffffff>Air Altar</col>";
    }

    @ConfigItem(
            keyName = "replacementWaterAltar",
            name = "Water Altar",
            description = "Replace Water Altar teleport location.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 2
    )
    default String replacementWaterAltar() {
        return "<col=2a94ae>Water Altar</col>";
    }

    @ConfigItem(
            keyName = "replacementEarthAltar",
            name = "Earth Altar",
            description = "Replace Earth Altar teleport location.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 3
    )
    default String replacementEarthAltar() {
        return "<col=2aae4f>Earth Altar</col>";
    }

    @ConfigItem(
            keyName = "replacementFireAltar",
            name = "Fire Altar",
            description = "Replace Fire Altar teleport location.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 4
    )
    default String replacementFireAltar() {
        return "<col=ae2a2a>Fire Altar</col>";
    }

    // Giantsoul amulet
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableGiantsoulAmulet",
            name = "Giantsoul amulet",
            description = "Replace teleport entries on the Giantsoul amulet with new names.",
            position = POSITION_FLAGS + (POSITION_GIANTSOUL_AMULET / 100)
    )
    default boolean enableGiantsoulAmulet() {
        return false;
    }

    @ConfigSection(
            name = "Giantsoul amulet",
            description = "Replacement text for Giantsoul amulet teleport locations.",
            position = POSITION_GIANTSOUL_AMULET,
            closedByDefault = true
    )
    String SECTION_GIANTSOUL_AMULET = "sectionGiantsoulAmulet";

    @ConfigItem(
            keyName = "replacementBryophyta",
            name = "Bryophyta",
            description = "Replace Bryophyta teleport location.",
            section = SECTION_GIANTSOUL_AMULET,
            position = POSITION_GIANTSOUL_AMULET + 1
    )
    default String replacementBryophyta() {
        return "<col=2aae4f>Bryo</col>";
    }

    @ConfigItem(
            keyName = "replacementObor",
            name = "Obor",
            description = "Replace Obor teleport location.",
            section = SECTION_GIANTSOUL_AMULET,
            position = POSITION_GIANTSOUL_AMULET + 2
    )
    default String replacementObor() {
        return "<col=ffca00>Obor</col>";
    }

    @ConfigItem(
            keyName = "replacementBrandaAndEldric",
            name = "Branda and Eldric",
            description = "Replace Branda and Eldric teleport location.",
            section = SECTION_GIANTSOUL_AMULET,
            position = POSITION_GIANTSOUL_AMULET + 3
    )
    default String replacementBrandaAndEldric() {
        return "<col=ae2a2a>Royal</col> <col=2a94ae>Titans</col>";
    }

    // Max cape
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableMaxCape",
            name = "Max cape",
            description = "Replace teleport entries on the Max cape with new names.",
            position = POSITION_FLAGS + (POSITION_MAX_CAPE / 100)
    )
    default boolean enableMaxCape() {
        return false;
    }

    @ConfigSection(
            name = "Max cape",
            description = "Replacement text for Max cape teleport locations.",
            position = POSITION_MAX_CAPE,
            closedByDefault = true
    )
    String SECTION_MAX_CAPE = "sectionMaxCape";

    @ConfigItem(
            keyName = "replacementMaxCapeWarriorsGuild",
            name = "Warrior's Guild name",
            description = "Replace Warrior's Guild teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 1
    )
    default String replacementMaxCapeWarriorsGuild() {
        return "Warrior's Guild";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeFishingGuild",
            name = "Fishing Guild",
            description = "Replace Fishing Guild teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 2
    )
    default String replacementMaxCapeFishingGuild() {
        return "Fishing Guild";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeCraftingGuild",
            name = "Crafting Guild",
            description = "Replace Crafting Guild teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 3
    )
    default String replacementMaxCapeCraftingGuild() {
        return "<col=ffca00>Crafting Guild</col>";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeFarmingGuild",
            name = "Farming Guild",
            description = "Replace Farming Guild teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 4
    )
    default String replacementMaxCapeFarmingGuild() {
        return "Farming Guild";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeOttosGrotto",
            name = "Otto's Grotto",
            description = "Replace Otto's Grotto teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 5
    )
    default String replacementMaxCapeOttosGrotto() {
        return "Barbarian fishing";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeFeldipHills",
            name = "Feldip Hills",
            description = "Replace Feldip Hills teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 6
    )
    default String replacementMaxCapeFeldipHills() {
        return "Red chinchompas";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeBlackChincompas",
            name = "Black chinchompas",
            description = "Replace Black chinchompas teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 7
    )
    default String replacementMaxCapeBlackChincompas() {
        return "<col=ff0000>Black chinchompas</col>";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeHunterGuild",
            name = "Hunter Guild",
            description = "Replace Hunter Guild teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 8
    )
    default String replacementMaxCapeHunterGuild() {
        return "Hunter Guild";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeHome",
            name = "Home",
            description = "Replace Home teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 9
    )
    default String replacementMaxCapeHome() {
        return "<col=8800ff>Home</col>";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeRimmington",
            name = "Rimmington",
            description = "Replace Rimmington teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 10
    )
    default String replacementMaxCapeRimmington() {
        return "Rimmington";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeTaverley",
            name = "Taverley",
            description = "Replace Taverley teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 11
    )
    default String replacementMaxCapeTaverley() {
        return "Taverley";
    }

    @ConfigItem(
            keyName = "replacementMaxCapePollnivneach",
            name = "Pollnivneach",
            description = "Replace Pollnivneach teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 12
    )
    default String replacementMaxCapePollnivneach() {
        return "Pollnivneach";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeHosidius",
            name = "Hosidius",
            description = "Replace Hosidius teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 13
    )
    default String replacementMaxCapeHosidius() {
        return "Hosidius";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeAldarin",
            name = "Aldarin",
            description = "Replace Aldarin teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 14
    )
    default String replacementMaxCapeAldarin() {
        return "Aldarin";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeRellekka",
            name = "Rellekka",
            description = "Replace Rellekka teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 15
    )
    default String replacementMaxCapeRellekka() {
        return "Rellekka";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeBrimhaven",
            name = "Brimhaven",
            description = "Replace Brimhaven teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 16
    )
    default String replacementMaxCapeBrimhaven() {
        return "Brimhaven";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeYanille",
            name = "Yanille",
            description = "Replace Yanille teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 17
    )
    default String replacementMaxCapeYanille() {
        return "Yanille";
    }

    @ConfigItem(
            keyName = "replacementMaxCapePrifddinas",
            name = "Prifddinas",
            description = "Replace Prifddinas teleport location.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 18
    )
    default String replacementMaxCapePrifddinas() {
        return "Prifddinas";
    }
}