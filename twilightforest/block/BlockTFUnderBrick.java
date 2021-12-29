// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFUnderBrick extends Block
{
    private static IIcon[] iconSide;
    
    public BlockTFUnderBrick() {
        super(Material.field_151576_e);
        this.func_149711_c(1.5f);
        this.func_149752_b(10.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFUnderBrick.iconSide[0] = par1IconRegister.func_94245_a("TwilightForest:knightbrick");
        BlockTFUnderBrick.iconSide[1] = par1IconRegister.func_94245_a("TwilightForest:knightbrick_mossy");
        BlockTFUnderBrick.iconSide[2] = par1IconRegister.func_94245_a("TwilightForest:knightbrick_cracked");
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        if (meta < BlockTFUnderBrick.iconSide.length) {
            if (side == 0 || side == 1) {
                return BlockTFUnderBrick.iconSide[meta];
            }
            return BlockTFUnderBrick.iconSide[meta];
        }
        else {
            if (side == 0 || side == 1) {
                return BlockTFUnderBrick.iconSide[0];
            }
            return BlockTFUnderBrick.iconSide[0];
        }
    }
    
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        return 16777215;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
    }
    
    public int func_149692_a(final int meta) {
        return meta;
    }
    
    static {
        BlockTFUnderBrick.iconSide = new IIcon[4];
    }
}
