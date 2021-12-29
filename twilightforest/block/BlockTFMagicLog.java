// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.enums.MagicWoodVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLog;

public class BlockTFMagicLog extends BlockLog implements ModelRegisterCallback
{
    public static final IProperty<MagicWoodVariant> VARIANT;
    
    protected BlockTFMagicLog() {
        this.func_149711_c(2.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.TIME).func_177226_a((IProperty)BlockTFMagicLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFMagicLog.VARIANT, (IProperty)BlockTFMagicLog.field_176299_a });
    }
    
    public IBlockState func_176203_a(final int meta) {
        IBlockState iblockstate = this.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.values()[meta & 0x3]);
        switch (meta & 0xC) {
            case 0: {
                iblockstate = iblockstate.func_177226_a((IProperty)BlockTFMagicLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y);
                break;
            }
            case 4: {
                iblockstate = iblockstate.func_177226_a((IProperty)BlockTFMagicLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
                break;
            }
            case 8: {
                iblockstate = iblockstate.func_177226_a((IProperty)BlockTFMagicLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
                break;
            }
            default: {
                iblockstate = iblockstate.func_177226_a((IProperty)BlockTFMagicLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
                break;
            }
        }
        return iblockstate;
    }
    
    public int func_176201_c(final IBlockState state) {
        int i = ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLog.VARIANT)).ordinal();
        switch ((BlockLog.EnumAxis)state.func_177229_b((IProperty)BlockTFMagicLog.field_176299_a)) {
            case X: {
                i |= 0x4;
                break;
            }
            case Y: {
                i |= 0x0;
                break;
            }
            case Z: {
                i |= 0x8;
                break;
            }
            case NONE: {
                i |= 0xC;
                break;
            }
        }
        return i;
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLog.VARIANT)).supplyMapColor();
    }
    
    protected boolean func_149700_E() {
        return false;
    }
    
    public int func_180651_a(final IBlockState state) {
        return ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLog.VARIANT)).ordinal();
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant((Block)this, BlockTFMagicLog.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)MagicWoodVariant.class);
    }
}
