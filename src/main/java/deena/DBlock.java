package deena;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
}
