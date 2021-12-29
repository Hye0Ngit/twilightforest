// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.Rotation;
import javax.annotation.Nullable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.Direction;
import twilightforest.enums.Diagonals;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.Block;

public class SpiralBrickBlock extends Block
{
    public static final EnumProperty<Diagonals> DIAGONAL;
    public static final EnumProperty<Direction.Axis> AXIS_FACING;
    
    public SpiralBrickBlock() {
        super(BlockBehaviour.Properties.m_60944_(Material.f_76278_, MaterialColor.f_76409_).m_60999_().m_60913_(1.5f, 10.0f).m_60918_(SoundType.f_56742_).m_60955_());
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.TOP_RIGHT)).m_61124_((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)Direction.Axis.X));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)SpiralBrickBlock.AXIS_FACING, (Property)SpiralBrickBlock.DIAGONAL });
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final BlockState state = context.m_43725_().m_8055_(context.m_8083_().m_142300_(context.m_43719_().m_122424_()));
        if (!context.m_43723_().m_6144_() && context.m_43725_().m_8055_(context.m_8083_().m_142300_(context.m_43719_().m_122424_())).m_60734_() instanceof SpiralBrickBlock) {
            final Direction.Axis axis = (Direction.Axis)state.m_61143_((Property)SpiralBrickBlock.AXIS_FACING);
            return (BlockState)((BlockState)super.m_5573_(context).m_61124_((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)axis)).m_61124_((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.mirror((Diagonals)state.m_61143_((Property)SpiralBrickBlock.DIAGONAL), (context.m_43719_().m_122434_() == Direction.Axis.X) ? Mirror.LEFT_RIGHT : Mirror.FRONT_BACK));
        }
        final Direction playerFacing = context.m_7820_().m_122424_();
        return (BlockState)((BlockState)super.m_5573_(context).m_61124_((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)playerFacing.m_122434_())).m_61124_((Property)SpiralBrickBlock.DIAGONAL, (Comparable)getDiagonalFromPlayerPlacement((LivingEntity)context.m_43723_(), context.m_43719_()));
    }
    
    private static Diagonals getDiagonalFromPlayerPlacement(final LivingEntity placer, final Direction facing) {
        final int angleX = (int)((placer.m_146909_() + 180.0f) / 180.0f) & 0x1;
        final int angleY = (int)((placer.m_146908_() + 180.0f) / 90.0f) & 0x3;
        Diagonals diagonals = null;
        Label_0232: {
            switch (facing) {
                case DOWN:
                case UP: {
                    switch (angleY) {
                        default: {
                            diagonals = Diagonals.TOP_RIGHT;
                            break Label_0232;
                        }
                        case 1: {
                            diagonals = Diagonals.BOTTOM_RIGHT;
                            break Label_0232;
                        }
                        case 2: {
                            diagonals = Diagonals.BOTTOM_LEFT;
                            break Label_0232;
                        }
                        case 3: {
                            diagonals = Diagonals.TOP_LEFT;
                            break Label_0232;
                        }
                    }
                    break;
                }
                case NORTH: {
                    diagonals = Diagonals.getDiagonalFromUpDownLeftRight(isEast(angleY), angleX < 1);
                    break;
                }
                case SOUTH: {
                    diagonals = Diagonals.getDiagonalFromUpDownLeftRight(!isEast(angleY), angleX < 1);
                    break;
                }
                case EAST: {
                    diagonals = Diagonals.getDiagonalFromUpDownLeftRight(isNorth(angleY), angleX < 1);
                    break;
                }
                case WEST: {
                    diagonals = Diagonals.getDiagonalFromUpDownLeftRight(!isNorth(angleY), angleX < 1);
                    break;
                }
                default: {
                    throw new IncompatibleClassChangeError();
                }
            }
        }
        return diagonals;
    }
    
    private static boolean isNorth(final int intIn) {
        return intIn == 0 || intIn == 3;
    }
    
    private static boolean isEast(final int intIn) {
        return intIn == 0 || intIn == 1;
    }
    
    public BlockState m_6843_(BlockState state, final Rotation rot) {
        if (rot == Rotation.NONE) {
            return state;
        }
        final Direction.Axis axis = (Direction.Axis)state.m_61143_((Property)SpiralBrickBlock.AXIS_FACING);
        if (axis == Direction.Axis.Y) {
            return (BlockState)state.m_61124_((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.rotate((Diagonals)state.m_61143_((Property)SpiralBrickBlock.DIAGONAL), rot));
        }
        if (rot == Rotation.CLOCKWISE_180 || (axis == Direction.Axis.X && rot == Rotation.COUNTERCLOCKWISE_90) || (axis == Direction.Axis.Z && rot == Rotation.CLOCKWISE_90)) {
            state = (BlockState)state.m_61124_((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.mirror((Diagonals)state.m_61143_((Property)SpiralBrickBlock.DIAGONAL), Mirror.LEFT_RIGHT));
        }
        return (BlockState)((rot.ordinal() % 2 == 0) ? state : state.m_61124_((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)((axis == Direction.Axis.X) ? Direction.Axis.Z : Direction.Axis.X)));
    }
    
    @Deprecated
    public BlockState m_6943_(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)state.m_61124_((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.mirrorOn((Direction.Axis)state.m_61143_((Property)SpiralBrickBlock.AXIS_FACING), (Diagonals)state.m_61143_((Property)SpiralBrickBlock.DIAGONAL), mirrorIn));
    }
    
    static {
        DIAGONAL = EnumProperty.m_61587_("diagonal", (Class)Diagonals.class);
        AXIS_FACING = EnumProperty.m_61587_("axis", (Class)Direction.Axis.class);
    }
}
