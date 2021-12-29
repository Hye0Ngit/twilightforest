// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class MapGenTFCourtyard extends agt
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d) == TFFeature.nagaLair;
    }
    
    protected pg b(final int chunkX, final int chunkZ) {
        return new StructureTFCourtyardStart(this.d, this.c, chunkX, chunkZ);
    }
}
