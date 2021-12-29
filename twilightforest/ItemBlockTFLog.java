// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemBlockTFLog extends vd
{
    public static final String[] woodNames;
    
    public ItemBlockTFLog(final int i) {
        super(i);
        this.a(true);
        this.g(0);
    }
    
    public int b(final int i) {
        final int j = gk.a(i, 0, 15);
        return TFBlocks.wood.a(2, j);
    }
    
    public String a(final aan itemstack) {
        int meta = itemstack.i();
        if ((meta & 0x8) == 0x0) {
            final int i = gk.a(meta, 0, 7);
            return super.e() + "." + ItemBlockTFLog.woodNames[i];
        }
        meta &= 0x7;
        final int i = gk.a(meta, 0, 7);
        return super.e() + "." + ItemBlockTFLog.woodNames[i] + ".log";
    }
    
    public int a(final int i) {
        return i;
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove", "darkwood", "x", "root", "oreroot", "rotten" };
    }
}
