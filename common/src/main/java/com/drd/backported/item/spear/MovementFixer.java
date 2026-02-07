package com.drd.backported.item.spear;

import net.minecraft.world.phys.Vec3;

public interface MovementFixer {
    Vec3 getMovement();

    default void setMovement(Vec3 movement) {
    }
}
