package com.drd.backported.fabric;

import com.drd.backported.fabric.item.CreativeTabPlacements;
import com.drd.backported.fabric.util.ModLootModifiers;
import com.drd.backported.fabric.util.SpecialMobDrops;
import com.drd.backported.fabric.world.MobSpawning;
import com.drd.backported.util.ModSoundTypes;
import com.drd.backported.util.ModStrippables;
import net.fabricmc.api.ModInitializer;

import com.drd.backported.Backported;

public final class BackportedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Backported.init();
        SpecialMobDrops.init();
        CreativeTabPlacements.registerTabPlacements();
        ModLootModifiers.modifyLootTables();
        ModStrippables.register();

        ModSoundTypes.init();
        MobSpawning.addAndRemoveSpawns();
    }
}
