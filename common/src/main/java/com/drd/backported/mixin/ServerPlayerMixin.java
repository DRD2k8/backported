package com.drd.backported.mixin;

import com.drd.backported.item.spear.MovementFixer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({ServerPlayer.class})
public abstract class ServerPlayerMixin implements MovementFixer {
    @Unique
    private Vec3 movement;

    public ServerPlayerMixin() {
    }

    public Vec3 getMovement() {
        ServerPlayer me = (ServerPlayer)((MovementFixer)this);
        Entity entity = me.getVehicle();
        Vec3 var10000;
        if (entity instanceof MovementFixer m) {
            if (entity.getControllingPassenger() != me) {
                var10000 = m.getMovement();
                return var10000;
            }
        }

        var10000 = this.movement;
        return var10000;
    }

    public void setMovement(Vec3 movement) {
        this.movement = movement;
    }
}