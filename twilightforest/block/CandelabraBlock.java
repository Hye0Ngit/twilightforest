// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.entity.BlockEntity;
import java.util.Random;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class CandelabraBlock extends AbstractLightableBlock
{
    public static final BooleanProperty ON_WALL;
    public static final DirectionProperty FACING;
    public static final VoxelShape CANDLES_NORTH;
    public static final VoxelShape CANDLES_SOUTH;
    public static final VoxelShape CANDLES_WEST;
    public static final VoxelShape CANDLES_EAST;
    public static final VoxelShape CANDLES_X;
    public static final VoxelShape CANDLES_Z;
    
    protected CandelabraBlock(final BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)CandelabraBlock.FACING, (Comparable)Direction.NORTH)).m_61124_((Property)CandelabraBlock.ON_WALL, (Comparable)false)).m_61124_((Property)CandelabraBlock.LIGHTING, (Comparable)Lighting.NONE));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        if (state.m_61143_((Property)CandelabraBlock.ON_WALL)) {
            return switch ((Direction)state.m_61143_((Property)CandelabraBlock.FACING)) {
                case SOUTH -> CandelabraBlock.CANDLES_SOUTH;
                case WEST -> CandelabraBlock.CANDLES_WEST;
                case EAST -> CandelabraBlock.CANDLES_EAST;
                default -> CandelabraBlock.CANDLES_NORTH;
            };
        }
        return (((Direction)state.m_61143_((Property)CandelabraBlock.FACING)).m_122434_() == Direction.Axis.X) ? CandelabraBlock.CANDLES_X : CandelabraBlock.CANDLES_Z;
    }
    
    public BlockState m_5573_(final BlockPlaceContext context) {
        final Direction clickDirection = context.m_43719_();
        final boolean onBottomBlock = clickDirection == Direction.UP;
        final Direction[] placements = context.m_6232_();
        final BlockPos placePos = context.m_8083_();
        final Level level = context.m_43725_();
        if (onBottomBlock) {
            if (canSurvive((LevelReader)level, placePos, false, context.m_8125_())) {
                return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)CandelabraBlock.FACING, (Comparable)context.m_8125_())).m_61124_((Property)CandelabraBlock.ON_WALL, (Comparable)false);
            }
            for (final Direction nextSide : placements) {
                if (nextSide.m_122434_().m_122479_() && canSurvive((LevelReader)level, placePos, true, nextSide)) {
                    return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)CandelabraBlock.FACING, (Comparable)context.m_8125_())).m_61124_((Property)CandelabraBlock.ON_WALL, (Comparable)true);
                }
            }
        }
        else {
            for (final Direction nextSide : placements) {
                if (nextSide.m_122434_().m_122479_() && canSurvive((LevelReader)level, placePos, true, nextSide)) {
                    return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)CandelabraBlock.FACING, (Comparable)context.m_8125_())).m_61124_((Property)CandelabraBlock.ON_WALL, (Comparable)true);
                }
            }
            if (canSurvive((LevelReader)level, placePos, false, context.m_8125_())) {
                return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)CandelabraBlock.FACING, (Comparable)context.m_8125_())).m_61124_((Property)CandelabraBlock.ON_WALL, (Comparable)false);
            }
        }
        return null;
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.m_61104_(new Property[] { (Property)CandelabraBlock.FACING, (Property)CandelabraBlock.ON_WALL, (Property)CandelabraBlock.LIGHTING });
    }
    
    public boolean m_7898_(final BlockState state, final LevelReader levelReader, final BlockPos pos) {
        return canSurvive(levelReader, pos, (boolean)state.m_61143_((Property)CandelabraBlock.ON_WALL), (Direction)state.m_61143_((Property)CandelabraBlock.FACING));
    }
    
    public static boolean canSurvive(final LevelReader levelReader, final BlockPos pos, final boolean onWall, final Direction facing) {
        return m_49863_(levelReader, onWall ? pos.m_142300_(facing) : pos.m_7495_(), Direction.UP);
    }
    
    public RenderShape m_7514_(final BlockState pState) {
        return RenderShape.MODEL;
    }
    
    public BlockState m_6843_(final BlockState pState, final Rotation pRot) {
        return (BlockState)pState.m_61124_((Property)CandelabraBlock.FACING, (Comparable)pRot.m_55954_((Direction)pState.m_61143_((Property)CandelabraBlock.FACING)));
    }
    
    public BlockState m_6943_(final BlockState pState, final Mirror pMirror) {
        return pState.m_60717_(pMirror.m_54846_((Direction)pState.m_61143_((Property)CandelabraBlock.FACING)));
    }
    
    public void m_7100_(final BlockState state, final Level level, final BlockPos pos, final Random rand) {
        final boolean ominous = state.m_61143_((Property)CandelabraBlock.LIGHTING) == Lighting.OMINOUS;
        if (state.m_61143_((Property)CandelabraBlock.LIGHTING) != Lighting.NONE) {
            if (state.m_61143_((Property)CandelabraBlock.ON_WALL)) {
                switch ((Direction)state.m_61143_((Property)CandelabraBlock.FACING)) {
                    case SOUTH: {
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.1875, 0.875, 0.75, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.5, 0.875, 0.75, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.8125, 0.875, 0.75, rand, ominous);
                        break;
                    }
                    case WEST: {
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.25, 0.875, 0.1875, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.25, 0.875, 0.5, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.25, 0.875, 0.8125, rand, ominous);
                        break;
                    }
                    case EAST: {
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.75, 0.875, 0.1875, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.75, 0.875, 0.5, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.75, 0.875, 0.8125, rand, ominous);
                        break;
                    }
                    default: {
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.1875, 0.875, 0.25, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.5, 0.875, 0.25, rand, ominous);
                        AbstractLightableBlock.addParticlesAndSound(level, pos, 0.8125, 0.875, 0.25, rand, ominous);
                        break;
                    }
                }
            }
            else if (((Direction)state.m_61143_((Property)CandelabraBlock.FACING)).m_122434_() == Direction.Axis.X) {
                AbstractLightableBlock.addParticlesAndSound(level, pos, 0.5, 0.875, 0.1875, rand, ominous);
                AbstractLightableBlock.addParticlesAndSound(level, pos, 0.5, 0.875, 0.5, rand, ominous);
                AbstractLightableBlock.addParticlesAndSound(level, pos, 0.5, 0.875, 0.8125, rand, ominous);
            }
            else {
                AbstractLightableBlock.addParticlesAndSound(level, pos, 0.1875, 0.875, 0.5, rand, ominous);
                AbstractLightableBlock.addParticlesAndSound(level, pos, 0.5, 0.875, 0.5, rand, ominous);
                AbstractLightableBlock.addParticlesAndSound(level, pos, 0.8125, 0.875, 0.5, rand, ominous);
            }
        }
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pPos, final BlockState pState) {
        return null;
    }
    
    static {
        ON_WALL = BooleanProperty.m_61465_("on_wall");
        FACING = BlockStateProperties.f_61374_;
        CANDLES_NORTH = Shapes.m_83124_(Block.m_49796_(1.0, 7.0, 2.0, 15.0, 15.0, 6.0), new VoxelShape[] { Block.m_49796_(1.0, 1.0, 3.5, 15.0, 7.0, 4.5), Block.m_49796_(7.5, 1.0, 1.0, 8.5, 7.0, 7.0), Block.m_49796_(6.0, 2.0, 0.0, 10.0, 6.0, 1.0) });
        CANDLES_SOUTH = Shapes.m_83124_(Block.m_49796_(1.0, 7.0, 10.0, 15.0, 15.0, 14.0), new VoxelShape[] { Block.m_49796_(1.0, 1.0, 11.5, 15.0, 7.0, 12.5), Block.m_49796_(7.5, 1.0, 9.0, 8.5, 7.0, 15.0), Block.m_49796_(6.0, 2.0, 15.0, 10.0, 6.0, 16.0) });
        CANDLES_WEST = Shapes.m_83124_(Block.m_49796_(2.0, 7.0, 1.0, 6.0, 15.0, 15.0), new VoxelShape[] { Block.m_49796_(3.5, 1.0, 1.0, 4.5, 7.0, 15.0), Block.m_49796_(1.0, 1.0, 7.5, 7.0, 7.0, 8.5), Block.m_49796_(0.0, 2.0, 6.0, 1.0, 6.0, 10.0) });
        CANDLES_EAST = Shapes.m_83124_(Block.m_49796_(10.0, 7.0, 1.0, 14.0, 15.0, 15.0), new VoxelShape[] { Block.m_49796_(11.5, 1.0, 1.0, 12.5, 7.0, 15.0), Block.m_49796_(9.0, 1.0, 7.5, 15.0, 7.0, 8.5), Block.m_49796_(15.0, 2.0, 6.0, 16.0, 6.0, 10.0) });
        CANDLES_X = Shapes.m_83124_(Block.m_49796_(6.0, 7.0, 1.0, 10.0, 15.0, 15.0), new VoxelShape[] { Block.m_49796_(7.5, 1.0, 1.0, 8.5, 7.0, 15.0), Block.m_49796_(5.0, 1.0, 7.5, 11.0, 7.0, 8.5), Block.m_49796_(6.0, 0.0, 6.0, 10.0, 1.0, 10.0) });
        CANDLES_Z = Shapes.m_83124_(Block.m_49796_(1.0, 7.0, 6.0, 15.0, 15.0, 10.0), new VoxelShape[] { Block.m_49796_(1.0, 1.0, 7.5, 15.0, 7.0, 8.5), Block.m_49796_(7.5, 1.0, 5.0, 8.5, 7.0, 11.0), Block.m_49796_(6.0, 0.0, 6.0, 10.0, 1.0, 10.0) });
    }
}
