package com.drd.backported.init;

import com.drd.backported.Backported;
import dev.thomasglasser.sherdsapi.impl.Sherd;
import dev.thomasglasser.sherdsapi.impl.SherdsApiRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ModSherds {
    public static final ResourceKey<Sherd> FLOW = registerSherd("flow");
    public static final ResourceKey<Sherd> GUSTER = registerSherd("guster");
    public static final ResourceKey<Sherd> SCRAPE = registerSherd("scrape");

    private static ResourceKey<Sherd> registerSherd(String id) {
        return ResourceKey.create(SherdsApiRegistries.SHERD, new ResourceLocation(Backported.MOD_ID, id + "_pottery_pattern"));
    }

    public static void register() {
    }
}
