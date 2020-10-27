package com.aavri.craftandhunt.items.armor;

import com.aavri.craftandhunt.Constants;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class StealthArmor extends ArmorItem {
	
	public Boolean hidden = false;
	private String materialIn;


    public StealthArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
        this.materialIn = materialIn.toString();
    }
    
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer) {
		if (hidden) {
			if (slot == EquipmentSlotType.LEGS) {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/hidden_layer_2.png").toString();
			} else {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/hidden_layer_1.png").toString();
			}			
		} else {
			if (slot == EquipmentSlotType.LEGS) {
				return this.getLegsMaterial();
			} else {
				return this.getMaterial();
			}
		}	
	}
	
	
	public String getLegsMaterial() {
		switch (materialIn) {
		case "silverfish" : return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/silverfish_layer_2.png").toString();
		case "endermite" : return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/endermite_layer_2.png").toString();
		}
		return null;
	}
	
	public String getMaterial() {
		switch (materialIn) {
		case "silverfish" : return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/silverfish_layer_1.png").toString();
		case "endermite" : return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/endermite_layer_1.png").toString();
		}
		return null;
	}
    
    
    @Override
 	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("stealth_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("stealth_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("stealth_armor") &&
	            player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("stealth_armor")) {
        	if (player.isCrouching()) {
        		this.hidden = true;
        		player.setInvisible(true);
        	} else {
        		this.hidden = false;
        		player.setInvisible(false);
        	}
        } else {
        	this.hidden = false;
    		player.setInvisible(false);
        }
    }
}
