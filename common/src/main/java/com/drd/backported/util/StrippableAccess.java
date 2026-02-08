package com.drd.backported.util;

import net.minecraft.world.level.block.Block;

import java.util.Map;

public interface StrippableAccess {
    Map<Block, Block> getStrippables();
}
