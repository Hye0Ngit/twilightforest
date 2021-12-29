// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenTaiga2;
import twilightforest.world.TFGenLargeWinter;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class TFBiomeSnow extends TFBiomeBase
{
    public TFBiomeSnow(final int i) {
        super(i);
        this.getTFBiomeDecorator().setTreesPerChunk(7);
        this.getTFBiomeDecorator().setGrassPerChunk(1);
        this.field_76750_F = 0.125f;
        this.field_76751_G = 0.9f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().field_76808_K = false;
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenerator)new WorldGenTaiga1();
        }
        if (random.nextInt(8) == 0) {
            return new TFGenLargeWinter();
        }
        return (WorldGenerator)new WorldGenTaiga2(true);
    }
    
    public boolean func_76746_c() {
        return true;
    }
    
    public boolean func_76738_d() {
        return false;
    }
}
