// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFBiomeClearing extends TFBiomeBase
{
    public TFBiomeClearing(final int i) {
        super(i);
        this.F = 0.8f;
        this.G = 0.4f;
        this.D = 0.01f;
        this.E = 0.0f;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
        this.getTFBiomeDecorator().setFlowersPerChunk(4);
        this.getTFBiomeDecorator().setGrassPerChunk(10);
    }
    
    @Override
    public li b(final Random par1Random) {
        return (li)new to(pb.X.bO, 1);
    }
}
