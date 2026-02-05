package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.entity.projectile.WindCharge;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Backported.MOD_ID);

    public static final RegistryObject<EntityType<WindCharge>> WIND_CHARGE = ENTITIES.register("wind_charge",
            () -> EntityType.Builder.<WindCharge>of(WindCharge::new, MobCategory.MISC).sized(0.3125f, 0.3125f).clientTrackingRange(4).updateInterval(10).build("wind_charge"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
