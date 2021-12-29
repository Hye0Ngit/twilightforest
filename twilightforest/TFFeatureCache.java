// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import java.util.List;

public class TFFeatureCache
{
    private final rs chunkManager;
    private long lastCleanupTime;
    private en cacheMap;
    private List cache;
    
    public TFFeatureCache(final rs par1WorldChunkManager) {
        this.lastCleanupTime = 0L;
        this.cacheMap = new en();
        this.cache = new ArrayList();
        this.chunkManager = par1WorldChunkManager;
    }
    
    public TFFeatureCacheBlock getFeatureCacheBlock(int mapX, int mapZ) {
        mapX >>= 4;
        mapZ >>= 4;
        final long l = ((long)mapX & 0xFFFFFFFFL) | ((long)mapZ & 0xFFFFFFFFL) << 32;
        TFFeatureCacheBlock featureBlock = (TFFeatureCacheBlock)this.cacheMap.a(l);
        if (featureBlock == null) {
            featureBlock = new TFFeatureCacheBlock(this, mapX, mapZ);
            this.cacheMap.a(l, (Object)featureBlock);
            this.cache.add(featureBlock);
        }
        featureBlock.lastAccessTime = System.currentTimeMillis();
        return featureBlock;
    }
    
    public abn isAreaFeature(final int mapX, final int mapZ) {
        return this.getFeatureCacheBlock(mapX, mapZ).isFeature();
    }
    
    public void cleanupCache() {
        final long l = System.currentTimeMillis();
        final long l2 = l - this.lastCleanupTime;
        if (l2 > 7500L || l2 < 0L) {
            this.lastCleanupTime = l;
            for (int i = 0; i < this.cache.size(); ++i) {
                final air biomecacheblock = this.cache.get(i);
                final long l3 = l - biomecacheblock.f;
                if (l3 > 30000L || l3 < 0L) {
                    this.cache.remove(i--);
                    final long l4 = ((long)biomecacheblock.d & 0xFFFFFFFFL) | ((long)biomecacheblock.e & 0xFFFFFFFFL) << 32;
                    this.cacheMap.d(l4);
                }
            }
        }
    }
    
    static rs getChunkManager(final TFFeatureCache par0BiomeCache) {
        return par0BiomeCache.chunkManager;
    }
}
