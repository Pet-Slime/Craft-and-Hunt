package com.aavri.craftandhunt.entity;

import com.aavri.craftandhunt.event.DamageSourceNew;
import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class IronSummonEntity extends IronGolemEntity {
	

	private PlayerEntity owner;
	private boolean limitedLifespan;
	private int limitedLifeTicks;
	
	public IronSummonEntity(EntityType<? extends IronGolemEntity> type, World worldIn) {
        super(type, worldIn);
    }
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
	    this.goalSelector.addGoal(3, new TemptGoal(this, 2.25D, Ingredient.fromItems(RegisterOffhand.golem_kit.get()), false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
	    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::func_233680_b_));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
	   }
	
   
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
        								 .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
        								 .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
        								 .createMutableAttribute(Attributes.ATTACK_DAMAGE, 15.0D);
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

        if (!this.world.isRemote) {
           this.func_241359_a_((ServerWorld)this.world, true);
        }

     }
    

}