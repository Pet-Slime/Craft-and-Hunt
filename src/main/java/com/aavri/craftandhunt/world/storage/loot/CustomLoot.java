package com.aavri.craftandhunt.world.storage.loot;

import java.util.Random;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.init.RegisterItems;
import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CustomLoot {
	
	@SubscribeEvent
	public void betterAnimalsPlusLoot(LivingDropsEvent event) {
		if (Constants.betterAnimalsLoaded) {
			Entity killer = event.getSource().getTrueSource();
			if (killer instanceof PlayerEntity) {
				Random random = new Random();
				PlayerEntity player = (PlayerEntity) killer;
				LivingEntity entity = event.getEntityLiving();
				double LUCK = player.getAttribute(Attributes.LUCK).getValue();
				int Looting = EnchantmentHelper.getLootingModifier(player);
			
				///Brown Bear Drop
				if (entity.getName().toString().contains("entity.betteranimalsplus.brownbear")) {
					if(random.nextInt(99) <= Config.drop_chance_panda_leather.get() + LUCK*3 + Looting*2) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.bear_brown_leather.get(), itemDropAmount));				
					}
					if(Config.bearFlank_true.get() == true) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmount));
						if (Looting > 0) {
							if(random.nextInt(99) <= (25 + LUCK*3 + Looting*2)) {
								int itemDropAmountLoot = (int) (itemDropAmount + Looting);
								entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmountLoot));
							}
						}
					}
				}
			
				///Black Bear Drop
				if (entity.getName().toString().contains("entity.betteranimalsplus.blackbear")) {
					if(random.nextInt(99) <= Config.drop_chance_panda_leather.get() + LUCK*3 + Looting*2) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.bear_black_leather.get(), itemDropAmount));				
					}
					if(Config.bearFlank_true.get() == true) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmount));
						if (Looting > 0) {
							if(random.nextInt(99) <= (25 + LUCK*3 + Looting*2)) {
								int itemDropAmountLoot = (int) (itemDropAmount + Looting);
								entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmountLoot));
							}
						}
					}
				}
			
			///Shark Drop
				if (entity.getName().toString().contains("entity.betteranimalsplus.shark")) {
					if(random.nextInt(99) <= Config.drop_chance_shark_leather.get() + LUCK*3 + Looting*2) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.shark_skin.get(), itemDropAmount));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_shark_leather.get() + LUCK*3 + Looting*2)) {
								int itemDropAmountLoot = (int) (itemDropAmount + Looting);
								entity.entityDropItem(new ItemStack(RegisterItems.shark_skin.get(), itemDropAmountLoot));
							}
						}
					}
				}
		
				///Lamprey Drop
				if (entity.getName().toString().contains("entity.betteranimalsplus.lamprey")) {
					if(random.nextInt(99) <= Config.drop_chance_lamprey.get() + LUCK*3 + Looting*2) {
						entity.entityDropItem(new ItemStack(RegisterOffhand.vampire_fang.get()));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_lamprey.get() + LUCK*3 + Looting*2)) {
								entity.entityDropItem(new ItemStack(RegisterOffhand.vampire_fang.get()));
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void quarkLoot(LivingDropsEvent event) {
		if (Constants.quarkLoaded) {
			Entity killer = event.getSource().getTrueSource();
			if (killer instanceof PlayerEntity) {
				Random random = new Random();
				PlayerEntity player = (PlayerEntity) killer;
				LivingEntity entity = event.getEntityLiving();
				double LUCK = player.getAttribute(Attributes.LUCK).getValue();
				int Looting = EnchantmentHelper.getLootingModifier(player);
			
				///Wolf Drops
				if (entity.getName().toString().contains("entity.quark.foxhound")) {
					if(random.nextInt(99) <= Config.drop_chance_wolf_hide.get() + LUCK*3 + Looting*2) {
						int itemDropAmount = (int) (random.nextInt(3) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.fox_fire_hide.get(), itemDropAmount));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_wolf_hide.get() + LUCK*3 + Looting*2)) {
								int itemDropAmountLoot = (int) (itemDropAmount + Looting);
								entity.entityDropItem(new ItemStack(RegisterItems.fox_fire_hide.get(), itemDropAmountLoot));
							}
						}
					}
					return;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void upgradeAquaticLoot(LivingDropsEvent event) {
		if (Constants.upgrade_aquaticLoaded) {
			Entity killer = event.getSource().getTrueSource();
			if (killer instanceof PlayerEntity) {
				Random random = new Random();
				PlayerEntity player = (PlayerEntity) killer;
				LivingEntity entity = event.getEntityLiving();
				double LUCK = player.getAttribute(Attributes.LUCK).getValue();
				int Looting = EnchantmentHelper.getLootingModifier(player);
			
				///Thrasher Drops
				if (entity.getName().toString().contains("entity.upgrade_aquatic.thrasher")) {
					if(random.nextInt(99) <= Config.drop_chance_shark_leather.get() + LUCK*3 + Looting*2) {
						int itemDropAmount = (int) (random.nextInt(3) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.thrasher_skin.get(), itemDropAmount));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_shark_leather.get() + LUCK*3 + Looting*2)) {
								int itemDropAmountLoot = (int) (itemDropAmount + Looting);
								entity.entityDropItem(new ItemStack(RegisterItems.thrasher_skin.get(), itemDropAmountLoot));
							}
						}
					}
					return;
				}
				
				///Great Thrasher Drops
				if (entity.getName().toString().contains("entity.upgrade_aquatic.great_thrasher")) {
					if(random.nextInt(99) <= Config.drop_chance_shark_leather.get() + LUCK*3 + Looting*2) {
						int itemDropAmount = (int) (random.nextInt(3) + LUCK);
						entity.entityDropItem(new ItemStack(RegisterItems.thrasher_great_skin.get(), itemDropAmount));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_shark_leather.get() + LUCK*3 + Looting*2)) {
								int itemDropAmountLoot = (int) (itemDropAmount + Looting);
								entity.entityDropItem(new ItemStack(RegisterItems.thrasher_great_skin.get(), itemDropAmountLoot));
							}
						}
					}
					return;
				}
			}
		}
	}
	
	
	/// Ender Dragon Scales Drop
	@SubscribeEvent
	public void endDragonCustomLootDrops(LivingDropsEvent event) {
		if (Config.upgrade_armor_true.get() == true) {
			Entity killer = event.getSource().getTrueSource();
			if (killer instanceof PlayerEntity) {
				Random random = new Random();
				PlayerEntity player = (PlayerEntity) killer;
				LivingEntity entity = event.getEntityLiving();
				double LUCK = player.getAttribute(Attributes.LUCK).getValue();	
				
				if (entity.getName().toString().contains("entity.minecraft.ender_dragon")) {
					if(random.nextInt(99) <= 100 + LUCK*2) {
						entity.entityDropItem(new ItemStack(RegisterItems.dragon_scale.get(), (int) (LUCK*2+1+random.nextInt(3))));
					}
					if(random.nextInt(99) <= 75 + LUCK*2) {
						entity.entityDropItem(new ItemStack(RegisterItems.dragon_scale.get(), (int) (LUCK*2+1+random.nextInt(2))));
					}
					if(random.nextInt(99) <= 50 + LUCK*2) {
						entity.entityDropItem(new ItemStack(RegisterItems.dragon_scale.get(), (int) (LUCK*2+1+random.nextInt(1))));
					}
					if(random.nextInt(99) <= 25 + LUCK*2) {
						entity.entityDropItem(new ItemStack(RegisterItems.dragon_scale.get(), (int) (LUCK*2+1)));
					}
					return;
				}		
			}
		}
	}
	
	@SubscribeEvent
	public void CustomLootDrops(LivingDropsEvent event) {
		Entity killer = event.getSource().getTrueSource();
		if (killer instanceof PlayerEntity) {
			Random random = new Random();
			PlayerEntity player = (PlayerEntity) killer;
			LivingEntity entity = event.getEntityLiving();
			double LUCK = player.getAttribute(Attributes.LUCK).getValue();
			int Looting = EnchantmentHelper.getLootingModifier(player);
			

		
			
			///Spider Drops
			if (entity.getName().toString().contains("entity.minecraft.spider") ||
					entity instanceof SpiderEntity ||
					entity.getName().toString().contains("entity.minecraft.cave_spider")) {
				if(random.nextInt(99) <= Config.drop_chance_spider_chitin.get() + LUCK*3 + Looting*2)  {
					int itemDropAmount = (int) (1 + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.spider_chitin.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_spider_chitin.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.spider_chitin.get(), itemDropAmountLoot));
						}
					}
				}
				///Cave Spider Toxin Sack
				if (entity.getName().toString().contains("entity.minecraft.cave_spider")) {
					if(random.nextInt(99) <= Config.drop_chance_cave_spider.get() + LUCK*3 + Looting*2) {
						entity.entityDropItem(new ItemStack(RegisterItems.spider_poison_chitin.get(), 2));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_cave_spider.get() + LUCK*3 + Looting*2)) {
								entity.entityDropItem(new ItemStack(RegisterItems.spider_poison_chitin.get(), 2));
							}
						}
					}
				}
				///Cave Spider Toxin Sack
				if (entity.getName().toString().contains("entity.minecraft.cave_spider")) {
					if(random.nextInt(99) <= Config.drop_chance_cave_spider.get() + LUCK*3 + Looting*2) {
						entity.entityDropItem(new ItemStack(RegisterOffhand.venom_sack.get()));
						if (Looting > 0) {
							if(random.nextInt(99) <= (Config.drop_chance_cave_spider.get() + LUCK*3 + Looting*2)) {
								entity.entityDropItem(new ItemStack(RegisterOffhand.venom_sack.get()));
							}
						}
					}
				}
				return;
			}
			
			///Wolf Drops
			if (entity.getName().toString().contains("entity.minecraft.wolf")) {
				if(random.nextInt(99) <= Config.drop_chance_wolf_hide.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(3) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.wolf_hide.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_wolf_hide.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.wolf_hide.get(), itemDropAmountLoot));
						}
					}
				}
				return;
			}
			
			///Silverfish Drops
			if (entity.getName().toString().contains("entity.minecraft.silverfish")) {
				if(random.nextInt(99) <= Config.drop_chance_silverfish_chitin.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(3) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.silverfish_chitin.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_silverfish_chitin.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.silverfish_chitin.get(), itemDropAmountLoot));
						}
					}
				}
				return;
			}
			
			///Endermite Drops
			if (entity.getName().toString().contains("entity.minecraft.endermite")) {
				if(random.nextInt(99) <= Config.drop_chance_endermite_mass.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(3) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.endermite_mass.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_endermite_mass.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.endermite_mass.get(), itemDropAmountLoot));
						}
					}
				}
				return;
			}
			

			
			///Panda Bear Drops
			if (entity.getName().toString().contains("entity.minecraft.panda")) {
		        if (Config.bearFlank_true.get() == true) {
		        	int itemDropAmount = (int) (random.nextInt(5) + LUCK);
		        	entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmount));
		        }
				if(random.nextInt(99) <= Config.drop_chance_panda_leather.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(5) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.bear_panda_leather.get(), itemDropAmount));				
				}
				if (Looting > 0) {
					if(random.nextInt(99) <= (Config.drop_chance_panda_leather.get() + LUCK*3 + Looting*2)) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						int itemDropAmountLoot = (int) (itemDropAmount + Looting);
						entity.entityDropItem(new ItemStack(RegisterItems.bear_panda_leather.get(), itemDropAmountLoot));
				        if (Config.bearFlank_true.get() == true) {
				        	entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmountLoot));
				        }
					}
				}
				return;
			}
			
			
			///Polar Bear Drop
			if (entity.getName().toString().contains("entity.minecraft.polar_bear")) {
		        if (Config.bearFlank_true.get() == true) {
		        	int itemDropAmount = (int) (random.nextInt(5) + LUCK);
		        	entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmount));
		        }
				if(random.nextInt(99) <= Config.drop_chance_polar_leather.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(5) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.bear_polar_leather.get(), itemDropAmount));
				}
				if (Looting > 0) {
					if(random.nextInt(99) <= (Config.drop_chance_polar_leather.get() + LUCK*3 + Looting*2)) {
						int itemDropAmount = (int) (random.nextInt(5) + LUCK);
						int itemDropAmountLoot = (int) (itemDropAmount + Looting);
						entity.entityDropItem(new ItemStack(RegisterItems.bear_polar_leather.get(), itemDropAmountLoot));
				        if (Config.bearFlank_true.get() == true) {
				        	entity.entityDropItem(new ItemStack(RegisterItems.bear_flank.get(), itemDropAmountLoot));
				        }	
					}
				}
				return;
			}
			
			///Creeper seeds drop
			if (entity.getName().toString().contains("entity.minecraft.creeper") ||
					entity instanceof CreeperEntity) {
				if(random.nextInt(99) <= Config.drop_chance_creeper.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.seed_cluster.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_creeper.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.seed_cluster.get()));
						}
					}
				}
				return;
			}
			
			///Guardian Drops
			if (entity.getName().toString().contains("entity.minecraft.guardian")) {
				if(random.nextInt(99) <= Config.drop_chance_guardian_leather.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(5) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.guardian_skin.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_guardian_leather.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.guardian_skin.get(), itemDropAmountLoot));
						}
					}
				}
				return;
			}
			
			///Guardian Drops
			if (entity.getName().toString().contains("entity.minecraft.elder_guardian")) {
				entity.entityDropItem(new ItemStack(RegisterItems.guardian_elder_skin.get(), 1));
				return;
			}

			///Ghast Flame Lung Drop
			if (entity.getName().toString().contains("entity.minecraft.ghast")) {
				if(random.nextInt(99) <= Config.drop_chance_ghast.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.fire_heart.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_ghast.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.fire_heart.get()));
						}
					}
				}
				return;
			}
			
			
			///Piglin Emblem chance
			if (entity instanceof AbstractPiglinEntity) {
				if (entity.getName().toString().contains("entity.minecraft.piglin_brute")) {
					if(random.nextInt(99) <= Config.drop_piglin_armbrace.get() + LUCK + Looting) {
						entity.entityDropItem(new ItemStack(RegisterOffhand.piglin_armbrace.get()));
					}
				}
				if(random.nextInt(99) <= Config.drop_piglin_emblem.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterItems.piglin_emblem.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_piglin_emblem.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterItems.piglin_emblem.get()));
						}
					}
				}
				return;
			}
			
			///Wither Skeleton Spine Drop
			if (entity.getName().toString().contains("entity.minecraft.wither_skeleton")) {
				if(random.nextInt(99) <= Config.drop_chance_wither_skeleton.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.wither_spine.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_wither_skeleton.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.wither_spine.get()));
						}
					}
				}
				return;
			}
			
			///Evoker Magic Book drop
			if (entity.getName().toString().contains("entity.minecraft.evoker")) {
				if(random.nextInt(99) <= Config.drop_chance_evoker.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.evokers_book.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_evoker.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.evokers_book.get()));
						}
					}
				}
				return;
			}
			
			///witch Magic Book drop
			if (entity.getName().toString().contains("entity.minecraft.witch")) {
				if(random.nextInt(99) <= Config.drop_chance_witch.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.witch_book.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_witch.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.witch_book.get()));
						}
					}
				}
				return;
			}
			
			
			
			///Squid Drops
			if (entity.getName().toString().contains("entity.minecraft.squid") ||
					entity instanceof SquidEntity) {
				if (Config.calamari_true.get() == true) {
					int itemDropAmount = (int) (random.nextInt(5) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.calamari.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (25 + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.calamari.get(), itemDropAmountLoot));
						}
					}
				}
				if(random.nextInt(99) <= Config.drop_chance_squid.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.super_ink_sack.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_squid.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.super_ink_sack.get()));
						}
					}
				}
				return;
			}
			
			///Fox tail
			if (entity.getName().toString().contains("entity.minecraft.fox")) {
				if(random.nextInt(99) <= Config.drop_chance_fox.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.fox_tail.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_fox.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.fox_tail.get()));
						}
					}
				}
				if(random.nextInt(99) <= Config.drop_chance_fox_hide.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (random.nextInt(3) + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.fox_hide.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_fox_hide.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.fox_hide.get(), itemDropAmountLoot));
						}
					}
				}
				return;
			}
			
			///Bee Drops
			if (entity.getName().toString().contains("entity.minecraft.bee") ||
					entity instanceof BeeEntity) {
				if(random.nextInt(99) <= Config.drop_chance_bee_chitin.get() + LUCK*3 + Looting*2) {
					int itemDropAmount = (int) (1 + LUCK);
					entity.entityDropItem(new ItemStack(RegisterItems.bee_chitin.get(), itemDropAmount));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_bee_chitin.get() + LUCK*3 + Looting*2)) {
							int itemDropAmountLoot = (int) (itemDropAmount + Looting);
							entity.entityDropItem(new ItemStack(RegisterItems.bee_chitin.get(), itemDropAmountLoot));
						}
					}
				}
				return;
			}
			
			///Mooshroom Puff shroom drop
			if (entity.getName().toString().contains("entity.minecraft.mooshroom")) {
				if(random.nextInt(99) <= Config.drop_chance_mooshroom.get() + LUCK*3 + Looting*2) {
					entity.entityDropItem(new ItemStack(RegisterOffhand.puff_shroom.get()));
					if (Looting > 0) {
						if(random.nextInt(99) <= (Config.drop_chance_mooshroom.get() + LUCK*3 + Looting*2)) {
							entity.entityDropItem(new ItemStack(RegisterOffhand.puff_shroom.get()));
						}
					}
				}
				return;
			}
			
			if (Config.drop_chance_totems.get() > 0) {
				if(random.nextInt(99) <= Config.drop_chance_totems.get() + LUCK + Looting)  {
					if (random.nextInt(99) > 50) {
						entity.entityDropItem(new ItemStack(RegisterOffhand.totem_of_block.get(), 1));
					} else {
						entity.entityDropItem(new ItemStack(RegisterOffhand.totem_of_regen.get(), 1));
					}
					return;
				}
			}
		}
	}
}
