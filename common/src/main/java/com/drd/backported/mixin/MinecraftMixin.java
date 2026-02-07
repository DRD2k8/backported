package com.drd.backported.mixin;

import com.drd.backported.Backported;
import com.drd.backported.client.BackportedClient;
import com.drd.backported.item.SpearItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Minecraft.class})
public abstract class MinecraftMixin {
    public @Nullable LocalPlayer player;

    public MinecraftMixin() {
    }

    @Inject(
            method = {"startAttack"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/player/LocalPlayer;getItemInHand(Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;",
                    shift = At.Shift.AFTER
            )},
            cancellable = true
    )
    private void spearAttack(CallbackInfoReturnable<Boolean> cir) {
        if (this.player != null && this.player.getMainHandItem().getItem() instanceof SpearItem) {
            if (this.player.getAttackStrengthScale(0.0F) < 1.0F) {
                cir.setReturnValue(false);
            } else {
                if (BackportedClient.syncSpears != null) {
                    BackportedClient.syncSpears.apply(this.player.getId());
                } else {
                    this.player.sendSystemMessage(Component.nullToEmpty("Missing packet for " + Backported.MOD_ID + ":send_stab_attack_to_server"));
                }

                this.player.swing(InteractionHand.MAIN_HAND);
                this.player.resetAttackStrengthTicker();
                cir.setReturnValue(true);
            }
        }
    }
}
