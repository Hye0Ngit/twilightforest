// 
// Decompiled by Procyon v0.6-prerelease
// 

public class LayerTFBase extends jx
{
    public LayerTFBase(final long l) {
        super(l);
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] output = bm.a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.a((long)(x + dx), (long)(z + dz));
                output[dx + dz * width] = 1;
            }
        }
        if (x > -width && x <= 0 && z > -depth && z <= 0) {
            output[-x + -z * width] = 1;
        }
        return output;
    }
}
