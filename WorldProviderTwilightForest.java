// 
// Decompiled by Procyon v0.6-prerelease
// 

public class WorldProviderTwilightForest extends xk
{
    public void a() {
        this.c = new TFWorldChunkManager(this.a);
        this.h = 7;
        this.a.e = this.a.c / 4 - 1;
        System.out.println("Setting lower ocean height for twilight forest");
    }
    
    @Override
    public cr b() {
        return (cr)new ChunkProviderTwilightForest(this.a, this.a.m(), this.a.r().o());
    }
    
    @Override
    public boolean a(final int i, final int j) {
        final int k = this.a.a(i, j);
        return k != 0 && ud.m[k].cb.c();
    }
    
    @Override
    public bz d() {
        return new bz(100, 50, 0);
    }
}
