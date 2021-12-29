// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.level.FoliageColor;
import twilightforest.world.components.BiomeGrassColors;
import twilightforest.world.registration.biomes.BiomeKeys;
import java.util.HashMap;
import net.minecraft.resources.ResourceLocation;
import java.util.WeakHashMap;
import net.minecraft.world.level.biome.Biome;
import java.util.Map;

public final class FoliageColorHandler
{
    private static final Map<Biome, Handler> HANDLES;
    
    public static int get(final int o, final Biome biome, final double x, final double z) {
        Handler handler = FoliageColorHandler.HANDLES.get(biome);
        if (handler == null) {
            handler = Handler.REGISTRY.getOrDefault(biome.getRegistryName(), Handler.DEFAULT);
            FoliageColorHandler.HANDLES.put(biome, handler);
        }
        return handler.apply(o, x, z);
    }
    
    static {
        HANDLES = new WeakHashMap<Biome, Handler>();
    }
    
    @FunctionalInterface
    private interface Handler
    {
        public static final Map<ResourceLocation, Handler> REGISTRY = new HashMap<ResourceLocation, Handler>() {
            {
                this.put(BiomeKeys.SPOOKY_FOREST.m_135782_(), (o, x, z) -> {
                    final double noise = (Biome.f_47433_.m_75449_(x * 0.0225, z * 0.0225, false) + 1.0) / 2.0;
                    return BiomeGrassColors.blendColors(16745729, 16252673, (noise > 0.6) ? (noise * 0.2) : noise);
                });
                this.put(BiomeKeys.ENCHANTED_FOREST.m_135782_(), (o, x, z) -> (o & 0xFFFF00) + BiomeGrassColors.getEnchantedColor((int)x, (int)z));
                this.put(BiomeKeys.DARK_FOREST_CENTER.m_135782_(), (o, x, z) -> {
                    final double noise2 = (Biome.f_47433_.m_75449_(x * 0.0225, z * 0.0225, false) + 1.0) / 2.0;
                    return (noise2 < -0.1) ? 16351774 : 15289876;
                });
                this.put(BiomeKeys.DARK_FOREST.m_135782_(), (o, x, z) -> ((FoliageColor.m_46107_(0.699999988079071, 0.800000011920929) & 0xFEFEFE) + 1969742) / 2);
                this.put(BiomeKeys.SWAMP.m_135782_(), (o, x, z) -> ((FoliageColor.m_46107_(0.800000011920929, 0.8999999761581421) & 0xFEFEFE) + 5115470) / 2);
            }
        };
        public static final Handler DEFAULT = (o, x, z) -> o;
        
        int apply(final int p0, final double p1, final double p2);
    }
}
