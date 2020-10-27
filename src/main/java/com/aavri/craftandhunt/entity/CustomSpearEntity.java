package com.aavri.craftandhunt.entity;

import javax.annotation.Nullable;

//Minecraft stuff
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
//Forge stuff
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class CustomSpearEntity extends AbstractArrowEntity {
	private static DataParameter<Byte> LVL_LOYALTY;
	private static DataParameter<Boolean> LVL_FOIL;
	public static EntityType<?> stringType;
	private ItemStack tridentItem;
	private boolean dealtDamage;
	public int returningTicks;
	private float damage;
	private Item test;

	public CustomSpearEntity(EntityType<? extends CustomSpearEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.tridentItem = getItem();
		this.stringType = this.getEntity().getType();
	}

	private ItemStack getItem() {
		return new ItemStack(test);
	}
	
	public static EntityType<?> getStuff() {
		return stringType;
	}

	public CustomSpearEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn, LivingEntity entity, ItemStack stack, float damage) {
		super(type, entity, worldIn);
		this.damage = damage+1;
		this.test = stack.getItem();
		this.tridentItem = stack.copy();
		this.dataManager.<Byte>set(CustomSpearEntity.LVL_LOYALTY, (byte)EnchantmentHelper.getLoyaltyModifier(stack));
		this.dataManager.<Boolean>set(CustomSpearEntity.LVL_FOIL, stack.hasEffect());
	}

	public CustomSpearEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn, double x, double y, double z){
		super(type, x, y, z, worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.<Byte>register(CustomSpearEntity.LVL_LOYALTY, (byte)0);
		this.dataManager.<Boolean>register(CustomSpearEntity.LVL_FOIL, false);
	}

	@Override
	public void tick() {
		if (this.timeInGround > 4) {
			this.dealtDamage = true;
		}

		Entity owner = this.func_234616_v_();

		if ((this.dealtDamage || this.getNoClip()) && owner != null) {
			int loyalty = this.dataManager.<Byte>get(CustomSpearEntity.LVL_LOYALTY);

			if (loyalty > 0 && !this.shouldReturnToThrower()) {

				if (!this.world.isRemote && this.pickupStatus == PickupStatus.ALLOWED) {
                 this.entityDropItem(this.getArrowStack(), 0.1f);
				}

				this.remove();
			} else if (loyalty > 0) {
				this.setNoClip(true);
				Vector3d vec = new Vector3d(owner.getPosX()-this.getPosX(), owner.getPosYEye()-this.getPosY(), owner.getPosZ()-this.getPosZ());
				this.setRawPosition(this.getPosX(), this.getPosY()+vec.y*0.015*loyalty, this.getPosZ());

				if (this.world.isRemote) {
					this.lastTickPosY = this.getPosY();
				}

				double loyaltyMult = 0.05*loyalty;
				this.setMotion(this.getMotion().scale(0.95).add(vec.normalize().scale(loyaltyMult)));

				if (this.returningTicks == 0) {
                 this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0f, 1.0f);
				}

				++this.returningTicks;
			}
		}

		super.tick();
	}

	private boolean shouldReturnToThrower() {
		Entity owner = this.func_234616_v_();
		return owner != null && owner.isAlive() && (!(owner instanceof ServerPlayerEntity) || !owner.isSpectator());
	}

	@Override
	protected ItemStack getArrowStack() {
		return this.tridentItem.copy();
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isFoil() {
		return this.dataManager.<Boolean>get(CustomSpearEntity.LVL_FOIL);
	}

	@Nullable
	@Override
	protected EntityRayTraceResult rayTraceEntities(Vector3d startVec, Vector3d endVec) {
		if (this.dealtDamage) {
			return null;
		}
		return super.rayTraceEntities(startVec, endVec);
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		Entity entity1 = result.getEntity();
		float thrownDamage = damage/2;

		if (entity1 instanceof LivingEntity) {
			LivingEntity entity2 = (LivingEntity)entity1;
			thrownDamage += EnchantmentHelper.getModifierForCreature(this.tridentItem, entity2.getCreatureAttribute());
		}

		Entity owner = this.func_234616_v_();
		DamageSource source = DamageSource.causeTridentDamage(this, (owner == null) ? this : owner);
		this.dealtDamage = true;
		SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;

		if (entity1.attackEntityFrom(source, thrownDamage)) {
			if (entity1.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity1 instanceof LivingEntity) {
				LivingEntity entity2 = (LivingEntity)entity1;

				if (owner instanceof LivingEntity) {
					EnchantmentHelper.applyThornEnchantments(entity2, owner);
					EnchantmentHelper.applyArthropodEnchantments((LivingEntity)owner, entity2);
				}

				this.arrowHit(entity2);
			}
		}

		this.setMotion(this.getMotion().mul(-0.01, -0.1, -0.01));
		float vol = 1.0f;
	       if (this.world instanceof ServerWorld && this.world.isThundering() && EnchantmentHelper.hasChanneling(this.tridentItem)) {
	            BlockPos position = entity1.getPosition();
	            if (this.world.canSeeSky(position)) {
	                LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(this.world);
	                lightning.moveForced(Vector3d.copyCenteredHorizontally(position));
	                lightning.setCaster((owner instanceof ServerPlayerEntity) ? ((ServerPlayerEntity)owner) : null);
	                this.world.addEntity(lightning);
	                soundEvent = SoundEvents.ITEM_TRIDENT_THUNDER;
	                vol = 5.0f;
	            }
	        }


		this.playSound(soundEvent, vol, 1.0f);
	}

	@Override
	protected SoundEvent getHitEntitySound() {
		return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
	}

	@Override
	public void onCollideWithPlayer(PlayerEntity player) {
		Entity owner = this.func_234616_v_();

		if (owner != null && owner.getUniqueID() != player.getUniqueID()) {
			return;
		}

		super.onCollideWithPlayer(player);
	}

	@Override
	public void readAdditional(CompoundNBT nbt) {
		super.readAdditional(nbt);

		if (nbt.contains("Trident", 10)) {
         this.tridentItem = ItemStack.read(nbt.getCompound("Trident"));
		}

		this.dealtDamage = nbt.getBoolean("DealtDamage");
		this.dataManager.<Byte>set(CustomSpearEntity.LVL_LOYALTY, (byte)EnchantmentHelper.getLoyaltyModifier(this.tridentItem));
	}

	@Override
	public void writeAdditional(CompoundNBT nbt) {
		super.writeAdditional(nbt);
     	nbt.put("Trident", (CompoundNBT)this.tridentItem.write(new CompoundNBT()));
     	nbt.putBoolean("DealtDamage", this.dealtDamage);
	}

	public void func_225516_i_() {
		int loyalty = this.dataManager.<Byte>get(CustomSpearEntity.LVL_LOYALTY);
		if (this.pickupStatus != PickupStatus.ALLOWED || loyalty <= 0) {
         super.func_225516_i_();
		}
	}

	@Override
	protected float getWaterDrag() {
		return 0.99f;
	}

	@Override
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return true;
	}

	static {
		LVL_LOYALTY = EntityDataManager.<Byte>createKey(CustomSpearEntity.class, DataSerializers.BYTE);
		LVL_FOIL = EntityDataManager.<Boolean>createKey(CustomSpearEntity.class, DataSerializers.BOOLEAN);
	}
}