package net.frogipher.forlorn.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.frogipher.forlorn.Forlorn;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_UMBRITE = registerItem("raw_umbrite", new Item(new FabricItemSettings()));
    public static final Item UMBRITE_INGOT = registerItem("umbrite_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_BRASS = registerItem("raw_brass", new Item(new FabricItemSettings()));
    public static final Item BRASS_INGOT = registerItem("brass_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_VERIDIUM = registerItem("raw_veridium", new Item(new FabricItemSettings()));
    public static final Item VERIDIUM_INGOT = registerItem("veridium_ingot", new Item(new FabricItemSettings()));
    public static final Item MINT_LEAVES = registerItem("mint_leaves", new Item(new FabricItemSettings()));
    public static final Item STONE_HEART = registerItem("stone_heart", new Item(new FabricItemSettings()));
    public static final Item SUNSTONE = registerItem("sunstone", new Item(new FabricItemSettings()));
    public static final Item MOONSTONE = registerItem("moonstone", new Item(new FabricItemSettings()));
    public static final Item SHALE_PEBBLE = registerItem("shale_pebble", new Item(new FabricItemSettings()));
    public static final Item BUBBLE_JELLY = registerItem("bubble_jelly", new Item(new FabricItemSettings()));
    public static final Item TWIG = registerItem("twig", new Item(new FabricItemSettings()));
    public static final Item PANICLE = registerItem("panicle", new Item(new FabricItemSettings()));
    public static final Item PANICLE_FLORETS = registerItem("panicle_florets", new Item(new FabricItemSettings()));
    public static final Item PARCHMENT = registerItem("parchment", new Item(new FabricItemSettings()));
    public static final Item FLUFF_TUFT = registerItem("fluff_tuft", new Item(new FabricItemSettings()));
    public static final Item FLUFF_THREAD = registerItem("fluff_thread", new Item(new FabricItemSettings()));
    public static final Item EMPTY_VESSEL = registerItem("empty_vessel", new Item(new FabricItemSettings()));
    public static final Item SHALE_SWORD = registerItem("shale_sword", new SwordItem(ModToolMaterial.SHALE, 2, -2f, new FabricItemSettings()));
    public static final Item SHALE_PICKAXE = registerItem("shale_pickaxe", new PickaxeItem(ModToolMaterial.SHALE, 1, 1f, new FabricItemSettings()));
    public static final Item SHALE_SHOVEL = registerItem("shale_shovel", new ShovelItem(ModToolMaterial.SHALE, 0, 0f, new FabricItemSettings()));
    public static final Item SHALE_AXE = registerItem("shale_axe", new AxeItem(ModToolMaterial.SHALE, 4, -2f, new FabricItemSettings()));
    public static final Item SHALE_HOE = registerItem("shale_hoe", new HoeItem(ModToolMaterial.SHALE, 0, 0f, new FabricItemSettings()));
    public static final Item SUGAR_PLUM = registerItem("sugar_plum", new Item(new FabricItemSettings().food(ModFoodComponents.SUGAR_PLUM)));
    public static final Item SUGAR_LUMPS = registerItem("sugar_lumps", new Item(new FabricItemSettings().food(ModFoodComponents.SUGAR_LUMPS)));
    public static final Item BUBBLE_MINT = registerItem("bubble_mint", new Item(new FabricItemSettings().food(ModFoodComponents.BUBBLE_MINT)));
    public static final Item RAW_GLOW_GUPPY = registerItem("raw_glow_guppy", new Item(new FabricItemSettings().food(ModFoodComponents.RAW_GLOW_GUPPY)));
    public static final Item MINT_SEEDS = registerItem("mint_seeds", new AliasedBlockItem(ModBlocks.MINT_CROP, new FabricItemSettings()));
    public static final Item FARTHER_MUSIC_DISC = registerItem("farther_music_disc", new MusicDiscItem(9, ModSounds.FARTHER, new FabricItemSettings().maxCount(1), 145));
    public static final Item BUBBLE_VESSEL = registerItem("bubble_vessel", new BubbleVesselItem(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Forlorn.MOD_ID, name),item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    }

    public static void registerModItems(){
        Forlorn.LOGGER.info("Registering Mod Items for " + Forlorn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
