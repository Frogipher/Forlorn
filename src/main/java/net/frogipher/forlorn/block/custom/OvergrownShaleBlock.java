package net.frogipher.forlorn.block.custom;

import net.frogipher.forlorn.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;

public class OvergrownShaleBlock extends Block implements Fertilizable {

    public OvergrownShaleBlock(Settings settings) {
        super(settings);
    }

    private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos posAbove = pos.up();
        BlockState stateAbove = world.getBlockState(posAbove);
        int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, stateAbove, posAbove, Direction.UP, stateAbove.getOpacity(world, posAbove));
        return i < world.getMaxLightLevel();
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!stayAlive(state, world, pos)) {
            world.setBlockState(pos, ModBlocks.SHALE.getDefaultState());
        }

    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        //return world.getBlockState(pos.up()).isAir();
        return false;
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        //Probably, you'll need this function once
    }
}
