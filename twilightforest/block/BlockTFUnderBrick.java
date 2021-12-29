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
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.UnderBrickVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFUnderBrick extends Block implements ModelRegisterCallback
{
    public static final IProperty<UnderBrickVariant> VARIANT;
    
    public BlockTFUnderBrick() {
        super(Material.field_151576_e, MapColor.field_151663_o);
        this.func_149711_c(1.5f);
        this.func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.NORMAL));
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFUnderBrick.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((UnderBrickVariant)state.func_177229_b((IProperty)BlockTFUnderBrick.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.values()[meta]);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (final UnderBrickVariant variant : UnderBrickVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variant.ordinal()));
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFUnderBrick.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)UnderBrickVariant.class);
    }
}
