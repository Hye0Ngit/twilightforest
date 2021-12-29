// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockNagastone extends ItemBlock
{
    public ItemBlockNagastone(final Block block) {
        super(block);
        this.func_77627_a(true);
        this.func_77656_e(0);
    }
    
    public IIcon func_77617_a(final int i) {
        final int j = MathHelper.func_76125_a(i, 0, 15);
        return TFBlocks.nagastone.func_149691_a(2, j);
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        final int meta = itemstack.func_77960_j();
        return super.func_77658_a() + "." + meta;
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
}
