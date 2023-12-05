package net.frogipher.forlorn.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frogipher.forlorn.Forlorn;
import net.frogipher.forlorn.block.custom.BubbleBulbBlock;
import net.frogipher.forlorn.block.custom.MintCropBlock;
import net.frogipher.forlorn.world.tree.FluffwoodSaplingGenerator;
import net.frogipher.forlorn.world.tree.VerdantSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //Ores
    public static final Block UMBRITE_BLOCK = registerBlock("umbrite_block", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).mapColor(MapColor.CYAN)));
    public static final Block RAW_UMBRITE_BLOCK = registerBlock("raw_umbrite_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK).mapColor(MapColor.CYAN)));
    public static final Block UMBRITE_ORE = registerBlock("umbrite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY), UniformIntProvider.create(2, 4)));

    public static final Block BRASS_BLOCK = registerBlock("brass_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block RAW_BRASS_BLOCK = registerBlock("raw_brass_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block BRASS_ORE = registerBlock("brass_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY), UniformIntProvider.create(4, 7)));

    public static final Block VERIDIUM_BLOCK = registerBlock("veridium_block", new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block RAW_VERIDIUM_BLOCK = registerBlock("raw_veridium_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block VERIDIUM_ORE = registerBlock("veridium_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY), UniformIntProvider.create(7, 11)));

    //Verdant Wood
    public static final Block VERDANT_LOG = registerBlock("verdant_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block VERDANT_WOOD = registerBlock("verdant_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block STRIPPED_VERDANT_LOG = registerBlock("stripped_verdant_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block STRIPPED_VERDANT_WOOD = registerBlock("stripped_verdant_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block VERDANT_PLANKS = registerBlock("verdant_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f).mapColor(MapColor.PALE_PURPLE)));
    public static final Block VERDANT_LEAVES = registerBlock("verdant_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(1f).mapColor(MapColor.GREEN)));
    public static final Block VERDANT_SAPLING = registerBlock("verdant_sapling", new SaplingBlock(new VerdantSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

    //Fluffwood
    public static final Block FLUFFWOOD_BLOCK = registerBlock("fluffwood_block", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO_BLOCK).strength(4f).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final Block STRIPPED_FLUFFWOOD_BLOCK = registerBlock("stripped_fluffwood_block", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block FLUFFWOOD_PLANKS = registerBlock("fluffwood_planks", new Block(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS).strength(4f).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block FLUFF = registerBlock("fluff", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(2f).mapColor(MapColor.OFF_WHITE)));
    public static final Block FLUFFWOOD_SAPLING = registerBlock("fluffwood_sapling", new SaplingBlock(new FluffwoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

    //Light Blocks
    public static final Block PINK_BUBBLE_LAMP = registerBlock("pink_bubble_lamp", new Block(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN).mapColor(MapColor.PINK).luminance(15)));
    public static final Block BLUE_BUBBLE_LAMP = registerBlock("blue_bubble_lamp", new Block(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN).mapColor(MapColor.LIGHT_BLUE).luminance(15)));
    public static final Block PURPLE_BUBBLE_LAMP = registerBlock("purple_bubble_lamp", new Block(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN).mapColor(MapColor.PALE_PURPLE).luminance(15)));
    public static final Block BUBBLE_BULB_BLOCK = registerBlock("bubble_bulb_block", new BubbleBulbBlock(FabricBlockSettings.create().mapColor(MapColor.RAW_IRON_PINK).instrument(Instrument.XYLOPHONE).strength(4f).requiresTool().luminance(state -> state.get(BubbleBulbBlock.CLICKED) ? 15:0)));

    //Shale
    public static final Block SHALE = registerBlock("shale", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_BRICKS = registerBlock("shale_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block CRACKED_SHALE_BRICKS = registerBlock("cracked_shale_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block CHISELED_SHALE_BRICKS = registerBlock("chiseled_shale_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block POLISHED_SHALE = registerBlock("polished_shale", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));

    //Stairs
    public static final Block POLISHED_SHALE_STAIRS = registerBlock("polished_shale_stairs", new StairsBlock(ModBlocks.POLISHED_SHALE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_BRICK_STAIRS = registerBlock("shale_brick_stairs", new StairsBlock(ModBlocks.SHALE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_STAIRS = registerBlock("shale_stairs", new StairsBlock(ModBlocks.SHALE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block VERDANT_STAIRS = registerBlock("verdant_stairs", new StairsBlock(ModBlocks.VERDANT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PALE_PURPLE)));
    public static final Block FLUFFWOOD_STAIRS = registerBlock("fluffwood_stairs", new StairsBlock(ModBlocks.FLUFFWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_WHITE)));

    //Slabs
    public static final Block SHALE_BRICK_SLAB = registerBlock("shale_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block POLISHED_SHALE_SLAB = registerBlock("polished_shale_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_SLAB = registerBlock("shale_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block VERDANT_SLAB = registerBlock("verdant_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PALE_PURPLE)));
    public static final Block FLUFFWOOD_SLAB = registerBlock("fluffwood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_WHITE)));

    //Buttons
    public static final Block POLISHED_SHALE_BUTTON = registerBlock("polished_shale_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.STONE, 20, true));
    public static final Block VERDANT_BUTTON = registerBlock("verdant_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 20, true));
    public static final Block FLUFFWOOD_BUTTON = registerBlock("fluffwood_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 20, true));

    //Walls
    public static final Block POLISHED_SHALE_WALL = registerBlock("polished_shale_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_WALL).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_BRICK_WALL = registerBlock("shale_brick_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_WALL).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_WALL = registerBlock("shale_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_WALL).mapColor(MapColor.DEEPSLATE_GRAY)));

    //Pressure Plates
    public static final Block POLISHED_SHALE_PRESSURE_PLATE = registerBlock("polished_shale_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE), BlockSetType.STONE));
    public static final Block VERDANT_PRESSURE_PLATE = registerBlock("verdant_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block FLUFFWOOD_PRESSURE_PLATE = registerBlock("fluffwood_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    //Crops
    public static final Block MINT_CROP = registerBlockWithoutBlockItem("mint_crop", new MintCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    //Flowers
    public static final Block ECHO_FLOWER = registerBlock("echo_flower", new FlowerBlock(StatusEffects.DARKNESS, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(5)));
    public static final Block POTTED_ECHO_FLOWER = registerBlockWithoutBlockItem("potted_echo_flower", new FlowerPotBlock(ECHO_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(5)));


    //Registries
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Forlorn.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Forlorn.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Forlorn.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Forlorn.LOGGER.info("Registering ModBlocks for " + Forlorn.MOD_ID);
    }
}
