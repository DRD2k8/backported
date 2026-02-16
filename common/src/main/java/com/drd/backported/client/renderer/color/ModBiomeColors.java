package com.drd.backported.client.renderer.color;

import com.drd.backported.worldgen.biome.ModBiomeSpecialEffects;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeColors {
    private final ColorResolver DRY_FOLIAGE_COLOR_RESOLVER = (biome, pos, color) -> {
        return getDryFoliageColor();
    };

    private final ClimateSettings climateSettings;
    private final ModBiomeSpecialEffects effects;

    public ModBiomeColors(ClimateSettings climateSettings, ModBiomeSpecialEffects effects) {
        this.climateSettings = climateSettings;
        this.effects = effects;
    }

    public int getDryFoliageColor() {
        return effects.getDryFoliageColorOverride()
                .orElseGet(this::getDryFoliageColorFromTexture);
    }

    private int getDryFoliageColorFromTexture() {
        double t = Mth.clamp(climateSettings.temperature, 0.0F, 1.0F);
        double h = Mth.clamp(climateSettings.downfall, 0.0F, 1.0F);
        return DryFoliageColor.get(t, h);
    }

    public record ClimateSettings(
            boolean hasPrecipitation,
            float temperature,
            Biome.TemperatureModifier temperatureModifier,
            float downfall
    ) {
        public static final MapCodec<ClimateSettings> CODEC =
                RecordCodecBuilder.mapCodec(instance -> instance.group(
                        Codec.BOOL.fieldOf("has_precipitation").forGetter(ClimateSettings::hasPrecipitation),
                        Codec.FLOAT.fieldOf("temperature").forGetter(ClimateSettings::temperature),
                        Biome.TemperatureModifier.CODEC.optionalFieldOf("temperature_modifier", Biome.TemperatureModifier.NONE)
                                .forGetter(ClimateSettings::temperatureModifier),
                        Codec.FLOAT.fieldOf("downfall").forGetter(ClimateSettings::downfall)
                ).apply(instance, ClimateSettings::new));
    }
}
