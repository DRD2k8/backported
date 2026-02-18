package com.drd.backported.item;

import com.drd.backported.Backported;
import com.drd.backported.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WolfArmorItem extends Item implements DyeableLeatherItem {
    private static final ResourceLocation TEX_FOLDER = new ResourceLocation(Backported.MOD_ID, "textures/entity/horse/armor/wolf_armor");
    private final int protection;
    private final ResourceLocation texture;
    private final ResourceLocation overlay;

    public WolfArmorItem(Item.Properties arg) {
        this(11, TEX_FOLDER.withSuffix(".png"), TEX_FOLDER.withSuffix("_overlay.png"), arg);
    }

    public WolfArmorItem(int i, ResourceLocation arg, ResourceLocation arg2, Item.Properties arg3) {
        super(arg3);
        this.protection = i;
        this.texture = arg;
        this.overlay = arg2;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public ResourceLocation getOverlayTexture() {
        return this.overlay;
    }

    public int getProtection() {
        return this.protection;
    }

    public static int getColorOrDefault(ItemStack stack, int fallback) {
        if (stack.getItem() instanceof DyeableLeatherItem item) {
            return item.getColor(stack);
        }

        return fallback;
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        return ingredient.is(ModItems.ARMADILLO_SCUTE.get()) || super.isValidRepairItem(stack, ingredient);
    }
}
