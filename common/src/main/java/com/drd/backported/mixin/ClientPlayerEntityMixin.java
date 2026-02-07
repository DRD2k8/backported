package com.drd.backported.mixin;

import com.drd.backported.client.BackportedClient;
import com.drd.backported.item.SpearItem;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
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

@Mixin({LocalPlayer.class})
public abstract class ClientPlayerEntityMixin extends Player {
    @Shadow
    public Input f_108618_;
    @Shadow
    @Final
    protected Minecraft f_108619_;
    @Shadow
    private boolean f_108609_;

    public ClientPlayerEntityMixin(Level world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(
            method = {"aiStep"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/player/LocalPlayer;isUsingItem()Z",
                    shift = At.Shift.AFTER
            )}
    )
    private void removeMovementSpeedPenalty(CallbackInfo ci) {
        if (this.getUseItem() != null && this.getUseItem().getItem() instanceof SpearItem) {
            Input var10000 = this.f_108618_;
            var10000.forwardImpulse *= 5.0F;
            var10000 = this.f_108618_;
            var10000.leftImpulse *= 5.0F;
        }

    }

    @WrapMethod(
            method = {"canStartSprinting"}
    )
    private boolean makeSurePlayerCanSprint(Operation<Boolean> original) {
        if (this.getUseItem() != null && this.getUseItem().getItem() instanceof SpearItem) {
            this.f_108609_ = false;
            Boolean result = (Boolean)original.call(new Object[0]);
            this.f_108609_ = true;
            return result;
        } else {
            return (Boolean)original.call(new Object[0]);
        }
    }
}
