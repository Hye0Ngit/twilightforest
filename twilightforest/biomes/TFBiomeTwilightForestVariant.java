// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TFBiomeTwilightForestVariant extends TFBiomeBase
{
    public TFBiomeTwilightForestVariant(final int i) {
        super(i);
        this.F = 0.7f;
        this.G = 0.8f;
        this.D = 0.15f;
        this.E = 0.4f;
        this.getTFBiomeDecorator().setTreesPerChunk(25);
        this.getTFBiomeDecorator().setGrassPerChunk(15);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    @Override
    public afd a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (afd)new aff(3, 0);
        }
        if (random.nextInt(10) == 0) {
            return (afd)new aev(false);
        }
        return (afd)this.O;
    }
    
    @Override
    public afd b(final Random par1Random) {
        if (par1Random.nextInt(4) != 0) {
            return (afd)new afy(aqw.ac.cF, 2);
        }
        if (par1Random.nextBoolean()) {
            return (afd)new afy(TFBlocks.plant.cF, 4);
        }
        return (afd)new afy(aqw.ac.cF, 1);
    }
}
