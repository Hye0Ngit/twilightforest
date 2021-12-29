// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.IBiomeMagnifier;
import java.util.OptionalLong;
import java.lang.reflect.Constructor;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.settings.NoiseSettings;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import com.mojang.serialization.Codec;
import net.minecraft.util.registry.WorldGenRegistries;
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
import net.minecraft.util.ResourceLocation;
import java.util.function.Supplier;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import com.mojang.serialization.DynamicOps;
import java.util.HashSet;
import net.minecraft.data.DirectoryCache;
import net.minecraft.util.registry.DynamicRegistries;
import java.util.function.Function;
import net.minecraft.data.DataGenerator;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.registry.WorldGenSettingsExport;

public abstract class WorldDataCompilerAndOps<Format> extends WorldGenSettingsExport<Format> implements IDataProvider
{
    protected static final Logger LOGGER;
    protected static final Gson GSON;
    protected final DataGenerator generator;
    private final Function<Format, String> fileContentWriter;
    protected final DynamicRegistries field_240895_b_;
    private DirectoryCache directoryCache;
    private final HashSet<Object> objectsSerializationCache;
    
    public WorldDataCompilerAndOps(final DataGenerator generator, final DynamicOps<Format> ops, final Function<Format, String> fileContentWriter, final DynamicRegistries dynamicRegistries) {
        super((DynamicOps)ops, dynamicRegistries);
        this.objectsSerializationCache = new HashSet<Object>();
        this.generator = generator;
        this.fileContentWriter = fileContentWriter;
        this.field_240895_b_ = dynamicRegistries;
    }
    
    protected <Resource> Resource getOrCreateInRegistry(final Registry<Resource> registry, final RegistryKey<Resource> registryKey, final Supplier<Resource> resourceCreator) {
        Resource resourceSaved = getFromVanillaRegistryIllegally(registry, registryKey);
        if (resourceSaved == null) {
            resourceSaved = (Resource)Registry.func_218322_a((Registry)registry, registryKey.func_240901_a_(), (Object)resourceCreator.get());
        }
        return resourceSaved;
    }
    
    public final void func_200398_a(final DirectoryCache directoryCache) {
        this.generate(this.directoryCache = directoryCache);
    }
    
    public abstract void generate(final DirectoryCache p0);
    
    public <Resource> void serialize(final RegistryKey<? extends Registry<Resource>> resourceType, final ResourceLocation resourceLocation, final Resource resource, final Encoder<Resource> encoder) {
        if (this.objectsSerializationCache.contains(resource)) {
            WorldDataCompilerAndOps.LOGGER.debug("Avoiding duplicate serialization with " + resourceLocation);
            return;
        }
        this.objectsSerializationCache.add(resource);
        final Optional<Format> output = this.withEncoder((Encoder)encoder).apply(resource).setLifecycle(Lifecycle.experimental()).resultOrPartial(error -> WorldDataCompilerAndOps.LOGGER.error("Object [" + resourceType.getRegistryName() + "] " + resourceLocation + " not serialized within recursive serialization: " + error));
        if (output.isPresent()) {
            try {
                this.save(this.directoryCache, output.get(), makePath(this.generator.func_200391_b(), resourceType, resourceLocation));
            }
            catch (IOException e) {
                WorldDataCompilerAndOps.LOGGER.error("Could not save resource `" + resourceLocation + "` (Resource Type `" + resourceType.func_240901_a_() + "`)", (Throwable)e);
            }
        }
    }
    
    private static Path makePath(final Path path, final RegistryKey<?> key, final ResourceLocation resc) {
        return path.resolve("data").resolve(resc.func_110624_b()).resolve(key.func_240901_a_().func_110623_a()).resolve(resc.func_110623_a() + ".json");
    }
    
    private void save(final DirectoryCache cache, final Format dynamic, final Path pathIn) throws IOException {
        final String s = this.fileContentWriter.apply(dynamic);
        final String s2 = WorldDataCompilerAndOps.field_208307_a.hashUnencodedChars((CharSequence)s).toString();
        if (!Objects.equals(cache.func_208323_a(pathIn), s2) || !Files.exists(pathIn, new LinkOption[0])) {
            Files.createDirectories(pathIn.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
            try (final BufferedWriter bufferedwriter = Files.newBufferedWriter(pathIn, new OpenOption[0])) {
                bufferedwriter.write(s);
            }
        }
        cache.func_208316_a(pathIn, s2);
    }
    
    @Nullable
    protected static <T> T getFromVanillaRegistryIllegally(final Registry registry, final RegistryKey<T> key) {
        return (T)registry.func_230516_a_((RegistryKey)key);
    }
    
    private static <Resource> Optional<ResourceLocation> getFromForgeRegistryIllegally(final RegistryKey<? extends Registry<Resource>> registryKey, final Resource resource) {
        if (!(resource instanceof IForgeRegistryEntry)) {
            return Optional.empty();
        }
        final IForgeRegistryEntry<Resource> entry = (IForgeRegistryEntry<Resource>)resource;
        final ResourceLocation location = entry.getRegistryName();
        if (location != null) {
            return Optional.of(location);
        }
        final IForgeRegistry forgeRegistry = (IForgeRegistry)RegistryManager.ACTIVE.getRegistry(registryKey.func_240901_a_());
        return Optional.ofNullable(forgeRegistry.getKey((IForgeRegistryEntry)resource));
    }
    
    private <Resource> Optional<ResourceLocation> rummageForResourceLocation(final Resource resource, final RegistryKey<? extends Registry<Resource>> registryKey) {
        Optional<ResourceLocation> instanceKey = Optional.empty();
        if (resource instanceof IForgeRegistryEntry) {
            instanceKey = Optional.ofNullable(((IForgeRegistryEntry)resource).getRegistryName());
        }
        if (!instanceKey.isPresent()) {
            try {
                final Registry<Resource> dynRegistry = (Registry<Resource>)this.field_240895_b_.func_243612_b((RegistryKey)registryKey);
                instanceKey = ((dynRegistry != null) ? dynRegistry.func_230519_c_((Object)resource).map(RegistryKey::func_240901_a_) : Optional.empty());
            }
            catch (Throwable t) {}
        }
        if (!instanceKey.isPresent()) {
            final Registry<Resource> registry = (Registry<Resource>)getFromVanillaRegistryIllegally(WorldGenRegistries.field_243650_b, (net.minecraft.util.RegistryKey<Registry>)registryKey);
            if (registry != null) {
                instanceKey = registry.func_230519_c_((Object)resource).map(RegistryKey::func_240901_a_);
            }
        }
        if (!instanceKey.isPresent()) {
            final Registry<Resource> registry = (Registry<Resource>)getFromVanillaRegistryIllegally(Registry.field_212617_f, (net.minecraft.util.RegistryKey<Registry>)registryKey);
            if (registry != null) {
                instanceKey = registry.func_230519_c_((Object)resource).map(RegistryKey::func_240901_a_);
            }
        }
        if (!instanceKey.isPresent()) {
            instanceKey = getFromForgeRegistryIllegally(registryKey, resource);
        }
        return instanceKey;
    }
    
    protected <Resource> DataResult<Format> func_241811_a_(final Resource resource, final Format dynamic, final RegistryKey<? extends Registry<Resource>> registryKey, final Codec<Resource> codec) {
        final Optional<ResourceLocation> instanceKey = this.rummageForResourceLocation(resource, registryKey);
        if (instanceKey.isPresent()) {
            if ("twilightforest".equals(instanceKey.get().func_110624_b())) {
                this.serialize(registryKey, instanceKey.get(), resource, (com.mojang.serialization.Encoder<Resource>)codec);
            }
            return (DataResult<Format>)ResourceLocation.field_240908_a_.encode((Object)instanceKey.get(), this.field_240857_a_, (Object)dynamic);
        }
        return (DataResult<Format>)codec.encode((Object)resource, (DynamicOps)this, (Object)dynamic);
    }
    
    public String func_200397_b() {
        return "Twilight World";
    }
    
    protected static Optional<DimensionSettings> makeDimensionSettings(final DimensionStructuresSettings structures, final NoiseSettings noise, final BlockState defaultBlock, final BlockState defaultFluid, final int bedrockRoofPosition, final int bedrockFloorPosition, final int seaLevel, final boolean disableMobGeneration) {
        try {
            final Constructor<DimensionSettings> ctor = DimensionSettings.class.getDeclaredConstructor(DimensionStructuresSettings.class, NoiseSettings.class, BlockState.class, BlockState.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
            ctor.setAccessible(true);
            return Optional.of(ctor.newInstance(structures, noise, defaultBlock, defaultFluid, bedrockRoofPosition, bedrockFloorPosition, seaLevel, disableMobGeneration));
        }
        catch (Exception e) {
            WorldDataCompilerAndOps.LOGGER.error("Error constructing `DimensionSettings`!", (Throwable)e);
            return Optional.empty();
        }
    }
    
    protected static Optional<DimensionType> makeDimensionType(final OptionalLong fixedTime, final boolean hasSkyLight, final boolean hasCeiling, final boolean ultrawarm, final boolean natural, final double coordinateScale, final boolean hasDragonFight, final boolean piglinSafe, final boolean bedWorks, final boolean respawnAnchorWorks, final boolean hasRaids, final int logicalHeight, final IBiomeMagnifier magnifier, final ResourceLocation infiniburn, final ResourceLocation effects, final float ambientLight) {
        try {
            final Constructor<DimensionType> ctor = DimensionType.class.getDeclaredConstructor(OptionalLong.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Double.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, IBiomeMagnifier.class, ResourceLocation.class, ResourceLocation.class, Float.TYPE);
            ctor.setAccessible(true);
            return Optional.of(ctor.newInstance(fixedTime, hasSkyLight, hasCeiling, ultrawarm, natural, coordinateScale, hasDragonFight, piglinSafe, bedWorks, respawnAnchorWorks, hasRaids, logicalHeight, magnifier, infiniburn, effects, ambientLight));
        }
        catch (Exception e) {
            WorldDataCompilerAndOps.LOGGER.error("Error constructing `DimensionType`!", (Throwable)e);
            return Optional.empty();
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        GSON = new GsonBuilder().setPrettyPrinting().create();
    }
}
