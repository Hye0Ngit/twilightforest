// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer1;

public enum GenLayerTFBiomeStabilize implements AreaTransformer1
{
    INSTANCE;
    
    public int m_6320_(final int x) {
        return x & 0x3;
    }
    
    public int m_6317_(final int z) {
        return z & 0x3;
    }
    
    public int m_7591_(final BigContext<?> iExtendedNoiseRandom, final Area iArea, final int x, final int z) {
        final int offX = this.m_6320_(x << 4);
        final int offZ = this.m_6317_(z << 4);
        final int centerX = (x + offX + 1 & 0xFFFFFFFC) - offX;
        final int centerZ = (z + offZ + 1 & 0xFFFFFFFC) - offZ;
        if (x <= centerX + 1 && x >= centerX - 1 && z <= centerZ + 1 && z >= centerZ - 1) {
            return iArea.m_7929_(centerX, centerZ);
        }
        return iArea.m_7929_(x, z);
    }
}
