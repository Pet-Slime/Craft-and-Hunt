package com.aavri.craftandhunt.data;

import com.aavri.craftandhunt.Constants;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class ModTags extends ItemTagsProvider {


	public static final ITag.INamedTag<Item> CRABSHELL = tag("crab_shell");
	public static final ITag.INamedTag<Item> SHARKTEETH = tag("shark_teeth");

	public static final ITag.INamedTag<Item> FIREFOX_HIDE = tag("fire_fox");
	public static final ITag.INamedTag<Item> LEATHER_REPLACEMENT = tag("craftandhunt_leather_replacement");

	public static final ITag.INamedTag<Item> DRAGON_SCALE = tag("dragon_scales");

	public ModTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider) {
		super(dataGenerator, blockTagProvider);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void registerTags() {
		this.getOrCreateBuilder(CRABSHELL);
	}
	
	
	private static IOptionalNamedTag<Item> tag(String name)
    {
        return ItemTags.createOptional(new ResourceLocation(Constants.MOD_ID, name));
    }


	@Override
	public String getName() {
		return "Craft and hunt item tags";
	}

}
