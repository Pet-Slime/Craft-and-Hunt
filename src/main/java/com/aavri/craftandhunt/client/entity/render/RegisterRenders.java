package com.aavri.craftandhunt.client.entity.render;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.client.entity.CaHResources;
import com.aavri.craftandhunt.init.RegisterEntityType;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RegisterRenders {
	
	public static final ResourceLocation SPEAR_TEST = new ResourceLocation(CaHResources.MODEL_SPEAR_TEST);
	public static final ResourceLocation SPEAR_WOODEN = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_wooden.png");
	public static final ResourceLocation SPEAR_STONE = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_stone.png");
	public static final ResourceLocation SPEAR_IRON = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_iron.png");
	public static final ResourceLocation SPEAR_GOLD = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_gold.png");
	public static final ResourceLocation SPEAR_DIAMOND = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_diamond.png");
	public static final ResourceLocation SPEAR_NETHERITE = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_netherite.png");
	

	public static final ResourceLocation SPEAR_BLAZE = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_blaze.png");
	public static final ResourceLocation SPEAR_BONE = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_bone.png");
	public static final ResourceLocation SPEAR_SHARK = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_shark.png");
	public static final ResourceLocation SPEAR_SHULKER = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_shulker.png");
	public static final ResourceLocation SPEAR_SPIDER = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_spider.png");
	public static final ResourceLocation SPEAR_SPIDER_FERMENTED = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_spider_fermented.png");
	public static final ResourceLocation SPEAR_SPIDER_POISON = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_spider_poison.png");
	public static final ResourceLocation SPEAR_WITHER = new ResourceLocation(Constants.MOD_ID, "textures/entity/spears/spear_wither.png");
	
	public static void registryEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.IRONSUMMON.get(), new IronSummonRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.WOLFSUMMON.get(), new WolfSummonRender.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_TEST, new CustomSpearFactory(SPEAR_TEST));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_TEST, new CustomSpearFactory(SPEAR_TEST));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_WOOD, new CustomSpearFactory(SPEAR_WOODEN));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_STONE, new CustomSpearFactory(SPEAR_STONE));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_IRON, new CustomSpearFactory(SPEAR_IRON));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_GOLD, new CustomSpearFactory(SPEAR_GOLD));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_DIAMOND, new CustomSpearFactory(SPEAR_DIAMOND));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_NETHERITE, new CustomSpearFactory(SPEAR_NETHERITE));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_BLAZE, new CustomSpearFactory(SPEAR_BLAZE));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_BONE, new CustomSpearFactory(SPEAR_BONE));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_SHARK, new CustomSpearFactory(SPEAR_SHARK));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_SHULKER, new CustomSpearFactory(SPEAR_SHULKER));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_SPIDER, new CustomSpearFactory(SPEAR_SPIDER));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_SPIDER_FERMENTED, new CustomSpearFactory(SPEAR_SPIDER_FERMENTED));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_SPIDER_POISON, new CustomSpearFactory(SPEAR_SPIDER_POISON));
		RenderingRegistry.registerEntityRenderingHandler(RegisterEntityType.SPEAR_WITHER, new CustomSpearFactory(SPEAR_WITHER));
	}
}