package deena;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DBlockState extends Block {
	public static final BooleanProperty DCHARGED = BooleanProperty.of("charged");

	public static final DBlockState DCHARGEABLE_BLOCK = new DBlockState(FabricBlockSettings.copyOf(Blocks.STONE));

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(DCHARGED);
	}

	public DBlockState(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(DCHARGED, false));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos,
				  PlayerEntity player, Hand hand, BlockHitResult hit) {
		player.playSound(SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, 1, 1);
		world.setBlockState(pos, state.with(DCHARGED, true));
		return ActionResult.SUCCESS;
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if (world.getBlockState(pos).get(DCHARGED)) {
			LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
			lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
			world.spawnEntity(lightningEntity);
		}

		world.setBlockState(pos, state.with(DCHARGED, false));
		super.onSteppedOn(world, pos, state, entity);
	}
}
