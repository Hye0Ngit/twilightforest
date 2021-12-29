// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import javax.annotation.Nullable;
import net.minecraft.resources.data.IMetadataSectionSerializer;
import com.google.common.base.Joiner;
import net.minecraft.util.ResourceLocation;
import java.util.Collection;
import java.util.function.Predicate;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;
import net.minecraft.resources.ResourcePackFileNotFoundException;
import java.nio.file.LinkOption;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Collections;
import twilightforest.TwilightForestMod;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.FileVisitOption;
import net.minecraftforge.forgespi.locating.IModFile;
import java.util.Set;
import net.minecraft.resources.ResourcePackType;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.resources.ResourcePack;

@OnlyIn(Dist.CLIENT)
public class TwilightLegacyPack extends ResourcePack
{
    private final ModFile modFile;
    private static final String subDir = "classic/";
    
    public TwilightLegacyPack(final ModFile modFile) {
        super(modFile.getFilePath().toFile());
        this.modFile = modFile;
    }
    
    public Set<String> func_195759_a(final ResourcePackType type) {
        try {
            final Path root = this.modFile.getLocator().findPath((IModFile)this.modFile, new String[] { "classic/" + type.func_198956_a() }).toAbsolutePath();
            return Files.walk(root, 1, new FileVisitOption[0]).map(path -> root.relativize(path.toAbsolutePath())).filter(path -> path.getNameCount() > 0).map(p -> p.toString().replaceAll("/$", "")).filter(s -> !s.isEmpty()).collect((Collector<? super Object, ?, Set<String>>)Collectors.toSet());
        }
        catch (Throwable t) {
            TwilightForestMod.LOGGER.error("TwilightLegacyPack failed to collect resource namespaces!", t);
            return Collections.emptySet();
        }
    }
    
    protected InputStream func_195766_a(final String location) throws IOException {
        final Path path = this.modFile.getLocator().findPath((IModFile)this.modFile, new String[] { "classic/" + location });
        if (!Files.exists(path, new LinkOption[0])) {
            TwilightForestMod.LOGGER.error("File does not exist!");
            throw new ResourcePackFileNotFoundException(path.toFile(), location);
        }
        return Files.newInputStream(path, StandardOpenOption.READ);
    }
    
    protected boolean func_195768_c(final String resourcePath) {
        return Files.exists(this.modFile.getLocator().findPath((IModFile)this.modFile, new String[] { "classic/" + resourcePath }), new LinkOption[0]);
    }
    
    public Collection<ResourceLocation> func_225637_a_(final ResourcePackType type, final String namespaceIn, final String pathIn, final int maxDepthIn, final Predicate<String> filterIn) {
        try {
            final Path root = this.modFile.getLocator().findPath((IModFile)this.modFile, new String[] { "classic/" + type.func_198956_a() }).toAbsolutePath();
            final Path inputPath = root.getFileSystem().getPath(pathIn, new String[0]);
            return Files.walk(root, new FileVisitOption[0]).map(path -> root.relativize(path.toAbsolutePath())).filter(path -> path.getNameCount() > 1 && path.getNameCount() - 1 <= maxDepthIn).filter(path -> !path.toString().endsWith(".mcmeta")).filter(path -> path.subpath(1, path.getNameCount()).startsWith(inputPath)).filter(path -> filterIn.test(path.getFileName().toString())).map(path -> new ResourceLocation(path.getName(0).toString(), Joiner.on('/').join((Iterable)path.subpath(1, Math.min(maxDepthIn, path.getNameCount()))))).collect((Collector<? super Object, ?, Collection<ResourceLocation>>)Collectors.toList());
        }
        catch (IOException e) {
            return (Collection<ResourceLocation>)Collections.emptyList();
        }
    }
    
    public void close() {
    }
    
    public String func_195762_a() {
        return "Twilight Classic";
    }
    
    @Nullable
    public <T> T func_195760_a(final IMetadataSectionSerializer<T> serializer) throws IOException {
        T resourceMetaData;
        try (final InputStream inputStream = this.func_195766_a("pack.mcmeta")) {
            resourceMetaData = (T)func_195770_a((IMetadataSectionSerializer)serializer, inputStream);
        }
        return resourceMetaData;
    }
}
