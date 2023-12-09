package net.frogipher.forlorn.block.custom;

import net.frogipher.forlorn.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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
        return super.getPickStack(world, pos, state);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        selfDestruct(world, hit.getBlockPos());
    }

    public void selfDestruct(World world, BlockPos selfPos){
        world.setBlockState(selfPos, Blocks.AIR.getDefaultState());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack interactStack = player.getStackInHand(hand);
        ItemStack bubbleVessel = new ItemStack(ModItems.BUBBLE_VESSEL);
        if(interactStack.getItem() == ModItems.EMPTY_VESSEL){
            if(world.isClient){
                world.playSoundAtBlockCenter(pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS,1F, 1F, true);
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
}
