package com.drd.backported.forge.world;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MobSpawning {
    public MobSpawning() {
    }

    @SubscribeEvent
    public static void entitySpawning(SpawnPlacementRegisterEvent event) {
        event.register(EntityType.WOLF, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wolf::checkWolfSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}
