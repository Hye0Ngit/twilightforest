// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.SlideBlock;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.Level;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class SliderBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock
{
    public static final IntegerProperty DELAY;
    public static final BooleanProperty WATERLOGGED;
    private static final int TICK_TIME = 80;
    private static final int OFFSET_TIME = 20;
    private static final int PLAYER_RANGE = 32;
    private static final float BLOCK_DAMAGE = 5.0f;
    private static final VoxelShape Y_BB;
    private static final VoxelShape Z_BB;
    private static final VoxelShape X_BB;
    
    protected SliderBlock() {
        super(BlockBehaviour.Properties.m_60944_(Material.f_76279_, MaterialColor.f_76408_).m_60913_(2.0f, 10.0f).m_60977_().m_60955_());
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)SliderBlock.f_55923_, (Comparable)Direction.Axis.Y)).m_61124_((Property)SliderBlock.DELAY, (Comparable)0)).m_61124_((Property)SliderBlock.WATERLOGGED, (Comparable)false));
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)SliderBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        final boolean flag = fluidstate.m_76152_() == Fluids.f_76193_;
        return (BlockState)super.m_5573_(context).m_61124_((Property)SliderBlock.WATERLOGGED, (Comparable)flag);
    }
    
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)SliderBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)SliderBlock.DELAY, (Property)SliderBlock.WATERLOGGED });
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return switch ((Direction.Axis)state.m_61143_((Property)SliderBlock.f_55923_)) {
            case X -> SliderBlock.X_BB;
            case Z -> SliderBlock.Z_BB;
            default -> SliderBlock.Y_BB;
        };
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        if (!world.f_46443_ && this.isConnectedInRange((Level)world, pos)) {
            final SlideBlock slideBlock = new SlideBlock(TFEntities.SLIDER, (Level)world, pos.m_123341_() + 0.5, pos.m_123342_(), pos.m_123343_() + 0.5, state);
            world.m_7967_((Entity)slideBlock);
        }
        this.scheduleBlockUpdate((Level)world, pos);
    }
    
    public boolean isConnectedInRange(final Level world, final BlockPos pos) {
        final Direction.Axis axis = (Direction.Axis)world.m_8055_(pos).m_61143_((Property)SliderBlock.f_55923_);
        return switch (axis) {
            case Y -> this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, Direction.UP) || this.isConnectedInRangeRecursive(world, pos, Direction.DOWN);
            case X -> this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, Direction.WEST) || this.isConnectedInRangeRecursive(world, pos, Direction.EAST);
            case Z -> this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, Direction.NORTH) || this.isConnectedInRangeRecursive(world, pos, Direction.SOUTH);
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    private boolean isConnectedInRangeRecursive(final Level world, final BlockPos pos, final Direction dir) {
        final BlockPos dPos = pos.m_142300_(dir);
        return world.m_8055_(pos) == world.m_8055_(dPos) && (this.anyPlayerInRange(world, dPos) || this.isConnectedInRangeRecursive(world, dPos, dir));
    }
    
    private boolean anyPlayerInRange(final Level world, final BlockPos pos) {
        return world.m_45924_(pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, 32.0, false) != null;
    }
    
    public void scheduleBlockUpdate(final Level world, final BlockPos pos) {
        final int offset = (int)world.m_8055_(pos).m_61143_((Property)SliderBlock.DELAY);
        final int update = 80 - (int)(world.m_46467_() - offset * 20) % 80;
        world.m_6219_().m_5945_(pos, (Object)this, update);
    }
    
    @Deprecated
    public void m_6807_(final BlockState state, final Level world, final BlockPos pos, final BlockState oldState, final boolean isMoving) {
        this.scheduleBlockUpdate(world, pos);
    }
    
    @Deprecated
    public void m_7892_(final BlockState state, final Level worldIn, final BlockPos pos, final Entity entity) {
        entity.m_6469_(TFDamageSources.SLIDER, 5.0f);
        if (entity instanceof LivingEntity) {
            final double kx = (pos.m_123341_() + 0.5 - entity.m_20185_()) * 2.0;
            final double kz = (pos.m_123343_() + 0.5 - entity.m_20189_()) * 2.0;
            ((LivingEntity)entity).m_147240_(2.0, kx, kz);
        }
    }
    
    static {
        DELAY = IntegerProperty.m_61631_("delay", 0, 3);
        WATERLOGGED = BlockStateProperties.f_61362_;
        Y_BB = Shapes.m_83064_(new AABB(0.3125, 0.0, 0.3125, 0.6875, 1.0, 0.6875));
        Z_BB = Shapes.m_83064_(new AABB(0.3125, 0.3125, 0.0, 0.6875, 0.6875, 1.0));
        X_BB = Shapes.m_83064_(new AABB(0.0, 0.3125, 0.3125, 1.0, 0.6875, 0.6875));
    }
}
