package com.drd.backported.mixin;

import com.drd.backported.item.SpearItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow @Final
    private ItemModelShaper itemModelShaper;

    @ModifyVariable(
            method = "render",
            at = @At("HEAD"),
            argsOnly = true
    )
    private BakedModel backported$swapSpearModel(
            BakedModel originalModel,
            ItemStack stack,
            ItemDisplayContext context,
            boolean leftHanded,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int light,
            int overlay
    ) {
        boolean isSpear = stack.getItem() instanceof SpearItem;
        boolean guiLike =
                context == ItemDisplayContext.GUI ||
                        context == ItemDisplayContext.GROUND ||
                        context == ItemDisplayContext.FIXED;

        if (isSpear && guiLike) {
            return this.itemModelShaper.getItemModel(stack);
        }

        return originalModel;
    }
}
