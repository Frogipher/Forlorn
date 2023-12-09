package net.frogipher.forlorn.block.custom;

import net.frogipher.forlorn.block.ModBlocks;
import net.frogipher.forlorn.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Iterator;

public class ShaleBlock extends Block implements Fertilizable {

    public ShaleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if (!world.getBlockState(pos.up()).isTransparent(world, pos)) {
            return false;
        } else {
            Iterator var5 = BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1)).iterator();

            BlockPos blockPos;
            do {
                if (!var5.hasNext()) {
                    return false;
                }

                blockPos = (BlockPos)var5.next();
            } while(!world.getBlockState(blockPos).isIn(ModTags.Blocks.SHALE_GROWTH));

            return true;
        }
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        boolean hasOvergrownShaleAround = false;

        for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState blockState = world.getBlockState(blockPos);

            if (blockState.isOf(ModBlocks.OVERGROWN_SHALE)) hasOvergrownShaleAround = true;

            if (hasOvergrownShaleAround) break;
        }

        if (hasOvergrownShaleAround) {
            world.setBlockState(pos, ModBlocks.OVERGROWN_SHALE.getDefaultState(), 3);
        }
    }
}
