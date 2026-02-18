package com.drd.backported.datagen.server.tags;

import com.drd.backported.Backported;
import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import com.drd.backported.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
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

        this.tag(ModTags.Items.WOODEN_SHELVES)
                .add(ModBlocks.OAK_SHELF.get().asItem())
                .add(ModBlocks.SPRUCE_SHELF.get().asItem())
                .add(ModBlocks.BIRCH_SHELF.get().asItem())
                .add(ModBlocks.JUNGLE_SHELF.get().asItem())
                .add(ModBlocks.ACACIA_SHELF.get().asItem())
                .add(ModBlocks.DARK_OAK_SHELF.get().asItem())
                .add(ModBlocks.MANGROVE_SHELF.get().asItem())
                .add(ModBlocks.CHERRY_SHELF.get().asItem())
                .add(ModBlocks.PALE_OAK_SHELF.get().asItem())
                .add(ModBlocks.BAMBOO_SHELF.get().asItem())
                .add(ModBlocks.CRIMSON_SHELF.get().asItem())
                .add(ModBlocks.WARPED_SHELF.get().asItem());

        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.TUFF_STAIRS.get().asItem())
                .add(ModBlocks.POLISHED_TUFF_STAIRS.get().asItem())
                .add(ModBlocks.TUFF_BRICK_STAIRS.get().asItem())
                .add(ModBlocks.RESIN_BRICK_STAIRS.get().asItem());

        this.tag(ItemTags.SLABS)
                .add(ModBlocks.TUFF_SLAB.get().asItem())
                .add(ModBlocks.POLISHED_TUFF_SLAB.get().asItem())
                .add(ModBlocks.TUFF_BRICK_SLAB.get().asItem())
                .add(ModBlocks.RESIN_BRICK_SLAB.get().asItem());

        this.tag(ItemTags.WALLS)
                .add(ModBlocks.TUFF_WALL.get().asItem())
                .add(ModBlocks.POLISHED_TUFF_WALL.get().asItem())
                .add(ModBlocks.TUFF_BRICK_WALL.get().asItem())
                .add(ModBlocks.RESIN_BRICK_WALL.get().asItem());

        this.tag(ItemTags.DOORS)
                .add(ModBlocks.COPPER_DOOR.get().asItem())
                .add(ModBlocks.EXPOSED_COPPER_DOOR.get().asItem())
                .add(ModBlocks.WEATHERED_COPPER_DOOR.get().asItem())
                .add(ModBlocks.OXIDIZED_COPPER_DOOR.get().asItem())
                .add(ModBlocks.WAXED_COPPER_DOOR.get().asItem())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get().asItem())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get().asItem())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get().asItem());

        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.WAXED_COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get().asItem())
                .add(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get().asItem());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_CREATOR.get())
                .add(ModItems.MUSIC_DISC_CREATOR_MUSIC_BOX.get())
                .add(ModItems.MUSIC_DISC_PRECIPICE.get())
                .add(ModItems.MUSIC_DISC_TEARS.get())
                .add(ModItems.MUSIC_DISC_LAVA_CHICKEN.get());

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

        this.tag(ModTags.Items.STRING)
                .addOptionalTag(Tags.Items.STRING)
                .addOptionalTag(ModTags.Items.FABRIC_STRING);

        this.tag(ModTags.Items.SPEARS)
                .add(ModItems.DIAMOND_SPEAR.get())
                .add(ModItems.STONE_SPEAR.get())
                .add(ModItems.GOLDEN_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get())
                .add(ModItems.WOODEN_SPEAR.get())
                .add(ModItems.IRON_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET.get())
                .add(ModItems.COPPER_CHESTPLATE.get())
                .add(ModItems.COPPER_LEGGINGS.get())
                .add(ModItems.COPPER_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.RESIN_BRICK.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE.get())
                .add(ModItems.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE.get());

        this.tag(ItemTags.DECORATED_POT_SHERDS)
                .add(ModItems.FLOW_POTTERY_SHERD.get())
                .add(ModItems.GUSTER_POTTERY_SHERD.get())
                .add(ModItems.SCRAPE_POTTERY_SHERD.get());

        this.tag(ItemTags.PIGLIN_LOVED)
                .add(ModItems.GOLDEN_SPEAR.get());

        this.tag(ModTags.Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE_INGREDIENTS)
                .add(Items.COPPER_BLOCK)
                .add(Items.WAXED_COPPER_BLOCK);

        this.tag(ModTags.Items.SHEARS)
                .addOptionalTag(Tags.Items.SHEARS)
                .addOptionalTag(ModTags.Items.FABRIC_SHEARS);
    }
}
