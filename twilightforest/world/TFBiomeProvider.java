// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import com.google.common.collect.ImmutableList;
import twilightforest.worldgen.biomes.BiomeKeys;
import com.mojang.datafixers.kinds.Applicative;
import net.minecraft.util.registry.RegistryLookupCodec;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Supplier;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.LazyAreaLayerContext;
import twilightforest.world.layer.GenLayerTFRiverMix;
import net.minecraft.world.gen.layer.SmoothLayer;
import twilightforest.world.layer.GenLayerTFStream;
import twilightforest.world.layer.GenLayerTFThornBorder;
import twilightforest.world.layer.GenLayerTFBiomeStabilize;
import net.minecraft.world.gen.layer.ZoomLayer;
import twilightforest.world.layer.GenLayerTFCompanionBiomes;
import twilightforest.world.layer.GenLayerTFKeyBiomes;
import twilightforest.world.layer.GenLayerTFBiomes;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import java.util.function.LongFunction;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import java.util.List;
import com.mojang.serialization.Codec;
import net.minecraft.world.biome.provider.BiomeProvider;

public class TFBiomeProvider extends BiomeProvider
{
    public static final Codec<TFBiomeProvider> TF_CODEC;
    private static final List<RegistryKey<Biome>> BIOMES;
    private final Registry<Biome> registry;
    private final Layer genBiomes;
    private final long seed;
    
    public TFBiomeProvider(final long seed, final Registry<Biome> registryIn) {
        super((Stream)TFBiomeProvider.BIOMES.stream().map((Function<? super Object, ?>)RegistryKey::func_240901_a_).map((Function<? super Object, ?>)registryIn::func_241873_b).filter(Optional::isPresent).map(opt -> opt::get));
        this.seed = seed;
        this.registry = registryIn;
        this.genBiomes = makeLayers(seed, registryIn);
    }
    
    public static int getBiomeId(final RegistryKey<Biome> biome, final Registry<Biome> registry) {
        return registry.func_148757_b(registry.func_230516_a_((RegistryKey)biome));
    }
    
    private static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> makeLayers(final LongFunction<C> seed, final Registry<Biome> registry) {
        IAreaFactory<T> biomes = (IAreaFactory<T>)GenLayerTFBiomes.INSTANCE.setup(registry).func_202823_a((IExtendedNoiseRandom)seed.apply(1L));
        biomes = (IAreaFactory<T>)GenLayerTFKeyBiomes.INSTANCE.setup(registry).func_202713_a((IExtendedNoiseRandom)seed.apply(1000L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)GenLayerTFCompanionBiomes.INSTANCE.setup(registry).func_202713_a((IExtendedNoiseRandom)seed.apply(1000L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)ZoomLayer.NORMAL.func_202713_a((IExtendedNoiseRandom)seed.apply(1000L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)ZoomLayer.NORMAL.func_202713_a((IExtendedNoiseRandom)seed.apply(1001L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)GenLayerTFBiomeStabilize.INSTANCE.func_202713_a((IExtendedNoiseRandom)seed.apply(700L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)GenLayerTFThornBorder.INSTANCE.setup(registry).func_202713_a((IExtendedNoiseRandom)seed.apply(500L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)ZoomLayer.NORMAL.func_202713_a((IExtendedNoiseRandom)seed.apply(1002L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)ZoomLayer.NORMAL.func_202713_a((IExtendedNoiseRandom)seed.apply(1003L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)ZoomLayer.NORMAL.func_202713_a((IExtendedNoiseRandom)seed.apply(1004L), (IAreaFactory)biomes);
        biomes = (IAreaFactory<T>)ZoomLayer.NORMAL.func_202713_a((IExtendedNoiseRandom)seed.apply(1005L), (IAreaFactory)biomes);
        IAreaFactory<T> riverLayer = (IAreaFactory<T>)GenLayerTFStream.INSTANCE.setup(registry).func_202713_a((IExtendedNoiseRandom)seed.apply(1L), (IAreaFactory)biomes);
        riverLayer = (IAreaFactory<T>)SmoothLayer.INSTANCE.func_202713_a((IExtendedNoiseRandom)seed.apply(7000L), (IAreaFactory)riverLayer);
        biomes = (IAreaFactory<T>)GenLayerTFRiverMix.INSTANCE.setup(registry).func_202707_a((IExtendedNoiseRandom)seed.apply(100L), (IAreaFactory)biomes, (IAreaFactory)riverLayer);
        return biomes;
    }
    
    public static Layer makeLayers(final long seed, final Registry<Biome> registry) {
        final IAreaFactory<LazyArea> areaFactory = makeLayers(context -> new LazyAreaLayerContext(25, seed, context), registry);
        return new Layer(areaFactory) {
            public Biome func_242936_a(final Registry<Biome> p_242936_1_, final int p_242936_2_, final int p_242936_3_) {
                final int i = this.field_215742_b.func_202678_a(p_242936_2_, p_242936_3_);
                final Biome biome = (Biome)registry.func_148745_a(i);
                if (biome == null) {
                    throw new IllegalStateException("Unknown biome id emitted by layers: " + i);
                }
                return biome;
            }
        };
    }
    
    protected Codec<? extends BiomeProvider> func_230319_a_() {
        return TFBiomeProvider.TF_CODEC;
    }
    
    public BiomeProvider func_230320_a_(final long l) {
        return new TFBiomeProvider(l, this.registry);
    }
    
    public Biome func_225526_b_(final int x, final int y, final int z) {
        return this.genBiomes.func_242936_a((Registry)this.registry, x, z);
    }
    
    static {
        TF_CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.LONG.fieldOf("seed").stable().orElseGet(() -> TFDimensions.seed).forGetter(obj -> obj.seed), (App)RegistryLookupCodec.func_244331_a(Registry.field_239720_u_).forGetter(provider -> provider.registry)).apply((Applicative)instance, instance.stable((Object)TFBiomeProvider::new)));
        BIOMES = (List)ImmutableList.of((Object)BiomeKeys.LAKE, (Object)BiomeKeys.FOREST, (Object)BiomeKeys.DENSE_FOREST, (Object)BiomeKeys.HIGHLANDS, (Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeKeys.SWAMP, (Object)BiomeKeys.STREAM, (Object)BiomeKeys.SNOWY_FOREST, (Object)BiomeKeys.GLACIER, (Object)BiomeKeys.CLEARING, (Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeKeys.FIREFLY_FOREST, (Object[])new RegistryKey[] { BiomeKeys.DENSE_MUSHROOM_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.ENCHANTED_FOREST, BiomeKeys.FIRE_SWAMP, BiomeKeys.DARK_FOREST_CENTER, BiomeKeys.FINAL_PLATEAU, BiomeKeys.THORNLANDS, BiomeKeys.SPOOKY_FOREST });
    }
}
