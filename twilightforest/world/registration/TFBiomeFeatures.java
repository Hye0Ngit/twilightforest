// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.world.components.feature.TFGenBigMushgloom;
import twilightforest.world.components.feature.BlockSpikeFeature;
import twilightforest.world.components.feature.trees.TFGenDarkCanopyTree;
import twilightforest.world.components.feature.templates.DruidHutFeature;
import twilightforest.world.components.feature.TFGenFallenHollowLog;
import twilightforest.world.components.feature.TFGenFallenLeaves;
import twilightforest.world.components.feature.TFGenFallenSmallLog;
import twilightforest.world.components.feature.TFGenFireJet;
import twilightforest.world.components.feature.TFGenFoundation;
import twilightforest.world.components.feature.templates.GraveyardFeature;
import twilightforest.world.components.feature.templates.GroveRuinsFeature;
import twilightforest.world.components.feature.trees.TFGenHollowStump;
import twilightforest.world.components.feature.trees.TFGenHollowTree;
import twilightforest.world.components.feature.TFGenHugeLilyPad;
import twilightforest.world.components.feature.TFGenHugeWaterLily;
import twilightforest.world.components.feature.TFGenLampposts;
import twilightforest.world.components.feature.trees.TFGenLargeWinter;
import twilightforest.world.components.feature.trees.TFGenMinersTree;
import twilightforest.world.components.feature.TFGenMonolith;
import twilightforest.world.components.feature.CheckAbovePatchFeature;
import twilightforest.world.components.feature.UndergroundPlantFeature;
import twilightforest.world.components.feature.templates.StoneCircleFeature;
import twilightforest.world.components.feature.TwilightThorns;
import twilightforest.world.components.feature.trees.TFGenTreeOfTime;
import twilightforest.world.components.feature.TFGenWebs;
import twilightforest.world.components.feature.templates.SimpleWellFeature;
import twilightforest.world.components.feature.templates.FancyWellFeature;
import twilightforest.world.components.feature.TFGenWoodRoots;
import twilightforest.world.components.feature.trees.growers.SnowUnderTrees;
import twilightforest.world.components.feature.trees.growers.SnowTreePlacer;
import com.mojang.serialization.Codec;
import twilightforest.world.components.feature.TFGenDarkForestFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import twilightforest.world.components.feature.config.ThornsConfig;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import twilightforest.world.components.feature.config.HollowLogConfig;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import twilightforest.world.components.feature.config.SpikeConfig;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;

public class TFBiomeFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BIG_MUSHGLOOM;
    public static final RegistryObject<Feature<SpikeConfig>> CAVE_STALACTITE;
    public static final RegistryObject<Feature<TreeConfiguration>> DARK_CANOPY_TREE;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DRUID_HUT;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FALLEN_HOLLOW_LOG;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FALLEN_LEAVES;
    public static final RegistryObject<Feature<HollowLogConfig>> FALLEN_SMALL_LOG;
    public static final RegistryObject<Feature<BlockStateConfiguration>> FIRE_JET;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FOUNDATION;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GRAVEYARD;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GROVE_RUINS;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> HOLLOW_STUMP;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> HOLLOW_TREE;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HUGE_LILY_PAD;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HUGE_WATER_LILY;
    public static final RegistryObject<Feature<BlockStateConfiguration>> LAMPPOSTS;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> LARGE_WINTER_TREE;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> MINERS_TREE;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MONOLITH;
    public static final RegistryObject<Feature<DiskConfiguration>> MYCELIUM_BLOB;
    public static final RegistryObject<Feature<BlockStateConfiguration>> UNDERGROUND_PLANTS;
    public static final RegistryObject<Feature<BlockStateConfiguration>> TROLL_VINES;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> STONE_CIRCLE;
    public static final RegistryObject<Feature<ThornsConfig>> THORNS;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> TREE_OF_TIME;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WEBS;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SIMPLE_WELL;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FANCY_WELL;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WOOD_ROOTS;
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SNOW_UNDER_TREES;
    public static final RegistryObject<Feature<TreeConfiguration>> SNOW_TREE;
    public static final RegistryObject<Feature<RandomPatchConfiguration>> DARK_FOREST_PLACER;
    
    static {
        FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, "twilightforest");
        BIG_MUSHGLOOM = TFBiomeFeatures.FEATURES.register("big_mushgloom", () -> new TFGenBigMushgloom((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        CAVE_STALACTITE = TFBiomeFeatures.FEATURES.register("block_spike", () -> new BlockSpikeFeature(SpikeConfig.CODEC));
        DARK_CANOPY_TREE = TFBiomeFeatures.FEATURES.register("dark_canopy_tree", () -> new TFGenDarkCanopyTree((Codec<TreeConfiguration>)TreeConfiguration.f_68184_));
        DRUID_HUT = TFBiomeFeatures.FEATURES.register("druid_hut", () -> new DruidHutFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        FALLEN_HOLLOW_LOG = TFBiomeFeatures.FEATURES.register("fallen_hollow_log", () -> new TFGenFallenHollowLog((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        FALLEN_LEAVES = TFBiomeFeatures.FEATURES.register("fallen_leaves", () -> new TFGenFallenLeaves((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        FALLEN_SMALL_LOG = TFBiomeFeatures.FEATURES.register("fallen_small_log", () -> new TFGenFallenSmallLog(HollowLogConfig.CODEC));
        FIRE_JET = TFBiomeFeatures.FEATURES.register("fire_jet", () -> new TFGenFireJet((Codec<BlockStateConfiguration>)BlockStateConfiguration.f_67546_));
        FOUNDATION = TFBiomeFeatures.FEATURES.register("foundation", () -> new TFGenFoundation((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        GRAVEYARD = TFBiomeFeatures.FEATURES.register("graveyard", () -> new GraveyardFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        GROVE_RUINS = TFBiomeFeatures.FEATURES.register("grove_ruins", () -> new GroveRuinsFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        HOLLOW_STUMP = TFBiomeFeatures.FEATURES.register("hollow_stump", () -> new TFGenHollowStump(TFTreeFeatureConfig.codecTFTreeConfig));
        HOLLOW_TREE = TFBiomeFeatures.FEATURES.register("hollow_tree", () -> new TFGenHollowTree(TFTreeFeatureConfig.codecTFTreeConfig));
        HUGE_LILY_PAD = TFBiomeFeatures.FEATURES.register("huge_lily_pad", () -> new TFGenHugeLilyPad((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        HUGE_WATER_LILY = TFBiomeFeatures.FEATURES.register("huge_water_lily", () -> new TFGenHugeWaterLily((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        LAMPPOSTS = TFBiomeFeatures.FEATURES.register("lampposts", () -> new TFGenLampposts((Codec<BlockStateConfiguration>)BlockStateConfiguration.f_67546_));
        LARGE_WINTER_TREE = TFBiomeFeatures.FEATURES.register("large_winter_tree", () -> new TFGenLargeWinter(TFTreeFeatureConfig.codecTFTreeConfig));
        MINERS_TREE = TFBiomeFeatures.FEATURES.register("miners_tree", () -> new TFGenMinersTree(TFTreeFeatureConfig.codecTFTreeConfig));
        MONOLITH = TFBiomeFeatures.FEATURES.register("monolith", () -> new TFGenMonolith((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        MYCELIUM_BLOB = TFBiomeFeatures.FEATURES.register("mycelium_blob", () -> new CheckAbovePatchFeature((Codec<DiskConfiguration>)DiskConfiguration.f_67618_));
        UNDERGROUND_PLANTS = TFBiomeFeatures.FEATURES.register("underground_plants", () -> new UndergroundPlantFeature((Codec<BlockStateConfiguration>)BlockStateConfiguration.f_67546_, false));
        TROLL_VINES = TFBiomeFeatures.FEATURES.register("troll_vines", () -> new UndergroundPlantFeature((Codec<BlockStateConfiguration>)BlockStateConfiguration.f_67546_, true));
        STONE_CIRCLE = TFBiomeFeatures.FEATURES.register("stone_circle", () -> new StoneCircleFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        THORNS = TFBiomeFeatures.FEATURES.register("thorns", () -> new TwilightThorns(ThornsConfig.CODEC));
        TREE_OF_TIME = TFBiomeFeatures.FEATURES.register("tree_of_time", () -> new TFGenTreeOfTime(TFTreeFeatureConfig.codecTFTreeConfig));
        WEBS = TFBiomeFeatures.FEATURES.register("webs", () -> new TFGenWebs((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        SIMPLE_WELL = TFBiomeFeatures.FEATURES.register("simple_well", () -> new SimpleWellFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        FANCY_WELL = TFBiomeFeatures.FEATURES.register("fancy_well", () -> new FancyWellFeature((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        WOOD_ROOTS = TFBiomeFeatures.FEATURES.register("wood_roots", () -> new TFGenWoodRoots((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        SNOW_UNDER_TREES = TFBiomeFeatures.FEATURES.register("snow_under_trees", () -> new SnowUnderTrees((Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_));
        SNOW_TREE = TFBiomeFeatures.FEATURES.register("anywhere_tree", () -> new SnowTreePlacer((Codec<TreeConfiguration>)TreeConfiguration.f_68184_));
        DARK_FOREST_PLACER = TFBiomeFeatures.FEATURES.register("dark_forest_placer", () -> new TFGenDarkForestFeature((Codec<RandomPatchConfiguration>)RandomPatchConfiguration.f_67902_));
    }
}
