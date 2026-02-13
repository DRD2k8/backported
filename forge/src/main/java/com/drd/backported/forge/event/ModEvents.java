package com.drd.backported.forge.event;

import com.drd.backported.Backported;
import com.drd.backported.entity.handler.ChickenJockeyDropHandler;
import com.drd.backported.entity.handler.GhastDropHandler;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Backported.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        GhastDropHandler.handleGhastKilledByReflectedFireball(
                event.getEntity(),
                event.getSource()
        );
        ChickenJockeyDropHandler.handleBabyChickenJockeyDrop(
                event.getEntity(),
                event.getSource()
        );
    }
}
