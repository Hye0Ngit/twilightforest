// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

public class TFBiomeDeepMushrooms extends TFBiomeBase
{
    public TFBiomeDeepMushrooms(final int i) {
        super(i);
        this.field_76750_F = 0.8f;
        this.field_76751_G = 1.0f;
        this.field_76748_D = 0.15f;
        this.field_76749_E = 0.4f;
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(12);
        this.getTFBiomeDecorator().setBigMushroomsPerChunk(8);
        this.getTFBiomeDecorator().myceliumPerChunk = 3;
        this.getTFBiomeDecorator().alternateCanopyChance = 0.9f;
    }
}
