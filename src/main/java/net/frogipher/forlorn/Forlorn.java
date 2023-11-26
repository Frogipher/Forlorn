package net.frogipher.forlorn;

import net.fabricmc.api.ModInitializer;

import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.item.ModItemGroup;
import net.frogipher.forlorn.item.ModItems;
import net.frogipher.forlorn.sound.ModSounds;
import net.frogipher.forlorn.util.ModRegistries;
import net.frogipher.forlorn.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Forlorn implements ModInitializer {
	public static final String MOD_ID = "forlorn";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModRegistries.registerModStuffs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();

		ModItemGroup.registerItemGroups();
		ModWorldGeneration.generateModWorldGeneration();

	}
}