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
        }

        if (tab == CreativeModeTabs.NATURAL_BLOCKS) {
            entries.addAfter(Items.CHERRY_LOG,
                    ModBlocks.PALE_OAK_LOG.get()
            );
        }

        if (tab == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            entries.addAfter(Items.CHERRY_HANGING_SIGN,
                    ModItems.PALE_OAK_HANGING_SIGN.get(),
                    ModItems.PALE_OAK_SIGN.get()
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
            entries.addAfter(Items.EGG,
                    ModItems.WIND_CHARGE.get()
            );
        }

        if (tab == CreativeModeTabs.INGREDIENTS) {
            entries.addBefore(Items.IRON_NUGGET,
                    ModItems.COPPER_NUGGET.get()
            );
            entries.addAfter(Items.BLAZE_ROD,
                    ModBlocks.HEAVY_CORE.get(),
                    ModItems.BREEZE_ROD.get()
            );
        }
    }
}
