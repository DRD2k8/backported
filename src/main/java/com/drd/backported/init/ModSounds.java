package com.drd.backported.init;

import com.drd.backported.Backported;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Backported.MOD_ID);

    // Tricky Trials
    public static final RegistryObject<SoundEvent> HEAVY_CORE_BREAK = registerSoundEvents("block.heavy_core.break");
    public static final RegistryObject<SoundEvent> HEAVY_CORE_STEP = registerSoundEvents("block.heavy_core.step");
    public static final RegistryObject<SoundEvent> HEAVY_CORE_FALL = registerSoundEvents("block.heavy_core.fall");
    public static final RegistryObject<SoundEvent> HEAVY_CORE_PLACE = registerSoundEvents("block.heavy_core.place");
    public static final RegistryObject<SoundEvent> HEAVY_CORE_HIT = registerSoundEvents("block.heavy_core.hit");
    public static final RegistryObject<SoundEvent> WIND_CHARGE_THROW = registerSoundEvents("entity.wind_charge.throw");
    public static final RegistryObject<SoundEvent> WIND_CHARGE_BURST = registerSoundEvents("entity.wind_charge.wind_burst");
    public static final RegistryObject<SoundEvent> MACE_SMASH_AIR = registerSoundEvents("item.mace.smash_air");
    public static final RegistryObject<SoundEvent> MACE_SMASH_GROUND = registerSoundEvents("item.mace.smash_ground");
    public static final RegistryObject<SoundEvent> MACE_SMASH_GROUND_HEAVY = registerSoundEvents("item.mace.smash_ground_heavy");

    // The Copper Age
    public static final RegistryObject<SoundEvent> ARMOR_EQUIP_COPPER = registerSoundEvents("item.armor.equip_copper");

    // Mounts of Mayhem
    public static final RegistryObject<SoundEvent> SPEAR_ATTACK = registerSoundEvents("item.spear.attack");
    public static final RegistryObject<SoundEvent> SPEAR_HIT = registerSoundEvents("item.spear.hit");
    public static final RegistryObject<SoundEvent> SPEAR_LUNGE = registerSoundEvents("item.spear.lunge");
    public static final RegistryObject<SoundEvent> SPEAR_USE = registerSoundEvents("item.spear.use");
    public static final RegistryObject<SoundEvent> SPEAR_WOOD_ATTACK = registerSoundEvents("item.spear_wood.attack");
    public static final RegistryObject<SoundEvent> SPEAR_WOOD_HIT = registerSoundEvents("item.spear_wood.hit");
    public static final RegistryObject<SoundEvent> SPEAR_WOOD_USE = registerSoundEvents("item.spear_wood.use");

    public static final ForgeSoundType HEAVY_CORE = new ForgeSoundType(1f, 1f,
            ModSounds.HEAVY_CORE_BREAK, ModSounds.HEAVY_CORE_STEP, ModSounds.HEAVY_CORE_PLACE,
            ModSounds.HEAVY_CORE_HIT, ModSounds.HEAVY_CORE_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
