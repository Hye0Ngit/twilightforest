// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import java.util.Random;

public class TFBiomeSnow extends TFBiomeBase
{
    public TFBiomeSnow(final int i) {
        super(i);
        this.getTFBiomeDecorator().setTreesPerChunk(7);
        this.getTFBiomeDecorator().setGrassPerChunk(1);
        this.F = 0.125f;
        this.G = 0.9f;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
    }
    
    @Override
    public abf a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (abf)new abs();
        }
        return (abf)new aby(true);
    }
    
    public boolean c() {
        return true;
    }
    
    public boolean d() {
        return false;
    }
}
