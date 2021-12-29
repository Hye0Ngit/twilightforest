// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFHedgeMaze extends agn
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.d) == 4;
    }
    
    protected pc b(final int chunkX, final int chunkZ) {
        return new StructureTFHedgeMazeStart(this.d, this.c, chunkX, chunkZ);
    }
}
