package com.drd.backported.client.model.armor;

import com.drd.backported.Backported;
import com.drd.backported.client.init.ModModelLayers;
import com.drd.backported.client.model.LazyModel;
import com.drd.backported.init.ModItems;
import com.drd.backported.item.WolfArmorItem;
import com.drd.backported.util.ModCrackiness;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class WolfArmorLayer extends RenderLayer<Wolf, WolfModel<Wolf>> {
    private static final Map<ModCrackiness.Level, ResourceLocation> ARMOR_CRACK_LOCATIONS = Map.of(
            ModCrackiness.Level.LOW, new ResourceLocation(Backported.MOD_ID, "textures/entity/wolf/wolf_armor_crackiness_low.png"),
            ModCrackiness.Level.MEDIUM, new ResourceLocation(Backported.MOD_ID, "textures/entity/wolf/wolf_armor_crackiness_medium.png"),
            ModCrackiness.Level.HIGH, new ResourceLocation(Backported.MOD_ID, "textures/entity/wolf/wolf_armor_crackiness_high.png")
    );
    private final LazyModel<Wolf, WolfModel<Wolf>> model;

    public WolfArmorLayer(RenderLayerParent<Wolf, WolfModel<Wolf>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = LazyModel.of(models, ModModelLayers.WOLF_ARMOR, WolfModel::new);
    }

    @Override
    public void render(
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            Wolf wolf,
            float limbSwing,
            float limbSwingAmount,
            float partialTick,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        if (!wolf.getItemBySlot(EquipmentSlot.CHEST).isEmpty() && wolf.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.WOLF_ARMOR.get())) {
            ItemStack stack = wolf.getItemBySlot(EquipmentSlot.CHEST);
            if (stack.getItem() instanceof WolfArmorItem armor) {
                this.getParentModel().copyPropertiesTo(this.model.get());
                this.model.get().prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTick);
                this.model.get().setupAnim(wolf, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                VertexConsumer vertices = buffer.getBuffer(RenderType.entityCutoutNoCull(armor.getTexture()));
                this.model.get().renderToBuffer(poseStack, vertices, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                this.maybeRenderColoredLayer(poseStack, buffer, packedLight, stack, armor);
                this.maybeRenderCracks(poseStack, buffer, packedLight, stack);
            }
        }
    }

    private void maybeRenderColoredLayer(PoseStack poseStack, MultiBufferSource buffer, int packedLight, ItemStack stack, WolfArmorItem armor) {
        ResourceLocation overlay = armor.getOverlayTexture();
        if (overlay == null) return;

        int color = WolfArmorItem.getColorOrDefault(stack, 0);

        if (color == 10511680) return;

        float red = (float)(color >> 16 & 0xFF) / 255.0F;
        float green = (float)(color >> 8 & 0xFF) / 255.0F;
        float blue = (float)(color & 0xFF) / 255.0F;

        VertexConsumer vertices = buffer.getBuffer(RenderType.entityCutoutNoCull(overlay));
        this.model.get().renderToBuffer(poseStack, vertices, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);
    }

    private void maybeRenderCracks(PoseStack poseStack, MultiBufferSource buffer, int packedLight, ItemStack stack) {
        ModCrackiness.Level level = ModCrackiness.WOLF_ARMOR.byDamage(stack);
        if (level != ModCrackiness.Level.NONE) {
            ResourceLocation texture = ARMOR_CRACK_LOCATIONS.get(level);
            VertexConsumer vertices = buffer.getBuffer(RenderType.entityTranslucent(texture));
            this.model.get().renderToBuffer(poseStack, vertices, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
