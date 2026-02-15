package com.drd.backported.datagen.server;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import com.drd.backported.util.ModTags;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(Blocks::new, LootContextParamSets.BLOCK)
        ));
    }

    public static class Blocks extends BlockLootSubProvider {
        protected Blocks() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        LootItemCondition.Builder face(Direction dir) {
            return LootItemBlockStatePropertyCondition
                    .hasBlockStateProperties(ModBlocks.RESIN_CLUMP.get())
                    .setProperties(StatePropertiesPredicate.Builder.properties()
                            .hasProperty(((MultifaceBlock) ModBlocks.RESIN_CLUMP.get()).getFaceProperty(dir), true));
        }

        @Override
        protected void generate() {
            // Tricky Trials
            this.dropSelf(ModBlocks.CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.EXPOSED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.WEATHERED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.OXIDIZED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.WAXED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER.get());
            this.dropSelf(ModBlocks.COPPER_GRATE.get());
            this.dropSelf(ModBlocks.EXPOSED_COPPER_GRATE.get());
            this.dropSelf(ModBlocks.WEATHERED_COPPER_GRATE.get());
            this.dropSelf(ModBlocks.OXIDIZED_COPPER_GRATE.get());
            this.dropSelf(ModBlocks.WAXED_COPPER_GRATE.get());
            this.dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get());
            this.dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get());
            this.dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get());
            this.add(ModBlocks.COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.COPPER_DOOR.get()));
            this.add(ModBlocks.EXPOSED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.EXPOSED_COPPER_DOOR.get()));
            this.add(ModBlocks.WEATHERED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WEATHERED_COPPER_DOOR.get()));
            this.add(ModBlocks.OXIDIZED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.OXIDIZED_COPPER_DOOR.get()));
            this.add(ModBlocks.WAXED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WAXED_COPPER_DOOR.get()));
            this.add(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get()));
            this.add(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get()));
            this.add(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get(),
                    block -> createDoorTable(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get()));
            this.dropSelf(ModBlocks.COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.WAXED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get());
            this.dropSelf(ModBlocks.COPPER_BULB.get());
            this.dropSelf(ModBlocks.EXPOSED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.WEATHERED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.OXIDIZED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.WAXED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_BULB.get());
            this.dropSelf(ModBlocks.TUFF_STAIRS.get());
            this.add(ModBlocks.TUFF_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.TUFF_SLAB.get()));
            this.dropSelf(ModBlocks.TUFF_WALL.get());
            this.dropSelf(ModBlocks.CHISELED_TUFF.get());
            this.dropSelf(ModBlocks.POLISHED_TUFF.get());
            this.dropSelf(ModBlocks.POLISHED_TUFF_STAIRS.get());
            this.add(ModBlocks.POLISHED_TUFF_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.POLISHED_TUFF_SLAB.get()));
            this.dropSelf(ModBlocks.POLISHED_TUFF_WALL.get());
            this.dropSelf(ModBlocks.TUFF_BRICKS.get());
            this.dropSelf(ModBlocks.TUFF_BRICK_STAIRS.get());
            this.add(ModBlocks.TUFF_BRICK_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.TUFF_BRICK_SLAB.get()));
            this.dropSelf(ModBlocks.TUFF_BRICK_WALL.get());
            this.dropSelf(ModBlocks.CHISELED_TUFF_BRICKS.get());
            this.dropSelf(ModBlocks.HEAVY_CORE.get());

            // The Garden Awakens
            this.dropSelf(ModBlocks.PALE_OAK_LOG.get());
            this.dropSelf(ModBlocks.PALE_OAK_WOOD.get());
            this.dropSelf(ModBlocks.STRIPPED_PALE_OAK_LOG.get());
            this.dropSelf(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
            this.dropSelf(ModBlocks.PALE_OAK_PLANKS.get());
            this.dropSelf(ModBlocks.PALE_OAK_STAIRS.get());
            this.add(ModBlocks.PALE_OAK_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.PALE_OAK_SLAB.get()));
            this.dropSelf(ModBlocks.PALE_OAK_FENCE.get());
            this.dropSelf(ModBlocks.PALE_OAK_FENCE_GATE.get());
            this.add(ModBlocks.PALE_OAK_DOOR.get(),
                    block -> createDoorTable(ModBlocks.PALE_OAK_DOOR.get()));
            this.dropSelf(ModBlocks.PALE_OAK_TRAPDOOR.get());
            this.dropSelf(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
            this.dropSelf(ModBlocks.PALE_OAK_BUTTON.get());
            this.add(ModBlocks.PALE_OAK_SIGN.get(),
                    block -> createSingleItemTable(ModItems.PALE_OAK_SIGN.get()));
            this.add(ModBlocks.PALE_OAK_HANGING_SIGN.get(),
                    block -> createSingleItemTable(ModItems.PALE_OAK_HANGING_SIGN.get()));
            this.add(ModBlocks.RESIN_CLUMP.get(), block -> {
                return LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(ModBlocks.RESIN_CLUMP.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).when(face(Direction.DOWN)))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).when(face(Direction.UP)))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).when(face(Direction.NORTH)))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).when(face(Direction.SOUTH)))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).when(face(Direction.WEST)))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).when(face(Direction.EAST)))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1))) // subtract 1
                                        .apply(ApplyExplosionDecay.explosionDecay())
                                )
                        );
            });
            this.dropSelf(ModBlocks.RESIN_BLOCK.get());
            this.dropSelf(ModBlocks.RESIN_BRICKS.get());
            this.dropSelf(ModBlocks.RESIN_BRICK_STAIRS.get());
            this.add(ModBlocks.RESIN_BRICK_SLAB.get(),
                    block -> createSlabItemTable(ModBlocks.RESIN_BRICK_SLAB.get()));
            this.dropSelf(ModBlocks.RESIN_BRICK_WALL.get());
            this.dropSelf(ModBlocks.CHISELED_RESIN_BRICKS.get());

            // Spring to Life
            this.add(ModBlocks.BUSH.get(), block ->
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .when(AnyOfCondition.anyOf(
                                            MatchTool.toolMatches(
                                                    ItemPredicate.Builder.item()
                                                            .of(ModTags.Items.SHEARS)
                                            ),
                                            MatchTool.toolMatches(
                                                    ItemPredicate.Builder.item()
                                                            .hasEnchantment(new EnchantmentPredicate(
                                                                    Enchantments.SILK_TOUCH,
                                                                    MinMaxBounds.Ints.atLeast(1)
                                                            ))
                                            )
                                    ))
                                    .add(LootItem.lootTableItem(ModBlocks.BUSH.get()))
                            )
            );
            this.add(ModBlocks.FIREFLY_BUSH.get(), block ->
                    LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .when(AnyOfCondition.anyOf(
                                            MatchTool.toolMatches(
                                                    ItemPredicate.Builder.item()
                                                            .of(ModTags.Items.SHEARS)
                                            ),
                                            MatchTool.toolMatches(
                                                    ItemPredicate.Builder.item()
                                                            .hasEnchantment(new EnchantmentPredicate(
                                                                    Enchantments.SILK_TOUCH,
                                                                    MinMaxBounds.Ints.atLeast(1)
                                                            ))
                                            )
                                    ))
                                    .add(LootItem.lootTableItem(ModBlocks.FIREFLY_BUSH.get()))
                            )
            );

            // The Copper Age
            this.dropSelf(ModBlocks.COPPER_BARS.get());
            this.dropSelf(ModBlocks.EXPOSED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.WEATHERED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.OXIDIZED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.WAXED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get());
            this.dropSelf(ModBlocks.COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.EXPOSED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.WEATHERED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.OXIDIZED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.WAXED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get());
            this.dropSelf(ModBlocks.OAK_SHELF.get());
            this.dropSelf(ModBlocks.SPRUCE_SHELF.get());
            this.dropSelf(ModBlocks.BIRCH_SHELF.get());
            this.dropSelf(ModBlocks.JUNGLE_SHELF.get());
            this.dropSelf(ModBlocks.ACACIA_SHELF.get());
            this.dropSelf(ModBlocks.DARK_OAK_SHELF.get());
            this.dropSelf(ModBlocks.MANGROVE_SHELF.get());
            this.dropSelf(ModBlocks.CHERRY_SHELF.get());
            this.dropSelf(ModBlocks.PALE_OAK_SHELF.get());
            this.dropSelf(ModBlocks.BAMBOO_SHELF.get());
            this.dropSelf(ModBlocks.CRIMSON_SHELF.get());
            this.dropSelf(ModBlocks.WARPED_SHELF.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            List<Block> blocks = new ArrayList<>();
            for (RegistrySupplier<Block> supplier : ModBlocks.BLOCKS) {
                blocks.add(supplier.get());
            }
            return blocks;
        }
    }
}
