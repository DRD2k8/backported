package com.drd.backported.entity.handler;

import com.drd.backported.init.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Zombie;

public class ChickenJockeyDropHandler {
    public static void handleBabyChickenJockeyDrop(LivingEntity entity, DamageSource source) {
        if (!(entity instanceof Zombie zombie)) return;

        if (!zombie.isBaby()) return;

        Entity vehicle = zombie.getVehicle();
        if (!(vehicle instanceof Chicken)) return;

        entity.spawnAtLocation(ModItems.MUSIC_DISC_LAVA_CHICKEN.get());
    }
}
