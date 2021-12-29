// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.util.IIcon;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;

public class BlockTFLeaves3 extends BlockLeaves
{
    public static final String[] names;
    
    protected BlockTFLeaves3() {
        this.func_149672_a(Block.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String[] func_150125_e() {
        return BlockTFLeaves3.names;
    }
    
    public int func_149692_a(final int p_149692_1_) {
        return super.func_149692_a(p_149692_1_) + 4;
    }
    
    public boolean func_149662_c() {
        return Blocks.field_150362_t.func_149662_c();
    }
    
    public int func_149643_k(final World world, final int x, final int y, final int z) {
        return world.func_72805_g(x, y, z) & 0x3;
    }
    
    public int func_149745_a(final Random rand) {
        return 0;
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return null;
    }
    
    public IIcon func_149691_a(final int i, final int j) {
        return Blocks.field_150362_t.func_149691_a(i, j & 0x3);
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (int i = 0; i < BlockTFLeaves3.names.length; ++i) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    static {
        names = new String[] { "thorn" };
    }
}
