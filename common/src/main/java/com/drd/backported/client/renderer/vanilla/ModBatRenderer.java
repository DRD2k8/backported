package com.drd.backported.client.renderer.vanilla;

import com.drd.backported.client.init.ModModelLayers;
import com.drd.backported.client.model.vanilla.ModBatModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ambient.Bat;

public class ModBatRenderer extends MobRenderer<Bat, ModBatModel> {
    private static final ResourceLocation BAT_TEXTURE = new ResourceLocation("textures/entity/bat.png");

    public ModBatRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new ModBatModel(ctx.bakeLayer(ModModelLayers.BAT)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Bat bat) {
        return BAT_TEXTURE;
    }

    @Override
    protected void scale(Bat bat, PoseStack poseStack, float f) {
        poseStack.scale(1.1875F, 1.1875F, 1.1875F);
    }

    @Override
    protected void setupRotations(Bat bat, PoseStack poseStack, float f, float g, float h) {
        if (bat.isResting()) {
            poseStack.translate(0.0F, -0.1F, 0.0F);
        } else {
            poseStack.translate(0.0F, Mth.cos(f * 0.3F) * 0.1F, 0.0F);
        }
        super.setupRotations(bat, poseStack, f, g, h);
    }
}
