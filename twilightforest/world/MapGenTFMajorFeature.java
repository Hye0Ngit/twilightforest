// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.structures.StructureTFMajorFeatureStart;
import twilightforest.TFFeature;

public class MapGenTFMajorFeature extends aev
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.c).structureEnabled;
    }
    
    protected afb b(final int chunkX, final int chunkZ) {
        return new StructureTFMajorFeatureStart(this.c, this.b, chunkX, chunkZ);
    }
}
