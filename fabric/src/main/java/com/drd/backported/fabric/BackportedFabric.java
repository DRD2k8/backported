package com.drd.backported.fabric;

import com.drd.backported.fabric.item.CreativeTabPlacements;
import com.drd.backported.util.ModSoundTypes;
import net.fabricmc.api.ModInitializer;

import com.drd.backported.Backported;

public final class BackportedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Backported.init();
        CreativeTabPlacements.registerTabPlacements();

        ModSoundTypes.init();
    }
}
