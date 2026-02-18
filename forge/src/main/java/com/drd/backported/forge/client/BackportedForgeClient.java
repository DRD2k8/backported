package com.drd.backported.forge.client;

import com.drd.backported.Backported;
import com.drd.backported.client.BackportedClient;
import com.drd.backported.client.init.ModModelLayers;
import com.drd.backported.client.listener.DryFoliageColorReloadListener;
import com.drd.backported.client.model.WindChargeModel;
import com.drd.backported.client.model.armor.WolfArmorModel;
import com.drd.backported.client.model.vanilla.ModBatModel;
import com.drd.backported.client.renderer.CustomBoatRenderer;
import com.drd.backported.client.renderer.ShelfRenderer;
import com.drd.backported.client.renderer.WindChargeRenderer;
import com.drd.backported.client.renderer.vanilla.ModBatRenderer;
import com.drd.backported.client.renderer.vanilla.ModWolfRenderer;
import com.drd.backported.entity.CustomBoat;
import com.drd.backported.forge.client.emissive.EmissiveModelWrapper;
import com.drd.backported.forge.packets.PacketHandler;
import com.drd.backported.forge.packets.PlayerStabPacket;
import com.drd.backported.init.*;
import com.drd.backported.item.WolfArmorItem;
import com.drd.backported.particle.DustPlumeParticle;
import com.drd.backported.particle.FireflyParticle;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Backported.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BackportedForgeClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(BackportedClient::init);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FIREFLY_BUSH.get(), RenderType.cutout());
        EntityRenderers.register(ModEntities.BOAT.get(), context -> new CustomBoatRenderer<>(context, false));
        EntityRenderers.register(ModEntities.CHEST_BOAT.get(), context -> new CustomBoatRenderer<>(context, true));
        EntityRenderers.register(EntityType.BAT, ModBatRenderer::new);
        EntityRenderers.register(EntityType.WOLF, ModWolfRenderer::new);
        EntityRenderers.register(ModEntities.WIND_CHARGE.get(), WindChargeRenderer::new);
        if (BackportedClient.syncSpears == null) {
            BackportedClient.syncSpears = (i) -> {
                PacketHandler.sendToServer(new PlayerStabPacket(i));
                return true;
            };
        }
    }

    @SubscribeEvent
    public static void onAddReloadListeners(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new DryFoliageColorReloadListener());
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (CustomBoat.Type type : CustomBoat.Type.values()) {
            event.registerLayerDefinition(new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, type.getModelLocation()), "main"), BoatModel::createBodyModel);
            event.registerLayerDefinition(new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
        }

        // Bats and Pots
        event.registerLayerDefinition(ModModelLayers.BAT, ModBatModel::createBodyLayer);

        // Armored Paws
        event.registerLayerDefinition(ModModelLayers.WOLF_ARMOR, () -> LayerDefinition.create(WolfArmorModel.createMeshDefinition(new CubeDeformation(0.2F)), 64, 32));

        // Tricky Trials
        event.registerLayerDefinition(ModModelLayers.WIND_CHARGE, WindChargeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SHELF.get(), ShelfRenderer::new);
    }

    @SubscribeEvent public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, level, pos, tint) -> level != null && pos != null
                        ? BiomeColors.getAverageGrassColor(level, pos)
                        : GrassColor.getDefaultColor(),
                ModBlocks.BUSH.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, i) -> i != 1 ? -1 : WolfArmorItem.getColorOrDefault(stack, 0), ModItems.WOLF_ARMOR.get());
        event.register((stack, layer) -> 0xFFFFFF, Items.ALLAY_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.AXOLOTL_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.BAT_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.BEE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.BLAZE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.CAMEL_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.CAT_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.CAVE_SPIDER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.CHICKEN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.COD_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.COW_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.CREEPER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.DOLPHIN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.DONKEY_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.DROWNED_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ELDER_GUARDIAN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ENDER_DRAGON_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ENDERMAN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ENDERMITE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.EVOKER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.FOX_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.FROG_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.GHAST_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.GLOW_SQUID_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.GOAT_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.GUARDIAN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.HOGLIN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.HORSE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.HUSK_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.IRON_GOLEM_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.LLAMA_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.MAGMA_CUBE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.MOOSHROOM_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.MULE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.OCELOT_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PANDA_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PARROT_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PHANTOM_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PIG_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PIGLIN_BRUTE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PIGLIN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PILLAGER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.POLAR_BEAR_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.PUFFERFISH_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.RABBIT_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.RAVAGER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SALMON_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SHEEP_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SHULKER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SILVERFISH_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SKELETON_HORSE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SKELETON_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SLIME_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SNIFFER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SNOW_GOLEM_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SPIDER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.SQUID_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.STRAY_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.STRIDER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.TADPOLE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.TRADER_LLAMA_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.TROPICAL_FISH_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.TURTLE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.VILLAGER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.VEX_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.VINDICATOR_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.WANDERING_TRADER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.WARDEN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.WITCH_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.WITHER_SKELETON_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.WITHER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.WOLF_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ZOGLIN_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIE_HORSE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIE_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIE_VILLAGER_SPAWN_EGG);
        event.register((stack, layer) -> 0xFFFFFF, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
        event.register((stack, tintIndex) -> GrassColor.getDefaultColor(), ModBlocks.BUSH.get());
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        // Bats and Pots
        event.registerSpriteSet(ModParticles.DUST_PLUME.get(), DustPlumeParticle.Provider::new);

        // Spring to Life
        event.registerSpriteSet(ModParticles.FIREFLY.get(), FireflyParticle.Provider::new);
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();

        for (String blockName : EMISSIVE_BLOCKS) {
            ModelResourceLocation blockModelLocation = new ModelResourceLocation(ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, blockName), "");

            BakedModel baseModel = modelRegistry.get(blockModelLocation);
            if (baseModel == null) continue;

            ResourceLocation emissiveModelLocation = ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "block/" + blockName + EMISSIVE_SUFFIX);

            BakedModel emissiveModel = modelRegistry.get(emissiveModelLocation);
            if (emissiveModel == null) continue;

            BakedModel wrappedModel = new EmissiveModelWrapper(baseModel, emissiveModel);
            modelRegistry.put(blockModelLocation, wrappedModel);
        }
    }

    @SubscribeEvent
    public static void onRegisterAdditionalModels(ModelEvent.RegisterAdditional event) {
        for (String blockName : EMISSIVE_BLOCKS) {
            ResourceLocation emissiveModelLocation = ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "block/" + blockName + EMISSIVE_SUFFIX);
            event.register(emissiveModelLocation);
        }
    }

    private static final String[] EMISSIVE_BLOCKS = {
            // "open_eyeblossom",
            // "potted_open_eyeblossom",
            "firefly_bush"
    };

    private static final String EMISSIVE_SUFFIX = "_emissive";
}
