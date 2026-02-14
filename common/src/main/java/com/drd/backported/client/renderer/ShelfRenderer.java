package com.drd.backported.client.renderer;

import com.drd.backported.block.ShelfBlock;
import com.drd.backported.block.entity.ShelfBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ShelfRenderer implements BlockEntityRenderer<ShelfBlockEntity> {
    private static final float ITEM_SIZE = 0.25F;
    private static final float SLOT_OFFSET = 0.3125F;
    private static final float ALIGN_ITEMS_TO_BOTTOM_OFFSET = -0.25F;

    private static final float BANNER_SCALE = 0.5F;
    private static final float BANNER_Y_OFFSET = -0.1F;

    private final ItemRenderer itemRenderer;

    public ShelfRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ShelfBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Direction direction = blockEntity.getBlockState().getValue(ShelfBlock.FACING);
        NonNullList<ItemStack> items = blockEntity.getItems();
        int seed = (int) blockEntity.getBlockPos().asLong();
        boolean alignToBottom = blockEntity.getAlignItemsToBottom();

        float rotation = direction.getAxis().isHorizontal() ? -direction.toYRot() : 180.0F;

        for (int i = 0; i < items.size(); i++) {
            ItemStack itemStack = items.get(i);
            if (itemStack.isEmpty()) continue;

            poseStack.pushPose();

            poseStack.translate(0.5F, 0.5F, 0.5F);

            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

            float horizontalOffset = (i - 1) * SLOT_OFFSET;
            float verticalOffset = alignToBottom ? ALIGN_ITEMS_TO_BOTTOM_OFFSET : 0.0F;
            float depthOffset = -0.25F;

            poseStack.translate(horizontalOffset, verticalOffset, depthOffset);

            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

            float scale = getItemScale(itemStack);
            float yOffset = getItemYOffset(itemStack);

            poseStack.translate(0.0F, yOffset, 0.0F);
            poseStack.scale(scale, scale, scale);

            this.itemRenderer.renderStatic(
                    itemStack,
                    ItemDisplayContext.FIXED,
                    packedLight,
                    packedOverlay,
                    poseStack,
                    bufferSource,
                    blockEntity.getLevel(),
                    seed + i
            );

            poseStack.popPose();
        }
    }

    private float getItemScale(ItemStack itemStack) {
        if (itemStack.getItem() instanceof BannerItem) {
            return BANNER_SCALE;
        }
        return ITEM_SIZE;
    }

    private float getItemYOffset(ItemStack itemStack) {
        if (itemStack.getItem() instanceof BannerItem) {
            return BANNER_Y_OFFSET;
        }
        return 0.0F;
    }
}
