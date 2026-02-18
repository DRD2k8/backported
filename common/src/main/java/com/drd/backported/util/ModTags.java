package com.drd.backported.util;

import com.drd.backported.Backported;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PALE_OAK_LOGS = tag("pale_oak_logs");
        public static final TagKey<Block> WOODEN_SHELVES = tag("wooden_shelves");

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
        public static final TagKey<Item> FABRIC_STRING = tagFabric("string");
        public static final TagKey<Item> STRING = tag("string");
        public static final TagKey<Item> WOODEN_SHELVES = tag("wooden_shelves");
        public static final TagKey<Item> SPEARS = tag("spears");
        public static final TagKey<Item> BOLT_ARMOR_TRIM_SMITHING_TEMPLATE_INGREDIENTS = tag("bolt_armor_trim_smithing_template_ingredients");
        public static final TagKey<Item> FABRIC_SHEARS = tagFabric("shears");
        public static final TagKey<Item> SHEARS = tag("shears");

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

    public static class Biomes {
        // Wolves
        public static final TagKey<Biome> SPAWNS_WOODS_WOLF = tag("spawns_woods_wolf");
        public static final TagKey<Biome> SPAWNS_ASHEN_WOLF = tag("spawns_ashen_wolf");
        public static final TagKey<Biome> SPAWNS_BLACK_WOLF = tag("spawns_black_wolf");
        public static final TagKey<Biome> SPAWNS_CHESTNUT_WOLF = tag("spawns_chestnut_wolf");
        public static final TagKey<Biome> SPAWNS_RUSTY_WOLF = tag("spawns_rusty_wolf");
        public static final TagKey<Biome> SPAWNS_SPOTTED_WOLF = tag("spawns_spotted_wolf");
        public static final TagKey<Biome> SPAWNS_STRIPED_WOLF = tag("spawns_striped_wolf");
        public static final TagKey<Biome> SPAWNS_SNOWY_WOLF = tag("spawns_snowy_wolf");
        public static final TagKey<Biome> SPAWNS_PALE_WOLF = tag("spawns_pale_wolf");

        // Chickens
        public static final TagKey<Biome> SPAWNS_COLD_CHICKEN = tag("spawns_cold_chicken");
        public static final TagKey<Biome> SPAWNS_WARM_CHICKEN = tag("spawns_warm_chicken");
        public static final TagKey<Biome> SPAWNS_TEMPERATE_CHICKEN = tag("spawns_temperate_chicken");

        // Cows
        public static final TagKey<Biome> SPAWNS_COLD_COW = tag("spawns_cold_cow");
        public static final TagKey<Biome> SPAWNS_WARM_COW = tag("spawns_warm_cow");
        public static final TagKey<Biome> SPAWNS_TEMPERATE_COW = tag("spawns_temperate_cow");

        // Pigs
        public static final TagKey<Biome> SPAWNS_COLD_PIG = tag("spawns_cold_pig");
        public static final TagKey<Biome> SPAWNS_WARM_PIG = tag("spawns_warm_pig");
        public static final TagKey<Biome> SPAWNS_TEMPERATE_PIG = tag("spawns_temperate_pig");

        private static TagKey<Biome> tagMod(String modId, String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(modId, name));
        }

        private static TagKey<Biome> tag(String name) {
            return tagMod(Backported.MOD_ID, name);
        }

        private static TagKey<Biome> tagForge(String name) {
            return tagMod("forge", name);
        }

        private static TagKey<Biome> tagFabric(String name) {
            return tagMod("c", name);
        }
    }

    public static class BannerPatterns {
        // Tricky Trials
        public static final TagKey<BannerPattern> FLOW_BANNER_PATTERN = tag("pattern_item/flow");
        public static final TagKey<BannerPattern> GUSTER_BANNER_PATTERN = tag("pattern_item/guster");

        // Bundles of Bravery
        public static final TagKey<BannerPattern> FIELD_MASONED_BANNER_PATTERN = tag("pattern_item/field_masoned");
        public static final TagKey<BannerPattern> BORDURE_INDENTED_BANNER_PATTERN = tag("pattern_item/bordure_indented");

        private static TagKey<BannerPattern> tag(String name) {
            return TagKey.create(Registries.BANNER_PATTERN, new ResourceLocation(Backported.MOD_ID, name));
        }
    }
}
