package com.aavri.craftandhunt.data;

import com.aavri.craftandhunt.Constants;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


@EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new Recipes(generator));
		}
		
	}
}
