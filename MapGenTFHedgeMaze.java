// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFHedgeMaze extends rd
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.d) == 4;
    }
    
    protected uj b(final int chunkX, final int chunkZ) {
        return new StructureTFHedgeMazeStart(this.d, this.c, chunkX, chunkZ);
    }
}
