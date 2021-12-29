// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFLog extends dd
{
    public static final String[] woodNames;
    
    public ItemTFLog(final int i) {
        super(i);
        this.a(true);
        this.f(0);
    }
    
    public String a(final kp itemstack) {
        int meta = itemstack.h();
        if ((meta & 0x8) == 0x0) {
            final int i = kb.a(meta, 0, 2);
            return super.b() + "." + ItemTFLog.woodNames[i];
        }
        meta &= 0x7;
        final int i = kb.a(meta, 0, 2);
        return super.b() + "." + ItemTFLog.woodNames[i] + ".log";
    }
    
    public int a(final int i) {
        return i;
    }
    
    static {
        woodNames = new String[] { "oak", "canopy", "mangrove" };
    }
}
