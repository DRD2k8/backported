package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.item.MaceItem;
import com.drd.backported.item.ModArmorMaterials;
import com.drd.backported.item.ModToolTiers;
import com.drd.backported.item.WindChargeItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Backported.MOD_ID);

    // Tricky Trials
    public static final RegistryObject<Item> BREEZE_ROD = basicItem("breeze_rod");
    public static final RegistryObject<Item> MACE = ITEMS.register("mace", () -> new MaceItem(new Item.Properties().rarity(Rarity.EPIC).durability(500)));
    public static final RegistryObject<Item> WIND_CHARGE = ITEMS.register("wind_charge", () -> new WindChargeItem(new Item.Properties()));

    // The Copper Age
    public static final RegistryObject<Item> COPPER_NUGGET = basicItem("copper_nugget");
    public static final RegistryObject<Item> COPPER_SWORD = sword("copper", ModToolTiers.COPPER, 5, 1.6f);
    public static final RegistryObject<Item> COPPER_SHOVEL = shovel("copper", ModToolTiers.COPPER, 3.5f, 1f);
    public static final RegistryObject<Item> COPPER_PICKAXE = pickaxe("copper", ModToolTiers.COPPER, 3, 1.2f);
    public static final RegistryObject<Item> COPPER_AXE = axe("copper", ModToolTiers.COPPER, 9f, 0.8f);
    public static final RegistryObject<Item> COPPER_HOE = hoe("copper", ModToolTiers.COPPER, 1, 2f);
    public static final RegistryObject<Item> COPPER_HELMET = armorItem("copper", ArmorItem.Type.HELMET, ModArmorMaterials.COPPER);
    public static final RegistryObject<Item> COPPER_CHESTPLATE = armorItem("copper", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.COPPER);
    public static final RegistryObject<Item> COPPER_LEGGINGS = armorItem("copper", ArmorItem.Type.LEGGINGS, ModArmorMaterials.COPPER);
    public static final RegistryObject<Item> COPPER_BOOTS = armorItem("copper", ArmorItem.Type.BOOTS, ModArmorMaterials.COPPER);

    private static RegistryObject<Item> basicItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static RegistryObject<Item> sword(String material, Tier tier, int attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_sword", () -> new SwordItem(tier, attackDamage - 2, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistryObject<Item> shovel(String material, Tier tier, float attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_shovel", () -> new ShovelItem(tier, attackDamage - 2f, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistryObject<Item> pickaxe(String material, Tier tier, int attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_pickaxe", () -> new PickaxeItem(tier, attackDamage - 2, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistryObject<Item> axe(String material, Tier tier, float attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_axe", () -> new AxeItem(tier, attackDamage - 2f, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistryObject<Item> hoe(String material, Tier tier, int attackDamage, float attackSpeed) {
        return ITEMS.register(material + "_hoe", () -> new HoeItem(tier, attackDamage - 2, attackSpeed - 4f, new Item.Properties()));
    }

    private static RegistryObject<Item> armorItem(String material, ArmorItem.Type type, ArmorMaterial armorMaterial) {
        return ITEMS.register(material + "_" + type.getName(), () -> new ArmorItem(armorMaterial, type, new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
