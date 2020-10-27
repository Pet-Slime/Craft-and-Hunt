package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.potion.BasicCustomEffect;
import com.aavri.craftandhunt.potion.BleedingEffect;
import com.aavri.craftandhunt.potion.PoisonResistEffect;
import com.aavri.craftandhunt.potion.WitherResistEffect;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = Bus.MOD)
public class RegisterEffects {
	
	public static final Effect VAMPIRE = new BasicCustomEffect(EffectType.BENEFICIAL, 13458603);
	public static final Effect CORPSEEATER = new BasicCustomEffect(EffectType.BENEFICIAL, 13458603);
	public static final Effect MAGICBLADE = new BasicCustomEffect(EffectType.BENEFICIAL, 8171462);
	public static final Effect POISONBLADE = new BasicCustomEffect(EffectType.BENEFICIAL, 5149489);
	public static final Effect WITHERBLADE = new BasicCustomEffect(EffectType.BENEFICIAL, 3484199);
	public static final Effect FIREBLADE = new BasicCustomEffect(EffectType.BENEFICIAL, 14981690);
	public static final Effect EXPHEAL = new BasicCustomEffect(EffectType.BENEFICIAL, 8171462);
	public static final Effect UNDEADIGNORE = new BasicCustomEffect(EffectType.BENEFICIAL, 1950417);
	public static final Effect PHANTOMIGNORE = new BasicCustomEffect(EffectType.BENEFICIAL, 1950417);
	public static final Effect PIGLINIGNORE = new BasicCustomEffect(EffectType.BENEFICIAL, 1950417);
	public static final Effect BUGIGNORE = new BasicCustomEffect(EffectType.BENEFICIAL, 1950417);
	public static final Effect ENTITYKNOW = new BasicCustomEffect(EffectType.HARMFUL, 5149489);
	public static final Effect INKYDEFENSE = new BasicCustomEffect(EffectType.BENEFICIAL, 8171462);
	public static final Effect THIEFBLADE = new BasicCustomEffect(EffectType.BENEFICIAL, 8171462);
	public static final Effect ENTITYBLIND = new BasicCustomEffect(EffectType.HARMFUL, 2039587);
	public static final Effect PACKLEADER = new BasicCustomEffect(EffectType.BENEFICIAL, 8356754);
	public static final Effect BEETALION = new BasicCustomEffect(EffectType.BENEFICIAL, 8356754);
	public static final Effect GUARDAINARMOR = new BasicCustomEffect(EffectType.BENEFICIAL, 8171462);
	public static final Effect SEEDCLUSTER = new BasicCustomEffect(EffectType.HARMFUL, 5149489);
	public static final Effect KILLSUMMON = new BasicCustomEffect(EffectType.HARMFUL, 5149489);
	public static final Effect RANGESTRENGTH = new BasicCustomEffect(EffectType.BENEFICIAL, 5149489);
	public static final Effect GOATSTRENGTH = new BasicCustomEffect(EffectType.BENEFICIAL, 5149489).addAttributesModifier(Attributes.ATTACK_DAMAGE, "411D7064-6A60-4F59-8ABE-C2C23A6DD7A9",  1.5D, AttributeModifier.Operation.ADDITION).addAttributesModifier(Attributes.ATTACK_KNOCKBACK, "984D7064-6A60-4F59-8ABE-C2C23A6DD7A9",  5.0D, AttributeModifier.Operation.ADDITION);
	

	public static final Effect BLEED = new BleedingEffect();
	public static final Effect POISONRESIST = new PoisonResistEffect();
	public static final Effect WITHERRESIST = new WitherResistEffect();
	
	
    @SubscribeEvent
    public static void register(Register<Effect> event) {
        IForgeRegistry<Effect> registry = event.getRegistry();
       
        
        BLEED.setRegistryName(Constants.MOD_ID, "bleed");
        registry.register(BLEED);
        VAMPIRE.setRegistryName(Constants.MOD_ID, "vampire");
        registry.register(VAMPIRE);
        CORPSEEATER.setRegistryName(Constants.MOD_ID, "corpse_eater");
        registry.register(CORPSEEATER);
        MAGICBLADE.setRegistryName(Constants.MOD_ID, "magic_blade");
        registry.register(MAGICBLADE);
        POISONBLADE.setRegistryName(Constants.MOD_ID, "poison_blade");
        registry.register(POISONBLADE);
        WITHERBLADE.setRegistryName(Constants.MOD_ID, "wither_blade");
        registry.register(WITHERBLADE);
        FIREBLADE.setRegistryName(Constants.MOD_ID, "fire_blade");
        registry.register(FIREBLADE);
        EXPHEAL.setRegistryName(Constants.MOD_ID, "exp_heal");
        registry.register(EXPHEAL);
        UNDEADIGNORE.setRegistryName(Constants.MOD_ID, "undead_ignore");
        registry.register(UNDEADIGNORE);
        PIGLINIGNORE.setRegistryName(Constants.MOD_ID, "piglin_ignore");
        registry.register(PIGLINIGNORE);
        ENTITYKNOW.setRegistryName(Constants.MOD_ID, "entity_know");
        registry.register(ENTITYKNOW);
        INKYDEFENSE.setRegistryName(Constants.MOD_ID, "inky_defense");
        registry.register(INKYDEFENSE);
        THIEFBLADE.setRegistryName(Constants.MOD_ID, "thief_blade");
        registry.register(THIEFBLADE);
        ENTITYBLIND.setRegistryName(Constants.MOD_ID, "entity_blind");
        registry.register(ENTITYBLIND);
        PHANTOMIGNORE.setRegistryName(Constants.MOD_ID, "phantom_ignore");
        registry.register(PHANTOMIGNORE);
        BUGIGNORE.setRegistryName(Constants.MOD_ID, "bug_ignore");
        registry.register(BUGIGNORE);
        POISONRESIST.setRegistryName(Constants.MOD_ID, "poison_resistance");
        registry.register(POISONRESIST);
        WITHERRESIST.setRegistryName(Constants.MOD_ID, "wither_resistance");
        registry.register(WITHERRESIST);
        PACKLEADER.setRegistryName(Constants.MOD_ID, "pack_leader");
        registry.register(PACKLEADER);
        GUARDAINARMOR.setRegistryName(Constants.MOD_ID, "guardian_armor");
        registry.register(GUARDAINARMOR);
        SEEDCLUSTER.setRegistryName(Constants.MOD_ID, "seed_cluster");
        registry.register(SEEDCLUSTER);
        RANGESTRENGTH.setRegistryName(Constants.MOD_ID, "range_strength");
        registry.register(RANGESTRENGTH);
        GOATSTRENGTH.setRegistryName(Constants.MOD_ID, "goat_strength");
        registry.register(GOATSTRENGTH);
        KILLSUMMON.setRegistryName(Constants.MOD_ID, "kill_summon");
        registry.register(KILLSUMMON);
        BEETALION.setRegistryName(Constants.MOD_ID, "beetalion");
        registry.register(BEETALION);
    }
}