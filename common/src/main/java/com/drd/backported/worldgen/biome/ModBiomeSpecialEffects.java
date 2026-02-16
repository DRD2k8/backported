package com.drd.backported.worldgen.biome;

import java.util.Optional;

public class ModBiomeSpecialEffects {
    private final Optional<Integer> dryFoliageColorOverride;

    ModBiomeSpecialEffects(Optional<Integer> optional) {
        this.dryFoliageColorOverride = optional;
    }

    public Optional<Integer> getDryFoliageColorOverride() {
        return this.dryFoliageColorOverride;
    }
}
