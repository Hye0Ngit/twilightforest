// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import twilightforest.world.components.TFBiomeProvider;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;
import java.util.Random;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer1;

public enum GenLayerTFKeyBiomes implements AreaTransformer1
{
    INSTANCE;
    
    private Registry<Biome> registry;
    private long seed;
    private static final Random RANDOM;
    
    public GenLayerTFKeyBiomes setup(final Registry<Biome> registry, final long seed) {
        this.registry = registry;
        this.seed = seed;
        return this;
    }
    
    public int m_6320_(final int x) {
        return x | 0x3;
    }
    
    public int m_6317_(final int z) {
        return z | 0x3;
    }
    
    public int m_7591_(final BigContext<?> random, final Area iArea, final int x, final int z) {
        GenLayerTFKeyBiomes.RANDOM.setSeed(this.seed + (x & 0xFFFFFFFC) * 25117L + (z & 0xFFFFFFFC) * 151121L);
        final int ox = GenLayerTFKeyBiomes.RANDOM.nextInt(2) + 1;
        final int oz = GenLayerTFKeyBiomes.RANDOM.nextInt(2) + 1;
        GenLayerTFKeyBiomes.RANDOM.setSeed(this.seed + x / 8 * 25117L + z / 8 * 151121L);
        final int offset = GenLayerTFKeyBiomes.RANDOM.nextInt(3);
        if ((x & 0x3) != ox || (z & 0x3) != oz) {
            return iArea.m_7929_(x, z);
        }
        if ((x & 0x4) == 0x0) {
            if ((z & 0x4) == 0x0) {
                return this.getKeyBiomeFor(offset);
            }
            return this.getKeyBiomeFor(offset + 1);
        }
        else {
            if ((z & 0x4) == 0x0) {
                return this.getKeyBiomeFor(offset + 2);
            }
            return this.getKeyBiomeFor(offset + 3);
        }
    }
    
    private int getKeyBiomeFor(final int index) {
        return switch (index & 0x3) {
            case 1 -> TFBiomeProvider.getBiomeId(BiomeKeys.FIRE_SWAMP, this.registry);
            case 2 -> TFBiomeProvider.getBiomeId(BiomeKeys.DARK_FOREST_CENTER, this.registry);
            case 3 -> TFBiomeProvider.getBiomeId(BiomeKeys.FINAL_PLATEAU, this.registry);
            default -> TFBiomeProvider.getBiomeId(BiomeKeys.GLACIER, this.registry);
        };
    }
    
    static {
        RANDOM = new Random();
    }
}
