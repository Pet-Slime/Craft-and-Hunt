package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.items.CreativeTab;
import com.aavri.craftandhunt.items.armor.AoEArmor;
import com.aavri.craftandhunt.items.armor.ArmorMaterialByItem;
import com.aavri.craftandhunt.items.armor.LavaArmor;
import com.aavri.craftandhunt.items.armor.SharkArmor;
import com.aavri.craftandhunt.items.armor.ShellArmor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterArmorsUpgrades {
	
	public static final DeferredRegister<Item> BONEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SPIDERARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> WITHERARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BLAZEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> WOLFARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> GOATARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> PHANTOMARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHULKERARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> GUARDIANARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SHARKARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BEARARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> BEEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> SILVERFISH = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

	public static final DeferredRegister<Item> HALLOWEEN = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	public static final DeferredRegister<Item> UPGRADEARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	

	private static Rarity upgrade = Constants.REINFORCED;
	
	public static void init() {
	
		if (Config.upgrade_armor_true.get() == true) {
			UPGRADEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
			if (Config.bone_armor_true.get() == true) { BONEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.spider_armor_true.get() == true) { SPIDERARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.wither_armor_true.get() == true) { WITHERARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.blaze_armor_true.get() == true) { BLAZEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.wolf_armor_true.get() == true) { WOLFARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.goat_armor_true.get() == true) { GOATARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.phantom_armor_true.get() == true) { PHANTOMARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.shulker_armor_true.get() == true) { SHULKERARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.guardian_armor_true.get() == true) { GUARDIANARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.shark_armor_true.get() == true) { SHARKARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.bear_armor_true.get() == true) { BEARARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.bee_armor_true.get() == true) { BEEARMOR.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.silverfish_armor_true.get() == true) { SILVERFISH.register(FMLJavaModLoadingContext.get().getModEventBus()); }
			if (Config.halloween_armor_true.get() == true) { HALLOWEEN.register(FMLJavaModLoadingContext.get().getModEventBus()); }
		}

	}
	

	public static final RegistryObject<ArmorItem> u_stray_helmet = BONEARMOR.register("u_stray_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_stray, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_stray_chestplate = BONEARMOR.register("u_stray_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.stray, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_stray_leggings = BONEARMOR.register("u_stray_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_stray, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_stray_boots = BONEARMOR.register("u_stray_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_stray, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_wither_helmet = WITHERARMOR.register("u_wither_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_wither, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_wither_chestplate = WITHERARMOR.register("u_wither_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_wither, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_wither_leggings = WITHERARMOR.register("u_wither_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_wither, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_wither_boots = WITHERARMOR.register("u_wither_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_wither, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_spider_poison_helmet = SPIDERARMOR.register("u_spider_poison_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderPoison, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_spider_poison_chestplate = SPIDERARMOR.register("u_spider_poison_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderPoison, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_spider_poison_leggings = SPIDERARMOR.register("u_spider_poison_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderPoison, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_spider_poison_boots = SPIDERARMOR.register("u_spider_poison_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderPoison, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_spider_fermented_helmet = SPIDERARMOR.register("u_spider_fermented_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderFermented, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_spider_fermented_chestplate = SPIDERARMOR.register("u_spider_fermented_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderFermented, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_spider_fermented_leggings = SPIDERARMOR.register("u_spider_fermented_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderFermented, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_spider_fermented_boots = SPIDERARMOR.register("u_spider_fermented_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_spiderFermented, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_blaze_helmet = BLAZEARMOR.register("u_blaze_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_blaze, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire().rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_blaze_chestplate = BLAZEARMOR.register("u_blaze_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_blaze, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire().rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_blaze_leggings = BLAZEARMOR.register("u_blaze_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_blaze, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire().rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_blaze_boots = BLAZEARMOR.register("u_blaze_boots",
            () -> new LavaArmor(ArmorMaterialByItem.u_blaze, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).isImmuneToFire().rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_shark_helmet = SHARKARMOR.register("u_shark_helmet",
            () -> new SharkArmor(ArmorMaterialByItem.u_shark, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shark_chestplate = SHARKARMOR.register("u_shark_chestplate",
            () -> new SharkArmor(ArmorMaterialByItem.u_shark, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shark_leggings = SHARKARMOR.register("u_shark_leggings",
            () -> new SharkArmor(ArmorMaterialByItem.u_shark, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shark_boots = SHARKARMOR.register("u_shark_boots",
            () -> new SharkArmor(ArmorMaterialByItem.u_shark, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_guardian_elder_helmet = GUARDIANARMOR.register("u_guardian_elder_helmet",
            () -> new AoEArmor(ArmorMaterialByItem.u_guardian_elder, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_guardian_elder_chestplate = GUARDIANARMOR.register("u_guardian_elder_chestplate",
            () -> new AoEArmor(ArmorMaterialByItem.u_guardian_elder, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_guardian_elder_leggings = GUARDIANARMOR.register("u_guardian_elder_leggings",
            () -> new AoEArmor(ArmorMaterialByItem.u_guardian_elder, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_guardian_elder_boots = GUARDIANARMOR.register("u_guardian_elder_boots",
            () -> new AoEArmor(ArmorMaterialByItem.u_guardian_elder, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_shulker_helmet = SHULKERARMOR.register("u_shulker_helmet",
            () -> new ShellArmor(ArmorMaterialByItem.u_shulker, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shulker_chestplate = SHULKERARMOR.register("u_shulker_chestplate",
            () -> new ShellArmor(ArmorMaterialByItem.u_shulker, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shulker_leggings = SHULKERARMOR.register("u_shulker_leggings",
            () -> new ShellArmor(ArmorMaterialByItem.u_shulker, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shulker_boots = SHULKERARMOR.register("u_shulker_boots",
            () -> new ShellArmor(ArmorMaterialByItem.u_shulker, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_phantom_helmet = PHANTOMARMOR.register("u_phantom_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_phantom, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_phantom_chestplate = PHANTOMARMOR.register("u_phantom_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_phantom, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_phantom_leggings = PHANTOMARMOR.register("u_phantom_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_phantom, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_phantom_boots = PHANTOMARMOR.register("u_phantom_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_phantom, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_goat_helmet = GOATARMOR.register("u_goat_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_goat, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_goat_chestplate = GOATARMOR.register("u_goat_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_goat, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_goat_leggings = GOATARMOR.register("u_goat_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_goat, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_goat_boots = GOATARMOR.register("u_goat_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_goat, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));

	public static final RegistryObject<ArmorItem> u_bee_helmet = BEEARMOR.register("u_bee_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_bee, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bee_chestplate = BEEARMOR.register("u_bee_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_bee, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bee_leggings = BEEARMOR.register("u_bee_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_bee, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bee_boots = BEEARMOR.register("u_bee_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_bee, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_fox_helmet = WOLFARMOR.register("u_fox_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_fox, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> u_fox_chestplate = WOLFARMOR.register("u_fox_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_fox, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> u_fox_leggings = WOLFARMOR.register("u_fox_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_fox, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade).isImmuneToFire()));
	public static final RegistryObject<ArmorItem> u_fox_boots = WOLFARMOR.register("u_fox_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_fox, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> u_bear_polar_helmet = BEARARMOR.register("u_bear_polar_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_polar, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_polar_chestplate = BEARARMOR.register("u_bear_polar_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_polar, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_polar_leggings = BEARARMOR.register("u_bear_polar_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_polar, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_polar_boots = BEARARMOR.register("u_bear_polar_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_polar, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_bear_panda_helmet = BEARARMOR.register("u_bear_panda_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_panda, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_panda_chestplate = BEARARMOR.register("u_bear_panda_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_panda, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_panda_leggings = BEARARMOR.register("u_bear_panda_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_panda, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_panda_boots = BEARARMOR.register("u_bear_panda_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_panda, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_bear_brown_helmet = BEARARMOR.register("u_bear_brown_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_brown, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_brown_chestplate = BEARARMOR.register("u_bear_brown_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_brown, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_brown_leggings = BEARARMOR.register("u_bear_brown_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_brown, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_brown_boots = BEARARMOR.register("u_bear_brown_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_brown, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	
	public static final RegistryObject<ArmorItem> u_bear_black_helmet = BEARARMOR.register("u_bear_black_helmet",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_black, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_black_chestplate = BEARARMOR.register("u_bear_black_chestplate",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_black, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_black_leggings = BEARARMOR.register("u_bear_black_leggings",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_black, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_bear_black_boots = BEARARMOR.register("u_bear_black_boots",
            () -> new ArmorItem(ArmorMaterialByItem.u_bear_black, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));

	public static final RegistryObject<ArmorItem> u_shell_helmet = UPGRADEARMOR.register("u_shell_helmet",
            () -> new ShellArmor(ArmorMaterialByItem.u_shell, EquipmentSlotType.HEAD, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shell_chestplate = UPGRADEARMOR.register("u_shell_chestplate",
            () -> new ShellArmor(ArmorMaterialByItem.u_shell, EquipmentSlotType.CHEST, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shell_leggings = UPGRADEARMOR.register("u_shell_leggings",
            () -> new ShellArmor(ArmorMaterialByItem.u_shell, EquipmentSlotType.LEGS, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
	public static final RegistryObject<ArmorItem> u_shell_boots = UPGRADEARMOR.register("u_shell_boots",
            () -> new ShellArmor(ArmorMaterialByItem.u_shell, EquipmentSlotType.FEET, new Item.Properties().group(CreativeTab.HUNT).rarity(upgrade)));
}
