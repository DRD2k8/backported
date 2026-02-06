package com.drd.backported.fabric.client;

import com.drd.backported.client.init.ModModelLayers;
import com.drd.backported.client.model.WindChargeModel;
import com.drd.backported.client.renderer.WindChargeRenderer;
import com.drd.backported.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.world.item.Items;

public class BackportedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Tricky Trials
        EntityRendererRegistry.register(ModEntities.WIND_CHARGE.get(), WindChargeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WIND_CHARGE, WindChargeModel::createBodyLayer);

        // Spring to Life
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ALLAY_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.AXOLOTL_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.BAT_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.BEE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.BLAZE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.CAMEL_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.CAT_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.CAVE_SPIDER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.CHICKEN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.COD_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.COW_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.CREEPER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.DOLPHIN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.DONKEY_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.DROWNED_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ELDER_GUARDIAN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ENDER_DRAGON_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ENDERMAN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ENDERMITE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.EVOKER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.FOX_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.FROG_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.GHAST_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.GLOW_SQUID_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.GOAT_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.GUARDIAN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.HOGLIN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.HORSE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.HUSK_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.IRON_GOLEM_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.LLAMA_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.MAGMA_CUBE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.MOOSHROOM_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.MULE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.OCELOT_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PANDA_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PARROT_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PHANTOM_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PIG_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PIGLIN_BRUTE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PIGLIN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PILLAGER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.POLAR_BEAR_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.PUFFERFISH_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.RABBIT_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.RAVAGER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SALMON_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SHEEP_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SHULKER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SILVERFISH_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SKELETON_HORSE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SKELETON_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SLIME_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SNIFFER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SNOW_GOLEM_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SPIDER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.SQUID_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.STRAY_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.STRIDER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.TADPOLE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.TRADER_LLAMA_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.TROPICAL_FISH_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.TURTLE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.VILLAGER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.VEX_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.VINDICATOR_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.WANDERING_TRADER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.WARDEN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.WITCH_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.WITHER_SKELETON_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.WITHER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.WOLF_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ZOGLIN_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIE_HORSE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIE_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIE_VILLAGER_SPAWN_EGG);
        ColorProviderRegistry.ITEM.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
    }
}
