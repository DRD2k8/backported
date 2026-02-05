package com.drd.backported.item;

import com.drd.backported.init.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;

public class SpearItem extends TieredItem {
    private final float swingSeconds;
    private final float chargeDamageMultiplier;
    private final float chargeDelaySeconds;
    private final float maxDismountSeconds;
    private final float minSpeedForDismount;
    private final float maxKnockbackSeconds;
    private final float minSpeedForKnockback;
    private final float maxChargeDamageSeconds;
    private final float minRelativeSpeedForDamage;

    private final SoundEvent useSound;
    private final SoundEvent hitSound;
    private final SoundEvent attackSound;

    private final Multimap<Attribute, AttributeModifier> attributes;

    public SpearItem(
            Tier material,
            float swingSeconds,
            float chargeDamageMultiplier,
            float chargeDelaySeconds,
            float maxDismountSeconds,
            float minSpeedForDismount,
            float maxKnockbackSeconds,
            float minSpeedForKnockback,
            float maxChargeDamageSeconds,
            float minRelativeSpeedForDamage,
            Properties props
    ) {
        super(material, applySpearProperties(material, props));

        this.swingSeconds = swingSeconds;
        this.chargeDamageMultiplier = chargeDamageMultiplier;
        this.chargeDelaySeconds = chargeDelaySeconds;
        this.maxDismountSeconds = maxDismountSeconds;
        this.minSpeedForDismount = minSpeedForDismount;
        this.maxKnockbackSeconds = maxKnockbackSeconds;
        this.minSpeedForKnockback = minSpeedForKnockback;
        this.maxChargeDamageSeconds = maxChargeDamageSeconds;
        this.minRelativeSpeedForDamage = minRelativeSpeedForDamage;

        if (material == Tiers.WOOD) {
            this.useSound = ModSounds.SPEAR_WOOD_USE.get();
            this.hitSound = ModSounds.SPEAR_WOOD_HIT.get();
            this.attackSound = ModSounds.SPEAR_WOOD_ATTACK.get();
        } else {
            this.useSound = ModSounds.SPEAR_USE.get();
            this.hitSound = ModSounds.SPEAR_HIT.get();
            this.attackSound = ModSounds.SPEAR_ATTACK.get();
        }

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                        BASE_ATTACK_DAMAGE_UUID,
                        "Spear damage",
                        material.getAttackDamageBonus(),
                        AttributeModifier.Operation.ADDITION
                )
        );

        builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(
                        BASE_ATTACK_SPEED_UUID,
                        "Spear speed",
                        1.0F / swingSeconds - 4.0F,
                        AttributeModifier.Operation.ADDITION
                )
        );

        this.attributes = builder.build();
    }

    private static Properties applySpearProperties(Tier material, Properties props) {
        props = props.durability(material.getUses());
        if (material == Tiers.NETHERITE) {
            props = props.fireResistant();
        }
        return props;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return this.getTier().getRepairIngredient().test(repair)
                || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? attributes : super.getDefaultAttributeModifiers(slot);
    }

    public int getSwingTicks() { return (int)(swingSeconds * 20F); }
    public int getChargeDelayTicks() { return (int)(chargeDelaySeconds * 20F); }
    public int getMaxDismountTicks() { return (int)(maxDismountSeconds * 20F); }
    public int getMaxKnockbackTicks() { return (int)(maxKnockbackSeconds * 20F); }
    public int getMaxChargeDamageTicks() { return (int)(maxChargeDamageSeconds * 20F); }

    public SoundEvent getUseSound() { return useSound; }
    public SoundEvent getHitSound() { return hitSound; }
    public SoundEvent getAttackSound() { return attackSound; }
}
