package com.drd.backported.client;

import com.drd.backported.Backported;
import com.drd.backported.item.SpearItem;
import com.drd.backported.util.ModWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.lang.reflect.Method;
import java.util.function.Function;

public class BackportedClient {
    public static void init() {
        registerSheets();
    }

    private static void registerSheets() {
        addWoodType(ModWoodTypes.PALE_OAK);
    }

    private static void addWoodType(WoodType woodType) {
        ResourceLocation location = new ResourceLocation(woodType.name());
        Sheets.SIGN_MATERIALS.put(woodType, new Material(Sheets.SIGN_SHEET, new ResourceLocation(Backported.MOD_ID, "entity/signs/" + location.getPath())));
        Sheets.HANGING_SIGN_MATERIALS.put(woodType, new Material(Sheets.SIGN_SHEET, new ResourceLocation(Backported.MOD_ID, "entity/signs/hanging/" + location.getPath())));
    }

    public static Method getUpswingTicks = null;
    public static Function<Integer, Boolean> syncSpears = null;

    public static record holdUpAnimation(float raiseProgress, float raiseProgressStart, float raiseProgressMiddle, float raiseProgressEnd, float swayProgress, float lowerProgress, float raiseBackProgress, float swayIntensity, float swayScaleSlow, float swayScaleFast) {
        public holdUpAnimation(float raiseProgress, float raiseProgressStart, float raiseProgressMiddle, float raiseProgressEnd, float swayProgress, float lowerProgress, float raiseBackProgress, float swayIntensity, float swayScaleSlow, float swayScaleFast) {
            this.raiseProgress = raiseProgress;
            this.raiseProgressStart = raiseProgressStart;
            this.raiseProgressMiddle = raiseProgressMiddle;
            this.raiseProgressEnd = raiseProgressEnd;
            this.swayProgress = swayProgress;
            this.lowerProgress = lowerProgress;
            this.raiseBackProgress = raiseBackProgress;
            this.swayIntensity = swayIntensity;
            this.swayScaleSlow = swayScaleSlow;
            this.swayScaleFast = swayScaleFast;
        }

        public static holdUpAnimation play(SpearItem spear, float f) {
            int i = spear.delayTicks();
            int j = i + spear.getMaxDurationForDismountInTicks();
            int k = i + spear.getMaxDurationForChargeKnockbackInTicks();
            int l = i + spear.getMaxDurationForChargeDamageInTicks();
            float g = Mth.clamp(Mth.inverseLerp(f, 0.0F, (float)i), 0.0F, 1.0F);
            float h = Mth.clamp(Mth.inverseLerp(g, 0.0F, 0.5F), 0.0F, 1.0F);
            float m = Mth.clamp(Mth.inverseLerp(g, 0.5F, 0.8F), 0.0F, 1.0F);
            float n = Mth.clamp(Mth.inverseLerp(g, 0.8F, 1.0F), 0.0F, 1.0F);
            float o = Mth.clamp(Mth.inverseLerp(f, (float)j, (float)k), 0.0F, 1.0F);
            float p = Mth.clamp(Mth.inverseLerp(f, (float)k, (float)(l - 5)), 0.0F, 1.0F);
            if (p < 0.0F) {
                p = 0.0F;
            } else if (p > 1.0F) {
                p = 1.0F;
            } else {
                double d = Math.sin((20.0 * (double)p - 11.125) * 3.1415927410125732 * 4.0 / 9.0);
                p = p < 0.5F ? (float)(-(Math.pow(2.0, 20.0 * (double)p - 10.0) * d) / 2.0) : (float)(Math.pow(2.0, -20.0 * (double)p + 10.0) * d / 2.0 + 1.0);
            }

            p = 1.0F - p * p * p;
            float q = Mth.clamp(Mth.inverseLerp(f, (float)(l - 5), (float)l), 0.0F, 1.0F);
            float r = 2.0F * (float)Math.sqrt((double)(1.0F + Mth.square(1.0F - o))) - 2.0F * (float)(-Math.sqrt((double)(1.0F - o * o)) + 1.0);
            float s = Mth.sin(f * 19.0F * 0.017453292F);
            float t = Mth.sin(f * 30.0F * 0.017453292F);
            float u = Mth.clamp((1.0F - f / (float)Math.max(Math.max(j, k), l)) * 20.0F, 0.0F, 1.0F) * (2.9F - r);
            return new holdUpAnimation(g, h, m, n, o, p, q, r, s * u, t * u);
        }

        public float raiseProgress() {
            return this.raiseProgress;
        }

        public float raiseProgressStart() {
            return this.raiseProgressStart;
        }

        public float raiseProgressMiddle() {
            return this.raiseProgressMiddle;
        }

        public float raiseProgressEnd() {
            return this.raiseProgressEnd;
        }

        public float swayProgress() {
            return this.swayProgress;
        }

        public float lowerProgress() {
            return this.lowerProgress;
        }

        public float raiseBackProgress() {
            return this.raiseBackProgress;
        }

        public float swayIntensity() {
            return this.swayIntensity;
        }

        public float swayScaleSlow() {
            return this.swayScaleSlow;
        }

        public float swayScaleFast() {
            return this.swayScaleFast;
        }
    }
}
