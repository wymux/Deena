package net.shoash.deena.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shoash.deena.Deena;

public class DeenaItemGroups {
	public static final ItemGroup RUBY_GROUP =
		Registry.register(Registries.ITEM_GROUP,
				  new Identifier(Deena.MOD_ID, "ruby"),
				  FabricItemGroup.builder()
				  .displayName(Text.translatable("itemgroup.ruby"))
				  .icon(() -> new ItemStack(DeenaItems.RUBY))
				  .entries((displayContext, entries) -> {
						  entries.add(DeenaItems.RUBY);
						  entries.add(Items.DIAMOND);
				  }).build());
}
