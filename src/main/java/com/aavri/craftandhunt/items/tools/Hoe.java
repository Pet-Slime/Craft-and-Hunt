package com.aavri.craftandhunt.items.tools;

import java.util.Random;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;

public class Hoe extends HoeItem {

    public Hoe(IItemTier material, Properties properties) {
        super(material, 1,  -1F, properties.addToolType(ToolType.HOE, material.getHarvestLevel()));
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
 	   String item = stack.getItem().getTags().toString();
        if(item.contains("weapon_wither_attack")){
                target.addPotionEffect(new EffectInstance(Effect.get(20), 60, 1));
        }
        
        if(item.contains("weapon_fire_attack")){
            target.setFire(3);
        }
        
        if(item.contains("weapon_poison_attack")){
            target.addPotionEffect(new EffectInstance(Effect.get(19), 60, 0));
        }
        
        if(item.contains("weapon_weaken_attack")){
            target.addPotionEffect(new EffectInstance(Effect.get(18), 60, 0));
        }
        
        if(item.contains("weapon_float_attack")){
            target.addPotionEffect(new EffectInstance(Effect.get(25), 60, 1));
        }
        
        if(item.contains("weapon_bone_attack")){
        	Random random = new Random();
        	if (random.nextInt(2) == 0) {
        		target.attackEntityFrom(DamageSource.GENERIC, 1.0F);
        		target.playSound(SoundEvents.ENTITY_SKELETON_HURT, 0.3F, 0.6F);
        	}
        }

        return super.hitEntity(stack, target, attacker);
    }

}
