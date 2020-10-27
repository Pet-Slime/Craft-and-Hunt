package com.aavri.craftandhunt.data;

import java.util.function.Consumer;

import com.aavri.craftandhunt.CraftandHunt;
import com.aavri.craftandhunt.init.RegisterArmors;
import com.aavri.craftandhunt.init.RegisterArmorsUpgrades;
import com.aavri.craftandhunt.init.RegisterBlocks;
import com.aavri.craftandhunt.init.RegisterItems;
import com.aavri.craftandhunt.init.RegisterOffhand;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.data.SmithingRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.Tags;



public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    	
    	CraftandHunt.LOGGER.info("Hunter's Recipies");
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.blaze_glass_block_item.get())
                .patternLine("xxx")
                .patternLine("xxx")
                .patternLine("xxx")
                .key('x', RegisterItems.blaze_glass.get())
                .addCriterion("has_blaze_glass", hasItem(RegisterItems.blaze_glass.get()))
                .build(consumer, DataGenerators.rl("blaze_glass_to_blaze_glass_block"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.blaze_glass_block_pane_item.get())
        		.patternLine("xxx")
        		.key('x', RegisterItems.blaze_glass.get())
        		.addCriterion("has_blaze_glass", hasItem(RegisterItems.blaze_glass.get()))
        		.build(consumer, DataGenerators.rl("blaze_glass_to_blaze_glass_panes"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.blaze_glass_block_pane_item.get(), 18)
        		.patternLine("xxx")
        		.patternLine("xxx")
       			.key('x', RegisterBlocks.blaze_glass_block_item.get())
       			.addCriterion("has_blaze_glass", hasItem(RegisterItems.blaze_glass.get()))
       			.build(consumer, DataGenerators.rl("blaze_glass_block_to_blaze_glass_panes"));
        
        ShapelessRecipeBuilder.shapelessRecipe(RegisterItems.blaze_glass.get(), 9)
        		.addIngredient(RegisterBlocks.blaze_glass_block_item.get())
        		.addCriterion("has_blaze_glass", hasItem(RegisterItems.blaze_glass.get()))
        		.build(consumer, DataGenerators.rl("blaze_glass_block_to_blaze_glass"));
        
        ShapelessRecipeBuilder.shapelessRecipe(RegisterItems.blaze_glass.get(), 3)
				.addIngredient(RegisterBlocks.blaze_glass_block_pane_item.get())
				.addCriterion("has_blaze_glass", hasItem(RegisterItems.blaze_glass.get()))
				.build(consumer, DataGenerators.rl("blaze_glass_block_panes_to_blaze_glass"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.beartrap_item.get())
        		.patternLine("xxx")
        		.patternLine("xyx")
        		.patternLine("xxx")
        		.key('x', Items.IRON_BARS).key('y', Items.TRIPWIRE_HOOK)
        		.addCriterion("has_tripwire", hasItem(Items.TRIPWIRE_HOOK))
        		.build(consumer, DataGenerators.rl("bear_trap"));
        
        ShapelessRecipeBuilder.shapelessRecipe(RegisterBlocks.beartrappower_item.get())
				.addIngredient(RegisterBlocks.beartrap_item.get()).addIngredient(Tags.Items.DUSTS_REDSTONE)
				.addCriterion("has_bear_trap", hasItem(RegisterBlocks.beartrappower_item.get()))
				.build(consumer, DataGenerators.rl("bear_trap_powered"));
        
        ShapelessRecipeBuilder.shapelessRecipe(RegisterOffhand.impact_slime.get())
				.addIngredient(Tags.Items.OBSIDIAN).addIngredient(Tags.Items.SLIMEBALLS)
				.addCriterion("has_slimeball", hasItem(Tags.Items.SLIMEBALLS))
				.build(consumer, DataGenerators.rl("impact_slime"));
        
        ShapelessRecipeBuilder.shapelessRecipe(RegisterBlocks.bonespikes_item.get())
        		.addIngredient(Items.BONE, 8).addIngredient(Items.FLINT)
				.addCriterion("has_bones", hasItem(Tags.Items.BONES))
				.build(consumer, DataGenerators.rl("bone_spikes"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.golden_lantern_item.get())
				.patternLine("xxx")
				.patternLine("xyx")
				.patternLine("xxx")
				.key('x', Tags.Items.NUGGETS_GOLD).key('y', Items.TORCH)
				.addCriterion("has_torch", hasItem(Items.TORCH))
				.build(consumer, DataGenerators.rl("golden_lantern"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.golden_soul_lantern_item.get())
        		.patternLine("xxx")
				.patternLine("xyx")
				.patternLine("xxx")
				.key('x', Tags.Items.NUGGETS_GOLD).key('y', Items.SOUL_TORCH)
				.addCriterion("has_soul_torch", hasItem(Items.SOUL_TORCH))
				.build(consumer, DataGenerators.rl("golden_soul_lantern"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.piglin_gold_block_item.get())
        		.patternLine("xxx")
        		.patternLine("yyy")
        		.patternLine("xxx")
        		.key('x', Tags.Items.INGOTS_GOLD).key('y', RegisterItems.piglin_emblem.get())
        		.addCriterion("has_piglin_emblem", hasItem(RegisterItems.piglin_emblem.get()))
        		.build(consumer, DataGenerators.rl("piglin_gold_block"));
        
        ShapelessRecipeBuilder.shapelessRecipe(Items.GOLD_INGOT, 7)
        		.addIngredient(RegisterBlocks.piglin_gold_block_item.get())
        		.addCriterion("has_piglin_gold_block", hasItem(RegisterBlocks.piglin_gold_block_item.get()))
        		.build(consumer, DataGenerators.rl("piglin_gold_block_to_ingots"));
        
        ShapelessRecipeBuilder.shapelessRecipe(Items.BOOK)
        		.addIngredient(Items.PAPER, 3).addIngredient(ModTags.LEATHER_REPLACEMENT)
        		.addCriterion("has_paper", hasItem(Items.PAPER))
        		.build(consumer, DataGenerators.rl("replacement_leather_to_books"));
        
        ShapelessRecipeBuilder.shapelessRecipe(Items.WHITE_DYE, 4)
        		.addIngredient(RegisterItems.bone_ash.get())
        		.addCriterion("has_bone_ash", hasItem(Items.PAPER))
        		.build(consumer, DataGenerators.rl("bone_ash_to_white_dye"));
        
        ShapedRecipeBuilder.shapedRecipe(Items.ITEM_FRAME)
				.patternLine("xxx")
				.patternLine("xyx")
				.patternLine("xxx")
				.key('x', Items.STICK).key('y', ModTags.LEATHER_REPLACEMENT)
				.addCriterion("has_leather_replacement", hasItem(ModTags.LEATHER_REPLACEMENT))
				.build(consumer, DataGenerators.rl("replacement_leather_to_itemframes"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterOffhand.redstone_magnet.get())
				.patternLine("xyx")
				.patternLine("xyx")
				.patternLine("xzx")
				.key('x', Tags.Items.DUSTS_REDSTONE).key('y', Tags.Items.INGOTS_IRON).key('z', Tags.Items.CROPS_POTATO)
				.addCriterion("has_red_stone", hasItem(Tags.Items.DUSTS_REDSTONE))
				.build(consumer, DataGenerators.rl("redstone_magnet"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterOffhand.witch_know.get())
        		.patternLine("xxx")
        		.patternLine("xyx")
        		.patternLine("xzx")
        		.key('x', Tags.Items.GEMS_DIAMOND).key('y', Items.NETHER_STAR).key('z', Tags.Items.GEMS_LAPIS)
        		.addCriterion("has_nether_star", hasItem(Items.NETHER_STAR))
        		.build(consumer, DataGenerators.rl("tablet_of_exp_to_hp"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterItems.hearthstone.get())
        		.patternLine("xxx")
        		.patternLine("xyx")
        		.patternLine("xzx")
        		.key('x', Tags.Items.STONE).key('y', Tags.Items.GEMS_LAPIS).key('z', Tags.Items.ENDER_PEARLS)
        		.addCriterion("has_ender_pearls", hasItem(Tags.Items.ENDER_PEARLS))
        		.build(consumer, DataGenerators.rl("hearthstone"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterItems.trident_head.get())
				.patternLine(" x ")
				.patternLine("xxx")
				.patternLine("yyy")
				.key('x', Items.PRISMARINE_SHARD).key('y', Items.PRISMARINE_CRYSTALS)
				.addCriterion("has_prismarine_shard", hasItem(Items.PRISMARINE_SHARD))
				.build(consumer, DataGenerators.rl("trident_head"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterItems.unfinished_trident.get())
        		.patternLine("x  ")
        		.patternLine(" y ")
        		.patternLine("  y")
        		.key('x', Items.PRISMARINE_SHARD).key('y', Items.PRISMARINE_CRYSTALS)
        		.addCriterion("has_prismarine_crystals", hasItem(Items.PRISMARINE_CRYSTALS))
        		.build(consumer, DataGenerators.rl("trident_unfinished"));
        
        ShapedRecipeBuilder.shapedRecipe(RegisterItems.dragon_scale.get())
				.patternLine("xxx")
				.patternLine("xyx")
				.patternLine("xxx")
				.key('x', Items.ENDER_PEARL).key('y', ModTags.DRAGON_SCALE)
				.addCriterion("has_ender_pearl", hasItem(Items.ENDER_PEARL))
				.build(consumer, DataGenerators.rl("transforming_dragon_scales"));
        

        ShapelessRecipeBuilder.shapelessRecipe(RegisterItems.spider_fermented_chitin.get())
        		.addIngredient(Items.SUGAR).addIngredient(RegisterItems.spider_chitin.get()).addIngredient(Items.BROWN_MUSHROOM)
        		.addCriterion("has_spider_chitin", hasItem(RegisterItems.spider_chitin.get()))
        		.build(consumer, DataGenerators.rl("fermented_spider_chitin"));
        

        registerCraftedArmorByItem("test", RegisterItems.dragon_scale.get(), "dragon", consumer);
        registerCraftedArmorByItem("magma_armor", RegisterItems.blaze_glass.get(), "blaze", consumer);
        registerCraftedArmorByItem("spider_armor", RegisterItems.spider_chitin.get(), "spider", consumer);
        registerCraftedArmorByItem("wolf_armor", RegisterItems.wolf_hide.get(), "wolf", consumer);
        registerCraftedArmorByItem("bee_armor", RegisterItems.bee_chitin.get(), "bee", consumer);
        registerCraftedArmorByItem("fox_armor", RegisterItems.fox_hide.get(), "fox", consumer);
        registerCraftedArmorByItem("shark_armor", RegisterItems.shark_skin.get(), "shark", consumer);
        registerCraftedArmorByItem("polar_bear_armor", RegisterItems.bear_polar_leather.get(), "bear_polar", consumer);
        registerCraftedArmorByItem("panda_bear_armor", RegisterItems.bear_panda_leather.get(), "bear_panda", consumer);
        registerCraftedArmorByItem("brown_bear_armor", RegisterItems.bear_brown_leather.get(), "bear_brown", consumer);
        registerCraftedArmorByItem("black_bear_armor", RegisterItems.bear_black_leather.get(), "bear_black", consumer);
        registerCraftedArmorByItem("guardian_armor", RegisterItems.guardian_skin.get(), "guardian", consumer);
        registerCraftedArmorByItem("goat_armor", RegisterItems.goat_hide.get(), "goat", consumer);
        registerCraftedArmorByItem("phantom_armor", Items.PHANTOM_MEMBRANE, "phantom", consumer);
        registerCraftedArmorByItem("shulker_armor", Items.SHULKER_SHELL, "shulker", consumer);
        registerCraftedArmorByItem("nautilus_armor", Items.NAUTILUS_SHELL, "naut", consumer);
        registerCraftedArmorByItem("horror_armor", RegisterItems.parasite_starved.get(), "horror", consumer);
        registerCraftedArmorByItem("stalker_armor", RegisterItems.branch_splinter_bloody.get(), "stalker", consumer);
        registerCraftedArmorByItem("silverfish_armor", RegisterItems.silverfish_chitin.get(), "silverfish", consumer);
        
        ShapedRecipeBuilder.shapedRecipe(RegisterArmors.shell_chestplate.get())
				.patternLine("x x")
				.patternLine("xxx")
				.patternLine("xxx")
				.key('x', Items.SCUTE).setGroup("turtle_armor").addCriterion(("has_scute"), hasItem(Items.SCUTE)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(RegisterArmors.shell_leggings.get())
				.patternLine("xxx")
				.patternLine("x x")
				.patternLine("x x")
				.key('x', Items.SCUTE).setGroup("turtle_armor").addCriterion(("has_scute"), hasItem(Items.SCUTE)).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(RegisterArmors.shell_boots.get())
				.patternLine("x x")
				.patternLine("x x")
				.key('x', Items.SCUTE).setGroup("turtle_armor").addCriterion(("has_scute"), hasItem(Items.SCUTE)).build(consumer);

    	CraftandHunt.LOGGER.info("armor Recipies by item done");
    	
        registerCraftedArmorByTag("bone_armor", Tags.Items.BONES, "bone", consumer);
        registerCraftedArmorByTag("crab_armor", ModTags.CRABSHELL, "crab", consumer);
    	CraftandHunt.LOGGER.info("armor Recipies by tags done");
        
        registerCraftedToolByItem("magma_tools", RegisterItems.blaze_glass.get(), "blaze", consumer);
        registerCraftedToolByItem("spider_tools", RegisterItems.spider_chitin.get(), "spider", consumer);
        registerCraftedToolByItem("shell_tools", Items.SCUTE, "shell", consumer);
        registerCraftedToolByItem("shulker_tools", Items.SHULKER_SHELL, "shulker", consumer);
        registerHalloweenTools("halloween_tools", RegisterItems.parasite_starved.get(), "horror", consumer);
    	CraftandHunt.LOGGER.info("tool Recipies by item done");

 //       registerCraftedSpearByTag(ItemTags.PLANKS, "wooden", consumer);
  //      registerCraftedSpearByTag(Tags.Items.COBBLESTONE, "stone", consumer);
 //       registerCraftedSpearByTag(Tags.Items.INGOTS_GOLD, "gold", consumer);
 //       registerCraftedSpearByTag(Tags.Items.INGOTS_IRON, "iron", consumer);
 //       registerCraftedSpearByTag(Tags.Items.GEMS_DIAMOND, "diamond", consumer);
 //       registerCraftedSpearByTag(Tags.Items.INGOTS_NETHERITE, "netherite", consumer);
 //       registerCraftedSpearByTag(Tags.Items.BONES, "bone", consumer);
 //       registerCraftedSpearByItem(RegisterItems.blaze_glass.get(), "blaze", consumer);
//        registerCraftedSpearByTag(ModTags.SHARKTEETH, "shark", consumer);
  //      registerCraftedSpearByItem(Items.SHULKER_SHELL, "shulker", consumer);
 //       registerCraftedSpearByItem(RegisterItems.spider_chitin.get(), "spider", consumer);
 //       registerCraftedSpearByItem(RegisterItems.spider_fermented_chitin.get(), "spider_fermented", consumer);
  //      registerCraftedSpearByItem(RegisterItems.spider_poison_chitin.get(), "spider_poison", consumer);
 //       registerCraftedSpearByItem(Items.WITHER_SKELETON_SKULL, "wither", consumer);
    	CraftandHunt.LOGGER.info("spear Recipes done");
    	

    	registerCraftedToolByTag("shark_tools", ModTags.SHARKTEETH, "shark", consumer);
    	registerCraftedToolByTag("bone_tools", Tags.Items.BONES, "bone", consumer);
    	CraftandHunt.LOGGER.info("tool Recipies by tags done");    
    	

        registerSmithingArmorUpgrades("silverfish", RegisterItems.endermite_mass.get(), "endermite", consumer);
        registerSmithingArmorUpgrades("bone", Items.WITHER_SKELETON_SKULL, "wither", consumer);
        registerSmithingArmorUpgrades("wither", Items.BEACON, "u_wither", consumer);
        registerSmithingArmorUpgrades("bone", RegisterItems.stray_cloth.get(), "stray", consumer);
        registerSmithingArmorUpgrades("blaze", RegisterItems.strider_rock.get(), "strider", consumer);
        registerSmithingArmorUpgrades("goat", RegisterItems.hoglin_leather.get(), "hoglin", consumer);
        registerSmithingArmorUpgrades("spider", RegisterItems.spider_poison_chitin.get(), "spider_poison", consumer);
        registerSmithingArmorUpgrades("spider", RegisterItems.spider_fermented_chitin.get(), "spider_fermented", consumer);
        registerSmithingArmorUpgrades("shark", RegisterItems.thrasher_skin.get(), "thrasher", consumer);
        registerSmithingArmorUpgrades("thrasher", RegisterItems.thrasher_great_skin.get(), "thrasher_great", consumer);     
        registerSmithingArmorUpgrades("guardian", RegisterItems.guardian_elder_skin.get(), "guardian_elder", consumer);
        registerSmithingArmorUpgrades("bee", Items.BEE_NEST, "nest", consumer);
        registerSmithingArmorUpgrades("nest", Items.BEEHIVE, "hive", consumer);
        
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.naut_helmet.get()),Ingredient.fromItems(Items.SCUTE), Items.TURTLE_HELMET)
								.addCriterion("has_scute", hasItem(Items.SCUTE))
								.build(consumer, DataGenerators.rl("naut_upgraded_to_turtle_helmet"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.naut_chestplate.get()),Ingredient.fromItems(Items.SCUTE), RegisterArmors.shell_chestplate.get())
								.addCriterion("has_scute", hasItem(Items.SCUTE))
								.build(consumer, DataGenerators.rl("naut_upgraded_to_turtle_chestplate"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.naut_leggings.get()),Ingredient.fromItems(Items.SCUTE), RegisterArmors.shell_leggings.get())
								.addCriterion("has_scute", hasItem(Items.SCUTE))
								.build(consumer, DataGenerators.rl("naut_upgraded_to_turtle_leggings"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.naut_boots.get()),Ingredient.fromItems(Items.SCUTE), RegisterArmors.shell_boots.get())
        						.addCriterion("has_scute", hasItem(Items.SCUTE))
        						.build(consumer, DataGenerators.rl("naut_upgraded_to_turtle_boots"));

    	CraftandHunt.LOGGER.info("armor upgrades by items done");    
        
        registerSmithingArmorUpgradesbyTag("crab", ModTags.CRABSHELL, "naut", consumer);
        registerSmithingArmorUpgradesbyTag("wolf", ModTags.FIREFOX_HIDE, "fox_fire", consumer);
        registerSmithingArmorUpgradesbyTag("fox", ModTags.FIREFOX_HIDE, "fox_fire", consumer);
        
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.IRON_HELMET),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_iron_helmet.get())
        						.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
        						.build(consumer, DataGenerators.rl("iron_upgraded_to_t_iron_helmet"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.IRON_CHESTPLATE),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_iron_chestplate.get())
        						.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
        						.build(consumer, DataGenerators.rl("iron_upgraded_to_t_iron_chestplate"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.IRON_LEGGINGS),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_iron_leggings.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("iron_upgraded_to_t_iron_leggings"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.IRON_BOOTS),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_iron_boots.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("iron_upgraded_to_t_iron_boots"));
        
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.DIAMOND_HELMET),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_diamond_helmet.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("diamond_upgraded_to_t_diamond_helmet"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.DIAMOND_CHESTPLATE),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_diamond_chestplate.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("diamond_upgraded_to_t_diamond_chestplate"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.DIAMOND_LEGGINGS),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_diamond_leggings.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("diamond_upgraded_to_t_diamond_leggings"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.DIAMOND_BOOTS),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_diamond_boots.get())
        						.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
        						.build(consumer, DataGenerators.rl("diamond_upgraded_to_t_diamond_boots"));
        
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.NETHERITE_HELMET),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_netherite_helmet.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("netherite_upgraded_to_t_netherite_helmet"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.NETHERITE_CHESTPLATE),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_netherite_chestplate.get())
        						.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
        						.build(consumer, DataGenerators.rl("netherite_upgraded_to_t_netherite_chestplate"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.NETHERITE_LEGGINGS),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_netherite_leggings.get())
								.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
								.build(consumer, DataGenerators.rl("netherite_upgraded_to_t_netherite_leggings"));
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.NETHERITE_BOOTS),Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), RegisterArmors.t_netherite_boots.get())
        						.addCriterion(("has_gold_block"), hasItem(Tags.Items.STORAGE_BLOCKS_GOLD))
        						.build(consumer, DataGenerators.rl("netherite_upgraded_to_t_netherite_boots"));
        
    	CraftandHunt.LOGGER.info("armor upgrades by tags done");     

        registerSmithingArmorUpgradesbyDragon("hive", "u_bee", consumer);
        registerSmithingArmorUpgradesbyDragon("strider", "u_blaze", consumer);
        registerSmithingArmorUpgradesbyDragon("stray", "u_stray", consumer);
        registerSmithingArmorUpgradesbyDragon("hoglin", "u_goat", consumer);
        registerSmithingArmorUpgradesbyDragon("spider_poison", "u_spider_poison", consumer);
        registerSmithingArmorUpgradesbyDragon("spider_fermented", "u_spider_fermented", consumer);
        registerSmithingArmorUpgradesbyDragon("thrasher_great", "u_shark", consumer);
        registerSmithingArmorUpgradesbyDragon("guardian_elder", "u_guardian_elder", consumer);
        registerSmithingArmorUpgradesbyDragon("shulker", "u_shulker", consumer);
        registerSmithingArmorUpgradesbyDragon("phantom", "u_phantom", consumer);
        registerSmithingArmorUpgradesbyDragon("fox_fire", "u_fox", consumer);
        registerSmithingArmorUpgradesbyDragon("bear_polar", "u_bear_polar", consumer);
        registerSmithingArmorUpgradesbyDragon("bear_panda", "u_bear_panda", consumer);
        registerSmithingArmorUpgradesbyDragon("bear_brown", "u_bear_brown", consumer);
        registerSmithingArmorUpgradesbyDragon("bear_black", "u_bear_black", consumer);
        
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(Items.TURTLE_HELMET),Ingredient.fromItems(RegisterItems.dragon_helmet.get()), RegisterArmorsUpgrades.u_shell_helmet.get())
								.addCriterion(RegisterItems.dragon_helmet.get().toString(), hasItem(RegisterItems.dragon_helmet.get()))
								.build(consumer, DataGenerators.rl("turtle_upgraded_to_u_turtle_helmet"));	
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.shell_chestplate.get()),Ingredient.fromItems(RegisterItems.dragon_chestplate.get()), RegisterArmorsUpgrades.u_shell_chestplate.get())
								.addCriterion(RegisterItems.dragon_chestplate.get().toString(), hasItem(RegisterItems.dragon_chestplate.get()))
								.build(consumer, DataGenerators.rl("turtle_upgraded_to_u_turtle_chestplate"));	
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.shell_leggings.get()),Ingredient.fromItems(RegisterItems.dragon_leggings.get()), RegisterArmorsUpgrades.u_shell_leggings.get())
								.addCriterion(RegisterItems.dragon_leggings.get().toString(), hasItem(RegisterItems.dragon_leggings.get()))
								.build(consumer, DataGenerators.rl("turtle_upgraded_to_u_turtle_leggings"));	
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(RegisterArmors.shell_boots.get()),Ingredient.fromItems(RegisterItems.dragon_boots.get()), RegisterArmorsUpgrades.u_shell_boots.get())
								.addCriterion(RegisterItems.dragon_boots.get().toString(), hasItem(RegisterItems.dragon_boots.get()))
								.build(consumer, DataGenerators.rl("turtle_upgraded_to_u_turtle_boots"));	

    	CraftandHunt.LOGGER.info("armor upgrades by dragon scales done");
    	

    	registerSmithingToolsUpgrades("bone", Items.WITHER_SKELETON_SKULL, "wither", consumer);
    	registerSmithingToolsUpgrades("spider", RegisterItems.spider_poison_chitin.get(), "spider_poison", consumer);
    	registerSmithingToolsUpgrades("spider", RegisterItems.spider_fermented_chitin.get(), "spider_fermented", consumer);
    	CraftandHunt.LOGGER.info("tool upgrades by item done");
    	
    	CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.MAGMA_CREAM), RegisterItems.blaze_glass.get(), 1.0F, 200).addCriterion("has_magma_cream", hasItem(Items.MAGMA_CREAM)).build(consumer, DataGenerators.rl("magma_glass_from_furnace"));
    	CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.MAGMA_CREAM), RegisterItems.blaze_glass.get(), 2.0F, 100).addCriterion("has_magma_cream", hasItem(Items.MAGMA_CREAM)).build(consumer, DataGenerators.rl("magma_glass_from_blast"));
    	CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.BONE), RegisterItems.bone_ash.get(), 1.0F, 200).addCriterion("has_bones", hasItem(Items.BONE)).build(consumer, DataGenerators.rl("bone_ash_from_furnace"));
    	CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(RegisterItems.unfinished_trident.get()), Items.TRIDENT, 1.0F, 200).addCriterion("has_unfinished_trident", hasItem(RegisterItems.unfinished_trident.get())).build(consumer, DataGenerators.rl("trident_from_furnace"));
    	CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(RegisterItems.unfinished_trident.get()), Items.TRIDENT, 2.0F, 100).addCriterion("has_unfinished_trident", hasItem(RegisterItems.unfinished_trident.get())).build(consumer, DataGenerators.rl("trident_from_blast"));
    	CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(RegisterItems.piglin_emblem.get()), Items.GOLD_INGOT, 1.0F, 200).addCriterion("has_piglin_emblem", hasItem(RegisterItems.piglin_emblem.get())).build(consumer, DataGenerators.rl("gold_ingot_from_furnace"));
    	CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(RegisterItems.piglin_emblem.get()), Items.GOLD_INGOT, 2.0F, 100).addCriterion("has_piglin_emblem", hasItem(RegisterItems.piglin_emblem.get())).build(consumer, DataGenerators.rl("gold_ingot_from_blast"));
    	CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(RegisterItems.bear_flank.get()), RegisterItems.cooked_bear_flank.get(), 0.35F, 200).addCriterion("has_bear_flank", hasItem(RegisterItems.bear_flank.get())).build(consumer, DataGenerators.rl("cooked_bear_flank_from_furnace"));
    	CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(RegisterItems.calamari.get()), RegisterItems.cooked_calamari.get(), 0.35F, 200).addCriterion("has_calamari", hasItem(RegisterItems.calamari.get())).build(consumer, DataGenerators.rl("cooked_calamari_from_furnace"));
    	cookingRecipesForMethod(consumer, "smoking", IRecipeSerializer.SMOKING, 100, 0.5F);
        cookingRecipesForMethod(consumer, "campfire_cooking", IRecipeSerializer.CAMPFIRE_COOKING, 600, 3.0F);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Items.STICK), Items.TORCH, 0.35F, 20, IRecipeSerializer.CAMPFIRE_COOKING).addCriterion("has_sticks", hasItem(Items.STICK)).build(consumer, DataGenerators.rl("campfire_torches"));
    	CraftandHunt.LOGGER.info("furnace recipes done");
        
    }
    
    private static void cookingRecipesForMethod(Consumer<IFinishedRecipe> recipeConsumer, String recipeConsumerIn, CookingRecipeSerializer<?> cookingMethod, int serializerIn, float expMod) {
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(RegisterItems.bear_flank.get()), RegisterItems.cooked_bear_flank.get(), (0.35F * expMod) , serializerIn, cookingMethod).addCriterion("has_bear_flank", hasItem(RegisterItems.bear_flank.get())).build(recipeConsumer, DataGenerators.rl("cooked_bear_flank_from_" + recipeConsumerIn));
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(RegisterItems.calamari.get()), RegisterItems.cooked_calamari.get(), (0.35F * expMod), serializerIn, cookingMethod).addCriterion("has_calamari", hasItem(RegisterItems.calamari.get())).build(recipeConsumer, DataGenerators.rl("cooked_calamari_from_" + recipeConsumerIn));
     }
    
    @SuppressWarnings("deprecation")
	public static void registerCraftedArmorByItem(String group, Item material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item helmet = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_helmet")).get();
		Item chestplate = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_chestplate")).get();
		Item leggings = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_leggings")).get();
		Item boots = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_boots")).get();
		
    	ShapedRecipeBuilder.shapedRecipe(helmet)
        					.patternLine("xxx")
        					.patternLine("x x")
        					.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(chestplate)
        					.patternLine("x x")
        					.patternLine("xxx")
        					.patternLine("xxx")
        					.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(leggings)
    						.patternLine("xxx")
    						.patternLine("x x")
    						.patternLine("x x")
    						.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(boots)
        					.patternLine("x x")
        					.patternLine("x x")
        					.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void registerCraftedArmorByTag(String group, ITag<Item> material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item helmet = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_helmet")).get();
		Item chestplate = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_chestplate")).get();
		Item leggings = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_leggings")).get();
		Item boots = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_boots")).get();
		
    	ShapedRecipeBuilder.shapedRecipe(helmet)
        					.patternLine("xxx")
        					.patternLine("x x")
        					.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(chestplate)
        					.patternLine("x x")
        					.patternLine("xxx")
        					.patternLine("xxx")
        					.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(leggings)
    						.patternLine("xxx")
    						.patternLine("x x")
    						.patternLine("x x")
    						.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(boots)
        					.patternLine("x x")
        					.patternLine("x x")
        					.key('x', material).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void registerCraftedToolByItem(String group, Item material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item hoe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_hoe")).get();
		Item axe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_axe")).get();
		Item sword = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_sword")).get();
		Item shovel = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_shovel")).get();
		Item pickaxe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_pickaxe")).get();
		
    	ShapedRecipeBuilder.shapedRecipe(hoe)
        					.patternLine("xx ")
        					.patternLine(" y ")
        					.patternLine(" y ")
        					.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(axe)
        					.patternLine("xx")
        					.patternLine("xy")
        					.patternLine(" y")
        					.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(sword)
    						.patternLine("x")
    						.patternLine("x")
    						.patternLine("y")
    						.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(shovel)
        					.patternLine("x")
        					.patternLine("y")
        					.patternLine("y")
        					.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(pickaxe)
							.patternLine("xxx")
							.patternLine(" y ")
							.patternLine(" y ")
							.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void registerHalloweenTools(String group, Item material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item hoe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_hoe")).get();
		Item axe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_axe")).get();
		Item sword = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_sword")).get();
		Item shovel = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_shovel")).get();
		Item pickaxe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_pickaxe")).get();
		
    	ShapedRecipeBuilder.shapedRecipe(hoe)
        					.patternLine("xx ")
        					.patternLine(" y ")
        					.patternLine(" y ")
        					.key('x', material)
							.key('y', RegisterItems.branch_splinter_bloody.get()).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(axe)
        					.patternLine("xx")
        					.patternLine("xy")
        					.patternLine(" y")
        					.key('x', material)
							.key('y', RegisterItems.branch_splinter_bloody.get()).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(sword)
    						.patternLine("x")
    						.patternLine("x")
    						.patternLine("y")
    						.key('x', material)
							.key('y', RegisterItems.branch_splinter_bloody.get()).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(shovel)
        					.patternLine("x")
        					.patternLine("y")
        					.patternLine("y")
        					.key('x', material)
							.key('y', RegisterItems.branch_splinter_bloody.get()).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(pickaxe)
							.patternLine("xxx")
							.patternLine(" y ")
							.patternLine(" y ")
							.key('x', material)
							.key('y', RegisterItems.branch_splinter_bloody.get()).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void registerCraftedSpearByItem(Item material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item spear = Registry.ITEM.getOptional(DataGenerators.rl("spear_" + variant)).get();
		
    	ShapedRecipeBuilder.shapedRecipe(spear)
        					.patternLine(" x ")
        					.patternLine("xyx")
        					.patternLine(" y ")
        					.key('x', material)
							.key('y', Items.STICK).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void registerCraftedSpearByTag(ITag<Item> material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item spear = Registry.ITEM.getOptional(DataGenerators.rl("spear_" + variant)).get();
		
    	ShapedRecipeBuilder.shapedRecipe(spear)
        					.patternLine(" x ")
        					.patternLine("xyx")
        					.patternLine(" y ")
        					.key('x', material)
							.key('y', Items.STICK).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }
    
    
    
    @SuppressWarnings("deprecation")
	public static void registerCraftedToolByTag(String group, ITag<Item> material, String variant, Consumer<IFinishedRecipe> consumer) {
    	
    	Item hoe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_hoe")).get();
		Item axe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_axe")).get();
		Item sword = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_sword")).get();
		Item shovel = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_shovel")).get();
		Item pickaxe = Registry.ITEM.getOptional(DataGenerators.rl(variant + "_pickaxe")).get();
		
    	ShapedRecipeBuilder.shapedRecipe(hoe)
        					.patternLine("xx ")
        					.patternLine(" y ")
        					.patternLine(" y ")
        					.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(axe)
        					.patternLine("xx")
        					.patternLine("xy")
        					.patternLine(" y")
        					.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(sword)
    						.patternLine("x")
    						.patternLine("x")
    						.patternLine("y")
    						.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(shovel)
        					.patternLine("x")
        					.patternLine("y")
        					.patternLine("y")
        					.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    	ShapedRecipeBuilder.shapedRecipe(pickaxe)
							.patternLine("xxx")
							.patternLine(" y ")
							.patternLine(" y ")
							.key('x', material)
							.key('y', Items.STICK).setGroup(group).addCriterion(("has_" + material.toString()), hasItem(material)).build(consumer);
    	
    }

    @SuppressWarnings("deprecation")
	public static void registerSmithingArmorUpgrades(String in, Item material, String out, Consumer<IFinishedRecipe> consumer) {
    	
     	Item HelmIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_helmet")).get();
    	Item chestplateIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_chestplate")).get();
    	Item leggingsIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_leggings")).get();
    	Item bootsIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_boots")).get();
    	
     	Item helmetOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_helmet")).get();
    	Item chestplateOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_chestplate")).get();
    	Item leggingsOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_leggings")).get();
    	Item bootsOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_boots")).get();
		
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(HelmIn),Ingredient.fromItems(material), helmetOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_helmet"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(chestplateIn),Ingredient.fromItems(material), chestplateOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_chestplate"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(leggingsIn),Ingredient.fromItems(material), leggingsOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_leggings"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(bootsIn),Ingredient.fromItems(material), bootsOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_boots"));
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void registerSmithingArmorUpgradesbyTag(String in, ITag<Item> material, String out, Consumer<IFinishedRecipe> consumer) {
    	
     	Item HelmIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_helmet")).get();
    	Item chestplateIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_chestplate")).get();
    	Item leggingsIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_leggings")).get();
    	Item bootsIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_boots")).get();
    	
     	Item helmetOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_helmet")).get();
    	Item chestplateOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_chestplate")).get();
    	Item leggingsOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_leggings")).get();
    	Item bootsOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_boots")).get();
		
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(HelmIn),Ingredient.fromTag(material), helmetOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_helmet"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(chestplateIn),Ingredient.fromTag(material), chestplateOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_chestplate"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(leggingsIn),Ingredient.fromTag(material), leggingsOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_leggings"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(bootsIn),Ingredient.fromTag(material), bootsOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_boots"));
    }
    
    @SuppressWarnings("deprecation")
	public static void registerSmithingArmorUpgradesbyDragon(String in, String out, Consumer<IFinishedRecipe> consumer) {
    	
     	Item HelmIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_helmet")).get();
    	Item chestplateIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_chestplate")).get();
    	Item leggingsIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_leggings")).get();
    	Item bootsIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_boots")).get();
    	
     	Item helmetOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_helmet")).get();
    	Item chestplateOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_chestplate")).get();
    	Item leggingsOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_leggings")).get();
    	Item bootsOut = Registry.ITEM.getOptional(DataGenerators.rl(out + "_boots")).get();
		
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(HelmIn),Ingredient.fromItems(RegisterItems.dragon_helmet.get()), helmetOut)
								.addCriterion(RegisterItems.dragon_helmet.get().toString(), hasItem(RegisterItems.dragon_helmet.get()))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_helmet"));	
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(chestplateIn),Ingredient.fromItems(RegisterItems.dragon_chestplate.get()), chestplateOut)
								.addCriterion(RegisterItems.dragon_chestplate.get().toString(), hasItem(RegisterItems.dragon_chestplate.get()))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_chestplate"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(leggingsIn),Ingredient.fromItems(RegisterItems.dragon_leggings.get()), leggingsOut)
								.addCriterion(RegisterItems.dragon_leggings.get().toString(), hasItem(RegisterItems.dragon_leggings.get()))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_leggings"));	
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(bootsIn),Ingredient.fromItems(RegisterItems.dragon_boots.get()), bootsOut)
								.addCriterion(RegisterItems.dragon_boots.get().toString(), hasItem(RegisterItems.dragon_boots.get()))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_boots"));
    }
    
    @SuppressWarnings("deprecation")
	public static void registerSmithingToolsUpgrades(String in, Item material, String out, Consumer<IFinishedRecipe> consumer) {
    	
     	Item HoeIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_hoe")).get();
    	Item swordIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_sword")).get();
    	Item axeIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_axe")).get();
    	Item shovelIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_shovel")).get();
    	Item pickaxeIn = Registry.ITEM.getOptional(DataGenerators.rl(in + "_pickaxe")).get();
    	
    	Item HoeOut = Registry.ITEM.getOptional(DataGenerators.rl(in + "_hoe")).get();
    	Item swordOut = Registry.ITEM.getOptional(DataGenerators.rl(in + "_sword")).get();
    	Item axeOut = Registry.ITEM.getOptional(DataGenerators.rl(in + "_axe")).get();
    	Item shovelOut = Registry.ITEM.getOptional(DataGenerators.rl(in + "_shovel")).get();
    	Item pickaxeOut = Registry.ITEM.getOptional(DataGenerators.rl(in + "_pickaxe")).get();
    	
		
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(HoeIn),Ingredient.fromItems(material), HoeOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_hoe"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(swordIn),Ingredient.fromItems(material), swordOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_sword"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(axeIn),Ingredient.fromItems(material), axeOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_axe"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(shovelIn),Ingredient.fromItems(material), shovelOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_shovel"));
		SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(pickaxeIn),Ingredient.fromItems(material), pickaxeOut)
								.addCriterion(("has_" + material.toString()), hasItem(material))
								.build(consumer, DataGenerators.rl(in + "_upgraded_to_" + out + "_pickaxe"));
    	
    }
}
