package com.aavri.craftandhunt.items.tools;

import com.aavri.craftandhunt.entity.CustomSpearEntity;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

// Minecraft stuff
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class SpearItem extends TieredItem {


	private final Multimap<Attribute, AttributeModifier> spearAttributes;
    private final float damage;
    private EntityType type;

    public SpearItem(EntityType type, IItemTier tier, float damage, float speed, Properties itemGroup) {
        super(tier, itemGroup);
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)-speed, AttributeModifier.Operation.ADDITION));
        this.spearAttributes = builder.build();
        this.damage = damage;
        this.type = type;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return  72000;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entity, int time) {
        if (!(entity instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity player = (PlayerEntity)entity;
        int time2 = this.getUseDuration(stack)-time;

        if (time2 < 10) {
            return;
        }

        int riptide = EnchantmentHelper.getRiptideModifier(stack);

        if (riptide > 0 && !player.isWet()) {
            return;
        }

        if (!worldIn.isRemote) {
            stack.damageItem(1, player, PlayerEntity -> player.sendBreakAnimation(entity.getActiveHand()));

            if (riptide == 0) {
                CustomSpearEntity tridentEntity = new CustomSpearEntity(type, worldIn, player, stack, damage);
                tridentEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, 2.5f+riptide*0.5f, 1.0f);
                
                if (player.abilities.isCreativeMode) {
                    tridentEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                }

                worldIn.addEntity(tridentEntity);
                worldIn.playMovingSound(null, tridentEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0f, 1.0f);
                
                if (!player.abilities.isCreativeMode) {
                    player.inventory.deleteStack(stack);
                }
            }
        }

        player.addStat(Stats.ITEM_USED.get(this));
        if (riptide > 0) {
            float rotationY = player.rotationYaw;
            float rotationX = player.rotationPitch;

            float math1 = -MathHelper.sin(rotationY*((float)Math.PI/180f))*MathHelper.cos(rotationX*((float)Math.PI/180f));
            float math2 = -MathHelper.sin(rotationX*((float)Math.PI/180f));
            float math3 = MathHelper.cos(rotationY*((float)Math.PI/180f))*MathHelper.cos(rotationX*((float)Math.PI/180f));
            
            float math4 = MathHelper.sqrt(math1*math1+math2*math2+math3*math3);
            float math5 = 3.0f*((1.0f+(float)riptide)/4.0f);
            
            math1 *= math5/math4;
            math2 *= math5/math4;
            math3 *= math5/math4;

            player.addVelocity((double)math1, (double)math2, (double)math3);
            player.startSpinAttack(20);
            
            if (!player.isAirBorne) {
                @SuppressWarnings("unused")
                float math6 = 1.1999999f;

                player.move(MoverType.SELF, new Vector3d(0.0, 1.1999999284744263, 0.0));
            }

            SoundEvent soundEvent;

            if (riptide >= 3) {
                soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_3;
            }
            else if (riptide == 2) {
                soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_2;
            }
            else {
                soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_1;
            }

            worldIn.playMovingSound(null, player, soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (stack.getDamage() >= stack.getMaxDamage()-1) {
            return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
        }

        if (EnchantmentHelper.getRiptideModifier(stack) > 0 && !player.isWet()) {
            return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
        }

        player.setActiveHand(hand);
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    	stack.damageItem(1, attacker, (entity) -> {
            entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
         });
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos position, LivingEntity entity) {
        if (state.getBlockHardness(worldIn, position) != 0.0) {
            stack.damageItem(2, entity, LivingEntity -> LivingEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND));
        }
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        return equipmentSlot == EquipmentSlotType.MAINHAND ? this.spearAttributes : super.getAttributeModifiers(equipmentSlot);
     }
}
