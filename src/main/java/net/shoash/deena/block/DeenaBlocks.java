package net.shoash.deena.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.shoash.deena.Deena;

public class DeenaBlocks {
	public static final Block MACK =
		registerBlock("mack", new Block(FabricBlockSettings
						.copyOf(Blocks.IRON_BLOCK)));
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(Deena.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(Deena.MOD_ID, name),
					 new BlockItem(block, new FabricItemSettings()));
	}

	public static void registerModBlocks() {
		Deena.LOGGER.info("Registering ModBlocks for " + Deena.MOD_ID);
	}
	
}
