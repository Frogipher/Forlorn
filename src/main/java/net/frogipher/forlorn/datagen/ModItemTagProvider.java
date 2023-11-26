package net.frogipher.forlorn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.FARTHER_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.VERDANT_LOG.asItem(), ModBlocks.VERDANT_WOOD.asItem(),
                        ModBlocks.STRIPPED_VERDANT_LOG.asItem(), ModBlocks.STRIPPED_VERDANT_WOOD.asItem(),
                        ModBlocks.FLUFFWOOD_BLOCK.asItem(), ModBlocks.STRIPPED_FLUFFWOOD_BLOCK.asItem()
                );

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.VERDANT_PLANKS.asItem(),
                        ModBlocks.FLUFFWOOD_PLANKS.asItem()
                );
    }
}
