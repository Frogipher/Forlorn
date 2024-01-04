package net.frogipher.forlorn.block.custom;

import net.frogipher.forlorn.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Iterator;

public class BubbleBlock extends TransparentBlock {

    public BubbleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        selfDestruct(world, pos);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.BUBBLE_VESSEL);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        selfDestruct(world, hit.getBlockPos());
        world.playSoundAtBlockCenter(hit.getBlockPos(), SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS,10F, 1F, true);
    }

    public void selfDestruct(World world, BlockPos selfPos){
        world.setBlockState(selfPos, Blocks.AIR.getDefaultState());
        world.playSoundAtBlockCenter(selfPos, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS,10F, 1F, true);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack interactStack = player.getStackInHand(hand);
        ItemStack bubbleVessel = new ItemStack(ModItems.BUBBLE_VESSEL);
        if(interactStack.getItem() == ModItems.EMPTY_VESSEL){
            if(world.isClient){
                world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS,10F, 1F, true);
                return ActionResult.SUCCESS;
            }else{
                if(!player.isCreative()){
                    interactStack.decrement(1);
                    if(!player.getInventory().insertStack(bubbleVessel)) world.spawnEntity(new ItemEntity(world, player.getX(), player.getY(), player.getZ(), bubbleVessel));
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }else if(!player.getInventory().contains(bubbleVessel)){
                    if(!player.getInventory().insertStack(bubbleVessel)) world.spawnEntity(new ItemEntity(world, player.getX(), player.getY(), player.getZ(), bubbleVessel));
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }else{
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
                return ActionResult.CONSUME;
            }
        }
        return ActionResult.FAIL;
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0F, world.getDamageSources().fall());
        }

    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounce(entity);
        }

    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.9;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }

    }

    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (this.isWaterAround(world, pos)) {
            this.selfDestruct(world, pos);
            world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS,10F, 1F, true);
        }
    }

    public boolean isWaterAround(World world, BlockPos pos){
        Iterator var5 = BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1)).iterator();

        BlockPos blockPos;
        FluidState fluidState;
        do {
            if (!var5.hasNext()) {
                return false;
            }

            blockPos = (BlockPos)var5.next();
            fluidState = world.getFluidState(blockPos);
        } while(!fluidState.isIn(FluidTags.WATER));

        return true;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof PlayerEntity){
            if(((PlayerEntity) entity).isSneaking()){
                selfDestruct(world, pos);
                Vec3d vec3d = entity.getVelocity();
                entity.setVelocity(vec3d.x, vec3d.y+0.5, vec3d.z);
            }
        }
    }
}
