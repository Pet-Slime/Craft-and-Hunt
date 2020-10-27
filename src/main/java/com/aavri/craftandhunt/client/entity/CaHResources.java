package com.aavri.craftandhunt.client.entity;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.client.entity.model.HoglinArmorModel;
import com.aavri.craftandhunt.client.entity.model.StalkerArmorModel;
import com.aavri.craftandhunt.client.entity.model.CanineArmorModel;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CaHResources {
	
	public static final String PREFIX_MOD = Constants.MOD_ID + ":";
	

	public static final String MODEL_SPEAR_TEST = PREFIX_MOD + "textures/entity/spears/spear_test.png";
	
	
    @SuppressWarnings("rawtypes")
	@OnlyIn(Dist.CLIENT)
    public static Object getArmorModel(int armorId, EquipmentSlotType slot) {
        switch (armorId) {
            case 0:
                return new CanineArmorModel(0.5F, slot);
            case 1:
                return new CanineArmorModel(0.3F, slot);
            case 2:
                return new HoglinArmorModel(0.5F, slot);
            case 3:
                return new HoglinArmorModel(0.3F, slot);
            case 4:
                return new StalkerArmorModel(0.5F, slot);
            case 5:
                return new StalkerArmorModel(0.3F, slot);
        }
        return null;
    }

}
