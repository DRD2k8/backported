package com.drd.backported.util;

import com.drd.backported.Backported;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PALE_OAK_LOGS = tag("pale_oak_logs");

        private static TagKey<Block> tagMod(String modId, String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(modId, name));
        }

        private static TagKey<Block> tag(String name) {
            return tagMod(Backported.MOD_ID, name);
        }

        private static TagKey<Block> tagForge(String name) {
            return tagMod("forge", name);
        }

        private static TagKey<Block> tagFabric(String name) {
            return tagMod("c", name);
        }
    }

    public static class Items {
        public static final TagKey<Item> PALE_OAK_LOGS = tag("pale_oak_logs");
        public static final TagKey<Item> METAL_NUGGETS = tag("metal_nuggets");
        public static final TagKey<Item> FORGE_COPPER_NUGGETS = tagForge("nuggets/copper");
        public static final TagKey<Item> FABRIC_COPPER_NUGGETS = tagFabric("copper_nuggets");
        public static final TagKey<Item> FABRIC_NUGGETS = tagFabric("nuggets");
        public static final TagKey<Item> FABRIC_WOODEN_RODS = tagFabric("wooden_rods");
        public static final TagKey<Item> STICKS = tag("sticks");
        public static final TagKey<Item> SPEARS = tag("spears");

        private static TagKey<Item> tagMod(String modId, String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(modId, name));
        }

        private static TagKey<Item> tag(String name) {
            return tagMod(Backported.MOD_ID, name);
        }

        private static TagKey<Item> tagForge(String name) {
            return tagMod("forge", name);
        }

        private static TagKey<Item> tagFabric(String name) {
            return tagMod("c", name);
        }
    }
}
