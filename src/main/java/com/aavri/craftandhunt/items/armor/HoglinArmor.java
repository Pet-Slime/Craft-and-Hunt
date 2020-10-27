package com.aavri.craftandhunt.items.armor;

import javax.annotation.Nullable;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.client.entity.CaHResources;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HoglinArmor extends ArmorItem {

    private String materialIn;

	public HoglinArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
        this.materialIn = materialIn.toString();
    }
    

    @SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
    @Nullable
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity LivingEntity, ItemStack itemStack, EquipmentSlotType slot, A _default) {
        return (A) CaHResources.getArmorModel(slot == EquipmentSlotType.LEGS ? 3 : 2, slot);
    }
    



	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer) {
	
		switch (materialIn) {
		case "hoglin" : if (slot == EquipmentSlotType.LEGS) {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/hoglin_layer_2.png").toString();
			} else {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/hoglin_layer_1.png").toString();
			}
		case "u_goat" : if (slot == EquipmentSlotType.LEGS) {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/hoglin_layer_2.png").toString();
			} else {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/hoglin_layer_1.png").toString();
			}
		}
		return null;
		
	}
	
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    

}
