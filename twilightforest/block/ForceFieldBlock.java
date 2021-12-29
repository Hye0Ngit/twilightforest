// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public class ForceFieldBlock extends ConnectableRotatedPillarBlock implements SimpleWaterloggedBlock
{
    private static final BooleanProperty WATERLOGGED;
    
    ForceFieldBlock(final BlockBehaviour.Properties props) {
        super(props, 2.0);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)ForceFieldBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Override
    protected AABB getSidedAABBStraight(final Direction facing, final Direction.Axis axis) {
        return this.makeQuickAABB((facing == Direction.EAST || axis == Direction.Axis.X) ? 16.0 : this.boundingBoxWidthLower, (facing == Direction.UP || axis == Direction.Axis.Y) ? 16.0 : this.boundingBoxWidthLower, (facing == Direction.SOUTH || axis == Direction.Axis.Z) ? 16.0 : this.boundingBoxWidthLower, (facing == Direction.WEST || axis == Direction.Axis.X) ? 0.0 : this.boundingBoxWidthUpper, (facing == Direction.DOWN || axis == Direction.Axis.Y) ? 0.0 : this.boundingBoxWidthUpper, (facing == Direction.NORTH || axis == Direction.Axis.Z) ? 0.0 : this.boundingBoxWidthUpper);
    }
    
    public boolean canEntityDestroy(final BlockState state, final BlockGetter world, final BlockPos pos, final Entity entity) {
        return false;
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean m_6104_(final BlockState state, final BlockState adjacentBlockState, final Direction side) {
        if (adjacentBlockState.m_60713_((Block)this)) {
            if (!side.m_122434_().m_122479_()) {
                return true;
            }
            if ((boolean)state.m_61143_((Property)PipeBlock.f_55154_.get(side)) && (boolean)adjacentBlockState.m_61143_((Property)PipeBlock.f_55154_.get(side.m_122424_()))) {
                return true;
            }
        }
        return super.m_6104_(state, adjacentBlockState, side);
    }
    
    public float m_7749_(final BlockState state, final BlockGetter worldIn, final BlockPos pos) {
        return 1.0f;
    }
    
    public boolean m_7420_(final BlockState state, final BlockGetter reader, final BlockPos pos) {
        return true;
    }
    
    @Override
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        final Block block = state.m_60734_();
        return (!m_152463_(state) && solidSide) || block instanceof ForceFieldBlock || block instanceof IronBarsBlock || state.m_60620_((Tag)BlockTags.f_13032_);
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)ForceFieldBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    @Override
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        final boolean flag = fluidstate.m_76152_() == Fluids.f_76193_;
        return (BlockState)super.m_5573_(context).m_61124_((Property)ForceFieldBlock.WATERLOGGED, (Comparable)flag);
    }
    
    @Override
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)ForceFieldBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)ForceFieldBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
