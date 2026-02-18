package com.drd.backported.client.renderer.vanilla;

import com.drd.backported.client.model.armor.WolfArmorLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;

public class ModWolfRenderer extends WolfRenderer {
    public ModWolfRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.addLayer(new WolfArmorLayer(this, ctx.getModelSet()));
    }
}
