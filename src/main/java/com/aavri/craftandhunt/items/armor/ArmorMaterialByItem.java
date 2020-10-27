package com.aavri.craftandhunt.items.armor;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.init.RegisterItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArmorMaterialByItem {

	/// Feet, Legs, Chest, Head
	public final static IArmorMaterial shell = new ArmorMaterial(Constants.MOD_ID + ":shell",	25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.3F, Items.SCUTE);
	
    public final static IArmorMaterial bone = new ArmorMaterial(Constants.MOD_ID + ":bone",	Config.bone_durabilityValue.get(), 	
    											new int[]{Config.bone_bootsdefense.get(), Config.bone_legsdefense.get(), Config.bone_chestdefense.get(), Config.bone_helmDefense.get()},
    											Config.bone_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.bone_toughness.get().floatValue(), (float) (Config.bone_knockbackResistance.get() * 0.1), Items.BONE);
    
    public final static IArmorMaterial horror = new ArmorMaterial(Constants.MOD_ID + ":horror",	Config.halloween_durabilityValue.get(), 	
    											new int[]{Config.halloween_bootsdefense.get(), Config.halloween_legsdefense.get(), Config.halloween_chestdefense.get(), Config.halloween_helmDefense.get()},
    											Config.halloween_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.halloween_toughness.get().floatValue(), (float) (Config.halloween_knockbackResistance.get() * 0.1), RegisterItems.parasite_starved.get());
    
    public final static IArmorMaterial stalker = new ArmorMaterial(Constants.MOD_ID + ":stalker",	Config.halloween_durabilityValue.get(), 	
												new int[]{Config.halloween_bootsdefense.get(), Config.halloween_legsdefense.get(), Config.halloween_chestdefense.get(), Config.halloween_helmDefense.get()},
												Config.halloween_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.halloween_toughness.get().floatValue(), (float) (Config.halloween_knockbackResistance.get() * 0.1), RegisterItems.branch_splinter_bloody.get());

    
    
    public final static IArmorMaterial silverfish = new ArmorMaterial(Constants.MOD_ID + ":silverfish",	Config.silverfish_durabilityValue.get(), 	
												new int[]{Config.silverfish_bootsdefense.get(), Config.silverfish_legsdefense.get(), Config.silverfish_chestdefense.get(), Config.silverfish_helmDefense.get()},
												Config.silverfish_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.silverfish_toughness.get().floatValue(), (float) (Config.silverfish_knockbackResistance.get() * 0.1), RegisterItems.silverfish_chitin.get());

    public final static IArmorMaterial endermite = new ArmorMaterial(Constants.MOD_ID + ":endermite",	(int) Math.round(Config.silverfish_durabilityValue.get() * 2), 	
    											new int[]{Config.silverfish_bootsdefense.get()+1, Config.silverfish_legsdefense.get()+1, Config.silverfish_chestdefense.get()+1, Config.silverfish_helmDefense.get()+1},
    											Config.silverfish_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.silverfish_toughness.get().floatValue(), (float) (Config.silverfish_knockbackResistance.get() * 0.1), RegisterItems.endermite_mass.get());
   
    public final static IArmorMaterial stray = new ArmorMaterial(Constants.MOD_ID + ":stray",	(int) Math.round(Config.bone_durabilityValue.get() * 1.25), 	
    											new int[]{Config.bone_bootsdefense.get()+1, Config.bone_legsdefense.get()+1, Config.bone_chestdefense.get()+1, Config.bone_helmDefense.get()+1},
    											Config.bone_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.bone_toughness.get().floatValue(), (float) (Config.bone_knockbackResistance.get() * 0.1), Items.BONE);
    
    public final static IArmorMaterial spider = new ArmorMaterial(Constants.MOD_ID + ":spider",	Config.spider_durabilityValue.get(), 	
    											new int[]{Config.spider_bootsdefense.get(), Config.spider_legsdefense.get(), Config.spider_chestdefense.get(), Config.spider_helmDefense.get()},
    											Config.spider_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.spider_toughness.get().floatValue(), (float) (Config.spider_knockbackResistance.get() * 0.1), RegisterItems.spider_chitin.get());
    
    public final static IArmorMaterial spiderPoison = new ArmorMaterial(Constants.MOD_ID + ":spider_poison",	(int) Math.round(Config.spider_durabilityValue.get() * 2), 	
												new int[]{Config.spider_bootsdefense.get()+1, Config.spider_legsdefense.get()+1, Config.spider_chestdefense.get()+1, Config.spider_helmDefense.get()+1},
												Config.spider_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.spider_toughness.get().floatValue(), (float) (Config.spider_knockbackResistance.get() * 0.1), RegisterItems.spider_poison_chitin.get());
    
    public final static IArmorMaterial spiderFermented = new ArmorMaterial(Constants.MOD_ID + ":spider_fermented",	(int) Math.round(Config.spider_durabilityValue.get() * 2), 	
												new int[]{Config.spider_bootsdefense.get()+1, Config.spider_legsdefense.get()+1, Config.spider_chestdefense.get()+1, Config.spider_helmDefense.get()+1},
												Config.spider_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.spider_toughness.get().floatValue(), (float) (Config.spider_knockbackResistance.get() * 0.1), RegisterItems.spider_fermented_chitin.get());
    
    public final static IArmorMaterial wither = new ArmorMaterial(Constants.MOD_ID + ":wither",	Config.wither_durabilityValue.get(), 	
    											new int[]{Config.wither_bootsdefense.get(), Config.wither_legsdefense.get(), Config.wither_chestdefense.get(), Config.wither_helmDefense.get()},
    											Config.wither_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.wither_toughness.get().floatValue(), (float) (Config.wither_knockbackResistance.get() * 0.1), Items.BONE);
												
    public final static IArmorMaterial blaze = new ArmorMaterial(Constants.MOD_ID + ":blaze",	Config.blaze_durabilityValue.get(), 	
    											new int[]{Config.blaze_bootsdefense.get(), Config.blaze_legsdefense.get(), Config.blaze_chestdefense.get(), Config.blaze_helmDefense.get()},
    											Config.blaze_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.blaze_toughness.get().floatValue(), (float) (Config.blaze_knockbackResistance.get() * 0.1), RegisterItems.blaze_glass.get());

    public final static IArmorMaterial strider = new ArmorMaterial(Constants.MOD_ID + ":strider",	(int) Math.round(Config.blaze_durabilityValue.get() * 1.5), 	
    											new int[]{Config.blaze_bootsdefense.get()+1, Config.blaze_legsdefense.get()+1, Config.blaze_chestdefense.get()+2, Config.blaze_helmDefense.get()+1},
    											Config.blaze_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.blaze_toughness.get().floatValue(), (float) (Config.blaze_knockbackResistance.get() * 0.1), RegisterItems.strider_rock.get());
    
    public final static IArmorMaterial phantom = new ArmorMaterial(Constants.MOD_ID + ":phantom",	Config.phantom_durabilityValue.get(), 	
    											new int[]{Config.phantom_bootsdefense.get(), Config.phantom_legsdefense.get(), Config.phantom_chestdefense.get(), Config.phantom_helmDefense.get()},
    											Config.phantom_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.phantom_toughness.get().floatValue(), (float) (Config.phantom_knockbackResistance.get() * 0.1), Items.PHANTOM_MEMBRANE);
												
    public final static IArmorMaterial shulker = new ArmorMaterial(Constants.MOD_ID + ":shulker",	Config.shulker_durabilityValue.get(), 	
    											new int[]{Config.shulker_bootsdefense.get(), Config.shulker_legsdefense.get(), Config.shulker_chestdefense.get(), Config.shulker_helmDefense.get()},
    											Config.shulker_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, Config.shulker_toughness.get().floatValue(), (float) (Config.shulker_knockbackResistance.get() * 0.1), Items.SHULKER_SHELL);
												
    public final static IArmorMaterial guardian = new ArmorMaterial(Constants.MOD_ID + ":guardian",	Config.guardian_durabilityValue.get(), 	
    											new int[]{Config.guardian_bootsdefense.get(), Config.guardian_legsdefense.get(), Config.guardian_chestdefense.get(), Config.guardian_helmDefense.get()},
    											Config.guardian_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.guardian_toughness.get().floatValue(), (float) (Config.guardian_knockbackResistance.get() * 0.1), RegisterItems.guardian_skin.get());
												
    public final static IArmorMaterial guardian_elder = new ArmorMaterial(Constants.MOD_ID + ":guardian_elder",	(int) Math.round(Config.guardian_durabilityValue.get() * 1.25), 	
												new int[]{Config.guardian_bootsdefense.get()+1, Config.guardian_legsdefense.get()+1, Config.guardian_chestdefense.get()+1, Config.guardian_helmDefense.get()+1},
												Config.guardian_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.guardian_toughness.get().floatValue(), (float) (Config.guardian_knockbackResistance.get() * 0.1), RegisterItems.guardian_skin.get());
												
    public final static IArmorMaterial shark = new ArmorMaterial(Constants.MOD_ID + ":shark",	Config.shark_durabilityValue.get(), 	
    											new int[]{Config.shark_bootsdefense.get(), Config.shark_legsdefense.get(), Config.shark_chestdefense.get(), Config.shark_helmDefense.get()},
    											Config.shark_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.shark_toughness.get().floatValue(), (float) (Config.shark_knockbackResistance.get() * 0.1), RegisterItems.shark_skin.get());
    
    public final static IArmorMaterial thrasher = new ArmorMaterial(Constants.MOD_ID + ":thrasher",	(int) Math.round(Config.shark_durabilityValue.get() * 2), 	
												new int[]{Config.shark_bootsdefense.get()+1, Config.shark_legsdefense.get()+3, Config.shark_chestdefense.get()+3, Config.shark_helmDefense.get()+1},
												Config.shark_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.shark_toughness.get().floatValue(), (float) (Config.shark_knockbackResistance.get() * 0.1), RegisterItems.thrasher_skin.get());
    
    public final static IArmorMaterial thrasher_great = new ArmorMaterial(Constants.MOD_ID + ":thrasher_great",	(int) Math.round(Config.shark_durabilityValue.get() * 4), 	
												new int[]{Config.shark_bootsdefense.get()+2, Config.shark_legsdefense.get()+5, Config.shark_chestdefense.get()+5, Config.shark_helmDefense.get()+2},
												Config.shark_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.shark_toughness.get().floatValue(), (float) (Config.shark_knockbackResistance.get() * 0.1), RegisterItems.thrasher_great_skin.get());
												
    public final static IArmorMaterial bear_polar = new ArmorMaterial(Constants.MOD_ID + ":bear_polar",	Config.bear_durabilityValue.get(), 	
    											new int[]{Config.bear_bootsdefense.get(), Config.bear_legsdefense.get(), Config.bear_chestdefense.get(), Config.bear_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.bear_toughness.get().floatValue(), (float) (Config.bear_knockbackResistance.get() * 0.1), RegisterItems.bear_polar_leather.get());
												
    public final static IArmorMaterial bear_panda = new ArmorMaterial(Constants.MOD_ID + ":bear_panda",	Config.bear_durabilityValue.get(), 	
    											new int[]{Config.bear_bootsdefense.get(), Config.bear_legsdefense.get(), Config.bear_chestdefense.get(), Config.bear_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.bear_toughness.get().floatValue(), (float) (Config.bear_knockbackResistance.get() * 0.1), RegisterItems.bear_panda_leather.get());
												
    public final static IArmorMaterial bear_brown = new ArmorMaterial(Constants.MOD_ID + ":bear_brown",	Config.bear_durabilityValue.get(), 	
    											new int[]{Config.bear_bootsdefense.get(), Config.bear_legsdefense.get(), Config.bear_chestdefense.get(), Config.bear_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.bear_toughness.get().floatValue(), (float) (Config.bear_knockbackResistance.get() * 0.1), RegisterItems.bear_brown_leather.get());
												
    public final static IArmorMaterial bear_black = new ArmorMaterial(Constants.MOD_ID + ":bear_black",	Config.bear_durabilityValue.get(), 	
    											new int[]{Config.bear_bootsdefense.get(), Config.bear_legsdefense.get(), Config.bear_chestdefense.get(), Config.bear_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.bear_toughness.get().floatValue(), (float) (Config.bear_knockbackResistance.get() * 0.1), RegisterItems.bear_black_leather.get());
												
    public final static IArmorMaterial bee = new ArmorMaterial(Constants.MOD_ID + ":bee",	Config.bee_durabilityValue.get(), 	
    											new int[]{Config.bee_bootsdefense.get(), Config.bee_legsdefense.get(), Config.bee_chestdefense.get(), Config.bee_helmDefense.get()},
    											Config.bee_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.bee_toughness.get().floatValue(), (float) (Config.bee_knockbackResistance.get() * 0.1), RegisterItems.bee_chitin.get());
    
    public final static IArmorMaterial nest = new ArmorMaterial(Constants.MOD_ID + ":nest",	(int) Math.round(Config.bee_durabilityValue.get() * 2), 	
												new int[]{Config.bee_bootsdefense.get() +1, Config.bee_legsdefense.get()+1, Config.bee_chestdefense.get()+1, Config.bee_helmDefense.get()+1},
												Config.bee_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.bee_toughness.get().floatValue(), (float) (Config.bee_knockbackResistance.get() * 0.1), Items.HONEYCOMB);
    
    public final static IArmorMaterial hive = new ArmorMaterial(Constants.MOD_ID + ":hive",	(int) Math.round(Config.bee_durabilityValue.get() * 3), 	
												new int[]{Config.bee_bootsdefense.get()+2, Config.bee_legsdefense.get()+2, Config.bee_chestdefense.get()+2, Config.bee_helmDefense.get()+2},
												Config.bee_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.bee_toughness.get().floatValue(), (float) (Config.bee_knockbackResistance.get() * 0.1), Items.BEEHIVE);
												
    public final static IArmorMaterial wolf = new ArmorMaterial(Constants.MOD_ID + ":wolf",	Config.wolf_durabilityValue.get(), 	
												new int[]{Config.wolf_bootsdefense.get(), Config.wolf_legsdefense.get(), Config.wolf_chestdefense.get(), Config.wolf_helmDefense.get()},
												Config.wolf_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.wolf_toughness.get().floatValue(), (float) (Config.wolf_knockbackResistance.get() * 0.1), RegisterItems.wolf_hide.get());
												
	public final static IArmorMaterial goat = new ArmorMaterial(Constants.MOD_ID + ":goat",	Config.goat_durabilityValue.get(), 	
												new int[]{Config.goat_bootsdefense.get(), Config.goat_legsdefense.get(), Config.goat_chestdefense.get(), Config.goat_helmDefense.get()},
												Config.goat_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.goat_toughness.get().floatValue(), (float) (Config.goat_knockbackResistance.get() * 0.1), RegisterItems.goat_hide.get());

	public final static IArmorMaterial hoglin = new ArmorMaterial(Constants.MOD_ID + ":hoglin",	(int) Math.round(Config.goat_durabilityValue.get() * 3), 	
												new int[]{Config.goat_bootsdefense.get()+1, Config.goat_legsdefense.get()+1, Config.goat_chestdefense.get()+1, Config.goat_helmDefense.get()+1},
												Config.goat_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.goat_toughness.get().floatValue(), (float) (Config.goat_knockbackResistance.get() * 0.1), RegisterItems.hoglin_leather.get());

	public final static IArmorMaterial naut = new ArmorMaterial(Constants.MOD_ID + ":naut",	Config.naut_durabilityValue.get(), 	
												new int[]{Config.naut_bootsdefense.get(), Config.naut_legsdefense.get(), Config.naut_chestdefense.get(), Config.naut_helmDefense.get()},
												Config.naut_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, Config.naut_toughness.get().floatValue(), (float) (Config.naut_knockbackResistance.get() * 0.1), Items.NAUTILUS_SHELL);											
												
    public final static IArmorMaterial fox = new ArmorMaterial(Constants.MOD_ID + ":fox",	Config.wolf_durabilityValue.get(), 	
    											new int[]{Config.wolf_bootsdefense.get(), Config.wolf_legsdefense.get(), Config.wolf_chestdefense.get(), Config.wolf_helmDefense.get()},
    											Config.wolf_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.wolf_toughness.get().floatValue(), (float) (Config.wolf_knockbackResistance.get() * 0.1), RegisterItems.fox_hide.get());
												
    
    public final static IArmorMaterial fox_fire = new ArmorMaterial(Constants.MOD_ID + ":fox_fire",	(int) Math.round(Config.wolf_durabilityValue.get() * 1.25), 	
												new int[]{Config.wolf_bootsdefense.get()+2, Config.wolf_legsdefense.get()+2, Config.wolf_chestdefense.get()+2, Config.wolf_helmDefense.get()+2},
												Config.wolf_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.wolf_toughness.get().floatValue(), (float) (Config.wolf_knockbackResistance.get() * 0.1), RegisterItems.fox_fire_hide.get());
												
    
    public final static IArmorMaterial u_stray = new ArmorMaterial(Constants.MOD_ID + ":u_stray",	(int) Math.round(Config.upgrade_durabilityValue.get() * 1.25), 	
												new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
												Config.bone_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), Items.BONE);
												
    public final static IArmorMaterial u_spiderPoison = new ArmorMaterial(Constants.MOD_ID + ":u_spider_poison",	(int) Math.round(Config.upgrade_durabilityValue.get() * 1.25), 	
												new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
												Config.spider_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.spider_poison_chitin.get());
												
    public final static IArmorMaterial u_spiderFermented = new ArmorMaterial(Constants.MOD_ID + ":u_spider_fermented",	(int) Math.round(Config.upgrade_durabilityValue.get() * 1.25), 	
												new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
												Config.spider_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.spider_fermented_chitin.get());
												
    public final static IArmorMaterial u_blaze = new ArmorMaterial(Constants.MOD_ID + ":u_blaze",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.blaze_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.blaze_glass.get());
												
    public final static IArmorMaterial u_phantom = new ArmorMaterial(Constants.MOD_ID + ":u_phantom",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.phantom_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), Items.PHANTOM_MEMBRANE);
												
    public final static IArmorMaterial u_shulker = new ArmorMaterial(Constants.MOD_ID + ":u_shulker",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.shulker_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), Items.SHULKER_SHELL);
												
    public final static IArmorMaterial u_guardian_elder = new ArmorMaterial(Constants.MOD_ID + ":u_guardian_elder",	(int) Math.round(Config.upgrade_durabilityValue.get() * 1.25), 	
												new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
												Config.guardian_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.guardian_skin.get());
												
    public final static IArmorMaterial u_shark = new ArmorMaterial(Constants.MOD_ID + ":u_shark",	(int) Math.round(Config.upgrade_durabilityValue.get() * 1.25), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.shark_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.thrasher_great_skin.get());
												
    public final static IArmorMaterial u_bear_polar = new ArmorMaterial(Constants.MOD_ID + ":u_bear_polar",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.bear_polar_leather.get());
												
    public final static IArmorMaterial u_bear_panda = new ArmorMaterial(Constants.MOD_ID + ":u_bear_panda",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.bear_panda_leather.get());
												
    public final static IArmorMaterial u_bear_brown = new ArmorMaterial(Constants.MOD_ID + ":u_bear_brown",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.bear_brown_leather.get());
												
    public final static IArmorMaterial u_bear_black = new ArmorMaterial(Constants.MOD_ID + ":u_bear_black",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.bear_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.bear_black_leather.get());
												
    public final static IArmorMaterial u_bee = new ArmorMaterial(Constants.MOD_ID + ":u_bee",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.bee_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.bee_chitin.get());
												
    public final static IArmorMaterial u_fox = new ArmorMaterial(Constants.MOD_ID + ":u_fox",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.wolf_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.fox_hide.get());
												
    public final static IArmorMaterial u_wither = new ArmorMaterial(Constants.MOD_ID + ":u_wither",	Config.wither_durabilityValue.get(), 	
    											new int[]{Config.wither_bootsdefense.get(), Config.wither_legsdefense.get(), Config.wither_chestdefense.get(), Config.wither_helmDefense.get()},
    											Config.wither_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, (float) Config.upgrade_toughness.get() + 1, (float) (Config.upgrade_knockbackResistance.get() * 0.1), Items.BONE);
												
	public final static IArmorMaterial u_shell = new ArmorMaterial(Constants.MOD_ID + ":u_shell",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											9 , SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1 + 0.3), Items.SCUTE);
												
	public final static IArmorMaterial u_goat = new ArmorMaterial(Constants.MOD_ID + ":u_goat",	Config.upgrade_durabilityValue.get(), 	
    											new int[]{Config.upgrade_bootsdefense.get(), Config.upgrade_legsdefense.get(), Config.upgrade_chestdefense.get(), Config.upgrade_helmDefense.get()},
    											Config.goat_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Config.upgrade_toughness.get().floatValue(), (float) (Config.upgrade_knockbackResistance.get() * 0.1), RegisterItems.goat_hide.get());
												
												
    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent equipSound;
        private final float toughness;
        float knockbackResistance;
        private final Item repairMaterial;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Item repairMaterial) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.equipSound = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }
        
        @Override
        public SoundEvent getSoundEvent() {
            return this.equipSound;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(this.repairMaterial);
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
		public float getKnockbackResistance() {
		      return this.knockbackResistance;
		}
    }
}

