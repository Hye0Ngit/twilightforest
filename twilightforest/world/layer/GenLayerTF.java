// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.GenLayer;

public abstract class GenLayerTF extends GenLayer
{
    public GenLayerTF(final long l) {
        super(l);
    }
    
    public static GenLayer[] makeTheWorld(final long l) {
        GenLayer biomes = new GenLayerTFBiomes1Point7(1L);
        biomes = new GenLayerTFKeyBiomes(1000L, biomes);
        biomes = new GenLayerTFCompanionBiomes(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerTFBiomeStabilize(700L, biomes);
        biomes = new GenLayerTFThornBorder(500L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        GenLayer riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (GenLayer)new GenLayerSmooth(7000L, riverLayer);
        biomes = new GenLayerTFRiverMix(100L, biomes, riverLayer);
        final GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        biomes.func_75905_a(l);
        genlayervoronoizoom.func_75905_a(l);
        return new GenLayer[] { biomes, genlayervoronoizoom };
    }
    
    public static GenLayer[] makeTheWorldOldMapGen(final long l) {
        GenLayer biomes = new GenLayerTFBiomes(1L);
        biomes = (GenLayer)new GenLayerZoom(1000L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerTFBiomeStabilize(700L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1002L, biomes);
        biomes = new GenLayerTFBiomeBorders(500L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1003L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1004L, biomes);
        biomes = (GenLayer)new GenLayerZoom(1005L, biomes);
        GenLayer riverLayer = new GenLayerTFStream(1L, biomes);
        riverLayer = (GenLayer)new GenLayerSmooth(7000L, riverLayer);
        biomes = new GenLayerTFRiverMix(100L, biomes, riverLayer);
        final GenLayer genlayervoronoizoom = (GenLayer)new GenLayerVoronoiZoom(10L, biomes);
        biomes.func_75905_a(l);
        genlayervoronoizoom.func_75905_a(l);
        return new GenLayer[] { biomes, genlayervoronoizoom };
    }
}
