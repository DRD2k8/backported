package com.drd.backported.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.drd.backported.Backported;

@Mod(Backported.MOD_ID)
public final class BackportedForge {
    public BackportedForge() {
        EventBuses.registerModEventBus(Backported.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        Backported.init();
    }
}
