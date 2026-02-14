package com.drd.backported.block.base;

import com.drd.backported.init.ModBlocks;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public interface WeatheringCopper extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    Supplier<ImmutableBiMap<Object, Object>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.builder()
                .put(ModBlocks.CHISELED_COPPER.get(), ModBlocks.EXPOSED_CHISELED_COPPER.get())
                .put(ModBlocks.EXPOSED_CHISELED_COPPER.get(), ModBlocks.WEATHERED_CHISELED_COPPER.get())
                .put(ModBlocks.WEATHERED_CHISELED_COPPER.get(), ModBlocks.OXIDIZED_CHISELED_COPPER.get())

                .put(ModBlocks.COPPER_GRATE.get(), ModBlocks.EXPOSED_COPPER_GRATE.get())
                .put(ModBlocks.EXPOSED_COPPER_GRATE.get(), ModBlocks.WEATHERED_COPPER_GRATE.get())
                .put(ModBlocks.WEATHERED_COPPER_GRATE.get(), ModBlocks.OXIDIZED_COPPER_GRATE.get())

                .put(ModBlocks.COPPER_DOOR.get(), ModBlocks.EXPOSED_COPPER_DOOR.get())
                .put(ModBlocks.EXPOSED_COPPER_DOOR.get(), ModBlocks.WEATHERED_COPPER_DOOR.get())
                .put(ModBlocks.WEATHERED_COPPER_DOOR.get(), ModBlocks.OXIDIZED_COPPER_DOOR.get())

                .put(ModBlocks.COPPER_TRAPDOOR.get(), ModBlocks.EXPOSED_COPPER_TRAPDOOR.get())
                .put(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get(), ModBlocks.WEATHERED_COPPER_TRAPDOOR.get())
                .put(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get(), ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get())

                .put(ModBlocks.COPPER_BULB.get(), ModBlocks.EXPOSED_COPPER_BULB.get())
                .put(ModBlocks.EXPOSED_COPPER_BULB.get(), ModBlocks.WEATHERED_COPPER_BULB.get())
                .put(ModBlocks.WEATHERED_COPPER_BULB.get(), ModBlocks.OXIDIZED_COPPER_BULB.get())

                .put(ModBlocks.COPPER_CHAIN.get(), ModBlocks.EXPOSED_COPPER_CHAIN.get())
                .put(ModBlocks.EXPOSED_COPPER_CHAIN.get(), ModBlocks.WEATHERED_COPPER_CHAIN.get())
                .put(ModBlocks.WEATHERED_COPPER_CHAIN.get(), ModBlocks.OXIDIZED_COPPER_CHAIN.get())
                .build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return ((BiMap)NEXT_BY_BLOCK.get()).inverse();
    });

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable((Block)((BiMap)PREVIOUS_BY_BLOCK.get()).get(block));
    }

    static Block getFirst(Block block) {
        Block block2 = block;

        for(Block block3 = (Block)((BiMap)PREVIOUS_BY_BLOCK.get()).get(block2); block3 != null; block3 = (Block)((BiMap)PREVIOUS_BY_BLOCK.get()).get(block2)) {
            block2 = block3;
        }

        return block2;
    }

    static Optional<BlockState> getPrevious(BlockState blockState) {
        return getPrevious(blockState.getBlock()).map((block) -> {
            return block.withPropertiesOf(blockState);
        });
    }

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable((Block)((BiMap)NEXT_BY_BLOCK.get()).get(block));
    }

    static BlockState getFirst(BlockState blockState) {
        return getFirst(blockState.getBlock()).withPropertiesOf(blockState);
    }

    default Optional<BlockState> getNext(BlockState blockState) {
        return getNext(blockState.getBlock()).map((block) -> {
            return block.withPropertiesOf(blockState);
        });
    }

    default float getChanceModifier() {
        return this.getAge() == WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum WeatherState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED;

        private WeatherState() {
        }
    }
}
