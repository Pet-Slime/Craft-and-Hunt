package com.aavri.craftandhunt.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BearTrapPoweredBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
	private static final VoxelShape SHAPE = Block.makeCuboidShape(0, 0, 0, 16, 4, 16);
	public boolean canTrap = true;

	
    public BearTrapPoweredBlock() {
        super(Block.Properties.create((new Material.Builder(MaterialColor.GRASS)).notSolid().build()).doesNotBlockMovement().hardnessAndResistance(1.0f).sound(SoundType.WOOD));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(OPEN, Boolean.valueOf(true)));
    }
    
    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
        super.fillStateContainer(builder);
    }
    
	@Nonnull
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
		return SHAPE;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
	}
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		state = state.func_235896_a_(OPEN);
		boolean flag = state.get(OPEN);
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
			} else {
				worldIn.setBlockState(pos, state, 3);
				float f = flag ? 0.6F : 0.5F;
		        worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, f);
		        return ActionResultType.SUCCESS;
			}
	}
	
	@Override
	public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
	      return blockState.get(OPEN) ? 0 : 15;
	   }
	
    
	   @Override
	    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
			boolean flag = state.get(OPEN);
			float f = flag ? 0.6F : 0.5F;
			if (state.get(OPEN) == true) {
		    	if (entityIn instanceof LivingEntity) {
		    		LivingEntity entity = (LivingEntity) entityIn;
		    		
		    		/// Break on mobs who are too "large"
		    		int Size = (int) (entity.getHeight() + entity.getWidth());
		    		if (Size >= 4) {
		    			if (!worldIn.isRemote()) {
		    				worldIn.destroyBlock(pos, false);
		    				}
		    		} else {
		    			BlockState blockstate = worldIn.getBlockState(pos);
		    			if (entity instanceof PlayerEntity) {
		    				PlayerEntity player = (PlayerEntity) entity;
		    				//Check to see if the player is creative
		    				if (player.isCreative() == false) {
		    					entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10000, 6));
		    					worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(false)), 3);
						        worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, f);
		    				}
		    			} else {
		    			entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10000, 6));
		    			worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(false)), 3);
				        worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, f);
		    			}
		    			
		    		}
		    	} else {
		    		BlockState blockstate = worldIn.getBlockState(pos);
	    			worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(false)), 3);
			        worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, f);
		    	}
	    	}
	    }
	}