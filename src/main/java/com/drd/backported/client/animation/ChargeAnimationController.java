package com.drd.backported.client.animation;

import net.minecraft.world.entity.player.Player;

public class ChargeAnimationController {
    private static final float STAGE1_TIME = 0.5f;
    private static final float STAGE2_TIME = 1.0f;

    public static float getChargeProgress(Player player) {
        if (!player.isUsingItem()) return 0f;

        int usedTicks = player.getUseItem().getUseDuration() - player.getUseItemRemainingTicks();
        float seconds = usedTicks / 20f;

        return Math.min(seconds / STAGE2_TIME, 1f);
    }

    public static int getChargeStage(Player player) {
        if (!player.isUsingItem()) return 0;

        int usedTicks = player.getUseItem().getUseDuration() - player.getUseItemRemainingTicks();
        float seconds = usedTicks / 20f;

        if (seconds < STAGE1_TIME) return 1;
        if (seconds < STAGE2_TIME) return 2;
        return 3;
    }

    public static float getPullbackAmount(Player player) {
        float x = getChargeProgress(player);

        // Ease-out cubic curve
        return 1f - (float) Math.pow(1f - x, 3);
    }

    public static float getJabProgress(Player player, float partialTicks) {
        float t = player.getAttackStrengthScale(partialTicks);
        return 1f - t;
    }
}
