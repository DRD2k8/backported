package com.drd.backported;

import com.drd.backported.init.*;
import com.drd.backported.util.ModSoundTypes;

public final class Backported {
    public static final String MOD_ID = "backported";

    public static void init() {
        ModBlocks.register();
        ModEntities.register();
        ModItems.register();
        ModSounds.register();

        ModSoundTypes.init();
    }
}
