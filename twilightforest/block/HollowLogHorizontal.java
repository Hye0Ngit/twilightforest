// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import twilightforest.util.AxisUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.ToolActions;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.FluidState;
import javax.annotation.Nullable;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import twilightforest.enums.HollowLogVariants;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.Block;

public class HollowLogHorizontal extends Block implements WaterloggedBlock
{
    public static final EnumProperty<Direction.Axis> HORIZONTAL_AXIS;
    public static final EnumProperty<HollowLogVariants.Horizontal> VARIANT;
    private static final VoxelShape HOLLOW_SHAPE_X;
    private static final VoxelShape HOLLOW_SHAPE_Z;
    private static final VoxelShape CARPET_SHAPE_X;
    private static final VoxelShape CARPET_SHAPE_Z;
    private static final VoxelShape COLLISION_SHAPE_X;
    private static final VoxelShape COLLISION_SHAPE_Z;
    
    public HollowLogHorizontal(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)HollowLogHorizontal.HORIZONTAL_AXIS, (Comparable)Direction.Axis.X)).m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.EMPTY));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        VoxelShape voxelShape = null;
        Label_0182: {
            switch ((HollowLogVariants.Horizontal)state.m_61143_((Property)HollowLogHorizontal.VARIANT)) {
                case EMPTY:
                case WATERLOGGED: {
                    switch ((Direction.Axis)state.m_61143_((Property)HollowLogHorizontal.HORIZONTAL_AXIS)) {
                        case X: {
                            voxelShape = HollowLogHorizontal.HOLLOW_SHAPE_X;
                            break Label_0182;
                        }
                        case Z: {
                            voxelShape = HollowLogHorizontal.HOLLOW_SHAPE_Z;
                            break Label_0182;
                        }
                        default: {
                            voxelShape = Shapes.m_83144_();
                            break Label_0182;
                        }
                    }
                    break;
                }
                case MOSS:
                case MOSS_AND_GRASS:
                case SNOW: {
                    switch ((Direction.Axis)state.m_61143_((Property)HollowLogHorizontal.HORIZONTAL_AXIS)) {
                        case X: {
                            voxelShape = HollowLogHorizontal.CARPET_SHAPE_X;
                            break Label_0182;
                        }
                        case Z: {
                            voxelShape = HollowLogHorizontal.CARPET_SHAPE_Z;
                            break Label_0182;
                        }
                        default: {
                            voxelShape = Shapes.m_83144_();
                            break Label_0182;
                        }
                    }
                    break;
                }
                default: {
                    throw new IncompatibleClassChangeError();
                }
            }
        }
        return voxelShape;
    }
    
    public VoxelShape m_5939_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return switch ((Direction.Axis)state.m_61143_((Property)HollowLogHorizontal.HORIZONTAL_AXIS)) {
            case X -> HollowLogHorizontal.COLLISION_SHAPE_X;
            case Z -> HollowLogHorizontal.COLLISION_SHAPE_Z;
            default -> Shapes.m_83040_();
        };
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder.m_61104_(new Property[] { (Property)HollowLogHorizontal.HORIZONTAL_AXIS, (Property)HollowLogHorizontal.VARIANT }));
    }
    
    public boolean isStateWaterlogged(final BlockState state) {
        return state.m_61143_((Property)HollowLogHorizontal.VARIANT) == HollowLogVariants.Horizontal.WATERLOGGED;
    }
    
    public BlockState setWaterlog(final BlockState prior, final boolean doWater) {
        return (BlockState)prior.m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)(doWater ? HollowLogVariants.Horizontal.WATERLOGGED : HollowLogVariants.Horizontal.EMPTY));
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)((BlockState)super.m_5573_(context).m_61124_((Property)HollowLogHorizontal.HORIZONTAL_AXIS, (Comparable)context.m_43719_().m_122434_())).m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)((context.m_43725_().m_8055_(context.m_8083_()).m_60819_().m_76152_() == Fluids.f_76193_) ? HollowLogVariants.Horizontal.WATERLOGGED : HollowLogVariants.Horizontal.EMPTY));
    }
    
    public FluidState m_5888_(final BlockState state) {
        return (state.m_61143_((Property)HollowLogHorizontal.VARIANT) == HollowLogVariants.Horizontal.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    public BlockState m_7417_(final BlockState state, final Direction facing, final BlockState neighborState, final LevelAccessor level, final BlockPos pos, final BlockPos neighborPos) {
        if (this.isStateWaterlogged(state)) {
            level.m_6217_().m_5945_(pos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, facing, neighborState, level, pos, neighborPos);
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        final Direction.Axis stateAxis = (Direction.Axis)state.m_61143_((Property)HollowLogHorizontal.HORIZONTAL_AXIS);
        if (!isInside((HitResult)hit, stateAxis, pos)) {
            return super.m_6227_(state, level, pos, player, hand, hit);
        }
        final ItemStack stack = player.m_21120_(hand);
        final HollowLogVariants.Horizontal variant = (HollowLogVariants.Horizontal)state.m_61143_((Property)HollowLogHorizontal.VARIANT);
        if (stack.m_150930_(((Block)TFBlocks.MOSS_PATCH.get()).m_5456_())) {
            if (canChangeVariant(variant, level, pos, stateAxis)) {
                level.m_7731_(pos, (BlockState)state.m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.MOSS), 3);
                level.m_5594_((Player)null, pos, SoundEvents.f_144190_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                player.m_6674_(hand);
                return InteractionResult.CONSUME;
            }
        }
        else if (stack.m_150930_(Blocks.f_50034_.m_5456_())) {
            if (variant == HollowLogVariants.Horizontal.MOSS) {
                level.m_7731_(pos, (BlockState)state.m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.MOSS_AND_GRASS), 3);
                level.m_5594_((Player)null, pos, SoundEvents.f_11991_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                player.m_6674_(hand);
                return InteractionResult.CONSUME;
            }
        }
        else if (stack.m_150930_(Items.f_42452_)) {
            if (canChangeVariant(variant, level, pos, stateAxis)) {
                level.m_7731_(pos, (BlockState)state.m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.SNOW), 3);
                level.m_5594_((Player)null, pos, SoundEvents.f_12482_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                player.m_6674_(hand);
                return InteractionResult.CONSUME;
            }
        }
        else if (stack.canPerformAction(ToolActions.SHOVEL_DIG)) {
            if (variant == HollowLogVariants.Horizontal.SNOW) {
                level.m_7731_(pos, (BlockState)state.m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.EMPTY), 3);
                level.m_5594_((Player)null, pos, SoundEvents.f_12474_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_7500_()) {
                    stack.m_41622_(1, (LivingEntity)player, p -> p.m_21190_(hand));
                    level.m_7967_((Entity)new ItemEntity(level, pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, new ItemStack((ItemLike)Items.f_42452_)));
                }
                player.m_6674_(hand);
                return InteractionResult.CONSUME;
            }
        }
        else if (stack.canPerformAction(ToolActions.SHEARS_HARVEST) && (variant == HollowLogVariants.Horizontal.MOSS || variant == HollowLogVariants.Horizontal.MOSS_AND_GRASS)) {
            level.m_7731_(pos, (BlockState)state.m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.EMPTY), 3);
            level.m_5594_((Player)null, pos, SoundEvents.f_12344_, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!player.m_7500_()) {
                stack.m_41622_(1, (LivingEntity)player, p -> p.m_21190_(hand));
                level.m_7967_((Entity)new ItemEntity(level, pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, new ItemStack((ItemLike)TFBlocks.MOSS_PATCH.get())));
                if (variant == HollowLogVariants.Horizontal.MOSS_AND_GRASS) {
                    level.m_7967_((Entity)new ItemEntity(level, pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, new ItemStack((ItemLike)Blocks.f_50034_)));
                }
            }
            player.m_6674_(hand);
            return InteractionResult.CONSUME;
        }
        return super.m_6227_(state, level, pos, player, hand, hit);
    }
    
    private static boolean canChangeVariant(final HollowLogVariants.Horizontal variant, final Level level, final BlockPos pos, final Direction.Axis axis) {
        return variant == HollowLogVariants.Horizontal.EMPTY || (variant == HollowLogVariants.Horizontal.WATERLOGGED && level.m_6425_(pos.m_142300_(AxisUtil.getAxisDirectionNegative(axis))).m_76152_() != Fluids.f_76193_ && level.m_6425_(pos.m_142300_(AxisUtil.getAxisDirectionPositive(axis))).m_76152_() != Fluids.f_76193_);
    }
    
    private static boolean isInside(final HitResult result, final Direction.Axis axis, final BlockPos pos) {
        final Vec3 vec = result.m_82450_().m_82492_((double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
        if (0.124 > vec.f_82480_ || vec.f_82480_ > 0.876) {
            return false;
        }
        return switch (axis) {
            case X -> 0.124 <= vec.f_82481_ && vec.f_82481_ <= 0.876;
            case Z -> 0.124 <= vec.f_82479_ && vec.f_82479_ <= 0.876;
            default -> false;
        };
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 5;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 5;
    }
    
    static {
        HORIZONTAL_AXIS = BlockStateProperties.f_61364_;
        VARIANT = EnumProperty.m_61587_("variant", (Class)HollowLogVariants.Horizontal.class);
        HOLLOW_SHAPE_X = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(0.0, 2.0, 2.0, 16.0, 14.0, 14.0), BooleanOp.f_82685_);
        HOLLOW_SHAPE_Z = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(2.0, 2.0, 0.0, 14.0, 14.0, 16.0), BooleanOp.f_82685_);
        CARPET_SHAPE_X = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(0.0, 3.0, 2.0, 16.0, 14.0, 14.0), BooleanOp.f_82685_);
        CARPET_SHAPE_Z = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(2.0, 3.0, 0.0, 14.0, 14.0, 16.0), BooleanOp.f_82685_);
        COLLISION_SHAPE_X = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(0.0, 1.0, 1.0, 16.0, 15.0, 15.0), BooleanOp.f_82685_);
        COLLISION_SHAPE_Z = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(1.0, 1.0, 0.0, 15.0, 15.0, 16.0), BooleanOp.f_82685_);
    }
}
