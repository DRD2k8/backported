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

        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.PALE_OAK_SIGN.get());

        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.PALE_OAK_WALL_SIGN.get());

        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.PALE_OAK_HANGING_SIGN.get());

        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get());

        this.tag(ModTags.Blocks.WOODEN_SHELVES)
                .add(ModBlocks.OAK_SHELF.get())
                .add(ModBlocks.SPRUCE_SHELF.get())
                .add(ModBlocks.BIRCH_SHELF.get())
                .add(ModBlocks.JUNGLE_SHELF.get())
                .add(ModBlocks.ACACIA_SHELF.get())
                .add(ModBlocks.DARK_OAK_SHELF.get())
                .add(ModBlocks.MANGROVE_SHELF.get())
                .add(ModBlocks.CHERRY_SHELF.get())
                .add(ModBlocks.PALE_OAK_SHELF.get())
                .add(ModBlocks.BAMBOO_SHELF.get())
                .add(ModBlocks.CRIMSON_SHELF.get())
                .add(ModBlocks.WARPED_SHELF.get());

        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.TUFF_STAIRS.get())
                .add(ModBlocks.POLISHED_TUFF_STAIRS.get())
                .add(ModBlocks.TUFF_BRICK_STAIRS.get())
                .add(ModBlocks.RESIN_BRICK_STAIRS.get());

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.TUFF_SLAB.get())
                .add(ModBlocks.POLISHED_TUFF_SLAB.get())
                .add(ModBlocks.TUFF_BRICK_SLAB.get())
                .add(ModBlocks.RESIN_BRICK_SLAB.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.TUFF_WALL.get())
                .add(ModBlocks.POLISHED_TUFF_WALL.get())
                .add(ModBlocks.TUFF_BRICK_WALL.get())
                .add(ModBlocks.RESIN_BRICK_WALL.get());

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.COPPER_DOOR.get())
                .add(ModBlocks.EXPOSED_COPPER_DOOR.get())
                .add(ModBlocks.WEATHERED_COPPER_DOOR.get())
                .add(ModBlocks.OXIDIZED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get());

        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.COPPER_TRAPDOOR.get())
                .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHISELED_COPPER.get())
                .add(ModBlocks.EXPOSED_CHISELED_COPPER.get())
                .add(ModBlocks.WEATHERED_CHISELED_COPPER.get())
                .add(ModBlocks.OXIDIZED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER.get())
                .add(ModBlocks.COPPER_GRATE.get())
                .add(ModBlocks.EXPOSED_COPPER_GRATE.get())
                .add(ModBlocks.WEATHERED_COPPER_GRATE.get())
                .add(ModBlocks.OXIDIZED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get())
                .add(ModBlocks.COPPER_DOOR.get())
                .add(ModBlocks.EXPOSED_COPPER_DOOR.get())
                .add(ModBlocks.WEATHERED_COPPER_DOOR.get())
                .add(ModBlocks.OXIDIZED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get())
                .add(ModBlocks.COPPER_TRAPDOOR.get())
                .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.COPPER_BULB.get())
                .add(ModBlocks.EXPOSED_COPPER_BULB.get())
                .add(ModBlocks.WEATHERED_COPPER_BULB.get())
                .add(ModBlocks.OXIDIZED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_BULB.get())
                .add(ModBlocks.COPPER_BARS.get())
                .add(ModBlocks.EXPOSED_COPPER_BARS.get())
                .add(ModBlocks.WEATHERED_COPPER_BARS.get())
                .add(ModBlocks.OXIDIZED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get())
                .add(ModBlocks.COPPER_CHAIN.get())
                .add(ModBlocks.EXPOSED_COPPER_CHAIN.get())
                .add(ModBlocks.WEATHERED_COPPER_CHAIN.get())
                .add(ModBlocks.OXIDIZED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get())
                .add(ModBlocks.HEAVY_CORE.get())
                .add(ModBlocks.TUFF_STAIRS.get())
                .add(ModBlocks.TUFF_SLAB.get())
                .add(ModBlocks.TUFF_WALL.get())
                .add(ModBlocks.CHISELED_TUFF.get())
                .add(ModBlocks.POLISHED_TUFF.get())
                .add(ModBlocks.POLISHED_TUFF_STAIRS.get())
                .add(ModBlocks.POLISHED_TUFF_SLAB.get())
                .add(ModBlocks.POLISHED_TUFF_WALL.get())
                .add(ModBlocks.TUFF_BRICKS.get())
                .add(ModBlocks.TUFF_BRICK_STAIRS.get())
                .add(ModBlocks.TUFF_BRICK_SLAB.get())
                .add(ModBlocks.TUFF_BRICK_WALL.get())
                .add(ModBlocks.CHISELED_TUFF_BRICKS.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CHISELED_COPPER.get())
                .add(ModBlocks.EXPOSED_CHISELED_COPPER.get())
                .add(ModBlocks.WEATHERED_CHISELED_COPPER.get())
                .add(ModBlocks.OXIDIZED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER.get())
                .add(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER.get())
                .add(ModBlocks.COPPER_GRATE.get())
                .add(ModBlocks.EXPOSED_COPPER_GRATE.get())
                .add(ModBlocks.WEATHERED_COPPER_GRATE.get())
                .add(ModBlocks.OXIDIZED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get())
                .add(ModBlocks.COPPER_DOOR.get())
                .add(ModBlocks.EXPOSED_COPPER_DOOR.get())
                .add(ModBlocks.WEATHERED_COPPER_DOOR.get())
                .add(ModBlocks.OXIDIZED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get())
                .add(ModBlocks.COPPER_TRAPDOOR.get())
                .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get())
                .add(ModBlocks.COPPER_BULB.get())
                .add(ModBlocks.EXPOSED_COPPER_BULB.get())
                .add(ModBlocks.WEATHERED_COPPER_BULB.get())
                .add(ModBlocks.OXIDIZED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_BULB.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_BULB.get())
                .add(ModBlocks.RESIN_BRICKS.get())
                .add(ModBlocks.RESIN_BRICK_STAIRS.get())
                .add(ModBlocks.RESIN_BRICK_SLAB.get())
                .add(ModBlocks.RESIN_BRICK_WALL.get())
                .add(ModBlocks.CHISELED_RESIN_BRICKS.get())
                .add(ModBlocks.COPPER_BARS.get())
                .add(ModBlocks.EXPOSED_COPPER_BARS.get())
                .add(ModBlocks.WEATHERED_COPPER_BARS.get())
                .add(ModBlocks.OXIDIZED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get())
                .add(ModBlocks.COPPER_CHAIN.get())
                .add(ModBlocks.EXPOSED_COPPER_CHAIN.get())
                .add(ModBlocks.WEATHERED_COPPER_CHAIN.get())
                .add(ModBlocks.OXIDIZED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get());
    }
}
