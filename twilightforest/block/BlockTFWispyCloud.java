// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockBreakable;

public class BlockTFWispyCloud extends BlockBreakable
{
    protected BlockTFWispyCloud() {
        super("", Material.field_151596_z, false);
        this.func_149672_a(BlockTFWispyCloud.field_149775_l);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = Blocks.field_150399_cn.func_149691_a(0, 0);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149701_w() {
        return 1;
    }
    
    protected boolean func_149700_E() {
        return true;
    }
    
    public int func_149745_a(final Random p_149745_1_) {
        return 0;
    }
    
    public boolean func_149686_d() {
        return false;
    }
}
