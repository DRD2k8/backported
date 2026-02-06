package com.drd.backported.mixin;

import com.drd.backported.client.animation.ChargeAnimationController;
import com.drd.backported.item.SpearItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemInHandRenderer.class, remap = false)
public class ItemInHandRendererMixin {
    @Inject(method = "renderArmWithItem", at = @At("HEAD"), cancellable = true)
    private void backported$renderSpear(
            AbstractClientPlayer player,
            float partialTicks,
            float pitch,
            InteractionHand hand,
            float swingProgress,
            ItemStack stack,
            float equipProgress,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int light,
            CallbackInfo ci
    ) {
        if (!(stack.getItem() instanceof SpearItem)) {
            return;
        }

        ci.cancel();

        ItemInHandRenderer renderer = (ItemInHandRenderer) (Object) this;

        poseStack.pushPose();

        poseStack.translate(0.56F, -0.52F, -0.72F);

        poseStack.translate(0.0F, equipProgress * -0.6F, 0.0F);

        float charge = ChargeAnimationController.getPullbackAmount(player);
        int stage = ChargeAnimationController.getChargeStage(player);

        float jab = ChargeAnimationController.getJabProgress(player, partialTicks);

        poseStack.translate(0f, 0f, 0.4f * charge);
        poseStack.mulPose(new Quaternionf().rotationX((float) Math.toRadians(-40f * charge)));

        if (stage == 2) {
            poseStack.translate(0.05f, 0f, 0f);
        } else if (stage == 3) {
            poseStack.translate(0.1f, 0f, 0f);
        }

        if (jab > 0f) {
            poseStack.translate(0f, 0f, -1.2f * jab);

            float straighten = (40f * charge) * jab;
            poseStack.mulPose(new Quaternionf().rotationX((float) Math.toRadians(straighten)));
        }

        renderer.renderItem(
                player,
                stack,
                ItemDisplayContext.FIRST_PERSON_RIGHT_HAND,
                false,
                poseStack,
                buffer,
                light
        );

        poseStack.popPose();
    }
}

