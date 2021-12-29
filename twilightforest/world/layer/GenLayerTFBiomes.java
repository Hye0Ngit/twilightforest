// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import java.util.Arrays;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.biome.Biome;
import java.util.function.Supplier;
import java.util.List;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFBiomes extends GenLayer
{
    private static final int RARE_BIOME_CHANCE = 15;
    protected static final List<Supplier<Biome>> commonBiomes;
    protected static final List<Supplier<Biome>> rareBiomes;
    
    public GenLayerTFBiomes(final long l, final GenLayer genlayer) {
        super(l);
        this.field_75909_a = genlayer;
    }
    
    public GenLayerTFBiomes(final long l) {
        super(l);
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] dest = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.func_75903_a((long)(dx + x), (long)(dz + z));
                if (this.func_75902_a(15) == 0) {
                    dest[dx + dz * width] = Biome.func_185362_a(this.getRandomBiome(GenLayerTFBiomes.rareBiomes));
                }
                else {
                    dest[dx + dz * width] = Biome.func_185362_a(this.getRandomBiome(GenLayerTFBiomes.commonBiomes));
                }
            }
        }
        return dest;
    }
    
    private Biome getRandomBiome(final List<Supplier<Biome>> biomes) {
        return biomes.get(this.func_75902_a(biomes.size())).get();
    }
    
    static {
        commonBiomes = Arrays.asList(() -> TFBiomes.twilightForest, () -> TFBiomes.denseTwilightForest, () -> TFBiomes.mushrooms, () -> TFBiomes.oakSavanna, () -> TFBiomes.fireflyForest);
        rareBiomes = Arrays.asList(() -> TFBiomes.tfLake, () -> TFBiomes.deepMushrooms, () -> TFBiomes.enchantedForest, () -> TFBiomes.clearing, () -> TFBiomes.spookyForest);
    }
}
