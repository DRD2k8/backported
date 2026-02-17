package com.drd.backported.client.init;

import com.drd.backported.Backported;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    // Bats and Pots
    public static final ModelLayerLocation BAT = register("bat");

    // Armored Paws
    public static final ModelLayerLocation WOLF_ARMOR = register("wolf_armor");
    public static final ModelLayerLocation ARMADILLO = register("armadillo");

    // Tricky Trials
    public static final ModelLayerLocation WIND_CHARGE = register("wind_charge");

    // The Garden Awakens
    public static final ModelLayerLocation CREAKING = register("creaking");

    // Spring to Life
    public static final ModelLayerLocation COLD_PIG = register("cold_pig");
    public static final ModelLayerLocation COLD_CHICKEN = register("cold_chicken");
    public static final ModelLayerLocation COLD_COW = register("cold_cow");
    public static final ModelLayerLocation WARM_COW = register("warm_cow");
    public static final ModelLayerLocation TEMPERATE_COW = register("temperate_cow");

    // Chase the Skies
    public static final ModelLayerLocation HAPPY_GHAST = register("happy_ghast");
    public static final ModelLayerLocation HAPPY_GHAST_HARNESS = register("happy_ghast_harness");
    public static final ModelLayerLocation HAPPY_GHAST_ROPES = register("happy_ghast_ropes");
    public static final ModelLayerLocation GHASTLING = register("ghastling");

    // First Drop 2026
    public static final ModelLayerLocation RABBIT = register("rabbit");
    public static final ModelLayerLocation BABY_ARMADILLO = register("baby_armadillo");
    public static final ModelLayerLocation BABY_AXOLOTL = register("baby_axolotl");
    public static final ModelLayerLocation BABY_BEE = register("baby_bee");
    public static final ModelLayerLocation BABY_CAMEL = register("baby_camel");
    public static final ModelLayerLocation BABY_CAT = register("baby_cat");
    public static final ModelLayerLocation BABY_CHICKEN = register("baby_chicken");
    public static final ModelLayerLocation BABY_COW = register("baby_cow");
    public static final ModelLayerLocation BABY_DOLPHIN = register("baby_dolphin");
    public static final ModelLayerLocation BABY_DONKEY = register("baby_donkey");
    public static final ModelLayerLocation BABY_DROWNED = register("baby_drowned");
    public static final ModelLayerLocation BABY_FOX = register("baby_fox");
    public static final ModelLayerLocation BABY_GLOW_SQUID = register("baby_glow_squid");
    public static final ModelLayerLocation BABY_GOAT = register("baby_goat");
    public static final ModelLayerLocation BABY_HORSE = register("baby_horse");
    public static final ModelLayerLocation BABY_HUSK = register("baby_husk");
    public static final ModelLayerLocation BABY_LLAMA = register("baby_llama");
    public static final ModelLayerLocation BABY_MOOSHROOM = register("baby_mooshroom");
    public static final ModelLayerLocation BABY_MULE = register("baby_mule");
    public static final ModelLayerLocation BABY_OCELOT = register("baby_ocelot");
    public static final ModelLayerLocation BABY_PIG = register("baby_pig");
    public static final ModelLayerLocation BABY_PIGLIN = register("baby_piglin");
    public static final ModelLayerLocation BABY_POLAR_BEAR = register("baby_polar_bear");
    public static final ModelLayerLocation BABY_RABBIT = register("baby_rabbit");
    public static final ModelLayerLocation BABY_SHEEP = register("baby_sheep");
    public static final ModelLayerLocation BABY_SKELETON_HORSE = register("baby_skeleton_horse");
    public static final ModelLayerLocation BABY_SQUID = register("baby_squid");
    public static final ModelLayerLocation BABY_TRADER_LLAMA = register("baby_trader_llama");
    public static final ModelLayerLocation BABY_TURTLE = register("baby_turtle");
    public static final ModelLayerLocation BABY_VILLAGER = register("baby_villager");
    public static final ModelLayerLocation BABY_WOLF = register("baby_wolf");
    public static final ModelLayerLocation BABY_ZOMBIE = register("baby_zombie");
    public static final ModelLayerLocation BABY_ZOMBIE_HORSE = register("baby_zombie_horse");
    public static final ModelLayerLocation BABY_ZOMBIE_VILLAGER = register("baby_zombie_villager");
    public static final ModelLayerLocation BABY_ZOMBIFIED_PIGLIN = register("baby_zombified_piglin");

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(Backported.MOD_ID, name), layer);
    }
}
