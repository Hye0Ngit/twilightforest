// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFBiomeEnchantedForest extends TFBiomeBase
{
    Random colorRNG;
    
    public TFBiomeEnchantedForest(final int i) {
        super(i);
        this.colorRNG = new Random();
        this.getTFBiomeDecorator().setGrassPerChunk(15);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    public int k() {
        return (zv.a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    public int l() {
        return (zv.a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    @Override
    public li b(final Random par1Random) {
        if (par1Random.nextInt(3) > 0) {
            return (li)new to(pb.X.bO, 2);
        }
        if (par1Random.nextInt(3) == 0) {
            return (li)new to(TFBlocks.plant.bO, 8);
        }
        return (li)new to(pb.X.bO, 1);
    }
    
    public void a(final xd par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final od worldgenvines = new od();
        for (int i = 0; i < 20; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
        }
    }
}
