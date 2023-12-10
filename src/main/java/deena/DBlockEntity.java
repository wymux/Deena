package deena;


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import deena.DImplementedInventory;

public class DBlockEntity extends BlockEntity {

	private final DefaultedList<ItemStack> items = DefaultedList.ofSize(4, ItemStack.EMPTY);
	public int number = 7;
	
	public DBlockEntity(BlockPos pos, BlockState state) {
		super(Deena.DEMO_BLOCK_ENTITY, pos, state);
	}

	@Override
	public void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, items);
	}
 
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		number = nbt.getInt("number");
		Inventories.readNbt(nbt, items); 
	}
}
