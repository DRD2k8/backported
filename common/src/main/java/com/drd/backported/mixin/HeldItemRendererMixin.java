package com.drd.backported.mixin;

import com.drd.backported.client.BackportedClient;
import com.drd.backported.item.SpearItem;
import com.drd.backported.item.spear.SpearUser;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public abstract class HeldItemRendererMixin {
    @Unique
    private boolean backported$suppressEquipOffset;

    @Unique
    private boolean backported$isSpear;

    @Unique
    private boolean backported$isSpearAttack;

    @Unique
    private ItemStack backported$currentStack;

    @Unique
    private float backported$currentSwingProgress;

    @Unique
    private AbstractClientPlayer backported$currentPlayer;

    @Inject(
            method = "renderArmWithItem",
            at = @At("HEAD")
    )
    private void backported$captureContext(
            AbstractClientPlayer player,
            float partialTicks,
            float pitch,
            InteractionHand hand,
            float swingProgress,
            ItemStack stack,
            float equipProgress,
            PoseStack poseStack,
            MultiBufferSource buffers,
            int light,
            CallbackInfo ci
    ) {
        this.backported$currentPlayer = player;
        this.backported$currentStack = stack;
        this.backported$currentSwingProgress = swingProgress;
        this.backported$isSpear = stack.getItem() instanceof SpearItem;
        this.backported$isSpearAttack = this.backported$isSpear && player.attackAnim > 0.0F;
    }

    @Redirect(
            method = "renderArmWithItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V",
                    ordinal = 12
            )
    )
    private void backported$suppressNormalSwing(
            PoseStack poseStack,
            float x, float y, float z
    ) {
        if (!this.backported$isSpear) {
            poseStack.translate(x, y, z);
        }
    }

    @Redirect(
            method = "renderArmWithItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;applyItemArmTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V",
                    ordinal = 8
            )
    )
    private void backported$suppressSwapAnimation(
            ItemInHandRenderer renderer,
            PoseStack poseStack,
            HumanoidArm arm,
            float equipProgress
    ) {
        if (this.backported$isSpearAttack) {
            ((ItemInHandRendererInvoker) renderer)
                    .backported$invokeApplyItemArmTransform(poseStack, arm, 0f);
        } else {
            ((ItemInHandRendererInvoker) renderer)
                    .backported$invokeApplyItemArmTransform(poseStack, arm, equipProgress);
        }
    }

    @Redirect(
            method = "renderArmWithItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;applyItemArmAttackTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V"
            )
    )
    private void backported$spearAnimation(
            ItemInHandRenderer renderer,
            PoseStack poseStack,
            HumanoidArm arm,
            float swingProgress
    ) {
        if (this.backported$isSpear) {
            float swing = this.backported$currentSwingProgress;

            float g = -(Mth.cos((float)Math.PI * Mth.clamp(Mth.inverseLerp(swing, 0.0F, 0.05F), 0.0F, 1.0F)) - 1.0F) / 2.0F;
            float h = Mth.clamp(Mth.inverseLerp(swing, 0.05F, 0.2F), 0.0F, 1.0F);
            h *= h;
            float j = Mth.clamp(Mth.inverseLerp(swing, 0.4F, 1.0F), 0.0F, 1.0F);
            if (j < 0.5F) {
                j = j == 0.0F ? 0.0F : (float)(Math.pow(2.0, 20.0 * (double)j - 10.0) / 2.0);
            } else {
                j = j == 1.0F ? 1.0F : (float)((2.0 - Math.pow(2.0, -20.0 * (double)j + 10.0)) / 2.0);
            }

            boolean trident = this.backported$currentStack.is(Items.TRIDENT);
            poseStack.translate(
                    j * 0.1F * (g - h),
                    -0.075F * (g - j),
                    (trident ? -0.4F * (g - j) : 0.0F) + 0.65F * (g - h)
            );
            poseStack.mulPose(Axis.XP.rotationDegrees(-(trident ? 50.0F : 70.0F) * (g - j)));
            poseStack.translate(0.0, 0.0, -0.25 * (double)(j - h));
        } else {
            ((ItemInHandRendererInvoker) renderer)
                    .backported$invokeApplyItemArmAttackTransform(poseStack, arm, swingProgress);
        }
    }

    @Inject(
            method = "renderArmWithItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;getUseAnimation()Lnet/minecraft/world/item/UseAnim;"
            )
    )
    private void backported$insertSpearAnimation(
            AbstractClientPlayer player,
            float partialTicks,
            float pitch,
            InteractionHand hand,
            float swingProgress,
            ItemStack stack,
            float equipProgress,
            PoseStack poseStack,
            MultiBufferSource buffers,
            int light,
            CallbackInfo ci
    ) {
        backported$suppressEquipOffset = false;

        if (player.getUsedItemHand() == hand && stack.getItem() instanceof SpearItem spear) {
            HumanoidArm arm = hand == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
            int i = arm == HumanoidArm.RIGHT ? 1 : -1;

            poseStack.translate((float)i * 0.56F, -0.52F, -0.72F);

            BackportedClient.holdUpAnimation anim = BackportedClient.holdUpAnimation.play(
                    spear,
                    (float)stack.getUseDuration() - ((float)player.getUseItemRemainingTicks() - partialTicks + 1.0F)
            );

            poseStack.translate(
                    (float)i * (anim.raiseProgress() * 0.15F + anim.raiseProgressEnd() * -0.05F + anim.swayProgress() * -0.1F + anim.swayScaleSlow() * 0.005F),
                    anim.raiseProgress() * -0.075F + anim.raiseProgressMiddle() * 0.075F + anim.swayScaleFast() * 0.01F,
                    anim.raiseProgressStart() * 0.05F + anim.raiseProgressEnd() * -0.05F + anim.swayScaleSlow() * 0.005F
            );

            float f = anim.raiseProgress();
            float h;
            if (f < 0.5F) {
                f = 4.0F * f * f * (7.189819F * f - 2.5949094F) / 2.0F;
            } else {
                h = 2.0F * f - 2.0F;
                f = (h * h * (3.5949094F * h + 2.5949094F) + 2.0F) / 2.0F;
            }

            poseStack.mulPose(Axis.XP.rotationDegrees(
                    -65.0F * f
                            - 35.0F * (1.0F - anim.lowerProgress())
                            + 100.0F * anim.raiseBackProgress()
                            - 0.5F * anim.swayScaleFast()
            ));
            poseStack.mulPose(Axis.YN.rotationDegrees(
                    (float)i * (
                            -90.0F * Mth.clamp(Mth.inverseLerp(anim.raiseProgress(), 0.5F, 0.55F), 0.0F, 1.0F)
                                    + 90.0F * anim.swayProgress()
                                    + 2.0F * anim.swayScaleSlow()
                    )
            ));

            h = 0.0F;
            if (player instanceof SpearUser s) {
                h = s.getTimeSinceLastKineticAttack(partialTicks);
            }

            h = 1.0F - Mth.square(Mth.square(1.0F - Mth.clamp(Mth.inverseLerp(h, 1.0F, 3.0F), 0.0F, 1.0F)))
                    + (Mth.cos((float)Math.PI * Mth.clamp(Mth.inverseLerp(h, 3.0F, 10.0F), 0.0F, 1.0F)) - 1.0F) / 2.0F;
            h *= 0.4F;
            if (h >= 10.0F) {
                h = 0.0F;
            }

            poseStack.translate(0.0F, -h, 0.0F);
            backported$suppressEquipOffset = true;
        }
    }

    @Redirect(
            method = "renderArmWithItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;applyItemArmTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V",
                    ordinal = 2
            )
    )
    private void backported$suppressEquipOffsetForUseAnimation(
            ItemInHandRenderer renderer,
            PoseStack poseStack,
            HumanoidArm arm,
            float equipProgress
    ) {
        if (!backported$suppressEquipOffset) {
            ((ItemInHandRendererInvoker) renderer)
                    .backported$invokeApplyItemArmAttackTransform(poseStack, arm, equipProgress);
        }
    }
}
