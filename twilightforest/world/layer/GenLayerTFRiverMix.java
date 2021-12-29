// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.biome.Biome;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFRiverMix extends GenLayer
{
    private GenLayer biomeLayer;
    private GenLayer riverLayer;
    
    public GenLayerTFRiverMix(final long seed, final GenLayer biomeLayer, final GenLayer riverLayer) {
        super(seed);
        this.biomeLayer = biomeLayer;
        this.riverLayer = riverLayer;
    }
    
    public void func_75905_a(final long seed) {
        this.biomeLayer.func_75905_a(seed);
        this.riverLayer.func_75905_a(seed);
        super.func_75905_a(seed);
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] biomeInputs = this.biomeLayer.func_75904_a(x, z, width, depth);
        final int[] riverInputs = this.riverLayer.func_75904_a(x, z, width, depth);
        final int[] outputs = IntCache.func_76445_a(width * depth);
        final int stream = Biome.func_185362_a(TFBiomes.stream);
        for (int i = 0; i < width * depth; ++i) {
            if (riverInputs[i] == stream) {
                outputs[i] = (riverInputs[i] & 0xFF);
            }
            else {
                outputs[i] = biomeInputs[i];
            }
        }
        return outputs;
    }
}
