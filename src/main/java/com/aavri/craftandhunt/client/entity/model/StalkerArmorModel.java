package com.aavri.craftandhunt.client.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class StalkerArmorModel<T extends LivingEntity> extends BipedModel<T> {
	
    public ModelRenderer rightArmUnder;
    public ModelRenderer antlerRightParent;
    public ModelRenderer antlerLeftParent;
    public ModelRenderer rribbonOne;
    public ModelRenderer lribbonTwo;
    public ModelRenderer rribbonTwo;
    public ModelRenderer rribbonThree;
    public ModelRenderer lribbonThree;
    public ModelRenderer lribbonOne;
    public ModelRenderer antlerRightBase;
    public ModelRenderer secondBase;
    public ModelRenderer pointyThing;
    public ModelRenderer pointyThing2;
    public ModelRenderer antlerRightBase_1;
    public ModelRenderer secondBase_1;
    public ModelRenderer pointyThing_1;
    public ModelRenderer poityThing2;
    public ModelRenderer bspikeLeftOne;
    public ModelRenderer bspikeRightOne;
    public ModelRenderer bspikeLeftTwo;
    public ModelRenderer bspikeRightTwo;
    public ModelRenderer bspikeLeftThree;
    public ModelRenderer bspikeRightThree;
    public ModelRenderer bodyUnder;


	public StalkerArmorModel(float modelSize, EquipmentSlotType slot) {
        super(modelSize, 0, 64, 64); 
        
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bspikeLeftTwo = new ModelRenderer(this, 44, 60);
        this.bspikeLeftTwo.setRotationPoint(1.25F, 7.0F, 2.5F);
        this.bspikeLeftTwo.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bspikeLeftTwo, 2.6179938779914944F, 0.0F, 0.0F);
        this.bspikeRightOne = new ModelRenderer(this, 44, 60);
        this.bspikeRightOne.setRotationPoint(-2.0F, 10.0F, 2.5F);
        this.bspikeRightOne.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bspikeRightOne, 2.6179938779914944F, 0.0F, 0.0F);
        this.bspikeRightTwo = new ModelRenderer(this, 44, 60);
        this.bspikeRightTwo.setRotationPoint(-2.25F, 7.0F, 2.5F);
        this.bspikeRightTwo.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bspikeRightTwo, 2.6179938779914944F, 0.0F, 0.0F);
        this.antlerRightBase = new ModelRenderer(this, 0, 55);
        this.antlerRightBase.setRotationPoint(8.15F, -0.8F, 1.1F);
        this.antlerRightBase.addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antlerRightBase, -0.1308996938995747F, 0.0F, 1.2304571226560024F);
        this.poityThing2 = new ModelRenderer(this, 28, 62);
        this.poityThing2.setRotationPoint(1.0F, 7.0F, -0.1F);
        this.poityThing2.addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(poityThing2, 0.0F, -0.23561944901923448F, 1.3032373205062326F);
        this.rribbonOne = new ModelRenderer(this, 41, 56);
        this.rribbonOne.setRotationPoint(8.2F, -9.0F, 1.7F);
        this.rribbonOne.addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 0.1F, 0.0F, 0.0F, 0.0F);
        this.secondBase = new ModelRenderer(this, 4, 55);
        this.secondBase.setRotationPoint(0.0F, 0.3F, 1.0F);
        this.secondBase.addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(secondBase, -2.792526803190927F, 0.0F, -0.27366763203903305F);
        this.secondBase_1 = new ModelRenderer(this, 24, 55);
        this.secondBase_1.setRotationPoint(0.0F, 0.3F, 1.0F);
        this.secondBase_1.addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(secondBase_1, -2.792526803190927F, 0.0F, 0.27366763203903305F);
        this.bspikeLeftThree = new ModelRenderer(this, 44, 60);
        this.bspikeLeftThree.setRotationPoint(1.5F, 4.0F, 2.5F);
        this.bspikeLeftThree.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bspikeLeftThree, 2.6179938779914944F, 0.0F, 0.0F);
        this.pointyThing = new ModelRenderer(this, 8, 60);
        this.pointyThing.setRotationPoint(1.0F, 7.0F, 0.0F);
        this.pointyThing.addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(pointyThing, 0.017453292519943295F, -0.19198621771937624F, 0.8609709519667358F);
        this.lribbonThree = new ModelRenderer(this, 41, 55);
        this.lribbonThree.setRotationPoint(-19.8F, -14.5F, -0.3F);
        this.lribbonThree.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.1F, 0.0F, 0.0F, 0.0F);
        this.rightArmUnder = new ModelRenderer(this, 48, 48);
        this.rightArmUnder.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.rightArmUnder.addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, 0.25F, 0.25F);
        this.lribbonOne = new ModelRenderer(this, 41, 55);
        this.lribbonOne.setRotationPoint(-6.9F, -9.1F, 1.1F);
        this.lribbonOne.addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 0.1F, 0.0F, 0.0F, 0.0F);
        this.lribbonTwo = new ModelRenderer(this, 41, 53);
        this.lribbonTwo.setRotationPoint(-13.9F, -10.9F, 1.4F);
        this.lribbonTwo.addBox(0.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.1F, 0.0F, 0.0F, 0.0F);
        this.antlerLeftParent = new ModelRenderer(this, 20, 50);
        this.antlerLeftParent.setRotationPoint(-4.0F, -11.05F, 0.5F);
        this.antlerLeftParent.addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antlerLeftParent, -0.12217304763960307F, 0.0F, -0.20943951023931953F);
        this.pointyThing2 = new ModelRenderer(this, 8, 62);
        this.pointyThing2.setRotationPoint(1.0F, 7.0F, -0.1F);
        this.pointyThing2.addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(pointyThing2, 0.0F, -0.23561944901923448F, 1.8383553330835603F);
        this.rribbonThree = new ModelRenderer(this, 41, 52);
        this.rribbonThree.setRotationPoint(15.3F, -11.5F, 1.3F);
        this.rribbonThree.addBox(0.0F, 0.0F, 0.0F, 1.0F, 12.0F, 0.1F, 0.0F, 0.0F, 0.0F);
        this.pointyThing_1 = new ModelRenderer(this, 28, 60);
        this.pointyThing_1.setRotationPoint(1.0F, 7.0F, 0.0F);
        this.pointyThing_1.addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(pointyThing_1, 0.017453292519943295F, -0.19198621771937624F, 2.280621701623057F);
        this.bodyUnder = new ModelRenderer(this, 3, 32);
        this.bodyUnder.mirror = true;
        this.bodyUnder.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyUnder.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, 0.25F, 0.25F);
        this.bspikeLeftOne = new ModelRenderer(this, 44, 60);
        this.bspikeLeftOne.setRotationPoint(1.0F, 10.0F, 2.5F);
        this.bspikeLeftOne.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bspikeLeftOne, 2.6179938779914944F, 0.0F, 0.0F);
        this.antlerRightParent = new ModelRenderer(this, 0, 50);
        this.antlerRightParent.setRotationPoint(3.0F, -11.05F, 0.5F);
        this.antlerRightParent.addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antlerRightParent, -0.12217304763960307F, 0.0F, 0.20943951023931953F);
        this.rribbonTwo = new ModelRenderer(this, 41, 60);
        this.rribbonTwo.setRotationPoint(11.7F, -10.0F, 2.0F);
        this.rribbonTwo.addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 0.1F, 0.0F, 0.0F, 0.0F);
        this.antlerRightBase_1 = new ModelRenderer(this, 20, 55);
        this.antlerRightBase_1.setRotationPoint(-7.15F, 0.2F, 1.1F);
        this.antlerRightBase_1.addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antlerRightBase_1, -0.1308996938995747F, 0.0F, -1.2304571226560024F);
        this.bspikeRightThree = new ModelRenderer(this, 44, 60);
        this.bspikeRightThree.setRotationPoint(-2.5F, 4.0F, 2.5F);
        this.bspikeRightThree.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bspikeRightThree, 2.6179938779914944F, 0.0F, 0.0F);
        this.bipedBody.addChild(this.bspikeLeftTwo);
        this.bipedBody.addChild(this.bspikeRightOne);
        this.bipedBody.addChild(this.bspikeRightTwo);
        this.antlerRightParent.addChild(this.antlerRightBase);
        this.secondBase_1.addChild(this.poityThing2);
        this.bipedHead.addChild(this.rribbonOne);
        this.antlerRightBase.addChild(this.secondBase);
        this.antlerRightBase_1.addChild(this.secondBase_1);
        this.bipedBody.addChild(this.bspikeLeftThree);
        this.secondBase.addChild(this.pointyThing);
        this.bipedHead.addChild(this.lribbonThree);
        this.bipedRightArm.addChild(this.rightArmUnder);
        this.bipedHead.addChild(this.lribbonOne);
        this.bipedHead.addChild(this.lribbonTwo);
        this.bipedHead.addChild(this.antlerLeftParent);
        this.secondBase.addChild(this.pointyThing2);
        this.bipedHead.addChild(this.rribbonThree);
        this.secondBase_1.addChild(this.pointyThing_1);
        this.bipedBody.addChild(this.bodyUnder);
        this.bipedBody.addChild(this.bspikeLeftOne);
        this.bipedHead.addChild(this.antlerRightParent);
        this.bipedHead.addChild(this.rribbonTwo);
        this.antlerLeftParent.addChild(this.antlerRightBase_1);
        this.bipedBody.addChild(this.bspikeRightThree);
    
        
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
