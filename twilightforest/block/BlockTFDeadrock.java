// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFDeadrock extends Block
{
    public static final String[] names;
    private IIcon[] icons;
    
    protected BlockTFDeadrock() {
        super(Material.field_151576_e);
        this.func_149722_s();
        this.func_149752_b(6000000.0f);
        this.func_149672_a(BlockTFDeadrock.field_149780_i);
        this.func_149649_H();
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.icons = new IIcon[BlockTFDeadrock.names.length];
        for (int i = 0; i < BlockTFDeadrock.names.length; ++i) {
            this.icons[i] = iconRegister.func_94245_a("TwilightForest:deadrock_" + BlockTFDeadrock.names[i]);
        }
    }
    
    public IIcon func_149691_a(final int side, int meta) {
        if (meta > BlockTFDeadrock.names.length) {
            meta = 0;
        }
        return this.icons[meta];
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int i = 0; i < BlockTFDeadrock.names.length; ++i) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    static {
        names = new String[] { "surface", "cracked", "solid" };
    }
}
