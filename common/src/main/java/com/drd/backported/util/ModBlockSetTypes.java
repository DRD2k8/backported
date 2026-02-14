package com.drd.backported.util;

import com.drd.backported.init.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlockSetTypes {
    public static BlockSetType COPPER = new BlockSetType("copper", true,
            SoundType.COPPER, ModSounds.COPPER_DOOR_CLOSE.get(), ModSounds.COPPER_DOOR_OPEN.get(), ModSounds.COPPER_TRAPDOOR_CLOSE.get(), ModSounds.COPPER_TRAPDOOR_OPEN.get(),
            SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
}
