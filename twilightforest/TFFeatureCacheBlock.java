// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFFeatureCacheBlock
{
    public float[] temperatureValues;
    public float[] rainfallValues;
    public abn[] biomes;
    public int xPosition;
    public int zPosition;
    public long lastAccessTime;
    final TFFeatureCache featureCache;
    
    public TFFeatureCacheBlock(final TFFeatureCache par1FeatureCache, final int chunkX, final int chunkZ) {
        this.featureCache = par1FeatureCache;
        this.temperatureValues = new float[256];
        this.rainfallValues = new float[256];
        this.biomes = new abn[256];
        this.xPosition = chunkX;
        this.zPosition = chunkZ;
        TFFeatureCache.getChunkManager(this.featureCache).a(this.temperatureValues, chunkX << 4, chunkZ << 4, 16, 16);
        TFFeatureCache.getChunkManager(this.featureCache).b(this.rainfallValues, chunkX << 4, chunkZ << 4, 16, 16);
        TFFeatureCache.getChunkManager(this.featureCache).a(this.biomes, chunkX << 4, chunkZ << 4, 16, 16, false);
    }
    
    public abn getBiomeGenAt(final int par1, final int par2) {
        return this.biomes[(par1 & 0xF) | (par2 & 0xF) << 4];
    }
    
    public abn isFeature() {
        return null;
    }
}
