package com.drd.backported.util;

import com.drd.backported.init.ModSounds;
import net.minecraft.world.level.block.SoundType;

public class ModSoundTypes {
    // Bats and Pots
    public static SoundType DECORATED_POT = new SoundType(
            1f,
            1f,
            ModSounds.DECORATED_POT_BREAK.get(),
            ModSounds.DECORATED_POT_STEP.get(),
            ModSounds.DECORATED_POT_PLACE.get(),
            ModSounds.DECORATED_POT_HIT.get(),
            ModSounds.DECORATED_POT_FALL.get()
    );

    // Tricky Trials
    public static SoundType COPPER_BULB = new SoundType(
            1f,
            1f,
            ModSounds.COPPER_BULB_BREAK.get(),
            ModSounds.COPPER_BULB_STEP.get(),
            ModSounds.COPPER_BULB_PLACE.get(),
            ModSounds.COPPER_BULB_HIT.get(),
            ModSounds.COPPER_BULB_FALL.get()
    );
    public static SoundType COPPER_GRATE = new SoundType(
            1f,
            1f,
            ModSounds.COPPER_GRATE_BREAK.get(),
            ModSounds.COPPER_GRATE_STEP.get(),
            ModSounds.COPPER_GRATE_PLACE.get(),
            ModSounds.COPPER_GRATE_HIT.get(),
            ModSounds.COPPER_GRATE_FALL.get()
    );
    public static SoundType HEAVY_CORE = new SoundType(
            1f,
            1f,
            ModSounds.HEAVY_CORE_BREAK.get(),
            ModSounds.HEAVY_CORE_STEP.get(),
            ModSounds.HEAVY_CORE_PLACE.get(),
            ModSounds.HEAVY_CORE_HIT.get(),
            ModSounds.HEAVY_CORE_FALL.get()
    );
    public static SoundType POLISHED_TUFF = new SoundType(
            1f,
            1f,
            ModSounds.POLISHED_TUFF_BREAK.get(),
            ModSounds.POLISHED_TUFF_STEP.get(),
            ModSounds.POLISHED_TUFF_PLACE.get(),
            ModSounds.POLISHED_TUFF_HIT.get(),
            ModSounds.POLISHED_TUFF_FALL.get()
    );
    public static SoundType TUFF_BRICKS = new SoundType(
            1f,
            1f,
            ModSounds.TUFF_BRICKS_BREAK.get(),
            ModSounds.TUFF_BRICKS_STEP.get(),
            ModSounds.TUFF_BRICKS_PLACE.get(),
            ModSounds.TUFF_BRICKS_HIT.get(),
            ModSounds.TUFF_BRICKS_FALL.get()
    );

    // The Garden Awakens
    public static SoundType RESIN = new SoundType(
            1f,
            1f,
            ModSounds.RESIN_BREAK.get(),
            ModSounds.RESIN_STEP.get(),
            ModSounds.RESIN_PLACE.get(),
            ModSounds.RESIN_HIT.get(),
            ModSounds.RESIN_FALL.get()
    );
    public static SoundType RESIN_BRICKS = new SoundType(
            1f,
            1f,
            ModSounds.RESIN_BRICKS_BREAK.get(),
            ModSounds.RESIN_BRICKS_STEP.get(),
            ModSounds.RESIN_BRICKS_PLACE.get(),
            ModSounds.RESIN_BRICKS_HIT.get(),
            ModSounds.RESIN_BRICKS_FALL.get()
    );

    public static void init() {
    }
}
