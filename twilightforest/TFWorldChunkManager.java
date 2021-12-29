// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class TFWorldChunkManager extends rs
{
    private wp genBiomes;
    private wp biomeIndexLayer;
    private pn biomeCache;
    private List biomesToSpawnIn;
    
    protected TFWorldChunkManager() {
        this.biomeCache = new pn((rs)this);
        (this.biomesToSpawnIn = new ArrayList()).add(TFBiomeBase.twilightForest);
        this.biomesToSpawnIn.add(TFBiomeBase.twilightForest2);
        this.biomesToSpawnIn.add(TFBiomeBase.clearing);
        this.biomesToSpawnIn.add(TFBiomeBase.swamp);
        this.biomesToSpawnIn.add(TFBiomeBase.mushrooms);
    }
    
    public TFWorldChunkManager(final long par1, final vx par3WorldType) {
        this();
        final wp[] agenlayer = GenLayerTF.makeTheWorld(par1);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }
    
    public TFWorldChunkManager(final xd par1World) {
        this(par1World.v(), par1World.B().t());
    }
    
    public List a() {
        return this.biomesToSpawnIn;
    }
    
    public abn a(final int par1, final int par2) {
        return this.biomeCache.b(par1, par2);
    }
    
    public float[] b(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        ad.a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] ai = this.biomeIndexLayer.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            float f = abn.a[ai[i]].g() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            par1ArrayOfFloat[i] = f;
        }
        return par1ArrayOfFloat;
    }
    
    public float a(final float par1, final int par2) {
        return par1;
    }
    
    public float[] a(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        ad.a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] ai = this.biomeIndexLayer.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            float f = abn.a[ai[i]].h() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            par1ArrayOfFloat[i] = f;
        }
        return par1ArrayOfFloat;
    }
    
    public abn[] a(abn[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        ad.a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new abn[par4 * par5];
        }
        final int[] ai = this.genBiomes.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            par1ArrayOfBiomeGenBase[i] = abn.a[ai[i]];
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public abn[] b(final abn[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        return this.a(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }
    
    public abn[] a(abn[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5, final boolean par6) {
        ad.a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new abn[par4 * par5];
        }
        if (par6 && par4 == 16 && par5 == 16 && (par2 & 0xF) == 0x0 && (par3 & 0xF) == 0x0) {
            final abn[] abiomegenbase = this.biomeCache.c(par2, par3);
            System.arraycopy(abiomegenbase, 0, (Object)par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        final int[] ai = this.biomeIndexLayer.a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            par1ArrayOfBiomeGenBase[i] = abn.a[ai[i]];
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
        final int[] ai = this.genBiomes.a(i, j, i2, j2);
        for (int k2 = 0; k2 < i2 * j2; ++k2) {
            final abn biomegenbase = abn.a[ai[k2]];
            if (!par4List.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public qo a(final int par1, final int par2, final int par3, final List par4List, final Random par5Random) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.genBiomes.a(i, j, i2, j2);
        qo chunkposition = null;
        int k2 = 0;
        for (int l2 = 0; l2 < ai.length; ++l2) {
            final int i3 = i + l2 % i2 << 2;
            final int j3 = j + l2 / i2 << 2;
            final abn biomegenbase = abn.a[ai[l2]];
            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k2 + 1) == 0)) {
                chunkposition = new qo(i3, 0, j3);
                ++k2;
            }
        }
        return chunkposition;
    }
    
    public void b() {
        this.biomeCache.a();
    }
    
    public boolean isInFeatureChunk(final int mapX, final int mapZ) {
        final abn[] biomes = this.biomeCache.a(mapX, mapZ).c;
        for (int i = 0; i < biomes.length; ++i) {
            if (biomes[i] == TFBiomeBase.largeFeature) {
                return true;
            }
        }
        return false;
    }
}
