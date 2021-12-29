// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFHollowHill extends agn
{
    protected boolean a(final int chunkX, final int chunkZ) {
        final int featureType = ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.d);
        return featureType == 1 || featureType == 2 || featureType == 3;
    }
    
    protected pc b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowHillStart(this.d, this.c, chunkX, chunkZ);
    }
}
