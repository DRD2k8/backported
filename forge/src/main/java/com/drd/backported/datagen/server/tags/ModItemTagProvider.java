package com.drd.backported.datagen.server.tags;

import com.drd.backported.Backported;
import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import com.drd.backported.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookup, Backported.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTag(ModTags.Items.PALE_OAK_LOGS);

        this.tag(ModTags.Items.PALE_OAK_LOGS)
                .add(ModBlocks.PALE_OAK_LOG.get().asItem())
                .add(ModBlocks.PALE_OAK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PALE_OAK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PALE_OAK_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.PALE_OAK_PLANKS.get().asItem());

        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.PALE_OAK_STAIRS.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.PALE_OAK_SLAB.get().asItem());

        this.tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.PALE_OAK_FENCE.get().asItem());

        this.tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.PALE_OAK_FENCE_GATE.get().asItem());

        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.PALE_OAK_DOOR.get().asItem());

        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PALE_OAK_TRAPDOOR.get().asItem());

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALE_OAK_PRESSURE_PLATE.get().asItem());

        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALE_OAK_BUTTON.get().asItem());

        this.tag(ItemTags.SIGNS)
                .add(ModItems.PALE_OAK_SIGN.get());

        this.tag(ItemTags.HANGING_SIGNS)
                .add(ModItems.PALE_OAK_HANGING_SIGN.get());

        this.tag(ItemTags.BOATS)
                .add(ModItems.PALE_OAK_BOAT.get());

        this.tag(ItemTags.CHEST_BOATS)
                .add(ModItems.PALE_OAK_CHEST_BOAT.get());

        this.tag(ModTags.Items.METAL_NUGGETS)
                .addOptionalTag(Tags.Items.NUGGETS)
                .addOptionalTag(ModTags.Items.FABRIC_NUGGETS);

        this.tag(Tags.Items.NUGGETS)
                .addTag(ModTags.Items.FORGE_COPPER_NUGGETS);

        this.tag(ModTags.Items.FABRIC_NUGGETS)
                .addTag(ModTags.Items.FABRIC_COPPER_NUGGETS);

        this.tag(ModTags.Items.FORGE_COPPER_NUGGETS)
                .add(ModItems.COPPER_NUGGET.get());

        this.tag(ModTags.Items.FABRIC_COPPER_NUGGETS)
                .add(ModItems.COPPER_NUGGET.get());

        this.tag(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD.get());

        this.tag(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL.get());

        this.tag(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE.get());

        this.tag(ItemTags.AXES)
                .add(ModItems.COPPER_AXE.get());

        this.tag(ItemTags.HOES)
                .add(ModItems.COPPER_HOE.get());

        this.tag(ModTags.Items.STICKS)
                .addOptionalTag(Tags.Items.RODS_WOODEN)
                .addOptionalTag(ModTags.Items.FABRIC_WOODEN_RODS);

        this.tag(ModTags.Items.SPEARS)
                .add(ModItems.DIAMOND_SPEAR.get())
                .add(ModItems.STONE_SPEAR.get())
                .add(ModItems.GOLDEN_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get())
                .add(ModItems.WOODEN_SPEAR.get())
                .add(ModItems.IRON_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get());

        this.tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.GOLDEN_SPEAR.get());
    }
}
