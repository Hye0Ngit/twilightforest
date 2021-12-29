// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFDiagonal extends Block implements ModelRegisterCallback
{
    public static final PropertyBool IS_ROTATED;
    
    public BlockTFDiagonal(final Material material) {
        super(material);
    }
    
    public BlockTFDiagonal(final Material material, final MapColor mapColor) {
        super(material, mapColor);
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFDiagonal.IS_ROTATED });
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFDiagonal.IS_ROTATED, (Comparable)(meta != 0));
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((boolean)state.func_177229_b((IProperty)BlockTFDiagonal.IS_ROTATED)) ? 1 : 0;
    }
    
    public IBlockState func_185499_a(final IBlockState state, final Rotation rot) {
        return (rot == Rotation.NONE || rot == Rotation.CLOCKWISE_180) ? state : state.func_177226_a((IProperty)BlockTFDiagonal.IS_ROTATED, (Comparable)!(boolean)state.func_177229_b((IProperty)BlockTFDiagonal.IS_ROTATED));
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirrorIn) {
        return (mirrorIn == Mirror.NONE) ? state : state.func_177226_a((IProperty)BlockTFDiagonal.IS_ROTATED, (Comparable)!(boolean)state.func_177229_b((IProperty)BlockTFDiagonal.IS_ROTATED));
    }
    
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFDiagonal.IS_ROTATED, (Comparable)(EnumFacing.func_176731_b(MathHelper.func_76141_d(placer.field_70177_z * 4.0f / 360.0f) & 0x1) == EnumFacing.WEST));
    }
    
    static {
        IS_ROTATED = PropertyBool.func_177716_a("is_rotated");
    }
}
