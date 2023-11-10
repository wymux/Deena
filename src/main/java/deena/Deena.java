package deena;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import deena.DItem;

public class Deena implements ModInitializer {

	public static final Item CUSTOM_ITEM =
		Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"),
				  new DItem(new FabricItemSettings().maxCount(16)));


	public static void itemGroupIngredients(FabricItemGroupEntries entries) {
		entries.addAfter(Items.OAK_DOOR, CUSTOM_ITEM);
	}

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(CUSTOM_ITEM))
		.displayName(Text.translatable("itemGroup.tutorial.test_group"))
		.entries((context, entries) -> {
				entries.add(CUSTOM_ITEM);

			})
		.build();

	public static void registerModItems() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(Deena::itemGroupIngredients);
		Registry.register(Registries.ITEM_GROUP, new Identifier(
					  "tutorial", "test_group"), ITEM_GROUP);
	}
	
	@Override
	public void onInitialize() {
		FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
		CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 0.2F);
		registerModItems();
	}

}
