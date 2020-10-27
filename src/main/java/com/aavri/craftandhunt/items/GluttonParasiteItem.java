package com.aavri.craftandhunt.items;

import java.util.Random;

import com.aavri.craftandhunt.init.RegisterItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class GluttonParasiteItem extends Item {

	private final int damageTotal;

	public GluttonParasiteItem(Properties properties, int damage) {
		super(properties.maxDamage(damage));
		this.damageTotal = damage;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		Random random = new Random();
		if(random.nextInt(99) <= 50) {
			int damage = stack.getDamage();
			stack.setDamage(damage+1);
			if (stack.getDamage() == damageTotal) {
				PlayerEntity player = (PlayerEntity) entityIn;
		        player.addStat(Stats.ITEM_USED.get(this));
				ItemStack olditem = stack;
				ItemStack newitem = new ItemStack(RegisterItems.parasite_starved.get());
				olditem.shrink(1);
				if (olditem.isEmpty()) {
					player.inventory.addItemStackToInventory(newitem);
				} else {
		              player.dropItem(newitem, false);
				}
			}
		}
	}
}
