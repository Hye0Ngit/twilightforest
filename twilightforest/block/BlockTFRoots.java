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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import twilightforest.enums.RootVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFRoots extends Block implements ModelRegisterCallback
{
    public static final IProperty<RootVariant> VARIANT;
    
    public BlockTFRoots() {
        super(Material.field_151575_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149672_a(SoundType.field_185848_a);
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFRoots.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((RootVariant)state.func_177229_b((IProperty)BlockTFRoots.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFRoots.VARIANT, (Comparable)RootVariant.values()[meta]);
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int j) {
        switch ((RootVariant)state.func_177229_b((IProperty)BlockTFRoots.VARIANT)) {
            default: {
                return Items.field_151055_y;
            }
            case LIVEROOT: {
                return TFItems.liveroot;
            }
        }
    }
    
    public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
        if (state.func_177229_b((IProperty)BlockTFRoots.VARIANT) == RootVariant.ROOT) {
            return 3 + random.nextInt(2);
        }
        return super.quantityDropped(state, fortune, random);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFRoots.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)RootVariant.class);
    }
}
