package com.drd.backported.mixin;

import com.drd.backported.item.SpearItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DamageEnchantment.class})
public abstract class DamageEnchantmentMixin {
    public DamageEnchantmentMixin() {
    }

    @Inject(
            method = {"canEnchant"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void allowSpears(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() instanceof SpearItem) {
            cir.setReturnValue(true);
        }
    }
}

