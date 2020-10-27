package com.aavri.craftandhunt.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BoneAshBottleItem extends Item {


    public BoneAshBottleItem(Item.Properties builder) {
        super(builder);
    }
    
    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
       ItemStack itemstack = playerIn.getHeldItem(handIn);
          RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
          if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
        	  return new ActionResult<>(ActionResultType.FAIL, itemstack);
          } else {
             if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getPos();
                if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                   worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                   return new ActionResult<>(ActionResultType.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(Items.SLIME_BALL)));
                }
             }
             return new ActionResult<>(ActionResultType.PASS, itemstack);
          }
       }
    

    protected ItemStack turnBottleIntoItem(ItemStack p_185061_1_, PlayerEntity player, ItemStack stack) {
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

