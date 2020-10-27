package com.aavri.craftandhunt.client.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class ArmorModel extends BipedModel<LivingEntity> {
	protected final EquipmentSlotType slot;

	public ArmorModel(EquipmentSlotType slot) {
		super(1);
		this.slot = slot;
	}

	

	protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}