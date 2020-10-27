package com.aavri.craftandhunt.entity;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.init.RegisterItems;
import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WandererReplacements {
	
	@SubscribeEvent
	public static void addWandererArrays(WandererTradesEvent event) {
		
		
		if (Config.trader_bear_black_leather.get() == true) {
			event.getGenericTrades().add(new BasicTrade(Config.price_bear_black_leather.get(), new ItemStack(RegisterItems.bear_black_leather.get()), 4, 5));
		}
		
		if (Config.trader_bear_brown_leather.get() == true) {
			event.getGenericTrades().add(new BasicTrade(Config.price_bear_brown_leather.get(), new ItemStack(RegisterItems.bear_brown_leather.get()), 4, 5));
		}
		if (Config.trader_bear_panda_leather.get() == true) {
			event.getGenericTrades().add(new BasicTrade(Config.price_bear_panda_leather.get(), new ItemStack(RegisterItems.bear_panda_leather.get()), 4, 5));
		}
		if (Config.trader_bear_polar_leather.get() == true) {
			event.getGenericTrades().add(new BasicTrade(Config.price_bear_polar_leather.get(), new ItemStack(RegisterItems.bear_polar_leather.get()), 4, 5));
		}
		if (Config.trader_goat_hide.get() == true) {
			event.getGenericTrades().add(new BasicTrade(Config.price_goat_hide.get(), new ItemStack(RegisterItems.goat_hide.get()), 4, 5));
		}

		if (Config.trader_shark_skin.get() == true) {
			event.getGenericTrades().add(new BasicTrade(Config.price_shark_skin.get(), new ItemStack(RegisterItems.shark_skin.get()), 4, 5));
		}

	
		
		
		if (Constants.betterAnimalsLoaded == false) {
			if (Config.trader_vampire_fang.get() == true) {
				event.getGenericTrades().add(new BasicTrade(Config.price_vampire_fang.get(), new ItemStack(RegisterOffhand.vampire_fang.get()), 1, 20));
			}
        }
		
		if (Constants.quarkLoaded == false) {
			if (Config.trader_crab_shell.get() == true) {
				event.getGenericTrades().add(new BasicTrade(Config.price_crab_shell.get(), new ItemStack(RegisterItems.crab_shell.get()), 10, 5));
			}	
        }
		
		if (Constants.upgrade_aquaticLoaded == false) {
			if (Config.trader_thrasher_tooth.get() == true) {
				event.getGenericTrades().add(new BasicTrade(Config.price_thrasher_tooth.get(), new ItemStack(RegisterItems.thrasher_tooth.get()), 5, 5));
			}
			if (Config.trader_thrasher_skin.get() == true) {
				event.getRareTrades().add(new BasicTrade(Config.price_thrasher_skin.get(), new ItemStack(RegisterItems.thrasher_skin.get()), 1, 20));
			}
			if (Config.trader_great_threasher_skin.get() == true) {
				event.getRareTrades().add(new BasicTrade(Config.price_great_threasher_skin.get(), new ItemStack(RegisterItems.thrasher_great_skin.get()), 1, 20));
			}

        }		
		if (Config.trader_fire_hound_hide.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_fire_hound_hide.get(), new ItemStack(RegisterItems.fox_fire_hide.get()), 1, 35));
		}
		if (Config.trader_dragon_scale.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_dragon_scale.get(), new ItemStack(RegisterItems.dragon_scale.get()), 3, 35));
		}	
		if (Config.trader_roc_feather.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_roc_feather.get(), new ItemStack(RegisterOffhand.roc_feather.get()), 1, 35));
		}
		if (Config.trader_lightning_rod.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_lightning_rod.get(), new ItemStack(RegisterOffhand.lightning_rod.get()), 1, 35));
		}
		if (Config.trader_lightning_rod.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_lightning_rod.get(), new ItemStack(RegisterOffhand.firecharge_rod.get()), 1, 35));
		}
		if (Config.trader_wind_horn.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_wind_horn.get(), new ItemStack(RegisterOffhand.wind_horn.get()), 1, 35));
		}
		if (Config.trader_deathcap.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_deathcap.get(), new ItemStack(RegisterOffhand.death_cap.get()), 1, 35));
		}
		if (Config.trader_golem_kit.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_golem_kit.get(), new ItemStack(RegisterOffhand.golem_kit.get()), 1, 35));
		}
		if (Config.trader_tasty_bone.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_tasty_bone.get(), new ItemStack(RegisterOffhand.tasty_bone.get()), 1, 35));
		}
		if (Config.trader_buzzy_nest.get() == true) {
			event.getRareTrades().add(new BasicTrade(Config.price_buzzy_nest.get(), new ItemStack(RegisterOffhand.buzzy_nest.get()), 1, 35));
		}
			
	}

}
