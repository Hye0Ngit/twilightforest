// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFRoots extends Block
{
    public static IIcon spRootSide;
    public static IIcon spOreRootSide;
    public static final int ROOT_META = 0;
    public static final int OREROOT_META = 1;
    
    public BlockTFRoots() {
        super(Material.field_151575_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149672_a(Block.field_149766_f);
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        if (meta == 1) {
            return BlockTFRoots.spOreRootSide;
        }
        return BlockTFRoots.spRootSide;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFRoots.spRootSide = par1IconRegister.func_94245_a("TwilightForest:rootblock");
        BlockTFRoots.spOreRootSide = par1IconRegister.func_94245_a("TwilightForest:oreroots");
    }
    
    public Item func_149650_a(final int meta, final Random random, final int j) {
        switch (meta) {
            case 0: {
                return Items.field_151055_y;
            }
            case 1: {
                return TFItems.liveRoot;
            }
            default: {
                return Item.func_150898_a((Block)this);
            }
        }
    }
    
    public int func_149692_a(final int meta) {
        switch (meta) {
            case 0: {
                return 0;
            }
            case 1: {
                return 0;
            }
            default: {
                return meta | 0x8;
            }
        }
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        switch (meta) {
            case 0: {
                return 3 + random.nextInt(2);
            }
            default: {
                return super.quantityDropped(meta, fortune, random);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
}
