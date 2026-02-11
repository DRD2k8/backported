package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.block.entity.CustomHangingSignBlockEntity;
import com.drd.backported.block.entity.CustomSignBlockEntity;
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

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}
