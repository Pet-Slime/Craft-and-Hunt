package com.aavri.craftandhunt.potion;

import com.aavri.craftandhunt.init.RegisterEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class BasicCustomEffect extends Effect {

	public BasicCustomEffect(EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
	}
}