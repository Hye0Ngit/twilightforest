// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public class GenLayerTFFeatureZoom extends akn
{
    public GenLayerTFFeatureZoom(final long l, final akn genlayer) {
        super(l);
        this.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int sx = x >> 1;
        final int sz = z >> 1;
        final int swidth = (width >> 1) + 3;
        final int sdepth = (depth >> 1) + 3;
        final int[] src = this.a.a(sx, sz, swidth, sdepth);
        final int[] dest = akl.a(swidth * 2 * (sdepth * 2));
        final int doubleWidth = swidth << 1;
        for (int dz = 0; dz < sdepth - 1; ++dz) {
            for (int dx = 0; dx < swidth - 1; ++dx) {
                dest[dx * 2 + 0 + (dz * 2 + 0) * doubleWidth] = src[dx + dz * swidth];
                dest[dx * 2 + 1 + (dz * 2 + 0) * doubleWidth] = 0;
                dest[dx * 2 + 1 + (dz * 2 + 1) * doubleWidth] = (dest[dx * 2 + 0 + (dz * 2 + 1) * doubleWidth] = 0);
            }
        }
        final int[] output = akl.a(width * depth);
        for (int copyZ = 0; copyZ < depth; ++copyZ) {
            System.arraycopy(dest, (copyZ + (z & 0x1)) * (swidth << 1) + (x & 0x1), output, copyZ * width, width);
        }
        return output;
    }
    
    public static akn multipleZoom(final long seed, final akn genlayer, final int loops) {
        akn layer = genlayer;
        for (int i = 0; i < loops; ++i) {
            layer = new GenLayerTFFeatureZoom(seed + i, layer);
        }
        return layer;
    }
}
