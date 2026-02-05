package com.drd.backported.init;

import com.drd.backported.Backported;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Backported.MOD_ID);

    public static final RegistryObject<SoundEvent> MACE_SMASH_AIR = registerSoundEvents("item.mace.smash_air");
    public static final RegistryObject<SoundEvent> MACE_SMASH_GROUND = registerSoundEvents("item.mace.smash_ground");
    public static final RegistryObject<SoundEvent> MACE_SMASH_GROUND_HEAVY = registerSoundEvents("item.mace.smash_ground_heavy");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
