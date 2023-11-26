package net.frogipher.forlorn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.block.custom.BubbleBulbBlock;
import net.frogipher.forlorn.block.custom.MintCropBlock;
import net.frogipher.forlorn.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UMBRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_UMBRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UMBRITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRASS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BRASS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRASS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERIDIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_VERIDIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERIDIUM_ORE);
        BlockStateModelGenerator.BlockTexturePool shale_bricksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHALE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_shaleTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_SHALE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHALE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SHALE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SHALE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_BUBBLE_LAMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_BUBBLE_LAMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_BUBBLE_LAMP);

        shale_bricksTexturePool.stairs(ModBlocks.SHALE_BRICK_STAIRS);
        shale_bricksTexturePool.slab(ModBlocks.SHALE_BRICK_SLAB);
        polished_shaleTexturePool.stairs(ModBlocks.POLISHED_SHALE_STAIRS);
        polished_shaleTexturePool.slab(ModBlocks.POLISHED_SHALE_SLAB);
        polished_shaleTexturePool.button(ModBlocks.POLISHED_SHALE_BUTTON);
        polished_shaleTexturePool.pressurePlate(ModBlocks.POLISHED_SHALE_PRESSURE_PLATE);
        polished_shaleTexturePool.wall(ModBlocks.POLISHED_SHALE_WALL);

        registerCustomLamp(blockStateModelGenerator);

        blockStateModelGenerator.registerCrop(ModBlocks.MINT_CROP, MintCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ECHO_FLOWER, ModBlocks.POTTED_ECHO_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBlocks.VERDANT_LOG).log(ModBlocks.VERDANT_LOG).wood(ModBlocks.VERDANT_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_VERDANT_LOG).log(ModBlocks.STRIPPED_VERDANT_LOG).wood(ModBlocks.STRIPPED_VERDANT_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDANT_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDANT_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.VERDANT_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBlocks.FLUFFWOOD_BLOCK).log(ModBlocks.FLUFFWOOD_BLOCK).wood(ModBlocks.STRIPPED_FLUFFWOOD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUFFWOOD_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUFF);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.FLUFFWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.BUBBLE_BULB_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.BUBBLE_BULB_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BUBBLE_BULB_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(BubbleBulbBlock.CLICKED, identifier2, identifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.UMBRITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_UMBRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BRASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRASS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VERIDIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERIDIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUGAR_PLUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUGAR_LUMPS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUBBLE_MINT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUBBLE_JELLY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHALE_PEBBLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOONSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINT_LEAVES, Models.GENERATED);
        itemModelGenerator.register(ModItems.FARTHER_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLUFF_THREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLUFF_TUFT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANICLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANICLE_FLORETS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PARCHMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GLOW_GUPPY, Models.GENERATED);
        itemModelGenerator.register(ModItems.TWIG, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VESSEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.SHALE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_SHOVEL, Models.HANDHELD);

    }

    }
