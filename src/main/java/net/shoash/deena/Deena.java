package net.shoash.deena;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deena implements ModInitializer {
	public static final String MOD_ID = "deena";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		DeenaItemGroups.registerItemGroups();
		DeenaBlocks.registerModBlocks();
	}
}
