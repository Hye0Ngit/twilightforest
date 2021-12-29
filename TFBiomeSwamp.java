import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeSwamp extends TFBiomeBase
{
    public TFBiomeSwamp(final int i) {
        super(i);
        this.D = -0.25f;
        this.E = 0.0f;
        this.F = 0.8f;
        this.G = 0.9f;
        this.I.C = 1;
        this.I.D = 8;
        this.I.E = 10;
        this.I.I = 1;
        this.I.z = 2;
        this.I.y = 6;
        this.H = 14745518;
        ((TFBiomeDecorator)this.I).canopyPerChunk = -999;
        ((TFBiomeDecorator)this.I).lakesPerChunk = 2;
        ((TFBiomeDecorator)this.I).mangrovesPerChunk = 3;
    }
    
    @Override
    public qt a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (qt)new sj(3, 0);
        }
        return (qt)this.Q;
    }
    
    public void a(final ge par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final uo worldgenvines = new uo();
        for (int i = 0; i < 50; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
        }
    }
}
