package net.frogipher.forlorn.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.frogipher.forlorn.Forlorn;
import net.frogipher.forlorn.block.custom.PotbellyStoveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static BlockEntityType<PotbellyStoveBlockEntity> POTBELLY_STOVE = register("fabric_furnace", FabricBlockEntityTypeBuilder.create(PotbellyStoveBlockEntity::new, ModBlocks.POTBELLY_STOVE).build(null));

    public static void register() {}

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,  new Identifier(Forlorn.MOD_ID, name), type);
    }
}
