// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.MathHelper;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.util.Icon;
import net.minecraft.item.ItemBlock;

public class ItemBlockTFLog extends ItemBlock
{
    public static final String[] woodNames;
    
    public ItemBlockTFLog(final int i) {
        super(i);
        this.func_77627_a(true);
        this.func_77656_e(0);
    }
    
    public Icon func_77617_a(final int par1) {
        return TFBlocks.log.func_71858_a(2, par1);
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        int meta = itemstack.func_77960_j();
        if ((meta & 0x8) == 0x0) {
            final int i = MathHelper.func_76125_a(meta, 0, 7);
            return super.func_77658_a() + "." + ItemBlockTFLog.woodNames[i];
        }
        meta &= 0x7;
        final int i = MathHelper.func_76125_a(meta, 0, 7);
        return super.func_77658_a() + "." + ItemBlockTFLog.woodNames[i] + ".log";
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove", "darkwood", "x", "root", "oreroot", "rotten" };
    }
}
