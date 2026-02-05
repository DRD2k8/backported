package com.drd.backported.datagen.server;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MACE.get())
                .pattern("#")
                .pattern("I")
                .define('#', ModBlocks.HEAVY_CORE.get())
                .define('I', ModItems.BREEZE_ROD.get())
                .unlockedBy(getHasName(ModItems.BREEZE_ROD.get()), has(ModItems.BREEZE_ROD.get()))
                .unlockedBy(getHasName(ModBlocks.HEAVY_CORE.get()), has(ModBlocks.HEAVY_CORE.get()))
                .save(consumer);
    }
}
