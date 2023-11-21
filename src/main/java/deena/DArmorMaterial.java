package deena;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class DArmorMaterial implements ArmorMaterial {
	private static int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3};

	public int method_7696(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 6;
	}
	
	public int method_7697(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 1;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(RegisterItems.CUSTOM_MATERIAL);
	}
	
	@Override
	public String getName() {
		return "name";
	}
	
	@Override
	public float getToughness() {
		return 0.5F;
	}

	@Override
	public int getDurability(ArmorItem.Type type) {
		return 500;
	}
	
	@Override
	public int getProtection(ArmorItem.Type type) {
		return 500;
	}
	
	@Override
	public float getKnockbackResistance() {
		return 0.5F;
	}
}
