package com.aavri.craftandhunt.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemHearthstone extends Item {

	private static int duration = 25;	
	
    public ItemHearthstone(Properties properties) {
        super(properties.maxStackSize(1).maxDamage(1));
    }
    
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        player.setActiveHand(hand);
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }
    

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
        if(!world.isRemote()) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity; 
            if(world.getDimensionKey().equals(World.OVERWORLD))  { //if dimension is Overworld
                if(player.func_241140_K_() != null) {                	
                	BlockPos bedLoc = player.func_241140_K_(); //get player bed position               	
                	player.func_241140_K_();
                	if (player.isPassenger()) {
                		player.stopRiding();
                	}
                    setPositionAndUpdate(entity, world, bedLoc);
                    stack.damageItem(1, player, (p_220039_0_) -> {
                        p_220039_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                    });
                } else {
                	player.setPositionAndUpdate(world.getWorldInfo().getSpawnX(), world.getWorldInfo().getSpawnY(), world.getWorldInfo().getSpawnZ());
                	stack.damageItem(1, player, (p_220039_0_) -> {
                        p_220039_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                    });
                }
            } else {
            }
        }
        return stack;        
    }    
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return duration;
    }
    
    public void setPositionAndUpdate(LivingEntity entity, World world, BlockPos bedLoc) {
        entity.setPositionAndUpdate(bedLoc.getX() + 0.5F, bedLoc.getY() + 0.6F, bedLoc.getZ() + 0.5F);
        entity.fallDistance = 0;
    }
    
    @Override
    public UseAction getUseAction (ItemStack stack) {
        return UseAction.BOW;
    } 
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(1, this.genericIntroText());
    }
    
    @OnlyIn(Dist.CLIENT)
    public ITextComponent genericIntroText() {
       return new StringTextComponent("Returns the player to their bed if in the overworld.").mergeStyle(TextFormatting.GRAY);
    }

}

