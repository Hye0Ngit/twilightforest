// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.World;
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

public class BlockTFAuroraBrick extends Block
{
    private static IIcon[] icons;
    
    public BlockTFAuroraBrick() {
        super(Material.field_151598_x);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        (BlockTFAuroraBrick.icons = new IIcon[8])[0] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick0");
        BlockTFAuroraBrick.icons[1] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick1");
        BlockTFAuroraBrick.icons[2] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick2");
        BlockTFAuroraBrick.icons[3] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick3");
        BlockTFAuroraBrick.icons[4] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick4");
        BlockTFAuroraBrick.icons[5] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick5");
        BlockTFAuroraBrick.icons[6] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick6");
        BlockTFAuroraBrick.icons[7] = par1IconRegister.func_94245_a("TwilightForest:aurorabrick7");
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        if (meta < 8) {
            return BlockTFAuroraBrick.icons[meta];
        }
        return BlockTFAuroraBrick.icons[15 - meta];
    }
    
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        int red = 0;
        int green = 0;
        int blue = 0;
        red = 16;
        blue = x * 12 + z * 6;
        if ((blue & 0x100) != 0x0) {
            blue = 255 - (blue & 0xFF);
        }
        blue ^= 0xFF;
        blue &= 0xFF;
        green = x * 4 + z * 8;
        if ((green & 0x100) != 0x0) {
            green = 255 - (green & 0xFF);
        }
        green &= 0xFF;
        if (green + blue < 128) {
            green = 128 - blue;
        }
        return red << 16 | blue << 8 | green;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149635_D() {
        return this.func_149720_d(null, 16, 0, 16);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149741_i(final int meta) {
        return this.func_149635_D();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    public int func_149692_a(final int meta) {
        return 0;
    }
    
    public int func_149660_a(final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ, final int meta) {
        return Math.abs(x + z) % 16;
    }
    
    public void func_149726_b(final World world, final int x, final int y, final int z) {
        world.func_72921_c(x, y, z, Math.abs(x + z) % 16, 2);
    }
}
