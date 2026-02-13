package com.drd.backported.datagen.server;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import com.drd.backported.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
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

        // The Garden Awakens
        bark(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.PALE_OAK_WOOD.get(), consumer);
        bark(ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), consumer);
        planks(ModTags.Items.PALE_OAK_LOGS, ModBlocks.PALE_OAK_PLANKS.get(), consumer);
        woodenStairs(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_STAIRS.get(), consumer);
        woodenSlab(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_SLAB.get(), consumer);
        woodenFence(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_FENCE.get(), consumer);
        woodenFenceGate(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_FENCE_GATE.get(), consumer);
        woodenDoor(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_DOOR.get(), consumer);
        woodenTrapdoor(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_TRAPDOOR.get(), consumer);
        woodenPressurePlate(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_PRESSURE_PLATE.get(), consumer);
        woodenButton(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_BUTTON.get(), consumer);
        sign(ModBlocks.PALE_OAK_PLANKS.get(), ModItems.PALE_OAK_SIGN.get(), consumer);
        hangingSign(ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModItems.PALE_OAK_HANGING_SIGN.get(), consumer);
        boat(ModBlocks.PALE_OAK_PLANKS.get(), ModItems.PALE_OAK_BOAT.get(), consumer);
        chestBoat(ModItems.PALE_OAK_BOAT.get(), ModItems.PALE_OAK_CHEST_BOAT.get(), consumer);

        // Chase the Skies
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.LEAD, 2)
                .pattern("~~ ")
                .pattern("~~ ")
                .pattern("  ~")
                .define('~', Items.STRING)
                .unlockedBy("has_string", has(Items.STRING))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.SADDLE)
                .pattern(" X ")
                .pattern("X#X")
                .define('#', Items.IRON_INGOT)
                .define('X', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(consumer);

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
        netheriteSmithing(consumer, Items.DIAMOND_HORSE_ARMOR, RecipeCategory.COMBAT, ModItems.NETHERITE_HORSE_ARMOR.get());

        // First Drop 2026
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.NAME_TAG)
                .pattern(" X")
                .pattern("# ")
                .define('#', Items.PAPER)
                .define('X', ModTags.Items.METAL_NUGGETS)
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_metal_nugget", has(ModTags.Items.METAL_NUGGETS))
                .save(consumer);
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

    protected static void bark(ItemLike log, ItemLike bark, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bark, 3)
                .pattern("##")
                .pattern("##")
                .define('#', log)
                .group("bark")
                .unlockedBy("has_log", has(log))
                .save(consumer);
    }

    protected static void planks(TagKey<Item> log, ItemLike planks, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                .requires(log)
                .group("planks")
                .unlockedBy("has_log", has(log))
                .save(consumer);
    }

    protected static void stairs(ItemLike base, ItemLike stairs, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    protected static void woodenStairs(ItemLike planks, ItemLike stairs, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', planks)
                .group("wooden_stairs")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void slab(ItemLike base, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    protected static void woodenSlab(ItemLike planks, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', planks)
                .group("wooden_slab")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void woodenFence(ItemLike planks, ItemLike fence, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, fence, 3)
                .pattern("W#W")
                .pattern("W#W")
                .define('#', ModTags.Items.STICKS)
                .define('W', planks)
                .group("wooden_fence")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void woodenFenceGate(ItemLike planks, ItemLike fenceGate, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, fenceGate)
                .pattern("#W#")
                .pattern("#W#")
                .define('#', ModTags.Items.STICKS)
                .define('W', planks)
                .group("wooden_fence_gate")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void door(ItemLike base, ItemLike door, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, door, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    protected static void woodenDoor(ItemLike planks, ItemLike door, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, door, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', planks)
                .group("wooden_door")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void trapdoor(ItemLike base, ItemLike trapdoor, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, trapdoor, 2)
                .pattern("###")
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    protected static void woodenTrapdoor(ItemLike planks, ItemLike trapdoor, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, trapdoor, 2)
                .pattern("###")
                .pattern("###")
                .define('#', planks)
                .group("wooden_trapdoor")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void pressurePlate(ItemLike base, ItemLike pressurePlate, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pressurePlate)
                .pattern("##")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    protected static void woodenPressurePlate(ItemLike planks, ItemLike pressurePlate, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pressurePlate)
                .pattern("##")
                .define('#', planks)
                .group("wooden_pressure_plate")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void button(ItemLike base, ItemLike button, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, button)
                .requires(base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    protected static void woodenButton(ItemLike planks, ItemLike button, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, button)
                .requires(planks)
                .group("wooden_button")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void shelf(ItemLike strippedLog, ItemLike shelf, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, shelf, 6)
                .pattern("###")
                .pattern("   ")
                .pattern("###")
                .define('#', strippedLog)
                .group("shelf")
                .unlockedBy("has_stripped_log", has(strippedLog))
                .save(consumer);
    }

    protected static void sign(ItemLike planks, ItemLike sign, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sign, 3)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .define('#', planks)
                .define('X', ModTags.Items.STICKS)
                .group("wooden_sign")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void hangingSign(ItemLike strippedLog, ItemLike hangingSign, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, hangingSign, 6)
                .pattern("X X")
                .pattern("###")
                .pattern("###")
                .define('#', strippedLog)
                .define('X', Items.CHAIN)
                .group("hanging_sign")
                .unlockedBy("has_stripped_log", has(strippedLog))
                .save(consumer);
    }

    protected static void boat(ItemLike planks, ItemLike boat, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, boat)
                .pattern("# #")
                .pattern("###")
                .define('#', planks)
                .group("boat")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    protected static void chestBoat(ItemLike boat, ItemLike chestBoat, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, chestBoat)
                .requires(Items.CHEST)
                .requires(boat)
                .group("chest_boat")
                .unlockedBy("has_boat", has(boat))
                .save(consumer);
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
