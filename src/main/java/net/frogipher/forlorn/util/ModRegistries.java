package net.frogipher.forlorn.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.item.ModItems;
import net.minecraft.block.ComposterBlock;

public class ModRegistries {
    public static void registerModStuffs(){
        registerModCompostables();
        registerStrippables();
        registerFlammables();
    }

    public static void registerModCompostables(){
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MINT_LEAVES, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MINT_SEEDS, 0.25f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SUGAR_PLUM, 0.7f);
    }

    private static void registerFlammables(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANT_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANT_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_VERDANT_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_VERDANT_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FLUFFWOOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_FLUFFWOOD_BLOCK, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANT_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FLUFFWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANT_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FLUFF, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ECHO_FLOWER, 60, 100);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MINT_CROP, 60, 100);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.VERDANT_LOG, ModBlocks.STRIPPED_VERDANT_LOG);
        StrippableBlockRegistry.register(ModBlocks.VERDANT_WOOD, ModBlocks.STRIPPED_VERDANT_WOOD);
        StrippableBlockRegistry.register(ModBlocks.FLUFFWOOD_BLOCK, ModBlocks.STRIPPED_FLUFFWOOD_BLOCK);
    }
}

