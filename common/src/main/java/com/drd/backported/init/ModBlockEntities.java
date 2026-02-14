package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.block.entity.CustomHangingSignBlockEntity;
import com.drd.backported.block.entity.CustomSignBlockEntity;
import com.drd.backported.block.entity.ShelfBlockEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Backported.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CustomSignBlockEntity>> SIGN =
            BLOCK_ENTITIES.register("sign", () ->
                    BlockEntityType.Builder.of(CustomSignBlockEntity::new,
                            ModBlocks.PALE_OAK_SIGN.get(), ModBlocks.PALE_OAK_WALL_SIGN.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<CustomHangingSignBlockEntity>> HANGING_SIGN =
            BLOCK_ENTITIES.register("hanging_sign", () ->
                    BlockEntityType.Builder.of(CustomHangingSignBlockEntity::new,
                            ModBlocks.PALE_OAK_HANGING_SIGN.get(), ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<ShelfBlockEntity>> SHELF =
            BLOCK_ENTITIES.register("shelf", () ->
                    BlockEntityType.Builder.of(ShelfBlockEntity::new,
                            ModBlocks.OAK_SHELF.get(),
                            ModBlocks.SPRUCE_SHELF.get(),
                            ModBlocks.BIRCH_SHELF.get(),
                            ModBlocks.JUNGLE_SHELF.get(),
                            ModBlocks.ACACIA_SHELF.get(),
                            ModBlocks.DARK_OAK_SHELF.get(),
                            ModBlocks.MANGROVE_SHELF.get(),
                            ModBlocks.CHERRY_SHELF.get(),
                            ModBlocks.PALE_OAK_SHELF.get(),
                            ModBlocks.BAMBOO_SHELF.get(),
                            ModBlocks.CRIMSON_SHELF.get(),
                            ModBlocks.WARPED_SHELF.get()).build(null));

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}
