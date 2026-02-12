package com.drd.backported.mixin;

import com.drd.backported.entity.variant.WolfVariant;
import com.drd.backported.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Wolf.class)
public abstract class WolfMixin extends MobMixin {
    @Unique
    private static final EntityDataAccessor<Integer> VARIANT;

    public WolfMixin() {
    }

    @Inject(
            method = {"defineSynchedData"},
            at = {@At("HEAD")}
    )
    public void initTracker(CallbackInfo ci) {
        Wolf wolf = (Wolf)(Object)this;
        wolf.getEntityData().define(VARIANT, 0);
    }

    @Inject(
            method = {"addAdditionalSaveData"},
            at = {@At("HEAD")}
    )
    public void writeNBTData(CompoundTag pCompound, CallbackInfo ci) {
        pCompound.putInt("Variant", this.getTypeVariant());
    }

    @Inject(
            method = {"readAdditionalSaveData"},
            at = {@At("HEAD")}
    )
    public void readNBTData(CompoundTag pCompound, CallbackInfo ci) {
        Wolf wolf = (Wolf)(Object)this;
        wolf.getEntityData().set(VARIANT, pCompound.getInt("Variant"));
    }

    protected void onInitialize(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, SpawnGroupData pSpawnData, CompoundTag pDataTag, CallbackInfoReturnable<SpawnGroupData> cir) {
        Wolf wolf = (Wolf)(Object)this;
        Holder<Biome> registryEntry = pLevel.getBiome(wolf.getOnPos());
        WolfVariant variant = WolfVariant.byId(WolfVariant.PALE_WOLF.getId());
        if (registryEntry.is(ModTags.Biomes.SPAWNS_WOODS_WOLF)) {
            variant = WolfVariant.WOODS_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_ASHEN_WOLF)) {
            variant = WolfVariant.ASHEN_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_BLACK_WOLF)) {
            variant = WolfVariant.BLACK_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_CHESTNUT_WOLF)) {
            variant = WolfVariant.CHESTNUT_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_RUSTY_WOLF)) {
            variant = WolfVariant.RUSTY_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_SPOTTED_WOLF)) {
            variant = WolfVariant.SPOTTED_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_STRIPED_WOLF)) {
            variant = WolfVariant.STRIPED_WOLF;
        } else if (registryEntry.is(ModTags.Biomes.SPAWNS_SNOWY_WOLF)) {
            variant = WolfVariant.SNOWY_WOLF;
        }

        this.setVariant(variant);
    }

    @Inject(
            method = {"getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/animal/Wolf;"},
            at = {@At("RETURN")}
    )
    private void onCreateChild(ServerLevel pLevel, AgeableMob pOtherParent, CallbackInfoReturnable<Wolf> cir) {
        Wolf child = (Wolf)cir.getReturnValue();
        Wolf wolf = (Wolf)(Object)this;
        CompoundTag childNbt = new CompoundTag();
        child.addAdditionalSaveData(childNbt);
        CompoundTag nbtParent = new CompoundTag();
        wolf.addAdditionalSaveData(nbtParent);
        CompoundTag nbtOtherParent = new CompoundTag();
        pOtherParent.addAdditionalSaveData(nbtOtherParent);
        int variant = wolf.getRandom().nextBoolean() ? nbtParent.getInt("Variant") : nbtOtherParent.getInt("Variant");
        child.getEntityData().set(VARIANT, variant & 255);
        childNbt.putInt("Variant", variant);
        child.readAdditionalSaveData(childNbt);
    }

    public WolfVariant getVariant() {
        return WolfVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        Wolf wolf = (Wolf)(Object)this;
        return (Integer) wolf.getEntityData().get(VARIANT);
    }

    public void setVariant(WolfVariant variant) {
        Wolf wolf = (Wolf)(Object)this;
        wolf.getEntityData().set(VARIANT, variant.getId() & 255);
    }

    static {
        VARIANT = SynchedEntityData.defineId(Wolf.class, EntityDataSerializers.INT);
    }
}
