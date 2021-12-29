// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFFeature;
import net.minecraft.world.ChunkPosition;
import java.util.Random;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.World;
import twilightforest.world.layer.GenLayerTF;
import twilightforest.TwilightForestMod;
import net.minecraft.world.WorldType;
import twilightforest.biomes.TFBiomeBase;
import java.util.ArrayList;
import java.util.List;
import twilightforest.TFFeatureCache;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.biome.WorldChunkManager;

public class TFWorldChunkManager extends WorldChunkManager
{
    private GenLayer myGenBiomes;
    private GenLayer myBiomeIndexLayer;
    private BiomeCache myBiomeCache;
    private TFFeatureCache featureCache;
    private List myBiomesToSpawnIn;
    
    protected TFWorldChunkManager() {
        this.myBiomeCache = new BiomeCache((WorldChunkManager)this);
        (this.myBiomesToSpawnIn = new ArrayList()).add(TFBiomeBase.twilightForest);
        this.myBiomesToSpawnIn.add(TFBiomeBase.twilightForest2);
        this.myBiomesToSpawnIn.add(TFBiomeBase.clearing);
        this.myBiomesToSpawnIn.add(TFBiomeBase.tfSwamp);
        this.myBiomesToSpawnIn.add(TFBiomeBase.mushrooms);
        this.featureCache = new TFFeatureCache(this);
    }
    
    public TFWorldChunkManager(final long par1, final WorldType par3WorldType) {
        this();
        GenLayer[] agenlayer;
        if (TwilightForestMod.mapGenChanges) {
            agenlayer = GenLayerTF.makeTheWorld1Point7(par1);
        }
        else {
            agenlayer = GenLayerTF.makeTheWorld(par1);
        }
        this.myGenBiomes = agenlayer[0];
        this.myBiomeIndexLayer = agenlayer[1];
    }
    
    public TFWorldChunkManager(final World par1World) {
        this(par1World.func_72905_C(), par1World.func_72912_H().func_76067_t());
    }
    
    public List func_76932_a() {
        return this.myBiomesToSpawnIn;
    }
    
    public BiomeGenBase func_76935_a(final int par1, final int par2) {
        final BiomeGenBase biome = this.myBiomeCache.func_76837_b(par1, par2);
        if (biome == null) {
            return TFBiomeBase.twilightForest;
        }
        return biome;
    }
    
    public float[] func_76936_a(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        IntCache.func_76446_a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] ai = this.myBiomeIndexLayer.func_75904_a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0 && BiomeGenBase.field_76773_a[ai[i]] != null) {
                float f = BiomeGenBase.field_76773_a[ai[i]].func_76744_g() / 65536.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                par1ArrayOfFloat[i] = f;
            }
        }
        return par1ArrayOfFloat;
    }
    
    public float func_76939_a(final float par1, final int par2) {
        return par1;
    }
    
    public float[] func_76934_b(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        IntCache.func_76446_a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] var6 = this.myBiomeIndexLayer.func_75904_a(par2, par3, par4, par5);
        for (int var7 = 0; var7 < par4 * par5; ++var7) {
            float floatTemp;
            if (var6[var7] >= 0 && BiomeGenBase.field_76773_a[var6[var7]] != null) {
                floatTemp = BiomeGenBase.field_76773_a[var6[var7]].func_76734_h() / 65536.0f;
            }
            else {
                floatTemp = 0.5f;
            }
            if (floatTemp > 1.0f) {
                floatTemp = 1.0f;
            }
            par1ArrayOfFloat[var7] = floatTemp;
        }
        return par1ArrayOfFloat;
    }
    
    public BiomeGenBase[] func_76937_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        IntCache.func_76446_a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }
        final int[] ai = this.myGenBiomes.func_75904_a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.field_76773_a[ai[i]];
            }
            else {
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public BiomeGenBase[] func_76933_b(final BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        return this.func_76931_a(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }
    
    public BiomeGenBase[] func_76931_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int x, final int y, final int width, final int length, final boolean cacheFlag) {
        IntCache.func_76446_a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < width * length) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[width * length];
        }
        if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0x0 && (y & 0xF) == 0x0) {
            final BiomeGenBase[] abiomegenbase = this.myBiomeCache.func_76839_e(x, y);
            System.arraycopy(abiomegenbase, 0, (Object)par1ArrayOfBiomeGenBase, 0, width * length);
            return par1ArrayOfBiomeGenBase;
        }
        final int[] ai = this.myBiomeIndexLayer.func_75904_a(x, y, width, length);
        for (int i = 0; i < width * length; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.field_76773_a[ai[i]];
            }
            else {
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public boolean func_76940_a(final int par1, final int par2, final int par3, final List par4List) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.myGenBiomes.func_75904_a(i, j, i2, j2);
        for (int k2 = 0; k2 < i2 * j2; ++k2) {
            final BiomeGenBase biomegenbase = BiomeGenBase.field_76773_a[ai[k2]];
            if (!par4List.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public ChunkPosition func_76941_a(final int par1, final int par2, final int par3, final List par4List, final Random par5Random) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.myGenBiomes.func_75904_a(i, j, i2, j2);
        ChunkPosition chunkposition = null;
        int k2 = 0;
        for (int l2 = 0; l2 < ai.length; ++l2) {
            final int i3 = i + l2 % i2 << 2;
            final int j3 = j + l2 / i2 << 2;
            final BiomeGenBase biomegenbase = BiomeGenBase.field_76773_a[ai[l2]];
            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k2 + 1) == 0)) {
                chunkposition = new ChunkPosition(i3, 0, j3);
                ++k2;
            }
        }
        return chunkposition;
    }
    
    public void func_76938_b() {
        this.myBiomeCache.func_76838_a();
    }
    
    public int getFeatureID(final int mapX, final int mapZ, final World world) {
        return this.getFeatureIDNoCache(mapX, mapZ, world);
    }
    
    public int getFeatureIDNoCache(final int mapX, final int mapZ, final World world) {
        return this.getFeatureNoCache(mapX, mapZ, world).featureID;
    }
    
    public TFFeature getFeatureAt(final int mapX, final int mapZ, final World world) {
        return this.getFeatureNoCache(mapX, mapZ, world);
    }
    
    public TFFeature getFeatureNoCache(final int mapX, final int mapZ, final World world) {
        return TFFeature.generateFeatureFor(mapX >> 4, mapZ >> 4, world);
    }
    
    public boolean isInFeatureChunk(final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        return chunkX % 16 == 0 && chunkZ % 16 == 0;
    }
}
