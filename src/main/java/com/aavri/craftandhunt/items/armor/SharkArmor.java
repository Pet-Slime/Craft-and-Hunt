package com.aavri.craftandhunt.items.armor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SharkArmor extends ArmorItem {


    public SharkArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
    }
    
    @Override
 	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("shark_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("shark_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("shark_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("shark_armor")) {
        	if (player.isSwimming()) {
        		player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 0));
        		player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
        	}
        }
    }
}
