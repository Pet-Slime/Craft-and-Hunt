package com.aavri.craftandhunt.client.entity.render;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.entity.IronSummonEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class IronSummonRender extends MobRenderer<IronSummonEntity, IronGolemModel<IronSummonEntity>> {
	
	public IronSummonRender(EntityRendererManager manager) {
		super(manager, new IronGolemModel<>(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(IronSummonEntity entity) {
		return new ResourceLocation(Constants.MOD_ID, "textures/entity/iron_summon.png");
	}

	public static class RenderFactory implements IRenderFactory<IronSummonEntity> {
		@Override
		public EntityRenderer<? super IronSummonEntity> createRenderFor(EntityRendererManager manager) 
		{
			return new IronSummonRender(manager);
		}
		
	}
}