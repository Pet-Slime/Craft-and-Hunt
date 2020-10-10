package com.aavri.craftandhunt;

import com.aavri.craftandhunt.config.CraftAndHuntConfig;
import com.aavri.craftandhunt.data.DataGenerators;
import com.aavri.craftandhunt.util.RegisterBlocks;
import com.aavri.craftandhunt.util.RegisterItems;
import com.aavri.craftandhunt.util.RegisterTools;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("craftandhunt")
public class Craftandhunt
{
   // private static final Logger LOGGER = LogManager.getLogger();

    public Craftandhunt() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	MinecraftForge.EVENT_BUS.register(new DataGenerators());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        CraftAndHuntConfig.loadConfig(CraftAndHuntConfig.Server_Config, FMLPaths.CONFIGDIR.get().resolve("craftandhunt.toml"));
        
        
        RegisterItems.init();
        RegisterTools.init();
        RegisterBlocks.init();

        MinecraftForge.EVENT_BUS.register(this);
        


		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		modBus.addListener(DataGenerators::gatherData);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    
}
