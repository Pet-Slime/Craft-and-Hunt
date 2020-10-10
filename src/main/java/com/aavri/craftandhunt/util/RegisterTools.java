package com.aavri.craftandhunt.util;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.items.CreativeTab;
import com.aavri.craftandhunt.items.tools.Axe;
import com.aavri.craftandhunt.items.tools.Hoe;
import com.aavri.craftandhunt.items.tools.Pickaxe;
import com.aavri.craftandhunt.items.tools.Shovel;
import com.aavri.craftandhunt.items.tools.Sword;
import com.aavri.craftandhunt.items.tools.ToolMaterialbyItem;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterTools {
	
	public static final DeferredRegister<Item> BONETOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> WITHERTOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SPIDERTOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHARKTOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHULKERTOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHELLTOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BLAZETOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	private static Rarity uncommon = Rarity.UNCOMMON;
	
	public static void init() {
        if (Config.bone_tool_true.get() == true) {
        	BONETOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        if (Config.wither_tool_true.get() == true) {
        	WITHERTOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        if (Config.blaze_tool_true.get() == true) {
        	BLAZETOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        if (Config.spider_tool_true.get() == true) {
        	SPIDERTOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        if (Config.shark_tool_true.get() == true) {
        	SHARKTOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        if (Config.shulker_tool_true.get() == true) {
        	SHULKERTOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        if (Config.shell_tool_true.get() == true) {
        	SHELLTOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
        
	}
	
	//Items
	
	public static final RegistryObject<HoeItem> boneHoe = BONETOOLS.register("bone_hoe", 
															() -> new Hoe(ToolMaterialbyItem.bone, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<AxeItem> boneAxe = BONETOOLS.register("bone_axe", 
															() -> new Axe(ToolMaterialbyItem.bone, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<PickaxeItem> bonePickaxe = BONETOOLS.register("bone_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.bone, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ShovelItem> boneShovel = BONETOOLS.register("bone_shovel", 
															() -> new Shovel(ToolMaterialbyItem.bone, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<SwordItem> boneSword = BONETOOLS.register("bone_sword", 
															() -> new Sword(ToolMaterialbyItem.bone, new Item.Properties().group(CreativeTab.HUNT)));

	public static final RegistryObject<HoeItem> blazeHoe = BLAZETOOLS.register("blaze_hoe", 
															() -> new Hoe(ToolMaterialbyItem.blaze, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<AxeItem> blazeAxe = BLAZETOOLS.register("blaze_axe", 
															() -> new Axe(ToolMaterialbyItem.blaze, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<PickaxeItem> blazePickaxe = BLAZETOOLS.register("blaze_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.blaze, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ShovelItem> blazeShovel = BLAZETOOLS.register("blaze_shovel", 
															() -> new Shovel(ToolMaterialbyItem.blaze, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<SwordItem> blazeSword = BLAZETOOLS.register("blaze_sword", 
															() -> new Sword(ToolMaterialbyItem.blaze, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	
	public static final RegistryObject<HoeItem> witherHoe = WITHERTOOLS.register("wither_hoe", 
															() -> new Hoe(ToolMaterialbyItem.wither, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<AxeItem> witherAxe = WITHERTOOLS.register("wither_axe", 
															() -> new Axe(ToolMaterialbyItem.wither, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<PickaxeItem> witherPickaxe = WITHERTOOLS.register("wither_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.wither, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<ShovelItem> witherShovel = WITHERTOOLS.register("wither_shovel", 
															() -> new Shovel(ToolMaterialbyItem.wither, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<SwordItem> witherSword = WITHERTOOLS.register("wither_sword", 
															() -> new Sword(ToolMaterialbyItem.wither, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));

	public static final RegistryObject<HoeItem> sharkHoe = SHARKTOOLS.register("shark_hoe", 
															() -> new Hoe(ToolMaterialbyItem.shark, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<AxeItem> sharkAxe = SHARKTOOLS.register("shark_axe", 
															() -> new Axe(ToolMaterialbyItem.shark, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<PickaxeItem> sharkPickaxe = SHARKTOOLS.register("shark_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.shark, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ShovelItem> sharkShovel = SHARKTOOLS.register("shark_shovel", 
															() -> new Shovel(ToolMaterialbyItem.shark, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<SwordItem> sharkSword = SHARKTOOLS.register("shark_sword", 
															() -> new Sword(ToolMaterialbyItem.shark, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<HoeItem> spiderHoe = SPIDERTOOLS.register("spider_hoe", 
															() -> new Hoe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<AxeItem> spiderAxe = SPIDERTOOLS.register("spider_axe", 
															() -> new Axe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<PickaxeItem> spiderPickaxe = SPIDERTOOLS.register("spider_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ShovelItem> spiderShovel = SPIDERTOOLS.register("spider_shovel", 
															() -> new Shovel(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<SwordItem> spiderSword = SPIDERTOOLS.register("spider_sword", 
															() -> new Sword(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<HoeItem> spiderFermentedHoe = SPIDERTOOLS.register("spider_fermented_hoe", 
															() -> new Hoe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<AxeItem> spiderFermentedAxe = SPIDERTOOLS.register("spider_fermented_axe", 
															() -> new Axe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<PickaxeItem> spiderFermentedPickaxe = SPIDERTOOLS.register("spider_fermented_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<ShovelItem> spiderFermentedShovel = SPIDERTOOLS.register("spider_fermented_shovel", 
															() -> new Shovel(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<SwordItem> spiderFermentedSword = SPIDERTOOLS.register("spider_fermented_sword", 
															() -> new Sword(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));


	public static final RegistryObject<HoeItem> spiderPoisonHoe = SPIDERTOOLS.register("spider_poison_hoe", 
															() -> new Hoe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<AxeItem> spiderPoisonAxe = SPIDERTOOLS.register("spider_poison_axe", 
															() -> new Axe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<PickaxeItem> spiderPoisonPickaxe = SPIDERTOOLS.register("spider_poison_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ShovelItem> spiderPoisonShovel = SPIDERTOOLS.register("spider_poison_shovel", 
															() -> new Shovel(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<SwordItem> spiderPoisonSword = SPIDERTOOLS.register("spider_poison_sword", 
															() -> new Sword(ToolMaterialbyItem.spider, new Item.Properties().group(CreativeTab.HUNT)));

	public static final RegistryObject<HoeItem> shellHoe = SHELLTOOLS.register("shell_hoe", 
															() -> new Hoe(ToolMaterialbyItem.shell, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<AxeItem> shellAxe = SHELLTOOLS.register("shell_axe", 
															() -> new Axe(ToolMaterialbyItem.shell, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<PickaxeItem> shellPickaxe = SHELLTOOLS.register("shell_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.shell, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ShovelItem> shellShovel = SHELLTOOLS.register("shell_shovel", 
															() -> new Shovel(ToolMaterialbyItem.shell, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<SwordItem> shellSword = SHELLTOOLS.register("shell_sword", 
															() -> new Sword(ToolMaterialbyItem.shell, new Item.Properties().group(CreativeTab.HUNT)));

	public static final RegistryObject<HoeItem> shulkerHoe = SHULKERTOOLS.register("shulker_hoe", 
															() -> new Hoe(ToolMaterialbyItem.shulker, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<AxeItem> shulkerAxe = SHULKERTOOLS.register("shulker_axe", 
															() -> new Axe(ToolMaterialbyItem.shulker, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<PickaxeItem> shulkerPickaxe = SHULKERTOOLS.register("shulker_pickaxe", 
															() -> new Pickaxe(ToolMaterialbyItem.shulker, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ShovelItem> shulkerShovel = SHULKERTOOLS.register("shulker_shovel", 
															() -> new Shovel(ToolMaterialbyItem.shulker, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<SwordItem> shulkerSword = SHULKERTOOLS.register("shulker_sword", 
															() -> new Sword(ToolMaterialbyItem.shulker, new Item.Properties().group(CreativeTab.HUNT)));
}
