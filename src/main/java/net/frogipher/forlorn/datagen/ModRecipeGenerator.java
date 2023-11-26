package net.frogipher.forlorn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.UMBRITE_INGOT, RecipeCategory.MISC, ModBlocks.UMBRITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_UMBRITE, RecipeCategory.MISC, ModBlocks.RAW_UMBRITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_BRASS, RecipeCategory.MISC, ModBlocks.RAW_BRASS_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BRASS_INGOT, RecipeCategory.MISC, ModBlocks.BRASS_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_VERIDIUM, RecipeCategory.MISC, ModBlocks.RAW_VERIDIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.VERIDIUM_INGOT, RecipeCategory.MISC, ModBlocks.VERIDIUM_BLOCK);

    }
}
