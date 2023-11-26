package net.frogipher.forlorn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.block.custom.MintCropBlock;
import net.frogipher.forlorn.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.UMBRITE_BLOCK);
        addDrop(ModBlocks.RAW_UMBRITE_BLOCK);
        addDrop(ModBlocks.BRASS_BLOCK);
        addDrop(ModBlocks.RAW_BRASS_BLOCK);
        addDrop(ModBlocks.VERIDIUM_BLOCK);
        addDrop(ModBlocks.RAW_VERIDIUM_BLOCK);
        addDrop(ModBlocks.SHALE);
        addDrop(ModBlocks.SHALE_BRICKS);
        addDrop(ModBlocks.CHISELED_SHALE_BRICKS);
        addDrop(ModBlocks.CRACKED_SHALE_BRICKS);
        addDrop(ModBlocks.POLISHED_SHALE);
        addDrop(ModBlocks.POLISHED_SHALE_STAIRS);
        addDrop(ModBlocks.SHALE_BRICK_STAIRS);
        addDrop(ModBlocks.POLISHED_SHALE_BUTTON);
        addDrop(ModBlocks.POLISHED_SHALE_PRESSURE_PLATE);
        addDrop(ModBlocks.POLISHED_SHALE_WALL);
        addDrop(ModBlocks.BUBBLE_BULB_BLOCK);
        addDrop(ModBlocks.PINK_BUBBLE_LAMP);
        addDrop(ModBlocks.BLUE_BUBBLE_LAMP);
        addDrop(ModBlocks.PURPLE_BUBBLE_LAMP);
        addDrop(ModBlocks.FLUFFWOOD_BLOCK);
        addDrop(ModBlocks.STRIPPED_FLUFFWOOD_BLOCK);
        addDrop(ModBlocks.FLUFFWOOD_PLANKS);
        addDrop(ModBlocks.FLUFF);
        addDrop(ModBlocks.FLUFFWOOD_SAPLING);
        addDrop(ModBlocks.VERDANT_LOG);
        addDrop(ModBlocks.VERDANT_LEAVES);
        addDrop(ModBlocks.VERDANT_PLANKS);
        addDrop(ModBlocks.VERDANT_WOOD);
        addDrop(ModBlocks.VERDANT_SAPLING);
        addDrop(ModBlocks.STRIPPED_VERDANT_WOOD);
        addDrop(ModBlocks.STRIPPED_VERDANT_LOG);
        addDrop(ModBlocks.VERDANT_SAPLING);
        addDrop(ModBlocks.FLUFFWOOD_SAPLING);
        addDrop(ModBlocks.ECHO_FLOWER);
        addDrop(ModBlocks.POTTED_ECHO_FLOWER);

        addDrop(ModBlocks.SHALE_BRICK_SLAB, slabDrops(ModBlocks.SHALE_BRICK_SLAB));
        addDrop(ModBlocks.POLISHED_SHALE_SLAB, slabDrops(ModBlocks.POLISHED_SHALE_SLAB));

        addDrop(ModBlocks.UMBRITE_ORE, oreDrops(ModBlocks.UMBRITE_ORE, ModItems.RAW_UMBRITE));
        addDrop(ModBlocks.BRASS_ORE, oreDrops(ModBlocks.BRASS_ORE, ModItems.RAW_BRASS));
        addDrop(ModBlocks.VERIDIUM_ORE, oreDrops(ModBlocks.VERIDIUM_ORE, ModItems.RAW_VERIDIUM));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.MINT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(MintCropBlock.AGE, 3));
        this.addDrop(ModBlocks.MINT_CROP, this.cropDrops(Blocks.WHEAT, ModItems.MINT_LEAVES, ModItems.MINT_SEEDS, builder2));
    }
}
