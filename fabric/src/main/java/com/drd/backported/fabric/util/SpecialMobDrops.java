package com.drd.backported.fabric.util;

import com.drd.backported.entity.handler.GhastDropHandler;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

public class SpecialMobDrops {
    public static void init() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, amount) -> {
            GhastDropHandler.handleGhastKilledByReflectedFireball(entity, damageSource);
            return true;
        });
    }
}
