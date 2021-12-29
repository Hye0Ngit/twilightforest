// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration.biomes;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import twilightforest.world.registration.ConfiguredWorldCarvers;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import twilightforest.world.registration.ConfiguredSurfaceBuilders;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import twilightforest.world.registration.TFStructures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import twilightforest.world.registration.ConfiguredFeatures;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.biome.BiomeGenerationSettings;

public abstract class BiomeHelper
{
    public static BiomeGenerationSettings.Builder twilightForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DENSE_CANOPY_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DENSE_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEFAULT_FALLEN_LOGS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126962_);
        addForestVegetation(biome);
        addHollowOakTrees(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder denseForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        addForestVegetation(biome);
        addCanopyTrees(biome);
        addHollowOakTrees(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder fireflyForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FIREFLY_FOREST_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEFAULT_FALLEN_LOGS);
        addHollowOakTrees(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.LAMPPOST_PLACER);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MUSHGLOOM_CLUSTER);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126931_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_127017_);
        addForestVegetation(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder clearingGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_127017_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEFAULT_FALLEN_LOGS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SMALL_LOG);
        addForestVegetation(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder oakSavannaGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SAVANNAH_OAK_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEFAULT_FALLEN_LOGS);
        addHollowOakTrees(biome);
        addForestVegetation(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder enchantedForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder().m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_QUEST_GROVE);
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.ENCHANTED_FOREST_TREES);
        addCanopyTrees(biome);
        addHollowOakTrees(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FIDDLEHEAD);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126874_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.GRASS_PLACER);
        addForestVegetation(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder spookyForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEAD_CANOPY_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.PUMPKIN_LAMPPOST);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.GRASS_PLACER);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TF_OAK_FALLEN_LOG);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.CANOPY_FALLEN_LOG);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.WEBS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FALLEN_LEAVES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126931_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126891_);
        biome.m_47842_(GenerationStep.Decoration.SURFACE_STRUCTURES, (ConfiguredFeature)ConfiguredFeatures.GRAVEYARD);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder mushroomForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MYCELIUM_BLOB);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        addHollowOakTrees(biome);
        addCanopyTrees(biome);
        addCanopyMushrooms(biome, false);
        addDefaultStructures(biome);
        addForestVegetation(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder denseMushroomForestGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder();
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MYCELIUM_BLOB);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        addCanopyMushrooms(biome, true);
        addCanopyTrees(biome);
        addHollowOakTrees(biome);
        addForestVegetation(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder plateauGen() {
        return new BiomeGenerationSettings.Builder().m_47851_((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_PLATEAU).m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_FINAL_CASTLE);
    }
    
    public static BiomeGenerationSettings.Builder thornlandsGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_PLATEAU);
        commonFeaturesWithoutBuildings(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.THORNS);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder highlandsGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_HIGHLANDS).m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_TROLL_CAVE);
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HIGHLANDS_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126865_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126888_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SPRUCE_FALLEN_LOG);
        addSmallStoneClusters(biome);
        addHighlandCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder streamsAndLakes(final boolean isLake) {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_(SurfaceBuilders.f_127292_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, isLake ? Features.f_127050_ : Features.f_127048_);
        BiomeDefaultFeatures.m_126814_(biome);
        BiomeDefaultFeatures.m_126761_(biome);
        addSmallStoneClusters(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder swampGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder().m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_LABYRINTH);
        commonFeatures(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MANGROVE_TREES);
        addSwampTrees(biome);
        addHollowOakTrees(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126903_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126874_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126891_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MANGROVE_FALLEN_LOG);
        addForestVegetation(biome);
        lilypads(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder fireSwampGen() {
        final BiomeGenerationSettings.Builder biome = defaultGenSettingBuilder().m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_HYDRA_LAIR);
        commonFeaturesWithoutBuildings(biome);
        addSwampTrees(biome);
        addHollowOakTrees(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.GRASS_PLACER);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FIRE_JET);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SMOKER);
        biome.m_47842_(GenerationStep.Decoration.LAKES, Features.f_126876_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126903_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126874_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126968_);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder darkForestGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_(SurfaceBuilders.f_127285_).m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_KNIGHT_STRONGHOLD);
        addDarkForestVegetation(biome);
        addForestVegetation(biome);
        addCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder darkForestCenterGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_(SurfaceBuilders.f_127285_).m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_DARK_TOWER);
        addDarkForestVegetation(biome);
        addCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder snowyForestGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_SNOW).m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_YETI_CAVE);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SNOWY_FOREST_TREES);
        biome.m_47842_(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, (ConfiguredFeature)ConfiguredFeatures.SNOW_UNDER_TREES);
        biome.m_47842_(GenerationStep.Decoration.LAKES, Features.f_126875_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SPRUCE_FALLEN_LOG);
        BiomeDefaultFeatures.m_126814_(biome);
        BiomeDefaultFeatures.m_126771_(biome);
        addCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder glacierGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_GLACIER).m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_AURORA_PALACE);
        addCaves(biome);
        return biome;
    }
    
    public static void withWoodRoots(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.WOOD_ROOTS_SPREAD);
    }
    
    public static void addDefaultStructures(final BiomeGenerationSettings.Builder biome) {
        biome.m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_HEDGE_MAZE);
        biome.m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_HOLLOW_HILL_SMALL);
        biome.m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_HOLLOW_HILL_MEDIUM);
        biome.m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_HOLLOW_HILL_LARGE);
        biome.m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_NAGA_COURTYARD);
        biome.m_47849_((ConfiguredStructureFeature)TFStructures.CONFIGURED_LICH_TOWER);
    }
    
    public static void commonFeatures(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.SURFACE_STRUCTURES, (ConfiguredFeature)ConfiguredFeatures.DRUID_HUT);
        biome.m_47842_(GenerationStep.Decoration.SURFACE_STRUCTURES, (ConfiguredFeature)ConfiguredFeatures.WELL_PLACER);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.GROVE_RUINS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FOUNDATION);
        commonFeaturesWithoutBuildings(biome);
    }
    
    public static void commonFeaturesWithoutBuildings(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.STONE_CIRCLE);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.OUTSIDE_STALAGMITE);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MONOLITH);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HOLLOW_STUMP);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HOLLOW_LOG);
    }
    
    public static void lilypads(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HUGE_LILY_PAD);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HUGE_WATER_LILY);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126896_);
    }
    
    public static void addForestVegetation(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FOREST_GRASS_PLACER);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FLOWER_PLACER);
    }
    
    public static void addDarkForestVegetation(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARKWOOD_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_FOREST_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_GRASS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_FERNS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_MUSHGLOOMS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_DEAD_BUSHES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_PUMPKINS);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_MUSHROOMS);
    }
    
    public static void addCanopyTrees(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.CANOPY_TREES);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEFAULT_FALLEN_LOGS);
    }
    
    public static void addCanopyMushrooms(final BiomeGenerationSettings.Builder biome, final boolean dense) {
        BiomeDefaultFeatures.m_126730_(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126911_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126912_);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_BIG_MUSH);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)(dense ? ConfiguredFeatures.CANOPY_MUSHROOMS_DENSE : ConfiguredFeatures.CANOPY_MUSHROOMS_SPARSE));
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)(dense ? ConfiguredFeatures.BIG_MUSHGLOOM : ConfiguredFeatures.MUSHGLOOM_CLUSTER));
    }
    
    public static void addHollowOakTrees(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HOLLOW_TREE_PLACER);
    }
    
    public static void addSwampTrees(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SWAMPY_OAK_TREES);
    }
    
    public static void addSmallStoneClusters(final BiomeGenerationSettings.Builder biome) {
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.SMALL_ANDESITE);
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.SMALL_DIORITE);
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.SMALL_GRANITE);
    }
    
    public static BiomeSpecialEffects.Builder whiteAshParticles(final BiomeSpecialEffects.Builder builder) {
        builder.m_48029_(new AmbientParticleSettings((ParticleOptions)ParticleTypes.f_123790_, 0.1f));
        return builder;
    }
    
    public static BiomeSpecialEffects.Builder fireflyForestParticles(final BiomeSpecialEffects.Builder builder) {
        builder.m_48029_(new AmbientParticleSettings((ParticleOptions)TFParticleType.WANDERING_FIREFLY.get(), 0.001f));
        return builder;
    }
    
    public static BiomeSpecialEffects.Builder fireflyParticles(final BiomeSpecialEffects.Builder builder) {
        builder.m_48029_(new AmbientParticleSettings((ParticleOptions)TFParticleType.WANDERING_FIREFLY.get(), 2.5E-4f));
        return builder;
    }
    
    public static void addCaves(final BiomeGenerationSettings.Builder biome) {
        biome.m_47839_(GenerationStep.Carving.AIR, (ConfiguredWorldCarver)ConfiguredWorldCarvers.TFCAVES_CONFIGURED);
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.PLANT_ROOTS);
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TORCH_BERRIES);
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_ROOTS);
        BiomeDefaultFeatures.m_126814_(biome);
    }
    
    public static void addHighlandCaves(final BiomeGenerationSettings.Builder biome) {
        biome.m_47839_(GenerationStep.Carving.AIR, (ConfiguredWorldCarver)ConfiguredWorldCarvers.HIGHLANDCAVES_CONFIGURED);
        biome.m_47842_(GenerationStep.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TROLL_ROOTS);
        BiomeDefaultFeatures.m_126814_(biome);
    }
    
    public static MobSpawnSettings.Builder penguinSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.2f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.PENGUIN, 10, 2, 4));
        return spawnInfo;
    }
    
    public static MobSpawnSettings.Builder darkForestSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.1f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20566_, 1, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20501_, 5, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20524_, 5, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.MIST_WOLF, 10, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.SKELETON_DRUID, 10, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.KING_SPIDER, 10, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.KOBOLD, 10, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20495_, 1, 1, 1));
        return spawnInfo;
    }
    
    public static MobSpawnSettings.Builder snowForestSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.1f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.WINTER_WOLF, 5, 1, 2));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.YETI, 5, 1, 1));
        return spawnInfo;
    }
    
    public static MobSpawnSettings.Builder ravenSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.3f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.RAVEN, 10, 4, 4));
        return spawnInfo;
    }
    
    public static MobSpawnSettings.Builder swampSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.2f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20558_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20501_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.MOSQUITO_SWARM, 10, 1, 1));
        return spawnInfo;
    }
    
    public static MobSpawnSettings.Builder spookSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.4f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20479_, 50, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20524_, 20, 1, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.SKELETON_DRUID, 5, 1, 1));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20549_, 20, 4, 4));
        return spawnInfo;
    }
    
    public static BiomeSpecialEffects.Builder defaultAmbientBuilder() {
        return new BiomeSpecialEffects.Builder().m_48019_(12648408).m_48034_(4159204).m_48037_(329011).m_48040_(2105930).m_48027_(AmbientMoodSettings.f_47387_).m_48021_(ConfiguredFeatures.TFMUSICTYPE);
    }
    
    public static BiomeGenerationSettings.Builder defaultGenSettingBuilder() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().m_47851_(SurfaceBuilders.f_127292_);
        BiomeDefaultFeatures.m_126824_(biome);
        BiomeDefaultFeatures.m_126822_(biome);
        BiomeDefaultFeatures.m_126708_(biome);
        BiomeDefaultFeatures.m_126698_(biome);
        biome.m_47842_(GenerationStep.Decoration.VEGETAL_DECORATION, Features.f_126906_);
        addSmallStoneClusters(biome);
        withWoodRoots(biome);
        addCaves(biome);
        return biome;
    }
    
    public static MobSpawnSettings.Builder defaultMobSpawning() {
        final MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.m_48368_(0.1f);
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.BIGHORN_SHEEP, 12, 4, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.BOAR, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20555_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.DEER, 15, 4, 5));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.f_20499_, 5, 4, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.TINY_BIRD, 15, 4, 8));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.SQUIRREL, 10, 2, 4));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.DWARF_RABBIT, 10, 4, 5));
        spawnInfo.m_48376_(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.RAVEN, 10, 1, 2));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20479_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20501_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20524_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20558_, 1, 4, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20526_, 10, 4, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20566_, 1, 1, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData((EntityType)TFEntities.KOBOLD, 10, 2, 4));
        spawnInfo.m_48376_(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.f_20549_, 10, 1, 2));
        return spawnInfo;
    }
    
    public static Biome.BiomeBuilder biomeWithDefaults(final BiomeSpecialEffects.Builder biomeAmbience, final MobSpawnSettings.Builder mobSpawnInfo, final BiomeGenerationSettings.Builder biomeGenerationSettings) {
        return new Biome.BiomeBuilder().m_47597_(Biome.Precipitation.RAIN).m_47595_(Biome.BiomeCategory.FOREST).m_47593_(0.025f).m_47607_(0.05f).m_47609_(0.5f).m_47611_(0.5f).m_47603_(biomeAmbience.m_48018_()).m_47605_(mobSpawnInfo.m_48381_()).m_47601_(biomeGenerationSettings.m_47831_()).m_47599_(Biome.TemperatureModifier.NONE);
    }
}
