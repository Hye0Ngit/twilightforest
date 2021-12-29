import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeTwilightForestVariant extends TFBiomeBase
{
    public TFBiomeTwilightForestVariant(final int i) {
        super(i);
        this.F = 0.7f;
        this.G = 0.8f;
        this.D = 0.15f;
        this.E = 0.4f;
        this.I.z = 25;
        this.I.B = 15;
        this.I.A = 8;
    }
    
    @Override
    public qt a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (qt)new sj(3, 0);
        }
        if (random.nextInt(10) == 0) {
            return (qt)this.O;
        }
        return (qt)this.N;
    }
    
    @Override
    public qt func_48410_b(final Random par1Random) {
        if (par1Random.nextInt(4) != 0) {
            return (qt)new az(vz.X.bO, 2);
        }
        return (qt)new az(vz.X.bO, 1);
    }
}
