package deena;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
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
import net.minecraft.block.entity.BlockEntityType;

import deena.DBlock;
import deena.DBlockState;
import deena.DItem;
import deena.DVerticalSlabBlock;
import deena.RegisterItems;
import deena.DeenaToolMaterial;

import java .util.List;

public class Deena implements ModInitializer {
	public static final Item CUSTOM_ITEM =
		Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"),
				  new DItem(new FabricItemSettings().maxCount(16)));

	public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.create().strength(4.0f));
	public static final Block DEMO_BLOCK = new DBlock(FabricBlockSettings.create().strength(4.0f));
	public static final Block DBlock = new DBlock(FabricBlockSettings.create().strength(4.0f));
	
	public static final DVerticalSlabBlock POLISHED_ANDESITE_VERTICAL_SLAB = Registry.register(
		Registries.BLOCK,
		new Identifier("tutorial", "polished_andesite_vertical_slab"),
		new DVerticalSlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)));

	public static final BlockEntityType<DBlockEntity> DEMO_BLOCK_ENTITY = Registry.register(
		Registries.BLOCK_ENTITY_TYPE,
		new Identifier("tutorial", "dblock_entity"),
		FabricBlockEntityTypeBuilder.create(DBlockEntity::new, DEMO_BLOCK).build()
		);
	
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

	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.translatable("item.tutorial.custom_item.tooltip"));
	}

	public static final ItemGroup EXAMPLE_MOD_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(RegisterItems.CUSTOM_MATERIAL))
		.displayName(Text.translatable("itemGroup.tutorial.test_group"))
		.build();
		

	@Override
	public void onInitialize() {
		FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
		CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 0.2F);
		registerModItems();
		DeenaToolMaterial.registerTools();
		RegisterItems.register();
		Registry.register(Registries.BLOCK,
				  new Identifier("tutorial", "example_block"),
				  EXAMPLE_BLOCK);
		Registry.register(Registries.ITEM,
				  new Identifier("tutorial", "example_block"),
				  new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.BLOCK,
				  new Identifier("tutorial", "example_block2"),
				  DBlock);
		Registry.register(Registries.ITEM,
				  new Identifier("tutorial", "example_block2"),
				  new BlockItem(DBlock, new FabricItemSettings()));
		Registry.register(Registries.BLOCK,
				  new Identifier("tutorial", "dblock_state"),
				  DBlockState.DCHARGEABLE_BLOCK);
		Registry.register(Registries.ITEM,
				  new Identifier("tutorial", "dblock_state"),
				  new BlockItem(DBlockState.DCHARGEABLE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM,
				  new Identifier("tutorial", "polished_andesite_vertical_slab"),
				  new BlockItem(POLISHED_ANDESITE_VERTICAL_SLAB, new FabricItemSettings()));
	}
}


