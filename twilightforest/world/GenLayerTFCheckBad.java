// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFCheckBad extends GenLayer
{
    private String stage;
    
    public GenLayerTFCheckBad(final long par1, final GenLayer par3GenLayer, final String stage) {
        super(par1);
        super.field_75909_a = par3GenLayer;
        this.stage = stage;
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] input = this.field_75909_a.func_75904_a(x, z, width, depth);
        for (int i = 0; i < width * depth; ++i) {
            if (input[i] < 0 || input[i] > TFBiomeBase.fireSwamp.field_76756_M) {
                System.err.printf("Got a bad ID, %d at %d, %d while checking during stage %s\n", input[i], x, z, this.stage);
            }
        }
        return input;
    }
}
