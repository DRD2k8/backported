package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.block.HeavyCoreBlock;
import com.drd.backported.util.ModSoundTypes;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Backported.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> HEAVY_CORE = registerBlockWithRarity("heavy_core", () -> new HeavyCoreBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.SNARE).sound(ModSoundTypes.HEAVY_CORE).explosionResistance(1200f).strength(10f).pushReaction(PushReaction.NORMAL)), Rarity.EPIC);

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistrySupplier<Item> registerBlockItem(String name, RegistrySupplier<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistrySupplier<T> registerBlockWithRarity(String name, Supplier<T> block, Rarity rarity) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItemWithRarity(name, toReturn, rarity);
        return toReturn;
    }

    private static <T extends Block> RegistrySupplier<Item> registerBlockItemWithRarity(String name, RegistrySupplier<T> block, Rarity rarity) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
    }

    public static void register() {
        BLOCKS.register();
    }
}
