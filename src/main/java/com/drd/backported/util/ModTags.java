package com.drd.backported.util;

import com.drd.backported.Backported;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tagMod(String modId, String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(modId, name));
        }

        private static TagKey<Block> tag(String name) {
            return tagMod(Backported.MOD_ID, name);
        }

        private static TagKey<Block> tagForge(String name) {
            return tagMod("forge", name);
        }
    }

    public static class Items {
        public static final TagKey<Item> METAL_NUGGETS = tag("metal_nuggets");
        public static final TagKey<Item> COPPER_NUGGETS = tagForge("nuggets/copper");

        private static TagKey<Item> tagMod(String modId, String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, name));
        }

        private static TagKey<Item> tag(String name) {
            return tagMod(Backported.MOD_ID, name);
        }

        private static TagKey<Item> tagForge(String name) {
            return tagMod("forge", name);
        }
    }
}
