// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final int i) {
        super(i);
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setGrassPerChunk(0);
        this.F = 0.0f;
        this.G = 0.1f;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.K.add(new bg((Class)EntityTFPenguin.class, 10, 4, 4));
    }
    
    @Override
    public li a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (li)new lo();
        }
        return (li)new rb(true);
    }
    
    public boolean c() {
        return true;
    }
    
    public boolean d() {
        return false;
    }
    
    public void a(final xd par1World, final Random par2Random, final int par3, final int par4) {
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
