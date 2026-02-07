package com.drd.backported.mixin;

import com.drd.backported.item.SpearItem;
import com.drd.backported.item.spear.SpearUser;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin({LivingEntity.class})
public abstract class LivingEntityMixin implements SpearUser {
    @Unique
    private long spears$lastKineticAttackTime = -2147483648L;
    @Unique
    private @Nullable Object2LongMap<Entity> spears$piercingCooldowns;

    public LivingEntityMixin() {
    }

    @Shadow
    public abstract ItemStack m_21205_();

    @Shadow
    public abstract ItemStack m_21211_();

    @Shadow
    public abstract boolean m_21023_(MobEffect var1);

    @Shadow
    public abstract @Nullable MobEffectInstance m_21124_(MobEffect var1);

    @Inject(
            method = {"getCurrentSwingDuration"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void overrideSwingDurationForSpear(CallbackInfoReturnable<Integer> cir) {
        Item var3 = this.m_21205_().getItem();
        if (var3 instanceof SpearItem s) {
            LivingEntity me = (LivingEntity)(Object)this;
            int swing = s.swingTicks();
            if (MobEffectUtil.hasDigSpeed(me)) {
                cir.setReturnValue(swing - (1 + MobEffectUtil.getDigSpeedAmplification(me)));
            } else {
                cir.setReturnValue(this.m_21023_(MobEffects.DIG_SLOWDOWN) ? swing + (1 + ((MobEffectInstance) Objects.requireNonNull(this.m_21124_(MobEffects.DIG_SLOWDOWN))).getAmplifier()) * 2 : swing);
            }
        }
    }

    @Inject(
            method = {"startUsingItem"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;gameEvent(Lnet/minecraft/world/level/gameevent/GameEvent;)V"
            )}
    )
    private void recordPiercingCooldowns(InteractionHand hand, CallbackInfo ci) {
        if (this.m_21211_() != null && this.m_21211_().getItem() instanceof SpearItem) {
            this.spears$piercingCooldowns = new Object2LongOpenHashMap();
        }

    }

    @Inject(
            method = {"stopUsingItem"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;setLivingEntityFlag(IZ)V"
            )}
    )
    private void forgetPiercingCooldowns(CallbackInfo ci) {
        this.spears$piercingCooldowns = null;
    }

    @Inject(
            method = {"handleEntityEvent"},
            at = {@At("HEAD")}
    )
    private void handleKineticAttack(byte status, CallbackInfo ci) {
        if (status == 2) {
            this.spears$lastKineticAttackTime = ((LivingEntity)(Object)this).getCommandSenderWorld().getGameTime();
        }
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    private void tickPiercingCooldowns(CallbackInfo ci) {
        if (!((LivingEntity)(Object)this).getCommandSenderWorld().isClientSide() && this.spears$piercingCooldowns != null) {
            ObjectIterator var3 = this.spears$piercingCooldowns.keySet().iterator();

            while(true) {
                LivingEntity l;
                Entity e;
                do {
                    if (!var3.hasNext()) {
                        return;
                    }

                    e = (Entity)var3.next();
                    if (!(e instanceof LivingEntity)) {
                        break;
                    }

                    l = (LivingEntity)e;
                } while(l.hurtTime != 0);

                long l = this.spears$piercingCooldowns.getLong(e);
                if (l > 1L) {
                    this.spears$piercingCooldowns.replace(e, l - 1L);
                } else {
                    this.spears$piercingCooldowns.remove(e, l);
                }
            }
        }
    }

    public float getTimeSinceLastKineticAttack(float tickProgress) {
        LivingEntity me = (LivingEntity)(Object)this;
        return this.spears$lastKineticAttackTime < 0L ? 0.0F : (float)(me.getCommandSenderWorld().getGameTime() - this.spears$lastKineticAttackTime) + tickProgress;
    }

    public boolean isInPiercingCooldown(Entity target, int cooldownTicks) {
        if (this.spears$piercingCooldowns == null) {
            return false;
        } else {
            LivingEntity me = (LivingEntity)(Object)this;
            return this.spears$piercingCooldowns.containsKey(target) ? me.getCommandSenderWorld().getGameTime() - this.spears$piercingCooldowns.getLong(target) < (long)cooldownTicks : false;
        }
    }

    public void startPiercingCooldown(Entity target) {
        if (this.spears$piercingCooldowns != null) {
            LivingEntity me = (LivingEntity)(Object)this;
            this.spears$piercingCooldowns.put(target, me.getCommandSenderWorld().getGameTime());
        }

    }

    public int countSpearedMobs() {
        return this.spears$piercingCooldowns == null ? 0 : this.spears$piercingCooldowns.size();
    }

    public boolean pierce(EquipmentSlot slot, Entity target, float damage, boolean dealDamage, boolean knockback, boolean dismount) {
        LivingEntity attacker = (LivingEntity)(Object)this;
        Level var10 = attacker.getCommandSenderWorld();
        if (!(var10 instanceof ServerLevel serverWorld)) {
            return false;
        } else {
            DamageSource damageSource;
            float halfCD;
            MobType var10002;
            ItemStack itemStack;
            if (attacker instanceof Player player) {
                itemStack = attacker.getItemBySlot(slot);
                damageSource = attacker.damageSources().playerAttack(player);
                halfCD = attacker.isUsingItem() ? 1.0F : player.getAttackStrengthScale(0.5F);
                if (target instanceof LivingEntity l) {
                    var10002 = l.getMobType();
                } else {
                    var10002 = MobType.UNDEFINED;
                }

                float f = halfCD * (EnchantmentHelper.getDamageBonus(itemStack, var10002) + damage);
                if (!attacker.isUsingItem()) {
                    damage *= 0.2F + halfCD * halfCD * 0.8F;
                }

                if (target instanceof AbstractHurtingProjectile e) {
                    if (e.hurt(player.damageSources().mobAttack(player), damage)) {
                        return true;
                    }
                }

                float g = dealDamage ? damage + f : 0.0F;
                float h = 0.0F;
                if (target instanceof LivingEntity livingEntity) {
                    h = livingEntity.getHealth();
                }

                boolean bl = dealDamage && target.hurt(damageSource, g);
                float kb = (float)EnchantmentHelper.getKnockbackBonus(attacker) + (float)(attacker.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? attacker.getAttributeValue(Attributes.ATTACK_KNOCKBACK) : 0.0) + 0.4F;
                if (knockback) {
                    if (target instanceof LivingEntity) {
                        LivingEntity knockable = (LivingEntity)target;
                        knockable.knockback((double)kb, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
                    } else if (target instanceof PrimedTnt) {
                        double x = attacker.getX() - target.getX();
                        double z = attacker.getZ() - target.getZ();
                        target.hasImpulse = true;

                        Vec3 vec3d;
                        for(vec3d = target.getDeltaMovement(); x * x + z * z < 9.999999747378752E-6; z = (Math.random() - Math.random()) * 0.01) {
                            x = (Math.random() - Math.random()) * 0.01;
                        }

                        Vec3 vec3d2 = (new Vec3(x, 0.0, z)).normalize().scale((double)kb);
                        target.setDeltaMovement(vec3d.x / 2.0 - vec3d2.x, target.onGround() ? Math.min(0.4, vec3d.y / 2.0 + (double)kb) : vec3d.y, vec3d.z / 2.0 - vec3d2.z);
                    }
                }

                boolean bl2 = false;
                if (dismount && target.isPassenger()) {
                    bl2 = true;
                    target.stopRiding();
                }

                if (!bl && !knockback && !bl2) {
                    return false;
                } else {
                    MobType var10001;
                    if (target instanceof LivingEntity) {
                        LivingEntity l = (LivingEntity)target;
                        var10001 = l.getMobType();
                    } else {
                        var10001 = MobType.UNDEFINED;
                    }

                    if (EnchantmentHelper.getDamageBonus(itemStack, var10001) > 0.0F) {
                        player.magicCrit(target);
                    }

                    player.setLastHurtMob(target);
                    Entity entity = target;
                    if (target instanceof EnderDragonPart) {
                        entity = ((EnderDragonPart)target).parentMob;
                    }

                    boolean runEnchantmentEffects = bl;
                    bl = false;
                    LivingEntity livingEntity;
                    if (entity instanceof LivingEntity) {
                        livingEntity = (LivingEntity)entity;
                        bl = itemStack.getItem().hurtEnemy(itemStack, livingEntity, player);
                    }

                    if (runEnchantmentEffects) {
                        EnchantmentHelper.doPostDamageEffects(attacker, target);
                        if (target instanceof LivingEntity && EnchantmentHelper.getFireAspect(attacker) > 0 && !target.isOnFire()) {
                            target.setSecondsOnFire(1);
                        }
                    }

                    if (!player.getCommandSenderWorld().isClientSide() && !itemStack.isEmpty() && entity instanceof LivingEntity) {
                        livingEntity = (LivingEntity)entity;
                        if (bl) {
                            itemStack.hurtEnemy(livingEntity, player);
                        }

                        if (itemStack.isEmpty()) {
                            if (itemStack == player.getMainHandItem()) {
                                player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                            } else {
                                player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                            }
                        }
                    }

                    if (target instanceof LivingEntity) {
                        f = h - ((LivingEntity)target).getHealth();
                        player.awardStat(Stats.DAMAGE_DEALT, Math.round(f * 10.0F));
                        if (player.getCommandSenderWorld() instanceof ServerLevel && f > 2.0F) {
                            int i = (int)((double)f * 0.5);
                            serverWorld.sendParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getY(0.5), target.getZ(), i, 0.1, 0.0, 0.1, 0.2);
                        }
                    }

                    player.causeFoodExhaustion(0.1F);
                    return true;
                }
            } else {
                itemStack = attacker.getItemBySlot(slot);
                damageSource = attacker.damageSources().mobAttack(attacker);
                if (target instanceof LivingEntity l) {
                    var10002 = l.getMobType();
                } else {
                    var10002 = MobType.UNDEFINED;
                }

                halfCD = damage + EnchantmentHelper.getDamageBonus(itemStack, var10002);
                boolean bl2 = dealDamage && target.hurt(damageSource, halfCD);
                boolean bl = knockback | bl2;
                if (knockback && target instanceof LivingEntity knockable) {
                    knockable.knockback((double)((float)EnchantmentHelper.getKnockbackBonus(attacker) + (float)(attacker.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? attacker.getAttributeValue(Attributes.ATTACK_KNOCKBACK) : 0.0) + 0.4F), attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
                }

                if (dismount && target.isPassenger()) {
                    bl = true;
                    target.stopRiding();
                }

                if (bl2) {
                    EnchantmentHelper.doPostDamageEffects(attacker, target);
                    if (target instanceof LivingEntity && EnchantmentHelper.getFireAspect(attacker) > 0 && !target.isOnFire()) {
                        target.setSecondsOnFire(1);
                    }
                }

                if (!bl) {
                    return false;
                } else {
                    attacker.setLastHurtMob(target);
                    return true;
                }
            }
        }
    }
}
