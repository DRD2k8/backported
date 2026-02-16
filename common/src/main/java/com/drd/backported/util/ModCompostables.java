package com.drd.backported.util;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.platform.CommonPlatformUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class ModCompostables {
    public static void registerCompostables() {
        add(ModBlocks.BUSH.get(), 0.3f);
        // add(ModBlocks.CACTUS_FLOWER.get(), 0.3f);
        add(ModBlocks.FIREFLY_BUSH.get(), 0.3f);
        // add(ModBlocks.LEAF_LITTER.get(), 0.3f);
        // add(ModBlocks.PALE_HANGING_MOSS.get(), 0.3f);
        // add(ModBlocks.PALE_MOSS_CARPET.get(), 0.3f);
        // add(ModBlocks.SHORT_DRY_GRASS.get(), 0.3f);
        // add(ModBlocks.TALL_DRY_GRASS.get(), 0.3f);
        // add(ModBlocks.WILDFLOWERS.get(), 0.3f);
        // add(ModBlocks.PALE_MOSS_BLOCK.get(), 0.65f);
    }

    public static void add(Item item, float chance) {
        CommonPlatformUtils.registerCompostable(item, chance);
    }

    public static void add(Block block, float chance) {
        Item item = block.asItem();
        if (item != Items.AIR) {
            CommonPlatformUtils.registerCompostable(item, chance);
        }
    }
}
