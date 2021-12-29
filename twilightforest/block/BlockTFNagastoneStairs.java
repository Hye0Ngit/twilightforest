// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockStairs;

public class BlockTFNagastoneStairs extends BlockStairs implements ModelRegisterCallback
{
    public static final IProperty<LeftRight> DIRECTION;
    
    BlockTFNagastoneStairs(final IBlockState state) {
        super(state);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.func_176223_P().func_177226_a((IProperty)BlockTFNagastoneStairs.DIRECTION, (Comparable)LeftRight.LEFT));
        this.field_149783_u = true;
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFNagastoneStairs.field_176309_a, (IProperty)BlockTFNagastoneStairs.field_176308_b, (IProperty)BlockTFNagastoneStairs.field_176310_M, BlockTFNagastoneStairs.DIRECTION });
    }
    
    public int func_176201_c(final IBlockState state) {
        return super.func_176201_c(state) + ((state.func_177229_b((IProperty)BlockTFNagastoneStairs.DIRECTION) == LeftRight.RIGHT) ? 8 : 0);
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return super.func_176203_a(meta & 0x7).func_177226_a((IProperty)BlockTFNagastoneStairs.DIRECTION, (Comparable)(((meta & 0x8) == 0x8) ? LeftRight.RIGHT : LeftRight.LEFT));
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 8));
    }
    
    public int func_180651_a(final IBlockState state) {
        return (state.func_177229_b((IProperty)BlockTFNagastoneStairs.DIRECTION) == LeftRight.RIGHT) ? 8 : 0;
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirrorIn) {
        return super.func_185471_a(state, mirrorIn).func_177226_a((IProperty)BlockTFNagastoneStairs.DIRECTION, (Comparable)((state.func_177229_b((IProperty)BlockTFNagastoneStairs.DIRECTION) == LeftRight.LEFT) ? LeftRight.RIGHT : LeftRight.LEFT));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToState((Block)this, 0, this.func_176223_P().func_177226_a((IProperty)BlockTFNagastoneStairs.field_176309_a, (Comparable)EnumFacing.EAST));
        ModelUtils.registerToState((Block)this, 8, this.func_176223_P().func_177226_a((IProperty)BlockTFNagastoneStairs.field_176309_a, (Comparable)EnumFacing.EAST).func_177226_a((IProperty)BlockTFNagastoneStairs.DIRECTION, (Comparable)LeftRight.RIGHT));
    }
    
    static {
        DIRECTION = (IProperty)PropertyEnum.func_177709_a("direction", (Class)LeftRight.class);
    }
    
    private enum LeftRight implements IStringSerializable
    {
        LEFT, 
        RIGHT;
        
        public String func_176610_l() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}
