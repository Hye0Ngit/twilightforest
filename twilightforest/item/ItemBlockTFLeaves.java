// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;

public class ItemBlockTFLeaves extends xh
{
    public ItemBlockTFLeaves(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
    }
    
    public lx a_(final int par1) {
        return TFBlocks.leaves.a(2, par1);
    }
    
    public String d(final wg itemstack) {
        final int meta = itemstack.k();
        return super.a() + "." + meta;
    }
    
    public int a(final int i) {
        return i;
    }
}
