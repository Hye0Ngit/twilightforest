// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.ArrayList;

public class TFFeatureCache
{
    private final yw chunkManager;
    private int lastSavedSize;
    public static final String fileName = "twilight.fc";
    private kc cacheMap;
    private ArrayList cache;
    
    public TFFeatureCache(final yw par1WorldChunkManager) {
        this.lastSavedSize = 0;
        this.cacheMap = new kc();
        this.cache = new ArrayList();
        this.chunkManager = par1WorldChunkManager;
    }
    
    public TFFeatureCacheData getFeatureCacheBlock(final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        final long key = ((long)chunkX & 0xFFFFFFFFL) | ((long)chunkZ & 0xFFFFFFFFL) << 32;
        final TFFeatureCacheData featureBlock = (TFFeatureCacheData)this.cacheMap.a(key);
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
        final boolean exists = this.cacheMap.a(key) != null;
        this.cacheMap.a(key, (Object)featureBlock);
        return exists;
    }
    
    static yw getChunkManager(final TFFeatureCache par0BiomeCache) {
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
        System.out.println("Cache loaded.  Size = " + this.cache.size());
        for (final TFFeatureCacheData block : this.cache) {
            this.addDataToMap(block);
        }
        this.lastSavedSize = this.cache.size();
        System.out.println("Readded hashes, hash size = " + this.cacheMap.a());
    }
}
