package com.drd.backported.mixin;

import com.drd.backported.item.spear.MovementFixer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin implements MovementFixer {
    @Shadow public double xo;
    @Shadow public double yo;
    @Shadow public double zo;

    // Store the position before movement
    private Vec3 backported$oldPos;

    @Inject(
            method = "move",
            at = @At("HEAD")
    )
    private void backported$storeOldPos(MoverType type, Vec3 movement, CallbackInfo ci) {
        Entity self = (Entity)(Object)this;
        this.backported$oldPos = self.position();
    }

    @Inject(
            method = "move",
            at = @At("TAIL")
    )
    private void backported$afterMove(MoverType type, Vec3 movement, CallbackInfo ci) {
        Entity self = (Entity)(Object)this;

        LivingEntity passenger = self.getControllingPassenger();
        if (passenger instanceof ServerPlayer player && player instanceof MovementFixer fixer) {
            Vec3 delta = self.position().subtract(this.backported$oldPos);
            fixer.setMovement(delta);
        }
    }

    @Override
    public Vec3 getMovement() {
        Entity me = (Entity)(Object)this;

        LivingEntity rider = me.getControllingPassenger();
        if (rider instanceof Player p && p instanceof MovementFixer fixer && me.isAlive()) {
            return fixer.getMovement();
        }

        return me.position()
                .add(me.getDeltaMovement())
                .subtract(this.xo, this.yo, this.zo);
    }
}
