package net.shoash.deena.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.shoash.deena.Deena;
import net.shoash.deena.block.DeenaBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DeenaItemGroups {
	public static final ItemGroup BASE_GROUP =
		Registry.register(Registries.ITEM_GROUP, new Identifier(Deena.MOD_ID, "base"),
				    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.base"))
				    .icon(() -> new ItemStack(DeenaBlocks.MACK))
				  .entries((displayContext, entries) -> {
						    entries.add(DeenaBlocks.MACK);
				    }).build());

	public static void registerItemGroups() {
		Deena.LOGGER.info("Registering Item Groups for " + Deena.MOD_ID);
	}
}
						    

								       
