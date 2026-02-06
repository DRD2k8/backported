package com.drd.backported.util;

import com.drd.backported.init.ModSounds;
import net.minecraft.world.level.block.SoundType;

public class ModSoundTypes {
    public static final SoundType HEAVY_CORE = new SoundType(
            1f,
            1f,
            ModSounds.HEAVY_CORE_BREAK.get(),
            ModSounds.HEAVY_CORE_STEP.get(),
            ModSounds.HEAVY_CORE_PLACE.get(),
            ModSounds.HEAVY_CORE_HIT.get(),
            ModSounds.HEAVY_CORE_FALL.get()
    );
}
