// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFLog extends uz
{
    public static final String[] woodNames;
    
    public ItemTFLog(final int i) {
        super(i);
        this.a(true);
        this.g(0);
    }
    
    public int b(final int i) {
        final int j = gh.a(i, 0, 15);
        return TFBlocks.wood.a(2, j);
    }
    
    public String a(final aai itemstack) {
        final int i = gh.a(itemstack.i(), 0, 2);
        return super.e() + "." + ItemTFLog.woodNames[i];
    }
    
    public int a(final int i) {
        return i;
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove" };
    }
}
