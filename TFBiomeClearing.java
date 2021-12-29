import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeClearing extends TFBiomeBase
{
    public TFBiomeClearing(final int i) {
        super(i);
        this.F = 0.8f;
        this.G = 0.4f;
        this.D = 0.01f;
        this.E = 0.0f;
        ((TFBiomeDecorator)this.I).canopyPerChunk = -999;
        this.I.z = -999;
        this.I.A = 4;
        this.I.B = 10;
    }
    
    @Override
    public qt func_48410_b(final Random par1Random) {
        return (qt)new az(vz.X.bO, 1);
    }
}
