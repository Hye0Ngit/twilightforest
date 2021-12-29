// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import java.util.function.Function;
import java.util.stream.Collectors;
import twilightforest.world.registration.biomes.BiomeMaker;
import net.minecraft.world.level.chunk.ChunkGenerator;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.world.level.biome.BiomeZoomer;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.biome.FuzzyOffsetBiomeZoomer;
import java.util.OptionalLong;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import twilightforest.world.components.TFBiomeProvider;
import net.minecraft.core.MappedRegistry;
import com.mojang.serialization.Lifecycle;
import twilightforest.world.registration.TFDimensions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.NoiseSlideSettings;
import net.minecraft.world.level.levelgen.NoiseSamplingSettings;
import net.minecraft.world.level.levelgen.StructureSettings;
import com.google.common.collect.ImmutableMap;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;
import net.minecraft.world.level.dimension.LevelStem;
import com.mojang.serialization.Encoder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import twilightforest.world.registration.ConfiguredWorldCarvers;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import twilightforest.world.registration.ConfiguredSurfaceBuilders;
import net.minecraft.core.Registry;
import net.minecraft.data.HashCache;
import com.google.gson.Gson;
import com.mojang.serialization.DynamicOps;
import net.minecraft.core.RegistryAccess;
import java.util.Objects;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataGenerator;
import com.google.gson.JsonElement;

public class TwilightWorldDataCompiler extends WorldDataCompilerAndOps<JsonElement>
{
    public TwilightWorldDataCompiler(final DataGenerator generator) {
        final JsonOps instance = JsonOps.INSTANCE;
        final Gson gson = TwilightWorldDataCompiler.GSON;
        Objects.requireNonNull(gson);
        super(generator, (com.mojang.serialization.DynamicOps<JsonElement>)instance, gson::toJson, (RegistryAccess)new RegistryAccess.RegistryHolder());
    }
    
    @Override
    public void generate(final HashCache directoryCache) {
        ConfiguredSurfaceBuilders.registerConfigurations((Registry<ConfiguredSurfaceBuilder<?>>)this.dynamicRegistries.m_175515_(Registry.f_122879_));
        ConfiguredWorldCarvers.registerConfigurations((Registry<ConfiguredWorldCarver<?>>)this.dynamicRegistries.m_175515_(Registry.f_122880_));
        final Map<ResourceLocation, Biome> biomes = this.getBiomes();
        biomes.forEach((rl, biome) -> this.dynamicRegistries.m_6632_(Registry.f_122885_).ifPresent(reg -> Registry.m_122965_(reg, rl, (Object)biome)));
        biomes.forEach((rl, biome) -> this.serialize((net.minecraft.resources.ResourceKey<? extends net.minecraft.core.Registry<Biome>>)Registry.f_122885_, rl, biome, (com.mojang.serialization.Encoder<Biome>)Biome.f_47429_));
        this.getDimensions().forEach((rl, dimension) -> this.serialize((net.minecraft.resources.ResourceKey<? extends net.minecraft.core.Registry<LevelStem>>)Registry.f_122820_, rl, dimension, (com.mojang.serialization.Encoder<LevelStem>)LevelStem.f_63970_));
    }
    
    @Override
    protected JsonElement intercept(final ResourceKey<?> key, final JsonElement json) {
        if (key == Registry.f_122820_) {
            json.getAsJsonObject().get("generator").getAsJsonObject().get("wrapped_generator").getAsJsonObject().get("biome_source").getAsJsonObject().remove("seed");
        }
        return super.intercept(key, json);
    }
    
    private Map<ResourceLocation, LevelStem> getDimensions() {
        final NoiseGeneratorSettings forestDimensionSettings = WorldDataCompilerAndOps.makeDimensionSettings(new StructureSettings((Optional)Optional.empty(), (Map)ImmutableMap.of()), NoiseSettings.m_158704_(-32, 128, new NoiseSamplingSettings(0.9999999814507745, 0.9999999814507745, 80.0, 160.0), new NoiseSlideSettings(-10, 3, 0), new NoiseSlideSettings(15, 3, 0), 1, 2, 1.0, -0.95, true, true, false, false), Blocks.f_50069_.m_49966_(), Blocks.f_49990_.m_49966_(), Integer.MIN_VALUE, 0, 0, -32, false, false, false, false, false, false);
        final NoiseGeneratorSettings skyDimensionSettings = WorldDataCompilerAndOps.makeDimensionSettings(new StructureSettings((Optional)Optional.empty(), (Map)ImmutableMap.of()), NoiseSettings.m_158704_(-16, 16, new NoiseSamplingSettings(3.0, 1.0, 256.0, 16.0), new NoiseSlideSettings(-3000, 92, -66), new NoiseSlideSettings(-30, 7, 1), 2, 1, 0.3, -0.2, true, false, false, false), Blocks.f_50069_.m_49966_(), Blocks.f_49990_.m_49966_(), Integer.MIN_VALUE, Integer.MAX_VALUE, 0, -32, false, false, false, false, false, false);
        this.getOrCreateInRegistry((net.minecraft.core.Registry<NoiseGeneratorSettings>)this.dynamicRegistries.m_175515_(Registry.f_122878_), (net.minecraft.resources.ResourceKey<NoiseGeneratorSettings>)ResourceKey.m_135785_(Registry.f_122878_, TwilightForestMod.prefix("forest_noise_config")), () -> forestDimensionSettings);
        this.getOrCreateInRegistry((net.minecraft.core.Registry<NoiseGeneratorSettings>)this.dynamicRegistries.m_175515_(Registry.f_122878_), (net.minecraft.resources.ResourceKey<NoiseGeneratorSettings>)ResourceKey.m_135785_(Registry.f_122878_, TwilightForestMod.prefix("sky_noise_config")), () -> skyDimensionSettings);
        TFDimensions.init();
        final NoiseBasedChunkGenerator forestChunkGen = new NoiseBasedChunkGenerator((BiomeSource)new TFBiomeProvider(0L, (Registry<Biome>)new MappedRegistry(Registry.f_122885_, Lifecycle.experimental())), 0L, () -> forestDimensionSettings);
        final NoiseBasedChunkGenerator skyChunkGen = new NoiseBasedChunkGenerator((BiomeSource)new TFBiomeProvider(0L, (Registry<Biome>)new MappedRegistry(Registry.f_122885_, Lifecycle.experimental())), 0L, () -> skyDimensionSettings);
        final DimensionType twilightType = DimensionType.m_156699_(OptionalLong.of(13000L), true, false, false, true, 0.125, false, false, true, true, false, -32, 288, 288, (BiomeZoomer)FuzzyOffsetBiomeZoomer.INSTANCE, new ResourceLocation("infiniburn_overworld"), TwilightForestMod.prefix("renderer"), 0.0f);
        this.getOrCreateInRegistry((net.minecraft.core.Registry<DimensionType>)this.dynamicRegistries.m_175515_(Registry.f_122818_), (net.minecraft.resources.ResourceKey<DimensionType>)ResourceKey.m_135785_(Registry.f_122818_, new ResourceLocation("twilightforest", "forest_type")), () -> twilightType);
        return (Map<ResourceLocation, LevelStem>)ImmutableMap.of((Object)TwilightForestMod.prefix("twilight_forest"), (Object)new LevelStem(() -> twilightType, (ChunkGenerator)new ChunkGeneratorTwilight((ChunkGenerator)forestChunkGen, true, true, Optional.of(12), true)));
    }
    
    private Map<ResourceLocation, Biome> getBiomes() {
        return BiomeMaker.BIOMES.entrySet().stream().peek(registryKeyBiomeEntry -> registryKeyBiomeEntry.getValue().setRegistryName(registryKeyBiomeEntry.getKey().m_135782_())).collect(Collectors.toMap(entry -> entry.getKey().m_135782_(), (Function<? super Object, ? extends Biome>)Map.Entry::getValue));
    }
}
