package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.item.MaceItem;
import com.drd.backported.item.WindChargeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Backported.MOD_ID);

    public static final RegistryObject<Item> BREEZE_ROD = basicItem("breeze_rod");
    public static final RegistryObject<Item> MACE = ITEMS.register("mace", () -> new MaceItem(new Item.Properties().rarity(Rarity.EPIC).durability(500)));
    public static final RegistryObject<Item> WIND_CHARGE = ITEMS.register("wind_charge", () -> new WindChargeItem(new Item.Properties()));

    private static RegistryObject<Item> basicItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
