package com.drd.backported.block;

import com.drd.backported.Backported;
import com.drd.backported.block.base.IHangingSign;
import com.drd.backported.block.entity.CustomHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CustomCeilingHangingSignBlock extends CeilingHangingSignBlock implements IHangingSign {
    private final ResourceLocation guiTexture;

    public CustomCeilingHangingSignBlock(Properties properties, WoodType type) {
        super(properties, type);
        ResourceLocation location = new ResourceLocation(type.name());
        this.guiTexture = new ResourceLocation(Backported.MOD_ID, "textures/gui/hanging_signs/" + location.getPath());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CustomHangingSignBlockEntity(pPos, pState);
    }

    @Override
    public ResourceLocation getGuiTexture() {
        return guiTexture;
    }
}
