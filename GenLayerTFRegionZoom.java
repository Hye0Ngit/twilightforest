// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFRegionZoom extends wl
{
    public boolean shiftCenter;
    
    public GenLayerTFRegionZoom(final long l, final wl genlayer, final boolean sc) {
        super(l);
        super.a = genlayer;
        this.shiftCenter = sc;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int sx = x >> 1;
        final int sz = z >> 1;
        final int swidth = (width >> 1) + 3;
        final int sdepth = (depth >> 1) + 3;
        final int[] src = this.a.a(sx, sz, swidth, sdepth);
        final int[] dest = ac.a(swidth * 2 * (sdepth * 2));
        final int doubleWidth = swidth << 1;
        for (int dz = 0; dz < sdepth - 1; ++dz) {
            final int doubleZ = dz << 1;
            int di = doubleZ * doubleWidth;
            int tl = src[0 + (dz + 0) * swidth];
            int bl = src[0 + (dz + 1) * swidth];
            for (int dx = 0; dx < swidth - 1; ++dx) {
                this.a((long)(dx + sx << 1), (long)(dz + sz << 1));
                final int tr = src[dx + 1 + (dz + 0) * swidth];
                final int br = src[dx + 1 + (dz + 1) * swidth];
                if (this.shiftCenter) {
                    dest[di] = ((tl == TFBiomeBase.largeFeature.M) ? br : tl);
                }
                else {
                    dest[di] = tl;
                }
                dest[di++ + doubleWidth] = this.chooseRandom(tl, bl);
                dest[di] = this.chooseRandom(tl, tr);
                dest[di++ + doubleWidth] = this.chooseWeighted(tl, tr, bl, br);
                tl = tr;
                bl = br;
            }
        }
        final int[] output = ac.a(width * depth);
        for (int copyZ = 0; copyZ < depth; ++copyZ) {
            System.arraycopy(dest, (copyZ + (z & 0x1)) * (swidth << 1) + (x & 0x1), output, copyZ * width, width);
        }
        return output;
    }
    
    protected int chooseRandom(final int i, final int j) {
        if (i == TFBiomeBase.largeFeature.M) {
            return j;
        }
        if (j == TFBiomeBase.largeFeature.M) {
            return i;
        }
        return (this.a(2) != 0) ? j : i;
    }
    
    protected int chooseRandom(final int o1, final int o2, final int o3) {
        return (this.a(3) != 0) ? o1 : ((this.a(2) != 0) ? o2 : o3);
    }
    
    protected int chooseWeighted(final int tl, final int tr, final int bl, final int br) {
        if (this.shiftCenter && tl == TFBiomeBase.largeFeature.M) {
            return tl;
        }
        if (tr == bl && bl == br) {
            return tr;
        }
        if (tl == tr && tl == bl) {
            return tl;
        }
        if (tl == tr && tl == br) {
            return tl;
        }
        if (tl == bl && tl == br) {
            return tl;
        }
        if (tl == tr && bl != br) {
            return tl;
        }
        if (tl == bl && tr != br) {
            return tl;
        }
        if (tl == br && tr != bl) {
            return tl;
        }
        if (tr == tl && bl != br) {
            return tr;
        }
        if (tr == bl && tl != br) {
            return tr;
        }
        if (tr == br && tl != bl) {
            return tr;
        }
        if (bl == tl && tr != br) {
            return bl;
        }
        if (bl == tr && tl != br) {
            return bl;
        }
        if (bl == br && tl != tr) {
            return bl;
        }
        if (br == tl && tr != bl) {
            return bl;
        }
        if (br == tr && tl != bl) {
            return bl;
        }
        if (br == bl && tl != tr) {
            return bl;
        }
        if (tl == TFBiomeBase.largeFeature.M) {
            return this.chooseRandom(tr, bl, br);
        }
        if (tr == TFBiomeBase.largeFeature.M) {
            return this.chooseRandom(tl, bl, br);
        }
        if (bl == TFBiomeBase.largeFeature.M) {
            return this.chooseRandom(tl, tr, br);
        }
        if (br == TFBiomeBase.largeFeature.M) {
            return this.chooseRandom(tl, tr, bl);
        }
        final int i1 = this.a(4);
        if (i1 == 0) {
            return tl;
        }
        if (i1 == 1) {
            return tr;
        }
        if (i1 == 2) {
            return bl;
        }
        return br;
    }
    
    public static wl multipleZoom(final long l, final wl genlayer, final int i) {
        Object obj = genlayer;
        for (int j = 0; j < i; ++j) {
            obj = new GenLayerTFRegionZoom(l + j, (wl)obj, false);
        }
        return (wl)obj;
    }
}
