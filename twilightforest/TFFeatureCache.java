// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import cpw.mods.fml.common.FMLLog;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.ArrayList;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.biome.WorldChunkManager;

public class TFFeatureCache
{
    private final WorldChunkManager chunkManager;
    private int lastSavedSize;
    public static final String fileName = "twilight.fc";
    private LongHashMap cacheMap;
    private ArrayList<TFFeatureCacheData> cache;
    
    public TFFeatureCache(final WorldChunkManager par1WorldChunkManager) {
        this.lastSavedSize = 0;
        this.cacheMap = new LongHashMap();
        this.cache = new ArrayList<TFFeatureCacheData>();
        this.chunkManager = par1WorldChunkManager;
    }
    
    public TFFeatureCacheData getFeatureCacheBlock(final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        final long key = ((long)chunkX & 0xFFFFFFFFL) | ((long)chunkZ & 0xFFFFFFFFL) << 32;
        final TFFeatureCacheData featureBlock = (TFFeatureCacheData)this.cacheMap.func_76164_a(key);
        return featureBlock;
    }
    
    public void addData(final int chunkX, final int chunkZ, final int featureID, final int featureStatus) {
        final TFFeatureCacheData featureBlock = new TFFeatureCacheData(this, chunkX, chunkZ);
        featureBlock.featureID = (byte)featureID;
        featureBlock.featureStatus = (byte)featureStatus;
        if (!this.addDataToMap(featureBlock)) {
            this.cache.add(featureBlock);
        }
    }
    
    private boolean addDataToMap(final TFFeatureCacheData featureBlock) {
        final long key = ((long)featureBlock.xPosition & 0xFFFFFFFFL) | ((long)featureBlock.zPosition & 0xFFFFFFFFL) << 32;
        final boolean exists = this.cacheMap.func_76164_a(key) != null;
        this.cacheMap.func_76163_a(key, (Object)featureBlock);
        return exists;
    }
    
    static WorldChunkManager getChunkManager(final TFFeatureCache par0BiomeCache) {
        return par0BiomeCache.chunkManager;
    }
    
    public void save(final File saveDir) {
        if (this.lastSavedSize < this.cache.size()) {
            final File saveFile = new File(saveDir, "twilight.fc");
            try {
                saveFile.createNewFile();
                final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
                out.writeObject(this.cache);
                out.close();
                this.lastSavedSize = this.cache.size();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void load(final File saveDir) {
        final File saveFile = new File(saveDir, "twilight.fc");
        try {
            final ObjectInputStream in = new ObjectInputStream(new FileInputStream(saveFile));
            this.cache = (ArrayList)in.readObject();
            in.close();
        }
        catch (FileNotFoundException e) {
            return;
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        for (final TFFeatureCacheData block : this.cache) {
            this.addDataToMap(block);
        }
        this.lastSavedSize = this.cache.size();
        if (this.cache.size() == this.cacheMap.func_76162_a()) {
            FMLLog.info("[TwilightForest] Loaded feature cache with %d chunks present.", new Object[] { this.cache.size() });
        }
        else {
            FMLLog.warning("[TwilightForest] Feature cache mismatch, cache.size=%d, map.elements=%d.", new Object[] { this.cache.size(), this.cacheMap.func_76162_a() });
        }
    }
}
