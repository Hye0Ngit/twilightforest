// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFBiomeSwamp extends TFBiomeBase
{
    public TFBiomeSwamp(final int i) {
        super(i);
        this.D = -0.25f;
        this.E = 0.0f;
        this.F = 0.8f;
        this.G = 0.9f;
        this.getTFBiomeDecorator().setDeadBushPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(10);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(2);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(6);
        this.H = 14745518;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.getTFBiomeDecorator().lakesPerChunk = 2;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
    }
    
    @Override
    public li a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (li)new agm(3, 0);
        }
        return (li)this.Q;
    }
    
    public void a(final xd par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final od worldgenvines = new od();
        for (int i = 0; i < 50; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
        }
    }
    
    public int k() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((zv.a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public int l() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((gu.a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
}
