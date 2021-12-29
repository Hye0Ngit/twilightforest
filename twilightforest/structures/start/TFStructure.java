// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.start;

import java.util.function.Predicate;
import net.minecraft.world.ISeedReader;
import java.util.function.Function;
import twilightforest.structures.TFStructureComponentTemplate;
import java.util.Random;
import javax.annotation.Nullable;
import twilightforest.TFStructures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.gen.feature.structure.StructureManager;
import java.util.Iterator;
import twilightforest.structures.TFStructureComponent;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.MobSpawnInfo;
import java.util.List;
import com.mojang.serialization.Codec;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class TFStructure<C extends IFeatureConfig> extends Structure<C>
{
    private final TFFeature feature;
    private final boolean template;
    
    public TFStructure(final Codec<C> codec, final TFFeature feature) {
        this(codec, feature, false);
    }
    
    public TFStructure(final Codec<C> codec, final TFFeature feature, final boolean template) {
        super((Codec)codec);
        this.feature = feature;
        this.template = template;
    }
    
    public TFFeature getFeature() {
        return this.feature;
    }
    
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return this.feature.getCombinedMonsterSpawnableList();
    }
    
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        return this.feature.getCombinedCreatureSpawnableList();
    }
    
    public boolean getDefaultRestrictsSpawnsToInside() {
        return true;
    }
    
    public GenerationStage.Decoration func_236396_f_() {
        return this.feature.getDecorationStage();
    }
    
    public Structure.IStartFactory<C> func_214557_a() {
        return (Structure.IStartFactory<C>)(this.template ? ((x$0, x$1, x$2, x$3, x$4, x$5) -> new TemplateStart((Structure<C>)x$0, x$1, x$2, x$3, x$4, x$5)) : ((x$0, x$1, x$2, x$3, x$4, x$5) -> new Start((Structure<C>)x$0, x$1, x$2, x$3, x$4, x$5)));
    }
    
    private StructureStart<C> createStructureStart(final int p_236387_1_, final int p_236387_2_, final MutableBoundingBox p_236387_3_, final int refCount, final long seed) {
        return (StructureStart<C>)this.func_214557_a().create((Structure)this, p_236387_1_, p_236387_2_, p_236387_3_, refCount, seed);
    }
    
    public StructureStart<?> func_242785_a(final DynamicRegistries dynamicRegistries, final ChunkGenerator generator, final BiomeProvider provider, final TemplateManager templateManager, final long seed, final ChunkPos pos, final Biome biome, final int refCount, final SharedSeedRandom rand, final StructureSeparationSettings settings, final C config) {
        if (this.func_230363_a_(generator, provider, seed, rand, pos.field_77276_a, pos.field_77275_b, biome, pos, config)) {
            final StructureStart<C> structurestart = this.createStructureStart(pos.field_77276_a, pos.field_77275_b, MutableBoundingBox.func_78887_a(), refCount, seed);
            structurestart.func_230364_a_(dynamicRegistries, generator, templateManager, pos.field_77276_a, pos.field_77275_b, biome, (IFeatureConfig)config);
            if (structurestart.func_75069_d()) {
                return structurestart;
            }
        }
        return (StructureStart<?>)StructureStart.field_214630_a;
    }
    
    protected boolean func_230363_a_(final ChunkGenerator generator, final BiomeProvider provider, final long seed, final SharedSeedRandom random, final int chunkX, final int chunkZ, final Biome biome, final ChunkPos structurePos, final C config) {
        return TFFeature.isInFeatureChunk(chunkX << 4, chunkZ << 4) && TFFeature.generateFeature(chunkX, chunkZ, biome, seed) == this.feature;
    }
    
    private static int getSpawnListIndexAt(final StructureStart<?> start, final BlockPos pos) {
        int highestFoundIndex = -1;
        for (final StructurePiece component : start.func_186161_c()) {
            if (component.func_74874_b().func_175898_b((Vector3i)pos)) {
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
    public static List<MobSpawnInfo.Spawners> gatherPotentialSpawns(final StructureManager structureManager, final EntityClassification classification, final BlockPos pos) {
        for (final Structure<?> structure : TFStructures.SEPARATION_SETTINGS.keySet()) {
            final StructureStart<?> start = (StructureStart<?>)structureManager.func_235010_a_(pos, true, (Structure)structure);
            if (!start.func_75069_d()) {
                continue;
            }
            final TFFeature feature = ((TFStructure)structure).feature;
            if (classification != EntityClassification.MONSTER) {
                return feature.getSpawnableList(classification);
            }
            final int index = getSpawnListIndexAt(start, pos);
            if (index < 0) {
                return null;
            }
            return feature.getSpawnableMonsterList(index);
        }
        return null;
    }
    
    private class Start extends StructureStart<C>
    {
        public Start(final Structure<C> p_i225876_1_, final int p_i225876_2_, final int p_i225876_3_, final MutableBoundingBox p_i225876_4_, final int p_i225876_5_, final long p_i225876_6_) {
            super((Structure)p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_, p_i225876_5_, p_i225876_6_);
        }
        
        public void func_230364_a_(final DynamicRegistries p_230364_1_, final ChunkGenerator p_230364_2_, final TemplateManager p_230364_3_, final int p_230364_4_, final int p_230364_5_, final Biome p_230364_6_, final C p_230364_7_) {
            final boolean dontCenter = TFStructure.this.feature == TFFeature.LICH_TOWER || TFStructure.this.feature == TFFeature.TROLL_CAVE || TFStructure.this.feature == TFFeature.YETI_CAVE;
            final int x = (p_230364_4_ << 4) + (dontCenter ? 0 : 7);
            final int z = (p_230364_5_ << 4) + (dontCenter ? 0 : 7);
            final int y = 32;
            final StructurePiece start = TFStructure.this.feature.provideStructureStart((Random)this.field_214631_d, x, y, z);
            if (start == null) {
                return;
            }
            this.field_75075_a.add(start);
            start.func_74861_a(start, this.field_75075_a, (Random)this.field_214631_d);
            this.func_202500_a();
        }
    }
    
    private class TemplateStart extends Start
    {
        public TemplateStart(final Structure<C> p_i225876_1_, final int p_i225876_2_, final int p_i225876_3_, final MutableBoundingBox p_i225876_4_, final int p_i225876_5_, final long p_i225876_6_) {
            super(p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_, p_i225876_5_, p_i225876_6_);
        }
        
        @Override
        public void func_230364_a_(final DynamicRegistries p_230364_1_, final ChunkGenerator p_230364_2_, final TemplateManager p_230364_3_, final int p_230364_4_, final int p_230364_5_, final Biome p_230364_6_, final C p_230364_7_) {
            super.func_230364_a_(p_230364_1_, p_230364_2_, p_230364_3_, p_230364_4_, p_230364_5_, p_230364_6_, p_230364_7_);
            this.field_75075_a.stream().filter(piece -> piece instanceof TFStructureComponentTemplate).map(TFStructureComponentTemplate.class::cast).forEach(piece -> piece.setup(p_230364_3_));
            this.func_202500_a();
        }
        
        public void func_230366_a_(final ISeedReader p_230366_1_, final StructureManager p_230366_2_, final ChunkGenerator p_230366_3_, final Random p_230366_4_, final MutableBoundingBox p_230366_5_, final ChunkPos p_230366_6_) {
            this.field_75075_a.stream().filter(TFStructureComponentTemplate.class::isInstance).map(TFStructureComponentTemplate.class::cast).filter(component -> component.LAZY_TEMPLATE_LOADER != null).forEach(component -> component.LAZY_TEMPLATE_LOADER.run());
            super.func_230366_a_(p_230366_1_, p_230366_2_, p_230366_3_, p_230366_4_, p_230366_5_, p_230366_6_);
        }
    }
}
