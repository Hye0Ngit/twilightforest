// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import twilightforest.world.TFBiomeProvider;
import twilightforest.worldgen.biomes.BiomeKeys;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;

public enum GenLayerTFRiverMix implements IAreaTransformer2, IDimOffset0Transformer
{
    INSTANCE;
    
    private Registry<Biome> registry;
    
    public GenLayerTFRiverMix setup(final Registry<Biome> registry) {
        this.registry = registry;
        return this;
    }
    
    public int func_215723_a(final INoiseRandom iNoiseRandom, final IArea area1, final IArea area2, final int val1, final int val2) {
        final int biomeInputs = area1.func_202678_a(this.func_215721_a(val1), this.func_215722_b(val2));
        final int riverInputs = area2.func_202678_a(this.func_215721_a(val1), this.func_215722_b(val2));
        final int stream = TFBiomeProvider.getBiomeId(BiomeKeys.STREAM, this.registry);
        if (riverInputs == stream) {
            return riverInputs;
        }
        return biomeInputs;
    }
}
