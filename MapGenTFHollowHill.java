// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFHollowHill extends rd
{
    protected boolean a(final int chunkX, final int chunkZ) {
        final int featureType = ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.d);
        return featureType == 1 || featureType == 2 || featureType == 3;
    }
    
    protected uj b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowHillStart(this.d, this.c, chunkX, chunkZ);
    }
}
