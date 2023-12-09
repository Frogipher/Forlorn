package net.frogipher.forlorn.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.frogipher.forlorn.Forlorn;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType SULFUR_FLAME_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Forlorn.MOD_ID, "sulfur_flame"), SULFUR_FLAME_PARTICLE);
    }
}
