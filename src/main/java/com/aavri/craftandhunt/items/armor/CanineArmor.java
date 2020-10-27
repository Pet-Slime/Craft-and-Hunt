package com.aavri.craftandhunt.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.client.entity.CaHResources;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CanineArmor extends ArmorItem {

    private String materialIn;

	public CanineArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
        this.materialIn = materialIn.toString();
    }
    

    @SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
    @Nullable
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity LivingEntity, ItemStack itemStack, EquipmentSlotType slot, A _default) {
        return (A) CaHResources.getArmorModel(slot == EquipmentSlotType.LEGS ? 1 : 0, slot);
    }
    



	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer) {
	
		switch (materialIn) {
		case "wolf" : if (slot == EquipmentSlotType.LEGS) {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/wolf_layer_2.png").toString();
			} else {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/wolf_layer_1.png").toString();
			}
		case "fox" : if (slot == EquipmentSlotType.LEGS) {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/fox_layer_2.png").toString();
			} else {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/fox_layer_1.png").toString();
			}
		case "fox_fire" : if (slot == EquipmentSlotType.LEGS) {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/fox_fire_layer_2.png").toString();
			} else {
				return new ResourceLocation(Constants.MOD_ID, "textures/models/armor/fox_fire_layer_1.png").toString();
			}
		}
		return null;
		
	}
    
   @Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
  	PlayerEntity host = player;
  	
   	if (host.isPotionActive(RegisterEffects.PACKLEADER)) {
		double x = host.getPosX();
		double y = host.getPosY() + 1.5;
		double z = host.getPosZ();
			double range = 15;
		List<PlayerEntity> target = host.world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
			for(PlayerEntity X: target) {
				
				if (X != host) {
				X.addPotionEffect(new EffectInstance(Effect.get(5), 200, 0));
				}
			}
		}
	}
}
