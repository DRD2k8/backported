package com.drd.backported.enchantment;

import com.drd.backported.item.SpearItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LungeEnchantment extends Enchantment {
    public LungeEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    public int getMaxLevel() {
        return 3;
    }

    public int getMinCost(int level) {
        return 5 + level * 8;
    }

    public int getMaxCost(int level) {
        return this.getMinCost(level) + 20;
    }

    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof SpearItem;
    }
}
