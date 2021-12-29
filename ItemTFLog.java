// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFLog extends cq
{
    public static final String[] woodNames;
    
    public ItemTFLog(final int i) {
        super(i);
        this.a(true);
        this.f(0);
    }
    
    public int a(final int i) {
        return i;
    }
    
    public String a(final jm itemstack) {
        final int i = iy.a(itemstack.h(), 0, 2);
        return super.b() + "." + ItemTFLog.woodNames[i];
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove" };
    }
}
