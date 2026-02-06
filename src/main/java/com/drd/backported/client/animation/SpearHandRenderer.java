package com.drd.backported.client.animation;

import com.drd.backported.Backported;
import com.drd.backported.item.SpearItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Backported.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpearHandRenderer {
    private static float easeOutCubic(float x) {
        return 1f - (float)Math.pow(1f - x, 3);
    }

    private static float easeInOutCubic(float x) {
        return x < 0.5f
                ? 4f * x * x * x
                : 1f - (float)Math.pow(-2f * x + 2f, 3) / 2f;
    }

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof SpearItem)) return;

        Minecraft mc = Minecraft.getInstance();
        AbstractClientPlayer player = mc.player;
        if (player == null) return;

        event.setCanceled(true);

        PoseStack pose = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();
        int light = event.getPackedLight();

        pose.pushPose();

        pose.translate(0.42f, -0.48f, -0.58f);
        pose.mulPose(Axis.YP.rotationDegrees(-14f));
        pose.mulPose(Axis.XP.rotationDegrees(-6f));

        float equip = event.getEquipProgress();
        pose.translate(0f, 0.07f * equip, 0.16f * equip);
        pose.mulPose(Axis.XP.rotationDegrees(16f * equip));

        boolean isCharging = player.isUsingItem() && player.getUseItem() == stack;
        if (isCharging) {
            float charge = (72000 - player.getUseItemRemainingTicks()) / 20f;
            charge = Math.min(charge, 1f);

            if (charge < 0.3f) {
                float p = easeInOutCubic(charge / 0.3f);

                pose.translate(0f, -0.06f * p, 0.11f * p);
                pose.mulPose(Axis.XP.rotationDegrees(-14f * p));

            } else {
                float p = easeInOutCubic((charge - 0.3f) / 0.7f);

                pose.translate(0f, -0.06f - 0.30f * p, 0.11f + 0.34f * p);
                pose.mulPose(Axis.XP.rotationDegrees(-14f - 34f * p));
                pose.translate(0.17f * p, 0f, 0f);
            }
        }

        int throwTicks = player.getPersistentData().getInt("spear_throw_ticks");
        if (throwTicks > 0) {
            player.getPersistentData().putInt("spear_throw_ticks", throwTicks - 1);

            float p = easeOutCubic(1f - (throwTicks / 6f));

            pose.translate(0f, 0f, -0.78f * p);
            pose.mulPose(Axis.XP.rotationDegrees(18f * p));
            pose.translate(0f, -0.12f * p, 0f);
        }

        int jab = player.getPersistentData().getInt("spear_jab_ticks");
        if (jab > 0) {
            player.getPersistentData().putInt("spear_jab_ticks", jab - 1);

            float p = easeOutCubic(1f - (jab / 5f));

            pose.translate(0f, 0f, 0.10f * (1f - p));

            pose.translate(0f, 0f, -0.72f * p);

            pose.mulPose(Axis.XP.rotationDegrees(24f * p));

            pose.translate(0.15f * p, -0.07f * p, 0f);

            if (jab == 1) {
                pose.translate(0f, 0f, 0.10f);
            }
        }

        mc.getItemRenderer().renderStatic(
                player,
                stack,
                ItemDisplayContext.FIRST_PERSON_RIGHT_HAND,
                false,
                pose,
                buffer,
                player.level(),
                light,
                OverlayTexture.NO_OVERLAY,
                0
        );

        pose.popPose();
    }
}
