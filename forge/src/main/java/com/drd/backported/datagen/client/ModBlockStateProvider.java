package com.drd.backported.datagen.client;

import com.drd.backported.Backported;
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
}
