package net.shoash.deena;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.shoash.deena.block.DeenaBlocks;
import net.shoash.deena.item.DeenaItems;

public class Deena implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("deena");
	public static final String MOD_ID = "deena";

	@Override
	public void onInitialize() {
    		LOGGER.info("Hello Fabric world!");
		DeenaItems.registerModItems();
		DeenaBlocks.registerModBlocks();
	}
}
