// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFRiverMix extends GenLayer
{
    private GenLayer biomeLayer;
    private GenLayer riverLayer;
    
    public GenLayerTFRiverMix(final long par1, final GenLayer par3GenLayer, final GenLayer par4GenLayer) {
        super(par1);
        this.biomeLayer = par3GenLayer;
        this.riverLayer = par4GenLayer;
    }
    
    public void func_75905_a(final long par1) {
        this.biomeLayer.func_75905_a(par1);
        this.riverLayer.func_75905_a(par1);
        super.func_75905_a(par1);
    }
    
    public int[] func_75904_a(final int par1, final int par2, final int par3, final int par4) {
        final int[] biomeInputs = this.biomeLayer.func_75904_a(par1, par2, par3, par4);
        final int[] riverInputs = this.riverLayer.func_75904_a(par1, par2, par3, par4);
        final int[] outputs = IntCache.func_76445_a(par3 * par4);
        for (int i = 0; i < par3 * par4; ++i) {
            if (riverInputs[i] == TFBiomeBase.stream.field_76756_M) {
                outputs[i] = (riverInputs[i] & 0xFF);
            }
            else {
                outputs[i] = biomeInputs[i];
            }
        }
        return outputs;
    }
}
