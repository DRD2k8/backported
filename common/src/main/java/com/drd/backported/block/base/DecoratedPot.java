package com.drd.backported.block.base;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.ticks.ContainerSingleItem;

public interface DecoratedPot extends ContainerSingleItem {
    void wobble(WobbleStyle style);

    WobbleStyle getLastWobbleStyle();

    long getWobbleStartedAtTick();

    BlockEntity getContainerBlockEntity();

    @Override
    default boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this.getContainerBlockEntity(), player);
    }
}
