// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;

public class ItemBlockTFLog extends vq
{
    public static final String[] woodNames;
    
    public ItemBlockTFLog(final int i) {
        super(i);
        this.a(true);
        this.e(0);
    }
    
    public int b(final int i) {
        final int j = ke.a(i, 0, 15);
        return TFBlocks.log.a(2, j);
    }
    
    public String d(final ur itemstack) {
        int meta = itemstack.j();
        if ((meta & 0x8) == 0x0) {
            final int i = ke.a(meta, 0, 7);
            return super.a() + "." + ItemBlockTFLog.woodNames[i];
        }
        meta &= 0x7;
        final int i = ke.a(meta, 0, 7);
        return super.a() + "." + ItemBlockTFLog.woodNames[i] + ".log";
    }
    
    public int a(final int i) {
        return i;
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove", "darkwood", "x", "root", "oreroot", "rotten" };
    }
}
