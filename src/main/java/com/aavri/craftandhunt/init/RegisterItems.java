package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.items.BoneAshBottleItem;
import com.aavri.craftandhunt.items.CreativeTab;
import com.aavri.craftandhunt.items.CustomMusicDisc;
import com.aavri.craftandhunt.items.GluttonParasiteItem;
import com.aavri.craftandhunt.items.ItemHearthstone;
import com.aavri.craftandhunt.items.WoodenSplinterItem;

import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> FOOD = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	private static Rarity uncommon = Rarity.UNCOMMON;
	private static Rarity epic = Rarity.EPIC;
	private static Rarity upgrade = Constants.REINFORCED;
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		FOOD.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//Items
	
	public static final RegistryObject<Item> blaze_glass = ITEMS.register("blaze_glass", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	
	public static final RegistryObject<Item> strider_rock = ITEMS.register("strider_rock", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));

	public static final RegistryObject<Item> hoglin_leather = ITEMS.register("hoglin_leather", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	
	public static final RegistryObject<Item> spider_chitin = ITEMS.register("spider_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> spider_poison_chitin = ITEMS.register("spider_poison_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<Item> spider_fermented_chitin = ITEMS.register("spider_fermented_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	
	public static final RegistryObject<Item> bee_chitin = ITEMS.register("bee_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	

	public static final RegistryObject<Item> parasite_glutton = ITEMS.register("parasite_glutton", 
															() -> new GluttonParasiteItem(new Item.Properties().group(CreativeTab.HUNT), 300));
	public static final RegistryObject<Item> parasite_starved = ITEMS.register("parasite_starved", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	

	public static final RegistryObject<Item> branch_splinter = ITEMS.register("branch_splinter", 
															() -> new WoodenSplinterItem(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> branch_splinter_bloody = ITEMS.register("bloodied_branch_splinter", 
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
	
	public static final RegistryObject<Item> piglin_emblem = ITEMS.register("piglin_emblem", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> trident_head = ITEMS.register("trident_head", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> unfinished_trident = ITEMS.register("unfinished_trident", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> calamari = FOOD.register("calamari", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).food(Foods.COOKED_SALMON)));
	public static final RegistryObject<Item> cooked_calamari = FOOD.register("cooked_calamari", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).food(Foods.COOKED_SALMON)));
	public static final RegistryObject<Item> bear_flank = FOOD.register("bear_flank", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).food(Foods.BEEF)));
	public static final RegistryObject<Item> cooked_bear_flank = FOOD.register("cooked_bear_flank", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT).food(Foods.COOKED_BEEF)));
	
	public static final RegistryObject<Item> bone_ash = ITEMS.register("bone_ash", 
															() -> new BoneAshBottleItem(new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<Item> sunken_temple_desc = ITEMS.register("sunken_temple_desc", 
															() -> new CustomMusicDisc(50, RegisterSounds.sunken_temple, new Item.Properties().maxStackSize(1).group(CreativeTab.HUNT).rarity(epic)));
	

	public static final RegistryObject<Item> hearthstone = ITEMS.register("hearthstone", 
															() -> new ItemHearthstone(new Item.Properties().group(CreativeTab.HUNT)));
	

	public static final RegistryObject<Item> silverfish_chitin = ITEMS.register("silverfish_chitin", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<Item> endermite_mass = ITEMS.register("endermite_mass", 
															() -> new Item(new Item.Properties().group(CreativeTab.HUNT)));
	

	
	



}
