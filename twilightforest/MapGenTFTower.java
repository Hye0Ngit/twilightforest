// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class MapGenTFTower extends agt
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d) == TFFeature.wizardTower;
    }
    
    protected pg b(final int chunkX, final int chunkZ) {
        return new StructureTFTowerStart(this.d, this.c, chunkX, chunkZ);
    }
}
