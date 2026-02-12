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
    }

    private static void addItemsToColoredBlocksTab(FabricItemGroupEntries entries) {
    }

    private static void addItemsToNaturalBlocksTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.CHERRY_LOG,
                ModBlocks.PALE_OAK_LOG.get()
        );
    }

    private static void addItemsToFunctionalBlocksTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.CHERRY_HANGING_SIGN,
                ModItems.PALE_OAK_SIGN.get(),
                ModItems.PALE_OAK_HANGING_SIGN.get()
        );
    }

    private static void addItemsToRedstoneBlocksTab(FabricItemGroupEntries entries) {
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
        entries.addAfter(Items.EGG,
                ModItems.WIND_CHARGE.get());
    }

    private static void addItemsToFoodTab(FabricItemGroupEntries entries) {
    }

    private static void addItemsToIngredientsTab(FabricItemGroupEntries entries) {
        entries.addBefore(Items.IRON_NUGGET,
                ModItems.COPPER_NUGGET.get());
        entries.addAfter(Items.BLAZE_ROD,
                ModItems.BREEZE_ROD.get(),
                ModBlocks.HEAVY_CORE.get());
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
