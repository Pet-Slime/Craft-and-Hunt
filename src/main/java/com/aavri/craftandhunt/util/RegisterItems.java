package com.aavri.craftandhunt.util;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.items.CreativeTab;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	private static Rarity uncommon = Rarity.UNCOMMON;
	private static Rarity epic = Rarity.EPIC;
	private static Rarity upgrade = Constants.REINFORCED;
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//Items
	
	public static final RegistryObject<Item> blaze_glass = ITEMS.register("blaze_glass", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	
	public static final RegistryObject<Item> spider_chitin = ITEMS.register("spider_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> spider_poison_chitin = ITEMS.register("spider_poison_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<Item> spider_fermented_chitin = ITEMS.register("spider_fermented_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	
	public static final RegistryObject<Item> bee_chitin = ITEMS.register("bee_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> bear_polar_leather = ITEMS.register("bear_polar_leather", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> bear_panda_leather = ITEMS.register("bear_panda_leather", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> bear_brown_leather = ITEMS.register("bear_brown_leather", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> bear_black_leather = ITEMS.register("bear_black_leather", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> dragon_scale = ITEMS.register("dragon_scale", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(epic)));
	public static final RegistryObject<Item> dragon_boots = ITEMS.register("dragon_boots", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<Item> dragon_helmet = ITEMS.register("dragon_helmet", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<Item> dragon_chestplate = ITEMS.register("dragon_chestplate", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<Item> dragon_leggings = ITEMS.register("dragon_leggings", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<Item> shark_skin = ITEMS.register("shark_skin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> thrasher_tooth = ITEMS.register("thrasher_tooth", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> thrasher_skin = ITEMS.register("thrasher_skin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> thrasher_great_skin = ITEMS.register("thrasher_great_skin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	
	public static final RegistryObject<Item> guardian_skin = ITEMS.register("guardian_skin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> guardian_elder_skin = ITEMS.register("guardian_elder_skin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	
	public static final RegistryObject<Item> wolf_hide = ITEMS.register("wolf_hide", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> fox_hide = ITEMS.register("fox_hide", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> fox_fire_hide = ITEMS.register("fox_fire_hide",
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	
	public static final RegistryObject<Item> stray_cloth = ITEMS.register("stray_cloth", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> goat_hide = ITEMS.register("goat_hide", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> crab_shell = ITEMS.register("crab_shell", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	



}
