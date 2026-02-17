package com.drd.backported.mixin;

import com.drd.backported.block.base.DecoratedPot;
import com.drd.backported.block.base.RandomizableContainer;
import com.drd.backported.block.base.WobbleStyle;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DecoratedPotBlockEntity.class)
public abstract class DecoratedPotBlockEntityMixin extends BlockEntity implements RandomizableContainer, DecoratedPot {
    @Unique
    private static final String TAG_ITEM = "item";
    @Unique private static final int EVENT_POT_WOBBLES = 1;
    @Unique public long backported$wobbleStartedAtTick;
    @Unique @Nullable
    public WobbleStyle backported$lastWobbleStyle;
    @Unique private ItemStack backported$item = ItemStack.EMPTY;
    @Unique @Nullable protected ResourceLocation backported$lootTable;
    @Unique protected long backported$lootTableSeed;

    public DecoratedPotBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Inject(method = "saveAdditional", at = @At("TAIL"))
    public void backported$saveAdditional(CompoundTag tag, CallbackInfo ci) {
        if (!this.trySaveLootTable(tag) && !this.backported$item.isEmpty()) {
            tag.put(TAG_ITEM, this.backported$item.save(new CompoundTag()));
        }
    }

    @Inject(method = "load", at = @At("TAIL"))
    public void backported$load(CompoundTag tag, CallbackInfo ci) {
        if (!this.tryLoadLootTable(tag)) {
            if (tag.contains(TAG_ITEM, 10)) {
                this.backported$item = ItemStack.of(tag.getCompound(TAG_ITEM));
            } else {
                this.backported$item = ItemStack.EMPTY;
            }
        }
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (this.level != null && id == EVENT_POT_WOBBLES && type >= 0 && type < WobbleStyle.values().length) {
            this.backported$wobbleStartedAtTick = this.level.getGameTime();
            this.backported$lastWobbleStyle = WobbleStyle.values()[type];
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }

    @Override
    public WobbleStyle getLastWobbleStyle() {
        return this.backported$lastWobbleStyle;
    }

    @Override
    public long getWobbleStartedAtTick() {
        return this.backported$wobbleStartedAtTick;
    }

    @Override
    public void wobble(WobbleStyle style) {
        if (this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), EVENT_POT_WOBBLES, style.ordinal());
        }
    }

    @Override
    public @Nullable ResourceLocation getLootTable() {
        return this.backported$lootTable;
    }

    @Override
    public long getLootTableSeed() {
        return this.backported$lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.backported$lootTableSeed = seed;
    }

    @Override
    public void setLootTable(@Nullable ResourceLocation lootTable) {
        this.backported$lootTable = lootTable;
    }

    @Override
    public @NotNull ItemStack getItem(int slot) {
        return slot == 0 ? this.getFirstItem() : ItemStack.EMPTY;
    }

    @Override
    public @NotNull ItemStack getFirstItem() {
        this.unpackLootTable(null);
        return this.backported$item;
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int amount) {
        return slot != 0 ? ItemStack.EMPTY : this.splitFirstItem(amount);
    }

    @Override
    public void setItem(int slot, @NotNull ItemStack stack) {
        if (slot == 0) this.setFirstItem(stack);
    }

    @Override
    public void setFirstItem(@NotNull ItemStack stack) {
        this.unpackLootTable(null);
        this.backported$item = stack;
    }

    @Unique
    public ItemStack splitFirstItem(int stack) {
        this.unpackLootTable(null);
        ItemStack itemstack = this.backported$item.split(stack);
        if (this.backported$item.isEmpty()) {
            this.backported$item = ItemStack.EMPTY;
        }

        return itemstack;
    }

    @Override @Nullable
    public Level getLevel() {
        return this.level;
    }

    @Override
    public BlockPos getBlockPos() {
        return this.worldPosition;
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    @Override
    public void setChanged() {
        if (this.level != null) {
            setChanged(this.level, this.worldPosition, this.getBlockState());
        }
    }
}
