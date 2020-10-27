package com.aavri.craftandhunt.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class PoisonResistEffect extends Effect {

	public PoisonResistEffect() {
		super(EffectType.BENEFICIAL, 7745939);
	}

	@Override
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn.isPotionActive(Effects.POISON)) {
			entityLivingBaseIn.removePotionEffect(Effects.POISON);
		}
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}

}