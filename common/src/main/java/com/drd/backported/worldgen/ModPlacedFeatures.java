package com.drd.backported.worldgen;

import com.drd.backported.Backported;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> PATCH_BUSH = registerKey("patch_bush");
    public static final ResourceKey<PlacedFeature> PATCH_FIREFLY_BUSH_SWAMP = registerKey("patch_firefly_bush_swamp");
    public static final ResourceKey<PlacedFeature> PATCH_FIREFLY_BUSH_NEAR_WATER = registerKey("patch_firefly_bush_near_water");
    public static final ResourceKey<PlacedFeature> PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP = registerKey("patch_firefly_bush_near_water_swamp");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Backported.MOD_ID, name));
    }
}
