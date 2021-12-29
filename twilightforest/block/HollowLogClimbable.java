// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.ToolActions;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.phys.shapes.VoxelShape;
import twilightforest.enums.HollowLogVariants;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class HollowLogClimbable extends HorizontalDirectionalBlock implements WaterloggedBlock
{
    public static final EnumProperty<HollowLogVariants.Climbable> VARIANT;
    private static final VoxelShape LADDER_EAST;
    private static final VoxelShape LADDER_WEST;
    private static final VoxelShape LADDER_SOUTH;
    private static final VoxelShape LADDER_NORTH;
    private static final VoxelShape HOLLOW_SHAPE;
    private static final VoxelShape HOLLOW_SHAPE_SOUTH;
    private static final VoxelShape HOLLOW_SHAPE_NORTH;
    private static final VoxelShape HOLLOW_SHAPE_EAST;
    private static final VoxelShape HOLLOW_SHAPE_WEST;
    private static final VoxelShape COLLISION_SHAPE;
    private static final VoxelShape COLLISION_SHAPE_SOUTH;
    private static final VoxelShape COLLISION_SHAPE_NORTH;
    private static final VoxelShape COLLISION_SHAPE_EAST;
    private static final VoxelShape COLLISION_SHAPE_WEST;
    private final RegistryObject<HollowLogVertical> vertical;
    
    public HollowLogClimbable(final BlockBehaviour.Properties props, final RegistryObject<HollowLogVertical> vertical) {
        super(props);
        this.vertical = vertical;
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.VINE)).m_61124_((Property)HollowLogClimbable.f_54117_, (Comparable)Direction.NORTH));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        VoxelShape voxelShape = null;
        if (state.m_61143_((Property)HollowLogClimbable.VARIANT) == HollowLogVariants.Climbable.VINE) {
            voxelShape = HollowLogClimbable.HOLLOW_SHAPE;
        }
        else {
            voxelShape = switch ((Direction)state.m_61143_((Property)HollowLogClimbable.f_54117_)) {
                case SOUTH -> HollowLogClimbable.HOLLOW_SHAPE_SOUTH;
                case WEST -> HollowLogClimbable.HOLLOW_SHAPE_WEST;
                case EAST -> HollowLogClimbable.HOLLOW_SHAPE_EAST;
                default -> HollowLogClimbable.HOLLOW_SHAPE_NORTH;
            };
        }
        return voxelShape;
    }
    
    public VoxelShape m_5939_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        VoxelShape voxelShape = null;
        if (state.m_61143_((Property)HollowLogClimbable.VARIANT) == HollowLogVariants.Climbable.VINE) {
            voxelShape = HollowLogClimbable.COLLISION_SHAPE;
        }
        else {
            voxelShape = switch ((Direction)state.m_61143_((Property)HollowLogClimbable.f_54117_)) {
                case SOUTH -> HollowLogClimbable.COLLISION_SHAPE_SOUTH;
                case WEST -> HollowLogClimbable.COLLISION_SHAPE_WEST;
                case EAST -> HollowLogClimbable.COLLISION_SHAPE_EAST;
                default -> HollowLogClimbable.COLLISION_SHAPE_NORTH;
            };
        }
        return voxelShape;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder.m_61104_(new Property[] { (Property)HollowLogClimbable.VARIANT, (Property)HollowLogClimbable.f_54117_ }));
    }
    
    public boolean isStateWaterlogged(final BlockState state) {
        return state.m_61143_((Property)HollowLogClimbable.VARIANT) == HollowLogVariants.Climbable.LADDER_WATERLOGGED;
    }
    
    public BlockState setWaterlog(final BlockState prior, final boolean doWater) {
        return switch ((HollowLogVariants.Climbable)prior.m_61143_((Property)HollowLogClimbable.VARIANT)) {
            case VINE -> doWater ? ((HollowLogVertical)this.vertical.get()).m_49966_().m_61124_((Property)HollowLogVertical.WATERLOGGED, (Comparable)true) : prior;
            case LADDER -> (BlockState)prior.m_61124_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.LADDER_WATERLOGGED);
            case LADDER_WATERLOGGED -> (BlockState)prior.m_61124_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.LADDER);
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    public FluidState m_5888_(final BlockState state) {
        return (state.m_61143_((Property)HollowLogClimbable.VARIANT) == HollowLogVariants.Climbable.LADDER_WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    public BlockState m_7417_(final BlockState state, final Direction facing, final BlockState neighborState, final LevelAccessor level, final BlockPos pos, final BlockPos neighborPos) {
        if (this.isStateWaterlogged(state)) {
            level.m_6217_().m_5945_(pos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)level));
        }
        return super.m_7417_(state, facing, neighborState, level, pos, neighborPos);
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        if (!isInside((HitResult)hit, pos)) {
            return super.m_6227_(state, level, pos, player, hand, hit);
        }
        final ItemStack stack = player.m_21120_(hand);
        if (stack.canPerformAction(ToolActions.SHEARS_HARVEST)) {
            final HollowLogVariants.Climbable variant = (HollowLogVariants.Climbable)state.m_61143_((Property)HollowLogClimbable.VARIANT);
            level.m_7731_(pos, (BlockState)((HollowLogVertical)this.vertical.get()).m_49966_().m_61124_((Property)HollowLogVertical.WATERLOGGED, (Comparable)(variant == HollowLogVariants.Climbable.LADDER_WATERLOGGED)), 3);
            level.m_5594_((Player)null, pos, SoundEvents.f_12344_, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!player.m_7500_()) {
                stack.m_41622_(1, (LivingEntity)player, p -> p.m_21190_(hand));
                level.m_7967_((Entity)new ItemEntity(level, pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, new ItemStack((ItemLike)((variant == HollowLogVariants.Climbable.VINE) ? Blocks.f_50191_ : Blocks.f_50155_))));
            }
            player.m_6674_(hand);
            return InteractionResult.CONSUME;
        }
        return super.m_6227_(state, level, pos, player, hand, hit);
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
        VARIANT = EnumProperty.m_61587_("variant", (Class)HollowLogVariants.Climbable.class);
        LADDER_EAST = Block.m_49796_(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        LADDER_WEST = Block.m_49796_(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        LADDER_SOUTH = Block.m_49796_(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        LADDER_NORTH = Block.m_49796_(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        HOLLOW_SHAPE = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(2.0, 0.0, 2.0, 14.0, 16.0, 14.0), BooleanOp.f_82685_);
        HOLLOW_SHAPE_SOUTH = Shapes.m_83110_(HollowLogClimbable.HOLLOW_SHAPE, HollowLogClimbable.LADDER_SOUTH);
        HOLLOW_SHAPE_NORTH = Shapes.m_83110_(HollowLogClimbable.HOLLOW_SHAPE, HollowLogClimbable.LADDER_NORTH);
        HOLLOW_SHAPE_EAST = Shapes.m_83110_(HollowLogClimbable.HOLLOW_SHAPE, HollowLogClimbable.LADDER_EAST);
        HOLLOW_SHAPE_WEST = Shapes.m_83110_(HollowLogClimbable.HOLLOW_SHAPE, HollowLogClimbable.LADDER_WEST);
        COLLISION_SHAPE = Shapes.m_83113_(Shapes.m_83144_(), Block.m_49796_(1.0, 0.0, 1.0, 15.0, 16.0, 15.0), BooleanOp.f_82685_);
        COLLISION_SHAPE_SOUTH = Shapes.m_83110_(HollowLogClimbable.COLLISION_SHAPE, HollowLogClimbable.LADDER_SOUTH);
        COLLISION_SHAPE_NORTH = Shapes.m_83110_(HollowLogClimbable.COLLISION_SHAPE, HollowLogClimbable.LADDER_NORTH);
        COLLISION_SHAPE_EAST = Shapes.m_83110_(HollowLogClimbable.COLLISION_SHAPE, HollowLogClimbable.LADDER_EAST);
        COLLISION_SHAPE_WEST = Shapes.m_83110_(HollowLogClimbable.COLLISION_SHAPE, HollowLogClimbable.LADDER_WEST);
    }
}
