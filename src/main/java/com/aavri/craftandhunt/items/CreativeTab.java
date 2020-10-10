package com.aavri.craftandhunt.items;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTab extends ItemGroup {
	
	public final static CreativeTab HUNT = new CreativeTab();

    public CreativeTab(){
        super("CaH");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon(){
        return new ItemStack(Items.CROSSBOW);
    }

}
