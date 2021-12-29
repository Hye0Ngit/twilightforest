// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.ToolActions;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.material.Fluids;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import twilightforest.enums.BanisterShape;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class BanisterBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<BanisterShape> SHAPE;
    public static final BooleanProperty EXTENDED;
    private static final VoxelShape NORTH_SUPPORTS_TALL;
    private static final VoxelShape EAST_SUPPORTS_TALL;
    private static final VoxelShape SOUTH_SUPPORTS_TALL;
    private static final VoxelShape WEST_SUPPORTS_TALL;
    private static final VoxelShape NORTH_SUPPORTS_SHORT;
    private static final VoxelShape EAST_SUPPORTS_SHORT;
    private static final VoxelShape SOUTH_SUPPORTS_SHORT;
    private static final VoxelShape WEST_SUPPORTS_SHORT;
    private static final VoxelShape NORTH_EXTENSION;
    private static final VoxelShape EAST_EXTENSION;
    private static final VoxelShape SOUTH_EXTENSION;
    private static final VoxelShape WEST_EXTENSION;
    private static final VoxelShape NORTH_TALL;
    private static final VoxelShape EAST_TALL;
    private static final VoxelShape SOUTH_TALL;
    private static final VoxelShape WEST_TALL;
    private static final VoxelShape NORTH_SHORT;
    private static final VoxelShape EAST_SHORT;
    private static final VoxelShape SOUTH_SHORT;
    private static final VoxelShape WEST_SHORT;
    private static final VoxelShape NORTH_TALL_EXTENDED;
    private static final VoxelShape EAST_TALL_EXTENDED;
    private static final VoxelShape SOUTH_TALL_EXTENDED;
    private static final VoxelShape WEST_TALL_EXTENDED;
    private static final VoxelShape NORTH_SHORT_EXTENDED;
    private static final VoxelShape EAST_SHORT_EXTENDED;
    private static final VoxelShape SOUTH_SHORT_EXTENDED;
    private static final VoxelShape WEST_SHORT_EXTENDED;
    private static final VoxelShape NORTH_CONNECTED_EXTENDED;
    private static final VoxelShape EAST_CONNECTED_EXTENDED;
    private static final VoxelShape SOUTH_CONNECTED_EXTENDED;
    private static final VoxelShape WEST_CONNECTED_EXTENDED;
    
    public BanisterBlock(final BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)BanisterBlock.SHAPE, (Comparable)BanisterShape.TALL)).m_61124_((Property)BanisterBlock.EXTENDED, (Comparable)false)).m_61124_((Property)BanisterBlock.f_54117_, (Comparable)Direction.NORTH)).m_61124_((Property)BanisterBlock.WATERLOGGED, (Comparable)false));
    }
    
    public BlockState m_5573_(final BlockPlaceContext context) {
        final BlockPos pos = context.m_8083_();
        return (BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_((Property)BanisterBlock.f_54117_, (Comparable)context.m_8125_())).m_61124_((Property)BanisterBlock.SHAPE, (Comparable)(BlockTagGenerator.BANISTERS.m_8110_((Object)context.m_43725_().m_8055_(pos.m_7494_()).m_60734_()) ? BanisterShape.CONNECTED : BanisterShape.TALL))).m_61124_((Property)BanisterBlock.WATERLOGGED, (Comparable)(context.m_43725_().m_6425_(pos).m_76152_() == Fluids.f_76193_));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter blockGetter, final BlockPos pos, final CollisionContext context) {
        final boolean extended = (boolean)state.m_61143_((Property)BanisterBlock.EXTENDED);
        VoxelShape voxelShape = null;
        Label_0404: {
            switch ((BanisterShape)state.m_61143_((Property)BanisterBlock.SHAPE)) {
                case SHORT: {
                    switch ((Direction)state.m_61143_((Property)BanisterBlock.f_54117_)) {
                        case NORTH: {
                            voxelShape = (extended ? BanisterBlock.NORTH_SHORT_EXTENDED : BanisterBlock.NORTH_SHORT);
                            break Label_0404;
                        }
                        case WEST: {
                            voxelShape = (extended ? BanisterBlock.WEST_SHORT_EXTENDED : BanisterBlock.WEST_SHORT);
                            break Label_0404;
                        }
                        case EAST: {
                            voxelShape = (extended ? BanisterBlock.EAST_SHORT_EXTENDED : BanisterBlock.EAST_SHORT);
                            break Label_0404;
                        }
                        default: {
                            voxelShape = (extended ? BanisterBlock.SOUTH_SHORT_EXTENDED : BanisterBlock.SOUTH_SHORT);
                            break Label_0404;
                        }
                    }
                    break;
                }
                case CONNECTED: {
                    switch ((Direction)state.m_61143_((Property)BanisterBlock.f_54117_)) {
                        case NORTH: {
                            voxelShape = (extended ? BanisterBlock.NORTH_CONNECTED_EXTENDED : BanisterBlock.NORTH_SUPPORTS_TALL);
                            break Label_0404;
                        }
                        case WEST: {
                            voxelShape = (extended ? BanisterBlock.WEST_CONNECTED_EXTENDED : BanisterBlock.WEST_SUPPORTS_TALL);
                            break Label_0404;
                        }
                        case EAST: {
                            voxelShape = (extended ? BanisterBlock.EAST_CONNECTED_EXTENDED : BanisterBlock.EAST_SUPPORTS_TALL);
                            break Label_0404;
                        }
                        default: {
                            voxelShape = (extended ? BanisterBlock.SOUTH_CONNECTED_EXTENDED : BanisterBlock.SOUTH_SUPPORTS_TALL);
                            break Label_0404;
                        }
                    }
                    break;
                }
                case TALL: {
                    switch ((Direction)state.m_61143_((Property)BanisterBlock.f_54117_)) {
                        case NORTH: {
                            voxelShape = (extended ? BanisterBlock.NORTH_TALL_EXTENDED : BanisterBlock.NORTH_TALL);
                            break Label_0404;
                        }
                        case WEST: {
                            voxelShape = (extended ? BanisterBlock.WEST_TALL_EXTENDED : BanisterBlock.WEST_TALL);
                            break Label_0404;
                        }
                        case EAST: {
                            voxelShape = (extended ? BanisterBlock.EAST_TALL_EXTENDED : BanisterBlock.EAST_TALL);
                            break Label_0404;
                        }
                        default: {
                            voxelShape = (extended ? BanisterBlock.SOUTH_TALL_EXTENDED : BanisterBlock.SOUTH_TALL);
                            break Label_0404;
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
    
    public void m_5871_(final ItemStack stack, @Nullable final BlockGetter level, final List<Component> tooltip, final TooltipFlag flag) {
        tooltip.add((Component)new TranslatableComponent("block.twilightforest.banister.cycle").m_130940_(ChatFormatting.GRAY));
    }
    
    @Nullable
    public BlockPathTypes getAiPathNodeType(final BlockState state, final BlockGetter world, final BlockPos pos, @Nullable final Mob entity) {
        return BlockPathTypes.BLOCKED;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.m_61104_(new Property[] { (Property)BanisterBlock.SHAPE, (Property)BanisterBlock.EXTENDED, (Property)BanisterBlock.f_54117_, (Property)BanisterBlock.WATERLOGGED });
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)BanisterBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hitResult) {
        final ItemStack held = player.m_21120_(hand);
        if (held.canPerformAction(ToolActions.AXE_WAX_OFF)) {
            final BlockState newState = (BlockState)state.m_61122_((Property)BanisterBlock.SHAPE);
            level.m_5594_((Player)null, pos, SoundEvents.f_11688_, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.m_7731_(pos, (newState.m_61143_((Property)BanisterBlock.SHAPE) == BanisterShape.TALL) ? ((BlockState)newState.m_61122_((Property)BanisterBlock.EXTENDED)) : newState, 3);
            return InteractionResult.SUCCESS;
        }
        return super.m_6227_(state, level, pos, player, hand, hitResult);
    }
    
    static {
        WATERLOGGED = BlockStateProperties.f_61362_;
        SHAPE = EnumProperty.m_61587_("shape", (Class)BanisterShape.class);
        EXTENDED = BooleanProperty.m_61465_("extended");
        NORTH_SUPPORTS_TALL = Shapes.m_83110_(Block.m_49796_(2.5, 0.0, 0.0, 5.5, 16.0, 3.0), Block.m_49796_(10.5, 0.0, 0.0, 13.5, 16.0, 3.0));
        EAST_SUPPORTS_TALL = Shapes.m_83110_(Block.m_49796_(13.0, 0.0, 2.5, 16.0, 16.0, 5.5), Block.m_49796_(13.0, 0.0, 10.5, 16.0, 16.0, 13.5));
        SOUTH_SUPPORTS_TALL = Shapes.m_83110_(Block.m_49796_(2.5, 0.0, 13.0, 5.5, 16.0, 16.0), Block.m_49796_(10.5, 0.0, 13.0, 13.5, 16.0, 16.0));
        WEST_SUPPORTS_TALL = Shapes.m_83110_(Block.m_49796_(0.0, 0.0, 2.5, 3.0, 16.0, 5.5), Block.m_49796_(0.0, 0.0, 10.5, 3.0, 16.0, 13.5));
        NORTH_SUPPORTS_SHORT = Shapes.m_83110_(Block.m_49796_(2.5, 0.0, 0.0, 5.5, 4.0, 3.0), Block.m_49796_(10.5, 0.0, 0.0, 13.5, 4.0, 3.0));
        EAST_SUPPORTS_SHORT = Shapes.m_83110_(Block.m_49796_(13.0, 0.0, 2.5, 16.0, 4.0, 5.5), Block.m_49796_(13.0, 0.0, 10.5, 16.0, 4.0, 13.5));
        SOUTH_SUPPORTS_SHORT = Shapes.m_83110_(Block.m_49796_(2.5, 0.0, 13.0, 5.5, 4.0, 16.0), Block.m_49796_(10.5, 0.0, 13.0, 13.5, 4.0, 16.0));
        WEST_SUPPORTS_SHORT = Shapes.m_83110_(Block.m_49796_(0.0, 0.0, 2.5, 3.0, 4.0, 5.5), Block.m_49796_(0.0, 0.0, 10.5, 3.0, 4.0, 13.5));
        NORTH_EXTENSION = Shapes.m_83110_(Block.m_49796_(2.5, -8.0, 0.0, 5.5, 0.0, 3.0), Block.m_49796_(10.5, -8.0, 0.0, 13.5, 0.0, 3.0));
        EAST_EXTENSION = Shapes.m_83110_(Block.m_49796_(13.0, -8.0, 2.5, 16.0, 0.0, 5.5), Block.m_49796_(13.0, -8.0, 10.5, 16.0, 0.0, 13.5));
        SOUTH_EXTENSION = Shapes.m_83110_(Block.m_49796_(2.5, -8.0, 13.0, 5.5, 0.0, 16.0), Block.m_49796_(10.5, -8.0, 13.0, 13.5, 0.0, 16.0));
        WEST_EXTENSION = Shapes.m_83110_(Block.m_49796_(0.0, -8.0, 2.5, 3.0, 0.0, 5.5), Block.m_49796_(0.0, -8.0, 10.5, 3.0, 0.0, 13.5));
        NORTH_TALL = Shapes.m_83110_(Block.m_49796_(0.0, 12.0, 0.0, 16.0, 16.0, 4.0), BanisterBlock.NORTH_SUPPORTS_TALL);
        EAST_TALL = Shapes.m_83110_(Block.m_49796_(12.0, 12.0, 0.0, 16.0, 16.0, 16.0), BanisterBlock.EAST_SUPPORTS_TALL);
        SOUTH_TALL = Shapes.m_83110_(Block.m_49796_(0.0, 12.0, 12.0, 16.0, 16.0, 16.0), BanisterBlock.SOUTH_SUPPORTS_TALL);
        WEST_TALL = Shapes.m_83110_(Block.m_49796_(0.0, 12.0, 0.0, 4.0, 16.0, 16.0), BanisterBlock.WEST_SUPPORTS_TALL);
        NORTH_SHORT = Shapes.m_83110_(Block.m_49796_(0.0, 4.0, 0.0, 16.0, 8.0, 4.0), BanisterBlock.NORTH_SUPPORTS_SHORT);
        EAST_SHORT = Shapes.m_83110_(Block.m_49796_(12.0, 4.0, 0.0, 16.0, 8.0, 16.0), BanisterBlock.EAST_SUPPORTS_SHORT);
        SOUTH_SHORT = Shapes.m_83110_(Block.m_49796_(0.0, 4.0, 12.0, 16.0, 8.0, 16.0), BanisterBlock.SOUTH_SUPPORTS_SHORT);
        WEST_SHORT = Shapes.m_83110_(Block.m_49796_(0.0, 4.0, 0.0, 4.0, 8.0, 16.0), BanisterBlock.WEST_SUPPORTS_SHORT);
        NORTH_TALL_EXTENDED = Shapes.m_83110_(BanisterBlock.NORTH_TALL, BanisterBlock.NORTH_EXTENSION);
        EAST_TALL_EXTENDED = Shapes.m_83110_(BanisterBlock.EAST_TALL, BanisterBlock.EAST_EXTENSION);
        SOUTH_TALL_EXTENDED = Shapes.m_83110_(BanisterBlock.SOUTH_TALL, BanisterBlock.SOUTH_EXTENSION);
        WEST_TALL_EXTENDED = Shapes.m_83110_(BanisterBlock.WEST_TALL, BanisterBlock.WEST_EXTENSION);
        NORTH_SHORT_EXTENDED = Shapes.m_83110_(BanisterBlock.NORTH_SHORT, BanisterBlock.NORTH_EXTENSION);
        EAST_SHORT_EXTENDED = Shapes.m_83110_(BanisterBlock.EAST_SHORT, BanisterBlock.EAST_EXTENSION);
        SOUTH_SHORT_EXTENDED = Shapes.m_83110_(BanisterBlock.SOUTH_SHORT, BanisterBlock.SOUTH_EXTENSION);
        WEST_SHORT_EXTENDED = Shapes.m_83110_(BanisterBlock.WEST_SHORT, BanisterBlock.WEST_EXTENSION);
        NORTH_CONNECTED_EXTENDED = Shapes.m_83110_(BanisterBlock.NORTH_SUPPORTS_TALL, BanisterBlock.NORTH_EXTENSION);
        EAST_CONNECTED_EXTENDED = Shapes.m_83110_(BanisterBlock.EAST_SUPPORTS_TALL, BanisterBlock.EAST_EXTENSION);
        SOUTH_CONNECTED_EXTENDED = Shapes.m_83110_(BanisterBlock.SOUTH_SUPPORTS_TALL, BanisterBlock.SOUTH_EXTENSION);
        WEST_CONNECTED_EXTENDED = Shapes.m_83110_(BanisterBlock.WEST_SUPPORTS_TALL, BanisterBlock.WEST_EXTENSION);
    }
}
