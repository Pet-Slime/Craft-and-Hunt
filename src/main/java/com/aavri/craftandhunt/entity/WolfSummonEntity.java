package com.aavri.craftandhunt.entity;

import com.aavri.craftandhunt.event.DamageSourceNew;
import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WolfSummonEntity extends CreatureEntity {
	

	private PlayerEntity owner;
	private boolean limitedLifespan;
	private int limitedLifeTicks;
	
	public WolfSummonEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }
	
	@Override
	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, true));
		this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 1.0D, 32.0F));
	    this.goalSelector.addGoal(5, new TemptGoal(this, 2.25D, Ingredient.fromItems(RegisterOffhand.tasty_bone.get()), false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
	   }
	
   
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
        								 .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0D)
        								 .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
    }
    
    public PlayerEntity getOwner() {
        return this.owner;
    }
    
    public void setOwner(PlayerEntity playerIn) {
        this.owner = playerIn;
     }
    
    public void setLimitedLife(int limitedLifeTicksIn) {
        this.limitedLifespan = true;
        this.limitedLifeTicks = limitedLifeTicksIn;
     }
    
    
    public void livingTick() {
        super.livingTick();
        if (this.limitedLifespan && --this.limitedLifeTicks <= 0) {
            this.limitedLifeTicks = 20;
            this.attackEntityFrom(DamageSourceNew.KILLSUMMON, 10000.0F);
         }
        if (horizontalMag(this.getMotion()) > (double)2.5000003E-7F && this.rand.nextInt(5) == 0) {
           int i = MathHelper.floor(this.getPosX());
           int j = MathHelper.floor(this.getPosY() - (double)0.2F);
           int k = MathHelper.floor(this.getPosZ());
           BlockPos pos = new BlockPos(i, j, k);
           BlockState blockstate = this.world.getBlockState(pos);
           if (!blockstate.isAir(this.world, pos)) {
              this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getPosX() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), this.getPosY() + 0.1D, this.getPosZ() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
           }
        }
     }
    
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WOLF_HURT;
     }
    
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
     }
    
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WOLF_PANT;
     }
    
    protected float getSoundVolume() {
        return 0.4F;
     }
    
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
     }
    

}