package com.drd.backported.datagen.server.tags;

import com.drd.backported.Backported;
import com.drd.backported.init.ModBlocks;
import com.drd.backported.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Backported.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.PALE_OAK_LOGS);

        this.tag(ModTags.Blocks.PALE_OAK_LOGS)
                .add(ModBlocks.PALE_OAK_LOG.get())
                .add(ModBlocks.PALE_OAK_WOOD.get())
                .add(ModBlocks.STRIPPED_PALE_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PALE_OAK_PLANKS.get());

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.PALE_OAK_STAIRS.get());

        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.PALE_OAK_SLAB.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALE_OAK_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PALE_OAK_FENCE_GATE.get());

        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.PALE_OAK_DOOR.get());

        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PALE_OAK_TRAPDOOR.get());

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALE_OAK_BUTTON.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.HEAVY_CORE.get());
    }
}
