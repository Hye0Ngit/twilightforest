// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.chunkgenerators;

import net.minecraft.world.level.levelgen.BaseStoneSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.levelgen.Heightmap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.server.level.WorldGenRegion;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGenerator;

public abstract class ChunkGeneratorWrapper extends ChunkGenerator
{
    public final ChunkGenerator delegate;
    
    public ChunkGeneratorWrapper(final ChunkGenerator delegate) {
        final BiomeSource 62218_ = delegate.m_62218_();
        final BiomeSource 62218_2 = delegate.m_62218_();
        final StructureSettings 62205_ = delegate.m_62205_();
        long n;
        if (delegate instanceof final NoiseBasedChunkGenerator noiseGen) {
            n = noiseGen.f_64333_;
        }
        else {
            n = delegate.f_62140_;
        }
        super(62218_, 62218_2, 62205_, n);
        this.delegate = delegate;
    }
    
    public void m_62196_(final Registry<Biome> biomes, final ChunkAccess chunkAccess) {
        this.delegate.m_62196_((Registry)biomes, chunkAccess);
    }
    
    public void m_6013_(final long seed, final BiomeManager biomeManager, final ChunkAccess chunkAccess, final GenerationStep.Carving carving) {
        this.delegate.m_6013_(seed, biomeManager, chunkAccess, carving);
    }
    
    @Nullable
    public BlockPos m_62161_(final ServerLevel level, final StructureFeature<?> structure, final BlockPos pos, final int searchRadius, final boolean skipKnownStructures) {
        return this.delegate.m_62161_(level, (StructureFeature)structure, pos, searchRadius, skipKnownStructures);
    }
    
    public void m_7399_(final WorldGenRegion region, final StructureFeatureManager structureManager) {
        this.delegate.m_7399_(region, structureManager);
    }
    
    public void m_7338_(final WorldGenRegion level, final ChunkAccess chunkAccess) {
        this.delegate.m_7338_(level, chunkAccess);
    }
    
    public void m_6929_(final WorldGenRegion region) {
        this.delegate.m_6929_(region);
    }
    
    public StructureSettings m_62205_() {
        return this.delegate.m_62205_();
    }
    
    public int m_142051_(final LevelHeightAccessor level) {
        return this.delegate.m_142051_(level);
    }
    
    public BiomeSource m_62218_() {
        return this.delegate.m_62218_();
    }
    
    public int m_6331_() {
        return this.delegate.m_6331_();
    }
    
    public WeightedRandomList<MobSpawnSettings.SpawnerData> m_142184_(final Biome biome, final StructureFeatureManager structureManager, final MobCategory mobCategory, final BlockPos pos) {
        return (WeightedRandomList<MobSpawnSettings.SpawnerData>)this.delegate.m_142184_(biome, structureManager, mobCategory, pos);
    }
    
    public void m_62199_(final RegistryAccess registry, final StructureFeatureManager structureManager, final ChunkAccess chunkAccess, final StructureManager templateManager, final long pSeed) {
        this.delegate.m_62199_(registry, structureManager, chunkAccess, templateManager, pSeed);
    }
    
    public void m_62177_(final WorldGenLevel level, final StructureFeatureManager structureManager, final ChunkAccess chunkAccess) {
        this.delegate.m_62177_(level, structureManager, chunkAccess);
    }
    
    public CompletableFuture<ChunkAccess> m_142189_(final Executor executor, final StructureFeatureManager structureManager, final ChunkAccess chunkAccess) {
        return this.delegate.m_142189_(executor, structureManager, chunkAccess);
    }
    
    public int m_6337_() {
        return this.delegate.m_6337_();
    }
    
    public int m_142062_() {
        return this.delegate.m_142062_();
    }
    
    public int m_142647_(final int x, final int z, final Heightmap.Types heightMap, final LevelHeightAccessor level) {
        return this.delegate.m_142647_(x, z, heightMap, level);
    }
    
    public NoiseColumn m_141914_(final int x, final int z, final LevelHeightAccessor level) {
        return this.delegate.m_141914_(x, z, level);
    }
    
    public int m_156174_(final int x, final int z, final Heightmap.Types heightMapType, final LevelHeightAccessor level) {
        return this.delegate.m_156174_(x, z, heightMapType, level);
    }
    
    public int m_156179_(final int x, final int z, final Heightmap.Types heightMapType, final LevelHeightAccessor level) {
        return this.delegate.m_156179_(x, z, heightMapType, level);
    }
    
    public boolean m_62172_(final ChunkPos chunkPos) {
        return this.delegate.m_62172_(chunkPos);
    }
    
    public BaseStoneSource m_142168_() {
        return this.delegate.m_142168_();
    }
}
