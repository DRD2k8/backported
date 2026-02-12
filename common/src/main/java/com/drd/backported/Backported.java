package com.drd.backported;

import com.drd.backported.init.*;

public final class Backported {
    public static final String MOD_ID = "backported";

    public static void init() {
        ModBlocks.register();
        ModBlockEntities.register();
        ModEnchantments.register();
        ModEntities.register();
        ModItems.register();
        ModPaintings.register();
        ModSounds.register();
    }
}
