// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFBiomeHighlands extends TFBiomeBase
{
    public TFBiomeHighlands(final int i) {
        super(i);
        this.D = 2.5f;
        this.E = 0.4f;
        this.F = 0.5f;
        this.G = 0.3f;
        ((TFBiomeDecorator)this.I).canopyPerChunk = -999;
    }
    
    @Override
    public li a(final Random random) {
        if (random.nextInt(4) == 0) {
            return (li)this.O;
        }
        if (random.nextInt(10) == 0) {
            return (li)new rb(true);
        }
        return (li)this.P;
    }
}
