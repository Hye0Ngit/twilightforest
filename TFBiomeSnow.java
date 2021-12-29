import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeSnow extends TFBiomeBase
{
    public TFBiomeSnow(final int i) {
        super(i);
        this.B.z = 7;
        this.B.B = 1;
        this.y = 0.125f;
        this.z = 0.9f;
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
