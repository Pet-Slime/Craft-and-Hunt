package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.blocks.BearTrapBlock;
import com.aavri.craftandhunt.blocks.BearTrapPoweredBlock;
import com.aavri.craftandhunt.blocks.BlazeGlassBlock;
import com.aavri.craftandhunt.blocks.BlazeGlassBlockPane;
import com.aavri.craftandhunt.blocks.BlockItemBase;
import com.aavri.craftandhunt.blocks.BoneSpikesBlock;
import com.aavri.craftandhunt.blocks.FilledlPumicBlock;
import com.aavri.craftandhunt.blocks.PumicBlock;
import com.aavri.craftandhunt.items.CreativeTab;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterBlocks {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
	
	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
		
	//Blocks
	public static final RegistryObject<Block> blaze_glass_block = BLOCKS.register("blaze_glass_block", BlazeGlassBlock::new);
	public static final RegistryObject<Block> blaze_glass_block_pane = BLOCKS.register("blaze_glass_block_pane", BlazeGlassBlockPane::new);
	public static final RegistryObject<Block> bonespikes = BLOCKS.register("bonespikes", BoneSpikesBlock::new);
	public static final RegistryObject<Block> beartrap = BLOCKS.register("beartrap", BearTrapBlock::new);
	public static final RegistryObject<Block> beartrappower = BLOCKS.register("beartrappower", BearTrapPoweredBlock::new);
	public static final RegistryObject<Block> pumice = BLOCKS.register("pumice", 
							() -> new PumicBlock(AbstractBlock.Properties.create(Material.SPONGE).hardnessAndResistance(0.6F).sound(SoundType.NETHERRACK).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> lava_pumice  = BLOCKS.register("lava_pumice", 
							() -> new FilledlPumicBlock(AbstractBlock.Properties.create(Material.SPONGE).hardnessAndResistance(0.6F).sound(SoundType.NETHERRACK).harvestLevel(0).harvestTool(ToolType.PICKAXE).setLightLevel((lightValue) -> 14)));
	public static final RegistryObject<Block> piglin_gold_block = BLOCKS.register("piglin_gold_block", 
							() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> golden_lantern = BLOCKS.register("golden_lantern", 
			() -> new LanternBlock(AbstractBlock.Properties.create(Material.IRON).setRequiresTool().hardnessAndResistance(3.5F).sound(SoundType.LANTERN).setLightLevel((state) -> {
					      return 15;
					   }).notSolid()));
	public static final RegistryObject<Block> golden_soul_lantern = BLOCKS.register("golden_soul_lantern", 
			() -> new LanternBlock(AbstractBlock.Properties.create(Material.IRON).setRequiresTool().hardnessAndResistance(3.5F).sound(SoundType.LANTERN).setLightLevel((state) -> {
					      return 10;
					   }).notSolid()));

	
	
	//Block Items
	public static final RegistryObject<Item> blaze_glass_block_item = ITEMS.register("blaze_glass_block", () -> new BlockItemBase(blaze_glass_block.get(), new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<Item> blaze_glass_block_pane_item = ITEMS.register("blaze_glass_block_pane", () -> new BlockItemBase(blaze_glass_block_pane.get(), new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<Item> bonespikes_item = ITEMS.register("bonespikes", () -> new BlockItemBase(bonespikes.get(), new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> beartrap_item = ITEMS.register("beartrap", () -> new BlockItemBase(beartrap.get(), new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> beartrappower_item = ITEMS.register("beartrappower", () -> new BlockItemBase(beartrappower.get(), new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> piglin_gold_block_item = ITEMS.register("piglin_gold_block", () -> new BlockItemBase(piglin_gold_block.get(), new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> golden_lantern_item = ITEMS.register("golden_lantern", () -> new BlockItemBase(golden_lantern.get(), new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> golden_soul_lantern_item = ITEMS.register("golden_soul_lantern", () -> new BlockItemBase(golden_soul_lantern.get(), new Item.Properties().group(CreativeTab.HUNT)));
	
    public static final RegistryObject<Item> pumice_item = ITEMS.register("pumice", () -> new BlockItem(pumice.get(), new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
    public static final RegistryObject<Item> lava_pumice_item = ITEMS.register("lava_pumice", () -> new BlockItem(lava_pumice.get(), new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire().maxStackSize(1).containerItem(pumice_item.get())) {
        @Override
        public int getBurnTime(ItemStack itemStack) {
            return 16000;
        }
    });

}
