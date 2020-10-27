package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;

import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.Potions;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = Bus.MOD)
public class RegisterPotions {
	
	public static final Potion UNDEADIGNORE = new Potion(new EffectInstance(RegisterEffects.UNDEADIGNORE, 3600));
	public static final Potion LONG_UNDEADIGNORE = new Potion(new EffectInstance(RegisterEffects.UNDEADIGNORE, 9600));
	
	public static final Potion VAMPIRE = new Potion(new EffectInstance(RegisterEffects.VAMPIRE, 1800));
	public static final Potion LONG_VAMPIRE = new Potion(new EffectInstance(RegisterEffects.VAMPIRE, 4800));
	public static final Potion STRONG_VAMPIRE = new Potion(new EffectInstance(RegisterEffects.VAMPIRE, 400, 3));
	
	public static final Potion MAGIC_STRIKE = new Potion(new EffectInstance(RegisterEffects.MAGICBLADE, 1800));
	public static final Potion LONG_MAGIC_STRIKE = new Potion(new EffectInstance(RegisterEffects.MAGICBLADE, 4800));
	public static final Potion STRONG_MAGIC_STRIKE = new Potion(new EffectInstance(RegisterEffects.MAGICBLADE, 400, 1));
	
	public static final Potion POISON_STRIKE = new Potion(new EffectInstance(RegisterEffects.POISONBLADE, 1800));
	public static final Potion LONG_POISON_STRIKE = new Potion(new EffectInstance(RegisterEffects.POISONBLADE, 4800));
	public static final Potion STRONG_POISON_STRIKE = new Potion(new EffectInstance(RegisterEffects.POISONBLADE, 400, 1));
	
	public static final Potion WITHER_STRIKE = new Potion(new EffectInstance(RegisterEffects.WITHERBLADE, 1800));
	public static final Potion LONG_WITHER_STRIKE = new Potion(new EffectInstance(RegisterEffects.WITHERBLADE, 4800));
	public static final Potion STRONG_WITHER_STRIKE = new Potion(new EffectInstance(RegisterEffects.WITHERBLADE, 400, 1));
	
	public static final Potion FIRE_STRIKE = new Potion(new EffectInstance(RegisterEffects.FIREBLADE, 1800));
	public static final Potion LONG_FIRE_STRIKE = new Potion(new EffectInstance(RegisterEffects.FIREBLADE, 4800));
	public static final Potion STRONG_FIRE_STRIKE = new Potion(new EffectInstance(RegisterEffects.FIREBLADE, 400, 1));
	
	public static final Potion BUGIGNORE = new Potion(new EffectInstance(RegisterEffects.BUGIGNORE, 3600));
	public static final Potion LONG_BUGIGNORE = new Potion(new EffectInstance(RegisterEffects.BUGIGNORE, 9600));
	
	public static final Potion POISONRESISTANCE = new Potion(new EffectInstance(RegisterEffects.POISONRESIST, 3600));
	public static final Potion LONG_POISONRESISTANCE = new Potion(new EffectInstance(RegisterEffects.POISONRESIST, 9600));
	
	public static final Potion RANGESTRENGTH = new Potion(new EffectInstance(RegisterEffects.RANGESTRENGTH, 3600));
	public static final Potion LONG_RANGESTRENGTH = new Potion(new EffectInstance(RegisterEffects.RANGESTRENGTH, 9600));
	public static final Potion STRONG_RANGESTRNGTH = new Potion(new EffectInstance(RegisterEffects.RANGESTRENGTH, 1800, 1));
	
	public static final Potion GOATSTRENGTH = new Potion(new EffectInstance(RegisterEffects.GOATSTRENGTH, 3600));
	public static final Potion LONG_GOATSTRENGTH = new Potion(new EffectInstance(RegisterEffects.GOATSTRENGTH, 9600));
	public static final Potion STRONG_GOATSTRENGTH = new Potion(new EffectInstance(RegisterEffects.GOATSTRENGTH, 1800, 1));
	

	public static final Potion WITHER = new Potion(new EffectInstance(Effects.WITHER, 900));
	public static final Potion LONG_WITHER = new Potion(new EffectInstance(Effects.WITHER, 1800));
	public static final Potion STRONG_WITHER = new Potion(new EffectInstance(Effects.WITHER, 432, 1));
	public static final Potion WITHERRESISTANCE = new Potion(new EffectInstance(RegisterEffects.WITHERRESIST, 3600));
	public static final Potion LONG_WITHERRESISTANCE = new Potion(new EffectInstance(RegisterEffects.WITHERRESIST, 9600));
	

	


    @SubscribeEvent
    public static void register(Register<Potion> event) {
        IForgeRegistry<Potion> registry = event.getRegistry();
       
        UNDEADIGNORE.setRegistryName(Constants.MOD_ID, "undead_ignore");
        registry.register(UNDEADIGNORE);
        LONG_UNDEADIGNORE.setRegistryName(Constants.MOD_ID, "long_undead_ignore");
        registry.register(LONG_UNDEADIGNORE);
        
		BUGIGNORE.setRegistryName(Constants.MOD_ID, "bug_ignore");
        registry.register(BUGIGNORE);
        LONG_BUGIGNORE.setRegistryName(Constants.MOD_ID, "long_bug_ignore");
        registry.register(LONG_BUGIGNORE);
        
		POISONRESISTANCE.setRegistryName(Constants.MOD_ID, "poison_resistance");
        registry.register(POISONRESISTANCE);
        LONG_POISONRESISTANCE.setRegistryName(Constants.MOD_ID, "long_poison_resistance");
        registry.register(LONG_POISONRESISTANCE);
        
        WITHER.setRegistryName(Constants.MOD_ID, "wither");
        registry.register(WITHER);
        LONG_WITHER.setRegistryName(Constants.MOD_ID, "long_wither");
        registry.register(LONG_WITHER);
        STRONG_WITHER.setRegistryName(Constants.MOD_ID, "strong_wither");
        registry.register(STRONG_WITHER);
        
        WITHERRESISTANCE.setRegistryName(Constants.MOD_ID, "wither_resistance");
        registry.register(WITHERRESISTANCE); 
        LONG_WITHERRESISTANCE.setRegistryName(Constants.MOD_ID, "long_wither_resistance");
        registry.register(LONG_WITHERRESISTANCE);
        
        VAMPIRE.setRegistryName(Constants.MOD_ID, "vampire");
        registry.register(VAMPIRE);
        LONG_VAMPIRE.setRegistryName(Constants.MOD_ID, "long_vampire");
        registry.register(LONG_VAMPIRE);
        STRONG_VAMPIRE.setRegistryName(Constants.MOD_ID, "strong_vampire");
        registry.register(STRONG_VAMPIRE);
        
        MAGIC_STRIKE.setRegistryName(Constants.MOD_ID, "magic_strike");
        registry.register(MAGIC_STRIKE);   
        LONG_MAGIC_STRIKE.setRegistryName(Constants.MOD_ID, "long_magic_strike");
        registry.register(LONG_MAGIC_STRIKE);
        STRONG_MAGIC_STRIKE.setRegistryName(Constants.MOD_ID, "strong_magic_strike");
        registry.register(STRONG_MAGIC_STRIKE);
        
		POISON_STRIKE.setRegistryName(Constants.MOD_ID, "poison_strike");
        registry.register(POISON_STRIKE);
        LONG_POISON_STRIKE.setRegistryName(Constants.MOD_ID, "long_poison_strike");
        registry.register(LONG_POISON_STRIKE);
        STRONG_POISON_STRIKE.setRegistryName(Constants.MOD_ID, "strong_poison_strike");
        registry.register(STRONG_POISON_STRIKE);
        
		WITHER_STRIKE.setRegistryName(Constants.MOD_ID, "wither_strike");
        registry.register(WITHER_STRIKE);
        LONG_WITHER_STRIKE.setRegistryName(Constants.MOD_ID, "long_wither_strike");
        registry.register(LONG_WITHER_STRIKE);
        STRONG_WITHER_STRIKE.setRegistryName(Constants.MOD_ID, "strong_wither_strike");
        registry.register(STRONG_WITHER_STRIKE);
        
		FIRE_STRIKE.setRegistryName(Constants.MOD_ID, "fire_strike");
        registry.register(FIRE_STRIKE);
        LONG_FIRE_STRIKE.setRegistryName(Constants.MOD_ID, "long_fire_strike");
        registry.register(LONG_FIRE_STRIKE);
        STRONG_FIRE_STRIKE.setRegistryName(Constants.MOD_ID, "strong_fire_strike");
        registry.register(STRONG_FIRE_STRIKE);
        
        RANGESTRENGTH.setRegistryName(Constants.MOD_ID, "rangestrength");
        registry.register(RANGESTRENGTH);
        LONG_RANGESTRENGTH.setRegistryName(Constants.MOD_ID, "long_rangestrength");
        registry.register(LONG_RANGESTRENGTH);
        STRONG_RANGESTRNGTH.setRegistryName(Constants.MOD_ID, "strong_rangestrength");
        registry.register(STRONG_RANGESTRNGTH);
        
        GOATSTRENGTH.setRegistryName(Constants.MOD_ID, "goatstrength");
        registry.register(GOATSTRENGTH);
        LONG_GOATSTRENGTH.setRegistryName(Constants.MOD_ID, "long_goatstrength");
        registry.register(LONG_GOATSTRENGTH);
        STRONG_GOATSTRENGTH.setRegistryName(Constants.MOD_ID, "strong_goatstrength");
        registry.register(STRONG_GOATSTRENGTH);
      
        PotionBrewing.addMix(Potions.AWKWARD, Items.ROTTEN_FLESH, RegisterPotions.UNDEADIGNORE);
        PotionBrewing.addMix(RegisterPotions.UNDEADIGNORE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_UNDEADIGNORE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterItems.bee_chitin.get(), RegisterPotions.BUGIGNORE);
        PotionBrewing.addMix(Potions.AWKWARD, RegisterItems.spider_chitin.get(), RegisterPotions.BUGIGNORE);
        PotionBrewing.addMix(Potions.AWKWARD, RegisterItems.spider_fermented_chitin.get(), RegisterPotions.BUGIGNORE);
        PotionBrewing.addMix(Potions.AWKWARD, RegisterItems.spider_poison_chitin.get(), RegisterPotions.BUGIGNORE);
        PotionBrewing.addMix(RegisterPotions.BUGIGNORE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_BUGIGNORE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterOffhand.witch_book.get(), RegisterPotions.MAGIC_STRIKE);
        PotionBrewing.addMix(RegisterPotions.MAGIC_STRIKE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_MAGIC_STRIKE);
        PotionBrewing.addMix(RegisterPotions.MAGIC_STRIKE, Items.REDSTONE, RegisterPotions.STRONG_MAGIC_STRIKE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterOffhand.venom_sack.get(), RegisterPotions.POISON_STRIKE);
        PotionBrewing.addMix(RegisterPotions.POISON_STRIKE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_POISON_STRIKE);
        PotionBrewing.addMix(RegisterPotions.POISON_STRIKE, Items.REDSTONE, RegisterPotions.STRONG_POISON_STRIKE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterOffhand.wither_spine.get(), RegisterPotions.WITHER_STRIKE);
        PotionBrewing.addMix(Potions.AWKWARD, Items.WITHER_SKELETON_SKULL, RegisterPotions.WITHER_STRIKE);
        PotionBrewing.addMix(RegisterPotions.WITHER_STRIKE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_WITHER_STRIKE);
        PotionBrewing.addMix(RegisterPotions.WITHER_STRIKE, Items.REDSTONE, RegisterPotions.STRONG_WITHER_STRIKE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterOffhand.fire_heart.get(), RegisterPotions.FIRE_STRIKE);
        PotionBrewing.addMix(RegisterPotions.FIRE_STRIKE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_FIRE_STRIKE);
        PotionBrewing.addMix(RegisterPotions.FIRE_STRIKE, Items.REDSTONE, RegisterPotions.STRONG_FIRE_STRIKE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterOffhand.vampire_fang.get(), RegisterPotions.VAMPIRE);
        PotionBrewing.addMix(RegisterPotions.VAMPIRE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_VAMPIRE);
        PotionBrewing.addMix(RegisterPotions.VAMPIRE, Items.REDSTONE, RegisterPotions.STRONG_VAMPIRE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterItems.stray_cloth.get(), RegisterPotions.RANGESTRENGTH);
        PotionBrewing.addMix(RegisterPotions.RANGESTRENGTH, Items.GLOWSTONE_DUST, RegisterPotions.LONG_RANGESTRENGTH);
        PotionBrewing.addMix(RegisterPotions.RANGESTRENGTH, Items.REDSTONE, RegisterPotions.STRONG_RANGESTRNGTH);

        PotionBrewing.addMix(Potions.AWKWARD, Items.NETHER_STAR, RegisterPotions.WITHER);
        PotionBrewing.addMix(RegisterPotions.WITHER, Items.GLOWSTONE_DUST, RegisterPotions.LONG_WITHER);
        PotionBrewing.addMix(RegisterPotions.WITHER, Items.REDSTONE, RegisterPotions.STRONG_WITHER);

        PotionBrewing.addMix(RegisterPotions.WITHER, Items.CHARCOAL, RegisterPotions.WITHERRESISTANCE);
        PotionBrewing.addMix(RegisterPotions.WITHERRESISTANCE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_WITHERRESISTANCE);
        PotionBrewing.addMix(RegisterPotions.LONG_WITHER, Items.CHARCOAL, RegisterPotions.LONG_WITHERRESISTANCE);    

        PotionBrewing.addMix(Potions.POISON, Items.CHARCOAL, RegisterPotions.POISONRESISTANCE);
        PotionBrewing.addMix(RegisterPotions.POISONRESISTANCE, Items.GLOWSTONE_DUST, RegisterPotions.LONG_POISONRESISTANCE);
        PotionBrewing.addMix(Potions.LONG_POISON, Items.CHARCOAL, RegisterPotions.LONG_POISONRESISTANCE);
        
        PotionBrewing.addMix(Potions.AWKWARD, RegisterItems.goat_hide.get(), RegisterPotions.GOATSTRENGTH);
        PotionBrewing.addMix(RegisterPotions.GOATSTRENGTH, Items.GLOWSTONE_DUST, RegisterPotions.LONG_GOATSTRENGTH);
        PotionBrewing.addMix(RegisterPotions.GOATSTRENGTH, Items.REDSTONE, RegisterPotions.STRONG_GOATSTRENGTH);
        
        PotionBrewing.addMix(Potions.HARMING, Items.CHARCOAL, Potions.HEALING);
        PotionBrewing.addMix(Potions.STRONG_HARMING, Items.CHARCOAL, Potions.STRONG_HEALING);
        PotionBrewing.addMix(Potions.SLOWNESS, Items.CHARCOAL, Potions.SWIFTNESS);
        PotionBrewing.addMix(Potions.LONG_SLOWNESS, Items.CHARCOAL, Potions.LONG_SWIFTNESS);
        PotionBrewing.addMix(Potions.INVISIBILITY, Items.CHARCOAL, Potions.NIGHT_VISION);
        PotionBrewing.addMix(Potions.LONG_INVISIBILITY, Items.CHARCOAL, Potions.LONG_NIGHT_VISION);
        PotionBrewing.addMix(Potions.STRENGTH, Items.FERMENTED_SPIDER_EYE, Potions.WEAKNESS);
        PotionBrewing.addMix(Potions.LONG_STRENGTH, Items.FERMENTED_SPIDER_EYE, Potions.LONG_WEAKNESS);
        PotionBrewing.addMix(Potions.WEAKNESS, Items.CHARCOAL, Potions.STRENGTH);
        PotionBrewing.addMix(Potions.LONG_WEAKNESS, Items.CHARCOAL, Potions.LONG_STRENGTH);
    }
}