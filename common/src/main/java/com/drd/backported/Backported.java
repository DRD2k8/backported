package com.drd.backported;

import com.drd.backported.init.*;
import com.drd.backported.util.ModCompostables;
import com.drd.backported.util.ModFuels;
import com.mojang.logging.LogUtils;
import dev.architectury.event.events.common.LifecycleEvent;
import org.slf4j.Logger;

public final class Backported {
    public static final String MOD_ID = "backported";
    public static final Logger LOGGER = LogUtils.getLogger();

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
        ModSherds.register();

        LifecycleEvent.SETUP.register(() -> {
            ModFuels.registerFuels();
            ModCompostables.registerCompostables();
        });
    }
}
