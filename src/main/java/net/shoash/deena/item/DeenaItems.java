package net.shoash.deena.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;      
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shoash.deena.Deena;

public class DeenaItems {
	public static final Item RUBY =
		registerItem("ruby", new Item(new FabricItemSettings()));

	private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
		entries.add(RUBY);
	}
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM,
					 new Identifier(Deena.MOD_ID, name), item);
	}
	public static void registerModItems() {
		Deena.LOGGER.info("Register Mod Items for " + Deena.MOD_ID);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
			.register(DeenaItems::addItemsToIngredientItemGroup);
	}
}
