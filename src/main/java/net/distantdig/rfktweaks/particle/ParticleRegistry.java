package net.distantdig.rfktweaks.particle;

import net.distantdig.rfktweaks.RfkTweaks;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, RfkTweaks.MODID);

    public static final Supplier<SimpleParticleType> GILDER_PARTICLE =
            PARTICLE_TYPES.register("sign_gilder", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> EXCLAMATION_PARTICLE =
            PARTICLE_TYPES.register("sign_exclamation", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
