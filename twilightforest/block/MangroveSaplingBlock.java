// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.tags.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SaplingBlock;

public class MangroveSaplingBlock extends SaplingBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED;
    
    protected MangroveSaplingBlock(final AbstractTreeGrower tree, final BlockBehaviour.Properties properties) {
        super(tree, properties);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)MangroveSaplingBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Deprecated
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)MangroveSaplingBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel worldIn, final BlockPos pos, final Random rand) {
        if (!isInWater(state, (BlockGetter)worldIn, pos)) {
            worldIn.m_7731_(pos, (BlockState)this.m_49966_().m_61124_((Property)MangroveSaplingBlock.WATERLOGGED, (Comparable)false), 2);
        }
    }
    
    protected static boolean isInWater(final BlockState state, final BlockGetter worldIn, final BlockPos pos) {
        if (state.m_61143_((Property)MangroveSaplingBlock.WATERLOGGED)) {
            return true;
        }
        for (final Direction direction : Direction.values()) {
            if (worldIn.m_6425_(pos.m_142300_(direction)).m_76153_((Tag)FluidTags.f_13131_)) {
                return true;
            }
        }
        return false;
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        return (BlockState)this.m_49966_().m_61124_((Property)MangroveSaplingBlock.WATERLOGGED, (Comparable)(fluidstate.m_76153_((Tag)FluidTags.f_13131_) && fluidstate.m_76186_() == 8));
    }
    
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)MangroveSaplingBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return (facing == Direction.DOWN && !this.m_7898_(stateIn, (LevelReader)worldIn, currentPos)) ? Blocks.f_50016_.m_49966_() : super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)MangroveSaplingBlock.WATERLOGGED, (Property)MangroveSaplingBlock.f_55973_ });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
