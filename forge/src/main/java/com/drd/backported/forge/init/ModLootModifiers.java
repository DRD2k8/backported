package com.drd.backported.forge.init;

import com.drd.backported.Backported;
import com.drd.backported.forge.loot.AddItemModifier;
import com.drd.backported.forge.loot.WeightedLootModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Backported.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIERS.register("add_item", () -> AddItemModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> WEIGHTED_LOOT =
            LOOT_MODIFIERS.register("weighted_loot", () -> WeightedLootModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIERS.register(eventBus);
    }
}
