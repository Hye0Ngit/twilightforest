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
import twilightforest.world.components.layer.GenLayerTFBiomes;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.area.Area;
import java.util.function.LongFunction;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Objects;
import java.util.function.Function;
import net.minecraft.resources.ResourceKey;
import java.util.List;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.world.level.newbiome.layer.Layer;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.biome.BiomeSource;

public class TFBiomeDistributor extends BiomeSource
{
    public static final Codec<TFBiomeDistributor> TF_CODEC;
    private final long seed;
    private final Layer genBiomes;
    private final Registry<Biome> registry;
    private static final List<ResourceKey<Biome>> BIOMES;
    
    public TFBiomeDistributor(final long seed, final Registry<Biome> registryIn) {
        final Stream<Object> map = TFBiomeDistributor.BIOMES.stream().map((Function<? super Object, ?>)ResourceKey::m_135782_);
        Objects.requireNonNull(registryIn);
        super((Stream)map.map((Function<? super Object, ?>)registryIn::m_6612_).filter(Optional::isPresent).map(opt -> {
            Objects.requireNonNull(opt);
            return opt::get;
        }));
        this.seed = seed;
        this.registry = registryIn;
        this.genBiomes = makeLayers(seed, registryIn);
    }
    
    private static <T extends Area, C extends BigContext<T>> AreaFactory<T> makeLayers(final LongFunction<C> seed, final Registry<Biome> registry) {
        final AreaFactory<T> biomes = (AreaFactory<T>)GenLayerTFBiomes.INSTANCE.setup(registry).m_76984_((BigContext)seed.apply(1L));
        return biomes;
    }
    
    public static Layer makeLayers(final long seed, final Registry<Biome> registry) {
        final AreaFactory<LazyArea> areaFactory = makeLayers(context -> new LazyAreaContext(25, seed, context), registry);
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
        return TFBiomeDistributor.TF_CODEC;
    }
    
    public BiomeSource m_7206_(final long seed) {
        return new TFBiomeDistributor(seed, this.registry);
    }
    
    public Biome m_7158_(final int x, final int y, final int z) {
        return this.genBiomes.m_76715_((Registry)this.registry, x, y);
    }
    
    static {
        TF_CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.LONG.fieldOf("seed").stable().orElseGet(() -> TFDimensions.seed).forGetter(obj -> obj.seed), (App)RegistryLookupCodec.m_135622_(Registry.f_122885_).forGetter(provider -> provider.registry)).apply((Applicative)instance, instance.stable((Object)TFBiomeDistributor::new)));
        BIOMES = (List)ImmutableList.of((Object)BiomeKeys.LAKE, (Object)BiomeKeys.FOREST, (Object)BiomeKeys.DENSE_FOREST, (Object)BiomeKeys.HIGHLANDS, (Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeKeys.SWAMP, (Object)BiomeKeys.STREAM, (Object)BiomeKeys.SNOWY_FOREST, (Object)BiomeKeys.GLACIER, (Object)BiomeKeys.CLEARING, (Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeKeys.FIREFLY_FOREST, (Object[])new ResourceKey[] { BiomeKeys.DENSE_MUSHROOM_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.ENCHANTED_FOREST, BiomeKeys.FIRE_SWAMP, BiomeKeys.DARK_FOREST_CENTER, BiomeKeys.FINAL_PLATEAU, BiomeKeys.THORNLANDS, BiomeKeys.SPOOKY_FOREST });
    }
}
