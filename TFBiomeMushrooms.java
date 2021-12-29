import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeMushrooms extends TFBiomeBase
{
    public TFBiomeMushrooms(final int i) {
        super(i);
        this.z = 0.8f;
        this.B.D = 16;
    }
    
    @Override
    public ig a(final Random random) {
        if (random.nextInt(7) == 0) {
            return (ig)this.bigMushroomGen;
        }
        if (random.nextInt(5) == 0) {
            return (ig)this.I;
        }
        return (ig)this.G;
    }
}
