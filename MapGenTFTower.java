// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFTower extends hl
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return ChunkProviderTwilightForest.featureType(chunkX, chunkZ, this.c) == 6;
    }
    
    protected oa b(final int chunkX, final int chunkZ) {
        return new StructureTFTowerStart(this.c, this.b, chunkX, chunkZ);
    }
}
