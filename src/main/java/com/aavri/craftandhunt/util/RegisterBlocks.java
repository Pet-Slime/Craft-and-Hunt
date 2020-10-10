package com.aavri.craftandhunt.util;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.blocks.BlazeGlassBlock;
import com.aavri.craftandhunt.blocks.BlazeGlassBlockPane;
import com.aavri.craftandhunt.blocks.BlockItemBase;
import com.aavri.craftandhunt.items.CreativeTab;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterBlocks {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
	private static Properties item = new Item.Properties().group(CreativeTab.HUNT);
	
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
		
	//Blocks
	public static final RegistryObject<Block> blaze_glass_block = BLOCKS.register("blaze_glass_block", BlazeGlassBlock::new);
	public static final RegistryObject<Block> blaze_glass_block_pane = BLOCKS.register("blaze_glass_block_pane", BlazeGlassBlockPane::new);
	
	
	//Block Items
	public static final RegistryObject<Item> blaze_glass_block_item = ITEMS.register("blaze_glass_block", () -> new BlockItemBase(blaze_glass_block.get(), item.isImmuneToFire()));
	public static final RegistryObject<Item> blaze_glass_block_pane_item = ITEMS.register("blaze_glass_block_pane", () -> new BlockItemBase(blaze_glass_block_pane.get(), item.isImmuneToFire()));

}
