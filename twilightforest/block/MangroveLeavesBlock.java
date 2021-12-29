// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import javax.annotation.Nullable;
import net.minecraft.tags.Tag;
import net.minecraft.tags.FluidTags;
import java.util.Objects;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public class MangroveLeavesBlock extends TFLeavesBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED;
    
    public MangroveLeavesBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)MangroveLeavesBlock.f_54418_, (Comparable)7)).m_61124_((Property)MangroveLeavesBlock.f_54419_, (Comparable)false)).m_61124_((Property)MangroveLeavesBlock.WATERLOGGED, (Comparable)false));
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)MangroveLeavesBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        return (BlockState)Objects.requireNonNull(super.m_5573_(context)).m_61124_((Property)MangroveLeavesBlock.WATERLOGGED, (Comparable)(fluidstate.m_76153_((Tag)FluidTags.f_13131_) && fluidstate.m_76186_() == 8));
    }
    
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)MangroveLeavesBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)MangroveLeavesBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
