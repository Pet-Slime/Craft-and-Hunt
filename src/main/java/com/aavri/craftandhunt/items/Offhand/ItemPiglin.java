package com.aavri.craftandhunt.items.Offhand;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemPiglin extends Item {
	private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    private final float knockbackResistance;
    protected final EquipmentSlotType slot;
    private final float toughness;
    private final Multimap<Attribute, AttributeModifier> field_234656_m_;


	public ItemPiglin(EquipmentSlotType slot, float toughness, float knockbackResistance, Properties properties) {
        super(properties.maxStackSize(1).maxDamage(384));
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.slot = slot;
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = ARMOR_MODIFIERS[slot.getIndex()];
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", (double)this.toughness, AttributeModifier.Operation.ADDITION));
        if (this.knockbackResistance > 0) {
           builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", (double)this.knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        
        this.field_234656_m_ = builder.build();
    }
	
	@Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
    
	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
	      return equipmentSlot == this.slot ? this.field_234656_m_ : super.getAttributeModifiers(equipmentSlot);
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
 
}

