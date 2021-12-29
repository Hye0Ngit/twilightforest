// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockDirectional;

public class BlockTFNagastoneEtched extends BlockDirectional implements ModelRegisterCallback
{
    protected BlockTFNagastoneEtched() {
        super(Material.field_151576_e);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFNagastoneEtched.field_176387_N, (Comparable)EnumFacing.DOWN));
    }
    
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFNagastoneEtched.field_176387_N, (Comparable)(placer.func_70093_af() ? facing.func_176734_d() : facing));
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFNagastoneEtched.field_176387_N, (Comparable)EnumFacing.values()[meta % EnumFacing.values().length]);
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((EnumFacing)state.func_177229_b((IProperty)BlockTFNagastoneEtched.field_176387_N)).ordinal();
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFNagastoneEtched.field_176387_N });
    }
    
    public IBlockState func_185499_a(final IBlockState state, final Rotation rot) {
        return state.func_177226_a((IProperty)BlockTFNagastoneEtched.field_176387_N, (Comparable)rot.func_185831_a((EnumFacing)state.func_177229_b((IProperty)BlockTFNagastoneEtched.field_176387_N)));
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirrorIn) {
        return state.func_177226_a((IProperty)BlockTFNagastoneEtched.field_176387_N, (Comparable)mirrorIn.func_185803_b((EnumFacing)state.func_177229_b((IProperty)BlockTFNagastoneEtched.field_176387_N)));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToState((Block)this, 0, this.func_176223_P());
    }
    
    protected ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack(Item.func_150898_a((Block)this));
    }
}
