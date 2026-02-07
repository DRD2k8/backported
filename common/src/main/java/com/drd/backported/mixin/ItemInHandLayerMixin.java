package com.drd.backported.mixin;

import com.drd.backported.client.BackportedClient;
import com.drd.backported.item.SpearItem;
import com.drd.backported.item.spear.SpearUser;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandLayer.class)
public abstract class ItemInHandLayerMixin {
    @Inject(
            method = "renderArmWithItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;Lnet/minecraft/world/entity/HumanoidArm;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void addSpearAnimation(
            LivingEntity entity,
            ItemStack stack,
            ItemDisplayContext transformationMode,
            HumanoidArm arm,
            PoseStack matrices,
            MultiBufferSource vertexConsumers,
            int light,
            CallbackInfo ci
    ) {
        if (entity.getMainArm() == arm) {
            Item var10 = stack.getItem();
            if (var10 instanceof SpearItem spear) {
                float g;
                float tickDelta;
                if (entity.attackAnim <= 0.0F) {
                    tickDelta = Minecraft.getInstance().getFrameTime();
                    g = (float)stack.getUseDuration() - ((float)entity.getUseItemRemainingTicks() - tickDelta + 1.0F);
                    if (g == 0.0F || !entity.isUsingItem()) {
                        return;
                    }

                    BackportedClient.holdUpAnimation lv = BackportedClient.holdUpAnimation.play(spear, g);
                    int i = arm == HumanoidArm.RIGHT ? 1 : -1;
                    g = 1.0F - lv.raiseProgress() - 1.0F;
                    g = 1.0F - (1.0F + 2.70158F * g * g * g + 1.70158F * Mth.square(g));
                    float j = 0.0F;
                    if (entity instanceof SpearUser s) {
                        j = s.getTimeSinceLastKineticAttack(tickDelta);
                    }

                    j = 1.0F - Mth.square(Mth.square(1.0F - Mth.clamp(Mth.inverseLerp(j, 1.0F, 3.0F), 0.0F, 1.0F))) + (Mth.cos((float)Math.PI * Mth.clamp(Mth.inverseLerp(j, 3.0F, 10.0F), 0.0F, 1.0F)) - 1.0F) / 2.0F;
                    j *= 0.4F;
                    if (j >= 10.0F) {
                        j = 0.0F;
                    }

                    matrices.translate(0.0, -j * 0.4, -0.0F * (g - lv.raiseBackProgress()) + j);
                    matrices.rotateAround(Axis.XN.rotationDegrees(lv.raiseProgress() * 70.0F - lv.raiseBackProgress() * 70.0F), 0.0F, -0.03125F, 0.125F);
                    matrices.rotateAround(Axis.YP.rotationDegrees(lv.raiseProgress() * i * 90.0F - lv.swayProgress() * i * 90.0F), 0.0F, 0.0F, 0.125F);
                } else {
                    tickDelta = 0.0F;
                    g = 0.125F;
                    float h = entity.isUsingItem() ? 1.0F : entity.getAttackAnim(Minecraft.getInstance().getFrameTime());
                    float i = Mth.clamp(Mth.inverseLerp(h, 0.05F, 0.2F), 0.0F, 1.0F);
                    i *= i;
                    g = Mth.clamp(Mth.inverseLerp(h, 0.4F, 1.0F), 0.0F, 1.0F);
                    if (g < 0.5F) {
                        g = g == 0.0F ? 0.0F : (float)(Math.pow(2.0, 20.0 * g - 10.0) / 2.0);
                    } else {
                        g = g == 1.0F ? 1.0F : (float)((2.0 - Math.pow(2.0, -20.0 * g + 10.0)) / 2.0);
                    }

                    matrices.rotateAround(Axis.XN.rotationDegrees(70.0F * (i - g)), 0.0F, -g, g);
                    matrices.translate(0.0F, tickDelta * (i - g), 0.0F);
                }
            }
        }
    }
}
