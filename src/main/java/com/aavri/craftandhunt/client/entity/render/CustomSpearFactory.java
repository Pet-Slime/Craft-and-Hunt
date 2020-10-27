package com.aavri.craftandhunt.client.entity.render;

import com.aavri.craftandhunt.entity.CustomSpearEntity;

//Minecraft stuff
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
//Forge stuff
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CustomSpearFactory implements IRenderFactory<CustomSpearEntity> {
	public CustomSpearRenderer spearRenderer;
	public final ResourceLocation spearTextures;

	public CustomSpearFactory(ResourceLocation render) {
		this.spearTextures = render;
	}

	@Override
	public EntityRenderer<? super CustomSpearEntity> createRenderFor(EntityRendererManager manager) {
		this.spearRenderer = new CustomSpearRenderer(manager);
		spearRenderer.SPEAR_TEXTURE = spearTextures;
		return spearRenderer;
    }
}