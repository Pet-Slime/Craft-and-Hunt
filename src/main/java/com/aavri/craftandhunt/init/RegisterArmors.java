package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.CraftandHunt;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.items.CreativeTab;
import com.aavri.craftandhunt.items.armor.AoEArmor;
import com.aavri.craftandhunt.items.armor.ArmorMaterialByItem;
import com.aavri.craftandhunt.items.armor.ArmorMaterialByTag;
import com.aavri.craftandhunt.items.armor.CanineArmor;
import com.aavri.craftandhunt.items.armor.GuildedArmor;
import com.aavri.craftandhunt.items.armor.HoglinArmor;
import com.aavri.craftandhunt.items.armor.LavaArmor;
import com.aavri.craftandhunt.items.armor.SharkArmor;
import com.aavri.craftandhunt.items.armor.ShellArmor;
import com.aavri.craftandhunt.items.armor.StalkerArmor;
import com.aavri.craftandhunt.items.armor.StealthArmor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterArmors {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

	public static final DeferredRegister<Item> BONEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SPIDERARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> WITHERARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BLAZEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> WOLFARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> NAUTARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> GOATARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> PHANTOMARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHULKERARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> GUARDIANARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHARKARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BEARARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BEEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SILVERFISH = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> HALLOWEEN = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> TRIMMEDARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	
	
	private static Rarity uncommon = Rarity.UNCOMMON;
	private static Rarity upgrade = Constants.REINFORCED;
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());		
		if (Config.bone_armor_true.get() == true) { BONEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.spider_armor_true.get() == true) { SPIDERARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.wither_armor_true.get() == true) { WITHERARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.blaze_armor_true.get() == true) { BLAZEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.wolf_armor_true.get() == true) { WOLFARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.naut_armor_true.get() == true) { NAUTARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.goat_armor_true.get() == true) { GOATARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.phantom_armor_true.get() == true) { PHANTOMARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.shulker_armor_true.get() == true) { SHULKERARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.guardian_armor_true.get() == true) { GUARDIANARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.shark_armor_true.get() == true) { SHARKARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.bear_armor_true.get() == true) { BEARARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.bee_armor_true.get() == true) { BEEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.silverfish_armor_true.get() == true) { SILVERFISH.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.guilded_armor_true.get() == true) { TRIMMEDARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		if (Config.halloween_armor_true.get() == true) { HALLOWEEN.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		
		CraftandHunt.LOGGER.info("Sexy Armors Loaded");
	}
	
	public static final RegistryObject<ArmorItem> bone_helmet = BONEARMOR.register("bone_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.bone, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bone_chestplate = BONEARMOR.register("bone_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.bone, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bone_leggings = BONEARMOR.register("bone_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.bone, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bone_boots = BONEARMOR.register("bone_boots",
            () -> new ArmorItem(ArmorMaterialByItem.bone, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	

	public static final RegistryObject<ArmorItem> horror_helmet = HALLOWEEN.register("horror_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.horror, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> horror_chestplate = HALLOWEEN.register("horror_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.horror, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> horror_leggings = HALLOWEEN.register("horror_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.horror, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> horror_boots = HALLOWEEN.register("horror_boots",
            () -> new ArmorItem(ArmorMaterialByItem.horror, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> stalker_helmet = HALLOWEEN.register("stalker_helmet",
            () -> new StalkerArmor(ArmorMaterialByItem.stalker, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> stalker_chestplate = HALLOWEEN.register("stalker_chestplate",
            () -> new StalkerArmor(ArmorMaterialByItem.stalker, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> stalker_leggings = HALLOWEEN.register("stalker_leggings",
            () -> new StalkerArmor(ArmorMaterialByItem.stalker, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> stalker_boots = HALLOWEEN.register("stalker_boots",
            () -> new StalkerArmor(ArmorMaterialByItem.stalker, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> silverfish_helmet = SILVERFISH.register("silverfish_helmet",
            () -> new StealthArmor(ArmorMaterialByItem.silverfish, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> silverfish_chestplate = SILVERFISH.register("silverfish_chestplate",
            () -> new StealthArmor(ArmorMaterialByItem.silverfish, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> silverfish_leggings = SILVERFISH.register("silverfish_leggings",
            () -> new StealthArmor(ArmorMaterialByItem.silverfish, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> silverfish_boots = SILVERFISH.register("silverfish_boots",
            () -> new StealthArmor(ArmorMaterialByItem.silverfish, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> endermite_helmet = SILVERFISH.register("endermite_helmet",
            () -> new StealthArmor(ArmorMaterialByItem.endermite, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> endermite_chestplate = SILVERFISH.register("endermite_chestplate",
            () -> new StealthArmor(ArmorMaterialByItem.endermite, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> endermite_leggings = SILVERFISH.register("endermite_leggings",
            () -> new StealthArmor(ArmorMaterialByItem.endermite, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> endermite_boots = SILVERFISH.register("endermite_boots",
            () -> new StealthArmor(ArmorMaterialByItem.endermite, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	
	public static final RegistryObject<ArmorItem> stray_helmet = BONEARMOR.register("stray_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.stray, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> stray_chestplate = BONEARMOR.register("stray_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.stray, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> stray_leggings = BONEARMOR.register("stray_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.stray, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> stray_boots = BONEARMOR.register("stray_boots",
            () -> new ArmorItem(ArmorMaterialByItem.stray, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> wither_helmet = WITHERARMOR.register("wither_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.wither, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<ArmorItem> wither_chestplate = WITHERARMOR.register("wither_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.wither, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<ArmorItem> wither_leggings = WITHERARMOR.register("wither_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.wither, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	public static final RegistryObject<ArmorItem> wither_boots = WITHERARMOR.register("wither_boots",
            () -> new ArmorItem(ArmorMaterialByItem.wither, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon)));
	
	public static final RegistryObject<ArmorItem> spider_helmet = SPIDERARMOR.register("spider_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.spider, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_chestplate = SPIDERARMOR.register("spider_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.spider, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_leggings = SPIDERARMOR.register("spider_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.spider, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_boots = SPIDERARMOR.register("spider_boots",
            () -> new ArmorItem(ArmorMaterialByItem.spider, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> spider_poison_helmet = SPIDERARMOR.register("spider_poison_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.spiderPoison, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_poison_chestplate = SPIDERARMOR.register("spider_poison_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.spiderPoison, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_poison_leggings = SPIDERARMOR.register("spider_poison_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.spiderPoison, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_poison_boots = SPIDERARMOR.register("spider_poison_boots",
            () -> new ArmorItem(ArmorMaterialByItem.spiderPoison, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> spider_fermented_helmet = SPIDERARMOR.register("spider_fermented_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.spiderFermented, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_fermented_chestplate = SPIDERARMOR.register("spider_fermented_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.spiderFermented, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_fermented_leggings = SPIDERARMOR.register("spider_fermented_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.spiderFermented, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> spider_fermented_boots = SPIDERARMOR.register("spider_fermented_boots",
            () -> new ArmorItem(ArmorMaterialByItem.spiderFermented, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> blaze_helmet = BLAZEARMOR.register("blaze_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.blaze, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> blaze_chestplate = BLAZEARMOR.register("blaze_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.blaze, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> blaze_leggings = BLAZEARMOR.register("blaze_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.blaze, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> blaze_boots = BLAZEARMOR.register("blaze_boots",
            () -> new ArmorItem(ArmorMaterialByItem.blaze, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> strider_helmet = BLAZEARMOR.register("strider_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.strider, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> strider_chestplate = BLAZEARMOR.register("strider_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.strider, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> strider_leggings = BLAZEARMOR.register("strider_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.strider, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> strider_boots = BLAZEARMOR.register("strider_boots",
            () -> new LavaArmor(ArmorMaterialByItem.strider, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> shark_helmet = SHARKARMOR.register("shark_helmet",
            () -> new SharkArmor(ArmorMaterialByItem.shark, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shark_chestplate = SHARKARMOR.register("shark_chestplate",
            () -> new SharkArmor(ArmorMaterialByItem.shark, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shark_leggings = SHARKARMOR.register("shark_leggings",
            () -> new SharkArmor(ArmorMaterialByItem.shark, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shark_boots = SHARKARMOR.register("shark_boots",
            () -> new SharkArmor(ArmorMaterialByItem.shark, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> thrasher_helmet = SHARKARMOR.register("thrasher_helmet",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> thrasher_chestplate = SHARKARMOR.register("thrasher_chestplate",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> thrasher_leggings = SHARKARMOR.register("thrasher_leggings",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> thrasher_boots = SHARKARMOR.register("thrasher_boots",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> thrasher_great_helmet = SHARKARMOR.register("thrasher_great_helmet",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher_great, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> thrasher_great_chestplate = SHARKARMOR.register("thrasher_great_chestplate",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher_great, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> thrasher_great_leggings = SHARKARMOR.register("thrasher_great_leggings",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher_great, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> thrasher_great_boots = SHARKARMOR.register("thrasher_great_boots",
            () -> new SharkArmor(ArmorMaterialByItem.thrasher_great, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> guardian_helmet = GUARDIANARMOR.register("guardian_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.guardian, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> guardian_chestplate = GUARDIANARMOR.register("guardian_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.guardian, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> guardian_leggings = GUARDIANARMOR.register("guardian_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.guardian, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> guardian_boots = GUARDIANARMOR.register("guardian_boots",
            () -> new ArmorItem(ArmorMaterialByItem.guardian, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> guardian_elder_helmet = GUARDIANARMOR.register("guardian_elder_helmet",
            () -> new AoEArmor(ArmorMaterialByItem.guardian_elder, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> guardian_elder_chestplate = GUARDIANARMOR.register("guardian_elder_chestplate",
            () -> new AoEArmor(ArmorMaterialByItem.guardian_elder, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> guardian_elder_leggings = GUARDIANARMOR.register("guardian_elder_leggings",
            () -> new AoEArmor(ArmorMaterialByItem.guardian_elder, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> guardian_elder_boots = GUARDIANARMOR.register("guardian_elder_boots",
            () -> new AoEArmor(ArmorMaterialByItem.guardian_elder, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> shulker_helmet = SHULKERARMOR.register("shulker_helmet",
            () -> new ShellArmor(ArmorMaterialByItem.shulker, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shulker_chestplate = SHULKERARMOR.register("shulker_chestplate",
            () -> new ShellArmor(ArmorMaterialByItem.shulker, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shulker_leggings = SHULKERARMOR.register("shulker_leggings",
            () -> new ShellArmor(ArmorMaterialByItem.shulker, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shulker_boots = SHULKERARMOR.register("shulker_boots",
            () -> new ShellArmor(ArmorMaterialByItem.shulker, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> phantom_helmet = PHANTOMARMOR.register("phantom_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.phantom, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> phantom_chestplate = PHANTOMARMOR.register("phantom_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.phantom, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> phantom_leggings = PHANTOMARMOR.register("phantom_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.phantom, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> phantom_boots = PHANTOMARMOR.register("phantom_boots",
            () -> new ArmorItem(ArmorMaterialByItem.phantom, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> goat_helmet = GOATARMOR.register("goat_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.goat, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> goat_chestplate = GOATARMOR.register("goat_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.goat, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> goat_leggings = GOATARMOR.register("goat_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.goat, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> goat_boots = GOATARMOR.register("goat_boots",
            () -> new ArmorItem(ArmorMaterialByItem.goat, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> hoglin_helmet = GOATARMOR.register("hoglin_helmet",
            () -> new HoglinArmor(ArmorMaterialByItem.hoglin, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> hoglin_chestplate = GOATARMOR.register("hoglin_chestplate",
            () -> new HoglinArmor(ArmorMaterialByItem.hoglin, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> hoglin_leggings = GOATARMOR.register("hoglin_leggings",
            () -> new HoglinArmor(ArmorMaterialByItem.hoglin, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> hoglin_boots = GOATARMOR.register("hoglin_boots",
            () -> new HoglinArmor(ArmorMaterialByItem.hoglin, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> naut_helmet = NAUTARMOR.register("naut_helmet",
            () -> new ShellArmor(ArmorMaterialByItem.naut, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> naut_chestplate = NAUTARMOR.register("naut_chestplate",
            () -> new ShellArmor(ArmorMaterialByItem.naut, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> naut_leggings = NAUTARMOR.register("naut_leggings",
            () -> new ShellArmor(ArmorMaterialByItem.naut, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> naut_boots = NAUTARMOR.register("naut_boots",
            () -> new ShellArmor(ArmorMaterialByItem.naut, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> wolf_helmet = WOLFARMOR.register("wolf_helmet",
            () -> new CanineArmor(ArmorMaterialByItem.wolf, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> wolf_chestplate = WOLFARMOR.register("wolf_chestplate",
            () -> new CanineArmor(ArmorMaterialByItem.wolf, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> wolf_leggings = WOLFARMOR.register("wolf_leggings",
            () -> new CanineArmor(ArmorMaterialByItem.wolf, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> wolf_boots = WOLFARMOR.register("wolf_boots",
            () -> new CanineArmor(ArmorMaterialByItem.wolf, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> fox_helmet = WOLFARMOR.register("fox_helmet",
            () -> new CanineArmor(ArmorMaterialByItem.fox, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> fox_chestplate = WOLFARMOR.register("fox_chestplate",
            () -> new CanineArmor(ArmorMaterialByItem.fox, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> fox_leggings = WOLFARMOR.register("fox_leggings",
            () -> new CanineArmor(ArmorMaterialByItem.fox, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> fox_boots = WOLFARMOR.register("fox_boots",
            () -> new CanineArmor(ArmorMaterialByItem.fox, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> fox_fire_helmet = WOLFARMOR.register("fox_fire_helmet",
            () -> new CanineArmor(ArmorMaterialByItem.fox_fire, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> fox_fire_chestplate = WOLFARMOR.register("fox_fire_chestplate",
            () -> new CanineArmor(ArmorMaterialByItem.fox_fire, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> fox_fire_leggings = WOLFARMOR.register("fox_fire_leggings",
            () -> new CanineArmor(ArmorMaterialByItem.fox_fire, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> fox_fire_boots = WOLFARMOR.register("fox_fire_boots",
            () -> new CanineArmor(ArmorMaterialByItem.fox_fire, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(uncommon).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> bee_helmet = BEEARMOR.register("bee_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.bee, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bee_chestplate = BEEARMOR.register("bee_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.bee, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bee_leggings = BEEARMOR.register("bee_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.bee, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bee_boots = BEEARMOR.register("bee_boots",
            () -> new ArmorItem(ArmorMaterialByItem.bee, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> nest_helmet = BEEARMOR.register("nest_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.nest, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> nest_chestplate = BEEARMOR.register("nest_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.nest, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> nest_leggings = BEEARMOR.register("nest_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.nest, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> nest_boots = BEEARMOR.register("nest_boots",
            () -> new ArmorItem(ArmorMaterialByItem.nest, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> hive_helmet = BEEARMOR.register("hive_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.hive, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> hive_chestplate = BEEARMOR.register("hive_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.hive, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> hive_leggings = BEEARMOR.register("hive_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.hive, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> hive_boots = BEEARMOR.register("hive_boots",
            () -> new ArmorItem(ArmorMaterialByItem.hive, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> bear_polar_helmet = BEARARMOR.register("bear_polar_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.bear_polar, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_polar_chestplate = BEARARMOR.register("bear_polar_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.bear_polar, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_polar_leggings = BEARARMOR.register("bear_polar_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.bear_polar, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_polar_boots = BEARARMOR.register("bear_polar_boots",
            () -> new ArmorItem(ArmorMaterialByItem.bear_polar, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> bear_panda_helmet = BEARARMOR.register("bear_panda_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.bear_panda, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_panda_chestplate = BEARARMOR.register("bear_panda_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.bear_panda, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_panda_leggings = BEARARMOR.register("bear_panda_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.bear_panda, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_panda_boots = BEARARMOR.register("bear_panda_boots",
            () -> new ArmorItem(ArmorMaterialByItem.bear_panda, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> bear_brown_helmet = BEARARMOR.register("bear_brown_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.bear_brown, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_brown_chestplate = BEARARMOR.register("bear_brown_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.bear_brown, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_brown_leggings = BEARARMOR.register("bear_brown_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.bear_brown, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_brown_boots = BEARARMOR.register("bear_brown_boots",
            () -> new ArmorItem(ArmorMaterialByItem.bear_brown, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> bear_black_helmet = BEARARMOR.register("bear_black_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.bear_black, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_black_chestplate = BEARARMOR.register("bear_black_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.bear_black, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_black_leggings = BEARARMOR.register("bear_black_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.bear_black, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> bear_black_boots = BEARARMOR.register("bear_black_boots",
            () -> new ArmorItem(ArmorMaterialByItem.bear_black, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> crab_helmet = ITEMS.register("crab_helmet",
            () -> new ShellArmor(ArmorMaterialByTag.crab, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> crab_chestplate = ITEMS.register("crab_chestplate",
            () -> new ShellArmor(ArmorMaterialByTag.crab, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> crab_leggings = ITEMS.register("crab_leggings",
            () -> new ShellArmor(ArmorMaterialByTag.crab, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> crab_boots = ITEMS.register("crab_boots",
            () -> new ShellArmor(ArmorMaterialByTag.crab, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> shell_chestplate = ITEMS.register("shell_chestplate",
            () -> new ShellArmor(ArmorMaterialByItem.shell, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shell_leggings = ITEMS.register("shell_leggings",
            () -> new ShellArmor(ArmorMaterialByItem.shell, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT)));
	public static final RegistryObject<ArmorItem> shell_boots = ITEMS.register("shell_boots",
            () -> new ShellArmor(ArmorMaterialByItem.shell, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT)));
	
	public static final RegistryObject<ArmorItem> t_iron_helmet = TRIMMEDARMOR.register("t_iron_helmet",
            () -> new GuildedArmor(ArmorMaterialByTag.t_iron, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_iron_chestplate = TRIMMEDARMOR.register("t_iron_chestplate",
            () -> new GuildedArmor(ArmorMaterialByTag.t_iron, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_iron_leggings = TRIMMEDARMOR.register("t_iron_leggings",
            () -> new GuildedArmor(ArmorMaterialByTag.t_iron, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_iron_boots = TRIMMEDARMOR.register("t_iron_boots",
            () -> new GuildedArmor(ArmorMaterialByTag.t_iron, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> t_diamond_helmet = TRIMMEDARMOR.register("t_diamond_helmet",
            () -> new GuildedArmor(ArmorMaterialByTag.t_diamond, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_diamond_chestplate = TRIMMEDARMOR.register("t_diamond_chestplate",
            () -> new GuildedArmor(ArmorMaterialByTag.t_diamond, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_diamond_leggings = TRIMMEDARMOR.register("t_diamond_leggings",
            () -> new GuildedArmor(ArmorMaterialByTag.t_diamond, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_diamond_boots = TRIMMEDARMOR.register("t_diamond_boots",
            () -> new GuildedArmor(ArmorMaterialByTag.t_diamond, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> t_netherite_helmet = TRIMMEDARMOR.register("t_netherite_helmet",
            () -> new GuildedArmor(ArmorMaterialByTag.t_netherite, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_netherite_chestplate = TRIMMEDARMOR.register("t_netherite_chestplate",
            () -> new GuildedArmor(ArmorMaterialByTag.t_netherite, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_netherite_leggings = TRIMMEDARMOR.register("t_netherite_leggings",
            () -> new GuildedArmor(ArmorMaterialByTag.t_netherite, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> t_netherite_boots = TRIMMEDARMOR.register("t_netherite_boots",
            () -> new GuildedArmor(ArmorMaterialByTag.t_netherite, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	
}
