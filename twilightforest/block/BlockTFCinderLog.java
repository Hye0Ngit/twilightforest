// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLog;

public class BlockTFCinderLog extends BlockLog implements ModelRegisterCallback
{
    protected BlockTFCinderLog() {
        this.func_149711_c(1.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFCinderLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFCinderLog.field_176299_a });
    }
    
    public int func_176201_c(final IBlockState state) {
        switch ((BlockLog.EnumAxis)state.func_177229_b((IProperty)BlockTFCinderLog.field_176299_a)) {
            case X: {
                return 4;
            }
            case Y: {
                return 0;
            }
            case Z: {
                return 8;
            }
            default: {
                return 12;
            }
        }
    }
    
    public IBlockState func_176203_a(final int meta) {
        switch (meta) {
            case 0: {
                return this.func_176223_P().func_177226_a((IProperty)BlockTFCinderLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y);
            }
            case 4: {
                return this.func_176223_P().func_177226_a((IProperty)BlockTFCinderLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
            }
            case 8: {
                return this.func_176223_P().func_177226_a((IProperty)BlockTFCinderLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
            }
            default: {
                return this.func_176223_P().func_177226_a((IProperty)BlockTFCinderLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
            }
        }
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return MapColor.field_151670_w;
    }
}
