package com.drd.backported.item;

import com.drd.backported.Backported;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WolfArmorItem extends Item {
    private final int protection;
    private final ResourceLocation texture;

    public WolfArmorItem(int i, Item.Properties arg) {
        this(i, new ResourceLocation(Backported.MOD_ID, "textures/entity/horse/armor/wolf_armor.png"), arg);
    }

    public WolfArmorItem(int i, ResourceLocation arg, Item.Properties arg2) {
        super(arg2);
        this.protection = i;
        this.texture = arg;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public int getProtection() {
        return this.protection;
    }
}
