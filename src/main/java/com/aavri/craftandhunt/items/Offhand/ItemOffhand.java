package com.aavri.craftandhunt.items.Offhand;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemOffhand extends Item {


    public ItemOffhand(Properties properties) {
        super(properties);
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
        } else {
            return new ActionResult<>(ActionResultType.FAIL, itemstack);
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

