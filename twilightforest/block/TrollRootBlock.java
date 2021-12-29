// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Block;

public class TrollRootBlock extends Block
{
    protected static final VoxelShape AABB;
    
    protected TrollRootBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public static boolean canPlaceRootBelow(final LevelReader world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        final Block block = state.m_60734_();
        return state.m_60620_((Tag)BlockTags.f_13061_) || block == TFBlocks.TROLLVIDR.get() || block == TFBlocks.TROLLBER.get() || block == TFBlocks.UNRIPE_TROLLBER.get();
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult result) {
        if (state.m_60734_() == TFBlocks.TROLLBER.get()) {
            level.m_7731_(pos, ((Block)TFBlocks.TROLLVIDR.get()).m_49966_(), 2);
            level.m_5594_((Player)null, pos, TFSounds.PICKED_TORCHBERRIES, SoundSource.BLOCKS, 1.0f, 1.0f);
            final ItemEntity torchberries = new ItemEntity(level, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), new ItemStack((ItemLike)TFItems.TORCHBERRIES.get()));
            level.m_7967_((Entity)torchberries);
            if (player instanceof ServerPlayer) {
                player.m_36220_(TFStats.TORCHBERRIES_HARVESTED);
            }
            return InteractionResult.m_19078_(level.f_46443_);
        }
        return super.m_6227_(state, level, pos, player, hand, result);
    }
    
    @Deprecated
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        return canPlaceRootBelow(world, pos.m_7494_());
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return TrollRootBlock.AABB;
    }
    
    @Deprecated
    public BlockState m_7417_(final BlockState state, final Direction dirToNeighbor, final BlockState neighborState, final LevelAccessor world, final BlockPos pos, final BlockPos neighborPos) {
        if (dirToNeighbor == Direction.UP) {
            return this.m_7898_(state, (LevelReader)world, pos) ? state : Blocks.f_50016_.m_49966_();
        }
        return state;
    }
    
    static {
        AABB = Shapes.m_83064_(new AABB(0.1, 0.0, 0.1, 0.9, 1.0, 0.9));
    }
}
