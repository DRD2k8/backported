package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.block.*;
import com.drd.backported.block.base.WeatheringCopper;
import com.drd.backported.util.ModBlockSetTypes;
import com.drd.backported.util.ModSoundTypes;
import com.drd.backported.util.ModWoodTypes;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Backported.MOD_ID, Registries.BLOCK);

    // Tricky Trials
    public static final RegistrySupplier<Block> CHISELED_COPPER = registerBlock("chiseled_copper",
            () -> new CustomWeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistrySupplier<Block> EXPOSED_CHISELED_COPPER = registerBlock("exposed_chiseled_copper",
            () -> new CustomWeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)));
    public static final RegistrySupplier<Block> WEATHERED_CHISELED_COPPER = registerBlock("weathered_chiseled_copper",
            () -> new CustomWeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)));
    public static final RegistrySupplier<Block> OXIDIZED_CHISELED_COPPER = registerBlock("oxidized_chiseled_copper",
            () -> new CustomWeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));
    public static final RegistrySupplier<Block> WAXED_CHISELED_COPPER = registerBlock("waxed_chiseled_copper",
            () -> new Block(BlockBehaviour.Properties.copy(CHISELED_COPPER.get())));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_CHISELED_COPPER = registerBlock("waxed_exposed_chiseled_copper",
            () -> new Block(BlockBehaviour.Properties.copy(EXPOSED_CHISELED_COPPER.get())));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_CHISELED_COPPER = registerBlock("waxed_weathered_chiseled_copper",
            () -> new Block(BlockBehaviour.Properties.copy(WEATHERED_CHISELED_COPPER.get())));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_CHISELED_COPPER = registerBlock("waxed_oxidized_chiseled_copper",
            () -> new Block(BlockBehaviour.Properties.copy(OXIDIZED_CHISELED_COPPER.get())));
    public static final RegistrySupplier<Block> COPPER_GRATE = registerBlock("copper_grate",
            () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(ModSoundTypes.COPPER_GRATE).noOcclusion().requiresCorrectToolForDrops().isValidSpawn(ModBlocks::never).isRedstoneConductor(ModBlocks::never).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)));
    public static final RegistrySupplier<Block> EXPOSED_COPPER_GRATE = registerBlock("exposed_copper_grate",
            () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(COPPER_GRATE.get()).mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())));
    public static final RegistrySupplier<Block> WEATHERED_COPPER_GRATE = registerBlock("weathered_copper_grate",
            () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(COPPER_GRATE.get()).mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())));
    public static final RegistrySupplier<Block> OXIDIZED_COPPER_GRATE = registerBlock("oxidized_copper_grate",
            () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(COPPER_GRATE.get()).mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())));
    public static final RegistrySupplier<Block> WAXED_COPPER_GRATE = registerBlock("waxed_copper_grate",
            () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.copy(COPPER_GRATE.get())));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_COPPER_GRATE = registerBlock("waxed_exposed_copper_grate",
            () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_GRATE.get())));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_COPPER_GRATE = registerBlock("waxed_weathered_copper_grate",
            () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_GRATE.get())));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_GRATE = registerBlock("waxed_oxidized_copper_grate",
            () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_GRATE.get())));
    public static final RegistrySupplier<Block> COPPER_DOOR = registerBlock("copper_door",
            () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> EXPOSED_COPPER_DOOR = registerBlock("exposed_copper_door",
            () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).noOcclusion()));
    public static final RegistrySupplier<Block> WEATHERED_COPPER_DOOR = registerBlock("weathered_copper_door",
            () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).noOcclusion()));
    public static final RegistrySupplier<Block> OXIDIZED_COPPER_DOOR = registerBlock("oxidized_copper_door",
            () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).noOcclusion()));
    public static final RegistrySupplier<Block> WAXED_COPPER_DOOR = registerBlock("waxed_copper_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(COPPER_DOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_COPPER_DOOR = registerBlock("waxed_exposed_copper_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_DOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_COPPER_DOOR = registerBlock("waxed_weathered_copper_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_DOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_DOOR = registerBlock("waxed_oxidized_copper_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_DOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
            () -> new WeatheringCopperTrapdoorBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> EXPOSED_COPPER_TRAPDOOR = registerBlock("exposed_copper_trapdoor",
            () -> new WeatheringCopperTrapdoorBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).noOcclusion()));
    public static final RegistrySupplier<Block> WEATHERED_COPPER_TRAPDOOR = registerBlock("weathered_copper_trapdoor",
            () -> new WeatheringCopperTrapdoorBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).noOcclusion()));
    public static final RegistrySupplier<Block> OXIDIZED_COPPER_TRAPDOOR = registerBlock("oxidized_copper_trapdoor",
            () -> new WeatheringCopperTrapdoorBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).noOcclusion()));
    public static final RegistrySupplier<Block> WAXED_COPPER_TRAPDOOR = registerBlock("waxed_copper_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(COPPER_TRAPDOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_COPPER_TRAPDOOR = registerBlock("waxed_exposed_copper_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_TRAPDOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_COPPER_TRAPDOOR = registerBlock("waxed_weathered_copper_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_TRAPDOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_TRAPDOOR = registerBlock("waxed_oxidized_copper_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_TRAPDOOR.get()), ModBlockSetTypes.COPPER));
    public static final RegistrySupplier<Block> COPPER_BULB = registerBlock("copper_bulb",
            () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).isRedstoneConductor(ModBlocks::never)
                    .lightLevel(litBlockEmission(15)).sound(ModSoundTypes.COPPER_BULB)));
    public static final RegistrySupplier<Block> EXPOSED_COPPER_BULB = registerBlock("exposed_copper_bulb",
            () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).isRedstoneConductor(ModBlocks::never)
                    .lightLevel(litBlockEmission(12)).sound(ModSoundTypes.COPPER_BULB)));
    public static final RegistrySupplier<Block> WEATHERED_COPPER_BULB = registerBlock("weathered_copper_bulb",
            () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).isRedstoneConductor(ModBlocks::never)
                    .lightLevel(litBlockEmission(8)).sound(ModSoundTypes.COPPER_BULB)));
    public static final RegistrySupplier<Block> OXIDIZED_COPPER_BULB = registerBlock("oxidized_copper_bulb",
            () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).isRedstoneConductor(ModBlocks::never)
                    .lightLevel(litBlockEmission(4)).sound(ModSoundTypes.COPPER_BULB)));
    public static final RegistrySupplier<Block> WAXED_COPPER_BULB = registerBlock("waxed_copper_bulb",
            () -> new CopperBulbBlock(BlockBehaviour.Properties.copy(COPPER_BULB.get())));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_COPPER_BULB = registerBlock("waxed_exposed_copper_bulb",
            () -> new CopperBulbBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_BULB.get())));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_COPPER_BULB = registerBlock("waxed_weathered_copper_bulb",
            () -> new CopperBulbBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_BULB.get())));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_BULB = registerBlock("waxed_oxidized_copper_bulb",
            () -> new CopperBulbBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_BULB.get())));
    public static final RegistrySupplier<Block> TUFF_STAIRS = registerVanillaLikeStairs("tuff", Blocks.TUFF);
    public static final RegistrySupplier<Block> TUFF_SLAB = registerVanillaLikeSlab("tuff", Blocks.TUFF);
    public static final RegistrySupplier<Block> TUFF_WALL = registerVanillaLikeWall("tuff", Blocks.TUFF);
    public static final RegistrySupplier<Block> CHISELED_TUFF = registerBlock("chiseled_tuff",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistrySupplier<Block> POLISHED_TUFF = registerBlock("polished_tuff",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF).sound(ModSoundTypes.POLISHED_TUFF)));
    public static final RegistrySupplier<Block> POLISHED_TUFF_STAIRS = registerStairs("polished_tuff", POLISHED_TUFF);
    public static final RegistrySupplier<Block> POLISHED_TUFF_SLAB = registerSlab("polished_tuff", POLISHED_TUFF);
    public static final RegistrySupplier<Block> POLISHED_TUFF_WALL = registerWall("polished_tuff", POLISHED_TUFF);
    public static final RegistrySupplier<Block> TUFF_BRICKS = registerBlock("tuff_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF).sound(ModSoundTypes.TUFF_BRICKS)));
    public static final RegistrySupplier<Block> TUFF_BRICK_STAIRS = registerStairs("tuff_brick", TUFF_BRICKS);
    public static final RegistrySupplier<Block> TUFF_BRICK_SLAB = registerSlab("tuff_brick", TUFF_BRICKS);
    public static final RegistrySupplier<Block> TUFF_BRICK_WALL = registerWall("tuff_brick", TUFF_BRICKS);
    public static final RegistrySupplier<Block> CHISELED_TUFF_BRICKS = registerBlock("chiseled_tuff_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(TUFF_BRICKS.get())));
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
    public static final RegistrySupplier<Block> PALE_OAK_SIGN = registerStandingSign("pale_oak", PALE_OAK_PLANKS, ModWoodTypes.PALE_OAK);
    public static final RegistrySupplier<Block> PALE_OAK_WALL_SIGN = registerWallSign("pale_oak", PALE_OAK_PLANKS, ModWoodTypes.PALE_OAK, PALE_OAK_SIGN);
    public static final RegistrySupplier<Block> PALE_OAK_HANGING_SIGN = registerCeilingHangingSign("pale_oak", PALE_OAK_PLANKS, ModWoodTypes.PALE_OAK);
    public static final RegistrySupplier<Block> PALE_OAK_WALL_HANGING_SIGN = registerWallHangingSign("pale_oak", PALE_OAK_PLANKS, ModWoodTypes.PALE_OAK, PALE_OAK_HANGING_SIGN);
    public static final RegistrySupplier<Block> RESIN_CLUMP = registerBlock("resin_clump",
            () -> new ResinClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).replaceable().noCollission().sound(ModSoundTypes.RESIN).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistrySupplier<Block> RESIN_BLOCK = registerBlock("resin_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).sound(ModSoundTypes.RESIN)));
    public static final RegistrySupplier<Block> RESIN_BRICKS = registerBlock("resin_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSoundTypes.RESIN_BRICKS).strength(1.5f, 6f)));
    public static final RegistrySupplier<Block> RESIN_BRICK_STAIRS = registerStairs("resin_brick", RESIN_BRICKS);
    public static final RegistrySupplier<Block> RESIN_BRICK_SLAB = registerSlab("resin_brick", RESIN_BRICKS);
    public static final RegistrySupplier<Block> RESIN_BRICK_WALL = registerWall("resin_brick", RESIN_BRICKS);
    public static final RegistrySupplier<Block> CHISELED_RESIN_BRICKS = registerBlock("chiseled_resin_bricks", () -> new Block(BlockBehaviour.Properties.copy(RESIN_BRICKS.get())));

    // The Copper Age
    public static final RegistrySupplier<Block> COPPER_BARS = registerBlock("copper_bars",
            () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> EXPOSED_COPPER_BARS = registerBlock("exposed_copper_bars",
            () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> WEATHERED_COPPER_BARS = registerBlock("weathered_copper_bars",
            () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> OXIDIZED_COPPER_BARS = registerBlock("oxidized_copper_bars",
            () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> WAXED_COPPER_BARS = registerBlock("waxed_copper_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(COPPER_BARS.get())));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_COPPER_BARS = registerBlock("waxed_exposed_copper_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_BARS.get())));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_COPPER_BARS = registerBlock("waxed_weathered_copper_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_BARS.get())));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_BARS = registerBlock("waxed_oxidized_copper_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_BARS.get())));
    public static final RegistrySupplier<Block> COPPER_CHAIN = registerBlock("copper_chain",
            () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> EXPOSED_COPPER_CHAIN = registerBlock("exposed_copper_chain",
            () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> WEATHERED_COPPER_CHAIN = registerBlock("weathered_copper_chain",
            () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> OXIDIZED_COPPER_CHAIN = registerBlock("oxidized_copper_chain",
            () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).strength(5f, 6f).noOcclusion()));
    public static final RegistrySupplier<Block> WAXED_COPPER_CHAIN = registerBlock("waxed_copper_chain",
            () -> new ChainBlock(BlockBehaviour.Properties.copy(COPPER_CHAIN.get())));
    public static final RegistrySupplier<Block> WAXED_EXPOSED_COPPER_CHAIN = registerBlock("waxed_exposed_copper_chain",
            () -> new ChainBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_CHAIN.get())));
    public static final RegistrySupplier<Block> WAXED_WEATHERED_COPPER_CHAIN = registerBlock("waxed_weathered_copper_chain",
            () -> new ChainBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_CHAIN.get())));
    public static final RegistrySupplier<Block> WAXED_OXIDIZED_COPPER_CHAIN = registerBlock("waxed_oxidized_copper_chain",
            () -> new ChainBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_CHAIN.get())));
    public static final RegistrySupplier<Block> OAK_SHELF = registerShelf("oak", Blocks.OAK_PLANKS);
    public static final RegistrySupplier<Block> SPRUCE_SHELF = registerShelf("spruce", Blocks.SPRUCE_PLANKS);
    public static final RegistrySupplier<Block> BIRCH_SHELF = registerShelf("birch", Blocks.BIRCH_PLANKS);
    public static final RegistrySupplier<Block> JUNGLE_SHELF = registerShelf("jungle", Blocks.JUNGLE_PLANKS);
    public static final RegistrySupplier<Block> ACACIA_SHELF = registerShelf("acacia", Blocks.ACACIA_PLANKS);
    public static final RegistrySupplier<Block> DARK_OAK_SHELF = registerShelf("dark_oak", Blocks.DARK_OAK_PLANKS);
    public static final RegistrySupplier<Block> MANGROVE_SHELF = registerShelf("mangrove", Blocks.MANGROVE_PLANKS);
    public static final RegistrySupplier<Block> CHERRY_SHELF = registerShelf("cherry", Blocks.CHERRY_PLANKS);
    public static final RegistrySupplier<Block> PALE_OAK_SHELF = registerModdedShelf("pale_oak", PALE_OAK_PLANKS);
    public static final RegistrySupplier<Block> BAMBOO_SHELF = registerShelf("bamboo", Blocks.BAMBOO_PLANKS);
    public static final RegistrySupplier<Block> CRIMSON_SHELF = registerNonFlammableShelf("crimson", Blocks.CRIMSON_PLANKS);
    public static final RegistrySupplier<Block> WARPED_SHELF = registerNonFlammableShelf("warped", Blocks.WARPED_PLANKS);

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

    private static RegistrySupplier<Block> registerVanillaLikeStairs(String material, Block baseBlock) {
        return registerBlock(material + "_stairs", () -> new StairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.copy(baseBlock)));
    }

    private static RegistrySupplier<Block> registerVanillaLikeSlab(String material, Block baseBlock) {
        return registerBlock(material + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(baseBlock)));
    }

    private static RegistrySupplier<Block> registerFence(String material, RegistrySupplier<Block> baseBlock) {
        return registerBlock(material + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(baseBlock.get())));
    }

    private static RegistrySupplier<Block> registerFenceGate(String wood, RegistrySupplier<Block> planks, WoodType type) {
        return registerBlock(wood + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(planks.get()), type));
    }

    private static RegistrySupplier<Block> registerWall(String material, RegistrySupplier<Block> baseBlock) {
        return registerBlock(material + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(baseBlock.get())));
    }

    private static RegistrySupplier<Block> registerVanillaLikeWall(String material, Block baseBlock) {
        return registerBlock(material + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(baseBlock)));
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

    private static RegistrySupplier<Block> registerStandingSign(String wood, RegistrySupplier<Block> planks, WoodType type) {
        return BLOCKS.register(wood + "_sign", () -> new CustomStandingSignBlock(BlockBehaviour.Properties.copy(planks.get()).noCollission().strength(1f), type));
    }

    private static RegistrySupplier<Block> registerWallSign(String wood, RegistrySupplier<Block> planks, WoodType type, RegistrySupplier<Block> sign) {
        return BLOCKS.register(wood + "_wall_sign", () -> new CustomWallSignBlock(BlockBehaviour.Properties.copy(planks.get()).noCollission().strength(1f).dropsLike(sign.get()), type));
    }

    private static RegistrySupplier<Block> registerCeilingHangingSign(String wood, RegistrySupplier<Block> planks, WoodType type) {
        return BLOCKS.register(wood + "_hanging_sign", () -> new CustomCeilingHangingSignBlock(BlockBehaviour.Properties.copy(planks.get()).noCollission().strength(1f), type));
    }

    private static RegistrySupplier<Block> registerWallHangingSign(String wood, RegistrySupplier<Block> planks, WoodType type, RegistrySupplier<Block> sign) {
        return BLOCKS.register(wood + "_wall_hanging_sign", () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.copy(planks.get()).noCollission().strength(1f).dropsLike(sign.get()), type));
    }

    private static RegistrySupplier<Block> registerShelf(String wood, Block planks) {
        return registerBlock(wood + "_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().mapColor(planks.defaultMapColor()).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHISELED_BOOKSHELF).strength(2f, 3f).ignitedByLava()));
    }

    private static RegistrySupplier<Block> registerNonFlammableShelf(String wood, Block planks) {
        return registerBlock(wood + "_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().mapColor(planks.defaultMapColor()).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHISELED_BOOKSHELF).strength(2f, 3f)));
    }

    private static RegistrySupplier<Block> registerModdedShelf(String wood, RegistrySupplier<Block> planks) {
        return registerBlock(wood + "_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().mapColor(planks.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).sound(SoundType.CHISELED_BOOKSHELF).strength(2f, 3f).ignitedByLava()));
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int i) {
        return (blockState) -> {
            return (Boolean)blockState.getValue(BlockStateProperties.LIT) ? i : 0;
        };
    }

    public static void register() {
        BLOCKS.register();
    }
}
