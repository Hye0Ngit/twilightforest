// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.DimensionSettings;
import java.util.function.Supplier;
import com.mojang.serialization.Codec;

public class ChunkGeneratorTwilightSky extends ChunkGeneratorTwilightBase
{
    public static final Codec<ChunkGeneratorTwilightSky> CODEC;
    private final long seed;
    protected final Supplier<DimensionSettings> dimensionSettings;
    
    public ChunkGeneratorTwilightSky(final BiomeProvider provider, final long seed, final Supplier<DimensionSettings> settings) {
        super(provider, seed, settings, false);
        this.seed = seed;
        this.dimensionSettings = settings;
    }
    
    protected Codec<? extends ChunkGenerator> func_230347_a_() {
        return (Codec<? extends ChunkGenerator>)ChunkGeneratorTwilightSky.CODEC;
    }
    
    public ChunkGenerator func_230349_a_(final long l) {
        return (ChunkGenerator)new ChunkGeneratorTwilightSky(this.field_222542_c.func_230320_a_(l), l, this.dimensionSettings);
    }
    
    private Supplier<DimensionSettings> getDimensionSettings() {
        return this.dimensionSettings;
    }
    
    public void func_225551_a_(final WorldGenRegion worldGenRegion, final IChunk iChunk) {
    }
    
    public void func_230354_a_(final WorldGenRegion region) {
        final int x = region.func_201679_a();
        final int z = region.func_201680_b();
        final ChunkBitArray data = new ChunkBitArray();
        final ChunkPrimer primer = new DirectChunkPrimer(new ChunkPos(x, z));
    }
    
    public void func_230352_b_(final IWorld world, final StructureManager p_230352_2_, final IChunk chunk) {
        super.func_230352_b_(world, p_230352_2_, chunk);
        if (!(world instanceof WorldGenRegion)) {
            return;
        }
        this.deformTerrainForFeature((WorldGenRegion)world);
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)BiomeProvider.field_235202_a_.fieldOf("biome_source").forGetter(obj -> obj.field_222542_c), (App)Codec.LONG.fieldOf("seed").stable().forGetter(obj -> obj.seed), (App)DimensionSettings.field_236098_b_.fieldOf("settings").forGetter((Function)ChunkGeneratorTwilightSky::getDimensionSettings)).apply((Applicative)instance, instance.stable((Object)ChunkGeneratorTwilightSky::new)));
    }
}
