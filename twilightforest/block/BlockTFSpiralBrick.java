// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import javax.annotation.Nullable;
import net.minecraft.util.Rotation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import twilightforest.client.ModelUtils;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.util.Mirror;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import twilightforest.enums.Diagonals;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFSpiralBrick extends Block implements ModelRegisterCallback
{
    public static final IProperty<Diagonals> DIAGONAL;
    public static final IProperty<EnumFacing.Axis> AXIS_FACING;
    
    public BlockTFSpiralBrick() {
        super(Material.field_151576_e, MapColor.field_151665_m);
        this.func_149711_c(1.5f);
        this.func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149713_g(255);
        this.field_149783_u = true;
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.TOP_RIGHT).func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)EnumFacing.Axis.X));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFSpiralBrick.AXIS_FACING, BlockTFSpiralBrick.DIAGONAL });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING)).ordinal() << 2 | ((Diagonals)state.func_177229_b((IProperty)BlockTFSpiralBrick.DIAGONAL)).ordinal();
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.values()[meta & 0x3]).func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)EnumFacing.Axis.values()[(meta & 0xC) >> 2]);
    }
    
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        final IBlockState state = worldIn.func_180495_p(pos.func_177972_a(facing.func_176734_d()));
        if (!placer.func_70093_af() && worldIn.func_180495_p(pos.func_177972_a(facing.func_176734_d())).func_177230_c() instanceof BlockTFSpiralBrick) {
            final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING);
            return super.func_180642_a(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)axis).func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.mirror((Diagonals)state.func_177229_b((IProperty)BlockTFSpiralBrick.DIAGONAL), (facing.func_176740_k() == EnumFacing.Axis.X) ? Mirror.LEFT_RIGHT : Mirror.FRONT_BACK));
        }
        final EnumFacing playerFacing = EnumFacing.func_190914_a(pos, placer);
        return super.func_180642_a(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)playerFacing.func_176740_k()).func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)getDiagonalFromPlayerPlacement(placer, facing));
    }
    
    private static Diagonals getDiagonalFromPlayerPlacement(final EntityLivingBase placer, final EnumFacing facing) {
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
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178440_a((IProperty)BlockTFSpiralBrick.AXIS_FACING).func_178439_a("_spiral_bricks").func_178441_a();
        ModelLoader.setCustomStateMapper((Block)this, stateMapper);
        ModelUtils.registerToState(this, 0, this.func_176223_P().func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.BOTTOM_LEFT), stateMapper);
    }
    
    public IBlockState func_185499_a(IBlockState state, final Rotation rot) {
        if (rot == Rotation.NONE) {
            return state;
        }
        final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING);
        if (axis == EnumFacing.Axis.Y) {
            return state.func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.rotate((Diagonals)state.func_177229_b((IProperty)BlockTFSpiralBrick.DIAGONAL), rot));
        }
        if (rot == Rotation.CLOCKWISE_180 || (axis == EnumFacing.Axis.X && rot == Rotation.COUNTERCLOCKWISE_90) || (axis == EnumFacing.Axis.Z && rot == Rotation.CLOCKWISE_90)) {
            state = state.func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.mirror((Diagonals)state.func_177229_b((IProperty)BlockTFSpiralBrick.DIAGONAL), Mirror.LEFT_RIGHT));
        }
        return (rot.ordinal() % 2 == 0) ? state : state.func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)((axis == EnumFacing.Axis.X) ? EnumFacing.Axis.Z : EnumFacing.Axis.X));
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirrorIn) {
        return state.func_177226_a((IProperty)BlockTFSpiralBrick.DIAGONAL, (Comparable)Diagonals.mirrorOn((EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING), (Diagonals)state.func_177229_b((IProperty)BlockTFSpiralBrick.DIAGONAL), mirrorIn));
    }
    
    public boolean rotateBlock(final World world, final BlockPos pos, final EnumFacing facing) {
        IBlockState state = world.func_180495_p(pos);
        if (facing.func_176740_k() == state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING)) {
            state = state.func_177231_a((IProperty)BlockTFSpiralBrick.DIAGONAL);
        }
        else {
            switch (facing.func_176740_k()) {
                case X: {
                    state = state.func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)((state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING) == EnumFacing.Axis.Y) ? EnumFacing.Axis.Z : EnumFacing.Axis.Y));
                    break;
                }
                case Y: {
                    state = state.func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)((state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING) == EnumFacing.Axis.X) ? EnumFacing.Axis.Z : EnumFacing.Axis.X));
                    break;
                }
                case Z: {
                    state = state.func_177226_a((IProperty)BlockTFSpiralBrick.AXIS_FACING, (Comparable)((state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING) == EnumFacing.Axis.Y) ? EnumFacing.Axis.X : EnumFacing.Axis.Y));
                    break;
                }
            }
        }
        world.func_175656_a(pos, state);
        return true;
    }
    
    @Nullable
    public EnumFacing[] getValidRotations(final World world, final BlockPos pos) {
        return EnumFacing.values();
    }
    
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFSpiralBrick.AXIS_FACING);
        if (face.func_176740_k() == axis) {
            return BlockFaceShape.UNDEFINED;
        }
        final EnumFacing top = (axis == EnumFacing.Axis.Y) ? EnumFacing.NORTH : EnumFacing.UP;
        final EnumFacing left = (axis == EnumFacing.Axis.X) ? EnumFacing.SOUTH : EnumFacing.WEST;
        final Diagonals diagonal = (Diagonals)state.func_177229_b((IProperty)BlockTFSpiralBrick.DIAGONAL);
        if (face == (diagonal.isLeft() ? left : left.func_176734_d()) || face == (diagonal.isTop() ? top : top.func_176734_d())) {
            return BlockFaceShape.SOLID;
        }
        return BlockFaceShape.UNDEFINED;
    }
    
    public boolean doesSideBlockRendering(final IBlockState state, final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return this.func_193383_a(world, state, pos, face) == BlockFaceShape.SOLID;
    }
    
    protected ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack(Item.func_150898_a((Block)this));
    }
    
    static {
        DIAGONAL = (IProperty)PropertyEnum.func_177709_a("diagonal", (Class)Diagonals.class);
        AXIS_FACING = (IProperty)PropertyEnum.func_177709_a("axis", (Class)EnumFacing.Axis.class);
    }
}
