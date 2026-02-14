package com.drd.backported.block;

import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public class WaterloggedTransparentBlock extends GlassBlock implements SimpleWaterloggedBlock {
    public WaterloggedTransparentBlock(Properties properties) {
        super(properties);
    }
}
