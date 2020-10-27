package com.aavri.craftandhunt.items.armor;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.config.Config;
import com.aavri.craftandhunt.data.ModTags;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

public class ArmorMaterialByTag {

	/// Feet, Legs, Chest, Head

	public final static IArmorMaterial crab = new ArmorMaterial(Constants.MOD_ID + ":crab",	Config.crab_durabilityValue.get(), 	
												new int[]{Config.crab_bootsdefense.get(), Config.crab_legsdefense.get(), Config.crab_chestdefense.get(), Config.crab_helmDefense.get()},
												Config.crab_enchantability.get(), SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, Config.crab_toughness.get().floatValue(), (float) (Config.crab_knockbackResistance.get() * 0.1), ModTags.CRABSHELL);		
	
	public final static IArmorMaterial t_iron = new ArmorMaterial(Constants.MOD_ID + ":t_iron", 15, new int[]{2, 5, 6, 2}, 14, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, Tags.Items.INGOTS_IRON);
	
	public final static IArmorMaterial t_diamond = new ArmorMaterial(Constants.MOD_ID + ":t_diamond",33, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, Tags.Items.GEMS_DIAMOND);
	
	public final static IArmorMaterial t_netherite = new ArmorMaterial(Constants.MOD_ID + ":t_netherite", 37, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, Tags.Items.INGOTS_NETHERITE);
											
    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final float knockbackResistance;
        private final INamedTag<Item> repairMaterial;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, INamedTag<Item> tag) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairMaterial = tag;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }
        
        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
         }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromTag(this.repairMaterial);
        }

        @Override
        public float getToughness() {
            return toughness;
        }


		@Override
		public float getKnockbackResistance() {
		      return this.knockbackResistance;
		}
    }
}
