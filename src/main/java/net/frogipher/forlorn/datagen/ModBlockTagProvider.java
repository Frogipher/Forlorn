package net.frogipher.forlorn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.util.ModTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.UMBRITE_BLOCK,
                ModBlocks.RAW_UMBRITE_BLOCK,
                ModBlocks.UMBRITE_ORE,
                ModBlocks.BRASS_BLOCK,
                ModBlocks.RAW_BRASS_BLOCK,
                ModBlocks.BRASS_ORE,
                ModBlocks.VERIDIUM_BLOCK,
                ModBlocks.RAW_VERIDIUM_BLOCK,
                ModBlocks.VERIDIUM_ORE,
                ModBlocks.SHALE,
                ModBlocks.OVERGROWN_SHALE,
                ModBlocks.POLISHED_SHALE,
                ModBlocks.SHALE_BRICKS,
                ModBlocks.CRACKED_SHALE_BRICKS,
                ModBlocks.CHISELED_SHALE_BRICKS,
                ModBlocks.SHALE_BRICK_SLAB,
                ModBlocks.SHALE_BRICK_STAIRS,
                ModBlocks.POLISHED_SHALE_SLAB,
                ModBlocks.POLISHED_SHALE_STAIRS,
                ModBlocks.POLISHED_SHALE_PRESSURE_PLATE,
                ModBlocks.POLISHED_SHALE_WALL,
                ModBlocks.BUBBLE_BULB_BLOCK,
                ModBlocks.PINK_BUBBLE_LAMP,
                ModBlocks.BLUE_BUBBLE_LAMP,
                ModBlocks.PURPLE_BUBBLE_LAMP,
                ModBlocks.POTBELLY_STOVE,
                ModBlocks.ARCHITECT_TABLE
        );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(
                ModBlocks.VERDANT_LOG,
                ModBlocks.VERDANT_PLANKS,
                ModBlocks.VERDANT_WOOD,
                ModBlocks.STRIPPED_VERDANT_WOOD,
                ModBlocks.STRIPPED_VERDANT_LOG,
                ModBlocks.FLUFFWOOD_BLOCK,
                ModBlocks.FLUFFWOOD_PLANKS,
                ModBlocks.STRIPPED_FLUFFWOOD_BLOCK,
                ModBlocks.FLUFFWOOD_PRESSURE_PLATE,
                ModBlocks.FLUFFWOOD_SLAB,
                ModBlocks.FLUFFWOOD_STAIRS,
                ModBlocks.VERDANT_SLAB,
                ModBlocks.VERDANT_STAIRS,
                ModBlocks.VERDANT_PRESSURE_PLATE,
                ModBlocks.VERDANT_BUTTON,
                ModBlocks.FLUFFWOOD_BUTTON,
                ModBlocks.WORKBENCH,
                ModBlocks.SPINNING_WHEEL
        );


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.UMBRITE_BLOCK,
                ModBlocks.RAW_UMBRITE_BLOCK,
                ModBlocks.UMBRITE_ORE,
                ModBlocks.BRASS_BLOCK,
                ModBlocks.RAW_BRASS_BLOCK,
                ModBlocks.BRASS_ORE,
                ModBlocks.VERIDIUM_BLOCK,
                ModBlocks.RAW_VERIDIUM_BLOCK,
                ModBlocks.VERIDIUM_ORE,
                ModBlocks.SHALE,
                ModBlocks.OVERGROWN_SHALE,
                ModBlocks.POLISHED_SHALE,
                ModBlocks.SHALE_BRICKS,
                ModBlocks.CRACKED_SHALE_BRICKS,
                ModBlocks.CHISELED_SHALE_BRICKS,
                ModBlocks.SHALE_BRICK_SLAB,
                ModBlocks.SHALE_BRICK_STAIRS,
                ModBlocks.POLISHED_SHALE_SLAB,
                ModBlocks.POLISHED_SHALE_STAIRS,
                ModBlocks.BUBBLE_BULB_BLOCK,
                ModBlocks.PINK_BUBBLE_LAMP,
                ModBlocks.BLUE_BUBBLE_LAMP,
                ModBlocks.PURPLE_BUBBLE_LAMP,
                ModBlocks.SHALE_SLAB,
                ModBlocks.SHALE_STAIRS,
                ModBlocks.POTBELLY_STOVE
        );

        getOrCreateTagBuilder(BlockTags.WALLS).add(
                ModBlocks.POLISHED_SHALE_WALL,
                ModBlocks.SHALE_BRICK_WALL,
                ModBlocks.SHALE_BRICK_WALL
        );

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(
                ModBlocks.VERDANT_LOG,
                ModBlocks.STRIPPED_VERDANT_LOG,
                ModBlocks.VERDANT_WOOD,
                ModBlocks.STRIPPED_VERDANT_WOOD,
                ModBlocks.FLUFFWOOD_BLOCK,
                ModBlocks.STRIPPED_FLUFFWOOD_BLOCK
        );

        getOrCreateTagBuilder(ModTags.Blocks.SHALE_GROWTH).add(
                ModBlocks.OVERGROWN_SHALE
        );
    }

}
