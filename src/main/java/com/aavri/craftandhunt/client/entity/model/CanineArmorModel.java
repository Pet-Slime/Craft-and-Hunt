package com.aavri.craftandhunt.client.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class CanineArmorModel<T extends LivingEntity> extends BipedModel<T> {

    public ModelRenderer nose;
    public ModelRenderer ear_right;
    public ModelRenderer ear_left;
    public ModelRenderer ear_right_top;
    public ModelRenderer ear_left_top;

	public CanineArmorModel(float modelSize, EquipmentSlotType slot) {
        super(modelSize, 0, 64, 32);        
        this.textureWidth = 64;
        this.textureHeight = 32;    

        this.ear_right = new ModelRenderer(this, 0, 2);
        this.ear_right.setRotationPoint(-4.5F, -11.5F, -0.4F);
        this.ear_right.addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, 0.0F, -0.4F);
        this.ear_left = new ModelRenderer(this, 0, 2);
        this.ear_left.setRotationPoint(1.5F, -11.5F, -0.4F);
        this.ear_left.addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, 0.0F, -0.4F);
        this.ear_right_top = new ModelRenderer(this, 0, 0);
        this.ear_right_top.setRotationPoint(0.0F, -0.6F, -0.4F);
        this.ear_right_top.addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, 0.0F);
        this.ear_left_top = new ModelRenderer(this, 0, 0);
        this.ear_left_top.setRotationPoint(0.0F, -0.6F, -0.4F);
        this.ear_left_top.addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, 0.0F);
        this.nose = new ModelRenderer(this, 24, 1);
        this.nose.setRotationPoint(0.0F, -3.1F, -4.7F);
        this.nose.addBox(-2.0F, -2.0F, -3.8F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        
        
        this.bipedHead.addChild(this.ear_right);
        this.bipedHead.addChild(this.ear_left);
        this.ear_right.addChild(this.ear_right_top);
        this.ear_left.addChild(this.ear_left_top);
        this.bipedHead.addChild(this.nose);
    
        
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
