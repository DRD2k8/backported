package com.drd.backported.datagen.client;

import com.drd.backported.Backported;
import com.drd.backported.block.CustomStandingSignBlock;
import com.drd.backported.block.CustomWallSignBlock;
import com.drd.backported.init.ModBlocks;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Backported.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Tricky Trials
        blockWithItem(ModBlocks.CHISELED_COPPER);
        blockWithItem(ModBlocks.EXPOSED_CHISELED_COPPER);
        blockWithItem(ModBlocks.WEATHERED_CHISELED_COPPER);
        blockWithItem(ModBlocks.OXIDIZED_CHISELED_COPPER);
        simpleBlock(ModBlocks.WAXED_CHISELED_COPPER.get(), models().getExistingFile(modLoc("block/chiseled_copper")));
        simpleBlock(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER.get(), models().getExistingFile(modLoc("block/exposed_chiseled_copper")));
        simpleBlock(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER.get(), models().getExistingFile(modLoc("block/weathered_chiseled_copper")));
        simpleBlock(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER.get(), models().getExistingFile(modLoc("block/oxidized_chiseled_copper")));
        copperGrateBlock(ModBlocks.COPPER_GRATE);
        copperGrateBlock(ModBlocks.EXPOSED_COPPER_GRATE);
        copperGrateBlock(ModBlocks.WEATHERED_COPPER_GRATE);
        copperGrateBlock(ModBlocks.OXIDIZED_COPPER_GRATE);
        simpleBlock(ModBlocks.WAXED_COPPER_GRATE.get(), models().getExistingFile(modLoc("block/copper_grate")));
        simpleBlock(ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get(), models().getExistingFile(modLoc("block/exposed_copper_grate")));
        simpleBlock(ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get(), models().getExistingFile(modLoc("block/weathered_copper_grate")));
        simpleBlock(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get(), models().getExistingFile(modLoc("block/oxidized_copper_grate")));
        stairsBlock(((StairBlock) ModBlocks.TUFF_STAIRS.get()), mcLoc("block/tuff"));
        slabBlock(((SlabBlock) ModBlocks.TUFF_SLAB.get()), mcLoc("block/tuff"), mcLoc("block/tuff"));
        wallBlock(((WallBlock) ModBlocks.TUFF_WALL.get()), mcLoc("block/tuff"));
        nonRotatingPillarBlock(ModBlocks.CHISELED_TUFF);
        blockWithItem(ModBlocks.POLISHED_TUFF);
        stairsBlock(((StairBlock) ModBlocks.POLISHED_TUFF_STAIRS.get()), blockTexture(ModBlocks.POLISHED_TUFF.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_TUFF_SLAB.get()), blockTexture(ModBlocks.POLISHED_TUFF.get()), blockTexture(ModBlocks.POLISHED_TUFF.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_TUFF_WALL.get()), blockTexture(ModBlocks.POLISHED_TUFF.get()));
        blockWithItem(ModBlocks.TUFF_BRICKS);
        stairsBlock(((StairBlock) ModBlocks.TUFF_BRICK_STAIRS.get()), blockTexture(ModBlocks.TUFF_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.TUFF_BRICK_SLAB.get()), blockTexture(ModBlocks.TUFF_BRICKS.get()), blockTexture(ModBlocks.TUFF_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.TUFF_BRICK_WALL.get()), blockTexture(ModBlocks.TUFF_BRICKS.get()));
        nonRotatingPillarBlock(ModBlocks.CHISELED_TUFF_BRICKS);

        // The Garden Awakens
        logBlock(((RotatedPillarBlock) ModBlocks.PALE_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.PALE_OAK_WOOD.get()), blockTexture(ModBlocks.PALE_OAK_LOG.get()), blockTexture(ModBlocks.PALE_OAK_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALE_OAK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PALE_OAK_LOG.get()), blockTexture(ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
        blockItem(ModBlocks.PALE_OAK_LOG);
        blockItem(ModBlocks.PALE_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_PALE_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_PALE_OAK_WOOD);
        blockWithItem(ModBlocks.PALE_OAK_PLANKS);
        stairsBlock(((StairBlock) ModBlocks.PALE_OAK_STAIRS.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.PALE_OAK_SLAB.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.PALE_OAK_FENCE.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PALE_OAK_FENCE_GATE.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PALE_OAK_DOOR.get()), modLoc("block/pale_oak_door_bottom"), modLoc("block/pale_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PALE_OAK_TRAPDOOR.get()), modLoc("block/pale_oak_trapdoor"), true, "cutout");
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PALE_OAK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.PALE_OAK_BUTTON.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        signBlock(((CustomStandingSignBlock) ModBlocks.PALE_OAK_SIGN.get()), ((CustomWallSignBlock) ModBlocks.PALE_OAK_WALL_SIGN.get()), blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        hangingSignBlock(ModBlocks.PALE_OAK_HANGING_SIGN.get(), ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STRIPPED_PALE_OAK_LOG.get()));
    }

    private void saplingBlock(RegistrySupplier<Block> block) {
        simpleBlock(block.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), blockTexture(block.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private void leavesBlock(RegistrySupplier<Block> block) {
        simpleBlockWithItem(block.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), ResourceLocation.withDefaultNamespace("block/leaves"),
                        "all", blockTexture(block.get())).renderType("cutout"));
    }

    private void blockItem(RegistrySupplier<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(Backported.MOD_ID +
                ":block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
    }

    private void blockWithItem(RegistrySupplier<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void copperGrateBlock(RegistrySupplier<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeAll(this.name(block.get()), this.blockTexture(block.get())).renderType("cutout"));
    }

    private void nonRotatingPillarBlock(RegistrySupplier<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeColumn(this.name(block.get()), blockTexture(block.get()), blockTextureTop(block.get())));
    }

    public ResourceLocation blockTextureTop(Block block) {
        ResourceLocation name = this.key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), "block/" + name.getPath() + "_top");
    }
}
