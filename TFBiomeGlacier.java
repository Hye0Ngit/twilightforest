import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final int i) {
        super(i);
        this.G.z = 1;
        this.G.B = 0;
        this.D = 0.0f;
        this.E = 0.1f;
        ((TFBiomeDecorator)this.G).canopyPerChunk = -999;
    }
    
    @Override
    public pg a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (pg)new pp();
        }
        return (pg)new xb(true);
    }
    
    public boolean b() {
        return true;
    }
    
    public boolean c() {
        return false;
    }
}
