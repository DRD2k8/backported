package com.drd.backported.init;

import com.drd.backported.Backported;
import com.drd.backported.particle.base.ModSimpleParticleType;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Backported.MOD_ID, Registries.PARTICLE_TYPE);

    // Bats and Pots
    public static final RegistrySupplier<SimpleParticleType> DUST_PLUME = PARTICLES.register("dust_plume", () -> new ModSimpleParticleType(false));

    // Spring to Life
    public static final RegistrySupplier<SimpleParticleType> FIREFLY = PARTICLES.register("firefly", () -> new ModSimpleParticleType(false));

    public static void register() {
        PARTICLES.register();
    }
}
