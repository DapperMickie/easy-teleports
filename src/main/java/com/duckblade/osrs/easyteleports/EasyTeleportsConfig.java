package com.duckblade.osrs.easyteleports;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.Color;

@ConfigGroup(EasyTeleportsConfig.CONFIG_GROUP)
public interface EasyTeleportsConfig extends Config {

    public static final String CONFIG_GROUP = "easypharaohsceptre";

    public static final int STEP = 100;
    public static final int BASE = 0;

    public static final int POSITION_DISPLAY_OPTIONS = BASE + 1 * STEP;
    public static final int POSITION_FLAGS = BASE + 2 * STEP;
    public static final int POSITION_RING_OF_DUELING = BASE + 3 * STEP;
    public static final int POSITION_SLAYER_RING = BASE + 4 * STEP;
    public static final int POSITION_NECKLACE_OF_PASSAGE = BASE + 5 * STEP;
    public static final int POSITION_DIGSITE_PENDANT = BASE + 6 * STEP;
    public static final int POSITION_GAMES_NECKLACE = BASE + 7 * STEP;
    public static final int POSITION_BURNING_AMULET = BASE + 8 * STEP;
    public static final int POSITION_SKILLS_NECKLACE = BASE + 9 * STEP;
    public static final int POSITION_COMBAT_BRACELET = BASE + 10 * STEP;
    public static final int POSITION_RING_OF_WEALTH = BASE + 11 * STEP;
    public static final int POSITION_AMULET_OF_GLORY = BASE + 12 * STEP;
    public static final int POSITION_CONSTRUCTION_CAPE = BASE + 13 * STEP;
    public static final int POSITION_FISHING_CAPE = BASE + 14 * STEP;
    public static final int POSITION_HUNTER_CAPE = BASE + 15 * STEP;
    public static final int POSITION_MAX_CAPE = BASE + 16 * STEP;
    public static final int POSITION_RADAS_BLESSING = BASE + 17 * STEP;
    public static final int POSITION_KARAMJA_GLOVES = BASE + 18 * STEP;
    public static final int POSITION_MORYTANIA_LEGS = BASE + 19 * STEP;
    public static final int POSITION_DESERT_AMULET = BASE + 20 * STEP;
    public static final int POSITION_ARDOUGNE_CLOAK = BASE + 21 * STEP;
    public static final int POSITION_DIARY_CAPE = BASE + 22 * STEP;
    public static final int POSITION_KHAREDSTS_MEMOIRS = BASE + 23 * STEP;
    public static final int POSITION_DRAKANS = BASE + 24 * STEP;
    public static final int POSITION_RING_OF_SHADOWS = BASE + 25 * STEP;
    public static final int POSITION_ENCHANTED_LYRE = BASE + 26 * STEP;
    public static final int POSITION_CAMULET = BASE + 27 * STEP;
    public static final int POSITION_ETERNAL_TELEPORT_CRYSTAL = BASE + 28 * STEP;
    public static final int POSITION_PHARAOHS_SCEPTRE = BASE + 29 * STEP;
    public static final int POSITION_XERICS_TALISMAN = BASE + 30 * STEP;
    public static final int POSITION_PENDANT_OF_ATES = BASE + 31 * STEP;
    public static final int POSITION_GHOMMALS_HILT = BASE + 32 * STEP;
    public static final int POSITION_GRAND_SEED_POD = BASE + 33 * STEP;
    public static final int POSITION_RING_OF_THE_ELEMENTS = BASE + 34 * STEP;
    public static final int POSITION_GIANTSOUL_AMULET = BASE + 35 * STEP;
    public static final int POSITION_ANCIENT_SHARD = BASE + 36 * STEP;
    public static final int POSITION_DISK_OF_RETURNING = BASE + 37 * STEP;

    // General plugin options
    @ConfigSection(
            name = "Display options",
            description = "General text and display options.",
            position = POSITION_DISPLAY_OPTIONS
    )
    String SECTION_DISPLAY_OPTIONS = "displayOptions";

	@ConfigItem(
		section = SECTION_DISPLAY_OPTIONS,
		keyName = "enableShadowedText",
		name = "Text shadow",
		description = "Render a shadow under re-colored text to make them more readable.<br>This only applies to the chatbox dialog menu, not right click sub-menus.",
		position = POSITION_DISPLAY_OPTIONS + 1
	)
	default boolean enableShadowedText()
	{
		return true;
	}

    @ConfigItem(
            section = SECTION_DISPLAY_OPTIONS,
            keyName = "dummyColorPicker",
            name = "Dummy color picker",
            description = "Dummy color picker to help with quickly grabbing hex color codes.",
            position = POSITION_DISPLAY_OPTIONS + 2
    )
    default Color dummyColorPicker() {
        return Color.WHITE;
    }

    @ConfigSection(
            name = "Toggles",
            description = "Toggle teleport replacements for specific items.",
            position = POSITION_FLAGS
    )
    String SECTION_ENABLE_FLAGS = "enableFlags";

    // -- Enchanted jewellery --
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
            description = "Replacement text for the ring of dueling teleport location names.",
            position = POSITION_RING_OF_DUELING,
            closedByDefault = true
    )
    String SECTION_RING_OF_DUELING = "sectionRingOfDueling";

    @ConfigItem(
            keyName = "replacementPvPArena",
            name = "Emir's Arena",
            description = "Replace Emir's Arena teleport location name.",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 1
    )
    default String replacementEmirsArena() {
        return "Emir's Arena";
    }

    @ConfigItem(
            keyName = "replacementCastleWars",
            name = "Castle Wars",
            description = "Replace Castle Wars teleport location name.",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 2
    )
    default String replacementCastleWars() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementFeroxEnclave",
            name = "Ferox Enclave",
            description = "Replace Ferox Enclave teleport location name.",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 3
    )
    default String replacementFeroxEnclave() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementFortisColosseum",
            name = "Fortis Colosseum",
            description = "Replace Fortis Colosseum teleport location name.",
            section = SECTION_RING_OF_DUELING,
            position = POSITION_RING_OF_DUELING + 4
    )
    default String replacementFortisColosseum() {
        return "";
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
            description = "Replacement text for the Slayer ring teleport location names.",
            position = POSITION_SLAYER_RING,
            closedByDefault = true
    )
    String SECTION_SLAYER_RING = "sectionSlayerRing";

    @ConfigItem(
            keyName = "replacementSlayerStronghold",
            name = "Stronghold Slayer Cave",
            description = "Replace Stronghold Slayer Cave teleport location name.",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 1
    )
    default String replacementSlayerStronghold() {
        return "Gnome Stronghold Caves";
    }

    @ConfigItem(
            keyName = "replacementSlayerTower",
            name = "Morytania Slayer Tower",
            description = "Replace Morytania Slayer Tower teleport location name.",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 2
    )
    default String replacementSlayerTower() {
        return "Slayer Tower";
    }

    @ConfigItem(
            keyName = "replacementSlayerRellekka",
            name = "Rellekka Slayer Caves",
            description = "Replace Rellekka Slayer Caves teleport location name.",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 3
    )
    default String replacementSlayerRellekka() {
        return "Rellekka Caves";
    }

    @ConfigItem(
            keyName = "replacementTarns",
            name = "Tarn's Lair",
            description = "Replace Tarn's Lair teleport location name.",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 4
    )
    default String replacementTarns() {
        return "Haunted Mine";
    }

    @ConfigItem(
            keyName = "replacementDarkBeasts",
            name = "Dark Beasts",
            description = "Replace Dark Beasts teleport location name.",
            section = SECTION_SLAYER_RING,
            position = POSITION_SLAYER_RING + 5
    )
    default String replacementDarkBeasts() {
        return "ME2 Caves";
    }

    // Necklace of passage
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
            name = "Necklace of passage",
            description = "Replacement text for the Necklace of passage teleport location names.",
            position = POSITION_NECKLACE_OF_PASSAGE,
            closedByDefault = true
    )
    String SECTION_NECKLACE_OF_PASSAGE = "sectionNecklaceOfPassage";

    @ConfigItem(
            keyName = "replacementWizardTower",
            name = "Wizard's Tower",
            description = "Replace Wizard's Tower teleport location name.",
            section = SECTION_NECKLACE_OF_PASSAGE,
            position = POSITION_NECKLACE_OF_PASSAGE + 1
    )
    default String replacementWizardsTower() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementOutpost",
            name = "The Outpost",
            description = "Replace The Outpost teleport location name.",
            section = SECTION_NECKLACE_OF_PASSAGE,
            position = POSITION_NECKLACE_OF_PASSAGE + 2
    )
    default String replacementOutpost() {
        return "NW of West Ardougne";
    }

    @ConfigItem(
            keyName = "replacementEagleEyrie",
            name = "Eagle's Eyrie",
            description = "Replace Eagle's Eyrie teleport location name.",
            section = SECTION_NECKLACE_OF_PASSAGE,
            position = POSITION_NECKLACE_OF_PASSAGE + 3
    )
    default String replacementEagleEyrie() {
        return "NW of Uzer (Desert)";
    }

    // Digsite pendant
    @ConfigItem(
            keyName = "enableDigsitePendant",
            name = "Digsite pendant",
            description = "Replace teleport entries on the Digsite pendant with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_DIGSITE_PENDANT / 100)
    )
    default boolean enableDigsitePendant() {
        return true;
    }

    @ConfigSection(
            name = "Digsite pendant",
            description = "Replacement text for Digsite pendant teleport location names.",
            position = POSITION_DIGSITE_PENDANT,
            closedByDefault = true
    )
    String SECTION_DIGSITE_PENDANT = "sectionDigsitePendant";

    @ConfigItem(
            keyName = "replacementDigsite",
            name = "Digsite",
            description = "Replace Digsite teleport location name.",
            section = SECTION_DIGSITE_PENDANT,
            position = POSITION_DIGSITE_PENDANT + 1
    )
    default String replacementDigsite() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementFossilIsland",
            name = "Fossil Island",
            description = "Replace Fossil Island teleport location name.",
            section = SECTION_DIGSITE_PENDANT,
            position = POSITION_DIGSITE_PENDANT + 2
    )
    default String replacementFossilIsland() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementLithkren",
            name = "Lithkren",
            description = "Replace Lithkren teleport location name.",
            section = SECTION_DIGSITE_PENDANT,
            position = POSITION_DIGSITE_PENDANT + 3
    )
    default String replacementLithkren() {
        return "";
    }

    // Games necklace
    @ConfigItem(
            keyName = "enableGamesNecklace",
            name = "Games necklace",
            description = "Replace teleport entries on the Games necklace with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_GAMES_NECKLACE / 100)
    )
    default boolean enableGamesNecklace() {
        return false;
    }

    @ConfigSection(
            name = "Games necklace",
            description = "Replacement text for Games necklace teleport locations.",
            position = POSITION_GAMES_NECKLACE,
            closedByDefault = true
    )
    String SECTION_GAMES_NECKLACE = "sectionGamesNecklace";

    @ConfigItem(
            keyName = "replacementGamesBurthorpe",
            name = "Burthorpe",
            description = "Replace Burthorpe teleport location name.",
            section = SECTION_GAMES_NECKLACE,
            position = POSITION_GAMES_NECKLACE + 1
    )
    default String replacementGamesBurthorpe() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGamesBarbarianOutpost",
            name = "Barbarian Outpost",
            description = "Replace Barbarian Outpost teleport location name.",
            section = SECTION_GAMES_NECKLACE,
            position = POSITION_GAMES_NECKLACE + 2
    )
    default String replacementGamesBarbarianOutpost() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGamesCorporealBeast",
            name = "Corporeal Beast",
            description = "Replace Corporeal Beast teleport location name.",
            section = SECTION_GAMES_NECKLACE,
            position = POSITION_GAMES_NECKLACE + 3
    )
    default String replacementGamesCorporealBeast() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGamesTearsOfGuthix",
            name = "Tears of Guthix",
            description = "Replace Tears of Guthix teleport location name.",
            section = SECTION_GAMES_NECKLACE,
            position = POSITION_GAMES_NECKLACE + 4
    )
    default String replacementGamesTearsOfGuthix() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGamesWintertodtCamp",
            name = "Wintertodt Camp",
            description = "Replace Wintertodt Camp teleport location name.",
            section = SECTION_GAMES_NECKLACE,
            position = POSITION_GAMES_NECKLACE + 5
    )
    default String replacementGamesWintertodtCamp() {
        return "";
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
            description = "Replace Chaos Temple teleport location name.",
            section = SECTION_BURNING_AMULET,
            position = POSITION_BURNING_AMULET + 1
    )
    default String replacementBurningChaosTemple() {
        return "<col=ff0000>Chaos Temple</col>";
    }

    @ConfigItem(
            keyName = "replacementBurningBanditCamp",
            name = "Bandit Camp",
            description = "Replace Bandit Camp teleport location name.",
            section = SECTION_BURNING_AMULET,
            position = POSITION_BURNING_AMULET + 2
    )
    default String replacementBurningBanditCamp() {
        return "<col=ff0000>Bandit Camp</col>";
    }

    @ConfigItem(
            keyName = "replacementBurningLavaMaze",
            name = "Lava Maze",
            description = "Replace Lava Maze teleport location name.",
            section = SECTION_BURNING_AMULET,
            position = POSITION_BURNING_AMULET + 3
    )
    default String replacementBurningLavaMaze() {
        return "<col=ff0000>Lava Maze</col>";
    }

    // Skills necklace
    @ConfigItem(
            keyName = "enableSkillsNecklace",
            name = "Skills necklace",
            description = "Replace teleport entries on the Skills necklace with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_SKILLS_NECKLACE / 100)
    )
    default boolean enableSkillsNecklace() {
        return false;
    }

    @ConfigSection(
            name = "Skills necklace",
            description = "Replacement text for Skills necklace teleport locations.",
            position = POSITION_SKILLS_NECKLACE,
            closedByDefault = true
    )
    String SECTION_SKILLS_NECKLACE = "sectionSkillsNecklace";

    @ConfigItem(
            keyName = "replacementSkillsFishingGuild",
            name = "Fishing Guild",
            description = "Replace Fishing Guild teleport location name.",
            section = SECTION_SKILLS_NECKLACE,
            position = POSITION_SKILLS_NECKLACE + 1
    )
    default String replacementSkillsFishingGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementSkillsMiningGuild",
            name = "Mining Guild",
            description = "Replace Mining Guild teleport location name.",
            section = SECTION_SKILLS_NECKLACE,
            position = POSITION_SKILLS_NECKLACE + 2
    )
    default String replacementSkillsMiningGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementSkillsCraftingGuild",
            name = "Crafting Guild",
            description = "Replace Crafting Guild teleport location name.",
            section = SECTION_SKILLS_NECKLACE,
            position = POSITION_SKILLS_NECKLACE + 3
    )
    default String replacementSkillsCraftingGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementSkillsCookingGuild",
            name = "Cooking Guild",
            description = "Replace Cooking Guild teleport location name.",
            section = SECTION_SKILLS_NECKLACE,
            position = POSITION_SKILLS_NECKLACE + 4
    )
    default String replacementSkillsCookingGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementSkillsWoodcuttingGuild",
            name = "Woodcutting Guild",
            description = "Replace Woodcutting Guild teleport location name.",
            section = SECTION_SKILLS_NECKLACE,
            position = POSITION_SKILLS_NECKLACE + 5
    )
    default String replacementSkillsWoodcuttingGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementSkillsFarmingGuild",
            name = "Farming Guild",
            description = "Replace Farming Guild teleport location name.",
            section = SECTION_SKILLS_NECKLACE,
            position = POSITION_SKILLS_NECKLACE + 6
    )
    default String replacementSkillsFarmingGuild() {
        return "";
    }

    // Combat bracelet
    @ConfigItem(
            keyName = "enableCombatBracelet",
            name = "Combat bracelet",
            description = "Replace teleport entries on the Combat bracelet with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_COMBAT_BRACELET / 100)
    )
    default boolean enableCombatBracelet() {
        return false;
    }

    @ConfigSection(
            name = "Combat bracelet",
            description = "Replacement text for Combat bracelet teleport locations.",
            position = POSITION_COMBAT_BRACELET,
            closedByDefault = true
    )
    String SECTION_COMBAT_BRACELET = "sectionCombatBracelet";

    @ConfigItem(
            keyName = "replacementCombatWarriorsGuild",
            name = "Warriors' Guild",
            description = "Replace Warriors' Guild teleport location name.",
            section = SECTION_COMBAT_BRACELET,
            position = POSITION_COMBAT_BRACELET + 1
    )
    default String replacementCombatWarriorsGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementCombatChampionsGuild",
            name = "Champions' Guild",
            description = "Replace Champions' Guild teleport location name.",
            section = SECTION_COMBAT_BRACELET,
            position = POSITION_COMBAT_BRACELET + 2
    )
    default String replacementCombatChampionsGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementCombatMonastery",
            name = "Monastery",
            description = "Replace Monastery teleport location name.",
            section = SECTION_COMBAT_BRACELET,
            position = POSITION_COMBAT_BRACELET + 3
    )
    default String replacementCombatMonastery() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementCombatRangingGuild",
            name = "Ranging Guild",
            description = "Replace Ranging Guild teleport location name.",
            section = SECTION_COMBAT_BRACELET,
            position = POSITION_COMBAT_BRACELET + 4
    )
    default String replacementCombatRangingGuild() {
        return "";
    }

    // Ring of wealth
    @ConfigItem(
            keyName = "enableRingOfWealth",
            name = "Ring of wealth",
            description = "Replace teleport entries on the Ring of wealth with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_RING_OF_WEALTH / 100)
    )
    default boolean enableRingOfWealth() {
        return false;
    }

    @ConfigSection(
            name = "Ring of wealth",
            description = "Replacement text for Ring of wealth teleport locations.",
            position = POSITION_RING_OF_WEALTH,
            closedByDefault = true
    )
    String SECTION_RING_OF_WEALTH = "sectionRingOfWealth";

    @ConfigItem(
            keyName = "replacementWealthMiscellania",
            name = "Miscellania",
            description = "Replace Miscellania teleport location name.",
            section = SECTION_RING_OF_WEALTH,
            position = POSITION_RING_OF_WEALTH + 1
    )
    default String replacementWealthMiscellania() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementWealthGrandExchange",
            name = "Grand Exchange",
            description = "Replace Grand Exchange teleport location name.",
            section = SECTION_RING_OF_WEALTH,
            position = POSITION_RING_OF_WEALTH + 2
    )
    default String replacementWealthGrandExchange() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementWealthFalador",
            name = "Falador",
            description = "Replace Falador teleport location name.",
            section = SECTION_RING_OF_WEALTH,
            position = POSITION_RING_OF_WEALTH + 3
    )
    default String replacementWealthFalador() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementWealthDondakan",
            name = "Dondakan",
            description = "Replace Dondakan teleport location name.",
            section = SECTION_RING_OF_WEALTH,
            position = POSITION_RING_OF_WEALTH + 4
    )
    default String replacementWealthDondakan() {
        return "";
    }

    // Amulet of glory
    @ConfigItem(
            keyName = "enableAmuletOfGlory",
            name = "Amulet of glory",
            description = "Replace teleport entries on the Amulet of glory with new names.",
            section = SECTION_ENABLE_FLAGS,
            position = POSITION_FLAGS + (POSITION_AMULET_OF_GLORY / 100)
    )
    default boolean enableAmuletOfGlory() {
        return false;
    }

    @ConfigSection(
            name = "Amulet of glory",
            description = "Replacement text for Amulet of glory teleport locations.",
            position = POSITION_AMULET_OF_GLORY,
            closedByDefault = true
    )
    String SECTION_AMULET_OF_GLORY = "sectionAmuletOfGlory";

    @ConfigItem(
            keyName = "replacementGloryEdgeville",
            name = "Edgeville",
            description = "Replace Edgeville teleport location name.",
            section = SECTION_AMULET_OF_GLORY,
            position = POSITION_AMULET_OF_GLORY + 1
    )
    default String replacementGloryEdgeville() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGloryKaramja",
            name = "Karamja",
            description = "Replace Karamja teleport location name.",
            section = SECTION_AMULET_OF_GLORY,
            position = POSITION_AMULET_OF_GLORY + 2
    )
    default String replacementGloryKaramja() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGloryDraynorVillage",
            name = "Draynor Village",
            description = "Replace Draynor Village teleport location name.",
            section = SECTION_AMULET_OF_GLORY,
            position = POSITION_AMULET_OF_GLORY + 3
    )
    default String replacementGloryDraynorVillage() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementGloryAlKharid",
            name = "Al Kharid",
            description = "Replace Al Kharid teleport location name.",
            section = SECTION_AMULET_OF_GLORY,
            position = POSITION_AMULET_OF_GLORY + 4
    )
    default String replacementGloryAlKharid() {
        return "";
    }

    // -- Skill capes --
    // Max cape (applies to all other skill capes with teleports)
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableMaxCape",
            name = "Max/skill capes",
            description = "Replace teleport entries on the Max/skill capes with new names.",
            position = POSITION_FLAGS + (POSITION_MAX_CAPE / 100)
    )
    default boolean enableMaxCape() {
        return false;
    }

    @ConfigSection(
            name = "Max/skill capes",
            description = "Replacement text for Max/skill capes teleport location names.",
            position = POSITION_MAX_CAPE,
            closedByDefault = true
    )
    String SECTION_MAX_CAPE = "sectionMaxCape";

    @ConfigItem(
            keyName = "replacementMaxCapeWarriorsGuild",
            name = "Warrior's Guild",
            description = "Replace Warrior's Guild teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 1
    )
    default String replacementMaxCapeWarriorsGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeFishingGuild",
            name = "Fishing Guild",
            description = "Replace Fishing Guild teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 2
    )
    default String replacementMaxCapeFishingGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeCraftingGuild",
            name = "Crafting Guild",
            description = "Replace Crafting Guild teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 3
    )
    default String replacementMaxCapeCraftingGuild() {
        return "<col=ffca00>Crafting Guild</col>";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeFarmingGuild",
            name = "Farming Guild",
            description = "Replace Farming Guild teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 4
    )
    default String replacementMaxCapeFarmingGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeOttosGrotto",
            name = "Otto's Grotto",
            description = "Replace Otto's Grotto teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 5
    )
    default String replacementMaxCapeOttosGrotto() {
        return "Barbarian fishing";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeFeldipHills",
            name = "Feldip Hills",
            description = "Replace Feldip Hills teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 6
    )
    default String replacementMaxCapeFeldipHills() {
        return "Red chinchompas";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeBlackChinchompas",
            name = "Black chinchompas",
            description = "Replace Black chinchompas teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 7
    )
    default String replacementMaxCapeBlackChinchompas() {
        return "<col=ff0000>Black chinchompas</col>";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeHunterGuild",
            name = "Hunter Guild",
            description = "Replace Hunter Guild teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 8
    )
    default String replacementMaxCapeHunterGuild() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeHome",
            name = "Home",
            description = "Replace Home teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 9
    )
    default String replacementMaxCapeHome() {
        return "<col=8800ff>Home</col>";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeRimmington",
            name = "Rimmington",
            description = "Replace Rimmington teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 10
    )
    default String replacementMaxCapeRimmington() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeTaverley",
            name = "Taverley",
            description = "Replace Taverley teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 11
    )
    default String replacementMaxCapeTaverley() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapePollnivneach",
            name = "Pollnivneach",
            description = "Replace Pollnivneach teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 12
    )
    default String replacementMaxCapePollnivneach() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeHosidius",
            name = "Hosidius",
            description = "Replace Hosidius teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 13
    )
    default String replacementMaxCapeHosidius() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeAldarin",
            name = "Aldarin",
            description = "Replace Aldarin teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 14
    )
    default String replacementMaxCapeAldarin() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeRellekka",
            name = "Rellekka",
            description = "Replace Rellekka teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 15
    )
    default String replacementMaxCapeRellekka() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeBrimhaven",
            name = "Brimhaven",
            description = "Replace Brimhaven teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 16
    )
    default String replacementMaxCapeBrimhaven() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapeYanille",
            name = "Yanille",
            description = "Replace Yanille teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 17
    )
    default String replacementMaxCapeYanille() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementMaxCapePrifddinas",
            name = "Prifddinas",
            description = "Replace Prifddinas teleport location name.",
            section = SECTION_MAX_CAPE,
            position = POSITION_MAX_CAPE + 18
    )
    default String replacementMaxCapePrifddinas() {
        return "";
    }

    // -- Achievement diary items --
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
            description = "Replacement text for Rada's blessing teleport location names.",
            position = POSITION_RADAS_BLESSING,
            closedByDefault = true
    )
    String SECTION_RADAS_BLESSING = "sectionRadasBlessing";

    @ConfigItem(
            keyName = "replacementRadasKourendWoodland",
            name = "Kourend Woodland",
            description = "Replace Kourend Woodland teleport location name.",
            section = SECTION_RADAS_BLESSING,
            position = POSITION_RADAS_BLESSING + 1
    )
    default String replacementRadasKourendWoodland() {
        return "<col=2aae4f>Kourend Woodland</col>";
    }

    @ConfigItem(
            keyName = "replacementRadasMountKaruulm",
            name = "Mount Karuulm",
            description = "Replace Mount Karuulm teleport location name.",
            section = SECTION_RADAS_BLESSING,
            position = POSITION_RADAS_BLESSING + 2
    )
    default String replacementRadasMountKaruulm() {
        return "<col=8800ff>Konar</col>";
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
            description = "Replacement text for Karamja gloves teleport location names.",
            position = POSITION_KARAMJA_GLOVES,
            closedByDefault = true
    )
    String SECTION_KARAMJA_GLOVES = "sectionKaramjaGloves";

    @ConfigItem(
            keyName = "replacementKaramjaGemMine",
            name = "Gem Mine",
            description = "Replace Gem Mine teleport location name.",
            section = SECTION_KARAMJA_GLOVES,
            position = POSITION_KARAMJA_GLOVES + 1
    )
    default String replacementKaramjaGemMine() {
        return "<col=8800ff>Gem Mine</col>";
    }

    @ConfigItem(
            keyName = "replacementKaramjaSlayerMaster",
            name = "Slayer Master",
            description = "Replace Slayer Master teleport location name.",
            section = SECTION_KARAMJA_GLOVES,
            position = POSITION_KARAMJA_GLOVES + 2
    )
    default String replacementKaramjaSlayerMaster() {
        return "<col=ff0000>Duradel</col>";
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
            description = "Replacement text for Morytania legs teleport location names.",
            position = POSITION_MORYTANIA_LEGS,
            closedByDefault = true
    )
    String SECTION_MORYTANIA_LEGS = "sectionMorytaniaLegs";

    @ConfigItem(
            keyName = "replacementMorytaniaEctofuntus",
            name = "Ecto Teleport",
            description = "Replace Ecto Teleport teleport location name.",
            section = SECTION_MORYTANIA_LEGS,
            position = POSITION_MORYTANIA_LEGS + 1
    )
    default String replacementMorytaniaEctofuntus() {
        return "Ectofuntus";
    }

    @ConfigItem(
            keyName = "replacementMorytaniaBurgh",
            name = "Burgh Teleport",
            description = "Replace Burgh Teleport teleport location name.",
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
            description = "Replacement text for Desert amulet teleport location names.",
            position = POSITION_DESERT_AMULET,
            closedByDefault = true
    )
    String SECTION_DESERT_AMULET = "sectionDesertAmulet";

    @ConfigItem(
            keyName = "replacementDesertNardah",
            name = "Nardah",
            description = "Replace Nardah teleport location name.",
            section = SECTION_DESERT_AMULET,
            position = POSITION_DESERT_AMULET + 1
    )
    default String replacementDesertNardah() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementDesertKalphiteCave",
            name = "Kalphite cave",
            description = "Replace Kalphite cave teleport location name.",
            section = SECTION_DESERT_AMULET,
            position = POSITION_DESERT_AMULET + 2
    )
    default String replacementDesertKalphiteCave() {
        return "";
    }

    // Ardougne cloak
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableArdougneCloak",
            name = "Ardougne cloak",
            description = "Replace teleport entries on the Ardougne cloak with new names.",
            position = POSITION_FLAGS + (POSITION_ARDOUGNE_CLOAK / 100)
    )
    default boolean enableArdougneCloak() {
        return false;
    }

    @ConfigSection(
            name = "Ardougne cloak",
            description = "Replacement text for the Ardougne cloak teleport location names.",
            position = POSITION_ARDOUGNE_CLOAK,
            closedByDefault = true
    )
    String SECTION_ARDOUGNE_CLOAK = "sectionArdougneCloak";

    @ConfigItem(
            keyName = "replacementArdougneCloakKandarinMonastery",
            name = "Kandarin Monastery",
            description = "Replace Kandarin Monastery teleport location name.",
            section = SECTION_ARDOUGNE_CLOAK,
            position = POSITION_ARDOUGNE_CLOAK + 1
    )
    default String replacementArdougneCloakKandarinMonastery() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementArdougneCloakArdougneFarm",
            name = "Ardougne Farm",
            description = "Replace Ardougne Farm teleport location name.",
            section = SECTION_ARDOUGNE_CLOAK,
            position = POSITION_ARDOUGNE_CLOAK + 2
    )
    default String replacementArdougneCloakArdougneFarm() {
        return "";
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
            description = "Replacement text for the Achievement diary cape teleport location names.",
            position = POSITION_DIARY_CAPE,
            closedByDefault = true
    )
    String SECTION_DIARY_CAPE = "sectionDiaryCape";

    @ConfigItem(
            keyName = "replacementArdougne",
            name = "Ardougne: Two-pints",
            description = "Replace Ardougne: Two-pints teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 1
    )
    default String replacementArdougne() {
        return "Ardougne: Bar";
    }

    @ConfigItem(
            keyName = "replacementDesert",
            name = "Desert: Jarr",
            description = "Replace Desert: Jarr teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 2
    )
    default String replacementDesert() {
        return "Desert: Shantay Pass";
    }

    @ConfigItem(
            keyName = "replacementFalador",
            name = "Falador: Sir Rebral",
            description = "Replace Falador: Sir Rebral teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 3
    )
    default String replacementFalador() {
        return "Falador: Castle";
    }

    @ConfigItem(
            keyName = "replacementFremennik",
            name = "Fremennik: Thorodin",
            description = "Replace Fremennik: Thorodin teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 4
    )
    default String replacementFremennik() {
        return "Fremennik: POH Portal";
    }

    @ConfigItem(
            keyName = "replacementKandarin",
            name = "Kandarin: Flax keeper",
            description = "Replace Kandarin: Flax keeper teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 5
    )
    default String replacementKandarin() {
        return "Kandarin: Flax";
    }

    @ConfigItem(
            keyName = "replacementKaramjaJackie",
            name = "Karamja: Pirate Jackie the Fruit",
            description = "Replace Karamja: Pirate Jackie the Fruit teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 6
    )
    default String replacementKaramjaJackie() {
        return "Karamja: Agility Arena";
    }

    @ConfigItem(
            keyName = "replacementKaramjaKaleb",
            name = "Karamja: Kaleb Paramaya (retired)",
            description = "Replace Karamja: Kaleb Paramaya (retired) teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 7
    )
    default String replacementKaramjaKaleb() {
        return "Karamja: Shilo Village";
    }

    @ConfigItem(
            keyName = "replacementKaramjaForester",
            name = "Karamja: Jungle forester (retired)",
            description = "Replace Karamja: Jungle forester (retired) teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 8
    )
    default String replacementKaramjaForester() {
        return "Karamja: Kharazi Jungle";
    }

    @ConfigItem(
            keyName = "replacementKaramjaTzhaar",
            name = "Karamja: TzHaar-Mej (retired)",
            description = "Replace Karamja: TzHaar-Mej (retired) teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 9
    )
    default String replacementKaramjaTzhaar() {
        return "Karamja: Mor-Ul-Rek";
    }

    @ConfigItem(
            keyName = "replacementKourend",
            name = "Kourend & Kebos: Elise",
            description = "Replace Kourend & Kebos: Elise teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 10
    )
    default String replacementKourend() {
        return "Kourend: Castle";
    }

    @ConfigItem(
            keyName = "replacementLumbridge",
            name = "Lumbridge & Draynor: Hatius Cosaintus",
            description = "Replace Lumbridge & Draynor: Hatius Cosaintus teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 11
    )
    default String replacementLumbridge() {
        return "Lumbridge: Town Square";
    }

    @ConfigItem(
            keyName = "replacementMorytania",
            name = "Morytania: Le-sabrè",
            description = "Replace Morytania: Le-sabrè teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 12
    )
    default String replacementMorytania() {
        return "Morytania: Canifis";
    }

    @ConfigItem(
            keyName = "replacementVarrock",
            name = "Varrock: Toby",
            description = "Replace Varrock: Toby teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 13
    )
    default String replacementVarrock() {
        return "Varrock: Rooftops";
    }

    @ConfigItem(
            keyName = "replacementWilderness",
            name = "Wilderness: Lesser Fanatic",
            description = "Wilderness: Lesser Fanatic teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 14
    )
    default String replacementWilderness() {
        return "Wilderness: Edgeville";
    }

    @ConfigItem(
            keyName = "replacementWestern",
            name = "Western Provinces: Elder Gnome Child",
            description = "Replace Western Provinces: Elder Gnome Child teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 15
    )
    default String replacementWestern() {
        return "Western: Gnome Stronghold";
    }

    @ConfigItem(
            keyName = "replacementTwiggy",
            name = "Twiggy O'Korn",
            description = "Replace Twiggy O'Korn teleport location name.",
            section = SECTION_DIARY_CAPE,
            position = POSITION_DIARY_CAPE + 16
    )
    default String replacementTwiggy() {
        return "Diary Master: Draynor Village";
    }

    // -- Quest-related items --
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
            description = "Replacement text for the Kharedst's memoirs/Book of the dead teleport location names.",
            position = POSITION_KHAREDSTS_MEMOIRS,
            closedByDefault = true
    )
    String SECTION_KHAREDSTS_MEMOIRS = "sectionKharedstsMemoirs";

    @ConfigItem(
            keyName = "replacementLancalliums",
            name = "Lunch by the Lancalliums",
            description = "Replace Lunch by the Lancalliums teleport location name.",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 1
    )
    default String replacementLancalliums() {
        return "<col=2aae4f>Hosidius</col>";
    }

    @ConfigItem(
            keyName = "replacementFishers",
            name = "The Fisher's Flute",
            description = "Replace The Fisher's Flute teleport location name.",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 2
    )
    default String replacementFishers() {
        return "<col=2a94ae>Port Piscarilius</col>";
    }

    @ConfigItem(
            keyName = "replacementHistory",
            name = "History and Hearsay",
            description = "Replace History and Hearsay teleport location name.",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 3
    )
    default String replacementHistory() {
        return "<col=ae2a2a>Shayzien</col>";
    }

    @ConfigItem(
            keyName = "replacementJubilation",
            name = "Jewellery of Jubilation",
            description = "Replace Jewellery of Jubilation teleport location name.",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 4
    )
    default String replacementJubilation() {
        return "<col=ae842a>Lovakengj</col>";
    }

    @ConfigItem(
            keyName = "replacementDisposition",
            name = "A Dark Disposition",
            description = "Replace A Dark Disposition teleport location name.",
            section = SECTION_KHAREDSTS_MEMOIRS,
            position = POSITION_KHAREDSTS_MEMOIRS + 5
    )
    default String replacementDisposition() {
        return "<col=8800ff>Arceuus</col>";
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
            description = "Replacement text for Drakan's medallion teleport location names.",
            position = POSITION_DRAKANS,
            closedByDefault = true
    )
    String SECTION_DRAKANS = "sectionDrakans";

    @ConfigItem(
            keyName = "replacementVerSinhaza",
            name = "Ver Sinhaza",
            description = "Replace Ver Sinhaza teleport location name.",
            section = SECTION_DRAKANS,
            position = POSITION_DRAKANS + 1
    )
    default String replacementVerSinhaza() {
        return "Theatre of Blood";
    }

    @ConfigItem(
            keyName = "replacementDarkmeyer",
            name = "Darkmeyer",
            description = "Replace Darkmeyer teleport location name.",
            section = SECTION_DRAKANS,
            position = POSITION_DRAKANS + 2
    )
    default String replacementDarkmeyer() {
        return "Vampyre City";
    }

    @ConfigItem(
            keyName = "replacementSlepe",
            name = "Slepe",
            description = "Replace Slepe teleport location name.",
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
            name = "Ring of shadows",
            description = "Replacement text for the Ring of shadows teleport location names.",
            position = POSITION_RING_OF_SHADOWS,
            closedByDefault = true
    )
    String SECTION_RING_OF_SHADOWS = "sectionRingOfShadows";

    @ConfigItem(
            keyName = "replacementAncientVault",
            name = "The Ancient Vault",
            description = "Replace The Ancient Vault teleport location name.",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 1
    )
    default String replacementAncientVault() {
        return "<col=aea92a>DT2 Vault</col>";
    }

    @ConfigItem(
            keyName = "replacementGhorrockDungeon",
            name = "Ghorrock Dungeon",
            description = "Replace Ghorrock Dungeon teleport location name.",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 2
    )
    default String replacementGhorrockDungeon() {
        return "<col=2a94ae>Duke Sucellus</col>";
    }

    @ConfigItem(
            keyName = "replacementScar",
            name = "The Scar",
            description = "Replace The Scar teleport location name.",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 3
    )
    default String replacementScar() {
        return "<col=ae2a43>Leviathan</col>";
    }

    @ConfigItem(
            keyName = "replacementLassarUndercity",
            name = "Lassar Undercity",
            description = "Replace Lassar Undercity teleport location name.",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 4
    )
    default String replacementLassarUndercity() {
        return "<col=5f2aae>Whisperer</col>";
    }

    @ConfigItem(
            keyName = "replacementStranglewood",
            name = "The Stranglewood",
            description = "Replace The Stranglewood teleport location name.",
            section = SECTION_RING_OF_SHADOWS,
            position = POSITION_RING_OF_SHADOWS + 5
    )
    default String replacementStranglewood() {
        return "<col=ae2a2a>Vardorvis</col>";
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
            description = "Replacement text for Enchanted lyre teleport location names.",
            position = POSITION_ENCHANTED_LYRE,
            closedByDefault = true
    )
    String SECTION_ENCHANTED_LYRE = "sectionEnchantedLyre";

    @ConfigItem(
            keyName = "replacementLyreRellekka",
            name = "Rellekka",
            description = "Replace Rellekka teleport location name.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 1
    )
    default String replacementLyreRellekka() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementLyreWaterbirthIsland",
            name = "Waterbirth Island",
            description = "Replace Waterbirth Island teleport location name.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 2
    )
    default String replacementLyreWaterbirthIsland() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementLyreNeitiznot",
            name = "Neitiznot",
            description = "Replace Neitiznot teleport location name.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 3
    )
    default String replacementLyreNeitiznot() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementLyreJatizso",
            name = "Jatizso",
            description = "Replace Jatizso teleport location name.",
            section = SECTION_ENCHANTED_LYRE,
            position = POSITION_ENCHANTED_LYRE + 4
    )
    default String replacementLyreJatizso() {
        return "";
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
            description = "Replacement text for Camulet teleport location names.",
            position = POSITION_CAMULET,
            closedByDefault = true
    )
    String SECTION_CAMULET = "sectionCamulet";

    @ConfigItem(
            keyName = "replacementCamuletEnakhrasTemple",
            name = "Enakhra's Temple",
            description = "Replace Enakhra's Temple teleport location name.",
            section = SECTION_CAMULET,
            position = POSITION_CAMULET + 1
    )
    default String replacementCamuletEnakhrasTemple() {
        return "Inside Enakhra's Temple";
    }

    @ConfigItem(
            keyName = "replacementCamuletEnakhrasTempleEntrance",
            name = " Enakhra's Temple Entrance",
            description = "Replace Enakhra's Temple Entrance teleport location name.",
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
            description = "Replacement text for Eternal teleport crystal teleport location names.",
            position = POSITION_ETERNAL_TELEPORT_CRYSTAL,
            closedByDefault = true
    )
    String SECTION_ETERNAL_TELEPORT_CRYSTAL = "sectionEternalTeleportCrystal";

    @ConfigItem(
            keyName = "replacementEternalPrifddinas",
            name = "Prifddinas",
            description = "Replace Prifddinas teleport location name.",
            section = SECTION_ETERNAL_TELEPORT_CRYSTAL,
            position = POSITION_ETERNAL_TELEPORT_CRYSTAL + 1
    )
    default String replacementEternalPrifddinas() {
        return "<col=2a94ae>Prifddinas</col>";
    }

    @ConfigItem(
            keyName = "replacementEternalLletya",
            name = " Lletya",
            description = "Replace Lletya teleport location name.",
            section = SECTION_ETERNAL_TELEPORT_CRYSTAL,
            position = POSITION_ETERNAL_TELEPORT_CRYSTAL + 2
    )
    default String replacementEternalLletya() {
        return "<col=2aae4f>Lletya</col>";
    }

    // -- Other items --
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
            description = "Replacement text for the Pharaoh's sceptre teleport location names.",
            position = POSITION_PHARAOHS_SCEPTRE,
            closedByDefault = true
    )
    String SECTION_PHARAOHS_SCEPTRE = "sectionCustomReplacements"; // legacy config name

    @ConfigItem(
            keyName = "replacementJalsavrah",
            name = "Jalsavrah",
            description = "Replace Jalsavrah teleport location name.",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 1
    )
    default String replacementJalsavrah() {
        return "Pyramid Plunder";
    }

    @ConfigItem(
            keyName = "replacementJaleustrophos",
            name = "Jaleustrophos",
            description = "Replace Jaleustrophos teleport location name.",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 2
    )
    default String replacementJaleustrophos() {
        return "Agility Pyramid";
    }

    @ConfigItem(
            keyName = "replacementJaldraocht",
            name = "Jaldraocht",
            description = "Replace Jaldraocht teleport location name.",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 3
    )
    default String replacementJaldraocht() {
        return "Ancients Pyramid";
    }

    @ConfigItem(
            keyName = "replacementJaltevas",
            name = "Jaltevas",
            description = "Replace Jaltevas teleport location name.",
            section = SECTION_PHARAOHS_SCEPTRE,
            position = POSITION_PHARAOHS_SCEPTRE + 4
    )
    default String replacementJaltevas() {
        return "Necropolis";
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
            description = "Replacement text for the Xeric's talisman teleport location names.",
            position = POSITION_XERICS_TALISMAN,
            closedByDefault = true
    )
    String SECTION_XERICS_TALISMAN = "sectionXericsTalisman";

    @ConfigItem(
            keyName = "replacementLookout",
            name = "Xeric's Look-out",
            description = "Replace Xeric's Look-out teleport location name.",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 1
    )
    default String replacementLookout() {
        return "Shayzien";
    }

    @ConfigItem(
            keyName = "replacementGlade",
            name = "Xeric's Glade",
            description = "Replace Xeric's Glade teleport location name.",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 2
    )
    default String replacementGlade() {
        return "Hosidius";
    }

    @ConfigItem(
            keyName = "replacementInferno",
            name = "Xeric's Inferno",
            description = "Replace Xeric's Inferno teleport location name.",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 3
    )
    default String replacementInferno() {
        return "Lovakengj";
    }

    @ConfigItem(
            keyName = "replacementHeart",
            name = "Xeric's Heart",
            description = "Replace Xeric's Heart teleport location name.",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 4
    )
    default String replacementHeart() {
        return "Kourend Castle";
    }

    @ConfigItem(
            keyName = "replacementHonour",
            name = "Xeric's Honour",
            description = "Replace Xeric's Honour teleport location name.",
            section = SECTION_XERICS_TALISMAN,
            position = POSITION_XERICS_TALISMAN + 5
    )
    default String replacementHonour() {
        return "Chambers of Xeric";
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
            description = "Replacement text for Pendant of ates teleport location names.",
            position = POSITION_PENDANT_OF_ATES,
            closedByDefault = true
    )
    String SECTION_PENDANT_OF_ATES = "sectionPendantOfAtes";

    @ConfigItem(
            keyName = "replacementDarkfrost",
            name = "The Darkfrost",
            description = "Replace The Darkfrost (west of base camp) teleport location name.",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 1
    )
    default String replacementDarkfrost() {
        return "<col=2a94ae>Hueycoatl</col>";
    }

    @ConfigItem(
            keyName = "replacementTwilightTemple",
            name = "Twilight Temple",
            description = "Replace Twilight Temple (east of Tower of Ascension) teleport location name.",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 2
    )
    default String replacementTwilightTemple() {
        return "<col=ae2a2a>Amoxliatl</col>";
    }

    @ConfigItem(
            keyName = "replacementRalosRise",
            name = "Ralos' Rise",
            description = "Replace Ralos' Rise (east of exposed altar) teleport location name.",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 3
    )
    default String replacementRalosRise() {
        return "<col=ae8b2a>Moons of Peril</col>";
    }

    @ConfigItem(
            keyName = "replacementNorthAldarin",
            name = "North Aldarin",
            description = "Replace North Aldarin (north of market) teleport location name.",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 4
    )
    default String replacementNorthAldarin() {
        return "<col=8800ff>Mastering Mixology</col>";
    }

    @ConfigItem(
            keyName = "replacementKastori",
            name = "Kastori",
            description = "Replace Kastori (east of Tlati Rainforest) teleport location name.",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 5
    )
    default String replacementKastori() {
        return "<col=65684f>Gemstone Crab</col>";
    }

    @ConfigItem(
            keyName = "replacementNemusRetreat",
            name = "Nemus Retreat",
            description = "Replace Nemus Retreat (south of Auburnvale) teleport location name.",
            section = SECTION_PENDANT_OF_ATES,
            position = POSITION_PENDANT_OF_ATES + 6
    )
    default String replacementNemusRetreat() {
        return "<col=80b37c>Vale Totems</col>";
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
            description = "Replacement text for Ghommal's hilt teleport location names.",
            position = POSITION_GHOMMALS_HILT,
            closedByDefault = true
    )
    String SECTION_GHOMMALS_HILT = "sectionGhommalsHilt";

    @ConfigItem(
            keyName = "replacementGhommalTrollheim",
            name = "Trollheim",
            description = "Replace Trollheim teleport location name.",
            section = SECTION_GHOMMALS_HILT,
            position = POSITION_GHOMMALS_HILT + 1
    )
    default String replacementGhommalTrollheim() {
        return "<col=2a94ae>God Wars</col>";
    }

    @ConfigItem(
            keyName = "replacementGhommalMorUlRek",
            name = "Mor Ul Rek",
            description = "Replace Mor Ul Rek teleport location name.",
            section = SECTION_GHOMMALS_HILT,
            position = POSITION_GHOMMALS_HILT + 2
    )
    default String replacementGhommalMorUlRek() {
        return "<col=ff0000>The Inferno</col>";
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
            description = "Replacement text for Grand seed pod teleport location names.",
            position = POSITION_GRAND_SEED_POD,
            closedByDefault = true
    )
    String SECTION_GRAND_SEED_POD = "sectionGrandSeedPod";

    @ConfigItem(
            keyName = "replacementPodLaunch",
            name = "Launch",
            description = "Replace Launch teleport location name.",
            section = SECTION_GRAND_SEED_POD,
            position = POSITION_GRAND_SEED_POD + 1
    )
    default String replacementPodLaunch() {
        return "Gnome Glider";
    }

    @ConfigItem(
            keyName = "replacementPodSquash",
            name = "Squash",
            description = "Replace Squash teleport location name.",
            section = SECTION_GRAND_SEED_POD,
            position = POSITION_GRAND_SEED_POD + 2
    )
    default String replacementPodSquash() {
        return "Grand Tree (King Narnode)";
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
            description = "Replacement text for Ring of the elements teleport location names.",
            position = POSITION_RING_OF_THE_ELEMENTS,
            closedByDefault = true
    )
    String SECTION_RING_OF_THE_ELEMENTS = "sectionRingOfTheElements";

    @ConfigItem(
            keyName = "replacementAirAltar",
            name = "Air Altar",
            description = "Replace Air Altar teleport location name.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 1
    )
    default String replacementAirAltar() {
        return "<col=ffffff>Air Altar</col>";
    }

    @ConfigItem(
            keyName = "replacementWaterAltar",
            name = "Water Altar",
            description = "Replace Water Altar teleport location name.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 2
    )
    default String replacementWaterAltar() {
        return "<col=2a94ae>Water Altar</col>";
    }

    @ConfigItem(
            keyName = "replacementEarthAltar",
            name = "Earth Altar",
            description = "Replace Earth Altar teleport location name.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 3
    )
    default String replacementEarthAltar() {
        return "<col=2aae4f>Earth Altar</col>";
    }

    @ConfigItem(
            keyName = "replacementFireAltar",
            name = "Fire Altar",
            description = "Replace Fire Altar teleport location name.",
            section = SECTION_RING_OF_THE_ELEMENTS,
            position = POSITION_RING_OF_THE_ELEMENTS + 4
    )
    default String replacementFireAltar() {
        return "<col=ff0000>Fire Altar</col>";
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
            description = "Replacement text for Giantsoul amulet teleport location names.",
            position = POSITION_GIANTSOUL_AMULET,
            closedByDefault = true
    )
    String SECTION_GIANTSOUL_AMULET = "sectionGiantsoulAmulet";

    @ConfigItem(
            keyName = "replacementBryophyta",
            name = "Bryophyta",
            description = "Replace Bryophyta teleport location name.",
            section = SECTION_GIANTSOUL_AMULET,
            position = POSITION_GIANTSOUL_AMULET + 1
    )
    default String replacementBryophyta() {
        return "<col=2aae4f>Bryo</col>";
    }

    @ConfigItem(
            keyName = "replacementObor",
            name = "Obor",
            description = "Replace Obor teleport location name.",
            section = SECTION_GIANTSOUL_AMULET,
            position = POSITION_GIANTSOUL_AMULET + 2
    )
    default String replacementObor() {
        return "<col=ffca00>Obor</col>";
    }

    @ConfigItem(
            keyName = "replacementBrandaAndEldric",
            name = "Branda and Eldric",
            description = "Replace Branda and Eldric teleport location name.",
            section = SECTION_GIANTSOUL_AMULET,
            position = POSITION_GIANTSOUL_AMULET + 3
    )
    default String replacementBrandaAndEldric() {
        return "<col=ff0000>Royal</col> <col=2a94ae>Titans</col>";
    }

    // Ancient shard
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableAncientShard",
            name = "Ancient shard",
            description = "Replace teleport entries on the Ancient shard teleport with new names.",
            position = POSITION_FLAGS + (POSITION_ANCIENT_SHARD / 100)
    )
    default boolean enableAncientShard() {
        return false;
    }

    @ConfigSection(
            name = "Ancient shard",
            description = "Replacement text for the Ancient shard teleport location names.",
            position = POSITION_ANCIENT_SHARD,
            closedByDefault = true
    )
    String SECTION_ANCIENT_SHARD = "sectionAncientShard";

    @ConfigItem(
            keyName = "replacementAncientShardDemonsRun",
            name = "Demon's Run ",
            description = "Replace Demon's Run teleport location name.",
            section = SECTION_ANCIENT_SHARD,
            position = POSITION_ANCIENT_SHARD + 1
    )
    default String replacementAncientShardDemonsRun() {
        return "NE - Lesser demons";
    }

    @ConfigItem(
            keyName = "replacementAncientShardDragonsDen",
            name = "Dragon's Den",
            description = "Replace Dragon's Den teleport location name.",
            section = SECTION_ANCIENT_SHARD,
            position = POSITION_ANCIENT_SHARD + 2
    )
    default String replacementAncientShardDragonsDen() {
        return "NW - Brutal blue dragons";
    }

    @ConfigItem(
            keyName = "replacementAncientShardReekingCove",
            name = "Reeking Cove",
            description = "Replace Reeking Cove teleport location name.",
            section = SECTION_ANCIENT_SHARD,
            position = POSITION_ANCIENT_SHARD + 3
    )
    default String replacementAncientShardReekingCove() {
        return "SW - Deviant spectres";
    }

    @ConfigItem(
            keyName = "replacementAncientShardTheShallows",
            name = "The Shallows",
            description = "Replace The Shallows teleport location name.",
            section = SECTION_ANCIENT_SHARD,
            position = POSITION_ANCIENT_SHARD + 4
    )
    default String replacementAncientShardTheShallows() {
        return "SE - King sand crabs";
    }

    // Disk of returning
    @ConfigItem(
            section = SECTION_ENABLE_FLAGS,
            keyName = "enableDiskOfReturning",
            name = "Disk of returning",
            description = "Replace teleport entries on the Disk of returning teleport with new names.",
            position = POSITION_FLAGS + (POSITION_DISK_OF_RETURNING / 100)
    )
    default boolean enableDiskOfReturning() {
        return false;
    }

    @ConfigSection(
            name = "Disk of returning",
            description = "Replacement text for the Disk of returning teleport location names.",
            position = POSITION_DISK_OF_RETURNING,
            closedByDefault = true
    )
    String SECTION_DISK_OF_RETURNING = "sectionDiskOfReturning";

    @ConfigItem(
            keyName = "replacementDiskOfReturningActivate",
            name = "Activate ",
            description = "Replace Activate teleport location name.",
            section = SECTION_DISK_OF_RETURNING,
            position = POSITION_DISK_OF_RETURNING + 1
    )
    default String replacementDiskOfReturningActivate() {
        return "";
    }

    @ConfigItem(
            keyName = "replacementDiskOfReturningBlackout",
            name = "Blackout",
            description = "Replace Blackout teleport location name.",
            section = SECTION_DISK_OF_RETURNING,
            position = POSITION_DISK_OF_RETURNING + 2
    )
    default String replacementDiskOfReturningBlackout() {
        return "";
    }
}