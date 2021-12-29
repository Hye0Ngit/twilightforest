// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFFourZoom extends wl
{
    int zoomFactor;
    
    public GenLayerTFFourZoom(final long l, final wl genlayer) {
        super(l);
        this.zoomFactor = 2;
        super.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int sox = x / this.zoomFactor - ((x < 0 && x % this.zoomFactor != 0) ? 1 : 0);
        final int soz = z / this.zoomFactor - ((z < 0 && z % this.zoomFactor != 0) ? 1 : 0);
        final int swidth = width / this.zoomFactor + 3;
        final int sdepth = depth / this.zoomFactor + 3;
        final int[] src = this.a.a(sox, soz, swidth, sdepth);
        final int[] dest = ac.a(swidth * this.zoomFactor * (sdepth * this.zoomFactor));
        final int doubleWidth = swidth * this.zoomFactor;
        for (int sz = 0; sz < sdepth - 1; ++sz) {
            for (int sx = 0; sx < swidth - 1; ++sx) {
                this.a((long)(sx + sox * this.zoomFactor), (long)(sz + soz * this.zoomFactor));
                int di = sx * this.zoomFactor + sz * this.zoomFactor * doubleWidth;
                final int source = src[sx + sz * swidth];
                final int cx = 0;
                final int cz = 0;
                for (int dz = 0; dz < this.zoomFactor; ++dz) {
                    for (int dx = 0; dx < this.zoomFactor; ++dx) {
                        dest[di + dx] = ((dx == cx && dz == cz) ? TFBiomeBase.largeFeature.M : source);
                    }
                    di += swidth * this.zoomFactor;
                }
            }
        }
        final int[] output = ac.a(width * depth);
        final int xOffset = x - sox * this.zoomFactor;
        final int zOffset = z - soz * this.zoomFactor;
        for (int copyZ = 0; copyZ < depth; ++copyZ) {
            System.arraycopy(dest, (copyZ + zOffset) * (swidth * this.zoomFactor) + xOffset, output, copyZ * width, width);
        }
        return output;
    }
    
    protected int chooseRandom(int i, int j) {
        if (i < 0) {
            i = -i;
        }
        if (j < 0) {
            j = -j;
        }
        return (this.a(2) != 0) ? j : i;
    }
    
    protected int chooseWeighted(int tl, int tr, int bl, int br) {
        if (tl < 0) {
            tl = -tl;
        }
        if (tr < 0) {
            tr = -tr;
        }
        if (bl < 0) {
            bl = -bl;
        }
        if (br < 0) {
            br = -br;
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
            obj = new GenLayerTFFourZoom(l + j, (wl)obj);
        }
        return (wl)obj;
    }
}
