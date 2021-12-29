// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.worldgen.structures.GenDruidHut;
import twilightforest.worldgen.structures.TFGenGraveyard;
import twilightforest.world.feature.tree.SnowUnderTrees;
import twilightforest.world.feature.tree.SnowTreePlacer;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import twilightforest.world.feature.config.CaveStalactiteConfig;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;

public class TFBiomeFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES;
    public static final RegistryObject<Feature<NoFeatureConfig>> BIG_MUSHGLOOM;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> CANOPY_OAK;
    public static final RegistryObject<Feature<CaveStalactiteConfig>> CAVE_STALACTITE;
    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> DARK_CANOPY_TREE;
    public static final RegistryObject<Feature<NoFeatureConfig>> DRUID_HUT;
    public static final RegistryObject<Feature<NoFeatureConfig>> FALLEN_HOLLOW_LOG;
    public static final RegistryObject<Feature<NoFeatureConfig>> FALLEN_LEAVES;
    public static final RegistryObject<Feature<NoFeatureConfig>> FALLEN_SMALL_LOG;
    public static final RegistryObject<Feature<BlockStateFeatureConfig>> FIRE_JET;
    public static final RegistryObject<Feature<NoFeatureConfig>> FOUNDATION;
    public static final RegistryObject<Feature<NoFeatureConfig>> GRAVEYARD;
    public static final RegistryObject<Feature<NoFeatureConfig>> GROVE_RUINS;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> HOLLOW_STUMP;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> HOLLOW_TREE;
    public static final RegistryObject<Feature<NoFeatureConfig>> HUGE_LILY_PAD;
    public static final RegistryObject<Feature<NoFeatureConfig>> HUGE_WATER_LILY;
    public static final RegistryObject<Feature<BlockStateFeatureConfig>> LAMPPOSTS;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> MINERS_TREE;
    public static final RegistryObject<Feature<NoFeatureConfig>> MONOLITH;
    public static final RegistryObject<Feature<SphereReplaceConfig>> MYCELIUM_BLOB;
    public static final RegistryObject<Feature<CaveStalactiteConfig>> OUTSIDE_STALAGMITE;
    public static final RegistryObject<Feature<NoFeatureConfig>> PLANT_ROOTS;
    public static final RegistryObject<Feature<NoFeatureConfig>> STONE_CIRCLE;
    public static final RegistryObject<Feature<NoFeatureConfig>> THORNS;
    public static final RegistryObject<Feature<NoFeatureConfig>> TORCH_BERRIES;
    public static final RegistryObject<Feature<TFTreeFeatureConfig>> TREE_OF_TIME;
    public static final RegistryObject<Feature<NoFeatureConfig>> TROLL_ROOTS;
    public static final RegistryObject<Feature<NoFeatureConfig>> WEBS;
    public static final RegistryObject<Feature<NoFeatureConfig>> WELL;
    public static final RegistryObject<Feature<NoFeatureConfig>> WOOD_ROOTS;
    public static final RegistryObject<Feature<NoFeatureConfig>> SNOW_UNDER_TREES;
    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> SNOW_TREE;
    public static final RegistryObject<Feature<BlockClusterFeatureConfig>> DARK_FOREST_PLACER;
    
    static {
        FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, "twilightforest");
        BIG_MUSHGLOOM = TFBiomeFeatures.FEATURES.register("big_mushgloom", () -> new TFGenBigMushgloom((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        CANOPY_OAK = TFBiomeFeatures.FEATURES.register("canopy_oak", () -> new TFGenCanopyOak(TFTreeFeatureConfig.codecTFTreeConfig));
        CAVE_STALACTITE = TFBiomeFeatures.FEATURES.register("cave_stalactite", () -> new TFGenCaveStalactite(CaveStalactiteConfig.caveStalactiteCodec));
        DARK_CANOPY_TREE = TFBiomeFeatures.FEATURES.register("dark_canopy_tree", () -> new TFGenDarkCanopyTree((Codec<BaseTreeFeatureConfig>)BaseTreeFeatureConfig.field_236676_a_));
        DRUID_HUT = TFBiomeFeatures.FEATURES.register("druid_hut", () -> new GenDruidHut((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        FALLEN_HOLLOW_LOG = TFBiomeFeatures.FEATURES.register("fallen_hollow_log", () -> new TFGenFallenHollowLog((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        FALLEN_LEAVES = TFBiomeFeatures.FEATURES.register("fallen_leaves", () -> new TFGenFallenLeaves((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        FALLEN_SMALL_LOG = TFBiomeFeatures.FEATURES.register("fallen_small_log", () -> new TFGenFallenSmallLog((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        FIRE_JET = TFBiomeFeatures.FEATURES.register("fire_jet", () -> new TFGenFireJet((Codec<BlockStateFeatureConfig>)BlockStateFeatureConfig.field_236455_a_));
        FOUNDATION = TFBiomeFeatures.FEATURES.register("foundation", () -> new TFGenFoundation((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        GRAVEYARD = TFBiomeFeatures.FEATURES.register("graveyard", () -> new TFGenGraveyard((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        GROVE_RUINS = TFBiomeFeatures.FEATURES.register("grove_ruins", () -> new TFGenGroveRuins((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        HOLLOW_STUMP = TFBiomeFeatures.FEATURES.register("hollow_stump", () -> new TFGenHollowStump(TFTreeFeatureConfig.codecTFTreeConfig));
        HOLLOW_TREE = TFBiomeFeatures.FEATURES.register("hollow_tree", () -> new TFGenHollowTree(TFTreeFeatureConfig.codecTFTreeConfig));
        HUGE_LILY_PAD = TFBiomeFeatures.FEATURES.register("huge_lily_pad", () -> new TFGenHugeLilyPad((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        HUGE_WATER_LILY = TFBiomeFeatures.FEATURES.register("huge_water_lily", () -> new TFGenHugeWaterLily((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        LAMPPOSTS = TFBiomeFeatures.FEATURES.register("lampposts", () -> new TFGenLampposts((Codec<BlockStateFeatureConfig>)BlockStateFeatureConfig.field_236455_a_));
        MINERS_TREE = TFBiomeFeatures.FEATURES.register("miners_tree", () -> new TFGenMinersTree(TFTreeFeatureConfig.codecTFTreeConfig));
        MONOLITH = TFBiomeFeatures.FEATURES.register("monolith", () -> new TFGenMonolith((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        MYCELIUM_BLOB = TFBiomeFeatures.FEATURES.register("mycelium_blob", () -> new TFGenMyceliumBlob((Codec<SphereReplaceConfig>)SphereReplaceConfig.field_236516_a_));
        OUTSIDE_STALAGMITE = TFBiomeFeatures.FEATURES.register("outside_stalagmite", () -> new TFGenOutsideStalagmite(CaveStalactiteConfig.caveStalactiteCodec));
        PLANT_ROOTS = TFBiomeFeatures.FEATURES.register("plant_roots", () -> new TFGenPlantRoots((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        STONE_CIRCLE = TFBiomeFeatures.FEATURES.register("stone_circle", () -> new TFGenStoneCircle((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        THORNS = TFBiomeFeatures.FEATURES.register("thorns", () -> new TFGenThorns((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        TORCH_BERRIES = TFBiomeFeatures.FEATURES.register("torch_berries", () -> new TFGenTorchBerries((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        TREE_OF_TIME = TFBiomeFeatures.FEATURES.register("tree_of_time", () -> new TFGenTreeOfTime(TFTreeFeatureConfig.codecTFTreeConfig));
        TROLL_ROOTS = TFBiomeFeatures.FEATURES.register("troll_roots", () -> new TFGenTrollRoots((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        WEBS = TFBiomeFeatures.FEATURES.register("webs", () -> new TFGenWebs((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        WELL = TFBiomeFeatures.FEATURES.register("well", () -> new TFGenWell((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        WOOD_ROOTS = TFBiomeFeatures.FEATURES.register("wood_roots", () -> new TFGenWoodRoots((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        SNOW_UNDER_TREES = TFBiomeFeatures.FEATURES.register("snow_under_trees", () -> new SnowUnderTrees((Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_));
        SNOW_TREE = TFBiomeFeatures.FEATURES.register("anywhere_tree", () -> new SnowTreePlacer((Codec<BaseTreeFeatureConfig>)BaseTreeFeatureConfig.field_236676_a_));
        DARK_FOREST_PLACER = TFBiomeFeatures.FEATURES.register("dark_forest_placer", () -> new TFGenDarkForestFeature((Codec<BlockClusterFeatureConfig>)BlockClusterFeatureConfig.field_236587_a_));
    }
}
