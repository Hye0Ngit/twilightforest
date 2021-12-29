// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFHedgeMaze extends ss
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d) == TFFeature.hedgeMaze;
    }
    
    protected wg b(final int chunkX, final int chunkZ) {
        return new StructureTFHedgeMazeStart(this.d, this.c, chunkX, chunkZ);
    }
}
