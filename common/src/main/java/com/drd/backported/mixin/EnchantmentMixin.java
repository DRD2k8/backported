package com.drd.backported.mixin;

import com.drd.backported.item.SpearItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.SweepingEdgeEnchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {
    @Shadow @Final
    public EnchantmentCategory category;

    @Inject(
            method = "canEnchant",
            at = @At("HEAD"),
            cancellable = true
    )
    private void allowSpears(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (this.category == EnchantmentCategory.WEAPON
                && !((Object) this instanceof SweepingEdgeEnchantment)
                && stack.getItem() instanceof SpearItem) {
            cir.setReturnValue(true);
        }
    }
}
