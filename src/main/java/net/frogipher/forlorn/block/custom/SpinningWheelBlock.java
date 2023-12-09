package net.frogipher.forlorn.block.custom;

import net.frogipher.forlorn.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SpinningWheelBlock extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final IntProperty STAGE = IntProperty.of("stage", 0, 3);

    private static final VoxelShape NS_BOX = Block.createCuboidShape(5.5, 0.0, 1.0, 10.5, 16.0, 15.0);
    private static final VoxelShape EW_BOX = Block.createCuboidShape(1.0, 0.0, 5.5, 15.0, 16.0, 10.5);

    public SpinningWheelBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(STAGE, 0));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack interactStack = player.getStackInHand(hand);
        int stage = state.get(STAGE);

        //if player is sneaking then return all applied tuft instead of applying more or crafting thread
        if(player.isSneaking() && stage > 0){
          if(world.isClient) {
              world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.BLOCKS,1F, 1F, true);
              return ActionResult.SUCCESS;
          } else {
              world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.FLUFF_TUFT, stage)));
              world.setBlockState(pos, state.with(STAGE, 0));
              return ActionResult.CONSUME;
          }
        }

        if(stage == 3){
            if(world.isClient) {
                world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.BLOCKS,1F, 1F, true);
                return ActionResult.SUCCESS;
            } else {
                world.setBlockState(pos, state.with(STAGE, 0));
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.FLUFF_THREAD)));
                return ActionResult.CONSUME;
            }
        }else if (interactStack.getItem() == ModItems.FLUFF_TUFT) {
            if(world.isClient) {
                world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS,1F, 1F, true);
                return ActionResult.SUCCESS;
            } else {
                if(!player.isCreative()) interactStack.decrement(1);
                world.setBlockState(pos, state.with(STAGE, stage + 1));
                return ActionResult.CONSUME;
            }
        }

        return ActionResult.FAIL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, STAGE});
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH, SOUTH -> NS_BOX;
            case EAST, WEST -> EW_BOX;
            default -> NS_BOX;
        };
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if(!world.isClient()){
            int threads = state.get(STAGE);
            if(threads > 0){
                world.spawnEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.FLUFF_TUFT, threads)));
            }
        }
    }
}
