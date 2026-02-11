package com.drd.backported.datagen.server;

import com.drd.backported.init.ModBlocks;
import com.drd.backported.init.ModItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

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

        @Override
        protected void generate() {
            // Tricky Trials
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
