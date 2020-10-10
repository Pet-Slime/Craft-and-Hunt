package com.aavri.craftandhunt.items.tools;

import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.util.RegisterItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class ToolMaterialbyItem {

    public static final IItemTier bone = new 			ToolMaterial(Config.bone_tool_harvestLevel.get(), 
    																	Config.bone_tool_durability.get(), 
    																	Config.bone_tool_efficiency.get().floatValue(), 
    																	Config.bone_tool_attackDamage.get().floatValue(), 
    																	Config.bone_tool_enchantability.get(), 
    																	Items.BONE);
    
    public static final IItemTier spider = new 			ToolMaterial(Config.spider_tool_harvestLevel.get(), 
    																	Config.spider_tool_durability.get(), 
    																	Config.spider_tool_efficiency.get().floatValue(), 
    																	Config.spider_tool_attackDamage.get().floatValue(), 
    																	Config.spider_tool_enchantability.get(), 
    																	RegisterItems.spider_chitin.get());
    
    public static final IItemTier spiderPoison = new 	ToolMaterial(Config.spider_tool_harvestLevel.get(), 
    																	(int) Math.round(Config.spider_tool_durability.get() * 1.25), 
    																	Config.spider_tool_efficiency.get().floatValue(), 
    																	(float) (Config.spider_tool_attackDamage.get() +0.5), 
    																	Config.spider_tool_enchantability.get(), 
    																	RegisterItems.spider_poison_chitin.get());
    
    public static final IItemTier spiderFermented = new ToolMaterial(Config.spider_tool_harvestLevel.get(), 
    																	(int) Math.round(Config.spider_tool_durability.get() * 1.25),
    																	Config.spider_tool_efficiency.get().floatValue(), 
    																	(float) (Config.spider_tool_attackDamage.get() +0.5), 
    																	Config.spider_tool_enchantability.get(), 
    																	RegisterItems.spider_fermented_chitin.get());  
    
    public static final IItemTier wither = new			ToolMaterial(Config.wither_tool_harvestLevel.get(), 
    																	Config.wither_tool_durability.get(), 
    																	Config.wither_tool_efficiency.get().floatValue(), 
    																	Config.wither_tool_attackDamage.get().floatValue(), 
    																	Config.wither_tool_enchantability.get(), Items.BONE);
    
    public static final IItemTier shell = new 			ToolMaterial(Config.shell_tool_harvestLevel.get(), 
    																	Config.shell_tool_durability.get(), 
    																	Config.shell_tool_efficiency.get().floatValue(), 
    																	Config.shell_tool_attackDamage.get().floatValue(),
    																	Config.shell_tool_enchantability.get(), 
    																	Items.SCUTE);
    
    public static final IItemTier blaze = new 			ToolMaterial(Config.blaze_tool_harvestLevel.get(), 
    																	Config.blaze_tool_durability.get(), 
    																	Config.blaze_tool_efficiency.get().floatValue(), 
    																	Config.blaze_tool_attackDamage.get().floatValue(), 
    																	Config.blaze_tool_enchantability.get(), 
    																	RegisterItems.blaze_glass.get());
    
    public static final IItemTier shulker = new 		ToolMaterial(Config.shulker_tool_harvestLevel.get(), 
    																	Config.shulker_tool_durability.get(), 
    																	Config.shulker_tool_efficiency.get().floatValue(),
    																	Config.shulker_tool_attackDamage.get().floatValue(), 
    																	Config.shulker_tool_enchantability.get(), 
    																	Items.SHULKER_SHELL);
    
    public static final IItemTier shark = new 			ToolMaterial(Config.shark_tool_harvestLevel.get(), 
    																	Config.shark_tool_durability.get(), 
    																	Config.shark_tool_efficiency.get().floatValue(), 
    																	Config.shark_tool_attackDamage.get().floatValue(), 
    																	Config.shark_tool_enchantability.get(), 
    																	RegisterItems.thrasher_tooth.get());

    
    private static class ToolMaterial implements IItemTier{

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Item repairMaterial;

        public ToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Item repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(this.repairMaterial);
        }
    }


}
