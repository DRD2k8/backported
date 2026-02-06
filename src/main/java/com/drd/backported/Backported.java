package com.drd.backported;

import com.drd.backported.client.init.ModModelLayers;
import com.drd.backported.client.model.WindChargeModel;
import com.drd.backported.client.renderer.WindChargeRenderer;
import com.drd.backported.init.*;
import com.drd.backported.item.client.SpearSync;
import com.drd.backported.packets.PacketHandler;
import com.drd.backported.packets.PlayerStabPacket;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Backported.MOD_ID)
public class Backported {
    public static final String MOD_ID = "backported";

    public Backported(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModBlocks.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.WIND_CHARGE.get(), WindChargeRenderer::new);
            if (SpearSync.syncSpears == null) {
                SpearSync.syncSpears = (i) -> {
                    PacketHandler.sendToServer(new PlayerStabPacket(i));
                    return true;
                };
            }
        }

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.WIND_CHARGE, WindChargeModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void removeSpawnEggColors(RegisterColorHandlersEvent.Item event) {
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
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CreativeTabPlacements {
        interface Entries {
            void addBefore(ItemLike reference, ItemLike... values);
            void addAfter(ItemLike reference, ItemLike... values);
        }

        @SubscribeEvent
        public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
            var tab = event.getTabKey();
            var entries = new Entries() {
                @Override
                public void addBefore(ItemLike reference, ItemLike... values) {
                    for (ItemLike value : values) {
                        event.getEntries().putBefore(new ItemStack(reference), new ItemStack(value), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    }
                }

                @Override
                public void addAfter(ItemLike reference, ItemLike... values) {
                    for (ItemLike value : values) {
                        event.getEntries().putAfter(new ItemStack(reference), new ItemStack(value), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    }
                }
            };

            if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
                entries.addAfter(Items.STONE_HOE,
                        ModItems.COPPER_HOE.get(),
                        ModItems.COPPER_AXE.get(),
                        ModItems.COPPER_PICKAXE.get(),
                        ModItems.COPPER_SHOVEL.get()
                );
            }

            if (tab == CreativeModeTabs.COMBAT) {
                entries.addAfter(Items.STONE_SWORD,
                        ModItems.COPPER_SWORD.get()
                );
                entries.addBefore(Items.WOODEN_AXE,
                        ModItems.WOODEN_SPEAR.get(),
                        ModItems.STONE_SPEAR.get(),
                        ModItems.COPPER_SPEAR.get(),
                        ModItems.IRON_SPEAR.get(),
                        ModItems.GOLDEN_SPEAR.get(),
                        ModItems.DIAMOND_SPEAR.get(),
                        ModItems.NETHERITE_SPEAR.get()
                );
                entries.addAfter(Items.TRIDENT,
                        ModItems.MACE.get()
                );
                entries.addAfter(Items.LEATHER_BOOTS,
                        ModItems.COPPER_BOOTS.get(),
                        ModItems.COPPER_LEGGINGS.get(),
                        ModItems.COPPER_CHESTPLATE.get(),
                        ModItems.COPPER_HELMET.get()
                );
                entries.addAfter(Items.EGG,
                        ModItems.WIND_CHARGE.get()
                );
            }

            if (tab == CreativeModeTabs.INGREDIENTS) {
                entries.addBefore(Items.IRON_NUGGET,
                        ModItems.COPPER_NUGGET.get()
                );
                entries.addAfter(Items.BLAZE_ROD,
                        ModBlocks.HEAVY_CORE.get(),
                        ModItems.BREEZE_ROD.get()
                );
            }
        }
    }
}
