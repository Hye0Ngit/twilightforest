// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockTFLeaves extends ItemBlock
{
    public ItemBlockTFLeaves(final Block par1) {
        super(par1);
        this.func_77627_a(true);
        this.func_77656_e(0);
    }
    
    public IIcon func_77617_a(final int par1) {
        return TFBlocks.leaves.func_149691_a(2, par1);
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        final int meta = itemstack.func_77960_j();
        return super.func_77658_a() + "." + meta;
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
}
