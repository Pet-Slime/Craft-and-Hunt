package com.aavri.craftandhunt.items.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class GuildedArmor extends ArmorItem {


    public GuildedArmor(IArmorMaterial materialIn, EquipmentSlotType slots, Properties properties) {
        super(materialIn, slots, properties);
    }
    
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }

}
