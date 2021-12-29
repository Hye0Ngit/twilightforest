// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.SixWayBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.RotatedPillarBlock;

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
    
    ConnectableRotatedPillarBlock(final AbstractBlock.Properties props, final double size) {
        this(props, size, size);
    }
    
    ConnectableRotatedPillarBlock(final AbstractBlock.Properties props, final double width, final double height) {
        super(props.func_226896_b_());
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
        this.func_180632_j((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)ConnectableRotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y)).func_206870_a((Property)ConnectableRotatedPillarBlock.NORTH, (Comparable)false)).func_206870_a((Property)ConnectableRotatedPillarBlock.WEST, (Comparable)false)).func_206870_a((Property)ConnectableRotatedPillarBlock.SOUTH, (Comparable)false)).func_206870_a((Property)ConnectableRotatedPillarBlock.EAST, (Comparable)false)).func_206870_a((Property)ConnectableRotatedPillarBlock.DOWN, (Comparable)false)).func_206870_a((Property)ConnectableRotatedPillarBlock.UP, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)ConnectableRotatedPillarBlock.NORTH, (Property)ConnectableRotatedPillarBlock.EAST, (Property)ConnectableRotatedPillarBlock.SOUTH, (Property)ConnectableRotatedPillarBlock.WEST, (Property)ConnectableRotatedPillarBlock.DOWN, (Property)ConnectableRotatedPillarBlock.UP });
    }
    
    public BlockState func_196271_a(final BlockState state, final Direction facing, final BlockState facingState, final IWorld world, final BlockPos pos, final BlockPos facingPos) {
        return (BlockState)state.func_206870_a((Property)SixWayBlock.field_196491_B.get(facing), (Comparable)this.canConnectTo(facingState, facingState.func_224755_d((IBlockReader)world, facingPos, facing.func_176734_d())));
    }
    
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        final Block block = state.func_177230_c();
        return !func_220073_a(block) && solidSide;
    }
    
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final IBlockReader iblockreader = (IBlockReader)context.func_195991_k();
        final BlockPos blockpos = context.func_195995_a();
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        final BlockPos blockpos2 = blockpos.func_177978_c();
        final BlockPos blockpos3 = blockpos.func_177968_d();
        final BlockPos blockpos4 = blockpos.func_177976_e();
        final BlockPos blockpos5 = blockpos.func_177974_f();
        final BlockState blockstate = iblockreader.func_180495_p(blockpos2);
        final BlockState blockstate2 = iblockreader.func_180495_p(blockpos3);
        final BlockState blockstate3 = iblockreader.func_180495_p(blockpos4);
        final BlockState blockstate4 = iblockreader.func_180495_p(blockpos5);
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.func_176223_P().func_206870_a((Property)ConnectableRotatedPillarBlock.field_176298_M, (Comparable)context.func_196000_l().func_176740_k())).func_206870_a((Property)ConnectableRotatedPillarBlock.NORTH, (Comparable)this.canConnectTo(blockstate, blockstate.func_224755_d(iblockreader, blockpos2, Direction.SOUTH)))).func_206870_a((Property)ConnectableRotatedPillarBlock.SOUTH, (Comparable)this.canConnectTo(blockstate2, blockstate2.func_224755_d(iblockreader, blockpos3, Direction.NORTH)))).func_206870_a((Property)ConnectableRotatedPillarBlock.WEST, (Comparable)this.canConnectTo(blockstate3, blockstate3.func_224755_d(iblockreader, blockpos4, Direction.EAST)))).func_206870_a((Property)ConnectableRotatedPillarBlock.EAST, (Comparable)this.canConnectTo(blockstate4, blockstate4.func_224755_d(iblockreader, blockpos5, Direction.WEST)));
    }
    
    protected AxisAlignedBB getSidedAABBStraight(final Direction facing, final Direction.Axis axis) {
        return this.makeQuickAABB((facing == Direction.EAST) ? 16.0 : ((axis == Direction.Axis.X) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == Direction.UP) ? 16.0 : ((axis == Direction.Axis.Y) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == Direction.SOUTH) ? 16.0 : ((axis == Direction.Axis.Z) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == Direction.WEST) ? 0.0 : ((axis == Direction.Axis.X) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper), (facing == Direction.DOWN) ? 0.0 : ((axis == Direction.Axis.Y) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper), (facing == Direction.NORTH) ? 0.0 : ((axis == Direction.Axis.Z) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper));
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader world, final BlockPos pos, final ISelectionContext context) {
        switch ((Direction.Axis)state.func_177229_b((Property)ConnectableRotatedPillarBlock.field_176298_M)) {
            case X: {
                return func_208617_a(0.0, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.NORTH)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.WEST)) ? 0.0 : this.boundingBoxWidthLower, 16.0, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.SOUTH)) ? 16.0 : this.boundingBoxWidthUpper, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.EAST)) ? 16.0 : this.boundingBoxWidthUpper);
            }
            case Z: {
                return func_208617_a(((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.EAST)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.SOUTH)) ? 0.0 : this.boundingBoxWidthLower, 0.0, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.WEST)) ? 16.0 : this.boundingBoxWidthUpper, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.NORTH)) ? 16.0 : this.boundingBoxWidthUpper, 16.0);
            }
            default: {
                return func_208617_a(((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.WEST)) ? 0.0 : this.boundingBoxWidthLower, 0.0, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.NORTH)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.EAST)) ? 16.0 : this.boundingBoxWidthUpper, 16.0, ((boolean)state.func_177229_b((Property)ConnectableRotatedPillarBlock.SOUTH)) ? 16.0 : this.boundingBoxWidthUpper);
            }
        }
    }
    
    protected AxisAlignedBB makeQuickAABB(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return new AxisAlignedBB(x1 / 16.0, y1 / 16.0, z1 / 16.0, x2 / 16.0, y2 / 16.0, z2 / 16.0);
    }
    
    static {
        NORTH = SixWayBlock.field_196488_a;
        SOUTH = SixWayBlock.field_196492_c;
        WEST = SixWayBlock.field_196495_y;
        EAST = SixWayBlock.field_196490_b;
        UP = SixWayBlock.field_196496_z;
        DOWN = SixWayBlock.field_196489_A;
    }
}
