package com.drd.backported.init;

import com.drd.backported.Backported;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModBannerPatterns {
    public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Backported.MOD_ID, Registries.BANNER_PATTERN);

    public static final RegistrySupplier<BannerPattern> FLOW = registerBannerPattern("flow");
    public static final RegistrySupplier<BannerPattern> GUSTER = registerBannerPattern("guster");

    private static RegistrySupplier<BannerPattern> registerBannerPattern(String name) {
        return BANNER_PATTERNS.register(name, () -> new BannerPattern("backported_" + name));
    }

    public static void register() {
        BANNER_PATTERNS.register();
    }
}
