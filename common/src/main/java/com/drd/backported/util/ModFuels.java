package com.drd.backported.util;

import com.drd.backported.init.ModItems;
import dev.architectury.registry.fuel.FuelRegistry;

public class ModFuels {
    public static void registerFuels() {
        FuelRegistry.register(200, ModItems.WOODEN_SPEAR.get());
    }
}
