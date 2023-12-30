package net.frogipher.forlorn.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.frogipher.forlorn.Forlorn;
import net.frogipher.forlorn.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup FORLORN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Forlorn.MOD_ID, "forlorn"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.forlorn"))
                    .icon(() -> new ItemStack(ModItems.SUGAR_PLUM)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.UMBRITE_BLOCK);
                        entries.add(ModBlocks.RAW_UMBRITE_BLOCK);
                        entries.add(ModBlocks.UMBRITE_ORE);
                        entries.add(ModItems.RAW_UMBRITE);
                        entries.add(ModItems.UMBRITE_INGOT);
                        entries.add(ModBlocks.BRASS_BLOCK);
                        entries.add(ModBlocks.RAW_BRASS_BLOCK);
                        entries.add(ModBlocks.BRASS_ORE);
                        entries.add(ModItems.RAW_BRASS);
                        entries.add(ModItems.BRASS_INGOT);
                        entries.add(ModBlocks.VERIDIUM_BLOCK);
                        entries.add(ModBlocks.RAW_VERIDIUM_BLOCK);
                        entries.add(ModBlocks.VERIDIUM_ORE);
                        entries.add(ModItems.RAW_VERIDIUM);
                        entries.add(ModItems.VERIDIUM_INGOT);

                        entries.add(ModBlocks.SHALE);
                        entries.add(ModBlocks.OVERGROWN_SHALE);
                        entries.add(ModBlocks.SHALE_STAIRS);
                        entries.add(ModBlocks.SHALE_SLAB);
                        entries.add(ModBlocks.SHALE_WALL);
                        entries.add(ModBlocks.POLISHED_SHALE);
                        entries.add(ModBlocks.POLISHED_SHALE_STAIRS);
                        entries.add(ModBlocks.POLISHED_SHALE_SLAB);
                        entries.add(ModBlocks.SHALE_BRICKS);
                        entries.add(ModBlocks.SHALE_BRICK_STAIRS);
                        entries.add(ModBlocks.SHALE_BRICK_SLAB);
                        entries.add(ModBlocks.CRACKED_SHALE_BRICKS);
                        entries.add(ModBlocks.CHISELED_SHALE_BRICKS);
                        entries.add(ModBlocks.SHALE_BRICK_WALL);
                        entries.add(ModBlocks.POLISHED_SHALE_WALL);
                        entries.add(ModBlocks.POLISHED_SHALE_BUTTON);
                        entries.add(ModBlocks.POLISHED_SHALE_PRESSURE_PLATE);
                        entries.add(ModItems.SHALE_PEBBLE);

                        entries.add(ModBlocks.BUBBLE_BULB_BLOCK);
                        entries.add(ModBlocks.PINK_BUBBLE_LAMP);
                        entries.add(ModBlocks.BLUE_BUBBLE_LAMP);
                        entries.add(ModBlocks.PURPLE_BUBBLE_LAMP);

                        entries.add(ModBlocks.VERDANT_LOG);
                        entries.add(ModBlocks.VERDANT_WOOD);
                        entries.add(ModBlocks.STRIPPED_VERDANT_LOG);
                        entries.add(ModBlocks.STRIPPED_VERDANT_WOOD);
                        entries.add(ModBlocks.VERDANT_PLANKS);
                        entries.add(ModBlocks.VERDANT_STAIRS);
                        entries.add(ModBlocks.VERDANT_SLAB);
                        entries.add(ModBlocks.VERDANT_PRESSURE_PLATE);
                        entries.add(ModBlocks.VERDANT_BUTTON);
                        entries.add(ModBlocks.VERDANT_LEAVES);
                        entries.add(ModBlocks.VERDANT_SAPLING);

                        entries.add(ModBlocks.FLUFFWOOD_BLOCK);
                        entries.add(ModBlocks.STRIPPED_FLUFFWOOD_BLOCK);
                        entries.add(ModBlocks.FLUFFWOOD_PLANKS);
                        entries.add(ModBlocks.FLUFFWOOD_STAIRS);
                        entries.add(ModBlocks.FLUFFWOOD_SLAB);
                        entries.add(ModBlocks.FLUFFWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.FLUFFWOOD_BUTTON);
                        entries.add(ModBlocks.FLUFF);
                        entries.add(ModBlocks.FLUFFWOOD_SAPLING);
                        entries.add(ModItems.FLUFF_TUFT);
                        entries.add(ModItems.FLUFF_THREAD);

                        entries.add(ModItems.SHALE_SWORD);
                        entries.add(ModItems.SHALE_AXE);
                        entries.add(ModItems.SHALE_HOE);
                        entries.add(ModItems.SHALE_PICKAXE);
                        entries.add(ModItems.SHALE_SHOVEL);

                        entries.add(ModItems.EMPTY_VESSEL);
                        entries.add(ModItems.BUBBLE_VESSEL);

                        entries.add(ModBlocks.ECHO_FLOWER);
                        entries.add(ModItems.SUGAR_PLUM);
                        entries.add(ModItems.SUGAR_LUMPS);
                        entries.add(ModItems.MINT_SEEDS);
                        entries.add(ModItems.MINT_LEAVES);
                        entries.add(ModItems.BUBBLE_MINT);
                        entries.add(ModItems.RAW_GLOW_GUPPY);
                        entries.add(ModItems.PLUMAGE);

                        entries.add(ModItems.STONE_HEART);
                        entries.add(ModItems.SUNSTONE);
                        entries.add(ModItems.MOONSTONE);
                        entries.add(ModItems.SULFUR_CRYSTALS);
                        entries.add(ModItems.MINERAL_CRYSTALS);
                        entries.add(ModItems.BUBBLE_JELLY);
                        entries.add(ModItems.PANICLE);
                        entries.add(ModItems.PANICLE_FLORETS);
                        entries.add(ModItems.PARCHMENT);
                        entries.add(ModItems.TWIG_DISH);
                        entries.add(ModItems.TWIG);

                        entries.add(ModItems.FARTHER_MUSIC_DISC);

                        entries.add(ModBlocks.WORKBENCH);
                        entries.add(ModBlocks.POTBELLY_STOVE);
                        entries.add(ModBlocks.SPINNING_WHEEL);
                        entries.add(ModBlocks.ARCHITECT_TABLE);

                    }).build());

    public static void registerItemGroups() {

    }
}
