package com.aavri.craftandhunt.items.armor;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;

public class LavaArmor extends ArmorItem {


    public LavaArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
    }
    
    
   @Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
       if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("lava_walker") &&
	            player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("lava_walker") &&
	            player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("lava_walker") &&
	            player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("lava_walker")) {
    	   
    	   if (player.isInLava()) {
		   player.extinguish();
		   ISelectionContext iselectioncontext = ISelectionContext.forEntity(player);
		   player.fallDistance = 0;
		   if (iselectioncontext.func_216378_a(FlowingFluidBlock.LAVA_COLLISION_SHAPE, player.getPosition(), true) && !player.world.getFluidState(player.getPosition().up()).isTagged(FluidTags.LAVA)) {
			   player.onGround = true;
			   } else {
				   player.fallDistance = 0;
				   player.onGround = true;
				   player.setMotion(player.getMotion().add((player.getMotion().x * 1), 0.024D, (player.getMotion().z * 1)));
			   }
		   }
       }
   }
}
