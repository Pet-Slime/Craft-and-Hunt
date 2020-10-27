package com.aavri.craftandhunt.client.entity.model;

import java.util.function.Function;

import com.aavri.craftandhunt.entity.CustomSpearEntity;
import com.google.common.collect.ImmutableList;
// Mojang stuff
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
// Minecraft stuff
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
// Forge stuff
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CustomSpearModel extends SegmentedModel<CustomSpearEntity> {
    public static ResourceLocation TEXTURE;
	private final ModelRenderer mainbody;
	private final ModelRenderer sidebody;
	private final ModelRenderer tophead;
	private final ModelRenderer bottomhead;

    public CustomSpearModel() {
        super((Function<ResourceLocation, RenderType>)RenderType::getEntitySolid);
		textureWidth = 32;
		textureHeight = 32;

		mainbody = new ModelRenderer(this);
		mainbody.setRotationPoint(-0.35F, -1.3F, -0.3F);
		setRotationAngle(mainbody, 0.0F, 1.5708F, 0.7854F);
		mainbody.setTextureOffset(0, 28).addBox(-0.65F, -2.4574F, -2.4574F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mainbody.setTextureOffset(6, 24).addBox(-0.65F, 9.5426F, 9.5426F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mainbody.setTextureOffset(10, 22).addBox(-0.65F, 7.5426F, 7.5426F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mainbody.setTextureOffset(14, 20).addBox(-0.65F, 5.5426F, 5.5426F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mainbody.setTextureOffset(18, 18).addBox(-0.65F, 3.5426F, 3.5426F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mainbody.setTextureOffset(22, 16).addBox(-0.65F, 1.5426F, 1.5426F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mainbody.setTextureOffset(26, 14).addBox(-0.65F, -0.4574F, -0.4574F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		sidebody = new ModelRenderer(this);
		sidebody.setRotationPoint(1.35F, 24.3208F, -2.1645F);
		mainbody.addChild(sidebody);
		sidebody.setTextureOffset(0, 14).addBox(-2.0F, -14.7782F, 10.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(4, 14).addBox(-2.0F, -16.7782F, 8.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(8, 14).addBox(-2.0F, -18.7782F, 6.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(12, 14).addBox(-2.0F, -20.7782F, 4.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(16, 14).addBox(-2.0F, -22.7782F, 2.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(0, 12).addBox(-2.0F, -22.7782F, 1.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(28, 22).addBox(-2.0F, -23.7782F, 3.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(5, 12).addBox(-2.0F, -24.7782F, 3.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(28, 24).addBox(-2.0F, -21.7782F, 5.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(28, 26).addBox(-2.0F, -19.7782F, 7.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(28, 28).addBox(-2.0F, -17.7782F, 9.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sidebody.setTextureOffset(28, 30).addBox(-2.0F, -15.7782F, 11.7071F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tophead = new ModelRenderer(this);
		tophead.setRotationPoint(1.35F, 24.3208F, -2.1645F);
		mainbody.addChild(tophead);
		tophead.setTextureOffset(0, 24).addBox(-2.0F, -24.7782F, -0.2929F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		tophead.setTextureOffset(0, 19).addBox(-2.0F, -24.7782F, 0.7071F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		bottomhead = new ModelRenderer(this);
		bottomhead.setRotationPoint(1.35F, 24.3208F, -2.1645F);
		mainbody.addChild(bottomhead);
		bottomhead.setTextureOffset(14, 27).addBox(-2.0F, -25.7782F, 1.7071F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bottomhead.setTextureOffset(6, 28).addBox(-2.0F, -26.7782F, 1.7071F, 1.0F, 1.0F, 3.0F, 0.0F, false);
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
            this.mainbody.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(mainbody);
    }

    @Override
    public void setRotationAngles(CustomSpearEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
