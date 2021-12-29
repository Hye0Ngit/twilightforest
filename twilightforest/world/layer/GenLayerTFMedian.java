// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public enum GenLayerTFMedian implements IAreaTransformer1
{
    INSTANCE;
    
    public int func_215728_a(final IExtendedNoiseRandom<?> iExtendedNoiseRandom, final IArea iArea, final int x, final int z) {
        final int[] biomes = new int[9];
        for (int pos = 0; pos < 9; ++pos) {
            biomes[pos] = iArea.func_202678_a(x + pos % 3, z + pos / 3);
        }
        int biomeRecordIndex = 0;
        int biomeRecordCount = 0;
        for (int index = 0; index < 9; ++index) {
            int iterationQuantity = 0;
            for (int test = 0; test < 9; ++test) {
                if (biomes[index] == biomes[test] && ++iterationQuantity > 4) {
                    return biomes[index];
                }
            }
            if (biomeRecordCount == iterationQuantity && (index == 5 || (biomeRecordIndex != 5 && iExtendedNoiseRandom.func_202696_a(2) == 0))) {
                biomeRecordIndex = index;
            }
            if (biomeRecordCount > iterationQuantity) {
                biomeRecordIndex = index;
                biomeRecordCount = iterationQuantity;
            }
        }
        return biomes[biomeRecordIndex];
    }
    
    public int func_215721_a(final int x) {
        return x;
    }
    
    public int func_215722_b(final int z) {
        return z;
    }
}
