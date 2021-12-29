// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.RotatedPillarBlock;

public abstract class ConnectableRotatedPillarBlock extends RotatedPillarBlock
{
    private static final BooleanProperty NORTH;
    private static final BooleanProperty SOUTH;
    private static final BooleanProperty WEST;
    private static final BooleanProperty EAST;
    private static final BooleanProperty UP;
    private static final BooleanProperty DOWN;
    final double boundingBoxWidthLower;
    final double boundingBoxWidthUpper;
    private final double boundingBoxHeightLower;
    private final double boundingBoxHeightUpper;
    
    ConnectableRotatedPillarBlock(final BlockBehaviour.Properties props, final double size) {
        this(props, size, size);
    }
    
    ConnectableRotatedPillarBlock(final BlockBehaviour.Properties props, final double width, final double height) {
        super(props.m_60955_());
        if (width >= 16.0) {
            this.boundingBoxWidthLower = 0.0;
            this.boundingBoxWidthUpper = 16.0;
        }
        else {
            this.boundingBoxWidthLower = 8.0 - width / 2.0;
            this.boundingBoxWidthUpper = 16.0 - this.boundingBoxWidthLower;
        }
        if (height >= 16.0) {
            this.boundingBoxHeightLower = 0.0;
            this.boundingBoxHeightUpper = 16.0;
        }
        else {
            this.boundingBoxHeightLower = 8.0 - height / 2.0;
            this.boundingBoxHeightUpper = 16.0 - this.boundingBoxHeightLower;
        }
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)ConnectableRotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y)).m_61124_((Property)ConnectableRotatedPillarBlock.NORTH, (Comparable)false)).m_61124_((Property)ConnectableRotatedPillarBlock.WEST, (Comparable)false)).m_61124_((Property)ConnectableRotatedPillarBlock.SOUTH, (Comparable)false)).m_61124_((Property)ConnectableRotatedPillarBlock.EAST, (Comparable)false)).m_61124_((Property)ConnectableRotatedPillarBlock.DOWN, (Comparable)false)).m_61124_((Property)ConnectableRotatedPillarBlock.UP, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)ConnectableRotatedPillarBlock.NORTH, (Property)ConnectableRotatedPillarBlock.EAST, (Property)ConnectableRotatedPillarBlock.SOUTH, (Property)ConnectableRotatedPillarBlock.WEST, (Property)ConnectableRotatedPillarBlock.DOWN, (Property)ConnectableRotatedPillarBlock.UP });
    }
    
    public BlockState m_7417_(final BlockState state, final Direction facing, final BlockState facingState, final LevelAccessor world, final BlockPos pos, final BlockPos facingPos) {
        return (BlockState)state.m_61124_((Property)PipeBlock.f_55154_.get(facing), (Comparable)this.canConnectTo(facingState, facingState.m_60783_((BlockGetter)world, facingPos, facing.m_122424_())));
    }
    
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        return !m_152463_(state) && solidSide;
    }
    
    public BlockState m_5573_(final BlockPlaceContext context) {
        final BlockGetter iblockreader = (BlockGetter)context.m_43725_();
        final BlockPos blockpos = context.m_8083_();
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        final BlockPos blockpos2 = blockpos.m_142127_();
        final BlockPos blockpos3 = blockpos.m_142128_();
        final BlockPos blockpos4 = blockpos.m_142125_();
        final BlockPos blockpos5 = blockpos.m_142126_();
        final BlockState blockstate = iblockreader.m_8055_(blockpos2);
        final BlockState blockstate2 = iblockreader.m_8055_(blockpos3);
        final BlockState blockstate3 = iblockreader.m_8055_(blockpos4);
        final BlockState blockstate4 = iblockreader.m_8055_(blockpos5);
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_((Property)ConnectableRotatedPillarBlock.f_55923_, (Comparable)context.m_43719_().m_122434_())).m_61124_((Property)ConnectableRotatedPillarBlock.NORTH, (Comparable)this.canConnectTo(blockstate, blockstate.m_60783_(iblockreader, blockpos2, Direction.SOUTH)))).m_61124_((Property)ConnectableRotatedPillarBlock.SOUTH, (Comparable)this.canConnectTo(blockstate2, blockstate2.m_60783_(iblockreader, blockpos3, Direction.NORTH)))).m_61124_((Property)ConnectableRotatedPillarBlock.WEST, (Comparable)this.canConnectTo(blockstate3, blockstate3.m_60783_(iblockreader, blockpos4, Direction.EAST)))).m_61124_((Property)ConnectableRotatedPillarBlock.EAST, (Comparable)this.canConnectTo(blockstate4, blockstate4.m_60783_(iblockreader, blockpos5, Direction.WEST)));
    }
    
    protected AABB getSidedAABBStraight(final Direction facing, final Direction.Axis axis) {
        return this.makeQuickAABB((facing == Direction.EAST) ? 16.0 : ((axis == Direction.Axis.X) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == Direction.UP) ? 16.0 : ((axis == Direction.Axis.Y) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == Direction.SOUTH) ? 16.0 : ((axis == Direction.Axis.Z) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == Direction.WEST) ? 0.0 : ((axis == Direction.Axis.X) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper), (facing == Direction.DOWN) ? 0.0 : ((axis == Direction.Axis.Y) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper), (facing == Direction.NORTH) ? 0.0 : ((axis == Direction.Axis.Z) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper));
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter world, final BlockPos pos, final CollisionContext context) {
        return switch ((Direction.Axis)state.m_61143_((Property)ConnectableRotatedPillarBlock.f_55923_)) {
            case X -> m_49796_(0.0, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.NORTH)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.WEST)) ? 0.0 : this.boundingBoxWidthLower, 16.0, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.SOUTH)) ? 16.0 : this.boundingBoxWidthUpper, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.EAST)) ? 16.0 : this.boundingBoxWidthUpper);
            case Z -> m_49796_(((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.EAST)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.SOUTH)) ? 0.0 : this.boundingBoxWidthLower, 0.0, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.WEST)) ? 16.0 : this.boundingBoxWidthUpper, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.NORTH)) ? 16.0 : this.boundingBoxWidthUpper, 16.0);
            default -> m_49796_(((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.WEST)) ? 0.0 : this.boundingBoxWidthLower, 0.0, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.NORTH)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.EAST)) ? 16.0 : this.boundingBoxWidthUpper, 16.0, ((boolean)state.m_61143_((Property)ConnectableRotatedPillarBlock.SOUTH)) ? 16.0 : this.boundingBoxWidthUpper);
        };
    }
    
    protected AABB makeQuickAABB(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return new AABB(x1 / 16.0, y1 / 16.0, z1 / 16.0, x2 / 16.0, y2 / 16.0, z2 / 16.0);
    }
    
    static {
        NORTH = PipeBlock.f_55148_;
        SOUTH = PipeBlock.f_55150_;
        WEST = PipeBlock.f_55151_;
        EAST = PipeBlock.f_55149_;
        UP = PipeBlock.f_55152_;
        DOWN = PipeBlock.f_55153_;
    }
}
