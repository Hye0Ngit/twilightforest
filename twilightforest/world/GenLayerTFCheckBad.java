// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;

public class GenLayerTFCheckBad extends ain
{
    private String stage;
    
    public GenLayerTFCheckBad(final long par1, final ain par3GenLayer, final String stage) {
        super(par1);
        super.a = par3GenLayer;
        this.stage = stage;
    }
    
    public int[] a(final int x, final int z, final int width, final int depth) {
        final int[] input = this.a.a(x, z, width, depth);
        for (int i = 0; i < width * depth; ++i) {
            if (input[i] < 0 || input[i] > TFBiomeBase.fireSwamp.N) {
                System.err.printf("Got a bad ID, %d at %d, %d while checking during stage %s\n", input[i], x, z, this.stage);
            }
        }
        return input;
    }
}
