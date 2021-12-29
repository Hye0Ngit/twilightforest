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
import net.minecraft.block.material.Material;
import twilightforest.enums.DeadrockVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFDeadrock extends Block implements ModelRegisterCallback
{
    public static final IProperty<DeadrockVariant> VARIANT;
    
    protected BlockTFDeadrock() {
        super(Material.field_151576_e);
        this.func_149711_c(100.0f);
        this.func_149752_b(6000000.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149649_H();
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFDeadrock.VARIANT, (Comparable)DeadrockVariant.SURFACE));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFDeadrock.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((DeadrockVariant)state.func_177229_b((IProperty)BlockTFDeadrock.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFDeadrock.VARIANT, (Comparable)DeadrockVariant.values()[meta]);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (final DeadrockVariant variant : DeadrockVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variant.ordinal()));
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFDeadrock.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)DeadrockVariant.class);
    }
}
