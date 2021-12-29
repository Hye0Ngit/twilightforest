// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.Mirror;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockRotatedPillar;

public abstract class BlockTFDirectionalRotatedPillar extends BlockRotatedPillar
{
    public static final IProperty<Boolean> REVERSED;
    
    public BlockTFDirectionalRotatedPillar(final Material materialIn) {
        super(materialIn);
    }
    
    public BlockTFDirectionalRotatedPillar(final Material materialIn, final MapColor color) {
        super(materialIn, color);
    }
    
    public IBlockState func_176203_a(final int meta) {
        final IBlockState state = super.func_176203_a(meta);
        return state.func_177226_a((IProperty)BlockTFDirectionalRotatedPillar.REVERSED, (Comparable)((meta & 0x1) != 0x0));
    }
    
    public int func_176201_c(final IBlockState state) {
        final int meta = super.func_176201_c(state);
        return meta | (((boolean)state.func_177229_b((IProperty)BlockTFDirectionalRotatedPillar.REVERSED)) ? 1 : 0);
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFDirectionalRotatedPillar.field_176298_M, BlockTFDirectionalRotatedPillar.REVERSED });
    }
    
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        return super.func_180642_a(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).func_177226_a((IProperty)BlockTFDirectionalRotatedPillar.REVERSED, (Comparable)(facing.func_176743_c() == EnumFacing.AxisDirection.NEGATIVE));
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirror) {
        if (mirror != Mirror.NONE) {
            final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFDirectionalRotatedPillar.field_176298_M);
            if (axis == EnumFacing.Axis.Y || (mirror == Mirror.LEFT_RIGHT && axis == EnumFacing.Axis.Z) || (mirror == Mirror.FRONT_BACK && axis == EnumFacing.Axis.X)) {
                return state.func_177231_a((IProperty)BlockTFDirectionalRotatedPillar.REVERSED);
            }
        }
        return super.func_185471_a(state, mirror);
    }
    
    static {
        REVERSED = (IProperty)PropertyBool.func_177716_a("reversed");
    }
}
