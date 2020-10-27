package com.aavri.craftandhunt.items.Offhand;

import java.util.List;

import javax.annotation.Nullable;

import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFireChargeRod extends Item {


	public ItemFireChargeRod(Properties properties) {
        super(properties.maxStackSize(1).maxDamage(384));
    }
    
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack)
    {
        return EquipmentSlotType.OFFHAND;
    } 
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        EquipmentSlotType equipmentslottype = EquipmentSlotType.OFFHAND;
        ItemStack offhandSlot = playerIn.getItemStackFromSlot(equipmentslottype);
        if (offhandSlot.isEmpty()) {
           playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
           itemstack.setCount(0);
           return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
        } else if (offhandSlot.getItem().equals(RegisterOffhand.firecharge_rod.get())) {
        	castSpell(worldIn, playerIn);
        	return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
        }
        else {
            return new ActionResult<>(ActionResultType.FAIL, itemstack);
         }
    }
    
    public void castSpell(World worldIn, PlayerEntity playerIn) {
    	RayTraceResult lookingAt = Minecraft.getInstance().objectMouseOver;
	    double x = lookingAt.getHitVec().getX();
	    double y = lookingAt.getHitVec().getY();
	    double z = lookingAt.getHitVec().getZ();
	    double x2 = playerIn.getPosX();
	    double y2 = playerIn.getPosY();
	    double z2 = playerIn.getPosZ();
	    FireballEntity fireball = new FireballEntity(worldIn, x2, y2+2, z2, x-x2, y-y2-1.75, z-z2);
	    worldIn.addEntity(fireball);
	    if (playerIn.isCreative() ) {
	    	playerIn.getCooldownTracker().setCooldown(this, 5);
	    } else {
		playerIn.getCooldownTracker().setCooldown(this, 128);
		playerIn.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, playerIn,  (p_220038_0_) -> {
			p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
			});
	    }
    }


	@Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(1, this.genericIntroText());
       tooltip.add(2, this.getOffHandItemDesc());
    }
    
    @OnlyIn(Dist.CLIENT)
    public ITextComponent genericIntroText() {
       return new StringTextComponent("When in off hand:").mergeStyle(TextFormatting.GRAY);
    }
    
    @OnlyIn(Dist.CLIENT)
    public ITextComponent getOffHandItemDesc() {
       return new TranslationTextComponent(this.getTranslationKey() + ".desc").mergeStyle(TextFormatting.GOLD);
    }
	
}

