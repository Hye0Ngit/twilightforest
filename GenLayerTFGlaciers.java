// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFGlaciers extends jx
{
    public GenLayerTFGlaciers(final long l, final jx genlayer) {
        super(l);
        this.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] source = this.a.a(x, z, width, depth);
        final int[] dest = bm.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                if (source[dx + dz * width] != TFBiomeBase.tfOcean.F && this.a(37) == 0) {
                    dest[dx + dz * width] = TFBiomeBase.glacier.F;
                }
                else {
                    dest[dx + dz * width] = source[dx + dz * width];
                }
            }
        }
        return dest;
    }
}
