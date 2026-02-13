package com.drd.backported.fabric.util;

import com.drd.backported.init.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModLootModifiers {
    private static final ResourceLocation SIMPLE_DUNGEON = new ResourceLocation("chests/simple_dungeon");
    private static final ResourceLocation DESERT_PYRAMID = new ResourceLocation("chests/desert_pyramid");
    private static final ResourceLocation END_CITY = new ResourceLocation("chests/end_city_treasure");
    private static final ResourceLocation JUNGLE_TEMPLE = new ResourceLocation("chests/jungle_temple");
    private static final ResourceLocation NETHER_BRIDGE = new ResourceLocation("chests/nether_bridge");
    private static final ResourceLocation STRONGHOLD_CORRIDOR = new ResourceLocation("chests/stronghold_corridor");
    private static final ResourceLocation VILLAGE_WEAPONSMITH = new ResourceLocation("chests/village/village_weaponsmith");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(SIMPLE_DUNGEON)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.194f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
            if (id.equals(DESERT_PYRAMID)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.17f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
            if (id.equals(END_CITY)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.044f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
            if (id.equals(JUNGLE_TEMPLE)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.044f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
            if (id.equals(NETHER_BRIDGE)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.179f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
            if (id.equals(STRONGHOLD_CORRIDOR)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.025f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
            if (id.equals(VILLAGE_WEAPONSMITH)) {
                LootPool copperHorseArmor = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_ARMOR.get()))
                        .build();

                tableBuilder.pool(copperHorseArmor);
            }
        });
    }
}
