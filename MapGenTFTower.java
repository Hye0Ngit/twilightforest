// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFTower extends agn
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.d) == 6;
    }
    
    protected pc b(final int chunkX, final int chunkZ) {
        return new StructureTFTowerStart(this.d, this.c, chunkX, chunkZ);
    }
}
