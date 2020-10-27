package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = Bus.MOD)
public class RegisterSounds {
    
	public static final SoundEvent sunken_temple = makeSoundEvent("sunken_temple");
	
	private static SoundEvent makeSoundEvent(String name) {
		ResourceLocation loc = new ResourceLocation(Constants.MOD_ID, name);
		return new SoundEvent(loc).setRegistryName(loc);
	}

    
    @SubscribeEvent
    public static void register(Register<SoundEvent> event) {
        IForgeRegistry<SoundEvent> registry = event.getRegistry();
        
        registry.register(sunken_temple);

    }



}