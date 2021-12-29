// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class MapGenTFQuestGrove extends agt
{
    public MapGenTFQuestGrove() {
        this.b = 1;
    }
    
    protected boolean a(final int chunkX, final int chunkZ) {
        final TFFeature featureType = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d);
        return featureType == TFFeature.questGrove;
    }
    
    protected pg b(final int chunkX, final int chunkZ) {
        return new StructureTFQuestGroveStart(this.d, this.c, chunkX, chunkZ);
    }
}
