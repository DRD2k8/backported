package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.block.HeavyCoreBlock;
import com.drd.backported.util.ModSoundTypes;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Backported.MOD_ID, Registries.BLOCK);

    // Tricky Trials
    public static final RegistrySupplier<Block> HEAVY_CORE = registerBlockWithRarity("heavy_core", () -> new HeavyCoreBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.SNARE).sound(ModSoundTypes.HEAVY_CORE).explosionResistance(1200f).strength(10f).pushReaction(PushReaction.NORMAL)), Rarity.EPIC);

    // The Garden Awakens
    public static final RegistrySupplier<Block> PALE_OAK_LOG = registerLog("pale_oak_log", MapColor.QUARTZ, MapColor.STONE);
    public static final RegistrySupplier<Block> PALE_OAK_WOOD = registerLog("pale_oak_wood", MapColor.STONE, MapColor.STONE);
    public static final RegistrySupplier<Block> STRIPPED_PALE_OAK_LOG = registerLog("stripped_pale_oak_log", MapColor.QUARTZ, MapColor.QUARTZ);
    public static final RegistrySupplier<Block> STRIPPED_PALE_OAK_WOOD = registerLog("stripped_pale_oak_wood", MapColor.QUARTZ, MapColor.QUARTZ);
    public static final RegistrySupplier<Block> PALE_OAK_PLANKS = registerBlock("pale_oak_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final RegistrySupplier<Block> PALE_OAK_STAIRS = registerStairs("pale_oak", PALE_OAK_PLANKS);
    public static final RegistrySupplier<Block> PALE_OAK_SLAB = registerSlab("pale_oak", PALE_OAK_PLANKS);
    public static final RegistrySupplier<Block> PALE_OAK_FENCE = registerFence("pale_oak", PALE_OAK_PLANKS);
    public static final RegistrySupplier<Block> PALE_OAK_FENCE_GATE = registerFenceGate("pale_oak", PALE_OAK_PLANKS, WoodType.OAK);
    public static final RegistrySupplier<Block> PALE_OAK_DOOR = registerWoodenDoor("pale_oak", PALE_OAK_PLANKS, BlockSetType.OAK);
    public static final RegistrySupplier<Block> PALE_OAK_TRAPDOOR = registerWoodenTrapdoor("pale_oak", PALE_OAK_PLANKS, BlockSetType.OAK);
    public static final RegistrySupplier<Block> PALE_OAK_PRESSURE_PLATE = registerWoodenPressurePlate("pale_oak", PALE_OAK_PLANKS, BlockSetType.OAK);
    public static final RegistrySupplier<Block> PALE_OAK_BUTTON = registerWoodenButton("pale_oak", PALE_OAK_PLANKS, BlockSetType.OAK);

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

    private static RegistrySupplier<Block> registerLog(String name, MapColor top, MapColor side) {
        return registerBlock(name, () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor((blockState) -> {
            return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : side;
        })));
    }

    private static RegistrySupplier<Block> registerStairs(String material, RegistrySupplier<Block> baseBlock) {
        return registerBlock(material + "_stairs", () -> new StairBlock(baseBlock.get().defaultBlockState(), BlockBehaviour.Properties.copy(baseBlock.get())));
    }

    private static RegistrySupplier<Block> registerSlab(String material, RegistrySupplier<Block> baseBlock) {
        return registerBlock(material + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(baseBlock.get())));
    }

    private static RegistrySupplier<Block> registerFence(String material, RegistrySupplier<Block> baseBlock) {
        return registerBlock(material + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(baseBlock.get())));
    }

    private static RegistrySupplier<Block> registerFenceGate(String wood, RegistrySupplier<Block> planks, WoodType type) {
        return registerBlock(wood + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(planks.get()), type));
    }

    private static RegistrySupplier<Block> registerDoor(String material, RegistrySupplier<Block> baseBlock, BlockSetType type) {
        return registerBlock(material + "_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(baseBlock.get()).noOcclusion(), type));
    }

    private static RegistrySupplier<Block> registerWoodenDoor(String wood, RegistrySupplier<Block> planks, BlockSetType type) {
        return registerBlock(wood + "_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(planks.get()).strength(3f).noOcclusion(), type));
    }

    private static RegistrySupplier<Block> registerTrapdoor(String material, RegistrySupplier<Block> baseBlock, BlockSetType type) {
        return registerBlock(material + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(baseBlock.get()).noOcclusion(), type));
    }

    private static RegistrySupplier<Block> registerWoodenTrapdoor(String wood, RegistrySupplier<Block> planks, BlockSetType type) {
        return registerBlock(wood + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(planks.get()).strength(3f).noOcclusion(), type));
    }

    private static RegistrySupplier<Block> registerPressurePlate(String material, RegistrySupplier<Block> baseBlock, BlockSetType type) {
        return registerBlock(material + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(baseBlock.get()), type));
    }

    private static RegistrySupplier<Block> registerWoodenPressurePlate(String wood, RegistrySupplier<Block> planks, BlockSetType type) {
        return registerBlock(wood + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(planks.get()).strength(0.5f), type));
    }

    private static RegistrySupplier<Block> registerWoodenButton(String wood, RegistrySupplier<Block> planks, BlockSetType type) {
        return registerBlock(wood + "_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(planks.get()).noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY), type, 30, true));
    }

    public static void register() {
        BLOCKS.register();
    }
}
