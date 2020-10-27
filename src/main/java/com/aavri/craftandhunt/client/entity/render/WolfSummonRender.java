package com.aavri.craftandhunt.client.entity.render;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.client.entity.model.WolfSummonModel;
import com.aavri.craftandhunt.entity.WolfSummonEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WolfSummonRender extends MobRenderer<WolfSummonEntity, WolfSummonModel<WolfSummonEntity>> {
	
	public WolfSummonRender(EntityRendererManager manager) {
		super(manager, new WolfSummonModel<>(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(WolfSummonEntity entity) {
		return new ResourceLocation(Constants.MOD_ID, "textures/entity/wolf_summon.png");
	}

	public static class RenderFactory implements IRenderFactory<WolfSummonEntity> {
		@Override
		public EntityRenderer<? super WolfSummonEntity> createRenderFor(EntityRendererManager manager) 
		{
			return new WolfSummonRender(manager);
		}
		
	}
}