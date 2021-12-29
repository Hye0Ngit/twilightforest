// 
// Decompiled by Procyon v0.6-prerelease
// 

public class GenLayerTFLakes extends es
{
    public GenLayerTFLakes(final long l, final es genlayer) {
        super(l);
        this.a = genlayer;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] source = this.a.a(x, z, width, depth);
        final int[] dest = ah.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(dx + x), (long)(dz + z));
                if (this.a(29) == 0) {
                    dest[dx + dz * width] = TFBiomeBase.tfOcean.K;
                }
                else {
                    dest[dx + dz * width] = source[dx + dz * width];
                }
            }
        }
        return dest;
    }
}
