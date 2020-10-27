package com.aavri.craftandhunt.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class WitherResistEffect extends Effect {

	public WitherResistEffect() {
		super(EffectType.BENEFICIAL, 13293016);
	}

	@Override
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn.isPotionActive(Effects.WITHER)) {
			entityLivingBaseIn.removePotionEffect(Effects.WITHER);
		}
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}

}