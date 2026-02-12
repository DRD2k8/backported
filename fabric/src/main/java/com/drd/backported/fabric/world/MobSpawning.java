package com.drd.backported.fabric.world;

import com.drd.backported.Backported;
import com.drd.backported.util.ModTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class MobSpawning {
    public static void addAndRemoveSpawns() {
        int spawnWeight = 8;

        MobSpawnSettings.SpawnerData fourFour =
                new MobSpawnSettings.SpawnerData(EntityType.WOLF, spawnWeight, 4, 4);
        MobSpawnSettings.SpawnerData twoFour =
                new MobSpawnSettings.SpawnerData(EntityType.WOLF, spawnWeight, 2, 4);
        MobSpawnSettings.SpawnerData fourEight =
                new MobSpawnSettings.SpawnerData(EntityType.WOLF, spawnWeight, 4, 8);
        MobSpawnSettings.SpawnerData one =
                new MobSpawnSettings.SpawnerData(EntityType.WOLF, spawnWeight, 1, 1);

        BiomeModifications.create(new ResourceLocation(Backported.MOD_ID, "change_wolves"))
                .add(ModificationPhase.REMOVALS,
                        ctx -> ctx.hasTag(BiomeTags.IS_OVERWORLD),
                        (ctx, mod) -> mod.getSpawnSettings().removeSpawnsOfEntityType(EntityType.WOLF)
                )

                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_PALE_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, fourFour)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_WOODS_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, fourFour)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_ASHEN_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, fourFour)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_BLACK_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, twoFour)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_CHESTNUT_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, twoFour)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_RUSTY_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, twoFour)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_SPOTTED_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, fourEight)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_STRIPED_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, fourEight)
                )
                .add(ModificationPhase.REPLACEMENTS,
                        ctx -> ctx.hasTag(ModTags.Biomes.SPAWNS_SNOWY_WOLF),
                        (ctx, mod) -> mod.getSpawnSettings().addSpawn(MobCategory.CREATURE, one)
                );
    }
}
