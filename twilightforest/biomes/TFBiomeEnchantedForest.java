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
    
    public int k() {
        return (zu.a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    public int l() {
        return (zu.a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    @Override
    public add a(final Random random) {
        if (random.nextInt(15) == 0) {
            return new TFGenSmallRainboak();
        }
        if (random.nextInt(50) == 0) {
            return new TFGenLargeRainboak();
        }
        if (random.nextInt(5) == 0) {
            return (add)this.Q;
        }
        if (random.nextInt(10) == 0) {
            return (add)new acv(false);
        }
        return (add)this.O;
    }
    
    @Override
    public add b(final Random par1Random) {
        if (par1Random.nextInt(3) > 0) {
            return (add)new ady(aou.ab.cz, 2);
        }
        if (par1Random.nextInt(3) == 0) {
            return (add)new ady(TFBlocks.plant.cz, 8);
        }
        return (add)new ady(aou.ab.cz, 1);
    }
    
    public void a(final zv par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final aea worldgenvines = new aea();
        for (int i = 0; i < 20; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
        }
    }
}
