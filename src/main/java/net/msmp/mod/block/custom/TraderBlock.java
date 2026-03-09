package net.msmp.mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.msmp.mod.block.entity.TraderBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.OptionalInt;

@SuppressWarnings("deprecation")
public class TraderBlock extends BaseEntityBlock {


    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public TraderBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TraderBlockEntity(pos, state);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof TraderBlockEntity trader) {
                trader.setTradingPlayer(player);

                OptionalInt optionalInt = serverPlayer.openMenu(trader);

                if (optionalInt.isPresent()) {
                    serverPlayer.sendMerchantOffers(
                            optionalInt.getAsInt(),
                            trader.getOffers(),
                            1,
                            trader.getVillagerXp(),
                            trader.showProgressBar(),
                            trader.canRestock()
                    );
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }


}