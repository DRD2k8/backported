package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.enchantment.LungeEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Backported.MOD_ID);

    public static final RegistryObject<Enchantment> LUNGE = ENCHANTMENTS.register("lunge", () -> new LungeEnchantment());

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
