package com.drd.backported.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class CommonPlatformUtils {
    @ExpectPlatform
    public static <T extends Entity> Supplier<EntityType<T>> registerBoat(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height, int clientTrackingRange) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerCompostable(Item item, float chance) {
        throw new AssertionError();
    }
}
