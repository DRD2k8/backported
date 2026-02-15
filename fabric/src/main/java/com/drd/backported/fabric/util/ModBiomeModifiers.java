package com.drd.backported.fabric.util;

import com.drd.backported.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeModifiers {
    public static void modifyBiomes() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.PATCH_BUSH
        );
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.SWAMP, Biomes.MANGROVE_SWAMP),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.PATCH_FIREFLY_BUSH_SWAMP
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER
        );
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.SWAMP, Biomes.MANGROVE_SWAMP),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP
        );
    }
}
