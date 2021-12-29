// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

public class TFBiomeDeepMushrooms extends TFBiomeBase
{
    public TFBiomeDeepMushrooms(final int i) {
        super(i);
        this.F = 0.8f;
        this.G = 1.0f;
        this.D = 0.15f;
        this.E = 0.4f;
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(12);
        this.getTFBiomeDecorator().setBigMushroomsPerChunk(8);
        this.getTFBiomeDecorator().myceliumPerChunk = 3;
        this.getTFBiomeDecorator().chanceCanopyIsMushroom = 0.9f;
    }
}
