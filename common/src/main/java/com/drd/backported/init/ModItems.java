package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.entity.CustomBoat;
import com.drd.backported.item.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Backported.MOD_ID, Registries.ITEM);

    // Tricky Trials
    public static final RegistrySupplier<Item> BREEZE_ROD = basicItem("breeze_rod");
    public static final RegistrySupplier<Item> MACE = ITEMS.register("mace", () -> new MaceItem(new Item.Properties().rarity(Rarity.EPIC).durability(500)));
    public static final RegistrySupplier<Item> WIND_CHARGE = ITEMS.register("wind_charge", () -> new WindChargeItem(new Item.Properties()));

    // The Garden Awakens
    public static final RegistrySupplier<Item> PALE_OAK_SIGN = ITEMS.register("pale_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PALE_OAK_SIGN.get(), ModBlocks.PALE_OAK_WALL_SIGN.get()));
    public static final RegistrySupplier<Item> PALE_OAK_HANGING_SIGN = ITEMS.register("pale_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PALE_OAK_HANGING_SIGN.get(), ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistrySupplier<Item> PALE_OAK_BOAT = ITEMS.register("pale_oak_boat",
            () -> new CustomBoatItem(false, CustomBoat.Type.PALE_OAK, new Item.Properties()));
    public static final RegistrySupplier<Item> PALE_OAK_CHEST_BOAT = ITEMS.register("pale_oak_chest_boat",
            () -> new CustomBoatItem(true, CustomBoat.Type.PALE_OAK, new Item.Properties()));

    // The Copper Age
    public static final RegistrySupplier<Item> COPPER_NUGGET = basicItem("copper_nugget");
    public static final RegistrySupplier<Item> COPPER_SWORD = sword("copper", ModToolTiers.COPPER, 5, 1.6f);
    public static final RegistrySupplier<Item> COPPER_SHOVEL = shovel("copper", ModToolTiers.COPPER, 3.5f, 1f);
    public static final RegistrySupplier<Item> COPPER_PICKAXE = pickaxe("copper", ModToolTiers.COPPER, 3, 1.2f);
    public static final RegistrySupplier<Item> COPPER_AXE = axe("copper", ModToolTiers.COPPER, 9f, 0.8f);
    public static final RegistrySupplier<Item> COPPER_HOE = hoe("copper", ModToolTiers.COPPER, 1, 2f);
    public static final RegistrySupplier<Item> COPPER_HELMET = armorItem("copper", ArmorItem.Type.HELMET, ModArmorMaterials.COPPER);
    public static final RegistrySupplier<Item> COPPER_CHESTPLATE = armorItem("copper", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.COPPER);
    public static final RegistrySupplier<Item> COPPER_LEGGINGS = armorItem("copper", ArmorItem.Type.LEGGINGS, ModArmorMaterials.COPPER);
    public static final RegistrySupplier<Item> COPPER_BOOTS = armorItem("copper", ArmorItem.Type.BOOTS, ModArmorMaterials.COPPER);

    // Mounts of Mayhem
    public static final RegistrySupplier<Item> WOODEN_SPEAR = spear("wooden", Tiers.WOOD, 1.54, 0.65f, 0.7f, 0.75f, 5f, 14f, 6f, 15f, ModSounds.SPEAR_WOOD_HIT, ModSounds.SPEAR_WOOD_ATTACK, ModSounds.SPEAR_WOOD_USE);
    public static final RegistrySupplier<Item> STONE_SPEAR = spear("stone", Tiers.STONE, 1.33, 0.75f, 0.82f, 0.7f, 4.5f, 10f, 5.5f, 13.75f);
    public static final RegistrySupplier<Item> COPPER_SPEAR = spear("copper", ModToolTiers.COPPER, 1.18, 0.85f, 0.82f, 0.65f, 4f, 9f, 5f, 12.5f);
    public static final RegistrySupplier<Item> IRON_SPEAR = spear("iron", Tiers.IRON, 1.05, 0.95f, 0.95f, 0.6f, 2.5f, 8f, 4.5f, 11.25f);
    public static final RegistrySupplier<Item> GOLDEN_SPEAR = spear("golden", Tiers.GOLD, 1.05, 0.95f, 0.7f, 0.7f, 3.5f, 10f, 5.5f, 13.75f);
    public static final RegistrySupplier<Item> DIAMOND_SPEAR = spear("diamond", Tiers.DIAMOND, 0.95, 1.05f, 1.075f, 0.5f, 3f, 7.5f, 4f, 10f);
    public static final RegistrySupplier<Item> NETHERITE_SPEAR = spear("netherite", Tiers.NETHERITE, 0.87, 1.15f, 1.2f, 0.4f, 2.5f, 7.0f, 3.5f, 8.75f);

    private static RegistrySupplier<Item> basicItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static RegistrySupplier<Item> sword(String material, Tier tier, int attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_sword", () -> new SwordItem(tier, attackDamage - 2, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistrySupplier<Item> shovel(String material, Tier tier, float attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_shovel", () -> new ShovelItem(tier, attackDamage - 2f, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistrySupplier<Item> pickaxe(String material, Tier tier, int attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_pickaxe", () -> new PickaxeItem(tier, attackDamage - 2, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistrySupplier<Item> axe(String material, Tier tier, float attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_axe", () -> new AxeItem(tier, attackDamage - 2f, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistrySupplier<Item> hoe(String material, Tier tier, int attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_hoe", () -> new HoeItem(tier, attackDamage - 2, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistrySupplier<Item> spear(String material, Tier tier, double attackSpeed, float swingAnimationSeconds, float chargeDamageMultiplier, float chargeDelaySeconds, float maxDurationForDismountSeconds, float minSpeedForDismount, float maxDurationForChargeKnockbackInSeconds, float maxDurationForChargeDamageInSeconds) {
        return ITEMS.register(material + "_spear", () -> new SpearItem(tier, attackSpeed, (int) (swingAnimationSeconds * 20f), chargeDamageMultiplier, chargeDelaySeconds, maxDurationForDismountSeconds, minSpeedForDismount, maxDurationForChargeKnockbackInSeconds, 5.1f, maxDurationForChargeDamageInSeconds, 4.6f, ModSounds.SPEAR_HIT, ModSounds.SPEAR_ATTACK, ModSounds.SPEAR_USE, new Item.Properties()));
    }

    private static RegistrySupplier<Item> spear(String material, Tier tier, double attackSpeed, float swingAnimationSeconds, float chargeDamageMultiplier, float chargeDelaySeconds, float maxDurationForDismountSeconds, float minSpeedForDismount, float maxDurationForChargeKnockbackInSeconds, float maxDurationForChargeDamageInSeconds, RegistrySupplier<SoundEvent> hitSound, RegistrySupplier<SoundEvent> attackSound, RegistrySupplier<SoundEvent> useSound) {
        return ITEMS.register(material + "_spear", () -> new SpearItem(tier, attackSpeed, (int) (swingAnimationSeconds * 20f), chargeDamageMultiplier, chargeDelaySeconds, maxDurationForDismountSeconds, minSpeedForDismount, maxDurationForChargeKnockbackInSeconds, 5.1f, maxDurationForChargeDamageInSeconds, 4.6f, hitSound, attackSound, useSound, new Item.Properties()));
    }

    private static RegistrySupplier<Item> armorItem(String material, ArmorItem.Type type, ArmorMaterial armorMaterial) {
        return ITEMS.register(material + "_" + type.getName(), () -> new ArmorItem(armorMaterial, type, new Item.Properties()));
    }

    public static void register() {
        ITEMS.register();
    }
}
