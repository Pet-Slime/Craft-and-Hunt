package com.aavri.craftandhunt.event;

import java.util.List;
import java.util.Random;

import com.aavri.craftandhunt.init.RegisterEffects;
import com.aavri.craftandhunt.init.RegisterOffhand;
import com.aavri.craftandhunt.world.gen.OreGenerator;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionExpiryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent.XpChange;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent event)
    {
        if (!OreGenerator.checkAndInitBiome(event)) return;
        
        if (event.getCategory() == Biome.Category.NETHER) 
        {
        	OreGenerator.generateNetherOres(event);
        }
    }
	
	@SubscribeEvent
	public static void onEntityKillVampireEffect(LivingDeathEvent event) {
		Entity killer = event.getSource().getTrueSource();
		if(killer instanceof LivingEntity) {
			LivingEntity living = (LivingEntity) killer;
			if(living.isPotionActive(RegisterEffects.VAMPIRE)) {
				float level = living.getActivePotionEffect(RegisterEffects.VAMPIRE).getAmplifier() + 1;
				if (living instanceof PlayerEntity) {
					if (living.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("vampire_fang")) {
						living.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, living,  (p_220038_0_) -> {
							p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
						});
					}
				}
				living.heal(level);
			}
		}
	}
	
	@SubscribeEvent
	public static void onEntityKillHungerEffect(LivingDeathEvent event) {
		Entity killer = event.getSource().getTrueSource();
		if(killer instanceof PlayerEntity) {
			PlayerEntity living = (PlayerEntity) killer;
			if(living.isPotionActive(RegisterEffects.CORPSEEATER)) {
				int foodAmount = living.getActivePotionEffect(RegisterEffects.CORPSEEATER).getAmplifier() + 1;
				float saturationAmount = living.getActivePotionEffect(RegisterEffects.CORPSEEATER).getAmplifier() + 1;
				living.getFoodStats().addStats(foodAmount*2, saturationAmount*2);
			}
		}
	}
	

	
	@SubscribeEvent
	public static void youAreAlreadyDead(PotionExpiryEvent event) {
		if (event.getPotionEffect().toString().contains("effect.craftandhunt.seed_cluster")) {
			LivingEntity goingToExplode = event.getEntityLiving();
			double x = goingToExplode.getPosX();
			double y = goingToExplode.getPosY()+1;
			double z = goingToExplode.getPosZ();
			if (!event.getEntityLiving().world.isRemote) {
				float range = goingToExplode.getActivePotionEffect(RegisterEffects.SEEDCLUSTER).getAmplifier()+1;
	///			goingToExplode.world.createExplosion(goingToExplode, x, y, z, 3.0F, Explosion.Mode.NONE);
				Explosion explosionIn = goingToExplode.world.createExplosion(goingToExplode, x, y, z, 3.0F*range, Explosion.Mode.NONE);
				goingToExplode.attackEntityFrom(DamageSource.causeExplosionDamage(explosionIn ), 43.0F);
			}
		}
	}
	
	@SubscribeEvent
	public static void killSummon(PotionExpiryEvent event) {
		if (event.getPotionEffect().toString().contains("effect.craftandhunt.kill_summon")) {
			LivingEntity killSummon = event.getEntityLiving();
			killSummon.attackEntityFrom(DamageSourceNew.KILLSUMMON, 1000.0F);
		}
	}
	
	
	
	@SubscribeEvent
    public static void removePoison(LivingHurtEvent event) {
		LivingEntity entity = event.getEntityLiving();
		if(entity.getActivePotionEffect(RegisterEffects.POISONRESIST) != null) {
            if (entity.getActivePotionEffect(Effects.POISON) != null) {
            	entity.removePotionEffect(Effects.POISON);
            	event.setAmount(0);
            	event.setCanceled(true);
            }
		}
	}
	
	@SubscribeEvent
	public static void redstoneMagnet(ItemPickupEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.redstone_magnet.get())) {
				player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
					p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
				});
			}
		}
	}
	
	@SubscribeEvent
	public static void forbiddenKnowledge(XpChange event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			if (player.getActivePotionEffect(RegisterEffects.EXPHEAL) != null) {
				float currentHealth = player.getHealth();
				float maxHealth = player.getMaxHealth();
				if (currentHealth < maxHealth) {
					int XPamount = event.getAmount();
					if (currentHealth + XPamount > maxHealth) {
						int leftOverXP = (int) (currentHealth + XPamount - maxHealth);
						int offhandDurabilityLoss = XPamount - leftOverXP;
						float healingNeeded = XPamount - leftOverXP;
						if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.witch_know.get())) {
							player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(offhandDurabilityLoss, player,  (p_220038_0_) -> {
							p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
							});
						}
						event.setAmount(leftOverXP);
						player.heal(healingNeeded);
						
					} else {
						if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.witch_know.get())) {
							player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(XPamount, player,  (p_220038_0_) -> {
							p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
							});
						}
						event.setAmount(0);
						player.heal(XPamount);
					}	
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void onTarget(LivingSetAttackTargetEvent event) {
		if(event.getTarget() instanceof PlayerEntity){
				MobEntity entity = (MobEntity) event.getEntity();
				EntityType<?> type = entity.getType();
				PlayerEntity target = (PlayerEntity) event.getTarget();
				
				// Make undead mobs ignore you if you have undead ignore
				if (target.getActivePotionEffect(RegisterEffects.UNDEADIGNORE) != null) {
					if (type != EntityType.WITHER && 
							entity.isEntityUndead() && 
							target.getActivePotionEffect(RegisterEffects.ENTITYKNOW) == null) {
								entity.setAttackTarget(null);
								}
					}
				
				// Make phantoms ignore you if you have phantom ignore
				if (target.isPotionActive(RegisterEffects.PHANTOMIGNORE)) {
					if (type == EntityType.PHANTOM) {
								entity.setAttackTarget(null);
					}
				
				// Make bugs ignore you if you have bug ignore
				if (target.getActivePotionEffect(RegisterEffects.BUGIGNORE ) != null && 
						target.getActivePotionEffect(RegisterEffects.ENTITYKNOW) == null) {
							}
						if (entity.getCreatureAttribute() == CreatureAttribute.ARTHROPOD) {
								entity.setAttackTarget(null);
								}
					}
				
				// Make Piglins ignore you if you have piglin ignore
				if (target.getActivePotionEffect(RegisterEffects.PIGLINIGNORE ) != null) {
					if (event.getEntityLiving() instanceof PiglinEntity) {
								entity.setAttackTarget(null);
								}
					}
				
				// Super ink sack make entities ignore you
				if (target.getActivePotionEffect(RegisterEffects.ENTITYBLIND) != null && type != EntityType.WITHER) {
							entity.setAttackTarget(null);
							}
				}
		}
	

	@SubscribeEvent
	public static void beeAttack(LivingHurtEvent event) {
		if(event.getSource().getTrueSource() instanceof LivingEntity) {
			LivingEntity target = (LivingEntity) event.getSource().getTrueSource();
			if (event.getEntityLiving() instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) event.getEntity();
				if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.buzzy_nest.get())) {
					Item item = player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem();
					if (!player.getCooldownTracker().hasCooldown(item)) {
						int amount = (int) event.getAmount();	
						int i;
						for (i = 0; i < amount; i++) {
							BlockPos blockpos = player.getPosition().add(-2 + new Random().nextInt(5), 1, -2 + new Random().nextInt(5));
							ServerWorld serverworld = (ServerWorld) player.world;
							
							BeeEntity bee = EntityType.BEE.create(player.world);
							bee.onInitialSpawn(serverworld, player.world.getDifficultyForLocation(player.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
							bee.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
							bee.setAngerTarget(target.getUniqueID());
							bee.setAngerTime(1000);
							bee.setAttackTarget(target);
							bee.addPotionEffect(new EffectInstance(RegisterEffects.KILLSUMMON, 200, 0, false, false, false));
							serverworld.func_242417_l(bee);
						}
						player.getCooldownTracker().setCooldown(item, 256);
						player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(amount, player,  (p_220038_0_) -> {
							p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
						});
					}
				}		
			}
		}
	}
	

	
	@SubscribeEvent
    public static void onAttackEffects(LivingHurtEvent event) {
		//Do blade buffs on the player applied to a mob
		if(event.getSource().getTrueSource() instanceof LivingEntity) {
			LivingEntity player = (LivingEntity) event.getSource().getTrueSource();
			LivingEntity target = (LivingEntity) event.getEntity();
			
			
			
			///Wither Strike buff
			if(player.isPotionActive(RegisterEffects.WITHERBLADE)) {
				int level = player.getActivePotionEffect(RegisterEffects.WITHERBLADE).getAmplifier() + 1;
				if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("wither_spine")) {
					player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
					p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
					});
					}
				target.addPotionEffect(new EffectInstance(Effect.get(20), 60*level, 1));
				}
			///Fire Strike Buff
			if(player.isPotionActive(RegisterEffects.FIREBLADE)) {
				int level = player.getActivePotionEffect(RegisterEffects.FIREBLADE).getAmplifier() + 1;
				if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("fire_heart")) {
					player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
					p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
					});
					}
				target.setFire(3*level);
				}
			///Poison Strike buff
			if(player.isPotionActive(RegisterEffects.POISONBLADE)) {
				int level = player.getActivePotionEffect(RegisterEffects.POISONBLADE).getAmplifier() + 1;
				if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("venom_sack")) {
					player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
					p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
					});
					}
				target.addPotionEffect(new EffectInstance(Effect.get(19), 60*level, 0));
				}
			///Magic Strike Buff
			if(player.isPotionActive(RegisterEffects.MAGICBLADE)) {
				int level = player.getActivePotionEffect(RegisterEffects.MAGICBLADE).getAmplifier() + 1;
				float damage = level*3;
				if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("witch_book")) {
					player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
					p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
					});
					}
				target.attackEntityFrom(DamageSource.MAGIC, damage);
			}
			///Magic Strike Buff
			if (event.getSource().isProjectile()) {
				if(player.isPotionActive(RegisterEffects.RANGESTRENGTH)) {
					int level = player.getActivePotionEffect(RegisterEffects.RANGESTRENGTH).getAmplifier() +1;
					float boost = level*3;
					float initialDamage = event.getAmount();
					float newDamage = initialDamage + boost;
					event.setAmount(newDamage);
				}	
			}
			if(player instanceof PlayerEntity) {
				PlayerEntity PLAYER = (PlayerEntity) player;
				EquipmentSlotType equipmentslottype = EquipmentSlotType.OFFHAND;
				ItemStack offhandSlot = PLAYER.getItemStackFromSlot(equipmentslottype);
				if (offhandSlot.getItem().equals(RegisterOffhand.seed_cluster.get())) {
					offhandSlot.damageItem(1, PLAYER,  (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
					});
					target.addPotionEffect(new EffectInstance(RegisterEffects.SEEDCLUSTER, 200, 0));
					return;
				}
				if (offhandSlot.getItem().equals(RegisterOffhand.impact_slime.get())) {
					offhandSlot.damageItem(1, PLAYER,  (p_220038_0_) -> {
						p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
					});
					target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 0));
					return;
				}
				
			}
		}
	}
	
	@SubscribeEvent
    public static void cancleIgnoreEffects(LivingHurtEvent event) {		
		// add buffs to the player if they have an effect
		if (event.getEntity() instanceof MobEntity) {
			MobEntity entity = (MobEntity) event.getEntity();
			if (event.getSource().getTrueSource() instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
				
				if ( player.isPotionActive(RegisterEffects.BUGIGNORE) ||
						player.isPotionActive(RegisterEffects.UNDEADIGNORE) ||
							player.isPotionActive(RegisterEffects.PIGLINIGNORE) ) {
				
					if (entity.isEntityUndead() && player.getActivePotionEffect(RegisterEffects.UNDEADIGNORE) != null) {
						player.addPotionEffect(new EffectInstance(RegisterEffects.ENTITYKNOW, 200, 0, false, false, false));
					}
					if (entity.getCreatureAttribute() == CreatureAttribute.ARTHROPOD && player.getActivePotionEffect(RegisterEffects.BUGIGNORE) != null) {
						player.addPotionEffect(new EffectInstance(RegisterEffects.ENTITYKNOW, 200, 0, false, false, false));
					}
					if (entity.getType() == EntityType.PIGLIN && player.getActivePotionEffect(RegisterEffects.PIGLINIGNORE) != null) {
						player.addPotionEffect(new EffectInstance(RegisterEffects.ENTITYKNOW, 200, 0, false, false, false));
					}
				}
			}
		}
	}
	
	
	@SubscribeEvent
    public static void totemOfBlock(LivingHurtEvent event) {	
		///Totem of block, which blocks Projectile or Magic damage
		if (event.getSource().isProjectile() || event.getSource().isMagicDamage()) {
			if (event.getEntity() instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) event.getEntity();
				if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.totem_of_block.get())) {
					player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
		                p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
		             });
					event.setCanceled(true);
				}
			}
		}
	}
	
	@SubscribeEvent
    public static void thornsFireEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	String tag = "thorns_fire";
            	Item boots = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
            	Item legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
            	Item chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
            	Item head = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();        	

                if(boots.getTags().toString().contains(tag) && 
                		legs.getTags().toString().contains(tag) &&
                        chest.getTags().toString().contains(tag) && 
                        head.getTags().toString().contains(tag)) {
                    if (attackerIsPlayer == null && attackerIsEntity != null) {
                        attackerIsEntity.setFire(3);
                    } else if (attackerIsPlayer != null && attackerIsEntity == null) {
                        if (!attackerIsPlayer.getActivePotionEffects().toString().contains("effect.minecraft.fire_resistance")) {
                            if (!attackerIsPlayer.isCreative()) {
                                attackerIsPlayer.setFire(3);
                            }
                        }
                    }
                }
            }
        }
    }
	
	@SubscribeEvent
    public static void thornsBeesEvent(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof LivingEntity) {
        	LivingEntity target = (LivingEntity) event.getSource().getTrueSource();
            if (event.getEntity() instanceof LivingEntity) {
            	LivingEntity player = (LivingEntity) event.getEntity();
            	if (player != null) {
            		if (player.isPotionActive(RegisterEffects.BEETALION)) {
            			double amp = player.getActivePotionEffect(RegisterEffects.BEETALION).getAmplifier()+1;
            			double initialAmount = event.getAmount();
            			int finalAmount = (int) (Math.ceil(initialAmount/4)*amp);
						int i;
						for (i = 0; i <= finalAmount; i++) {
							BlockPos blockpos = player.getPosition().add(-2 + new Random().nextInt(5), 1, -2 + new Random().nextInt(5));
							ServerWorld serverworld = (ServerWorld) player.world;
							
							BeeEntity bee = EntityType.BEE.create(player.world);
							bee.onInitialSpawn(serverworld, player.world.getDifficultyForLocation(player.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
							bee.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
							bee.setAngerTarget(target.getUniqueID());
							bee.setAngerTime(1000);
							bee.setAttackTarget(target);
							bee.addPotionEffect(new EffectInstance(RegisterEffects.KILLSUMMON, 200, 0, false, false, false));
							serverworld.func_242417_l(bee);
						}
            		}
            	}
            }
        }
	}
	
	@SubscribeEvent
    public static void thornsPoisonEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	String tag = "thorns_poison";
            	Item boots = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
            	Item legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
            	Item chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
            	Item head = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();        	

                if(boots.getTags().toString().contains(tag) && 
                		legs.getTags().toString().contains(tag) &&
                        chest.getTags().toString().contains(tag) && 
                        head.getTags().toString().contains(tag)) {
                	
                    if(attackerIsPlayer == null && attackerIsEntity != null){
                        ((LivingEntity) attackerIsEntity).addPotionEffect(new EffectInstance(Effect.get(19), 200, 0));
                    }else if(attackerIsPlayer != null && attackerIsEntity == null){
                        if(!attackerIsPlayer.getActivePotionEffects().toString().contains("effect.craftandhunt.poison_resistance")){
                            if(!attackerIsPlayer.isCreative()){
                        		attackerIsPlayer.addPotionEffect(new EffectInstance(Effect.get(19), 200, 0));
                            }
                        }
                    }
                }
            }
        }
    }
	
	@SubscribeEvent
    public static void thornsWitherEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	String tag = "thorns_wither";
            	Item boots = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
            	Item legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
            	Item chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
            	Item head = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();          	

                if(boots.getTags().toString().contains(tag) && 
                		legs.getTags().toString().contains(tag) &&
                        chest.getTags().toString().contains(tag) && 
                        head.getTags().toString().contains(tag)) {
                	
                    if(attackerIsPlayer == null && attackerIsEntity != null){
                        ((LivingEntity) attackerIsEntity).addPotionEffect(new EffectInstance(Effect.get(20), 200, 0));
                    }else if(attackerIsPlayer != null && attackerIsEntity == null){
                            if(!attackerIsPlayer.isCreative()){
                                attackerIsPlayer.addPotionEffect(new EffectInstance(Effect.get(20), 200, 0));
                            }
                    }
                }
            }
        }
    }
	
	@SubscribeEvent
    public static void thornsWeakenEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	String tag = "thorns_weaken";
            	Item boots = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
            	Item legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
            	Item chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
            	Item head = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();         	

                if(boots.getTags().toString().contains(tag) && 
                		legs.getTags().toString().contains(tag) &&
                        chest.getTags().toString().contains(tag) && 
                        head.getTags().toString().contains(tag)) {
                	
                    if(attackerIsPlayer == null && attackerIsEntity != null){
                        ((LivingEntity) attackerIsEntity).addPotionEffect(new EffectInstance(Effect.get(18), 200, 0));
                    }else if(attackerIsPlayer != null && attackerIsEntity == null){
                            if(!attackerIsPlayer.isCreative()){
                            	attackerIsPlayer.addPotionEffect(new EffectInstance(Effect.get(18), 200, 0));
                            }
                    }
                }
            }
        }
    }
	
	@SubscribeEvent
    public static void thornsEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	String tag = "thorns";
            	Item boots = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
            	Item legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
            	Item chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
            	Item head = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();         	

                if(boots.getTags().toString().contains(tag) && 
                		legs.getTags().toString().contains(tag) &&
                        chest.getTags().toString().contains(tag) && 
                        head.getTags().toString().contains(tag)) {
                	
                    if(attackerIsPlayer == null && attackerIsEntity != null) {
                        ((LivingEntity) attackerIsEntity).attackEntityFrom(DamageSource.GENERIC, 2.0F);
                    }else if(attackerIsPlayer != null && attackerIsEntity == null) {
                            if(!attackerIsPlayer.isCreative()){
                                attackerIsPlayer.attackEntityFrom(DamageSource.GENERIC, 4.0F);
                            }
                    }
                }
            }
        }
    }
	
	@SubscribeEvent
    public static void inkyDefense(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	if(player.getActivePotionEffect(RegisterEffects.INKYDEFENSE) != null) {
                    if(attackerIsPlayer == null && attackerIsEntity != null){
                    	((LivingEntity) attackerIsEntity).addPotionEffect(new EffectInstance(RegisterEffects.ENTITYBLIND, 200, 0));
                    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.super_ink_sack.get())) {
                        	player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(64, player,  (p_220038_0_) -> {
            	                p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
            	             });
                    	}
                    }else if(attackerIsPlayer != null && attackerIsEntity == null){
                            if(!attackerIsPlayer.isCreative()){
                            	attackerIsPlayer.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200, 0));
                            	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.super_ink_sack.get())) {
                                	player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(64, player,  (p_220038_0_) -> {
                    	                p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
                    	             });
                            	}
                            }
                    }
            	}
            }
        }
    }
	
	@SubscribeEvent
    public static void puffyDefense(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            PlayerEntity attackerIsPlayer = null;
            Entity attackerIsEntity = null;
            if (event.getSource().getTrueSource() instanceof PlayerEntity) {
                attackerIsPlayer = (PlayerEntity) event.getSource().getTrueSource();
            } else {
                attackerIsEntity = event.getSource().getTrueSource();
            }
            if (player != null) {
            	
            	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.puff_shroom.get())) {
                	double x = player.getPosX();
            		double y = player.getPosY() + 1.5;
            		double z = player.getPosZ();
            		double range = 5;	
                	if(attackerIsPlayer == null && attackerIsEntity != null){
                		player.addPotionEffect(new EffectInstance(RegisterEffects.POISONRESIST, 200, 0));
                    	player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
    		                p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
    		             });
                		List<LivingEntity> target = player.world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                		for(LivingEntity X: target) {
            				
            				if ( !X.getActivePotionEffects().toString().contains("effect.craftandhunt.poison_resistance")) {
            				X.addPotionEffect(new EffectInstance(Effect.get(19), 200, 0));
            				}
                		}
                    }else if(attackerIsPlayer != null && attackerIsEntity == null){
                    	if(!attackerIsPlayer.isCreative()){
                    		player.addPotionEffect(new EffectInstance(RegisterEffects.POISONRESIST, 200, 0));
                        	player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
        		                p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
        		             });
                    		List<LivingEntity> target = player.world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                    			for(LivingEntity X: target) {
                				
                    				if ( !X.getActivePotionEffects().toString().contains("effect.craftandhunt.poison_resistance")) {
                    					X.addPotionEffect(new EffectInstance(Effect.get(19), 200, 0));
                    				}
                    			}
                    		}
                    	}
                }
            }
        }
    }
	
	@SubscribeEvent
    public static void defensiveHurtEvents(LivingHurtEvent event) {
        if(event.getEntity() instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if(player !=null){
                if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().equals(RegisterOffhand.totem_of_regen.get())) {
                	Item item = player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem();
					if (!player.getCooldownTracker().hasCooldown(item)) {
                		player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
    	                	p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
    	             	});
                		player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300, 0));
                		player.getCooldownTracker().setCooldown(item, 300);
                    	}
                	}
                }
            }
        }
    }