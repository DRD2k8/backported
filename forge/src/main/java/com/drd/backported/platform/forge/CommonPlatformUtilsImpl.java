package com.drd.backported.platform.forge;

import com.drd.backported.init.ModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

import java.util.function.Supplier;

public class CommonPlatformUtilsImpl {
    public static <T extends Entity> Supplier<EntityType<T>> registerBoat(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height, int clientTrackingRange) {
        return ModEntities.ENTITIES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(name));
    }

    public static void registerCompostable(Item item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }
}
