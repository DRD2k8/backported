package com.drd.backported.datagen.server.tags;

import com.drd.backported.Backported;
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
        this.tag(ModTags.Items.METAL_NUGGETS)
                .addTag(Tags.Items.NUGGETS);

        this.tag(Tags.Items.NUGGETS)
                .addTag(ModTags.Items.COPPER_NUGGETS);

        this.tag(ModTags.Items.COPPER_NUGGETS)
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

        this.tag(ModTags.Items.SPEARS)
                .add(ModItems.DIAMOND_SPEAR.get())
                .add(ModItems.STONE_SPEAR.get())
                .add(ModItems.GOLDEN_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get())
                .add(ModItems.WOODEN_SPEAR.get())
                .add(ModItems.IRON_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get());
    }
}
