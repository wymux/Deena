package net.shoash.deena;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.shoash.deena.block.DeenaBlocks;

public class Deena implements ModInitializer {
	public static final String MOD_ID = "deena";
	public static final Logger LOGGER = LoggerFactory.getLogger("deena");

	@Override
	public void onInitialize() {
		DeenaBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}
