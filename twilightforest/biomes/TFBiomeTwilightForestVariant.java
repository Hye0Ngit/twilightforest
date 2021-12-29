// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

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
    public add a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (add)new adf(3, 0);
        }
        if (random.nextInt(10) == 0) {
            return (add)new acv(false);
        }
        return (add)this.O;
    }
    
    @Override
    public add b(final Random par1Random) {
        if (par1Random.nextInt(4) != 0) {
            return (add)new ady(aou.ab.cz, 2);
        }
        return (add)new ady(aou.ab.cz, 1);
    }
}
