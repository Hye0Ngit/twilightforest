// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFCourtyard extends ss
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d) == TFFeature.nagaLair;
    }
    
    protected wg b(final int chunkX, final int chunkZ) {
        return new StructureTFCourtyardStart(this.d, this.c, chunkX, chunkZ);
    }
}
