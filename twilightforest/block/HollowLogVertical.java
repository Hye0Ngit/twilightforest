// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.FluidState;
import javax.annotation.Nullable;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import twilightforest.util.DirectionUtil;
import twilightforest.enums.HollowLogVariants;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Block;

public class HollowLogVertical extends Block implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape HOLLOW_SHAPE;
    private static final VoxelShape COLLISION_SHAPE;
    private final RegistryObject<HollowLogClimbable> climbable;
    
    public HollowLogVertical(final BlockBehaviour.Properties props, final RegistryObject<HollowLogClimbable> climbable) {
        super(props);
        this.climbable = climbable;
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)HollowLogVertical.WATERLOGGED, (Comparable)false));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return HollowLogVertical.HOLLOW_SHAPE;
    }
    
    public VoxelShape m_5939_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return HollowLogVertical.COLLISION_SHAPE;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder.m_61104_(new Property[] { (Property)HollowLogVertical.WATERLOGGED }));
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        if (!isInside((HitResult)hit, pos)) {
            return super.m_6227_(state, level, pos, player, hand, hit);
        }
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_150930_(Blocks.f_50191_.m_5456_())) {
            level.m_7731_(pos, (BlockState)((BlockState)((HollowLogClimbable)this.climbable.get()).m_49966_().m_61124_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.VINE)).m_61124_((Property)HollowLogClimbable.f_54117_, (Comparable)DirectionUtil.horizontalOrElse(hit.m_82434_(), player.m_6350_().m_122424_())), 3);
            level.m_5594_((Player)null, pos, SoundEvents.f_144241_, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!player.m_7500_()) {
                stack.m_41774_(1);
            }
            player.m_6674_(hand);
            return InteractionResult.CONSUME;
        }
        if (stack.m_150930_(Blocks.f_50155_.m_5456_())) {
            level.m_7731_(pos, (BlockState)((BlockState)((HollowLogClimbable)this.climbable.get()).m_49966_().m_61124_((Property)HollowLogClimbable.VARIANT, (Comparable)(state.m_61143_((Property)HollowLogVertical.WATERLOGGED) ? HollowLogVariants.Climbable.LADDER_WATERLOGGED : HollowLogVariants.Climbable.LADDER))).m_61124_((Property)HollowLogClimbable.f_54117_, (Comparable)DirectionUtil.horizontalOrElse(hit.m_82434_(), player.m_6350_().m_122424_())), 3);
            level.m_5594_((Player)null, pos, SoundEvents.f_12023_, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!player.m_7500_()) {
                stack.m_41774_(1);
            }
            player.m_6674_(hand);
            return InteractionResult.CONSUME;
        }
        return super.m_6227_(state, level, pos, player, hand, hit);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)super.m_5573_(context).m_61124_((Property)HollowLogVertical.WATERLOGGED, (Comparable)(context.m_43725_().m_8055_(context.m_8083_()).m_60819_().m_76152_() == Fluids.f_76193_));
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)HollowLogVertical.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    public BlockState m_7417_(final BlockState state, final Direction facing, final BlockState neighborState, final LevelAccessor level, final BlockPos pos, final BlockPos neighborPos) {
        if (state.m_61143_((Property)HollowLogVertical.WATERLOGGED)) {
            level.m_6217_().m_5945_(pos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, facing, neighborState, level, pos, neighborPos);
    }
    
    private static boolean isInside(final HitResult result, final BlockPos pos) {
        final Vec3 vec = result.m_82450_().m_82492_((double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
        return 0.124 <= vec.f_82479_ && vec.f_82479_ <= 0.876 && 0.124 <= vec.f_82481_ && vec.f_82481_ <= 0.876;
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 5;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 5;
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
        HOLLOW_SHAPE = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(2.0, 0.0, 2.0, 14.0, 16.0, 14.0), BooleanOp.f_82685_);
        COLLISION_SHAPE = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(1.0, 0.0, 1.0, 15.0, 16.0, 15.0), BooleanOp.f_82685_);
    }
}
