package com.drd.backported.mixin;

import com.drd.backported.item.SpearItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends LivingEntity> {
    @Inject(
            method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V",
            at = @At("HEAD")
    )
    private void backported$setupSpearPose(
            T entity,
            float limbSwing,
            float limbSwingAmount,
            float ageInTicks,
            float netHeadYaw,
            float headPitch,
            CallbackInfo ci
    ) {
        if (entity.isUsingItem() && entity.getUseItem().getItem() instanceof SpearItem) {
            HumanoidModel<?> self = (HumanoidModel<?>)(Object)this;

            self.rightArm.xRot = -1.5F;
            self.rightArm.yRot = 0.1F;
            self.rightArm.zRot = 0.0F;
        }
    }
}
