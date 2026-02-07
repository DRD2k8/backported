package com.drd.backported.mixin;

import com.drd.backported.item.SpearItem;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin extends Player {
    @Shadow public Input input;
    @Shadow @Final protected Minecraft minecraft;

    public LocalPlayerMixin(Level world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    @Inject(
            method = "aiStep",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/player/LocalPlayer;isUsingItem()Z",
                    shift = At.Shift.AFTER
            )
    )
    private void removeMovementSpeedPenalty(CallbackInfo ci) {
        if (this.getUseItem() != null && this.getUseItem().getItem() instanceof SpearItem) {
            this.input.forwardImpulse *= 5.0F;
            this.input.leftImpulse *= 5.0F;
        }
    }

    @Inject(method = "canStartSprinting", at = @At("HEAD"), cancellable = true)
    private void allowSprintingWithSpear(CallbackInfoReturnable<Boolean> cir) {
        if (this.getUseItem() != null && this.getUseItem().getItem() instanceof SpearItem) {
            boolean wants = this.input.forwardImpulse >= 0.8F;
            boolean notSneaking = !this.isShiftKeyDown();
            boolean notUsingItem = !this.isUsingItem();

            boolean result = wants && notSneaking && notUsingItem;

            cir.setReturnValue(result);
        }
    }
}
