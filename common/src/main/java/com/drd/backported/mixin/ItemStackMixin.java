package com.drd.backported.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(method = "isStackable", at = @At("HEAD"), cancellable = true)
    private void backported$allowPotStacking(CallbackInfoReturnable<Boolean> cir) {
        ItemStack self = (ItemStack)(Object)this;

        if (self.getItem() == Items.DECORATED_POT) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "isSameItemSameTags", at = @At("HEAD"), cancellable = true)
    private static void backported$isSameItem(ItemStack a, ItemStack b, CallbackInfoReturnable<Boolean> cir) {
        if (a.getItem() == Items.DECORATED_POT && b.getItem() == Items.DECORATED_POT) {
            cir.setReturnValue(true);
        }
    }
}
