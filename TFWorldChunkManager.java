import java.util.Random;
import java.util.ArrayList;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFWorldChunkManager extends yc
{
    private es biomeLayer;
    private es voronoiLayer;
    private es temperatureLayer;
    private es rainfallLayer;
    private us biomeCache;
    private List biomesToSpawnIn;
    
    protected TFWorldChunkManager() {
        this.biomeCache = new us((yc)this);
        (this.biomesToSpawnIn = new ArrayList()).add(TFBiomeBase.twilightForest);
    }
    
    public TFWorldChunkManager(final fq world) {
        this();
        final es[] agenlayer = TFGenLayer.makeTheWorld(world.m());
        this.biomeLayer = agenlayer[0];
        this.voronoiLayer = agenlayer[1];
        this.temperatureLayer = agenlayer[2];
        this.rainfallLayer = agenlayer[3];
    }
    
    public List a() {
        return this.biomesToSpawnIn;
    }
    
    public km a(final zg chunkcoordintpair) {
        return this.a(chunkcoordintpair.a << 4, chunkcoordintpair.b << 4);
    }
    
    public km a(final int i, final int j) {
        return this.biomeCache.b(i, j);
    }
    
    public float[] b(float[] af, final int i, final int j, final int k, final int l) {
        ah.a();
        if (af == null || af.length < k * l) {
            af = new float[k * l];
        }
        final int[] ai = this.rainfallLayer.a(i, j, k, l);
        for (int i2 = 0; i2 < k * l; ++i2) {
            float f = ai[i2] / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            af[i2] = f;
        }
        return af;
    }
    
    public float a(final int i, final int j, final int k) {
        return this.a(this.biomeCache.c(i, k), j);
    }
    
    public float a(final float f, final int i) {
        return f;
    }
    
    public float[] a(final int i, final int j, final int k, final int l) {
        return this.a = this.a(this.a, i, j, k, l);
    }
    
    public float[] a(float[] af, final int i, final int j, final int k, final int l) {
        ah.a();
        if (af == null || af.length < k * l) {
            af = new float[k * l];
        }
        final int[] ai = this.temperatureLayer.a(i, j, k, l);
        for (int i2 = 0; i2 < k * l; ++i2) {
            float f = ai[i2] / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            af[i2] = f;
        }
        return af;
    }
    
    public km[] a(km[] abiomegenbase, final int i, final int j, final int k, final int l) {
        ah.a();
        if (abiomegenbase == null || abiomegenbase.length < k * l) {
            abiomegenbase = new km[k * l];
        }
        final int[] ai = this.biomeLayer.a(i, j, k, l);
        for (int i2 = 0; i2 < k * l; ++i2) {
            abiomegenbase[i2] = km.a[ai[i2]];
        }
        return abiomegenbase;
    }
    
    public km[] b(final km[] abiomegenbase, final int i, final int j, final int k, final int l) {
        return this.a(abiomegenbase, i, j, k, l, true);
    }
    
    public km[] a(km[] abiomegenbase, final int i, final int j, final int k, final int l, final boolean flag) {
        ah.a();
        if (abiomegenbase == null || abiomegenbase.length < k * l) {
            abiomegenbase = new km[k * l];
        }
        if (flag && k == 16 && l == 16 && (i & 0xF) == 0x0 && (j & 0xF) == 0x0) {
            final km[] abiomegenbase2 = this.biomeCache.d(i, j);
            System.arraycopy(abiomegenbase2, 0, (Object)abiomegenbase, 0, k * l);
            return abiomegenbase;
        }
        final int[] ai = this.voronoiLayer.a(i, j, k, l);
        for (int i2 = 0; i2 < k * l; ++i2) {
            abiomegenbase[i2] = km.a[ai[i2]];
        }
        return abiomegenbase;
    }
    
    public boolean a(final int i, final int j, final int k, final List list) {
        final int l = i - k >> 2;
        final int i2 = j - k >> 2;
        final int j2 = i + k >> 2;
        final int k2 = j + k >> 2;
        final int l2 = j2 - l + 1;
        final int i3 = k2 - i2 + 1;
        final int[] ai = this.biomeLayer.a(l, i2, l2, i3);
        for (int j3 = 0; j3 < l2 * i3; ++j3) {
            final km biomegenbase = km.a[ai[j3]];
            if (!list.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public wk a(final int i, final int j, final int k, final List list, final Random random) {
        final int l = i - k >> 2;
        final int i2 = j - k >> 2;
        final int j2 = i + k >> 2;
        final int k2 = j + k >> 2;
        final int l2 = j2 - l + 1;
        final int i3 = k2 - i2 + 1;
        final int[] ai = this.biomeLayer.a(l, i2, l2, i3);
        wk chunkposition = null;
        int j3 = 0;
        for (int k3 = 0; k3 < ai.length; ++k3) {
            final int l3 = l + k3 % l2 << 2;
            final int i4 = i2 + k3 / l2 << 2;
            final km biomegenbase = km.a[ai[k3]];
            if (list.contains(biomegenbase) && (chunkposition == null || random.nextInt(j3 + 1) == 0)) {
                chunkposition = new wk(l3, 0, i4);
                ++j3;
            }
        }
        return chunkposition;
    }
    
    public void b() {
        this.biomeCache.a();
    }
}
