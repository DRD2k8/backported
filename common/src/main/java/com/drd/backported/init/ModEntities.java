package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.entity.WindCharge;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Backported.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<WindCharge>> WIND_CHARGE = ENTITIES.register("wind_charge",
            () -> EntityType.Builder.<WindCharge>of(WindCharge::new, MobCategory.MISC).sized(0.3125f, 0.3125f).clientTrackingRange(4).updateInterval(10).build("wind_charge"));

    public static void register() {
        ENTITIES.register();
    }
}
