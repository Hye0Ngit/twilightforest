// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Rotation;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Mirror;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import twilightforest.enums.Diagonals;
import net.minecraft.state.EnumProperty;
import net.minecraft.block.Block;

public class SpiralBrickBlock extends Block
{
    public static final EnumProperty<Diagonals> DIAGONAL;
    public static final EnumProperty<Direction.Axis> AXIS_FACING;
    
    public SpiralBrickBlock() {
        super(AbstractBlock.Properties.func_200949_a(Material.field_151576_e, MaterialColor.field_151665_m).func_235861_h_().func_200948_a(1.5f, 10.0f).func_200947_a(SoundType.field_185851_d).func_226896_b_());
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.TOP_RIGHT)).func_206870_a((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)Direction.Axis.X));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)SpiralBrickBlock.AXIS_FACING, (Property)SpiralBrickBlock.DIAGONAL });
    }
    
    public int getLightValue(final BlockState state, final IBlockReader world, final BlockPos pos) {
        return super.getLightValue(state, world, pos);
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final BlockState state = context.func_195991_k().func_180495_p(context.func_195995_a().func_177972_a(context.func_196000_l().func_176734_d()));
        if (!context.func_195999_j().func_225608_bj_() && context.func_195991_k().func_180495_p(context.func_195995_a().func_177972_a(context.func_196000_l().func_176734_d())).func_177230_c() instanceof SpiralBrickBlock) {
            final Direction.Axis axis = (Direction.Axis)state.func_177229_b((Property)SpiralBrickBlock.AXIS_FACING);
            return (BlockState)((BlockState)super.func_196258_a(context).func_206870_a((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)axis)).func_206870_a((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.mirror((Diagonals)state.func_177229_b((Property)SpiralBrickBlock.DIAGONAL), (context.func_196000_l().func_176740_k() == Direction.Axis.X) ? Mirror.LEFT_RIGHT : Mirror.FRONT_BACK));
        }
        final Direction playerFacing = context.func_196010_d().func_176734_d();
        return (BlockState)((BlockState)super.func_196258_a(context).func_206870_a((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)playerFacing.func_176740_k())).func_206870_a((Property)SpiralBrickBlock.DIAGONAL, (Comparable)getDiagonalFromPlayerPlacement((LivingEntity)context.func_195999_j(), context.func_196000_l()));
    }
    
    private static Diagonals getDiagonalFromPlayerPlacement(final LivingEntity placer, final Direction facing) {
        final int angleX = (int)((placer.field_70125_A + 180.0f) / 180.0f) & 0x1;
        final int angleY = (int)((placer.field_70177_z + 180.0f) / 90.0f) & 0x3;
        switch (facing) {
            case DOWN:
            case UP: {
                switch (angleY) {
                    default: {
                        return Diagonals.TOP_RIGHT;
                    }
                    case 1: {
                        return Diagonals.BOTTOM_RIGHT;
                    }
                    case 2: {
                        return Diagonals.BOTTOM_LEFT;
                    }
                    case 3: {
                        return Diagonals.TOP_LEFT;
                    }
                }
                break;
            }
            case NORTH: {
                return Diagonals.getDiagonalFromUpDownLeftRight(isEast(angleY), angleX < 1);
            }
            case SOUTH: {
                return Diagonals.getDiagonalFromUpDownLeftRight(!isEast(angleY), angleX < 1);
            }
            case EAST: {
                return Diagonals.getDiagonalFromUpDownLeftRight(isNorth(angleY), angleX < 1);
            }
            case WEST: {
                return Diagonals.getDiagonalFromUpDownLeftRight(!isNorth(angleY), angleX < 1);
            }
            default: {
                return Diagonals.TOP_RIGHT;
            }
        }
    }
    
    private static boolean isNorth(final int intIn) {
        return intIn == 0 || intIn == 3;
    }
    
    private static boolean isEast(final int intIn) {
        return intIn == 0 || intIn == 1;
    }
    
    public BlockState func_185499_a(BlockState state, final Rotation rot) {
        if (rot == Rotation.NONE) {
            return state;
        }
        final Direction.Axis axis = (Direction.Axis)state.func_177229_b((Property)SpiralBrickBlock.AXIS_FACING);
        if (axis == Direction.Axis.Y) {
            return (BlockState)state.func_206870_a((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.rotate((Diagonals)state.func_177229_b((Property)SpiralBrickBlock.DIAGONAL), rot));
        }
        if (rot == Rotation.CLOCKWISE_180 || (axis == Direction.Axis.X && rot == Rotation.COUNTERCLOCKWISE_90) || (axis == Direction.Axis.Z && rot == Rotation.CLOCKWISE_90)) {
            state = (BlockState)state.func_206870_a((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.mirror((Diagonals)state.func_177229_b((Property)SpiralBrickBlock.DIAGONAL), Mirror.LEFT_RIGHT));
        }
        return (BlockState)((rot.ordinal() % 2 == 0) ? state : state.func_206870_a((Property)SpiralBrickBlock.AXIS_FACING, (Comparable)((axis == Direction.Axis.X) ? Direction.Axis.Z : Direction.Axis.X)));
    }
    
    @Deprecated
    public BlockState func_185471_a(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)state.func_206870_a((Property)SpiralBrickBlock.DIAGONAL, (Comparable)Diagonals.mirrorOn((Direction.Axis)state.func_177229_b((Property)SpiralBrickBlock.AXIS_FACING), (Diagonals)state.func_177229_b((Property)SpiralBrickBlock.DIAGONAL), mirrorIn));
    }
    
    static {
        DIAGONAL = EnumProperty.func_177709_a("diagonal", (Class)Diagonals.class);
        AXIS_FACING = EnumProperty.func_177709_a("axis", (Class)Direction.Axis.class);
    }
}
