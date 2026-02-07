package com.drd.backported.mixin;

import com.drd.backported.client.BackportedClient;
import com.drd.backported.item.SpearItem;
import com.drd.backported.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({HumanoidModel.class})
public abstract class HumanoidModelMixin<T extends LivingEntity> extends AgeableListModel<T> {
    @Shadow
    @Final
    public ModelPart rightArm;
    @Shadow
    @Final
    public ModelPart leftArm;
    @Shadow
    @Final
    public ModelPart body;
    @Shadow
    @Final
    public ModelPart head;
    @Shadow
    public HumanoidModel.ArmPose rightArmPose;
    @Shadow
    public HumanoidModel.ArmPose leftArmPose;

    public HumanoidModelMixin() {
    }

    @Shadow
    protected abstract ModelPart getArm(HumanoidArm var1);

    @Inject(
            method = {"poseRightArm"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void rightArmSpear(T entity, CallbackInfo ci) {
        if ((!this.rightArmPose.isTwoHanded() || this.attackTime > 0.0F) && this.handleSpearAnimationPerArm(entity, HumanoidArm.RIGHT) && !entity.isUsingItem() && this.attackTime > 0.0F) {
            ci.cancel();
        }

    }

    @Inject(
            method = {"poseLeftArm"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void leftArmSpear(T entity, CallbackInfo ci) {
        if ((!this.leftArmPose.isTwoHanded() || this.attackTime > 0.0F) && this.handleSpearAnimationPerArm(entity, HumanoidArm.LEFT) && !entity.isUsingItem() && this.attackTime > 0.0F) {
            ci.cancel();
        }

    }

    @Unique
    private boolean handleSpearAnimationPerArm(T entity, HumanoidArm arm) {
        ItemStack itemStack = entity.getMainArm() == arm ? entity.getMainHandItem() : entity.getOffhandItem();
        if (itemStack.getItem() instanceof SpearItem || itemStack.is(ModTags.Items.SPEARS) && this.attackTime <= 0.0F) {
            ModelPart usedArm = this.getArm(arm);
            usedArm.yRot = -0.1F * this.head.yRot;
            usedArm.xRot = -1.5707964F + this.head.xRot + 0.8F;
            if (entity.isFallFlying() || entity.getSwimAmount(1.0F) > 0.0F) {
                usedArm.xRot -= 0.9599311F;
            }

            if (entity.isUsingItem()) {
                Item var6 = entity.getUseItem().getItem();
                if (var6 instanceof SpearItem) {
                    SpearItem spear = (SpearItem)var6;
                    int i = arm == HumanoidArm.RIGHT ? 1 : -1;
                    BackportedClient.holdUpAnimation lv = BackportedClient.holdUpAnimation.play(spear, (float)entity.getTicksUsingItem() + Minecraft.getInstance().getFrameTime());
                    usedArm.yRot += (float)(-i) * lv.swayScaleFast() * 0.017453292F * lv.swayIntensity();
                    usedArm.zRot += (float)(-i) * lv.swayScaleSlow() * 0.017453292F * lv.swayIntensity() * 0.5F;
                    usedArm.xRot += 0.017453292F * (-40.0F * lv.raiseProgressStart() + 30.0F * lv.raiseProgressMiddle() + 20.0F * lv.raiseProgressEnd() - 20.0F * lv.lowerProgress() + 10.0F * lv.raiseBackProgress() + 0.6F * lv.swayScaleSlow() * lv.swayIntensity());
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Inject(
            method = {"setupAttackAnimation"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/Mth;sin(F)F",
                    ordinal = 3
            )},
            cancellable = true
    )
    private void addSpearAnimation(T entity, float animationProgress, CallbackInfo ci) {
        if (entity.getMainHandItem().getItem() instanceof SpearItem) {
            float f = entity.isUsingItem() ? 1.0F : this.attackTime;
            HumanoidArm arm = entity.getMainArm();
            ModelPart var10000 = this.rightArm;
            var10000.yRot -= this.leftArm.yRot;
            var10000 = this.body;
            var10000.yRot -= this.leftArm.yRot;
            var10000 = this.body;
            var10000.xRot -= this.leftArm.yRot;
            float g = -(Mth.cos(3.1415927F * Mth.clamp(Mth.inverseLerp(f, 0.0F, 0.05F), 0.0F, 1.0F)) - 1.0F) / 2.0F;
            float h = Mth.clamp(Mth.inverseLerp(f, 0.05F, 0.2F), 0.0F, 1.0F);
            h *= h;
            float i = Mth.clamp(Mth.inverseLerp(f, 0.4F, 1.0F), 0.0F, 1.0F);
            if (i < 0.5F) {
                i = i == 0.0F ? 0.0F : (float)(Math.pow(2.0, 20.0 * (double)i - 10.0) / 2.0);
            } else {
                i = i == 1.0F ? 1.0F : (float)((2.0 - Math.pow(2.0, -20.0 * (double)i + 10.0)) / 2.0);
            }

            var10000 = this.getArm(arm);
            var10000.xRot += (90.0F * g - 120.0F * h + 30.0F * i) * 0.017453292F;
            var10000 = this.getArm(arm);
            var10000.yRot += this.head.yRot * (h - i);
            ci.cancel();
        }
    }

    @Inject(
            method = {"setupAttackAnimation"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void animateLanceAttack(T entity, float animationProgress, CallbackInfo ci) {
        Item var5 = (entity.isUsingItem() ? entity.getUseItem() : entity.getMainHandItem()).getItem();
        if (var5 instanceof SpearItem spear) {
            if (entity.isUsingItem()) {
                float f = (float)entity.getTicksUsingItem() + Minecraft.getInstance().getFrameTime();
                float g = spear.delayTicks() == 0 ? 1.0F : (float)spear.delayTicks();
                if (f > (float)spear.getUseTicks()) {
                    f = (1.0F - (f - (float)spear.getUseTicks())) / g;
                    if (f < 0.0F) {
                        f = 0.0F;
                    }
                } else {
                    f /= g;
                    if (f > 1.0F) {
                        f = 1.0F;
                    }
                }

                ModelPart usedArm = this.getArm(entity.getUsedItemHand() == InteractionHand.MAIN_HAND ? entity.getMainArm() : entity.getMainArm().getOpposite());
                usedArm.yRot = (float)Mth.clamp((double)this.head.yRot, -1.3089969389957472, 1.3089969389957472) * f;
                usedArm.xRot += this.head.xRot * 0.5F * f - (float)(0.017453292519943295 * (!entity.isFallFlying() && !(entity.getSwimAmount(1.0F) > 0.0F) ? 30.0 : 55.0)) * f;
                ci.cancel();
            }
        }
    }
}
