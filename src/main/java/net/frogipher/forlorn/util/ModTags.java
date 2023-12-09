package net.frogipher.forlorn.util;

import net.frogipher.forlorn.Forlorn;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {

        private static TagKey<Block> createBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Forlorn.MOD_ID, name));
        }
        private static TagKey<Block> createCommonBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }

        public static final TagKey<Block> SHALE_GROWTH = createBlockTag("shale_growth");
    }

    public static class Items {

        private static TagKey<Item> createItemTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Forlorn.MOD_ID, name));
        }
        private static TagKey<Item> createCommonItemTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }

        public static final TagKey<Item> FORLORN_PLANKS = createItemTag("forlorn_planks");
    }
}
