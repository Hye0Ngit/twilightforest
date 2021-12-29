// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFAuroraBrick extends Block
{
    private static Icon iconSide;
    private static Icon iconBottom;
    
    public BlockTFAuroraBrick(final int par1) {
        super(par1, Material.field_76260_u);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFAuroraBrick.iconSide = Block.field_94339_ct.func_71851_a(1);
        BlockTFAuroraBrick.iconBottom = Block.field_94339_ct.func_71851_a(0);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        if (side == 0) {
            return BlockTFAuroraBrick.iconBottom;
        }
        return BlockTFAuroraBrick.iconSide;
    }
    
    public int func_71920_b(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        int red = 0;
        int green = 0;
        int blue = 0;
        red = 16;
        blue = x * 12 + z * 6;
        if ((blue & 0x100) != 0x0) {
            blue = 255 - (blue & 0xFF);
        }
        blue ^= 0xFF;
        green = x * 4 + z * 8;
        if ((green & 0x100) != 0x0) {
            green = 255 - (green & 0xFF);
        }
        if (green + blue < 128) {
            green *= 4;
        }
        green &= 0xFF;
        return red << 16 | blue << 8 | green;
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    public int func_71899_b(final int meta) {
        return meta;
    }
}
