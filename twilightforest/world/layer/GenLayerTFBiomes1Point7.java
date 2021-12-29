// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.gen.layer.IntCache;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerTFBiomes1Point7 extends GenLayer
{
    private static final int RARE_BIOME_CHANCE = 15;
    protected BiomeGenBase[] commonBiomes;
    protected BiomeGenBase[] rareBiomes;
    
    public GenLayerTFBiomes1Point7(final long l, final GenLayer genlayer) {
        super(l);
        this.commonBiomes = new BiomeGenBase[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.mushrooms, TFBiomeBase.oakSavanna, TFBiomeBase.lightedForest };
        this.rareBiomes = new BiomeGenBase[] { TFBiomeBase.tfLake, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest };
        this.field_75909_a = genlayer;
    }
    
    public GenLayerTFBiomes1Point7(final long l) {
        super(l);
        this.commonBiomes = new BiomeGenBase[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.mushrooms, TFBiomeBase.oakSavanna, TFBiomeBase.lightedForest };
        this.rareBiomes = new BiomeGenBase[] { TFBiomeBase.tfLake, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest };
    }
    
    public int[] func_75904_a(final int x, final int z, final int width, final int depth) {
        final int[] dest = IntCache.func_76445_a(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.func_75903_a((long)(dx + x), (long)(dz + z));
                if (this.func_75902_a(15) == 0) {
                    dest[dx + dz * width] = this.rareBiomes[this.func_75902_a(this.rareBiomes.length)].field_76756_M;
                }
                else {
                    dest[dx + dz * width] = this.commonBiomes[this.func_75902_a(this.commonBiomes.length)].field_76756_M;
                }
            }
        }
        return dest;
    }
}
