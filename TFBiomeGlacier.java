import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final int i) {
        super(i);
        this.B.z = 1;
        this.B.B = 0;
        this.y = 0.0f;
        this.z = 0.1f;
        ((TFBiomeDecorator)this.B).canopyPerChunk = -999;
    }
    
    @Override
    public ig a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (ig)new us();
        }
        return (ig)new ty(true);
    }
    
    public boolean b() {
        return true;
    }
    
    public boolean c() {
        return false;
    }
}
