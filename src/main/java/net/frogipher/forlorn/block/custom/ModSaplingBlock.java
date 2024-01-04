package net.frogipher.forlorn.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.List;

public class ModSaplingBlock extends SaplingBlock {

    public final List<?> soilBlocks;

    public ModSaplingBlock(List<?> soilBlocksList, SaplingGenerator generator, Settings settings) {
        super(generator, settings);
        soilBlocks = soilBlocksList;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        boolean ret = false;
        for (var entry : soilBlocks) {
            if(entry instanceof Block){
                if(floor.isOf((Block)entry)){
                    ret = true;
                };
            } else if (entry instanceof TagKey) {
                if(floor.isIn((TagKey<Block>)entry)){
                    ret = true;
                };
            }
        }
        return ret;
    }
}
