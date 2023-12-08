package deena;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DBlockEntity extends BlockEntity {

	public int number = 7;
	
	public DBlockEntity(BlockPos pos, BlockState state) {
		super(Deena.DEMO_BLOCK_ENTITY, pos, state);
	}

	@Override
	public void writeNbt(NbtCompound nbt) {
		nbt.putInt("number", number);
 
		super.writeNbt(nbt);
	}
 
	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
 
		number = nbt.getInt("number");
	}
}
