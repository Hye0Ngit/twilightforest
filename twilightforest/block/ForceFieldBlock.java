// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.PaneBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.block.SixWayBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.IWaterLoggable;

public class ForceFieldBlock extends ConnectableRotatedPillarBlock implements IWaterLoggable
{
    private static final BooleanProperty WATERLOGGED;
    
    ForceFieldBlock(final AbstractBlock.Properties props) {
        super(props, 2.0);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)ForceFieldBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Override
    protected AxisAlignedBB getSidedAABBStraight(final Direction facing, final Direction.Axis axis) {
        return this.makeQuickAABB((facing == Direction.EAST || axis == Direction.Axis.X) ? 16.0 : this.boundingBoxWidthLower, (facing == Direction.UP || axis == Direction.Axis.Y) ? 16.0 : this.boundingBoxWidthLower, (facing == Direction.SOUTH || axis == Direction.Axis.Z) ? 16.0 : this.boundingBoxWidthLower, (facing == Direction.WEST || axis == Direction.Axis.X) ? 0.0 : this.boundingBoxWidthUpper, (facing == Direction.DOWN || axis == Direction.Axis.Y) ? 0.0 : this.boundingBoxWidthUpper, (facing == Direction.NORTH || axis == Direction.Axis.Z) ? 0.0 : this.boundingBoxWidthUpper);
    }
    
    public boolean canEntityDestroy(final BlockState state, final IBlockReader world, final BlockPos pos, final Entity entity) {
        return false;
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean func_200122_a(final BlockState state, final BlockState adjacentBlockState, final Direction side) {
        if (adjacentBlockState.func_203425_a((Block)this)) {
            if (!side.func_176740_k().func_176722_c()) {
                return true;
            }
            if ((boolean)state.func_177229_b((Property)SixWayBlock.field_196491_B.get(side)) && (boolean)adjacentBlockState.func_177229_b((Property)SixWayBlock.field_196491_B.get(side.func_176734_d()))) {
                return true;
            }
        }
        return super.func_200122_a(state, adjacentBlockState, side);
    }
    
    public float func_220080_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return 1.0f;
    }
    
    public boolean func_200123_i(final BlockState state, final IBlockReader reader, final BlockPos pos) {
        return true;
    }
    
    @Override
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        final Block block = state.func_177230_c();
        return (!func_220073_a(block) && solidSide) || block instanceof ForceFieldBlock || block instanceof PaneBlock || block.func_203417_a((ITag)BlockTags.field_219757_z);
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)ForceFieldBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Nullable
    @Override
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        final boolean flag = fluidstate.func_206886_c() == Fluids.field_204546_a;
        return (BlockState)super.func_196258_a(context).func_206870_a((Property)ForceFieldBlock.WATERLOGGED, (Comparable)flag);
    }
    
    @Override
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.func_177229_b((Property)ForceFieldBlock.WATERLOGGED)) {
            worldIn.func_205219_F_().func_205360_a(currentPos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)worldIn));
        }
        return super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a(builder);
        builder.func_206894_a(new Property[] { (Property)ForceFieldBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.field_208198_y;
    }
}
