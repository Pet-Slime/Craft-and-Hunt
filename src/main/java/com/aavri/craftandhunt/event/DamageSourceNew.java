package com.aavri.craftandhunt.event;

import net.minecraft.util.DamageSource;

public class DamageSourceNew extends DamageSource {

	public DamageSourceNew(String damageTypeIn) {
		super(damageTypeIn);
		// TODO Auto-generated constructor stub
	}
	
	public static final DamageSource KILLSUMMON = (new DamageSource("kill_summon")).setDamageBypassesArmor().setDamageIsAbsolute();

	public static final DamageSource BLEEDING = (new DamageSource("bleeding")).setDamageBypassesArmor();

}
