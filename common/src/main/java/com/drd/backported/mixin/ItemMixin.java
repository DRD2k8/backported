package com.drd.backported.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(method = "getMaxStackSize", at = @At("HEAD"), cancellable = true)
    private void potMaxStackSize(CallbackInfoReturnable<Integer> cir) {
        Item self = (Item)(Object)this;

        if (self == Items.DECORATED_POT) {
            cir.setReturnValue(64);
        }
    }
}
