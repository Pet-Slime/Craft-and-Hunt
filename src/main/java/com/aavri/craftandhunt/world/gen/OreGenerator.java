package com.aavri.craftandhunt.world.gen;

import com.aavri.craftandhunt.init.RegisterBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGenerator {
	
    protected static ConfiguredFeature<?, ?> PUMICE_STONE;
	
    public static boolean checkAndInitBiome(BiomeLoadingEvent event) {
    	if (event.getCategory() == Biome.Category.NETHER) {
    		initNetherFeatures();
    		return true;
        } else if (event.getCategory() != Biome.Category.THEEND) {
            return true;
        }
        return false;
    } 
    // end checkBiome
    
    protected static void initNetherFeatures() {
    	if (PUMICE_STONE != null) return;
        PUMICE_STONE = buildNetherOreFeature(RegisterBlocks.pumice.get().getDefaultState(), range(1, 0, 64), 25, 1);
    } 
    // end-initNetherFeatures()
	
	
	public static ConfiguredFeature<?, ?> buildNetherOreFeature(BlockState bstate, TopSolidRangeConfig cfg, int vein_size, int vein_count) {
		return Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, bstate, vein_size))
                		.withPlacement(Placement.field_242907_l.configure(cfg)
                        .func_242728_a().func_242731_b(vein_count));
    }
	
	public static  TopSolidRangeConfig range(int bottom_offset, int top_offset , int maximum) {
		return new TopSolidRangeConfig(bottom_offset, top_offset, maximum);
	}
	
	public static void generateNetherOres(BiomeLoadingEvent event) {
		event.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGenerator.PUMICE_STONE);
    }
}
