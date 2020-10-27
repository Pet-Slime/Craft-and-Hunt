package com.aavri.craftandhunt.items.Offhand;

import java.util.List;

import javax.annotation.Nullable;

import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.EvokerFangsEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemEvokersBook extends Item {


	public ItemEvokersBook(Properties properties) {
        super(properties.maxStackSize(1));
    }
    
	public PlayerEntity playerSpell = null;
	
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
        } else if (offhandSlot.getItem().equals(RegisterOffhand.evokers_book.get())) {
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
		double d0 = Math.min(y, playerIn.getPosY());
        double d1 = Math.max(y, playerIn.getPosY()) + 1.0D;
        playerSpell = playerIn;
        float f = (float)MathHelper.atan2(z - playerIn.getPosZ(), x - playerIn.getPosX());
        if (playerIn.getDistanceSq(x, y, z) < 9.0D) {
           for(int i = 0; i < 5; ++i) {
              float f1 = f + (float)i * (float)Math.PI * 0.4F;
              this.spawnFangs(playerIn.getPosX() + (double)MathHelper.cos(f1) * 1.5D, playerIn.getPosZ() + (double)MathHelper.sin(f1) * 1.5D, d0, d1, f1, 0);
           }

           for(int k = 0; k < 8; ++k) {
              float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
              this.spawnFangs(playerIn.getPosX() + (double)MathHelper.cos(f2) * 2.5D, playerIn.getPosZ() + (double)MathHelper.sin(f2) * 2.5D, d0, d1, f2, 3);
           }
        } else {
           for(int l = 0; l < 16; ++l) {
              double d2 = 1.25D * (double)(l + 1);
              int j = 1 * l;
              this.spawnFangs(playerIn.getPosX() + (double)MathHelper.cos(f) * d2, playerIn.getPosZ() + (double)MathHelper.sin(f) * d2, d0, d1, f, j);
           }
        }
	

	if (playerIn.isCreative() ) {
		playerIn.getCooldownTracker().setCooldown(this, 8);
	} else {
		playerIn.getCooldownTracker().setCooldown(this, 128);
		playerIn.getItemStackFromSlot(EquipmentSlotType.OFFHAND).damageItem(1, playerIn,  (p_220038_0_) -> {
			p_220038_0_.sendBreakAnimation(EquipmentSlotType.OFFHAND);
			});
	}
    	
    }
    
    private void spawnFangs(double p_190876_1_, double p_190876_3_, double p_190876_5_, double p_190876_7_, float p_190876_9_, int p_190876_10_) {
        BlockPos blockpos = new BlockPos(p_190876_1_, p_190876_7_, p_190876_3_);
        boolean flag = false;
        double d0 = 0.0D;

        do {
           BlockPos blockpos1 = blockpos.down();
           BlockState blockstate = playerSpell.world.getBlockState(blockpos1);
           if (blockstate.isSolidSide(playerSpell.world, blockpos1, Direction.UP)) {
              if (!playerSpell.world.isAirBlock(blockpos)) {
                 BlockState blockstate1 = playerSpell.world.getBlockState(blockpos);
                 VoxelShape voxelshape = blockstate1.getCollisionShape(playerSpell.world, blockpos);
                 if (!voxelshape.isEmpty()) {
                    d0 = voxelshape.getEnd(Direction.Axis.Y);
                 }
              }

              flag = true;
              break;
           }

           blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(p_190876_5_) - 1);

        if (flag) {
        	playerSpell.world.addEntity(new EvokerFangsEntity(playerSpell.world, p_190876_1_, (double)blockpos.getY() + d0, p_190876_3_, p_190876_9_, p_190876_10_, playerSpell));
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

