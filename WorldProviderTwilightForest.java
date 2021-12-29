// 
// Decompiled by Procyon v0.6-prerelease
// 

public class WorldProviderTwilightForest extends zl
{
    public WorldProviderTwilightForest() {
        this.g = 7;
    }
    
    public void a() {
        this.c = new TFWorldChunkManager(this.a);
        this.g = 7;
    }
    
    public df b() {
        return (df)new ChunkProviderTwilightForest(this.a, this.a.n(), this.a.s().n());
    }
    
    public boolean a(final int i, final int j) {
        final int k = this.a.b(i, j);
        return k != 0 && vz.m[k].cd.a();
    }
    
    public String getSaveFolder() {
        return "DIM7";
    }
    
    public String getWelcomeMessage() {
        return "Entering the Twilight Forest";
    }
    
    public String getDepartMessage() {
        return "Leaving the Twilight Forest";
    }
}
