package net.frogipher.forlorn.sound;

import net.frogipher.forlorn.Forlorn;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent FARTHER = registerSoundEvent("farther");

    private static SoundEvent registerSoundEvent(String name){
        Identifier identifier = new Identifier(Forlorn.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds(){
        Forlorn.LOGGER.info("Registering Mod Sounds for " + Forlorn.MOD_ID);
    }

}
