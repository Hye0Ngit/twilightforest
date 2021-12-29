// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.server.MinecraftServer;
import java.util.ArrayList;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.List;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;

public class TFBiomeCache
{
    private final Long2ObjectMap<Entry> entryMap;
    private final List<Entry> entries;
    private final TFBiomeProvider provider;
    private final int gridSize;
    private final boolean offset;
    private long lastCleanupTime;
    
    public TFBiomeCache(final TFBiomeProvider provider, final int gridSize, final boolean offset) {
        this.entryMap = (Long2ObjectMap<Entry>)new Long2ObjectOpenHashMap();
        this.entries = new ArrayList<Entry>();
        this.provider = provider;
        this.gridSize = gridSize;
        this.offset = offset;
    }
    
    private Entry getEntry(int x, int z) {
        x = this.toGrid(x);
        z = this.toGrid(z);
        final long key = getKey(x, z);
        Entry entry = (Entry)this.entryMap.get(key);
        if (entry == null) {
            entry = new Entry(x, z);
            this.entryMap.put(key, (Object)entry);
            this.entries.add(entry);
        }
        entry.lastAccessTime = MinecraftServer.func_130071_aq();
        return entry;
    }
    
    public Biome[] getBiomes(final int x, final int z) {
        return this.getEntry(x, z).biomes;
    }
    
    public void cleanup() {
        final long currentTime = MinecraftServer.func_130071_aq();
        final long timeSinceCleanup = currentTime - this.lastCleanupTime;
        if (timeSinceCleanup > 7500L || timeSinceCleanup < 0L) {
            this.lastCleanupTime = currentTime;
            for (int i = 0; i < this.entries.size(); ++i) {
                final Entry entry = this.entries.get(i);
                final long timeSinceAccess = currentTime - entry.lastAccessTime;
                if (timeSinceAccess > 30000L || timeSinceAccess < 0L) {
                    this.entries.remove(i--);
                    final long key = getKey(entry.x, entry.z);
                    this.entryMap.remove(key);
                }
            }
        }
    }
    
    public boolean isGridAligned(final int x, final int z, final int width, final int height) {
        return width == this.gridSize && height == this.gridSize && this.gridOffset(x) == 0 && this.gridOffset(z) == 0;
    }
    
    private int gridOffset(final int n) {
        return (n + (this.offset ? (this.gridSize / 2) : 0)) % this.gridSize;
    }
    
    private int toGrid(final int n) {
        return (n + (this.offset ? (this.gridSize / 2) : 0)) / this.gridSize;
    }
    
    private int fromGrid(final int n) {
        return n * this.gridSize - (this.offset ? (this.gridSize / 2) : 0);
    }
    
    private static long getKey(final int x, final int z) {
        return Integer.toUnsignedLong(x) | Integer.toUnsignedLong(z) << 32;
    }
    
    private final class Entry
    {
        final Biome[] biomes;
        final int x;
        final int z;
        long lastAccessTime;
        
        Entry(final int x, final int z) {
            this.biomes = new Biome[TFBiomeCache.this.gridSize * TFBiomeCache.this.gridSize];
            this.x = x;
            this.z = z;
            TFBiomeCache.this.provider.getBiomesForGeneration(this.biomes, TFBiomeCache.this.fromGrid(x), TFBiomeCache.this.fromGrid(z), TFBiomeCache.this.gridSize, TFBiomeCache.this.gridSize, false);
        }
    }
}
