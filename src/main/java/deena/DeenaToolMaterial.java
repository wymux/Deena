package deena;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DeenaToolMaterial implements ToolMaterial {

	public static final DeenaToolMaterial INSTANCE = new DeenaToolMaterial();
	
	@Override
	public int getDurability() {
		return 500;
	}

	@Override
	public int getMiningLevel() {
		return 3;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 5.0F;
	}

	@Override
	public float getAttackDamage() {
		return 3.0F;
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.POTATO);
	}
 
	public static ToolItem POTATO_PICKAXE = new PickaxeItem(DeenaToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings());
	public static ToolItem POTATO_AXE = new AxeItem(DeenaToolMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings());
	public static ToolItem POTATO_HOE = new HoeItem(DeenaToolMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings());

	public static void registerTools() {
		Registry.register(Registries.ITEM, new Identifier
				  ("tutorial", "custom_potato_pickaxe"), POTATO_PICKAXE);
		Registry.register(Registries.ITEM, new Identifier
				  ("tutorial", "custom_potato_axe"), POTATO_AXE);
		Registry.register(Registries.ITEM, new Identifier
				  ("tutorial", "custom_potato_hoe"), POTATO_HOE);
	}
	
}
