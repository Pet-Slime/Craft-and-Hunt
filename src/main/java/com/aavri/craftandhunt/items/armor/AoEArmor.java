package com.aavri.craftandhunt.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.CraftandHunt;
import com.aavri.craftandhunt.client.entity.model.CanineArmorModel;
import com.aavri.craftandhunt.init.RegisterEffects;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AoEArmor extends ArmorItem {


    public AoEArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
    }
    
   @Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
  	PlayerEntity host = player;
   	if (host.isPotionActive(RegisterEffects.GUARDAINARMOR)) {
		double x = host.getPosX();
		double y = host.getPosY() + 1.5;
		double z = host.getPosZ();
		double range = 15;
		List<LivingEntity> target = host.world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
			for(LivingEntity X: target) {
				
				if (X != host) {
				X.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 200, 2));
				X.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 0));
				}
			}
		}
	}
}
