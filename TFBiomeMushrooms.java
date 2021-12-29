import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeMushrooms extends TFBiomeBase
{
    public TFBiomeMushrooms(final int i) {
        super(i);
        this.E = 0.8f;
        this.G.D = 16;
    }
    
    @Override
    public pg a(final Random random) {
        if (random.nextInt(7) == 0) {
            return (pg)this.bigMushroomGen;
        }
        if (random.nextInt(5) == 0) {
            return (pg)this.N;
        }
        return (pg)this.L;
    }
}
