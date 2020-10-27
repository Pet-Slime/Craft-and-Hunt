package com.aavri.craftandhunt.client.entity.render;

import com.aavri.craftandhunt.client.entity.model.CustomSpearModel;
import com.aavri.craftandhunt.entity.CustomSpearEntity;
//Mojang stuff
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

//Minecraft stuff
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class CustomSpearRenderer extends EntityRenderer<CustomSpearEntity> implements IEntityRenderer<CustomSpearEntity, CustomSpearModel> {
    public ResourceLocation SPEAR_TEXTURE;
    private CustomSpearModel model;

    protected CustomSpearRenderer(EntityRendererManager renderManager) {
        super(renderManager);
        this.model = new CustomSpearModel();
    }

    @Override
    public void render(CustomSpearEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        matrixStack.push();
        matrixStack.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entity.prevRotationYaw, entity.rotationYaw)-90.0f));
        matrixStack.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entity.prevRotationPitch, entity.rotationPitch)+90.0f));

        IVertexBuilder verBuilder = ItemRenderer.getBuffer(buffer, this.model.getRenderType(this.getEntityTexture(entity)), false, entity.isInWater()); // foil=in water?????

        this.model.render(matrixStack, verBuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        matrixStack.pop();
        
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public CustomSpearModel getEntityModel() {
        return model;
    }

    @Override
    public ResourceLocation getEntityTexture(CustomSpearEntity entity) {
        return SPEAR_TEXTURE;
    }

}