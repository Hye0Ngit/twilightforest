// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFTower extends ss
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d) == TFFeature.wizardTower;
    }
    
    protected wg b(final int chunkX, final int chunkZ) {
        return new StructureTFTowerStart(this.d, this.c, chunkX, chunkZ);
    }
}
