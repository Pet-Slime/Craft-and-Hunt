package com.aavri.craftandhunt.data;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.CraftandHunt;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		CraftandHunt.LOGGER.info("Sexy data Gen.");
        DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new Recipes(generator));
///			generator.addProvider(new ModTags(generator, null));
		}
		
	}
	
	public static ResourceLocation rl(String path)
	{
		return new ResourceLocation(Constants.MOD_ID, path);
	}
}
