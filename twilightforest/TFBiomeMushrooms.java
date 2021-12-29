// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFBiomeMushrooms extends TFBiomeBase
{
    public TFBiomeMushrooms(final int i) {
        super(i);
        this.G = 0.8f;
        this.getTFBiomeDecorator().setTreesPerChunk(8);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setBigMushroomsPerChunk(2);
        this.getTFBiomeDecorator().chanceCanopyIsMushroom = 0.2f;
    }
}
