// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFCourtyard extends agn
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.d) == 5;
    }
    
    protected pc b(final int chunkX, final int chunkZ) {
        return new StructureTFCourtyardStart(this.d, this.c, chunkX, chunkZ);
    }
}
