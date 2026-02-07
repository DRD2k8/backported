package com.drd.backported.item;

import com.drd.backported.init.ModEnchantments;
import com.drd.backported.init.ModSounds;
import com.drd.backported.item.spear.MovementFixer;
import com.drd.backported.item.spear.SpearUser;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.datafixers.util.Either;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.phys.*;

import java.util.*;
import java.util.function.Predicate;

public class SpearItem extends TieredItem {
    public final int swingAnimationTicks;
    public final float chargeDamageMultiplier;
    public final float chargeDelaySeconds;
    public final float maxDurationForDismountSeconds;
    public final float minSpeedForDismount;
    public final float maxDurationForChargeKnockbackInSeconds;
    public final float minSpeedForChargeKnockback;
    public final float maxDurationForChargeDamageInSeconds;
    public final float minRelativeSpeedForChargeDamage;
    public final RegistrySupplier<SoundEvent> hitSound;
    public final RegistrySupplier<SoundEvent> attackSound;
    public final RegistrySupplier<SoundEvent> useSound;
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    private static Item.Properties handleSpearSettings(Tier material, Item.Properties settings) {
        if (material == Tiers.NETHERITE) {
            settings.fireResistant();
        }

        return settings;
    }

    public SpearItem(Tier material, double attackSpeed, int swingAnimationTicks, float chargeDamageMultiplier, float chargeDelaySeconds, float maxDurationForDismountSeconds, float minSpeedForDismount, float maxDurationForChargeKnockbackInSeconds, float minSpeedForChargeKnockback, float maxDurationForChargeDamageInSeconds, float minRelativeSpeedForChargeDamage, RegistrySupplier<SoundEvent> hitSound, RegistrySupplier<SoundEvent> attackSound, RegistrySupplier<SoundEvent> useSound, Item.Properties settings) {
        super(material, handleSpearSettings(material, settings));
        double vanillaAttackSpeed = attackSpeed - 4.0;
        this.swingAnimationTicks = swingAnimationTicks;
        this.chargeDamageMultiplier = chargeDamageMultiplier;
        this.chargeDelaySeconds = chargeDelaySeconds;
        this.maxDurationForDismountSeconds = maxDurationForDismountSeconds;
        this.minSpeedForDismount = minSpeedForDismount;
        this.maxDurationForChargeKnockbackInSeconds = maxDurationForChargeKnockbackInSeconds;
        this.minSpeedForChargeKnockback = minSpeedForChargeKnockback;
        this.maxDurationForChargeDamageInSeconds = maxDurationForChargeDamageInSeconds;
        this.minRelativeSpeedForChargeDamage = minRelativeSpeedForChargeDamage;
        this.hitSound = hitSound;
        this.attackSound = attackSound;
        this.useSound = useSound;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", (double)material.getAttackDamageBonus(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", vanillaAttackSpeed, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getDefaultAttributeModifiers(slot);
    }

    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (selected) {
            stack.setEntityRepresentation(entity);
        } else {
            stack.setEntityRepresentation((Entity)null);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public boolean canAttackBlock(BlockState state, Level world, BlockPos pos, Player miner) {
        return !miner.isCreative();
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (e) -> {
            e.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        user.startUsingItem(hand);
        Level var5 = user.level();
        if (var5 instanceof ServerLevel server) {
            server.playSound((Player)null, user.getX(), user.getY(), user.getZ(), this.useSound.get(), user.getSoundSource(), 1.0F, 1.0F);
        }

        return InteractionResultHolder.consume(user.getItemInHand(hand));
    }

    public static Vec3 getAmplifiedMovement(Entity entity) {
        if (!(entity instanceof Player) && entity.isPassenger()) {
            entity = entity.getRootVehicle();
        }

        if (entity instanceof Player player && player instanceof MovementFixer m) {
            return m.safeMovement().scale(20.0);
        }

        Vec3 movement = entity.position().subtract(entity.xo, entity.yo, entity.zo);
        return movement.scale(20.0);
    }

    public void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.onUseTick(world, user, stack, remainingUseTicks);
        if (!world.isClientSide) {
            int i = stack.getUseDuration() - remainingUseTicks;
            if (i >= this.delayTicks() && user instanceof SpearUser) {
                SpearUser s = (SpearUser)user;
                i -= this.delayTicks();
                Vec3 vec3d = user.getLookAngle();
                double d = vec3d.dot(getAmplifiedMovement(user));
                float f = user instanceof Player ? 1.0F : 0.2F;
                float g = user instanceof Player ? 1.0F : 0.5F;
                double e = user.getAttributeBaseValue(Attributes.ATTACK_DAMAGE);
                boolean bl = false;
                Iterator var15 = collectPiercingCollisions(user, g * 2.0F, g * 4.5F, 0.25F, (target) -> {
                    return canHit(user, target);
                }).iterator();

                while(true) {
                    Entity entity;
                    double j;
                    boolean bl3;
                    boolean bl4;
                    boolean bl5;
                    do {
                        boolean bl2;
                        do {
                            if (!var15.hasNext()) {
                                if (bl) {
                                    Level var27 = user.level();
                                    if (var27 instanceof ServerLevel) {
                                        ServerLevel server = (ServerLevel)var27;
                                        server.playSound((Player)null, user.getX(), user.getY(), user.getZ(), this.hitSound.get(), user.getSoundSource(), 1.0F, 1.0F);
                                    }

                                    user.getCommandSenderWorld().broadcastEntityEvent(user, (byte)2);
                                }

                                return;
                            }

                            EntityHitResult entityHitResult = (EntityHitResult)var15.next();
                            entity = entityHitResult.getEntity();
                            bl2 = s.isInPiercingCooldown(entity, 10);
                            s.startPiercingCooldown(entity);
                        } while(bl2);

                        j = Math.max(0.0, d - vec3d.dot(getAmplifiedMovement(entity)));
                        bl3 = this.canDismount(i, d, (double)f);
                        bl4 = this.canKnockback(i, d, (double)f);
                        bl5 = this.canDamage(i, j, (double)f);
                    } while(!bl3 && !bl4 && !bl5);

                    float var10000 = (float)e;
                    MobType var10002;
                    if (entity instanceof LivingEntity) {
                        LivingEntity l = (LivingEntity)entity;
                        var10002 = l.getMobType();
                    } else {
                        var10002 = MobType.UNDEFINED;
                    }

                    float k = var10000 + EnchantmentHelper.getDamageBonus(stack, var10002) + (float) Mth.floor(j * (double)this.chargeDamageMultiplier);
                    bl |= s.pierce(user.getUsedItemHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND, entity, k, bl5, bl4, bl3);
                }
            }
        }
    }

    public boolean canDismount(int durationTicks, double speed, double minSpeedMultiplier) {
        return durationTicks <= this.getMaxDurationForDismountInTicks() && speed >= (double)this.minSpeedForDismount * minSpeedMultiplier;
    }

    public boolean canKnockback(int durationTicks, double speed, double minSpeedMultiplier) {
        return durationTicks <= this.getMaxDurationForChargeKnockbackInTicks() && speed >= (double)this.minSpeedForChargeKnockback * minSpeedMultiplier;
    }

    public boolean canDamage(int durationTicks, double relativeSpeed, double minSpeedMultiplier) {
        return durationTicks <= this.getMaxDurationForChargeDamageInTicks() && relativeSpeed >= (double)this.minRelativeSpeedForChargeDamage * minSpeedMultiplier;
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public int swingTicks() {
        return this.swingAnimationTicks;
    }

    public int delayTicks() {
        return (int)(this.chargeDelaySeconds * 20.0F);
    }

    public int getUseTicks() {
        return this.delayTicks() + (int)(Math.max(Math.max(this.maxDurationForChargeDamageInSeconds, this.maxDurationForChargeKnockbackInSeconds), this.maxDurationForDismountSeconds) * 20.0F);
    }

    public int getMaxDurationForDismountInTicks() {
        return (int)(this.maxDurationForDismountSeconds * 20.0F);
    }

    public int getMaxDurationForChargeDamageInTicks() {
        return (int)(this.maxDurationForChargeDamageInSeconds * 20.0F);
    }

    public int getMaxDurationForChargeKnockbackInTicks() {
        return (int)(this.maxDurationForChargeKnockbackInSeconds * 20.0F);
    }

    public boolean stab(LivingEntity attacker, EquipmentSlot slot) {
        float f = (float)attacker.getAttributeValue(Attributes.ATTACK_DAMAGE);
        boolean bl = false;
        if (attacker instanceof SpearUser s) {
            EntityHitResult entityHitResult;
            for(Iterator var6 = collectPiercingCollisions(attacker, 2.0F, 4.5F, 0.25F, (entity) -> {
                return canHit(attacker, entity);
            }).iterator(); var6.hasNext(); bl |= s.pierce(slot, entityHitResult.getEntity(), f, true, true, false)) {
                entityHitResult = (EntityHitResult)var6.next();
            }
        }

        ItemStack stack = attacker.getItemBySlot(slot);
        int lunge = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.LUNGE.get(), stack);
        if (!attacker.isFallFlying() && !attacker.isInWater()) {
            label37: {
                if (attacker instanceof Player) {
                    Player player = (Player)attacker;
                    if (player.getFoodData().getFoodLevel() <= 5) {
                        break label37;
                    }
                }

                if (lunge > 0) {
                    Vec3 vec3d2 = transformLocalPos(getYawAndPitch(attacker.getLookAngle()), new Vec3(0.0, 0.0, 1.0)).multiply(new Vec3(1.0, 0.0, 1.0)).scale((double)lunge * 0.458);
                    attacker.addDeltaMovement(vec3d2);
                    attacker.hurtMarked = true;
                    attacker.hasImpulse = true;
                    Level var10 = attacker.level();
                    if (var10 instanceof ServerLevel) {
                        ServerLevel server = (ServerLevel)var10;
                        server.playSound((Player)null, attacker.getX(), attacker.getY(), attacker.getZ(), ModSounds.SPEAR_LUNGE.get(), attacker.getSoundSource(), 1.0F, 1.0F);
                    }

                    if (attacker instanceof Player) {
                        Player player = (Player)attacker;
                        if (!player.isCreative()) {
                            player.causeFoodExhaustion((float)lunge * 4.0F);
                        }
                    }

                    stack.hurtAndBreak(1, attacker, (user) -> {
                        user.broadcastBreakEvent(slot);
                    });
                }
            }
        }

        Level var15 = attacker.level();
        if (var15 instanceof ServerLevel server) {
            if (bl) {
                server.playSound((Player)null, attacker.getX(), attacker.getY(), attacker.getZ(), this.hitSound.get(), attacker.getSoundSource(), 1.0F, 1.0F);
            }

            server.playSound((Player)null, attacker.getX(), attacker.getY(), attacker.getZ(), this.attackSound.get(), attacker.getSoundSource(), 1.0F, 1.0F);
        }

        attacker.swing(InteractionHand.MAIN_HAND, false);
        return bl;
    }

    public static Vec2 getYawAndPitch(Vec3 vec3d) {
        float f = (float)Math.atan2(-vec3d.x, vec3d.z) * 57.295776F;
        float g = (float)Math.asin(-vec3d.y / Math.sqrt(vec3d.x * vec3d.x + vec3d.y * vec3d.y + vec3d.z * vec3d.z)) * 57.295776F;
        return new Vec2(g, f);
    }

    public static Vec3 transformLocalPos(Vec2 rotation, Vec3 vec) {
        float f = Mth.cos((rotation.y + 90.0F) * 0.017453292F);
        float g = Mth.sin((rotation.y + 90.0F) * 0.017453292F);
        float h = Mth.cos(-rotation.x * 0.017453292F);
        float i = Mth.sin(-rotation.x * 0.017453292F);
        float j = Mth.cos((-rotation.x + 90.0F) * 0.017453292F);
        float k = Mth.sin((-rotation.x + 90.0F) * 0.017453292F);
        Vec3 vec3d = new Vec3((double)(f * h), (double)i, (double)(g * h));
        Vec3 vec3d2 = new Vec3((double)(f * j), (double)k, (double)(g * j));
        Vec3 vec3d3 = vec3d.cross(vec3d2).scale(-1.0);
        double d = vec3d.x * vec.z + vec3d2.x * vec.y + vec3d3.x * vec.x;
        double e = vec3d.y * vec.z + vec3d2.y * vec.y + vec3d3.y * vec.x;
        double l = vec3d.z * vec.z + vec3d2.z * vec.y + vec3d3.z * vec.x;
        return new Vec3(d, e, l);
    }

    public static boolean canHit(Entity attacker, Entity target) {
        if (target.canBeHitByProjectile() && !target.isInvulnerable() && target.isAlive()) {
            boolean var10000;
            label21: {
                if (target instanceof Player) {
                    Player playerEntity = (Player)target;
                    if (attacker instanceof Player) {
                        Player playerEntity2 = (Player)attacker;
                        if (!playerEntity2.canHarmPlayer(playerEntity)) {
                            break label21;
                        }
                    }
                }

                if (!attacker.isPassengerOfSameVehicle(target)) {
                    var10000 = true;
                    return var10000;
                }
            }

            var10000 = false;
            return var10000;
        } else {
            return false;
        }
    }

    private static Vec3 getRotationVector(float pitch, float yaw) {
        float f = pitch * 0.017453292F;
        float g = -yaw * 0.017453292F;
        float h = Mth.cos(g);
        float i = Mth.sin(g);
        float j = Mth.cos(f);
        float k = Mth.sin(f);
        return new Vec3((double)(i * j), (double)(-k), (double)(h * j));
    }

    public static Collection<EntityHitResult> collectPiercingCollisions(LivingEntity entity, float minReach, float maxReach, float hitboxMargin, Predicate<Entity> hitPredicate) {
        Vec3 vec3d = getRotationVector(entity.getXRot(), entity.getYHeadRot());
        Vec3 vec3d2 = entity.getEyePosition();
        Vec3 vec3d3 = vec3d2.add(vec3d.scale((double)minReach));
        double d = entity.getDeltaMovement().dot(vec3d);
        Vec3 vec3d4 = vec3d2.add(vec3d.scale((double)maxReach + Math.max(0.0, d)));
        return (Collection)collectPiercingCollisions(entity, vec3d2, vec3d3, hitPredicate, vec3d4, hitboxMargin).map((hitResult) -> {
            return List.of();
        }, (hitResults) -> {
            return hitResults;
        });
    }

    private static Either<BlockHitResult, Collection<EntityHitResult>> collectPiercingCollisions(Entity entity, Vec3 pos, Vec3 minReach, Predicate<Entity> hitPredicate, Vec3 maxReach, float hitboxMargin) {
        Level world = entity.getCommandSenderWorld();
        BlockHitResult blockHitResult = getCollisionsIncludingWorldBorder(world, new ClipContext(pos, maxReach, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity));
        if (blockHitResult.getType() != HitResult.Type.MISS) {
            maxReach = blockHitResult.getLocation();
            if (pos.distanceToSqr(maxReach) < pos.distanceToSqr(minReach)) {
                return Either.left(blockHitResult);
            }
        }

        AABB box = AABB.ofSize(minReach, (double)hitboxMargin, (double)hitboxMargin, (double)hitboxMargin).expandTowards(maxReach.subtract(minReach)).inflate(1.0);
        Collection<EntityHitResult> collection = collectPiercingCollisions(world, entity, minReach, maxReach, box, hitPredicate, hitboxMargin, ClipContext.Block.COLLIDER, true);
        return !collection.isEmpty() ? Either.right(collection) : Either.left(blockHitResult);
    }

    public static Collection<EntityHitResult> collectPiercingCollisions(Level world, Entity entity, Vec3 from, Vec3 to, AABB box, Predicate<Entity> hitPredicate, float hitboxMargin, ClipContext.Block shapeType, boolean bl) {
        List<EntityHitResult> list = new ArrayList();
        Iterator var10 = world.getEntities(entity, box, hitPredicate).iterator();

        while(true) {
            while(var10.hasNext()) {
                Entity entity2 = (Entity)var10.next();
                AABB box2 = entity2.getBoundingBox();
                if (bl && box2.contains(from)) {
                    list.add(new EntityHitResult(entity2, from));
                } else {
                    Optional<Vec3> optional = box2.clip(from, to);
                    if (optional.isPresent()) {
                        list.add(new EntityHitResult(entity2, (Vec3)optional.get()));
                    } else if (!((double)hitboxMargin <= 0.0)) {
                        Optional<Vec3> optional2 = box2.inflate((double)hitboxMargin).clip(from, to);
                        if (optional2.isPresent()) {
                            Vec3 vec3d = (Vec3)optional2.get();
                            Vec3 vec3d2 = box2.getCenter();
                            BlockHitResult blockHitResult = getCollisionsIncludingWorldBorder(world, new ClipContext(vec3d, vec3d2, shapeType, ClipContext.Fluid.NONE, entity));
                            if (blockHitResult.getType() != HitResult.Type.MISS) {
                                vec3d2 = blockHitResult.getLocation();
                            }

                            Optional<Vec3> optional3 = entity2.getBoundingBox().clip(vec3d, vec3d2);
                            optional3.ifPresent((d) -> {
                                list.add(new EntityHitResult(entity2, d));
                            });
                        }
                    }
                }
            }

            return list;
        }
    }

    private static BlockHitResult getCollisionsIncludingWorldBorder(Level world, ClipContext context) {
        BlockHitResult blockHitResult = world.clip(context);
        WorldBorder worldBorder = world.getWorldBorder();
        if (worldBorder.isWithinBounds(BlockPos.containing(context.getFrom())) && !worldBorder.isWithinBounds(blockHitResult.getBlockPos())) {
            Vec3 vec3d = blockHitResult.getLocation().subtract(context.getFrom());
            Direction direction = Direction.getNearest(vec3d.x, vec3d.y, vec3d.z);
            Vec3 vec3d2 = blockHitResult.getLocation();
            vec3d2 = new Vec3(Mth.clamp(vec3d2.x, worldBorder.getMinX(), worldBorder.getMaxX() - 9.999999747378752E-6), vec3d2.y, Mth.clamp(vec3d2.z, worldBorder.getMinZ(), worldBorder.getMaxZ() - 9.999999747378752E-6));
            return new BlockHitResult(vec3d2, direction, BlockPos.containing(vec3d2), false);
        } else {
            return blockHitResult;
        }
    }
}
