package com.drd.backported.block;

import com.drd.backported.block.base.WeatheringCopper;
import com.drd.backported.util.ModBlockSetTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperTrapdoorBlock extends TrapDoorBlock implements WeatheringCopper {
    private final WeatherState weatherState;

    public WeatheringCopperTrapdoorBlock(WeatherState weatherState, Properties properties) {
        super(properties, ModBlockSetTypes.COPPER);
        this.weatherState = weatherState;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.onRandomTick(blockState, serverLevel, blockPos, randomSource);
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopper.getNext(blockState.getBlock()).isPresent();
    }

    public WeatherState getAge() {
        return this.weatherState;
    }
}
