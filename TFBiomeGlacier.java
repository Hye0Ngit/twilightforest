import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final int i) {
        super(i);
        this.I.z = 1;
        this.I.B = 0;
        this.F = 0.0f;
        this.G = 0.1f;
        ((TFBiomeDecorator)this.I).canopyPerChunk = -999;
        this.K.add(new bw((Class)EntityTFPenguin.class, 10, 4, 4));
    }
    
    @Override
    public qt a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (qt)new re();
        }
        return (qt)new za(true);
    }
    
    public boolean c() {
        return true;
    }
    
    public boolean d() {
        return false;
    }
    
    public void a(final ge par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final TFGenPenguins penguins = new TFGenPenguins();
        if (par2Random.nextInt(4) == 0) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            penguins.a(par1World, par2Random, j, byte0, k);
        }
    }
}
