package com.drd.backported.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class CommonPlatformUtils {
    @ExpectPlatform
    public static <T extends Entity> Supplier<EntityType<T>> registerBoat(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height, int clientTrackingRange) {
        throw new AssertionError();
    }
}
