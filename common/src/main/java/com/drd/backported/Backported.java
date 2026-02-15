package com.drd.backported;

import com.drd.backported.init.*;
import com.drd.backported.util.ModFuels;
import dev.architectury.event.events.common.LifecycleEvent;

public final class Backported {
    public static final String MOD_ID = "backported";

    public static void init() {
        ModSounds.register();
        ModBannerPatterns.register();
        ModBlocks.register();
        ModBlockEntities.register();
        ModEnchantments.register();
        ModEntities.register();
        ModItems.register();
        ModPaintings.register();
        ModParticles.register();

        LifecycleEvent.SETUP.register(() -> {
            ModFuels.registerFuels();
        });
    }
}
