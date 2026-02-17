package com.drd.backported.mixin;

import com.drd.backported.entity.other.BatAnimationAccess;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.ambient.Bat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bat.class)
public class BatMixin implements BatAnimationAccess {
    @Unique
    private final AnimationState flyAnimationState = new AnimationState();

    @Unique
    private final AnimationState restAnimationState = new AnimationState();

    @Unique
    private void setupAnimationStates() {
        Bat self = (Bat)(Object)this;

        if (self.isResting()) {
            flyAnimationState.stop();
            restAnimationState.startIfStopped(self.tickCount);
        } else {
            restAnimationState.stop();
            flyAnimationState.startIfStopped(self.tickCount);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tickAnimations(CallbackInfo ci) {
        this.setupAnimationStates();
    }

    @Override
    public AnimationState getFlyAnimationState() {
        return flyAnimationState;
    }

    @Override
    public AnimationState getRestAnimationState() {
        return restAnimationState;
    }
}
