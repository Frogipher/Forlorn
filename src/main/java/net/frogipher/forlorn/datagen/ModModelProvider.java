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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SHALE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_SHALE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_BUBBLE_LAMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_BUBBLE_LAMP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_BUBBLE_LAMP);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.WORKBENCH, ModBlocks.POLISHED_SHALE, TextureMap::frontSideWithCustomBottom); //TODO once a more fabric oriented dev comes here, they can fix this. frontSideWithCustomBottom needs a front and a side texture but all sides should have the same, currently we have a duplicate with a different name.
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUBBLE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool shale_bricksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHALE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool polished_shaleTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_SHALE);
        BlockStateModelGenerator.BlockTexturePool shaleTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHALE);
        BlockStateModelGenerator.BlockTexturePool verdantTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VERDANT_PLANKS);
        BlockStateModelGenerator.BlockTexturePool fluffwoodTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLUFFWOOD_PLANKS);

        shale_bricksTexturePool.stairs(ModBlocks.SHALE_BRICK_STAIRS);
        polished_shaleTexturePool.stairs(ModBlocks.POLISHED_SHALE_STAIRS);
        shaleTexturePool.stairs(ModBlocks.SHALE_STAIRS);
        fluffwoodTexturePool.stairs(ModBlocks.FLUFFWOOD_STAIRS);
        verdantTexturePool.stairs(ModBlocks.VERDANT_STAIRS);

        shale_bricksTexturePool.slab(ModBlocks.SHALE_BRICK_SLAB);
        polished_shaleTexturePool.slab(ModBlocks.POLISHED_SHALE_SLAB);
        shaleTexturePool.slab(ModBlocks.SHALE_SLAB);
        verdantTexturePool.slab(ModBlocks.VERDANT_SLAB);
        fluffwoodTexturePool.slab(ModBlocks.FLUFFWOOD_SLAB);

        polished_shaleTexturePool.button(ModBlocks.POLISHED_SHALE_BUTTON);
        verdantTexturePool.button(ModBlocks.VERDANT_BUTTON);
        fluffwoodTexturePool.button(ModBlocks.FLUFFWOOD_BUTTON);

        polished_shaleTexturePool.pressurePlate(ModBlocks.POLISHED_SHALE_PRESSURE_PLATE);
        verdantTexturePool.pressurePlate(ModBlocks.VERDANT_PRESSURE_PLATE);
        fluffwoodTexturePool.pressurePlate(ModBlocks.FLUFFWOOD_PRESSURE_PLATE);

        polished_shaleTexturePool.wall(ModBlocks.POLISHED_SHALE_WALL);
        shale_bricksTexturePool.wall(ModBlocks.SHALE_BRICK_WALL);
        shaleTexturePool.wall(ModBlocks.SHALE_WALL);

        registerCustomLamp(blockStateModelGenerator);

        blockStateModelGenerator.registerCrop(ModBlocks.MINT_CROP, MintCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ECHO_FLOWER, ModBlocks.POTTED_ECHO_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBlocks.VERDANT_LOG).log(ModBlocks.VERDANT_LOG).wood(ModBlocks.VERDANT_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_VERDANT_LOG).log(ModBlocks.STRIPPED_VERDANT_LOG).wood(ModBlocks.STRIPPED_VERDANT_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDANT_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.VERDANT_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBlocks.FLUFFWOOD_BLOCK).log(ModBlocks.FLUFFWOOD_BLOCK).wood(ModBlocks.STRIPPED_FLUFFWOOD_BLOCK);
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
        itemModelGenerator.register(ModItems.BUBBLE_VESSEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.SHALE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHALE_SHOVEL, Models.HANDHELD);

        itemModelGenerator.register(ModBlocks.FLUFFWOOD_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.VERDANT_SAPLING.asItem(), Models.GENERATED);

    }

    }
