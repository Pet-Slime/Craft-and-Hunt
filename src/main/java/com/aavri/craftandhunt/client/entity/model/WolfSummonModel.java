package com.aavri.craftandhunt.client.entity.model;

import com.aavri.craftandhunt.entity.WolfSummonEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WolfSummonModel <T extends WolfSummonEntity> extends EntityModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer legBackLeft;
	private final ModelRenderer legBackRight;
	private final ModelRenderer legFrontLeft;
	private final ModelRenderer legFrontRight;
	private final ModelRenderer tail;

	public WolfSummonModel() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(1.0F, 13.5F, -5.0F);
		head.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.0F, true);
		head.setTextureOffset(16, 14).addBox(1.0F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		head.setTextureOffset(16, 14).addBox(-3.0F, -5.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		head.setTextureOffset(0, 10).addBox(-1.5F, -0.02F, -7.0F, 3.0F, 3.0F, 4.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(18, 14).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 9.0F, 6.0F, 0.0F, true);
		body.setTextureOffset(21, 0).addBox(-3.0F, -7.0F, -1.0F, 8.0F, 6.0F, 7.0F, 0.0F, true);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(2.5F, 16.0F, 7.0F);
		legBackLeft.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-0.5F, 16.0F, 7.0F);
		legBackRight.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(2.5F, 16.0F, -4.0F);
		legFrontLeft.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-0.5F, 16.0F, -4.0F);
		legFrontRight.setTextureOffset(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(1.0F, 12.0F, 7.0F);
		setRotationAngle(tail, 1.2654F, 0.0F, 0.0F);
		tail.setTextureOffset(9, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.tail.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;		
	}	
}
