// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFLog extends uw
{
    public static final String[] woodNames;
    
    public ItemTFLog(final int i) {
        super(i);
        this.a(true);
        this.i(0);
    }
    
    public int a(final int i) {
        final int j = me.a(i, 0, 15);
        return TFBlocks.wood.a(2, j);
    }
    
    public String a(final dk itemstack) {
        final int i = me.a(itemstack.i(), 0, 2);
        return super.d() + "." + ItemTFLog.woodNames[i];
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove" };
    }
}
