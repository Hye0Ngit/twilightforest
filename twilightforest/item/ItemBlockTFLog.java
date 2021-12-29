// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;

public class ItemBlockTFLog extends xh
{
    public static final String[] woodNames;
    
    public ItemBlockTFLog(final int i) {
        super(i);
        this.a(true);
        this.e(0);
    }
    
    public lx a_(final int par1) {
        return TFBlocks.log.a(2, par1);
    }
    
    public String d(final wg itemstack) {
        int meta = itemstack.k();
        if ((meta & 0x8) == 0x0) {
            final int i = kx.a(meta, 0, 7);
            return super.a() + "." + ItemBlockTFLog.woodNames[i];
        }
        meta &= 0x7;
        final int i = kx.a(meta, 0, 7);
        return super.a() + "." + ItemBlockTFLog.woodNames[i] + ".log";
    }
    
    public int a(final int i) {
        return i;
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove", "darkwood", "x", "root", "oreroot", "rotten" };
    }
}
