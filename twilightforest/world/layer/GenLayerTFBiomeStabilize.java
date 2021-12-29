// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public enum GenLayerTFBiomeStabilize implements IAreaTransformer1
{
    INSTANCE;
    
    public int func_215721_a(final int x) {
        return x & 0x3;
    }
    
    public int func_215722_b(final int z) {
        return z & 0x3;
    }
    
    public int func_215728_a(final IExtendedNoiseRandom<?> iExtendedNoiseRandom, final IArea iArea, final int x, final int z) {
        final int offX = this.func_215721_a(x << 4);
        final int offZ = this.func_215722_b(z << 4);
        final int centerX = (x + offX + 1 & 0xFFFFFFFC) - offX;
        final int centerZ = (z + offZ + 1 & 0xFFFFFFFC) - offZ;
        if (x <= centerX + 1 && x >= centerX - 1 && z <= centerZ + 1 && z >= centerZ - 1) {
            return iArea.func_202678_a(centerX, centerZ);
        }
        return iArea.func_202678_a(x, z);
    }
}
