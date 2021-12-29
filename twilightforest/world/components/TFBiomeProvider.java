// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components;

import com.google.common.collect.ImmutableList;
import twilightforest.world.registration.biomes.BiomeKeys;
import com.mojang.datafixers.kinds.Applicative;
import net.minecraft.resources.RegistryLookupCodec;
import twilightforest.world.registration.TFDimensions;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Supplier;
import net.minecraft.world.level.newbiome.area.LazyArea;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import twilightforest.world.components.layer.GenLayerTFRiverMix;
import net.minecraft.world.level.newbiome.layer.SmoothLayer;
import twilightforest.world.components.layer.GenLayerTFStream;
import twilightforest.world.components.layer.GenLayerTFThornBorder;
import twilightforest.world.components.layer.GenLayerTFBiomeStabilize;
import net.minecraft.world.level.newbiome.layer.ZoomLayer;
import twilightforest.world.components.layer.GenLayerTFCompanionBiomes;
import twilightforest.world.components.layer.GenLayerTFKeyBiomes;
import twilightforest.world.components.layer.GenLayerTFBiomes;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.area.Area;
import java.util.function.LongFunction;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Objects;
import java.util.function.Function;
import net.minecraft.world.level.newbiome.layer.Layer;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import java.util.List;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.biome.BiomeSource;

public class TFBiomeProvider extends BiomeSource
{
    public static final Codec<TFBiomeProvider> TF_CODEC;
    private static final List<ResourceKey<Biome>> BIOMES;
    private final Registry<Biome> registry;
    private final Layer genBiomes;
    private final long seed;
    
    public TFBiomeProvider(final long seed, final Registry<Biome> registryIn) {
        final Stream<Object> map = TFBiomeProvider.BIOMES.stream().map((Function<? super Object, ?>)ResourceKey::m_135782_);
        Objects.requireNonNull(registryIn);
        super((Stream)map.map((Function<? super Object, ?>)registryIn::m_6612_).filter(Optional::isPresent).map(opt -> {
            Objects.requireNonNull(opt);
            return opt::get;
        }));
        this.seed = seed;
        this.registry = registryIn;
        this.genBiomes = makeLayers(seed, registryIn);
    }
    
    public static int getBiomeId(final ResourceKey<Biome> biome, final Registry<Biome> registry) {
        return registry.m_7447_((Object)registry.m_6246_((ResourceKey)biome));
    }
    
    private static <T extends Area, C extends BigContext<T>> AreaFactory<T> makeLayers(final LongFunction<C> seed, final Registry<Biome> registry, final long rawSeed) {
        AreaFactory<T> biomes = (AreaFactory<T>)GenLayerTFBiomes.INSTANCE.setup(registry).m_76984_((BigContext)seed.apply(1L));
        biomes = (AreaFactory<T>)GenLayerTFKeyBiomes.INSTANCE.setup(registry, rawSeed).m_77002_((BigContext)seed.apply(1000L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)GenLayerTFCompanionBiomes.INSTANCE.setup(registry).m_77002_((BigContext)seed.apply(1000L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)ZoomLayer.NORMAL.m_77002_((BigContext)seed.apply(1000L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)ZoomLayer.NORMAL.m_77002_((BigContext)seed.apply(1001L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)GenLayerTFBiomeStabilize.INSTANCE.m_77002_((BigContext)seed.apply(700L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)GenLayerTFThornBorder.INSTANCE.setup(registry).m_77002_((BigContext)seed.apply(500L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)ZoomLayer.NORMAL.m_77002_((BigContext)seed.apply(1002L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)ZoomLayer.NORMAL.m_77002_((BigContext)seed.apply(1003L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)ZoomLayer.NORMAL.m_77002_((BigContext)seed.apply(1004L), (AreaFactory)biomes);
        biomes = (AreaFactory<T>)ZoomLayer.NORMAL.m_77002_((BigContext)seed.apply(1005L), (AreaFactory)biomes);
        AreaFactory<T> riverLayer = (AreaFactory<T>)GenLayerTFStream.INSTANCE.setup(registry).m_77002_((BigContext)seed.apply(1L), (AreaFactory)biomes);
        riverLayer = (AreaFactory<T>)SmoothLayer.INSTANCE.m_77002_((BigContext)seed.apply(7000L), (AreaFactory)riverLayer);
        biomes = (AreaFactory<T>)GenLayerTFRiverMix.INSTANCE.setup(registry).m_77020_((BigContext)seed.apply(100L), (AreaFactory)biomes, (AreaFactory)riverLayer);
        return biomes;
    }
    
    public static Layer makeLayers(final long seed, final Registry<Biome> registry) {
        final AreaFactory<LazyArea> areaFactory = makeLayers(context -> new LazyAreaContext(25, seed, context), registry, seed);
        return new Layer(areaFactory) {
            public Biome m_76715_(final Registry<Biome> p_242936_1_, final int p_242936_2_, final int p_242936_3_) {
                final int i = this.f_76711_.m_7929_(p_242936_2_, p_242936_3_);
                final Biome biome = (Biome)registry.m_7942_(i);
                if (biome == null) {
                    throw new IllegalStateException("Unknown biome id emitted by layers: " + i);
                }
                return biome;
            }
        };
    }
    
    protected Codec<? extends BiomeSource> m_5820_() {
        return TFBiomeProvider.TF_CODEC;
    }
    
    public BiomeSource m_7206_(final long l) {
        return new TFBiomeProvider(l, this.registry);
    }
    
    public Biome m_7158_(final int x, final int y, final int z) {
        return this.genBiomes.m_76715_((Registry)this.registry, x, z);
    }
    
    static {
        TF_CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.LONG.fieldOf("seed").stable().orElseGet(() -> TFDimensions.seed).forGetter(obj -> obj.seed), (App)RegistryLookupCodec.m_135622_(Registry.f_122885_).forGetter(provider -> provider.registry)).apply((Applicative)instance, instance.stable((Object)TFBiomeProvider::new)));
        BIOMES = (List)ImmutableList.of((Object)BiomeKeys.LAKE, (Object)BiomeKeys.FOREST, (Object)BiomeKeys.DENSE_FOREST, (Object)BiomeKeys.HIGHLANDS, (Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeKeys.SWAMP, (Object)BiomeKeys.STREAM, (Object)BiomeKeys.SNOWY_FOREST, (Object)BiomeKeys.GLACIER, (Object)BiomeKeys.CLEARING, (Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeKeys.FIREFLY_FOREST, (Object[])new ResourceKey[] { BiomeKeys.DENSE_MUSHROOM_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.ENCHANTED_FOREST, BiomeKeys.FIRE_SWAMP, BiomeKeys.DARK_FOREST_CENTER, BiomeKeys.FINAL_PLATEAU, BiomeKeys.THORNLANDS, BiomeKeys.SPOOKY_FOREST });
    }
}
