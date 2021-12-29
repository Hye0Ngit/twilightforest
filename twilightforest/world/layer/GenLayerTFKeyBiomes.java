// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import twilightforest.world.TFBiomeProvider;
import twilightforest.worldgen.biomes.BiomeKeys;
import twilightforest.world.TFDimensions;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import java.util.Random;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public enum GenLayerTFKeyBiomes implements IAreaTransformer1
{
    INSTANCE;
    
    private Registry<Biome> registry;
    private static final Random RANDOM;
    
    public GenLayerTFKeyBiomes setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int func_215721_a(final int x) {
        return x | 0x3;
    }
    
    public int func_215722_b(final int z) {
        return z | 0x3;
    }
    
    public int func_215728_a(final IExtendedNoiseRandom<?> random, final IArea iArea, final int x, final int z) {
        GenLayerTFKeyBiomes.RANDOM.setSeed(TFDimensions.seed + (x & 0xFFFFFFFC) * 25117 + (z & 0xFFFFFFFC) * 151121);
        final int ox = GenLayerTFKeyBiomes.RANDOM.nextInt(2) + 1;
        final int oz = GenLayerTFKeyBiomes.RANDOM.nextInt(2) + 1;
        GenLayerTFKeyBiomes.RANDOM.setSeed(TFDimensions.seed + x / 8 * 25117 + z / 8 * 151121);
        final int offset = GenLayerTFKeyBiomes.RANDOM.nextInt(3);
        if ((x & 0x3) != ox || (z & 0x3) != oz) {
            return iArea.func_202678_a(x, z);
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
        switch (index & 0x3) {
            default: {
                return TFBiomeProvider.getBiomeId(BiomeKeys.GLACIER, this.registry);
            }
            case 1: {
                return TFBiomeProvider.getBiomeId(BiomeKeys.FIRE_SWAMP, this.registry);
            }
            case 2: {
                return TFBiomeProvider.getBiomeId(BiomeKeys.DARK_FOREST_CENTER, this.registry);
            }
            case 3: {
                return TFBiomeProvider.getBiomeId(BiomeKeys.FINAL_PLATEAU, this.registry);
            }
        }
    }
    
    static {
        RANDOM = new Random();
    }
}
