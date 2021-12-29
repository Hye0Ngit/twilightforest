// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.NoiseSlideSettings;
import net.minecraft.world.level.levelgen.NoiseSamplingSettings;
import com.mojang.serialization.Codec;
import net.minecraft.data.BuiltinRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.IForgeRegistryEntry;
import javax.annotation.Nullable;
import java.io.BufferedWriter;
import java.nio.file.OpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.Objects;
import java.nio.file.Path;
import java.util.Optional;
import java.io.IOException;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Encoder;
import net.minecraft.resources.ResourceLocation;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import com.mojang.serialization.DynamicOps;
import java.util.HashSet;
import net.minecraft.data.HashCache;
import net.minecraft.core.RegistryAccess;
import java.util.function.Function;
import net.minecraft.data.DataGenerator;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.RegistryWriteOps;

public abstract class WorldDataCompilerAndOps<Format> extends RegistryWriteOps<Format> implements DataProvider
{
    protected static final Logger LOGGER;
    protected static final Gson GSON;
    protected final DataGenerator generator;
    private final Function<Format, String> fileContentWriter;
    protected final RegistryAccess dynamicRegistries;
    private HashCache directoryCache;
    private final HashSet<Object> objectsSerializationCache;
    
    public WorldDataCompilerAndOps(final DataGenerator generator, final DynamicOps<Format> ops, final Function<Format, String> fileContentWriter, final RegistryAccess dynamicRegistries) {
        super((DynamicOps)ops, dynamicRegistries);
        this.objectsSerializationCache = new HashSet<Object>();
        this.generator = generator;
        this.fileContentWriter = fileContentWriter;
        this.dynamicRegistries = dynamicRegistries;
    }
    
    protected <Resource> Resource getOrCreateInRegistry(final Registry<Resource> registry, final ResourceKey<Resource> registryKey, final Supplier<Resource> resourceCreator) {
        Resource resourceSaved = getFromVanillaRegistryIllegally(registry, registryKey);
        if (resourceSaved == null) {
            resourceSaved = (Resource)Registry.m_122965_((Registry)registry, registryKey.m_135782_(), (Object)resourceCreator.get());
        }
        return resourceSaved;
    }
    
    public final void m_6865_(final HashCache directoryCache) {
        this.generate(this.directoryCache = directoryCache);
    }
    
    public abstract void generate(final HashCache p0);
    
    public <Resource> void serialize(final ResourceKey<? extends Registry<Resource>> resourceType, final ResourceLocation resourceLocation, final Resource resource, final Encoder<Resource> encoder) {
        if (this.objectsSerializationCache.contains(resource)) {
            WorldDataCompilerAndOps.LOGGER.debug("Avoiding duplicate serialization with " + resourceLocation);
            return;
        }
        this.objectsSerializationCache.add(resource);
        final Optional<Format> output = this.withEncoder((Encoder)encoder).apply(resource).setLifecycle(Lifecycle.experimental()).resultOrPartial(error -> WorldDataCompilerAndOps.LOGGER.error("Object [" + resourceType.getRegistryName() + "] " + resourceLocation + " not serialized within recursive serialization: " + error));
        if (output.isPresent()) {
            try {
                this.save(resourceType, this.directoryCache, output.get(), makePath(this.generator.m_123916_(), resourceType, resourceLocation));
            }
            catch (IOException e) {
                WorldDataCompilerAndOps.LOGGER.error("Could not save resource `" + resourceLocation + "` (Resource Type `" + resourceType.m_135782_() + "`)", (Throwable)e);
            }
        }
    }
    
    private static Path makePath(final Path path, final ResourceKey<?> key, final ResourceLocation resc) {
        return path.resolve("data").resolve(resc.m_135827_()).resolve(key.m_135782_().m_135815_()).resolve(resc.m_135815_() + ".json");
    }
    
    protected Format intercept(final ResourceKey<?> key, final Format format) {
        return format;
    }
    
    private void save(final ResourceKey<?> key, final HashCache cache, Format dynamic, final Path pathIn) throws IOException {
        dynamic = this.intercept(key, dynamic);
        final String s = this.fileContentWriter.apply(dynamic);
        final String s2 = WorldDataCompilerAndOps.f_123918_.hashUnencodedChars((CharSequence)s).toString();
        if (!Objects.equals(cache.m_123938_(pathIn), s2) || !Files.exists(pathIn, new LinkOption[0])) {
            Files.createDirectories(pathIn.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
            try (final BufferedWriter bufferedwriter = Files.newBufferedWriter(pathIn, new OpenOption[0])) {
                bufferedwriter.write(s);
            }
        }
        cache.m_123940_(pathIn, s2);
    }
    
    @Nullable
    protected final <T> T getFromDynRegistry(final ResourceKey<Registry<T>> key, final ResourceLocation rl) {
        return (T)this.dynamicRegistries.m_6632_((ResourceKey)key).get().m_7745_(rl);
    }
    
    @Nullable
    protected static <T> T getFromVanillaRegistryIllegally(final Registry registry, final ResourceKey<T> key) {
        return (T)registry.m_6246_((ResourceKey)key);
    }
    
    private static <Resource> Optional<ResourceLocation> getFromForgeRegistryIllegally(final ResourceKey<? extends Registry<Resource>> registryKey, final Resource resource) {
        if (!(resource instanceof IForgeRegistryEntry)) {
            return Optional.empty();
        }
        final IForgeRegistryEntry<Resource> entry = (IForgeRegistryEntry<Resource>)resource;
        final ResourceLocation location = entry.getRegistryName();
        if (location != null) {
            return Optional.of(location);
        }
        final IForgeRegistry forgeRegistry = (IForgeRegistry)RegistryManager.ACTIVE.getRegistry(registryKey.m_135782_());
        return Optional.ofNullable(forgeRegistry.getKey((IForgeRegistryEntry)resource));
    }
    
    private <Resource> Optional<ResourceLocation> rummageForResourceLocation(final Resource resource, final ResourceKey<? extends Registry<Resource>> registryKey) {
        Optional<ResourceLocation> instanceKey = Optional.empty();
        if (resource instanceof final IForgeRegistryEntry forgeRegistryEntry) {
            instanceKey = Optional.ofNullable(forgeRegistryEntry.getRegistryName());
        }
        if (instanceKey.isEmpty()) {
            try {
                final Registry<Resource> dynRegistry = (Registry<Resource>)this.dynamicRegistries.m_175515_((ResourceKey)registryKey);
                instanceKey = ((dynRegistry != null) ? dynRegistry.m_7854_((Object)resource).map(ResourceKey::m_135782_) : Optional.empty());
            }
            catch (Throwable t) {}
        }
        if (instanceKey.isEmpty()) {
            final Registry<Resource> registry = (Registry<Resource>)getFromVanillaRegistryIllegally(BuiltinRegistries.f_123858_, (net.minecraft.resources.ResourceKey<Registry>)registryKey);
            if (registry != null) {
                instanceKey = registry.m_7854_((Object)resource).map(ResourceKey::m_135782_);
            }
        }
        if (instanceKey.isEmpty()) {
            final Registry<Resource> registry = (Registry<Resource>)getFromVanillaRegistryIllegally(Registry.f_122897_, (net.minecraft.resources.ResourceKey<Registry>)registryKey);
            if (registry != null) {
                instanceKey = registry.m_7854_((Object)resource).map(ResourceKey::m_135782_);
            }
        }
        if (instanceKey.isEmpty()) {
            instanceKey = getFromForgeRegistryIllegally(registryKey, resource);
        }
        return instanceKey;
    }
    
    protected <Resource> DataResult<Format> m_135770_(final Resource resource, final Format dynamic, final ResourceKey<? extends Registry<Resource>> registryKey, final Codec<Resource> codec) {
        final Optional<ResourceLocation> instanceKey = this.rummageForResourceLocation(resource, registryKey);
        if (instanceKey.isPresent()) {
            if ("twilightforest".equals(instanceKey.get().m_135827_())) {
                this.serialize(registryKey, instanceKey.get(), resource, (com.mojang.serialization.Encoder<Resource>)codec);
            }
            return (DataResult<Format>)ResourceLocation.f_135803_.encode((Object)instanceKey.get(), this.f_135465_, (Object)dynamic);
        }
        return (DataResult<Format>)codec.encode((Object)resource, (DynamicOps)this, (Object)dynamic);
    }
    
    public String m_6055_() {
        return "Twilight World";
    }
    
    protected static NoiseSettings makeNoiseSettings(final int minY, final int height, final NoiseSamplingSettings noiseSamplingSettings, final NoiseSlideSettings topSlideSettings, final NoiseSlideSettings bottomSlideSettings, final int noiseSizeHorizontal, final int noiseSizeVertical, final double densityFactor, final double densityOffset, final boolean useSimplexSurfaceNoise, final boolean randomDensityOffset, final boolean islandNoiseOverride, final boolean isAmplified) {
        return NoiseSettings.m_158704_(minY, height, noiseSamplingSettings, topSlideSettings, bottomSlideSettings, noiseSizeHorizontal, noiseSizeVertical, densityFactor, densityOffset, useSimplexSurfaceNoise, randomDensityOffset, islandNoiseOverride, isAmplified);
    }
    
    protected static NoiseGeneratorSettings makeDimensionSettings(final StructureSettings structureSettings, final NoiseSettings noiseSettings, final BlockState defaultBlock, final BlockState defaultFluid, final int bedrockRoofPosition, final int bedrockFloorPosition, final int seaLevel, final int minSurfaceLevel, final boolean disableMobGeneration, final boolean aquifersEnabled, final boolean noiseCavesEnabled, final boolean deepslateEnabled, final boolean oreVeinsEnabled, final boolean noodleCavesEnabled) {
        return new NoiseGeneratorSettings(structureSettings, noiseSettings, defaultBlock, defaultFluid, bedrockRoofPosition, bedrockFloorPosition, seaLevel, minSurfaceLevel, disableMobGeneration, aquifersEnabled, noiseCavesEnabled, deepslateEnabled, oreVeinsEnabled, noodleCavesEnabled);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        GSON = new GsonBuilder().setPrettyPrinting().create();
    }
}
