package net.frogipher.forlorn.item;

import net.frogipher.forlorn.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class BubbleVesselItem extends Item {

    public BubbleVesselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos placePos = context.getBlockPos().offset(context.getSide());
        BlockState placeState = context.getWorld().getBlockState(placePos);
        if(placeState.isReplaceable() || placeState.isAir()){
            context.getWorld().setBlockState(placePos, ModBlocks.BUBBLE_BLOCK.getDefaultState());
            if(!context.getPlayer().isCreative()) {
                context.getStack().decrement(1);
                context.getPlayer().getInventory().insertStack(new ItemStack(ModItems.EMPTY_VESSEL, 1));
            }
            context.getWorld().playSoundAtBlockCenter(placePos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS,1F, 1F, true);
            return ActionResult.SUCCESS;
        }else{
            return ActionResult.FAIL;
        }
    }
}
