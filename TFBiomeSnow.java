import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeSnow extends TFBiomeBase
{
    public TFBiomeSnow(final int i) {
        super(i);
        this.I.z = 7;
        this.I.B = 1;
        this.F = 0.125f;
        this.G = 0.9f;
        ((TFBiomeDecorator)this.I).canopyPerChunk = -999;
    }
    
    @Override
    public lf a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (lf)new ll();
        }
        return (lf)new qx(true);
    }
    
    public boolean b() {
        return true;
    }
    
    public boolean c() {
        return false;
    }
}
