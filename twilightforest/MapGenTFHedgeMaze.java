// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class MapGenTFHedgeMaze extends agt
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d) == TFFeature.hedgeMaze;
    }
    
    protected pg b(final int chunkX, final int chunkZ) {
        return new StructureTFHedgeMazeStart(this.d, this.c, chunkX, chunkZ);
    }
}
