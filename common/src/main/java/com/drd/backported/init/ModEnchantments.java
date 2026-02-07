package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.enchantment.LungeEnchantment;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Backported.MOD_ID, Registries.ENCHANTMENT);

    public static final RegistrySupplier<Enchantment> LUNGE = ENCHANTMENTS.register("lunge", () -> new LungeEnchantment());

    public static void register() {
        ENCHANTMENTS.register();
    }
}
