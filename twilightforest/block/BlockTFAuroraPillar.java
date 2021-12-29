// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockRotatedPillar;

public class BlockTFAuroraPillar extends BlockRotatedPillar
{
    private IIcon sideIcon;
    private IIcon topIcon;
    
    protected BlockTFAuroraPillar() {
        super(Material.field_151598_x);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
    }
    
    public int func_149720_d(final IBlockAccess world, final int x, final int y, final int z) {
        int red = 0;
        int green = 0;
        int blue = 0;
        final int normalColor = TFBlocks.auroraBrick.func_149720_d(world, x, y, z);
        red = (normalColor >> 16 & 0xFF);
        blue = (normalColor & 0xFF);
        green = (normalColor >> 8 & 0xFF);
        final float[] hsb = Color.RGBtoHSB(red, blue, green, null);
        return Color.HSBtoRGB(hsb[0], hsb[1] * 0.5f, Math.min(hsb[2] + 0.4f, 0.9f));
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
    protected IIcon func_150163_b(final int meta) {
        return this.sideIcon;
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150161_d(final int p_150161_1_) {
        return this.topIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.sideIcon = Blocks.field_150371_ca.func_149691_a(2, 2);
        this.topIcon = Blocks.field_150371_ca.func_149691_a(1, 2);
    }
}
