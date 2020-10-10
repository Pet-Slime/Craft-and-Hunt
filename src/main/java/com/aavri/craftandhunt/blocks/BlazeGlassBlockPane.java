package com.aavri.craftandhunt.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BlazeGlassBlockPane extends PaneBlock {

	public BlazeGlassBlockPane() {
		super(Block.Properties.create(Material.GLASS)
				.hardnessAndResistance(0.3F)
				.sound(SoundType.GLASS)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.notSolid()
				.setAllowsSpawn(BlazeGlassBlockPane::neverAllowSpawn)
				.setOpaque(BlazeGlassBlockPane::isntSolid)
				.setSuffocates(BlazeGlassBlockPane::isntSolid)
				.setBlocksVision(BlazeGlassBlockPane::isntSolid)	
				);
	}
	
	private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
	      return false;
	   }
	
	private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
	      return (boolean)false;
	   }

}
