package com.aavri.craftandhunt.world.storage.loot;

import com.aavri.craftandhunt.Constants;

import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;

public final class LootHandler {

	public static void lootLoad(LootTableLoadEvent event) {
		String prefix = "minecraft:chests/";
		String name = event.getName().toString();

		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			switch (file) {
			case "bastion_bridge":
			case "bastion_hoglin_stable":
			case "bastion_other":
			case "bastion_treasure":
			case "desert_pyramid":
			case "jungle_temple":
			case "nether_bridge":
			case "simple_dungeon":
			case "stronghold_corridor":
			case "stronghold_crossing":
			case "village_tannery":
			case "woodland_mansion":
				event.getTable().addPool(getInjectPool(file));
				break;
			default:
				break;
			}
		}
	}

	public static LootPool getInjectPool(String entryName) {
		return LootPool.builder()
				.addEntry(getInjectEntry(entryName, 1))
				.bonusRolls(0, 3)
				.name("craftandhunt_inject")
				.build();
	}

	private static LootEntry.Builder<?> getInjectEntry(String name, int weight) {
		ResourceLocation table = Constants.rl("inject/" + name);
		return TableLootEntry.builder(table)
				.weight(weight);
	}

}
