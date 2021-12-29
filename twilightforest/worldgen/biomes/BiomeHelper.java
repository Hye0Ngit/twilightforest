// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import twilightforest.worldgen.ConfiguredWorldCarvers;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.gen.feature.StructureFeature;
import twilightforest.TFStructures;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import twilightforest.worldgen.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import twilightforest.worldgen.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.BiomeGenerationSettings;

public abstract class BiomeHelper
{
    public static BiomeGenerationSettings.Builder twilightForestGen(final BiomeGenerationSettings.Builder biome) {
        addForestVegetation(biome);
        addCanopyTrees(biome);
        addTwilightOakTrees(biome);
        addTwilightOakTrees(biome);
        addHollowOakTrees(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder denseForestGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243876_bV);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243876_bV);
        addForestVegetation(biome);
        addCanopyTrees(biome);
        addCanopyTrees(biome);
        addTwilightOakTrees(biome);
        addTwilightOakTrees(biome);
        addHollowOakTrees(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder fireflyForestGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.LAMPPOST);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MUSHGLOOM_CLUSTER);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243845_ar);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243931_cn);
        addForestVegetation(biome);
        addFireflyCanopyTrees(biome);
        addTwilightOakTrees(biome);
        addHollowOakTrees(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder oakSavannaGen(final BiomeGenerationSettings.Builder biome) {
        addForestVegetation(biome);
        addRareOakTrees(biome);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder enchantedForestGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FIDDLEHEAD);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243788_N);
        addForestVegetation(biome);
        addRainbowOaks(biome);
        addCanopyTrees(biome);
        addHollowOakTrees(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder spookyForestGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.PUMPKIN_LAMPPOST);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.GRASS_PLACER);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SMALL_LOG);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.WEBS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FALLEN_LEAVES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243845_ar);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243805_aD);
        biome.func_242513_a(GenerationStage.Decoration.SURFACE_STRUCTURES, (ConfiguredFeature)ConfiguredFeatures.GRAVEYARD);
        addDeadCanopyTrees(biome);
        addTwilightOakTrees(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder mushroomForestGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MYCELIUM_BLOB);
        addForestVegetation(biome);
        addTwilightOakTrees(biome);
        addHollowOakTrees(biome);
        addCanopyMushrooms(biome, false);
        addDefaultStructures(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder denseMushroomForestGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MYCELIUM_BLOB);
        addForestVegetation(biome);
        addTwilightOakTrees(biome);
        addHollowOakTrees(biome);
        addCanopyMushrooms(biome, true);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder thornlandsGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_PLATEAU);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RANDOM_COMMON_FEATURE);
        addThorns(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder highlandsGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_HIGHLANDS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RANDOM_COMMON_FEATURE);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243872_bR);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MEGA_SPRUCE_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243866_bL);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243872_bR);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243866_bL);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243779_E);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243802_aA);
        addSmallStoneClusters(biome);
        addHighlandCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder swampGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RANDOM_WATER_FEATURE);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243817_aP);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243788_N);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243805_aD);
        addForestVegetation(biome);
        addMangroveTrees(biome);
        addSwampTrees(biome);
        addHollowOakTrees(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder fireSwampGen(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.GRASS_PLACER);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FIRE_JET);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SMOKER);
        biome.func_242513_a(GenerationStage.Decoration.LAKES, Features.field_243790_P);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243817_aP);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243788_N);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243882_bb);
        addSwampTrees(biome);
        addHollowOakTrees(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder darkForestGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a(net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders.field_244178_j);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_GRASS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_FERNS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_MUSHGLOOMS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_MUSHROOMS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_PUMPKINS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_DEAD_BUSHES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.BUSH_DARK_FOREST_TREES);
        addDarkwoodTrees(biome);
        addCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder darkForestCenterGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a(net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders.field_244178_j);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_GRASS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_FERNS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_MUSHGLOOMS);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARK_DEAD_BUSHES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.BUSH_DARK_FOREST_TREES);
        addDarkwoodTrees(biome);
        addCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder snowyForestGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_SNOW);
        biome.func_242513_a(GenerationStage.Decoration.LAKES, Features.field_243789_O);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RANDOM_COMMON_FEATURE);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SMALL_LOG);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SNOW_SPRUCE_SNOWY);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MEGA_SPRUCE_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SNOW_SPRUCE_SNOWY);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MEGA_SPRUCE_TREES);
        biome.func_242513_a(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, (ConfiguredFeature)ConfiguredFeatures.SNOW_UNDER_TREES);
        DefaultBiomeFeatures.func_243750_j(biome);
        DefaultBiomeFeatures.func_243730_an(biome);
        addCaves(biome);
        return biome;
    }
    
    public static BiomeGenerationSettings.Builder glacierGen() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a(net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders.field_244178_j);
        addCaves(biome);
        return biome;
    }
    
    public static void withWoodRoots(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.WOOD_ROOTS_SPREAD);
    }
    
    public static BiomeGenerationSettings.Builder addDefaultStructures(final BiomeGenerationSettings.Builder biome) {
        return biome.func_242516_a((StructureFeature)TFStructures.CONFIGURED_HEDGE_MAZE).func_242516_a((StructureFeature)TFStructures.CONFIGURED_HOLLOW_HILL_SMALL).func_242516_a((StructureFeature)TFStructures.CONFIGURED_HOLLOW_HILL_MEDIUM).func_242516_a((StructureFeature)TFStructures.CONFIGURED_HOLLOW_HILL_LARGE).func_242516_a((StructureFeature)TFStructures.CONFIGURED_NAGA_COURTYARD).func_242516_a((StructureFeature)TFStructures.CONFIGURED_LICH_TOWER);
    }
    
    public static void addThorns(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.THORNS);
    }
    
    public static void addForestVegetation(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FOREST_GRASS_PLACER);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FLOWER_PLACER);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RANDOM_COMMON_FEATURE);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RANDOM_FALLEN_FEATURE);
    }
    
    public static void addCanopyTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.CANOPY_TREES);
    }
    
    public static void addFireflyCanopyTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.FIREFLY_CANOPY_TREE_MIX);
    }
    
    public static void addDeadCanopyTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DEAD_CANOPY_TREES);
    }
    
    public static void addCanopyMushrooms(final BiomeGenerationSettings.Builder biome, final boolean dense) {
        DefaultBiomeFeatures.func_243712_Z(biome);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243825_aX);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243826_aY);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_BIG_MUSH);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)(dense ? ConfiguredFeatures.CANOPY_MUSHROOMS_DENSE : ConfiguredFeatures.CANOPY_MUSHROOMS_SPARSE));
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)(dense ? ConfiguredFeatures.BIG_MUSHGLOOM : ConfiguredFeatures.MUSHGLOOM_CLUSTER));
    }
    
    public static void addRainbowOaks(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.RAINBOW_OAK_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.LARGE_RAINBOW_OAK_TREES);
    }
    
    public static void addMangroveTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.MANGROVE_TREES);
    }
    
    public static void addDarkwoodTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.DARKWOOD_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.BUSH_DARK_FOREST_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.OAK_DARK_FOREST_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.BIRCH_DARK_FOREST_TREES);
    }
    
    public static void addTwilightOakTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_OAK);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_BIRCH);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TWILIGHT_OAK_TREES);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_OAK);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.VANILLA_TF_BIRCH);
    }
    
    public static void addHollowOakTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.HOLLOW_TREE_PLACER);
    }
    
    public static void addRareOakTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.OAK_TREES_SPARSE);
    }
    
    public static void addSwampTrees(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, (ConfiguredFeature)ConfiguredFeatures.SWAMPY_OAK_TREES);
    }
    
    public static void addSmallStoneClusters(final BiomeGenerationSettings.Builder biome) {
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.SMALL_ANDESITE);
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.SMALL_DIORITE);
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)ConfiguredFeatures.SMALL_GRANITE);
    }
    
    public static BiomeAmbience.Builder whiteAshParticles(final BiomeAmbience.Builder builder) {
        builder.func_235244_a_(new ParticleEffectAmbience((IParticleData)ParticleTypes.field_239820_at_, 0.2f));
        return builder;
    }
    
    public static void addCaves(final BiomeGenerationSettings.Builder biome) {
        biome.func_242512_a(GenerationStage.Carving.AIR, (ConfiguredCarver)ConfiguredWorldCarvers.TFCAVES_CONFIGURED);
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.PLANT_ROOTS);
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TORCH_BERRIES);
    }
    
    public static void addHighlandCaves(final BiomeGenerationSettings.Builder biome) {
        biome.func_242512_a(GenerationStage.Carving.AIR, (ConfiguredCarver)ConfiguredWorldCarvers.HIGHLANDCAVES_CONFIGURED);
        biome.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, (ConfiguredFeature)ConfiguredFeatures.TROLL_ROOTS);
    }
    
    public static MobSpawnInfo.Builder penguinSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.2f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.penguin, 10, 2, 4));
        return spawnInfo;
    }
    
    public static MobSpawnInfo.Builder darkForestSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.1f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200803_q, 1, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200725_aD, 5, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200741_ag, 5, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.mist_wolf, 10, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.skeleton_druid, 10, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.king_spider, 10, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.kobold, 10, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200759_ay, 1, 1, 1));
        return spawnInfo;
    }
    
    public static MobSpawnInfo.Builder snowForestSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.1f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.winter_wolf, 5, 1, 2));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.yeti, 5, 1, 1));
        return spawnInfo;
    }
    
    public static MobSpawnInfo.Builder ravenSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.3f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.raven, 10, 4, 4));
        return spawnInfo;
    }
    
    public static MobSpawnInfo.Builder swampSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.2f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200797_k, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200725_aD, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.mosquito_swarm, 10, 1, 1));
        return spawnInfo;
    }
    
    public static MobSpawnInfo.Builder spookSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.4f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200748_an, 50, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200741_ag, 20, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.skeleton_druid, 5, 1, 1));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200791_e, 20, 4, 4));
        return spawnInfo;
    }
    
    public static BiomeAmbience.Builder defaultAmbientBuilder() {
        return new BiomeAmbience.Builder().func_235239_a_(12648408).func_235246_b_(4159204).func_235248_c_(329011).func_242539_d(2105930).func_235243_a_(MoodSoundAmbience.field_235027_b_).func_235240_a_(ConfiguredFeatures.TFMUSICTYPE);
    }
    
    public static BiomeGenerationSettings.Builder defaultGenSettingBuilder() {
        final BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder().func_242517_a((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_TF_DEFAULT);
        DefaultBiomeFeatures.func_243750_j(biome);
        DefaultBiomeFeatures.func_243755_o(biome);
        DefaultBiomeFeatures.func_243701_O(biome);
        DefaultBiomeFeatures.func_243696_J(biome);
        biome.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243820_aS);
        DefaultBiomeFeatures.func_243727_ak(biome);
        addSmallStoneClusters(biome);
        withWoodRoots(biome);
        addCaves(biome);
        return biome;
    }
    
    public static MobSpawnInfo.Builder defaultMobSpawning() {
        final MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder();
        spawnInfo.func_242572_a(0.1f);
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.bighorn_sheep, 12, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.wild_boar, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200795_i, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.deer, 15, 4, 5));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.field_200724_aC, 5, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.tiny_bird, 15, 4, 8));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.squirrel, 10, 2, 4));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.bunny, 10, 4, 5));
        spawnInfo.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners((EntityType)TFEntities.raven, 10, 1, 2));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200748_an, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200725_aD, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200741_ag, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200797_k, 1, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200743_ai, 10, 4, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200803_q, 1, 1, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners((EntityType)TFEntities.kobold, 10, 2, 4));
        spawnInfo.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.field_200791_e, 10, 1, 2));
        return spawnInfo;
    }
    
    public static Biome.Builder biomeWithDefaults(final BiomeAmbience.Builder biomeAmbience, final MobSpawnInfo.Builder mobSpawnInfo, final BiomeGenerationSettings.Builder biomeGenerationSettings) {
        return new Biome.Builder().func_205415_a(Biome.RainType.RAIN).func_205419_a(Biome.Category.FOREST).func_205421_a(0.1f).func_205420_b(0.2f).func_205414_c(0.5f).func_205417_d(0.5f).func_235097_a_(biomeAmbience.func_235238_a_()).func_242458_a(mobSpawnInfo.func_242577_b()).func_242457_a(biomeGenerationSettings.func_242508_a()).func_242456_a(Biome.TemperatureModifier.NONE);
    }
}
