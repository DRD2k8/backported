package com.drd.backported.item;

import com.drd.backported.Backported;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier COPPER = TierSortingRegistry.registerTier(
            new ForgeTier(1, 191, 5f, 1f, 13,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT)),
            ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "copper"), List.of(Tiers.STONE), List.of(Tiers.IRON));
}
