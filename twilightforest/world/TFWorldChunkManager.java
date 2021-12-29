// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.io.File;
import twilightforest.TFFeatureCacheData;
import java.util.Random;
import twilightforest.biomes.TFBiomeBase;
import java.util.ArrayList;
import java.util.List;
import twilightforest.TFFeatureCache;

public class TFWorldChunkManager extends yw
{
    private agp myGenBiomes;
    private agp myBiomeIndexLayer;
    private yt myBiomeCache;
    private TFFeatureCache featureCache;
    private List myBiomesToSpawnIn;
    
    protected TFWorldChunkManager() {
        this.myBiomeCache = new yt((yw)this);
        (this.myBiomesToSpawnIn = new ArrayList()).add(TFBiomeBase.twilightForest);
        this.myBiomesToSpawnIn.add(TFBiomeBase.twilightForest2);
        this.myBiomesToSpawnIn.add(TFBiomeBase.clearing);
        this.myBiomesToSpawnIn.add(TFBiomeBase.swamp);
        this.myBiomesToSpawnIn.add(TFBiomeBase.mushrooms);
        this.featureCache = new TFFeatureCache(this);
    }
    
    public TFWorldChunkManager(final long par1, final yg par3WorldType) {
        this();
        final agp[] agenlayer = GenLayerTF.makeTheWorld(par1);
        this.myGenBiomes = agenlayer[0];
        this.myBiomeIndexLayer = agenlayer[1];
    }
    
    public TFWorldChunkManager(final xv par1World) {
        this(par1World.E(), par1World.K().u());
    }
    
    public List a() {
        return this.myBiomesToSpawnIn;
    }
    
    public yr a(final int par1, final int par2) {
        final yr biome = this.myBiomeCache.b(par1, par2);
        if (biome == null) {
            System.err.println("Suppressing bad biome data, " + biome + " at " + par1 + ", " + par2);
            return TFBiomeBase.twilightForest;
        }
        return biome;
    }
    
    public float[] a(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        agn.a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] ai = this.myBiomeIndexLayer.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0 && yr.a[ai[i]] != null) {
                float f = yr.a[ai[i]].g() / 65536.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                par1ArrayOfFloat[i] = f;
            }
            else {
                System.err.println("Getting bad biome value when determining rainfall!");
                System.err.println("biome id is " + ai[i]);
            }
        }
        return par1ArrayOfFloat;
    }
    
    public float a(final float par1, final int par2) {
        return par1;
    }
    
    public float[] b(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        agn.a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] var6 = this.myBiomeIndexLayer.a(par2, par3, par4, par5);
        for (int var7 = 0; var7 < par4 * par5; ++var7) {
            float floatTemp;
            if (var6[var7] >= 0 && yr.a[var6[var7]] != null) {
                floatTemp = yr.a[var6[var7]].h() / 65536.0f;
            }
            else {
                System.err.println("Got bad biome data : " + var6[var7]);
                floatTemp = 0.5f;
            }
            if (floatTemp > 1.0f) {
                floatTemp = 1.0f;
            }
            par1ArrayOfFloat[var7] = floatTemp;
        }
        return par1ArrayOfFloat;
    }
    
    public yr[] a(yr[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        agn.a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new yr[par4 * par5];
        }
        final int[] ai = this.myGenBiomes.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = yr.a[ai[i]];
            }
            else {
                System.err.println("Got bad biome data : " + ai[i]);
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public yr[] b(final yr[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        return this.a(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }
    
    public yr[] a(yr[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5, final boolean par6) {
        agn.a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new yr[par4 * par5];
        }
        if (par6 && par4 == 16 && par5 == 16 && (par2 & 0xF) == 0x0 && (par3 & 0xF) == 0x0) {
            final yr[] abiomegenbase = this.myBiomeCache.e(par2, par3);
            System.arraycopy(abiomegenbase, 0, (Object)par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        final int[] ai = this.myBiomeIndexLayer.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = yr.a[ai[i]];
            }
            else {
                System.err.println("Got bad biome data : " + ai[i]);
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public boolean a(final int par1, final int par2, final int par3, final List par4List) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.myGenBiomes.a(i, j, i2, j2);
        for (int k2 = 0; k2 < i2 * j2; ++k2) {
            final yr biomegenbase = yr.a[ai[k2]];
            if (!par4List.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public yo a(final int par1, final int par2, final int par3, final List par4List, final Random par5Random) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.myGenBiomes.a(i, j, i2, j2);
        yo chunkposition = null;
        int k2 = 0;
        for (int l2 = 0; l2 < ai.length; ++l2) {
            final int i3 = i + l2 % i2 << 2;
            final int j3 = j + l2 / i2 << 2;
            final yr biomegenbase = yr.a[ai[l2]];
            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k2 + 1) == 0)) {
                chunkposition = new yo(i3, 0, j3);
                ++k2;
            }
        }
        return chunkposition;
    }
    
    public void b() {
        this.myBiomeCache.a();
    }
    
    public boolean isInFeatureChunk(final int mapX, final int mapZ) {
        final TFFeatureCacheData cacheBlock = this.featureCache.getFeatureCacheBlock(mapX, mapZ);
        if (cacheBlock != null) {
            return cacheBlock.featureID > 0;
        }
        return this.isInFeatureChunkNoCache(mapX, mapZ);
    }
    
    public boolean isInFeatureChunkNoCache(final int mapX, final int mapZ) {
        final yr[] biomes = this.myBiomeCache.a(mapX, mapZ).c;
        for (int i = 0; i < biomes.length; ++i) {
            if (biomes[i] == TFBiomeBase.majorFeature) {
                return true;
            }
        }
        return false;
    }
    
    public void cacheFeatureData(final int chunkX, final int chunkZ, final int featureID, final int featureStatus) {
        this.featureCache.addData(chunkX, chunkZ, featureID, featureStatus);
    }
    
    public void saveFeatureCache(final File saveDir) {
        this.featureCache.save(saveDir);
    }
    
    public void loadFeatureCache(final File saveDir) {
        this.featureCache.load(saveDir);
    }
}
