import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeHighlands extends TFBiomeBase
{
    public TFBiomeHighlands(final int i) {
        super(i);
        this.D = 1.0f;
        this.E = 2.0f;
        this.F = 0.5f;
        this.G = 0.3f;
        ((TFBiomeDecorator)this.I).canopyPerChunk = -999;
    }
    
    @Override
    public lf a(final Random random) {
        if (random.nextInt(4) == 0) {
            return (lf)this.O;
        }
        if (random.nextInt(10) == 0) {
            return (lf)new qx(true);
        }
        return (lf)this.P;
    }
}
