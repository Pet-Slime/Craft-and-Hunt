package com.aavri.craftandhunt.data;

import java.util.function.Consumer;

import com.aavri.craftandhunt.util.RegisterBlocks;
import com.aavri.craftandhunt.util.RegisterItems;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;


public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(RegisterBlocks.blaze_glass_block.get())
                .patternLine("xxx")
                .patternLine("xxx")
                .patternLine("xxx")
                .key('x', RegisterItems.blaze_glass.get())
                .setGroup("mytutorial")
                .addCriterion("blaze_glass", InventoryChangeTrigger.Instance.forItems(RegisterItems.blaze_glass.get()))
                .build(consumer);
    }
}
