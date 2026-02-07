package com.drd.backported.datagen.server;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import com.drd.backported.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Tricky Trials
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MACE.get())
                .pattern("#")
                .pattern("I")
                .define('#', ModBlocks.HEAVY_CORE.get())
                .define('I', ModItems.BREEZE_ROD.get())
                .unlockedBy(getHasName(ModItems.BREEZE_ROD.get()), has(ModItems.BREEZE_ROD.get()))
                .unlockedBy(getHasName(ModBlocks.HEAVY_CORE.get()), has(ModBlocks.HEAVY_CORE.get()))
                .save(consumer);

        unpack(ModItems.BREEZE_ROD.get(), ModItems.WIND_CHARGE.get(), 4, consumer);

        // The Copper Age
        resourceUnpack(Items.COPPER_INGOT, ModItems.COPPER_NUGGET.get(), consumer);
        nuggetsToIngot(ModItems.COPPER_NUGGET.get(), Items.COPPER_INGOT, consumer);
        sword(Items.COPPER_INGOT, ModItems.COPPER_SWORD.get(), consumer);
        shovel(Items.COPPER_INGOT, ModItems.COPPER_SHOVEL.get(), consumer);
        pickaxe(Items.COPPER_INGOT, ModItems.COPPER_PICKAXE.get(), consumer);
        axe(Items.COPPER_INGOT, ModItems.COPPER_AXE.get(), consumer);
        hoe(Items.COPPER_INGOT, ModItems.COPPER_HOE.get(), consumer);
        helmet(Items.COPPER_INGOT, ModItems.COPPER_HELMET.get(), consumer);
        chestplate(Items.COPPER_INGOT, ModItems.COPPER_CHESTPLATE.get(), consumer);
        leggings(Items.COPPER_INGOT, ModItems.COPPER_LEGGINGS.get(), consumer);
        boots(Items.COPPER_INGOT, ModItems.COPPER_BOOTS.get(), consumer);

        // Mounts of Mayhem
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOODEN_SPEAR.get())
                .pattern("  X")
                .pattern(" # ")
                .pattern("#  ")
                .define('#', ModTags.Items.STICKS)
                .define('X', ItemTags.PLANKS)
                .unlockedBy("has_stick", has(ModTags.Items.STICKS))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STONE_SPEAR.get())
                .pattern("  X")
                .pattern(" # ")
                .pattern("#  ")
                .define('#', ModTags.Items.STICKS)
                .define('X', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(consumer);
        spear(Items.COPPER_INGOT, ModItems.COPPER_SPEAR.get(), consumer);
        spear(Items.IRON_INGOT, ModItems.IRON_SPEAR.get(), consumer);
        spear(Items.GOLD_INGOT, ModItems.GOLDEN_SPEAR.get(), consumer);
        spear(Items.DIAMOND, ModItems.DIAMOND_SPEAR.get(), consumer);
        netheriteSmithing(consumer, ModItems.DIAMOND_SPEAR.get(), RecipeCategory.COMBAT, ModItems.NETHERITE_SPEAR.get());
    }

    protected static void packing2x2(ItemLike unpackedItem, ItemLike packedItem, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, packedItem)
                .pattern("##")
                .pattern("##")
                .define('#', unpackedItem)
                .group(group)
                .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
                .save(consumer);
    }

    protected static void packing3x3(ItemLike unpackedItem, ItemLike packedItem, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, packedItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', unpackedItem)
                .group(group)
                .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
                .save(consumer);
    }

    protected static void nuggetsToIngot(ItemLike nuggets, ItemLike ingot, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', nuggets)
                .group(getItemName(ingot))
                .unlockedBy(getHasName(nuggets), has(nuggets))
                .save(consumer, ingot + "_from_nuggets");
    }

    protected static void unpack(ItemLike packedItem, ItemLike unpackedItem, int count, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unpackedItem, count)
                .requires(packedItem)
                .unlockedBy(getHasName(packedItem), has(packedItem))
                .save(consumer);
    }

    protected static void resourceUnpack(ItemLike packedItem, ItemLike unpackedItem, Consumer<FinishedRecipe> consumer) {
        unpack(packedItem, unpackedItem, 9, consumer);
    }

    protected static void sword(ItemLike material, ItemLike sword, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('#', ModTags.Items.STICKS)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void shovel(ItemLike material, ItemLike shovel, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .define('#', ModTags.Items.STICKS)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void pickaxe(ItemLike material, ItemLike pickaxe, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('#', ModTags.Items.STICKS)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void axe(ItemLike material, ItemLike axe, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .define('#', ModTags.Items.STICKS)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void hoe(ItemLike material, ItemLike hoe, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .define('#', ModTags.Items.STICKS)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void spear(ItemLike material, ItemLike spear, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, spear)
                .pattern("  X")
                .pattern(" # ")
                .pattern("#  ")
                .define('#', ModTags.Items.STICKS)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void helmet(ItemLike material, ItemLike helmet, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .pattern("XXX")
                .pattern("X X")
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void chestplate(ItemLike material, ItemLike chestplate, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void leggings(ItemLike material, ItemLike leggings, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }

    protected static void boots(ItemLike material, ItemLike boots, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .pattern("X X")
                .pattern("X X")
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(consumer);
    }
}
