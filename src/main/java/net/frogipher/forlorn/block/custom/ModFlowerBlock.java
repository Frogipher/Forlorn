package net.frogipher.forlorn.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.List;

public class ModFlowerBlock extends FlowerBlock {

    public final List<?> soilBlocks;

    public ModFlowerBlock(List<?> soilBlocksList, StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
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
