package com.drd.backported.forge;

import com.drd.backported.forge.packets.PacketHandler;
import com.drd.backported.util.ModSoundTypes;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.drd.backported.Backported;

@Mod(Backported.MOD_ID)
public final class BackportedForge {
    public BackportedForge() {
        EventBuses.registerModEventBus(Backported.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        Backported.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModSoundTypes.init();
            PacketHandler.init();
        });
    }
}
