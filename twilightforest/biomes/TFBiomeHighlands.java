// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class TFBiomeHighlands extends TFBiomeBase
{
    public TFBiomeHighlands(final int i) {
        super(i);
        this.field_76748_D = 2.5f;
        this.field_76749_E = 0.4f;
        this.field_76750_F = 0.5f;
        this.field_76751_G = 0.3f;
        ((TFBiomeDecorator)this.field_76760_I).canopyPerChunk = -999;
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenBigTree(false);
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenTaiga2(true);
        }
        return (WorldGenerator)this.field_76764_P;
    }
}
