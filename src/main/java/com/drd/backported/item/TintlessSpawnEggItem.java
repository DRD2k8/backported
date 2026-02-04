package com.drd.backported.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;

public class TintlessSpawnEggItem extends SpawnEggItem {
    public TintlessSpawnEggItem(EntityType<? extends Mob> entityType, Properties properties) {
        super(entityType, 0xFFFFFF, 0xFFFFFF, properties);
    }
}
