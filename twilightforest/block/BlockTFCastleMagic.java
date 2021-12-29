// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Collection;
import net.minecraft.block.properties.PropertyEnum;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.EnumDyeColor;
import java.util.List;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFCastleMagic extends Block implements ModelRegisterCallback
{
    public static final List<EnumDyeColor> VALID_COLORS;
    public static final IProperty<EnumDyeColor> COLOR;
    
    public BlockTFCastleMagic() {
        super(Material.field_151576_e, MapColor.field_151677_p);
        this.func_149711_c(100.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)EnumDyeColor.PINK));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFCastleMagic.COLOR });
    }
    
    public int func_176201_c(final IBlockState state) {
        return BlockTFCastleMagic.VALID_COLORS.indexOf(state.func_177229_b((IProperty)BlockTFCastleMagic.COLOR));
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)BlockTFCastleMagic.VALID_COLORS.get(meta));
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFCastleMagic.COLOR);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static {
        VALID_COLORS = (List)ImmutableList.of((Object)EnumDyeColor.PINK, (Object)EnumDyeColor.BLUE, (Object)EnumDyeColor.YELLOW, (Object)EnumDyeColor.PURPLE);
        COLOR = (IProperty)PropertyEnum.func_177707_a("color", (Class)EnumDyeColor.class, (Collection)BlockTFCastleMagic.VALID_COLORS);
    }
}
