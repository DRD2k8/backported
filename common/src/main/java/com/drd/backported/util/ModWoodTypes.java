package com.drd.backported.util;

import com.drd.backported.Backported;
import com.drd.backported.mixin.WoodTypeInvoker;
import dev.architectury.injectables.targets.ArchitecturyTarget;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PALE_OAK = registerWoodType("pale_oak");

    private static WoodType registerWoodType(String name) {
        return WoodTypeInvoker.backported$register(new WoodType(ArchitecturyTarget.getCurrentTarget().equals("forge") ? Backported.MOD_ID + ":" + name : name, BlockSetType.OAK));
    }
}
