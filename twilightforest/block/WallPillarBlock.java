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
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public class WallPillarBlock extends ConnectableRotatedPillarBlock implements SimpleWaterloggedBlock
{
    private final VoxelShape TOP_X;
    private final VoxelShape BOTTOM_X;
    private final VoxelShape PILLAR_X;
    private final VoxelShape NO_TOP_X;
    private final VoxelShape NO_BOTTOM_X;
    private final VoxelShape FULL_X;
    private final VoxelShape TOP_Y;
    private final VoxelShape BOTTOM_Y;
    private final VoxelShape PILLAR_Y;
    private final VoxelShape NO_TOP_Y;
    private final VoxelShape NO_BOTTOM_Y;
    private final VoxelShape FULL_Y;
    private final VoxelShape TOP_Z;
    private final VoxelShape BOTTOM_Z;
    private final VoxelShape PILLAR_Z;
    private final VoxelShape NO_TOP_Z;
    private final VoxelShape NO_BOTTOM_Z;
    private final VoxelShape FULL_Z;
    public static final BooleanProperty WATERLOGGED;
    
    public WallPillarBlock(final Material material, final double width, final double height) {
        super(BlockBehaviour.Properties.m_60939_(material).m_60913_(1.5f, 6.0f).m_60999_().m_60955_(), width, height);
        this.TOP_X = Block.m_49796_(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        this.BOTTOM_X = Block.m_49796_(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        this.PILLAR_X = Block.m_49796_(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);
        this.NO_TOP_X = Shapes.m_83110_(this.PILLAR_X, this.BOTTOM_X);
        this.NO_BOTTOM_X = Shapes.m_83110_(this.PILLAR_X, this.TOP_X);
        this.FULL_X = Shapes.m_83124_(this.PILLAR_X, new VoxelShape[] { this.BOTTOM_X, this.TOP_X });
        this.TOP_Y = Block.m_49796_(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
        this.BOTTOM_Y = Block.m_49796_(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
        this.PILLAR_Y = Block.m_49796_(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
        this.NO_TOP_Y = Shapes.m_83110_(this.PILLAR_Y, this.BOTTOM_Y);
        this.NO_BOTTOM_Y = Shapes.m_83110_(this.PILLAR_Y, this.TOP_Y);
        this.FULL_Y = Shapes.m_83124_(this.PILLAR_Y, new VoxelShape[] { this.BOTTOM_Y, this.TOP_Y });
        this.TOP_Z = Block.m_49796_(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        this.BOTTOM_Z = Block.m_49796_(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        this.PILLAR_Z = Block.m_49796_(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);
        this.NO_TOP_Z = Shapes.m_83110_(this.PILLAR_Z, this.BOTTOM_Z);
        this.NO_BOTTOM_Z = Shapes.m_83110_(this.PILLAR_Z, this.TOP_Z);
        this.FULL_Z = Shapes.m_83124_(this.PILLAR_Z, new VoxelShape[] { this.BOTTOM_Z, this.TOP_Z });
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)WallPillarBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Override
    public VoxelShape m_5940_(final BlockState state, final BlockGetter world, final BlockPos pos, final CollisionContext context) {
        return switch ((Direction.Axis)state.m_61143_((Property)WallPillarBlock.f_55923_)) {
            case X -> ((boolean)state.m_61143_((Property)PipeBlock.f_55151_) && (boolean)state.m_61143_((Property)PipeBlock.f_55149_)) ? this.PILLAR_X : (state.m_61143_((Property)PipeBlock.f_55151_) ? this.NO_TOP_X : (state.m_61143_((Property)PipeBlock.f_55149_) ? this.NO_BOTTOM_X : this.FULL_X));
            case Z -> ((boolean)state.m_61143_((Property)PipeBlock.f_55148_) && (boolean)state.m_61143_((Property)PipeBlock.f_55150_)) ? this.PILLAR_Z : (state.m_61143_((Property)PipeBlock.f_55148_) ? this.NO_TOP_Z : (state.m_61143_((Property)PipeBlock.f_55150_) ? this.NO_BOTTOM_Z : this.FULL_Z));
            default -> ((boolean)state.m_61143_((Property)PipeBlock.f_55152_) && (boolean)state.m_61143_((Property)PipeBlock.f_55153_)) ? this.PILLAR_Y : (state.m_61143_((Property)PipeBlock.f_55152_) ? this.NO_TOP_Y : (state.m_61143_((Property)PipeBlock.f_55153_) ? this.NO_BOTTOM_Y : this.FULL_Y));
        };
    }
    
    @Override
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        final Block block = state.m_60734_();
        return block instanceof WallPillarBlock;
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)WallPillarBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    @Override
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        final boolean flag = fluidstate.m_76152_() == Fluids.f_76193_;
        return (BlockState)super.m_5573_(context).m_61124_((Property)WallPillarBlock.WATERLOGGED, (Comparable)flag);
    }
    
    @Override
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)WallPillarBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)WallPillarBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
