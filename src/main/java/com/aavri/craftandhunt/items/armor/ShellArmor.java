package com.aavri.craftandhunt.items.armor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.World;

public class ShellArmor extends ArmorItem {


    public ShellArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
    }
    
    @Override
 	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("shell_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("shell_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("shell_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("shell_armor")) {
        	if (player.isCrouching()) {
        		player.addPotionEffect(new EffectInstance(Effect.get(11), 20, 0));
        	}
        }
        
        if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("water_breather_armor") &&
        		!player.areEyesInFluid(FluidTags.WATER) ) {
        	player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        }
        
    }

}
