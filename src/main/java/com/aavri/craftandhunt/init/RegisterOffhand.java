package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.items.CreativeTab;
import com.aavri.craftandhunt.items.Offhand.ItemDeathCapMushroom;
import com.aavri.craftandhunt.items.Offhand.ItemEvokersBook;
import com.aavri.craftandhunt.items.Offhand.ItemFireChargeRod;
import com.aavri.craftandhunt.items.Offhand.ItemGolemKit;
import com.aavri.craftandhunt.items.Offhand.ItemLightningRod;
import com.aavri.craftandhunt.items.Offhand.ItemOffhand;
import com.aavri.craftandhunt.items.Offhand.ItemOffhandMagnet;
import com.aavri.craftandhunt.items.Offhand.ItemPiglin;
import com.aavri.craftandhunt.items.Offhand.ItemRocFeather;
import com.aavri.craftandhunt.items.Offhand.ItemTastyBone;
import com.aavri.craftandhunt.items.Offhand.ItemWindHorn;
import com.aavri.craftandhunt.items.Offhand.ItemWonderfulWheat;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@EventBusSubscriber(modid = Constants.MOD_ID, bus = Bus.MOD)
public class RegisterOffhand {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
	
	public static final RegistryObject<Item> wither_spine = ITEMS.register("wither_spine", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> fire_heart = ITEMS.register("fire_heart", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256).isImmuneToFire()));
	public static final RegistryObject<Item> vampire_fang = ITEMS.register("vampire_fang", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> venom_sack = ITEMS.register("venom_sack", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> witch_book = ITEMS.register("witch_book", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> witch_know = ITEMS.register("witch_know", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(1561)));
	public static final RegistryObject<Item> super_ink_sack = ITEMS.register("super_ink_sack", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> fox_tail = ITEMS.register("fox_tail", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> totem_of_regen = ITEMS.register("totem_of_regen", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(3)));
	public static final RegistryObject<Item> totem_of_block = ITEMS.register("totem_of_block", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(12)));
	public static final RegistryObject<Item> puff_shroom = ITEMS.register("puff_shroom", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(32)));
	public static final RegistryObject<Item> impact_slime = ITEMS.register("impact_slime", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(256)));
	public static final RegistryObject<Item> seed_cluster = ITEMS.register("seed_cluster", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE).maxDamage(32)));
	
	
	

	public static final RegistryObject<Item> redstone_magnet = ITEMS.register("redstone_magnet", 
			() -> new ItemOffhandMagnet(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> wonderful_wheat = ITEMS.register("wonderful_wheat", 
			() -> new ItemWonderfulWheat(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> golem_kit = ITEMS.register("golem_kit", 
			() -> new ItemGolemKit(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> tasty_bone = ITEMS.register("tasty_bone", 
			() -> new ItemTastyBone(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> evokers_book = ITEMS.register("evokers_book", 
			() -> new ItemEvokersBook(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> roc_feather = ITEMS.register("roc_feather", 
			() -> new ItemRocFeather(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> firecharge_rod = ITEMS.register("firecharge_rod", 
			() -> new ItemFireChargeRod(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> lightning_rod = ITEMS.register("lightning_rod", 
			() -> new ItemLightningRod(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> death_cap = ITEMS.register("death_cap", 
			() -> new ItemDeathCapMushroom(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> wind_horn = ITEMS.register("wind_horn", 
			() -> new ItemWindHorn(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> piglin_armbrace = ITEMS.register("piglin_armbrace", 
			() -> new ItemPiglin(EquipmentSlotType.OFFHAND, 3.0F, 0.3F, new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> buzzy_nest = ITEMS.register("buzzy_nest", 
			() -> new ItemOffhand(new Item.Properties().group(CreativeTab.HUNT).rarity(Rarity.EPIC).maxDamage(64)));
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	
}
