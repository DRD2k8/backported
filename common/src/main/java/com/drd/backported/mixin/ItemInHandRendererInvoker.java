package com.drd.backported.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.entity.HumanoidArm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemInHandRenderer.class)
public interface ItemInHandRendererInvoker {
    @Invoker("applyItemArmTransform")
    void backported$invokeApplyItemArmTransform(
            PoseStack poseStack,
            HumanoidArm arm,
            float equipProgress
    );

    @Invoker("applyItemArmAttackTransform")
    void backported$invokeApplyItemArmAttackTransform(
            PoseStack poseStack,
            HumanoidArm arm,
            float swingProgress
    );
}
