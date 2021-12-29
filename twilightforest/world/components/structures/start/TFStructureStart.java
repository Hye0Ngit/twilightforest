// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.start;

import java.util.function.Predicate;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.WorldGenLevel;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.Objects;
import twilightforest.world.components.structures.TFStructureComponentTemplate;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import java.util.Random;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import javax.annotation.Nullable;
import twilightforest.world.registration.TFStructures;
import net.minecraft.world.level.biome.MobSpawnSettings;
import java.util.List;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.StructureFeatureManager;
import java.util.Iterator;
import twilightforest.world.components.structures.TFStructureComponent;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import com.mojang.serialization.Codec;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class TFStructureStart<C extends FeatureConfiguration> extends StructureFeature<C>
{
    private final TFFeature feature;
    private final boolean template;
    
    public TFStructureStart(final Codec<C> codec, final TFFeature feature) {
        this(codec, feature, false);
    }
    
    public TFStructureStart(final Codec<C> codec, final TFFeature feature, final boolean template) {
        super((Codec)codec);
        this.feature = feature;
        this.template = template;
    }
    
    public TFFeature getFeature() {
        return this.feature;
    }
    
    public boolean getDefaultRestrictsSpawnsToInside() {
        return true;
    }
    
    public GenerationStep.Decoration m_67095_() {
        return this.getFeature().getDecorationStage();
    }
    
    public StructureFeature.StructureStartFactory<C> m_6258_() {
        return (StructureFeature.StructureStartFactory<C>)(this.template ? ((x$0, x$1, x$2, x$3) -> new TemplateStart((StructureFeature<C>)x$0, x$1, x$2, x$3)) : ((x$0, x$1, x$2, x$3) -> new Start((StructureFeature<C>)x$0, x$1, x$2, x$3)));
    }
    
    private StructureStart<C> createStructureStart(final ChunkPos pos, final int refCount, final long seed) {
        return (StructureStart<C>)this.m_6258_().m_160478_((StructureFeature)this, pos, refCount, seed);
    }
    
    public StructureStart<?> m_160464_(final RegistryAccess dynamicRegistries, final ChunkGenerator generator, final BiomeSource provider, final StructureManager templateManager, final long seed, final ChunkPos pos, final Biome biome, final int refCount, final WorldgenRandom rand, final StructureFeatureConfiguration settings, final C config, final LevelHeightAccessor accessor) {
        final ChunkPos chunkpos = this.m_67067_(settings, seed, rand, pos.f_45578_, pos.f_45579_);
        if (this.m_142290_(generator, provider, seed, rand, pos, biome, chunkpos, config, accessor)) {
            final StructureStart<C> structurestart = this.createStructureStart(pos, refCount, seed);
            structurestart.m_142743_(dynamicRegistries, generator, templateManager, pos, biome, (FeatureConfiguration)config, accessor);
            if (structurestart.m_73603_()) {
                return structurestart;
            }
        }
        return (StructureStart<?>)StructureStart.f_73561_;
    }
    
    protected boolean m_142290_(final ChunkGenerator generator, final BiomeSource provider, final long seed, final WorldgenRandom random, final ChunkPos pos, final Biome biome, final ChunkPos structurePos, final C config, final LevelHeightAccessor accessor) {
        return TFFeature.isInFeatureChunk(pos.f_45578_ << 4, pos.f_45579_ << 4) && TFFeature.generateFeature(pos.f_45578_, pos.f_45579_, biome, seed) == this.feature;
    }
    
    private static int getSpawnListIndexAt(final StructureStart<?> start, final BlockPos pos) {
        int highestFoundIndex = -1;
        for (final StructurePiece component : start.m_73602_()) {
            if (component.m_73547_().m_71051_((Vec3i)pos)) {
                if (!(component instanceof TFStructureComponent)) {
                    return 0;
                }
                final TFStructureComponent tfComponent = (TFStructureComponent)component;
                if (tfComponent.spawnListIndex <= highestFoundIndex) {
                    continue;
                }
                highestFoundIndex = tfComponent.spawnListIndex;
            }
        }
        return highestFoundIndex;
    }
    
    @Nullable
    public static List<MobSpawnSettings.SpawnerData> gatherPotentialSpawns(final StructureFeatureManager structureManager, final MobCategory classification, final BlockPos pos) {
        for (final StructureFeature<?> structure : TFStructures.SEPARATION_SETTINGS.keySet()) {
            final StructureStart<?> start = (StructureStart<?>)structureManager.m_47285_(pos, true, (StructureFeature)structure);
            if (!start.m_73603_()) {
                continue;
            }
            final TFFeature feature = ((TFStructureStart)structure).feature;
            if (classification != MobCategory.MONSTER) {
                return feature.getSpawnableList(classification);
            }
            final StructureStart<?> structureStart = start;
            if (structureStart instanceof final Start s) {
                if (s.conquered) {
                    return null;
                }
            }
            final int index = getSpawnListIndexAt(start, pos);
            if (index < 0) {
                return null;
            }
            return feature.getSpawnableMonsterList(index);
        }
        return null;
    }
    
    public class Start extends StructureStart<C>
    {
        private boolean conquered;
        
        public Start(final StructureFeature<C> p_i225876_1_, final ChunkPos p_i225876_2_, final int p_i225876_3_, final long p_i225876_4_) {
            super((StructureFeature)p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_);
        }
        
        public CompoundTag m_163606_(final ServerLevel pLevel, final ChunkPos pChunkPos) {
            final CompoundTag tag = super.m_163606_(pLevel, pChunkPos);
            if (this.m_73603_()) {
                tag.m_128379_("conquered", this.conquered);
            }
            return tag;
        }
        
        public void load(final CompoundTag nbt) {
            this.conquered = nbt.m_128471_("conquered");
        }
        
        public final void setConquered(final boolean flag) {
            this.conquered = flag;
        }
        
        public final boolean isConquered() {
            return this.conquered;
        }
        
        public void m_142743_(final RegistryAccess registryAccess, final ChunkGenerator chunkGenerator, final StructureManager structureManager, final ChunkPos chunkPos, final Biome biome, final C config, final LevelHeightAccessor levelHeightAccessor) {
            final boolean dontCenter = TFStructureStart.this.feature == TFFeature.LICH_TOWER || TFStructureStart.this.feature == TFFeature.TROLL_CAVE || TFStructureStart.this.feature == TFFeature.YETI_CAVE;
            final int x = (chunkPos.f_45578_ << 4) + (dontCenter ? 0 : 7);
            final int z = (chunkPos.f_45579_ << 4) + (dontCenter ? 0 : 7);
            final int y = TFStructureStart.this.feature.shouldAdjustToTerrain() ? Mth.m_14045_(chunkGenerator.m_156179_(x, z, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, levelHeightAccessor), chunkGenerator.m_6337_() + 1, chunkGenerator.m_6337_() + 7) : chunkGenerator.m_6337_();
            final StructurePiece start = TFStructureStart.this.feature.provideStructureStart(structureManager, chunkGenerator, (Random)this.f_73564_, x, y, z);
            if (start == null) {
                return;
            }
            this.m_142679_(start);
            start.m_142537_(start, (StructurePieceAccessor)this, (Random)this.f_73564_);
            this.m_142516_();
        }
    }
    
    private class TemplateStart extends Start
    {
        public TemplateStart(final StructureFeature<C> p_i225876_1_, final ChunkPos p_i225876_2_, final int p_i225876_3_, final long p_i225876_4_) {
            super(p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_);
        }
        
        @Override
        public void m_142743_(final RegistryAccess registryAccess, final ChunkGenerator chunkGenerator, final StructureManager structureManager, final ChunkPos chunkPos, final Biome biome, final C config, final LevelHeightAccessor levelHeightAccessor) {
            super.m_142743_(registryAccess, chunkGenerator, structureManager, chunkPos, biome, config, levelHeightAccessor);
            final Stream filter = this.f_73562_.stream().filter(piece -> piece instanceof TFStructureComponentTemplate);
            final Class<TFStructureComponentTemplate> obj = TFStructureComponentTemplate.class;
            Objects.requireNonNull(obj);
            filter.map(obj::cast).forEach(piece -> piece.setup(structureManager));
            this.m_142516_();
        }
        
        public void m_7129_(final WorldGenLevel p_230366_1_, final StructureFeatureManager p_230366_2_, final ChunkGenerator p_230366_3_, final Random p_230366_4_, final BoundingBox p_230366_5_, final ChunkPos p_230366_6_) {
            final Stream stream = this.f_73562_.stream();
            final Class<TFStructureComponentTemplate> obj = TFStructureComponentTemplate.class;
            Objects.requireNonNull(obj);
            final Stream filter = stream.filter(obj::isInstance);
            final Class<TFStructureComponentTemplate> obj2 = TFStructureComponentTemplate.class;
            Objects.requireNonNull(obj2);
            filter.map(obj2::cast).filter(component -> component.LAZY_TEMPLATE_LOADER != null).forEach(component -> component.LAZY_TEMPLATE_LOADER.run());
            super.m_7129_(p_230366_1_, p_230366_2_, p_230366_3_, p_230366_4_, p_230366_5_, p_230366_6_);
        }
    }
}
