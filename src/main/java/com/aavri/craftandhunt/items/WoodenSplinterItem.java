package com.aavri.craftandhunt.items;

import com.aavri.craftandhunt.init.RegisterItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WoodenSplinterItem extends Item {

	public WoodenSplinterItem(Properties properties) {
		super(properties);
	}
	
	
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.attackEntityFrom(DamageSource.GENERIC, 4.0F);
        return new ActionResult<>(ActionResultType.SUCCESS, this.turnIntoItem(itemstack, playerIn, new ItemStack(RegisterItems.branch_splinter_bloody.get())));
    }
    
    
    protected ItemStack turnIntoItem(ItemStack p_185061_1_, PlayerEntity player, ItemStack stack) {
    	p_185061_1_.shrink(1);
        player.addStat(Stats.ITEM_USED.get(this));
        if (p_185061_1_.isEmpty()) {
           return stack;
        } else {
           if (!player.inventory.addItemStackToInventory(stack)) {
              player.dropItem(stack, false);
           }
           return p_185061_1_;
        }
    }
}
