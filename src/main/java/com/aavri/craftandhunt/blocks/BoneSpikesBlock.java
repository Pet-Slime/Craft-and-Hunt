package com.aavri.craftandhunt.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BoneSpikesBlock extends Block {
	private static final VoxelShape SHAPE = Block.makeCuboidShape(2, 0, 2, 14, 9, 14);


	
    public BoneSpikesBlock() {
        super(Block.Properties.create((new Material.Builder(MaterialColor.GRASS)).notSolid().build()).doesNotBlockMovement().sound(SoundType.WOOD));
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
    
    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
    	if (entityIn instanceof LivingEntity) {
    		LivingEntity entity = (LivingEntity) entityIn;
    		if (entity.fallDistance > 0) {
        		if (entity instanceof IronGolemEntity) {
        			if (!worldIn.isRemote()) {
        	               worldIn.destroyBlock(pos, false);
        	               }
    			} else {
        			entity.attackEntityFrom(DamageSource.GENERIC, 20.0F);
    			}
    		}
    	}
    }
}