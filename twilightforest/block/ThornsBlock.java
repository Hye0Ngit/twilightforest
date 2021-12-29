// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public class ThornsBlock extends ConnectableRotatedPillarBlock implements SimpleWaterloggedBlock
{
    private static final BooleanProperty WATERLOGGED;
    private static final float THORN_DAMAGE = 4.0f;
    
    ThornsBlock(final BlockBehaviour.Properties props) {
        super(props, 10.0);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)ThornsBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Override
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        return state.m_60734_() instanceof ThornsBlock || state.m_60734_() == TFBlocks.THORN_ROSE.get() || state.m_60734_() == TFBlocks.THORN_LEAVES.get() || state.m_60767_() == Material.f_76300_ || state.m_60767_() == Material.f_76314_;
    }
    
    @Nullable
    public BlockPathTypes getAiPathNodeType(final BlockState state, final BlockGetter world, final BlockPos pos, @Nullable final Mob entity) {
        return BlockPathTypes.DAMAGE_CACTUS;
    }
    
    @Deprecated
    public void m_7892_(final BlockState state, final Level worldIn, final BlockPos pos, final Entity entity) {
        entity.m_6469_(TFDamageSources.THORNS, 4.0f);
    }
    
    public void m_141947_(final Level world, final BlockPos pos, final BlockState state, final Entity entity) {
        if (state.m_60734_() instanceof ThornsBlock && state.m_61143_((Property)ThornsBlock.f_55923_) == Direction.Axis.Y) {
            this.m_7892_(state, world, pos, entity);
        }
        super.m_141947_(world, pos, state, entity);
    }
    
    public boolean removedByPlayer(final BlockState state, final Level world, final BlockPos pos, final Player player, final boolean willHarvest, final FluidState fluid) {
        if (!player.m_150110_().f_35937_) {
            if (!world.f_46443_) {
                this.doThornBurst(world, pos, state);
            }
            return false;
        }
        return super.removedByPlayer(state, world, pos, player, willHarvest, fluid);
    }
    
    @Deprecated
    public PushReaction m_5537_(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    private void doThornBurst(final Level world, final BlockPos pos, final BlockState state) {
        switch ((Direction.Axis)state.m_61143_((Property)ThornsBlock.f_55923_)) {
            case Y: {
                this.growThorns(world, pos, Direction.UP);
                this.growThorns(world, pos, Direction.DOWN);
                break;
            }
            case X: {
                this.growThorns(world, pos, Direction.EAST);
                this.growThorns(world, pos, Direction.WEST);
                break;
            }
            case Z: {
                this.growThorns(world, pos, Direction.NORTH);
                this.growThorns(world, pos, Direction.SOUTH);
                break;
            }
        }
        this.growThorns(world, pos, Direction.m_122404_(world.f_46441_));
        this.growThorns(world, pos, Direction.m_122404_(world.f_46441_));
        this.growThorns(world, pos, Direction.m_122404_(world.f_46441_));
    }
    
    private void growThorns(final Level world, final BlockPos pos, final Direction dir) {
        for (int length = 1 + world.f_46441_.nextInt(3), i = 1; i < length; ++i) {
            final BlockPos dPos = pos.m_5484_(dir, i);
            if (!world.m_46859_(dPos)) {
                break;
            }
            world.m_7731_(dPos, (BlockState)((Block)TFBlocks.GREEN_THORNS.get()).m_49966_().m_61124_((Property)ThornsBlock.f_55923_, (Comparable)dir.m_122434_()), 2);
        }
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)ThornsBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    @Override
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        final boolean flag = fluidstate.m_76152_() == Fluids.f_76193_;
        return (BlockState)super.m_5573_(context).m_61124_((Property)ThornsBlock.WATERLOGGED, (Comparable)flag);
    }
    
    @Override
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)ThornsBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)ThornsBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
