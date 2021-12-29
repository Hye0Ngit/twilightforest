// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockHorizontal;

public class BlockTFHorizontal extends BlockHorizontal implements ModelRegisterCallback
{
    protected BlockTFHorizontal(final Material material) {
        super(material);
    }
    
    protected BlockTFHorizontal(final Material material, final MapColor mapColor) {
        super(material, mapColor);
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFHorizontal.field_185512_D });
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFHorizontal.field_185512_D, (Comparable)EnumFacing.func_176731_b(meta));
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((EnumFacing)state.func_177229_b((IProperty)BlockTFHorizontal.field_185512_D)).func_176736_b();
    }
    
    public IBlockState func_185499_a(final IBlockState state, final Rotation rot) {
        return state.func_177226_a((IProperty)BlockTFHorizontal.field_185512_D, (Comparable)rot.func_185831_a((EnumFacing)state.func_177229_b((IProperty)BlockTFHorizontal.field_185512_D)));
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirrorIn) {
        return state.func_185907_a(mirrorIn.func_185800_a((EnumFacing)state.func_177229_b((IProperty)BlockTFHorizontal.field_185512_D)));
    }
    
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFHorizontal.field_185512_D, (Comparable)placer.func_174811_aO().func_176734_d());
    }
}
