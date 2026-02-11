package com.drd.backported.datagen.client;

import com.drd.backported.Backported;
import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Backported.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Tricky Trials
        simpleItem(ModItems.BREEZE_ROD);
        simpleItem(ModItems.WIND_CHARGE);

        // The Garden Awakens
        evenSimplerBlockItem(ModBlocks.PALE_OAK_STAIRS);
        evenSimplerBlockItem(ModBlocks.PALE_OAK_SLAB);
        fenceItem(ModBlocks.PALE_OAK_FENCE, ModBlocks.PALE_OAK_PLANKS);
        evenSimplerBlockItem(ModBlocks.PALE_OAK_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.PALE_OAK_PRESSURE_PLATE);
        simpleBlockItem(ModBlocks.PALE_OAK_DOOR);
        withExistingParent("pale_oak_trapdoor", ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "block/pale_oak_trapdoor_bottom"));
        buttonItem(ModBlocks.PALE_OAK_BUTTON, ModBlocks.PALE_OAK_PLANKS);
        simpleItem(ModItems.PALE_OAK_SIGN);
        simpleItem(ModItems.PALE_OAK_HANGING_SIGN);

        // The Copper Age
        simpleItem(ModItems.COPPER_NUGGET);
        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_HOE);
        simpleItem(ModItems.COPPER_HELMET);
        simpleItem(ModItems.COPPER_CHESTPLATE);
        simpleItem(ModItems.COPPER_LEGGINGS);
        simpleItem(ModItems.COPPER_BOOTS);
    }

    private ItemModelBuilder simpleItem(RegistrySupplier<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistrySupplier<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistrySupplier<Block> block) {
        String name = block.getId().getPath();
        this.withExistingParent( name, modLoc("block/" + name) );
    }

    public void trapdoorItem(RegistrySupplier<Block> block) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistrySupplier<Block> block, RegistrySupplier<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistrySupplier<Block> block, RegistrySupplier<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistrySupplier<Block> block, RegistrySupplier<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistrySupplier<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID,"item/" + item.getId().getPath()));
    }
}
