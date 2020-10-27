package com.aavri.craftandhunt.event;

import com.aavri.craftandhunt.init.RegisterArmors;
import com.aavri.craftandhunt.init.RegisterArmorsUpgrades;
import com.aavri.craftandhunt.init.RegisterEffects;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BuffsEventHandler {
	
	
	@SubscribeEvent
	public static void bladeBuffsActive(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
		PlayerEntity player = (PlayerEntity) event.getEntity();
		String item = player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString();
		
		if (item.contains("wither_spine")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.WITHERBLADE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("fire_heart")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.FIREBLADE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("venom_sack")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.POISONBLADE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("vampire_fang")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.VAMPIRE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("witch_book")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.MAGICBLADE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("witch_know")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.EXPHEAL, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("fox_tail")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.THIEFBLADE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("super_ink_sack")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.INKYDEFENSE, 37200  , 0, false, false, true));
			return;
		}
		if (item.contains("piglin_respect")) {
			player.addPotionEffect(new EffectInstance(RegisterEffects.PIGLINIGNORE, 37200  , 0, false, false, true));
			return;
		}

		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveNightVision(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("night_vision") &&
	        	itemHead.contains("night_vision") &&
	        	itemChest.contains("night_vision") &&
	       		itemLegs.contains("night_vision")) {
	       			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveCorpseEater(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("corpse_eater") &&
	        	itemHead.contains("corpse_eater") &&
	        	itemChest.contains("corpse_eater") &&
	       		itemLegs.contains("corpse_eater")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.CORPSEEATER, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveHunger(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("hunger") &&
	        	itemHead.contains("hunger") &&
	        	itemChest.contains("hunger") &&
	       		itemLegs.contains("hunger")) {
	       			player.addPotionEffect(new EffectInstance(Effects.HUNGER, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveVampire(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("vampire") &&
	        	itemHead.contains("vampire") &&
	        	itemChest.contains("vampire") &&
	       		itemLegs.contains("vampire")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.VAMPIRE, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveUndeadIgnore(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("undead_ignore") &&
	        	itemHead.contains("undead_ignore") &&
	        	itemChest.contains("undead_ignore") &&
	       		itemLegs.contains("undead_ignore")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.UNDEADIGNORE, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActivePackLeader(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("pack_leader") &&
	        	itemHead.contains("pack_leader") &&
	        	itemChest.contains("pack_leader") &&
	       		itemLegs.contains("pack_leader")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.PACKLEADER, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveFireResist(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("fire_resist") &&
	        	itemHead.contains("fire_resist") &&
	        	itemChest.contains("fire_resist") &&
	       		itemLegs.contains("fire_resist")) {
	       			player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveGuardianAura(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("guardian_aura") &&
	        	itemHead.contains("guardian_aura") &&
	        	itemChest.contains("guardian_aura") &&
	       		itemLegs.contains("guardian_aura")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.GUARDAINARMOR, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveRammingStrength(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("ramming") &&
	        	itemHead.contains("ramming") &&
	        	itemChest.contains("ramming") &&
	       		itemLegs.contains("ramming")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.GOATSTRENGTH, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveSlowFall(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("slow_fall") &&
	        	itemHead.contains("slow_fall") &&
	        	itemChest.contains("slow_fall") &&
	       		itemLegs.contains("slow_fall")) {
	       			player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 37200, 0, false, false, true));
	        }
		}
	}
	
	
	@SubscribeEvent
	public static void armorBuffActiveJumpBoost(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("jump_boost") &&
	        	itemHead.contains("jump_boost") &&
	        	itemChest.contains("jump_boost") &&
	       		itemLegs.contains("jump_boost")) {
	       			player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveRangeStrength(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("range_power") &&
	        	itemHead.contains("range_power") &&
	        	itemChest.contains("range_power") &&
	       		itemLegs.contains("range_power")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.RANGESTRENGTH, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveMeleeStregnth(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("strength") &&
	        	itemHead.contains("strength") &&
	        	itemChest.contains("strength") &&
	       		itemLegs.contains("strength")) {
	       			player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActivePoisonResist(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("poison_resist") &&
	        	itemHead.contains("poison_resist") &&
	        	itemChest.contains("poison_resist") &&
	       		itemLegs.contains("poison_resist")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.POISONRESIST, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActivePhantomIgnore(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("phantom_ignore") ||
	        	itemHead.contains("phantom_ignore") ||
	        	itemChest.contains("phantom_ignore") ||
	       		itemLegs.contains("phantom_ignore")) {
	       			player.addPotionEffect(new EffectInstance(RegisterEffects.PHANTOMIGNORE, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveDolphinGrace(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			String itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString();
			String itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString();
			String itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString();
			String itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString();
					
	    	if(itemFeet.contains("dolphin_grace") &&
	        	itemHead.contains("dolphin_grace") &&
	        	itemChest.contains("dolphin_grace") &&
	       		itemLegs.contains("dolphin_grace")) {
	       			player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 37200, 0, false, false, true));
	        }
		}
	}
	
	@SubscribeEvent
	public static void armorBuffActiveBeetalion(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item itemFeet = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
			Item itemHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();
			Item itemChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
			Item itemLegs = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
					
	    	if(itemFeet.getTags().toString().contains("thorns_bees") &&
	        	itemHead.getTags().toString().contains("thorns_bees") &&
	        	itemChest.getTags().toString().contains("thorns_bees") &&
	       		itemLegs.getTags().toString().contains("thorns_bees")) {
	    		
	    		if(itemFeet.equals(RegisterArmors.bee_boots.get()) &&
	    	        	itemHead.equals(RegisterArmors.bee_helmet.get()) &&
	    	        	itemChest.equals(RegisterArmors.bee_chestplate.get()) &&
	    	       		itemLegs.equals(RegisterArmors.bee_leggings.get())) {

	       			player.addPotionEffect(new EffectInstance(RegisterEffects.BEETALION, 37200, 0, false, false, true));
	    			
	    		} else if(itemFeet.equals(RegisterArmors.nest_boots.get()) &&
	    	        	itemHead.equals(RegisterArmors.nest_helmet.get()) &&
	    	        	itemChest.equals(RegisterArmors.nest_chestplate.get()) &&
	    	       		itemLegs.equals(RegisterArmors.nest_leggings.get())) {

   					player.addPotionEffect(new EffectInstance(RegisterEffects.BEETALION, 37200, 1, false, false, true));
	    			
	    		}else if(itemFeet.equals(RegisterArmors.hive_boots.get()) &&
	    	        	itemHead.equals(RegisterArmors.hive_helmet.get()) &&
	    	        	itemChest.equals(RegisterArmors.hive_chestplate.get()) &&
	    	       		itemLegs.equals(RegisterArmors.hive_leggings.get())) {

   					player.addPotionEffect(new EffectInstance(RegisterEffects.BEETALION, 37200, 2, false, false, true));
	    			
	    		} else if(itemFeet.equals(RegisterArmorsUpgrades.u_bee_boots.get()) &&
	    	        	itemHead.equals(RegisterArmorsUpgrades.u_bee_helmet.get()) &&
	    	        	itemChest.equals(RegisterArmorsUpgrades.u_bee_chestplate.get()) &&
	    	       		itemLegs.equals(RegisterArmorsUpgrades.u_bee_leggings.get())) {

   					player.addPotionEffect(new EffectInstance(RegisterEffects.BEETALION, 37200, 3, false, false, true));
	    			
	    		} else {

   					player.addPotionEffect(new EffectInstance(RegisterEffects.BEETALION, 37200, 0, false, false, true));
	    			
	    		}
	        }
		}
	}


	@SubscribeEvent
	public static void bladeBuffsRemove(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
		PlayerEntity player = (PlayerEntity) event.getEntity();
		Item FROM = event.getFrom().getItem();
		
		if (FROM.getTags().toString().contains("wither_spine")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("wither_spine")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.WITHERBLADE);
				}
	    	}
		
		if (FROM.getTags().toString().contains("fire_heart")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("fire_heart")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.FIREBLADE);
				}
	    	}
		
		if (FROM.getTags().toString().contains("venom_sack")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("venom_sack")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.POISONBLADE);
				}
	    	}
		
		if (FROM.getTags().toString().contains("vampire_fang")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("vampire_fang")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.VAMPIRE);
				}
	    	}
		
		if (FROM.getTags().toString().contains("witch_book")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("witch_book")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.MAGICBLADE);
				}
	    	}
		
		if (FROM.getTags().toString().contains("witch_know")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("witch_know")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.EXPHEAL);
				}
	    	}
		
		if (FROM.getTags().toString().contains("super_ink_sack")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("super_ink_sack")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.INKYDEFENSE);
				}
	    	}
		
		if (FROM.getTags().toString().contains("fox_tail")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("fox_tail")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.THIEFBLADE);
				}
	    	}
		if (FROM.getTags().toString().contains("piglin_respect")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem().getTags().toString().contains("piglin_respect")) {  
	    		return;
	    	} else {
	    			player.removePotionEffect(RegisterEffects.PIGLINIGNORE);
				}
	    	}
		}
		
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveNightVision(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("night_vision")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("night_vision") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("night_vision") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("night_vision") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("night_vision")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.NIGHT_VISION);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveCorpseEater(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("corpse_eater")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("corpse_eater") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("corpse_eater") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("corpse_eater") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("corpse_eater")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.CORPSEEATER);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveVampire(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("vampire")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("vampire") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("vampire") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("vampire") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("vampire")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.VAMPIRE);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveHunger(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("hunger")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("hunger") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("hunger") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("hunger") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("hunger")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.HUNGER);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveUndeadIgnore(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("undead_ignore")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("undead_ignore") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("undead_ignore") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("undead_ignore") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("undead_ignore")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.UNDEADIGNORE);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemovePackLeader(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("pack_leader")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("pack_leader") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("pack_leader") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("pack_leader") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("pack_leader")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.PACKLEADER);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveFireResist(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("fire_resist")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("fire_resist") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("fire_resist") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("fire_resist") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("fire_resist")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.FIRE_RESISTANCE);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveThornsBees(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("thorns_bees")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("thorns_bees") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("thorns_bees") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("thorns_bees") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("thorns_bees")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.BEETALION);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveGuardianAura(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("guardian_aura")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("guardian_aura") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("guardian_aura") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("guardian_aura") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("guardian_aura")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.GUARDAINARMOR);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveRammingStrength(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("ramming")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("ramming") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("ramming") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("ramming") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("ramming")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.GOATSTRENGTH);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveJumpBoost(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("jump_boost")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("jump_boost") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("jump_boost") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("jump_boost") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("jump_boost")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.JUMP_BOOST);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveSlowFall(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("slow_fall")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("slow_fall") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("slow_fall") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("slow_fall") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("slow_fall")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.SLOW_FALLING);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveRangePower(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("range_power")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("range_power") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("range_power") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("range_power") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("range_power")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.RANGESTRENGTH);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveMeleePower(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("strength")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("strength") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("strength") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("strength") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("strength")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.STRENGTH);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemovePoisonResist(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("poison_resist")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("poison_resist") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("poison_resist") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("poison_resist") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("poison_resist")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.POISONRESIST);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemovePhantomIgnore(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("phantom_ignore")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("phantom_ignore") ||
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("phantom_ignore") ||
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("phantom_ignore") ||
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("phantom_ignore")) {  
	    		return;
	    	} else {
					player.removePotionEffect(RegisterEffects.PHANTOMIGNORE);
				}
	    	}
		}
	}
	
	@SubscribeEvent
	public static void armorBuffRemoveDolphinGrace(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			Item FROM = event.getFrom().getItem();
			
			
        	if (FROM.getTags().toString().contains("dolphin_grace")) {
	    	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().getTags().toString().contains("dolphin_grace") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().getTags().toString().contains("dolphin_grace") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().getTags().toString().contains("dolphin_grace") &&
	    			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().getTags().toString().contains("dolphin_grace")) {  
	    		return;
	    	} else {
					player.removePotionEffect(Effects.DOLPHINS_GRACE);
				}
	    	}
		}
	}

	
	
	
}
