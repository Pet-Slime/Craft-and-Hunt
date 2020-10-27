package com.aavri.craftandhunt.event;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.init.RegisterEffects;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class FoxThiefEventHandler {
	
	
	public static Item getRandomItem() {
		  ArrayList<Item> ITEM = new ArrayList<>(ForgeRegistries.ITEMS.getValues());
		  Predicate<? super Item> filter = item -> true == item.getItem().getTags().toString().contains("banned_random_item_drop");
		  ITEM.removeIf(filter);
		  int randomInt = new Random().nextInt(ITEM.size());
		  return ITEM.get(randomInt);
		}
	
	
	@SubscribeEvent
    public static void LivingHurt(LivingHurtEvent event) {
		
		//Do blade buffs on the player applied to a mob
		if(event.getSource().getTrueSource() instanceof LivingEntity) {
			LivingEntity player = (LivingEntity) event.getSource().getTrueSource();
			if(player.isPotionActive(RegisterEffects.THIEFBLADE)) {
				player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, player,  (p_220038_0_) -> {
	                p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
	             });
				Random random = new Random();
				double LUCK = player.getAttribute(Attributes.LUCK).getValue();
				int LOOTING = EnchantmentHelper.getLootingModifier(player);
				
				
				if(random.nextInt(99) <= (Config.fox_loot_chance.get() + LUCK*2)) {
					int itemDropAmount = (int) (1);
					event.getEntityLiving().entityDropItem(new ItemStack(getRandomItem(), itemDropAmount));
					if (LOOTING > 0) {
						if(random.nextInt(99) <= (Config.fox_loot_chance.get() + LUCK*2 + LOOTING)) {
							int itemDropAmountLoot = (int) (1);
							event.getEntityLiving().entityDropItem(new ItemStack(getRandomItem(), itemDropAmountLoot));
						}
					}
				}	
			}
		}
    }
}
