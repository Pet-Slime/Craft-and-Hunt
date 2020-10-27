package com.aavri.craftandhunt.init;

import com.aavri.craftandhunt.Constants;
import com.aavri.craftandhunt.entity.CustomSpearEntity;
import com.aavri.craftandhunt.entity.IronSummonEntity;
import com.aavri.craftandhunt.entity.WolfSummonEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterEntityType {
	

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Constants.MOD_ID);
	
	
	public static void init() {
		ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	// Entity Types
    public static final RegistryObject<EntityType<IronSummonEntity>> IRONSUMMON = ENTITY_TYPES.register("iron_summon",
            () -> EntityType.Builder.create(IronSummonEntity::new, EntityClassification.MISC)
                    .size(1.4F, 2.7F)
                    .trackingRange(10)
                    .build(new ResourceLocation(Constants.MOD_ID, "iron_summon").toString()));
    
    public static final RegistryObject<EntityType<WolfSummonEntity>> WOLFSUMMON = ENTITY_TYPES.register("wolf_summon",
            () -> EntityType.Builder.create(WolfSummonEntity::new, EntityClassification.CREATURE)
                    .size(0.6F, 0.85F)
                    .trackingRange(10)
                    .build(new ResourceLocation(Constants.MOD_ID, "wolf_summon").toString()));
    
    
    

    public static final EntityType<CustomSpearEntity> SPEAR_TEST = create("spear_test", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_WOOD = create("spear_wooden", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_STONE = create("spear_stone", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_GOLD = create("spear_gold", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_IRON = create("spear_iron", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_DIAMOND = create("spear_diamond", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_NETHERITE = create("spear_netherite", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);

    public static final EntityType<CustomSpearEntity> SPEAR_BLAZE = create("spear_blaze", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_BONE = create("spear_bone", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_SHARK = create("spear_shark", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_SHULKER = create("spear_shulker", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_SPIDER = create("spear_spider", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_SPIDER_FERMENTED = create("spear_spider_fermented", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_SPIDER_POISON = create("spear_spider_poison", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    public static final EntityType<CustomSpearEntity> SPEAR_WITHER = create("spear_wither", CustomSpearEntity::new, EntityClassification.MISC, 0.1f, 0.1f);
    
    
    
    
    
    private static <T extends Entity> EntityType<T> create(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height) {
        EntityType<T> type = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(128).build(name);
        ENTITY_TYPES.register(name, () -> type);
        return type;
    }
   
}
