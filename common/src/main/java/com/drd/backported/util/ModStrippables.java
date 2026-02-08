package com.drd.backported.util;

import com.drd.backported.init.ModBlocks;
import dev.architectury.hooks.item.tool.AxeItemHooks;
import net.minecraft.world.level.block.Block;

public class ModStrippables {
    public static void register() {
        addStrippable(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        addStrippable(ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
    }

    private static void addStrippable(Block from, Block to) {
        AxeItemHooks.addStrippable(from, to);
    }
}
