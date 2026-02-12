package com.drd.backported.init;

import com.drd.backported.Backported;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Backported.MOD_ID, Registries.SOUND_EVENT);

    // Tricky Trials
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_BREAK = registerSoundEvents("block.heavy_core.break");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_STEP = registerSoundEvents("block.heavy_core.step");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_FALL = registerSoundEvents("block.heavy_core.fall");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_PLACE = registerSoundEvents("block.heavy_core.place");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_HIT = registerSoundEvents("block.heavy_core.hit");
    public static final RegistrySupplier<SoundEvent> WIND_CHARGE_THROW = registerSoundEvents("entity.wind_charge.throw");
    public static final RegistrySupplier<SoundEvent> WIND_CHARGE_BURST = registerSoundEvents("entity.wind_charge.wind_burst");
    public static final RegistrySupplier<SoundEvent> MACE_SMASH_AIR = registerSoundEvents("item.mace.smash_air");
    public static final RegistrySupplier<SoundEvent> MACE_SMASH_GROUND = registerSoundEvents("item.mace.smash_ground");
    public static final RegistrySupplier<SoundEvent> MACE_SMASH_GROUND_HEAVY = registerSoundEvents("item.mace.smash_ground_heavy");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_CREATOR = registerMusicDisc("creator");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_CREATOR_MUSIC_BOX = registerMusicDisc("creator_music_box");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PRECIPICE = registerMusicDisc("precipice");

    // Chase the Skies
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_LAVA_CHICKEN = registerMusicDisc("lava_chicken");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_TEARS = registerMusicDisc("tears");

    // The Copper Age
    public static final RegistrySupplier<SoundEvent> ARMOR_EQUIP_COPPER = registerSoundEvents("item.armor.equip_copper");

    // Mounts of Mayhem
    public static final RegistrySupplier<SoundEvent> SPEAR_ATTACK = registerSoundEvents("item.spear.attack");
    public static final RegistrySupplier<SoundEvent> SPEAR_HIT = registerSoundEvents("item.spear.hit");
    public static final RegistrySupplier<SoundEvent> SPEAR_LUNGE = registerSoundEvents("item.spear.lunge");
    public static final RegistrySupplier<SoundEvent> SPEAR_USE = registerSoundEvents("item.spear.use");
    public static final RegistrySupplier<SoundEvent> SPEAR_WOOD_ATTACK = registerSoundEvents("item.spear_wood.attack");
    public static final RegistrySupplier<SoundEvent> SPEAR_WOOD_HIT = registerSoundEvents("item.spear_wood.hit");
    public static final RegistrySupplier<SoundEvent> SPEAR_WOOD_USE = registerSoundEvents("item.spear_wood.use");

    private static RegistrySupplier<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Backported.MOD_ID, name)));
    }

    private static RegistrySupplier<SoundEvent> registerMusicDisc(String name) {
        return SOUNDS.register("music_disc." + name, () ->
                SoundEvent.createFixedRangeEvent(new ResourceLocation(Backported.MOD_ID, "music_disc." + name), 16f)
        );
    }

    public static void register() {
        SOUNDS.register();
    }
}
