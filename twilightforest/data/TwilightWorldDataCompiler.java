// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import java.util.function.Function;
import java.util.stream.Collectors;
import twilightforest.worldgen.biomes.BiomeMaker;
import net.minecraft.world.DimensionType;
import twilightforest.world.ChunkGeneratorTwilightBase;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import java.util.OptionalLong;
import java.util.function.Supplier;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.biome.provider.BiomeProvider;
import twilightforest.world.ChunkGeneratorTwilightForest;
import twilightforest.world.TFBiomeProvider;
import net.minecraft.util.registry.SimpleRegistry;
import com.mojang.serialization.Lifecycle;
import twilightforest.world.TFDimensions;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.settings.NoiseSettings;
import net.minecraft.world.gen.settings.SlideSettings;
import net.minecraft.world.gen.settings.ScalingSettings;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import com.google.common.collect.ImmutableMap;
import java.util.Optional;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.world.Dimension;
import com.mojang.serialization.Encoder;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import twilightforest.worldgen.ConfiguredSurfaceBuilders;
import net.minecraft.util.registry.Registry;
import net.minecraft.data.DirectoryCache;
import com.mojang.serialization.DynamicOps;
import net.minecraft.util.registry.DynamicRegistries;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.DataGenerator;
import com.google.gson.JsonElement;

public class TwilightWorldDataCompiler extends WorldDataCompilerAndOps<JsonElement>
{
    public TwilightWorldDataCompiler(final DataGenerator generator) {
        super(generator, (com.mojang.serialization.DynamicOps<JsonElement>)JsonOps.INSTANCE, TwilightWorldDataCompiler.GSON::toJson, (DynamicRegistries)new DynamicRegistries.Impl());
    }
    
    @Override
    public void generate(final DirectoryCache directoryCache) {
        ConfiguredSurfaceBuilders.registerConfigurations((Registry<ConfiguredSurfaceBuilder<?>>)this.field_240895_b_.func_243612_b(Registry.field_243550_as));
        this.getBiomes().forEach((rl, biome) -> this.serialize((net.minecraft.util.RegistryKey<? extends net.minecraft.util.registry.Registry<Biome>>)Registry.field_239720_u_, rl, biome, (com.mojang.serialization.Encoder<Biome>)Biome.field_242418_b));
        this.getDimensions().forEach((rl, dimension) -> this.serialize((net.minecraft.util.RegistryKey<? extends net.minecraft.util.registry.Registry<Dimension>>)Registry.field_239700_af_, rl, dimension, (com.mojang.serialization.Encoder<Dimension>)Dimension.field_236052_a_));
    }
    
    private Map<ResourceLocation, Dimension> getDimensions() {
        final Optional<DimensionSettings> forestDimensionSettings = WorldDataCompilerAndOps.makeDimensionSettings(new DimensionStructuresSettings((Optional)Optional.empty(), (Map)ImmutableMap.of()), new NoiseSettings(128, new ScalingSettings(0.9999999814507745, 0.9999999814507745, 80.0, 160.0), new SlideSettings(-10, 3, 0), new SlideSettings(-30, 0, 0), 1, 2, 1.0, -0.46875, false, true, false, false), Blocks.field_150348_b.func_176223_P(), Blocks.field_150355_j.func_176223_P(), -20, 0, 31, false);
        final Optional<DimensionSettings> skyDimensionSettings = WorldDataCompilerAndOps.makeDimensionSettings(new DimensionStructuresSettings((Optional)Optional.empty(), (Map)ImmutableMap.of()), new NoiseSettings(128, new ScalingSettings(3.0, 1.0, 256.0, 16.0), new SlideSettings(-3000, 92, -66), new SlideSettings(-30, 7, 1), 2, 1, 0.3, -0.2, true, false, false, false), Blocks.field_150348_b.func_176223_P(), Blocks.field_150355_j.func_176223_P(), -20, -20, 0, false);
        this.getOrCreateInRegistry((net.minecraft.util.registry.Registry<Object>)this.field_240895_b_.func_243612_b(Registry.field_243549_ar), (net.minecraft.util.RegistryKey<Object>)RegistryKey.func_240903_a_(Registry.field_243549_ar, TwilightForestMod.prefix("forest_noise_config")), forestDimensionSettings::get);
        this.getOrCreateInRegistry((net.minecraft.util.registry.Registry<Object>)this.field_240895_b_.func_243612_b(Registry.field_243549_ar), (net.minecraft.util.RegistryKey<Object>)RegistryKey.func_240903_a_(Registry.field_243549_ar, TwilightForestMod.prefix("sky_noise_config")), skyDimensionSettings::get);
        TFDimensions.init();
        final ChunkGeneratorTwilightBase forestChunkGen = new ChunkGeneratorTwilightForest(new TFBiomeProvider(0L, (Registry<Biome>)new SimpleRegistry(Registry.field_239720_u_, Lifecycle.experimental())), 0L, forestDimensionSettings::get);
        final NoiseChunkGenerator skyChunkGen = new NoiseChunkGenerator((BiomeProvider)new TFBiomeProvider(0L, (Registry<Biome>)new SimpleRegistry(Registry.field_239720_u_, Lifecycle.experimental())), 0L, (Supplier)skyDimensionSettings::get);
        final Optional<DimensionType> twilightType = WorldDataCompilerAndOps.makeDimensionType(OptionalLong.of(13000L), true, false, false, true, 0.125, false, false, true, true, false, 256, (IBiomeMagnifier)FuzzedBiomeMagnifier.INSTANCE, new ResourceLocation("infiniburn_overworld"), TwilightForestMod.prefix("renderer"), 0.0f);
        this.getOrCreateInRegistry((net.minecraft.util.registry.Registry<Object>)this.field_240895_b_.func_243612_b(Registry.field_239698_ad_), (net.minecraft.util.RegistryKey<Object>)RegistryKey.func_240903_a_(Registry.field_239698_ad_, new ResourceLocation("twilightforest", "forest_type")), twilightType::get);
        return (Map<ResourceLocation, Dimension>)ImmutableMap.of((Object)TwilightForestMod.prefix("twilightforest"), (Object)new Dimension((Supplier)twilightType::get, (ChunkGenerator)forestChunkGen), (Object)TwilightForestMod.prefix("skylight_forest"), (Object)new Dimension((Supplier)twilightType::get, (ChunkGenerator)skyChunkGen));
    }
    
    private Map<ResourceLocation, Biome> getBiomes() {
        return BiomeMaker.BIOMES.entrySet().stream().peek(registryKeyBiomeEntry -> {
            final Biome biome = (Biome)registryKeyBiomeEntry.getValue().setRegistryName(registryKeyBiomeEntry.getKey().func_240901_a_());
        }).collect(Collectors.toMap(entry -> entry.getKey().func_240901_a_(), (Function<? super Object, ? extends Biome>)Map.Entry::getValue));
    }
}
