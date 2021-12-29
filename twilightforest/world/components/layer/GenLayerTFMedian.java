// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer1;

public enum GenLayerTFMedian implements AreaTransformer1
{
    INSTANCE;
    
    public int m_7591_(final BigContext<?> iExtendedNoiseRandom, final Area iArea, final int x, final int z) {
        final int[] biomes = new int[9];
        for (int pos = 0; pos < 9; ++pos) {
            biomes[pos] = iArea.m_7929_(x + pos % 3, z + pos / 3);
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
            if (biomeRecordCount == iterationQuantity && (index == 5 || (biomeRecordIndex != 5 && iExtendedNoiseRandom.m_5826_(2) == 0))) {
                biomeRecordIndex = index;
            }
            if (biomeRecordCount > iterationQuantity) {
                biomeRecordIndex = index;
                biomeRecordCount = iterationQuantity;
            }
        }
        return biomes[biomeRecordIndex];
    }
    
    public int m_6320_(final int x) {
        return x;
    }
    
    public int m_6317_(final int z) {
        return z;
    }
}
