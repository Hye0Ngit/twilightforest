// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class WorldProviderTwilightForest extends alb
{
    public float[] a(final float celestialAngle, final float f1) {
        return super.a(celestialAngle, f1);
    }
    
    public bo b(final float f, final float f1) {
        float bright = gk.b(1.5707965f) * 2.0f + 0.5f;
        if (bright < 0.0f) {
            bright = 0.0f;
        }
        if (bright > 1.0f) {
            bright = 1.0f;
        }
        float red = 0.7529412f;
        float green = 1.0f;
        float blue = 0.8470588f;
        red *= bright * 0.94f + 0.06f;
        green *= bright * 0.94f + 0.06f;
        blue *= bright * 0.91f + 0.09f;
        return bo.b((double)red, (double)green, (double)blue);
    }
    
    public void a() {
        this.c = new TFWorldChunkManager(this.a);
        this.g = 7;
    }
    
    public ca b() {
        return (ca)new ChunkProviderTwilightForest(this.a, this.a.v(), this.a.B().r());
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean a(final int i, final int j) {
        final int k = this.a.b(i, j);
        return k != 0 && pb.m[k].cd.a();
    }
    
    public boolean d() {
        return true;
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
