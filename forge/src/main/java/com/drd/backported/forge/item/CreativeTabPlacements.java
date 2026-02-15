package com.drd.backported.forge.item;

import com.drd.backported.Backported;
import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Backported.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabPlacements {
    interface Entries {
        void addBefore(ItemLike reference, ItemLike... values);
        void addAfter(ItemLike reference, ItemLike... values);
    }

    @SubscribeEvent
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        var tab = event.getTabKey();
        var entries = new Entries() {
            @Override
            public void addBefore(ItemLike reference, ItemLike... values) {
                for (ItemLike value : values) {
                    event.getEntries().putBefore(new ItemStack(reference), new ItemStack(value), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                }
            }

            @Override
            public void addAfter(ItemLike reference, ItemLike... values) {
                for (ItemLike value : values) {
                    event.getEntries().putAfter(new ItemStack(reference), new ItemStack(value), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                }
            }
        };

        if (tab == CreativeModeTabs.BUILDING_BLOCKS) {
            entries.addAfter(Items.CHERRY_BUTTON,
                    ModBlocks.PALE_OAK_BUTTON.get(),
                    ModBlocks.PALE_OAK_PRESSURE_PLATE.get(),
                    ModBlocks.PALE_OAK_TRAPDOOR.get(),
                    ModBlocks.PALE_OAK_DOOR.get(),
                    ModBlocks.PALE_OAK_FENCE_GATE.get(),
                    ModBlocks.PALE_OAK_FENCE.get(),
                    ModBlocks.PALE_OAK_SLAB.get(),
                    ModBlocks.PALE_OAK_STAIRS.get(),
                    ModBlocks.PALE_OAK_PLANKS.get(),
                    ModBlocks.STRIPPED_PALE_OAK_WOOD.get(),
                    ModBlocks.STRIPPED_PALE_OAK_LOG.get(),
                    ModBlocks.PALE_OAK_WOOD.get(),
                    ModBlocks.PALE_OAK_LOG.get()
            );
            entries.addAfter(Items.REINFORCED_DEEPSLATE,
                    ModBlocks.CHISELED_TUFF_BRICKS.get(),
                    ModBlocks.TUFF_BRICK_WALL.get(),
                    ModBlocks.TUFF_BRICK_SLAB.get(),
                    ModBlocks.TUFF_BRICK_STAIRS.get(),
                    ModBlocks.TUFF_BRICKS.get(),
                    ModBlocks.POLISHED_TUFF_WALL.get(),
                    ModBlocks.POLISHED_TUFF_SLAB.get(),
                    ModBlocks.POLISHED_TUFF_STAIRS.get(),
                    ModBlocks.POLISHED_TUFF.get(),
                    ModBlocks.CHISELED_TUFF.get(),
                    ModBlocks.TUFF_WALL.get(),
                    ModBlocks.TUFF_SLAB.get(),
                    ModBlocks.TUFF_STAIRS.get(),
                    Items.TUFF
            );
            entries.addAfter(Items.MUD_BRICK_WALL,
                    ModBlocks.CHISELED_RESIN_BRICKS.get(),
                    ModBlocks.RESIN_BRICK_WALL.get(),
                    ModBlocks.RESIN_BRICK_SLAB.get(),
                    ModBlocks.RESIN_BRICK_STAIRS.get(),
                    ModBlocks.RESIN_BRICKS.get()
            );
            entries.addAfter(Items.COPPER_BLOCK,
                    ModBlocks.COPPER_GRATE.get(),
                    ModBlocks.CHISELED_COPPER.get()
            );
            entries.addAfter(Items.CUT_COPPER_SLAB,
                    ModBlocks.COPPER_CHAIN.get(),
                    ModBlocks.COPPER_BULB.get(),
                    ModBlocks.COPPER_TRAPDOOR.get(),
                    ModBlocks.COPPER_DOOR.get(),
                    ModBlocks.COPPER_BARS.get()
            );
            entries.addAfter(Items.EXPOSED_COPPER,
                    ModBlocks.EXPOSED_COPPER_GRATE.get(),
                    ModBlocks.EXPOSED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.EXPOSED_CUT_COPPER_SLAB,
                    ModBlocks.EXPOSED_COPPER_CHAIN.get(),
                    ModBlocks.EXPOSED_COPPER_BULB.get(),
                    ModBlocks.EXPOSED_COPPER_TRAPDOOR.get(),
                    ModBlocks.EXPOSED_COPPER_DOOR.get(),
                    ModBlocks.EXPOSED_COPPER_BARS.get()
            );
            entries.addAfter(Items.WEATHERED_COPPER,
                    ModBlocks.WEATHERED_COPPER_GRATE.get(),
                    ModBlocks.WEATHERED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.WEATHERED_CUT_COPPER_SLAB,
                    ModBlocks.WEATHERED_COPPER_CHAIN.get(),
                    ModBlocks.WEATHERED_COPPER_BULB.get(),
                    ModBlocks.WEATHERED_COPPER_TRAPDOOR.get(),
                    ModBlocks.WEATHERED_COPPER_DOOR.get(),
                    ModBlocks.WEATHERED_COPPER_BARS.get()
            );
            entries.addAfter(Items.OXIDIZED_COPPER,
                    ModBlocks.OXIDIZED_COPPER_GRATE.get(),
                    ModBlocks.OXIDIZED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.OXIDIZED_CUT_COPPER_SLAB,
                    ModBlocks.OXIDIZED_COPPER_CHAIN.get(),
                    ModBlocks.OXIDIZED_COPPER_BULB.get(),
                    ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get(),
                    ModBlocks.OXIDIZED_COPPER_DOOR.get(),
                    ModBlocks.OXIDIZED_COPPER_BARS.get()
            );
            entries.addAfter(Items.WAXED_COPPER_BLOCK,
                    ModBlocks.WAXED_COPPER_GRATE.get(),
                    ModBlocks.WAXED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.WAXED_CUT_COPPER_SLAB,
                    ModBlocks.WAXED_COPPER_CHAIN.get(),
                    ModBlocks.WAXED_COPPER_BULB.get(),
                    ModBlocks.WAXED_COPPER_TRAPDOOR.get(),
                    ModBlocks.WAXED_COPPER_DOOR.get(),
                    ModBlocks.WAXED_COPPER_BARS.get()
            );
            entries.addAfter(Items.WAXED_EXPOSED_COPPER,
                    ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get(),
                    ModBlocks.WAXED_EXPOSED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.WAXED_EXPOSED_CUT_COPPER_SLAB,
                    ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(),
                    ModBlocks.WAXED_EXPOSED_COPPER_BULB.get(),
                    ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get(),
                    ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get(),
                    ModBlocks.WAXED_EXPOSED_COPPER_BARS.get()
            );
            entries.addAfter(Items.WAXED_WEATHERED_COPPER,
                    ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get(),
                    ModBlocks.WAXED_WEATHERED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB,
                    ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(),
                    ModBlocks.WAXED_WEATHERED_COPPER_BULB.get(),
                    ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get(),
                    ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get(),
                    ModBlocks.WAXED_WEATHERED_COPPER_BARS.get()
            );
            entries.addAfter(Items.WAXED_OXIDIZED_COPPER,
                    ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get(),
                    ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER.get()
            );
            entries.addAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB,
                    ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(),
                    ModBlocks.WAXED_OXIDIZED_COPPER_BULB.get(),
                    ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get(),
                    ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get(),
                    ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get()
            );
        }

        if (tab == CreativeModeTabs.NATURAL_BLOCKS) {
            entries.addAfter(Items.CHERRY_LOG,
                    ModBlocks.PALE_OAK_LOG.get()
            );
            entries.addAfter(Items.FERN,
                    ModBlocks.BUSH.get()
            );
            entries.addAfter(Items.HONEY_BLOCK,
                    ModBlocks.RESIN_BLOCK.get()
            );
        }

        if (tab == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            entries.addAfter(Items.CHISELED_BOOKSHELF,
                    ModBlocks.WARPED_SHELF.get(),
                    ModBlocks.CRIMSON_SHELF.get(),
                    ModBlocks.BAMBOO_SHELF.get(),
                    ModBlocks.PALE_OAK_SHELF.get(),
                    ModBlocks.CHERRY_SHELF.get(),
                    ModBlocks.MANGROVE_SHELF.get(),
                    ModBlocks.DARK_OAK_SHELF.get(),
                    ModBlocks.ACACIA_SHELF.get(),
                    ModBlocks.JUNGLE_SHELF.get(),
                    ModBlocks.BIRCH_SHELF.get(),
                    ModBlocks.SPRUCE_SHELF.get(),
                    ModBlocks.OAK_SHELF.get()
            );
            entries.addAfter(Items.CHERRY_HANGING_SIGN,
                    ModItems.PALE_OAK_HANGING_SIGN.get(),
                    ModItems.PALE_OAK_SIGN.get()
            );
        }

        if (tab == CreativeModeTabs.REDSTONE_BLOCKS) {
            entries.addAfter(Items.JUKEBOX,
                    Items.DECORATED_POT
            );
        }

        if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            entries.addAfter(Items.STONE_HOE,
                    ModItems.COPPER_HOE.get(),
                    ModItems.COPPER_AXE.get(),
                    ModItems.COPPER_PICKAXE.get(),
                    ModItems.COPPER_SHOVEL.get()
            );
            entries.addAfter(Items.CHERRY_CHEST_BOAT,
                    ModItems.PALE_OAK_CHEST_BOAT.get(),
                    ModItems.PALE_OAK_BOAT.get()
            );
            entries.addAfter(Items.MUSIC_DISC_11,
                    ModItems.MUSIC_DISC_CREATOR_MUSIC_BOX.get()
            );
            entries.addAfter(Items.MUSIC_DISC_WAIT,
                    ModItems.MUSIC_DISC_PRECIPICE.get(),
                    ModItems.MUSIC_DISC_CREATOR.get()
            );
            entries.addAfter(Items.MUSIC_DISC_RELIC,
                    ModItems.MUSIC_DISC_LAVA_CHICKEN.get(),
                    ModItems.MUSIC_DISC_TEARS.get()
            );
        }

        if (tab == CreativeModeTabs.COMBAT) {
            entries.addAfter(Items.STONE_SWORD,
                    ModItems.COPPER_SWORD.get()
            );
            entries.addBefore(Items.WOODEN_AXE,
                    ModItems.WOODEN_SPEAR.get(),
                    ModItems.STONE_SPEAR.get(),
                    ModItems.COPPER_SPEAR.get(),
                    ModItems.IRON_SPEAR.get(),
                    ModItems.GOLDEN_SPEAR.get(),
                    ModItems.DIAMOND_SPEAR.get(),
                    ModItems.NETHERITE_SPEAR.get()
            );
            entries.addAfter(Items.STONE_AXE,
                    ModItems.COPPER_AXE.get()
            );
            entries.addAfter(Items.TRIDENT,
                    ModItems.MACE.get()
            );
            entries.addAfter(Items.LEATHER_BOOTS,
                    ModItems.COPPER_BOOTS.get(),
                    ModItems.COPPER_LEGGINGS.get(),
                    ModItems.COPPER_CHESTPLATE.get(),
                    ModItems.COPPER_HELMET.get()
            );
            entries.addAfter(Items.LEATHER_HORSE_ARMOR,
                    ModItems.COPPER_HORSE_ARMOR.get()
            );
            entries.addAfter(Items.DIAMOND_HORSE_ARMOR,
                    ModItems.NETHERITE_HORSE_ARMOR.get()
            );
            entries.addAfter(Items.EGG,
                    ModItems.WIND_CHARGE.get()
            );
        }

        if (tab == CreativeModeTabs.INGREDIENTS) {
            entries.addBefore(Items.IRON_NUGGET,
                    ModItems.COPPER_NUGGET.get()
            );
            entries.addAfter(Items.HONEYCOMB,
                    ModBlocks.RESIN_CLUMP.get()
            );
            entries.addAfter(Items.BLAZE_ROD,
                    ModBlocks.HEAVY_CORE.get(),
                    ModItems.BREEZE_ROD.get()
            );
            entries.addAfter(Items.NETHER_BRICK,
                    ModItems.RESIN_BRICK.get()
            );
            entries.addBefore(Items.FLOWER_BANNER_PATTERN,
                    ModItems.FIELD_MASONED_BANNER_PATTERN.get(),
                    ModItems.BORDURE_INDENTED_BANNER_PATTERN.get()
            );
            entries.addAfter(Items.PIGLIN_BANNER_PATTERN,
                    ModItems.GUSTER_BANNER_PATTERN.get(),
                    ModItems.FLOW_BANNER_PATTERN.get()
            );
            entries.addAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    ModItems.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
                    ModItems.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE.get()
            );
        }
    }
}
