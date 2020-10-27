package com.aavri.craftandhunt.client.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;


public class HoglinArmorModel<T extends LivingEntity> extends BipedModel<T> {
	

    public ModelRenderer tusk_base_right;
    public ModelRenderer tusk_base_left;
    public ModelRenderer tusk_poke_right;
    public ModelRenderer tusk_poke_left;
    
    

	public HoglinArmorModel(float modelSize, EquipmentSlotType slot) {
        super(modelSize, 0, 64, 32);        

        
        this.textureWidth = 64;
        this.textureHeight = 32;    
        
        this.tusk_base_left = new ModelRenderer(this, 0, 0);
        this.tusk_base_left.setRotationPoint(1.2F, -1.7F, -5.7F);
        this.tusk_base_left.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.1F, 0.1F, 0.1F);
        this.tusk_poke_left = new ModelRenderer(this, 0, 3);
        this.tusk_poke_left.setRotationPoint(1.2F, -1.1F, 0.0F);
        this.tusk_poke_left.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.1F, 0.2F, 0.1F);
        this.tusk_poke_right = new ModelRenderer(this, 0, 2);
        this.tusk_poke_right.setRotationPoint(-1.2F, -2.2F, 0.0F);
        this.tusk_poke_right.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.1F, 0.3F, 0.1F);
        this.tusk_base_right = new ModelRenderer(this, 0, 0);
        this.tusk_base_right.setRotationPoint(-2.2F, -1.7F, -5.7F);
        this.tusk_base_right.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.1F, 0.1F, 0.1F);
        

        this.tusk_base_left.addChild(this.tusk_poke_left);
        this.tusk_base_right.addChild(this.tusk_poke_right);
        this.bipedHead.addChild(this.tusk_base_left);
        this.bipedHead.addChild(this.tusk_base_right);
        
        
    }
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	@Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityIn instanceof ArmorStandEntity) {
            ArmorStandEntity entityarmorstand = (ArmorStandEntity) entityIn;
            this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
            this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
            this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
            this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
            this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
            this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
            this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
            this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
            this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
            this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
            this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
            this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
            this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
            this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
            this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
            this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
            this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
            this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
            this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
            this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
            this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
            this.bipedHeadwear.copyModelAngles(this.bipedHead);
        } else {
            super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }
    }
}
