// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFFeature;
import java.util.Random;
import twilightforest.biomes.TFBiomeBase;
import java.util.ArrayList;
import java.util.List;
import twilightforest.TFFeatureCache;

public class TFWorldChunkManager extends acu
{
    private akn myGenBiomes;
    private akn myBiomeIndexLayer;
    private acr myBiomeCache;
    private TFFeatureCache featureCache;
    private List myBiomesToSpawnIn;
    
    protected TFWorldChunkManager() {
        this.myBiomeCache = new acr((acu)this);
        (this.myBiomesToSpawnIn = new ArrayList()).add(TFBiomeBase.twilightForest);
        this.myBiomesToSpawnIn.add(TFBiomeBase.twilightForest2);
        this.myBiomesToSpawnIn.add(TFBiomeBase.clearing);
        this.myBiomesToSpawnIn.add(TFBiomeBase.swamp);
        this.myBiomesToSpawnIn.add(TFBiomeBase.mushrooms);
        this.featureCache = new TFFeatureCache(this);
    }
    
    public TFWorldChunkManager(final long par1, final acf par3WorldType) {
        this();
        final akn[] agenlayer = GenLayerTF.makeTheWorld(par1);
        this.myGenBiomes = agenlayer[0];
        this.myBiomeIndexLayer = agenlayer[1];
    }
    
    public TFWorldChunkManager(final abv par1World) {
        this(par1World.H(), par1World.N().u());
    }
    
    public List a() {
        return this.myBiomesToSpawnIn;
    }
    
    public acp a(final int par1, final int par2) {
        final acp biome = this.myBiomeCache.b(par1, par2);
        if (biome == null) {
            return TFBiomeBase.twilightForest;
        }
        return biome;
    }
    
    public float[] a(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        akl.a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] ai = this.myBiomeIndexLayer.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0 && acp.a[ai[i]] != null) {
                float f = acp.a[ai[i]].g() / 65536.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                par1ArrayOfFloat[i] = f;
            }
        }
        return par1ArrayOfFloat;
    }
    
    public float a(final float par1, final int par2) {
        return par1;
    }
    
    public float[] b(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        akl.a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] var6 = this.myBiomeIndexLayer.a(par2, par3, par4, par5);
        for (int var7 = 0; var7 < par4 * par5; ++var7) {
            float floatTemp;
            if (var6[var7] >= 0 && acp.a[var6[var7]] != null) {
                floatTemp = acp.a[var6[var7]].h() / 65536.0f;
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
    
    public acp[] a(acp[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        akl.a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new acp[par4 * par5];
        }
        final int[] ai = this.myGenBiomes.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = acp.a[ai[i]];
            }
            else {
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public acp[] b(final acp[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        return this.a(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }
    
    public acp[] a(acp[] par1ArrayOfBiomeGenBase, final int x, final int y, final int width, final int length, final boolean cacheFlag) {
        akl.a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < width * length) {
            par1ArrayOfBiomeGenBase = new acp[width * length];
        }
        if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0x0 && (y & 0xF) == 0x0) {
            final acp[] abiomegenbase = this.myBiomeCache.e(x, y);
            System.arraycopy(abiomegenbase, 0, (Object)par1ArrayOfBiomeGenBase, 0, width * length);
            return par1ArrayOfBiomeGenBase;
        }
        final int[] ai = this.myBiomeIndexLayer.a(x, y, width, length);
        for (int i = 0; i < width * length; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = acp.a[ai[i]];
            }
            else {
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
            final acp biomegenbase = acp.a[ai[k2]];
            if (!par4List.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public acn a(final int par1, final int par2, final int par3, final List par4List, final Random par5Random) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.myGenBiomes.a(i, j, i2, j2);
        acn chunkposition = null;
        int k2 = 0;
        for (int l2 = 0; l2 < ai.length; ++l2) {
            final int i3 = i + l2 % i2 << 2;
            final int j3 = j + l2 / i2 << 2;
            final acp biomegenbase = acp.a[ai[l2]];
            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k2 + 1) == 0)) {
                chunkposition = new acn(i3, 0, j3);
                ++k2;
            }
        }
        return chunkposition;
    }
    
    public void b() {
        this.myBiomeCache.a();
    }
    
    public int getFeatureID(final int mapX, final int mapZ, final abv world) {
        return this.getFeatureIDNoCache(mapX, mapZ, world);
    }
    
    public int getFeatureIDNoCache(final int mapX, final int mapZ, final abv world) {
        return this.getFeatureNoCache(mapX, mapZ, world).featureID;
    }
    
    public TFFeature getFeatureAt(final int mapX, final int mapZ, final abv world) {
        return this.getFeatureNoCache(mapX, mapZ, world);
    }
    
    public TFFeature getFeatureNoCache(final int mapX, final int mapZ, final abv world) {
        return TFFeature.generateFeatureFor(mapX >> 4, mapZ >> 4, world);
    }
    
    public boolean isInFeatureChunk(final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        return chunkX % 16 == 0 && chunkZ % 16 == 0;
    }
}
