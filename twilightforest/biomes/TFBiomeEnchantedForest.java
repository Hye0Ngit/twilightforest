// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.world.TFWorld;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFGenLargeRainboak;
import twilightforest.world.TFGenSmallRainboak;
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
    
    @Override
    public int k() {
        return (abu.a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    @Override
    public int l() {
        return (abu.a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    @Override
    public afd a(final Random random) {
        if (random.nextInt(15) == 0) {
            return new TFGenSmallRainboak();
        }
        if (random.nextInt(50) == 0) {
            return new TFGenLargeRainboak();
        }
        if (random.nextInt(5) == 0) {
            return (afd)this.Q;
        }
        if (random.nextInt(10) == 0) {
            return (afd)new aev(false);
        }
        return (afd)this.O;
    }
    
    @Override
    public afd b(final Random par1Random) {
        if (par1Random.nextInt(3) > 0) {
            return (afd)new afy(aqw.ac.cF, 2);
        }
        if (par1Random.nextInt(3) == 0) {
            return (afd)new afy(TFBlocks.plant.cF, 8);
        }
        return (afd)new afy(aqw.ac.cF, 1);
    }
    
    public void a(final abv par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final aga worldgenvines = new aga();
        for (int i = 0; i < 20; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
        }
    }
}
