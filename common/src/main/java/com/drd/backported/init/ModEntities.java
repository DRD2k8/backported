package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.entity.CustomBoat;
import com.drd.backported.entity.CustomChestBoat;
import com.drd.backported.entity.WindCharge;
import com.drd.backported.platform.CommonPlatformUtils;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Backported.MOD_ID, Registries.ENTITY_TYPE);

    public static final Supplier<EntityType<CustomBoat>> BOAT = CommonPlatformUtils.registerBoat("boat", CustomBoat::new, MobCategory.MISC, 1.375F, 0.5625F, 10);
    public static final Supplier<EntityType<CustomChestBoat>> CHEST_BOAT = CommonPlatformUtils.registerBoat("chest_boat", CustomChestBoat::new, MobCategory.MISC, 1.375F, 0.5625F, 10);

    public static final RegistrySupplier<EntityType<WindCharge>> WIND_CHARGE = ENTITIES.register("wind_charge",
            () -> EntityType.Builder.<WindCharge>of(WindCharge::new, MobCategory.MISC).sized(0.3125f, 0.3125f).clientTrackingRange(4).updateInterval(10).build("wind_charge"));

    public static void register() {
        ENTITIES.register();
    }
}
