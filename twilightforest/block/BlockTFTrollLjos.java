// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTFTrollLjos extends Block
{
    protected BlockTFTrollLjos() {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149715_a(1.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = Blocks.field_150374_bv.func_149691_a(0, 0);
    }
}
