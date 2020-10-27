package com.aavri.craftandhunt;

import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class Constants {
	
	public static boolean yoyoLoaded = CraftandHunt.yoyoLoaded;
	public static boolean betterAnimalsLoaded = CraftandHunt.betterAnimalsLoaded;
	public static boolean patchouliLoaded = CraftandHunt.patchouliLoaded;
	public static boolean quarkLoaded = CraftandHunt.quarkLoaded;
	public static boolean upgrade_aquaticLoaded = CraftandHunt.upgrade_aquaticLoaded;
	public static final String MOD_ID = "craftandhunt";
	public static final Rarity REINFORCED = Rarity.create("reinforced", TextFormatting.DARK_AQUA);
	
	public static ResourceLocation rl(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

}
