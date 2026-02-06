package com.drd.backported.item;

import com.drd.backported.init.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class SpearItem extends TieredItem {
    private static final float STAGE1_TIME = 0.5f;
    private static final float STAGE2_TIME = 1.0f;

    private final float baseReach = 3.0f;
    private final float extraReach = 3.5f;
    private final float moveDamageScale = 4.0f;

    private final Multimap<Attribute, AttributeModifier> attributes;
    private final boolean isWooden;

    public SpearItem(Tier tier, Properties props, double attackSpeed) {
        super(tier, props);

        this.isWooden = tier == Tiers.WOOD;

        float baseDamage = tier.getAttackDamageBonus();

        double vanillaAttackSpeed = attackSpeed - 4.0;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder =
                ImmutableMultimap.builder();

        builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Spear damage", baseDamage, AttributeModifier.Operation.ADDITION)
        );

        builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Spear speed", vanillaAttackSpeed, AttributeModifier.Operation.ADDITION)
        );

        this.attributes = builder.build();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            level.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    isWooden ? ModSounds.SPEAR_WOOD_USE.get() : ModSounds.SPEAR_USE.get(),
                    player.getSoundSource(),
                    1.0f,
                    1.0f
            );
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int timeLeft) {
        if (!(living instanceof Player player)) return;

        int usedTicks = this.getUseDuration(stack) - timeLeft;
        float seconds = usedTicks / 20f;

        if (seconds < 0.1f) return;

        if (!level.isClientSide) {
            level.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    isWooden ? ModSounds.SPEAR_WOOD_ATTACK.get() : ModSounds.SPEAR_ATTACK.get(),
                    player.getSoundSource(),
                    1.0f,
                    1.0f
            );
        }

        float charge = Math.min(seconds / STAGE2_TIME, 1f);

        Vec3 motion = player.getDeltaMovement();
        double speed = Math.sqrt(motion.x * motion.x + motion.z * motion.z);
        float moveBonus = (float) speed * moveDamageScale;

        float finalDamage = (float) this.getTier().getAttackDamageBonus() + moveBonus * charge;

        float reach = baseReach + extraReach * charge;

        if (!level.isClientSide) {
            stab(level, player, finalDamage, reach);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }

        player.resetAttackStrengthTicker();

        player.getPersistentData().putInt("spear_throw_ticks", 6);
    }

    private void stab(Level level, Player player, float damage, float reach) {
        Vec3 eye = player.getEyePosition(1.0f);
        Vec3 look = player.getLookAngle().normalize();
        Vec3 end = eye.add(look.scale(reach));

        AABB box = new AABB(eye, end).inflate(0.5d);

        for (LivingEntity target : level.getEntitiesOfClass(LivingEntity.class, box,
                e -> e != player && e.isAlive())) {

            Vec3 toTarget = target.position().subtract(player.position());
            if (toTarget.dot(look) <= 0.0d) continue;

            target.hurt(level.damageSources().playerAttack(player), damage);

            level.playSound(
                    null,
                    target.getX(), target.getY(), target.getZ(),
                    isWooden ? ModSounds.SPEAR_WOOD_HIT.get() : ModSounds.SPEAR_HIT.get(),
                    player.getSoundSource(),
                    1.0f,
                    1.0f
            );
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? attributes : super.getDefaultAttributeModifiers(slot);
    }
}
