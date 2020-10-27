package com.aavri.craftandhunt.util;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.client.entity.render.RegisterRenders;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
		RegisterRenders.registryEntityRenders();
    }
}
