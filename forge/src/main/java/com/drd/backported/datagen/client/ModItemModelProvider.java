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
        simpleItem(ModItems.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(ModItems.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE);
        simpleItem(ModItems.FLOW_BANNER_PATTERN);
        simpleItem(ModItems.GUSTER_BANNER_PATTERN);
        simpleItem(ModItems.BREEZE_ROD);
        waxedItems("chiseled_copper");
        waxedItems("copper_grate");
        simpleBlockItem(ModBlocks.COPPER_DOOR);
        simpleBlockItem(ModBlocks.EXPOSED_COPPER_DOOR);
        simpleBlockItem(ModBlocks.WEATHERED_COPPER_DOOR);
        simpleBlockItem(ModBlocks.OXIDIZED_COPPER_DOOR);
        waxedItems("copper_door");
        musicDiscItem(ModItems.MUSIC_DISC_CREATOR);
        musicDiscItem(ModItems.MUSIC_DISC_CREATOR_MUSIC_BOX);
        musicDiscItem(ModItems.MUSIC_DISC_PRECIPICE);
        vanillaLikeWallItem(ModBlocks.TUFF_WALL, "tuff");
        wallItem(ModBlocks.POLISHED_TUFF_WALL, ModBlocks.POLISHED_TUFF);
        wallItem(ModBlocks.TUFF_BRICK_WALL, ModBlocks.TUFF_BRICKS);
        simpleItem(ModItems.WIND_CHARGE);

        // Bundles of Bravery
        simpleItem(ModItems.FIELD_MASONED_BANNER_PATTERN);
        simpleItem(ModItems.BORDURE_INDENTED_BANNER_PATTERN);

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
        simpleItem(ModItems.PALE_OAK_BOAT);
        simpleItem(ModItems.PALE_OAK_CHEST_BOAT);
        simpleBlockItem(ModBlocks.RESIN_CLUMP);
        simpleItem(ModItems.RESIN_BRICK);
        evenSimplerBlockItem(ModBlocks.RESIN_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.RESIN_BRICK_SLAB);
        wallItem(ModBlocks.RESIN_BRICK_WALL, ModBlocks.RESIN_BRICKS);

        // Spring to Life
        simpleBlockItem(ModBlocks.FIREFLY_BUSH);

        // Chase the Skies
        musicDiscItem(ModItems.MUSIC_DISC_LAVA_CHICKEN);
        musicDiscItem(ModItems.MUSIC_DISC_TEARS);

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
        simpleItem(ModItems.COPPER_HORSE_ARMOR);
        simplerBlockItem(ModBlocks.COPPER_BARS);
        simplerBlockItem(ModBlocks.EXPOSED_COPPER_BARS);
        simplerBlockItem(ModBlocks.WEATHERED_COPPER_BARS);
        simplerBlockItem(ModBlocks.OXIDIZED_COPPER_BARS);
        waxedItems("copper_bars");
        simpleBlockItem(ModBlocks.COPPER_CHAIN);
        simpleBlockItem(ModBlocks.EXPOSED_COPPER_CHAIN);
        simpleBlockItem(ModBlocks.WEATHERED_COPPER_CHAIN);
        simpleBlockItem(ModBlocks.OXIDIZED_COPPER_CHAIN);
        waxedItems("copper_chain");

        // Mounts of Mayhem
        simpleItem(ModItems.NETHERITE_HORSE_ARMOR);
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

    private ItemModelBuilder simplerBlockItem(RegistrySupplier<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID,"block/" + item.getId().getPath()));
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

    public void vanillaLikeWallItem(RegistrySupplier<Block> block, String baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.withDefaultNamespace("block/" + baseBlock));
    }

    private ItemModelBuilder handheldItem(RegistrySupplier<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder musicDiscItem(RegistrySupplier<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/template_music_disc")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder waxedItems(String unwaxedItem) {
        this.withExistingParent("waxed_" + unwaxedItem, ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "item/" + unwaxedItem));
        this.withExistingParent("waxed_exposed_" + unwaxedItem, ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "item/exposed_" + unwaxedItem));
        this.withExistingParent("waxed_weathered_" + unwaxedItem, ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "item/weathered_" + unwaxedItem));
        return this.withExistingParent("waxed_oxidized_" + unwaxedItem, ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "item/oxidized_" + unwaxedItem));
    }
}
