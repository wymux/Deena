package deena;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java .util.List;

public class DBlock extends Block {

	public DBlock(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos,
				  PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof DBlockEntity) {
				DBlockEntity demoBlockEntity = (DBlockEntity) blockEntity;
				demoBlockEntity.number++;
				player.sendMessage(Text.literal("Number is... "+demoBlockEntity.number), false);
				return ActionResult.SUCCESS;
			}
		}

		return ActionResult.PASS;
	}

	@Override
	public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
		NbtCompound nbt = BlockItem.getBlockEntityNbt(stack);
		if (nbt == null) {
			NbtCompound nbt2 = new NbtCompound();
			nbt2.putInt("number", 0);

			BlockItem.setBlockEntityNbt(stack, Deena.DEMO_BLOCK_ENTITY, nbt2);
		}

		tooltip.add(Text.literal("Number: "+nbt.getInt("number")));
	}
}
