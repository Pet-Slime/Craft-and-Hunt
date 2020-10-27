package com.aavri.craftandhunt.potion;

import com.aavri.craftandhunt.event.DamageSourceNew;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BleedingEffect extends Effect {

	public BleedingEffect() {
		super(EffectType.HARMFUL, 0x390000);
	}

	@Override
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		if (!entityLivingBaseIn.isEntityUndead()) {
			entityLivingBaseIn.attackEntityFrom(DamageSourceNew.BLEEDING, 1.0F + amplifier);
		}
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return duration % 40 == 0;
	}

}