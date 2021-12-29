// 
// Decompiled by Procyon v0.6-prerelease
// 

public class WorldProviderTwilightForest extends k
{
    @Override
    public float[] a(final float celestialAngle, final float f1) {
        return super.a(celestialAngle, f1);
    }
    
    @Override
    public fb b(final float f, final float f1) {
        float bright = me.b(1.5707965f) * 2.0f + 0.5f;
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
        return fb.b((double)red, (double)green, (double)blue);
    }
    
    public void b() {
        this.b = new TFWorldChunkManager(this.a);
        this.g = 7;
    }
    
    @Override
    public ej c() {
        return (ej)new ChunkProviderTwilightForest(this.a, this.a.t(), this.a.z().r());
    }
    
    @Override
    public boolean f() {
        return false;
    }
    
    @Override
    public boolean a(final int i, final int j) {
        final int k = this.a.a(i, j);
        return k != 0 && yy.k[k].bZ.d();
    }
}
