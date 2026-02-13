package com.drd.backported.entity.handler;

import com.drd.backported.init.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;

public class GhastDropHandler {
    public static void handleGhastKilledByReflectedFireball(LivingEntity entity, DamageSource source) {
        if (!(entity instanceof Ghast)) return;

        Entity direct = source.getDirectEntity();
        if (!(direct instanceof Fireball fireball)) return;

        Entity owner = fireball.getOwner();
        if (!(owner instanceof Player)) return;

        entity.spawnAtLocation(ModItems.MUSIC_DISC_TEARS.get());
    }
}
