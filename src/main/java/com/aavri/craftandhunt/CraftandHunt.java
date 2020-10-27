package com.aavri.craftandhunt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aavri.craftandhunt.config.CraftAndHuntConfig;
import com.aavri.craftandhunt.data.DataGenerators;
import com.aavri.craftandhunt.entity.IronSummonEntity;
import com.aavri.craftandhunt.init.RegisterArmors;
import com.aavri.craftandhunt.init.RegisterArmorsUpgrades;
import com.aavri.craftandhunt.init.RegisterBlocks;
import com.aavri.craftandhunt.init.RegisterEntityType;
import com.aavri.craftandhunt.init.RegisterItems;
import com.aavri.craftandhunt.init.RegisterOffhand;
import com.aavri.craftandhunt.init.RegisterTools;
import com.aavri.craftandhunt.world.gen.OreGenerator;
import com.aavri.craftandhunt.world.storage.loot.CustomLoot;
import com.aavri.craftandhunt.world.storage.loot.LootHandler;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("craftandhunt")
public class CraftandHunt {
	
	public static final Logger LOGGER = LogManager.getLogger(Constants.MOD_ID);
	
	public static boolean yoyoLoaded = false;
	public static boolean betterAnimalsLoaded = false;
	public static boolean patchouliLoaded = false;
	public static boolean quarkLoaded = false;
	public static boolean upgrade_aquaticLoaded = false;

    public CraftandHunt() {

        CraftAndHuntConfig.loadConfig(CraftAndHuntConfig.Server_Config, FMLPaths.CONFIGDIR.get().resolve("craftandhunt.toml"));
        
    	IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();   	
        modBus.addListener(this::setup);
        modBus.addListener(this::doClientStuff);
        modBus.addListener(DataGenerators::gatherData);
        
        yoyoLoaded = ModList.get().isLoaded("yoyos");
        betterAnimalsLoaded = ModList.get().isLoaded("betteranimalsplus");
        patchouliLoaded = ModList.get().isLoaded("patchouli");
        quarkLoaded = ModList.get().isLoaded("quark");
        upgrade_aquaticLoaded = ModList.get().isLoaded("upgrade_aquatic");
        

        
		IEventBus forgeBus = MinecraftForge.EVENT_BUS; 
		forgeBus.register(this);
		forgeBus.register(new DataGenerators());
		Object dataGen = new DataGenerators();
		Object oreGen = new OreGenerator();
		forgeBus.register(dataGen);
		forgeBus.register(oreGen);
		forgeBus.addListener(LootHandler::lootLoad);
		forgeBus.register(new CustomLoot());
		forgeBus.addListener(DataGenerators::gatherData);
        
        RegisterItems.init();
        RegisterTools.init();
        RegisterOffhand.init();
        RegisterArmors.init();
        RegisterArmorsUpgrades.init();
        RegisterBlocks.init();
        RegisterEntityType.init();
    }

    @SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event) {
    	
    	DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(RegisterEntityType.IRONSUMMON.get(), IronSummonEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegisterEntityType.WOLFSUMMON.get(), IronSummonEntity.setCustomAttributes().create());
        });
    	LOGGER.info("Sexy summons logged.");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    

    
}
