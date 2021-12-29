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
import twilightforest.world.layer.GenLayerTFBiomes;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import java.util.function.LongFunction;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.util.RegistryKey;
import java.util.List;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.layer.Layer;
import com.mojang.serialization.Codec;
import net.minecraft.world.biome.provider.BiomeProvider;

public class TFBiomeDistributor extends BiomeProvider
{
    public static final Codec<TFBiomeDistributor> TF_CODEC;
    private final long seed;
    private final Layer genBiomes;
    private final Registry<Biome> registry;
    private static final List<RegistryKey<Biome>> BIOMES;
    
    public TFBiomeDistributor(final long seed, final Registry<Biome> registryIn) {
        super((Stream)TFBiomeDistributor.BIOMES.stream().map((Function<? super Object, ?>)RegistryKey::func_240901_a_).map((Function<? super Object, ?>)registryIn::func_241873_b).filter(Optional::isPresent).map(opt -> opt::get));
        this.seed = seed;
        this.registry = registryIn;
        this.genBiomes = makeLayers(seed, registryIn);
    }
    
    private static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> makeLayers(final LongFunction<C> seed, final Registry<Biome> registry) {
        final IAreaFactory<T> biomes = (IAreaFactory<T>)GenLayerTFBiomes.INSTANCE.setup(registry).func_202823_a((IExtendedNoiseRandom)seed.apply(1L));
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
        return TFBiomeDistributor.TF_CODEC;
    }
    
    public BiomeProvider func_230320_a_(final long seed) {
        return new TFBiomeDistributor(seed, this.registry);
    }
    
    public Biome func_225526_b_(final int x, final int y, final int z) {
        return this.genBiomes.func_242936_a((Registry)this.registry, x, y);
    }
    
    static {
        TF_CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.LONG.fieldOf("seed").stable().orElseGet(() -> TFDimensions.seed).forGetter(obj -> obj.seed), (App)RegistryLookupCodec.func_244331_a(Registry.field_239720_u_).forGetter(provider -> provider.registry)).apply((Applicative)instance, instance.stable((Object)TFBiomeDistributor::new)));
        BIOMES = (List)ImmutableList.of((Object)BiomeKeys.LAKE, (Object)BiomeKeys.FOREST, (Object)BiomeKeys.DENSE_FOREST, (Object)BiomeKeys.HIGHLANDS, (Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeKeys.SWAMP, (Object)BiomeKeys.STREAM, (Object)BiomeKeys.SNOWY_FOREST, (Object)BiomeKeys.GLACIER, (Object)BiomeKeys.CLEARING, (Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeKeys.FIREFLY_FOREST, (Object[])new RegistryKey[] { BiomeKeys.DENSE_MUSHROOM_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.ENCHANTED_FOREST, BiomeKeys.FIRE_SWAMP, BiomeKeys.DARK_FOREST_CENTER, BiomeKeys.FINAL_PLATEAU, BiomeKeys.THORNLANDS, BiomeKeys.SPOOKY_FOREST });
    }
}
