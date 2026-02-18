package com.drd.backported.fabric.item;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class CreativeTabPlacements {
    private static void addItemsToBuildingBlocksTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.CHERRY_BUTTON,
                ModBlocks.PALE_OAK_LOG.get(),
                ModBlocks.PALE_OAK_WOOD.get(),
                ModBlocks.STRIPPED_PALE_OAK_LOG.get(),
                ModBlocks.STRIPPED_PALE_OAK_WOOD.get(),
                ModBlocks.PALE_OAK_PLANKS.get(),
                ModBlocks.PALE_OAK_STAIRS.get(),
                ModBlocks.PALE_OAK_SLAB.get(),
                ModBlocks.PALE_OAK_FENCE.get(),
                ModBlocks.PALE_OAK_FENCE_GATE.get(),
                ModBlocks.PALE_OAK_DOOR.get(),
                ModBlocks.PALE_OAK_TRAPDOOR.get(),
                ModBlocks.PALE_OAK_PRESSURE_PLATE.get(),
                ModBlocks.PALE_OAK_BUTTON.get());
        entries.addAfter(Items.REINFORCED_DEEPSLATE,
                Items.TUFF,
                ModBlocks.TUFF_STAIRS.get(),
                ModBlocks.TUFF_SLAB.get(),
                ModBlocks.TUFF_WALL.get(),
                ModBlocks.CHISELED_TUFF.get(),
                ModBlocks.POLISHED_TUFF.get(),
                ModBlocks.POLISHED_TUFF_STAIRS.get(),
                ModBlocks.POLISHED_TUFF_SLAB.get(),
                ModBlocks.POLISHED_TUFF_WALL.get(),
                ModBlocks.TUFF_BRICKS.get(),
                ModBlocks.TUFF_BRICK_STAIRS.get(),
                ModBlocks.TUFF_BRICK_SLAB.get(),
                ModBlocks.TUFF_BRICK_WALL.get(),
                ModBlocks.CHISELED_TUFF.get()
        );
        entries.addAfter(Items.MUD_BRICK_WALL,
                ModBlocks.RESIN_BRICKS.get(),
                ModBlocks.RESIN_BRICK_STAIRS.get(),
                ModBlocks.RESIN_BRICK_SLAB.get(),
                ModBlocks.RESIN_BRICK_WALL.get(),
                ModBlocks.CHISELED_RESIN_BRICKS.get()
        );
        entries.addAfter(Items.COPPER_BLOCK,
                ModBlocks.CHISELED_COPPER.get(),
                ModBlocks.COPPER_GRATE.get()
        );
        entries.addAfter(Items.CUT_COPPER_SLAB,
                ModBlocks.COPPER_BARS.get(),
                ModBlocks.COPPER_DOOR.get(),
                ModBlocks.COPPER_TRAPDOOR.get(),
                ModBlocks.COPPER_BULB.get(),
                ModBlocks.COPPER_CHAIN.get()
        );
        entries.addAfter(Items.EXPOSED_COPPER,
                ModBlocks.EXPOSED_CHISELED_COPPER.get(),
                ModBlocks.EXPOSED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.EXPOSED_CUT_COPPER_SLAB,
                ModBlocks.EXPOSED_COPPER_BARS.get(),
                ModBlocks.EXPOSED_COPPER_DOOR.get(),
                ModBlocks.EXPOSED_COPPER_TRAPDOOR.get(),
                ModBlocks.EXPOSED_COPPER_BULB.get(),
                ModBlocks.EXPOSED_COPPER_CHAIN.get()
        );
        entries.addAfter(Items.WEATHERED_COPPER,
                ModBlocks.WEATHERED_CHISELED_COPPER.get(),
                ModBlocks.WEATHERED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.WEATHERED_CUT_COPPER_SLAB,
                ModBlocks.WEATHERED_COPPER_BARS.get(),
                ModBlocks.WEATHERED_COPPER_DOOR.get(),
                ModBlocks.WEATHERED_COPPER_TRAPDOOR.get(),
                ModBlocks.WEATHERED_COPPER_BULB.get(),
                ModBlocks.WEATHERED_COPPER_CHAIN.get()
        );
        entries.addAfter(Items.OXIDIZED_COPPER,
                ModBlocks.OXIDIZED_CHISELED_COPPER.get(),
                ModBlocks.OXIDIZED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.OXIDIZED_CUT_COPPER_SLAB,
                ModBlocks.OXIDIZED_COPPER_BARS.get(),
                ModBlocks.OXIDIZED_COPPER_DOOR.get(),
                ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get(),
                ModBlocks.OXIDIZED_COPPER_BULB.get(),
                ModBlocks.OXIDIZED_COPPER_CHAIN.get()
        );
        entries.addAfter(Items.WAXED_COPPER_BLOCK,
                ModBlocks.WAXED_CHISELED_COPPER.get(),
                ModBlocks.WAXED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.WAXED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_COPPER_BARS.get(),
                ModBlocks.WAXED_COPPER_DOOR.get(),
                ModBlocks.WAXED_COPPER_TRAPDOOR.get(),
                ModBlocks.WAXED_COPPER_BULB.get(),
                ModBlocks.WAXED_COPPER_CHAIN.get()
        );
        entries.addAfter(Items.WAXED_EXPOSED_COPPER,
                ModBlocks.WAXED_EXPOSED_CHISELED_COPPER.get(),
                ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.WAXED_EXPOSED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(),
                ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get(),
                ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get(),
                ModBlocks.WAXED_EXPOSED_COPPER_BULB.get(),
                ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get()
        );
        entries.addAfter(Items.WAXED_WEATHERED_COPPER,
                ModBlocks.WAXED_WEATHERED_CHISELED_COPPER.get(),
                ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(),
                ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get(),
                ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get(),
                ModBlocks.WAXED_WEATHERED_COPPER_BULB.get(),
                ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get()
        );
        entries.addAfter(Items.WAXED_OXIDIZED_COPPER,
                ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER.get(),
                ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get()
        );
        entries.addAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB,
                ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(),
                ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get(),
                ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get(),
                ModBlocks.WAXED_OXIDIZED_COPPER_BULB.get(),
                ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get()
        );
    }

    private static void addItemsToColoredBlocksTab(FabricItemGroupEntries entries) {
    }

    private static void addItemsToNaturalBlocksTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.CHERRY_LOG,
                ModBlocks.PALE_OAK_LOG.get()
        );
        entries.addAfter(Items.FERN,
                ModBlocks.BUSH.get()
        );
        entries.addAfter(Items.SPORE_BLOSSOM,
                ModBlocks.FIREFLY_BUSH.get()
        );
        entries.addAfter(Items.HONEY_BLOCK,
                ModBlocks.RESIN_BLOCK.get()
        );
    }

    private static void addItemsToFunctionalBlocksTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.CHISELED_BOOKSHELF,
                ModBlocks.OAK_SHELF.get(),
                ModBlocks.SPRUCE_SHELF.get(),
                ModBlocks.BIRCH_SHELF.get(),
                ModBlocks.JUNGLE_SHELF.get(),
                ModBlocks.ACACIA_SHELF.get(),
                ModBlocks.DARK_OAK_SHELF.get(),
                ModBlocks.MANGROVE_SHELF.get(),
                ModBlocks.CHERRY_SHELF.get(),
                ModBlocks.PALE_OAK_SHELF.get(),
                ModBlocks.BAMBOO_SHELF.get(),
                ModBlocks.CRIMSON_SHELF.get(),
                ModBlocks.WARPED_SHELF.get()
        );
        entries.addAfter(Items.CHERRY_HANGING_SIGN,
                ModItems.PALE_OAK_SIGN.get(),
                ModItems.PALE_OAK_HANGING_SIGN.get()
        );
    }

    private static void addItemsToRedstoneBlocksTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.JUKEBOX,
                Items.DECORATED_POT
        );
    }

    private static void addItemsToToolsTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.STONE_HOE,
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_HOE.get());
        entries.addAfter(Items.CHERRY_CHEST_BOAT,
                ModItems.PALE_OAK_BOAT.get(),
                ModItems.PALE_OAK_CHEST_BOAT.get()
        );
        entries.addAfter(Items.MUSIC_DISC_11,
                ModItems.MUSIC_DISC_CREATOR_MUSIC_BOX.get()
        );
        entries.addAfter(Items.MUSIC_DISC_WAIT,
                ModItems.MUSIC_DISC_CREATOR.get(),
                ModItems.MUSIC_DISC_PRECIPICE.get()
        );
        entries.addAfter(Items.MUSIC_DISC_RELIC,
                ModItems.MUSIC_DISC_TEARS.get(),
                ModItems.MUSIC_DISC_LAVA_CHICKEN.get()
        );
    }

    private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.STONE_SWORD,
                ModItems.COPPER_SWORD.get());
        entries.addBefore(Items.WOODEN_AXE,
                ModItems.WOODEN_SPEAR.get(),
                ModItems.STONE_SPEAR.get(),
                ModItems.COPPER_SPEAR.get(),
                ModItems.IRON_SPEAR.get(),
                ModItems.GOLDEN_SPEAR.get(),
                ModItems.DIAMOND_SPEAR.get(),
                ModItems.NETHERITE_SPEAR.get());
        entries.addAfter(Items.STONE_AXE,
                ModItems.COPPER_AXE.get());
        entries.addAfter(Items.TRIDENT,
                ModItems.MACE.get());
        entries.addAfter(Items.LEATHER_BOOTS,
                ModItems.COPPER_HELMET.get(),
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COPPER_BOOTS.get());
        entries.addAfter(Items.LEATHER_HORSE_ARMOR,
                ModItems.COPPER_HORSE_ARMOR.get()
        );
        entries.addAfter(Items.DIAMOND_HORSE_ARMOR,
                ModItems.NETHERITE_HORSE_ARMOR.get(),
                ModItems.WOLF_ARMOR.get()
        );
        entries.addAfter(Items.EGG,
                ModItems.WIND_CHARGE.get());
    }

    private static void addItemsToFoodTab(FabricItemGroupEntries entries) {
    }

    private static void addItemsToIngredientsTab(FabricItemGroupEntries entries) {
        entries.addBefore(Items.IRON_NUGGET,
                ModItems.COPPER_NUGGET.get());
        entries.addAfter(Items.HONEYCOMB,
                ModBlocks.RESIN_CLUMP.get());
        entries.addAfter(Items.SCUTE,
                ModItems.ARMADILLO_SCUTE.get());
        entries.addAfter(Items.BLAZE_ROD,
                ModItems.BREEZE_ROD.get(),
                ModBlocks.HEAVY_CORE.get());
        entries.addAfter(Items.NETHER_BRICK,
                ModItems.RESIN_BRICK.get());
        entries.addBefore(Items.FLOWER_BANNER_PATTERN,
                ModItems.FIELD_MASONED_BANNER_PATTERN.get(),
                ModItems.BORDURE_INDENTED_BANNER_PATTERN.get()
        );
        entries.addAfter(Items.PIGLIN_BANNER_PATTERN,
                ModItems.FLOW_BANNER_PATTERN.get(),
                ModItems.GUSTER_BANNER_PATTERN.get()
        );
        entries.addAfter(Items.EXPLORER_POTTERY_SHERD,
                ModItems.FLOW_POTTERY_SHERD.get()
        );
        entries.addAfter(Items.FRIEND_POTTERY_SHERD,
                ModItems.GUSTER_POTTERY_SHERD.get()
        );
        entries.addAfter(Items.PRIZE_POTTERY_SHERD,
                ModItems.SCRAPE_POTTERY_SHERD.get()
        );
        entries.addAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
                ModItems.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                ModItems.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE.get()
        );
    }

    private static void addItemsToSpawnEggsTab(FabricItemGroupEntries entries) {
    }

    private static void addItemsToOperatorUtilitiesTab(FabricItemGroupEntries entries) {
    }

    public static void registerTabPlacements() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(CreativeTabPlacements::addItemsToBuildingBlocksTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(CreativeTabPlacements::addItemsToColoredBlocksTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(CreativeTabPlacements::addItemsToNaturalBlocksTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(CreativeTabPlacements::addItemsToFunctionalBlocksTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(CreativeTabPlacements::addItemsToRedstoneBlocksTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(CreativeTabPlacements::addItemsToToolsTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(CreativeTabPlacements::addItemsToCombatTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(CreativeTabPlacements::addItemsToFoodTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(CreativeTabPlacements::addItemsToIngredientsTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(CreativeTabPlacements::addItemsToSpawnEggsTab);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.OP_BLOCKS).register(CreativeTabPlacements::addItemsToOperatorUtilitiesTab);
    }
}
