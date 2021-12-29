// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen;

import java.util.OptionalInt;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import twilightforest.worldgen.treeplacers.TreeCorePlacer;
import twilightforest.block.TFLogBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.block.LanternBlock;
import twilightforest.worldgen.treeplacers.TreeRootsDecorator;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import twilightforest.worldgen.treeplacers.TrunkRiser;
import net.minecraft.block.Blocks;
import twilightforest.worldgen.treeplacers.DangleFromTreeDecorator;
import twilightforest.worldgen.treeplacers.TrunkSideDecorator;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import twilightforest.block.FireflyBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import twilightforest.worldgen.treeplacers.BranchingTrunkPlacer;
import twilightforest.worldgen.treeplacers.BranchesConfig;
import twilightforest.worldgen.treeplacers.LeafSpheroidFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.AbstractFeatureSizeType;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.feature.FeatureSpread;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;

public final class TreeConfigurations
{
    private static final int canopyDistancing = 5;
    public static final BaseTreeFeatureConfig TWILIGHT_OAK;
    public static final BaseTreeFeatureConfig SWAMPY_OAK;
    private static final int LEAF_SHAG_FACTOR = 24;
    public static final BaseTreeFeatureConfig CANOPY_TREE;
    public static final BaseTreeFeatureConfig CANOPY_TREE_FIREFLY;
    public static final BaseTreeFeatureConfig CANOPY_TREE_DEAD;
    public static final BaseTreeFeatureConfig MANGROVE_TREE;
    private static final SimpleBlockStateProvider DARKWOOD_LEAVES_PROVIDER;
    public static final BaseTreeFeatureConfig DARKWOOD_TREE;
    public static final BaseTreeFeatureConfig DARKWOOD_LANTERN_TREE;
    public static final BaseTreeFeatureConfig BIG_SPRUCE;
    public static final TFTreeFeatureConfig TIME_TREE;
    public static final BaseTreeFeatureConfig TRANSFORM_TREE;
    public static final TFTreeFeatureConfig MINING_TREE;
    public static final BaseTreeFeatureConfig SORT_TREE;
    public static final TFTreeFeatureConfig DENSE_OAK;
    public static final TFTreeFeatureConfig HOLLOW_TREE;
    public static final BaseTreeFeatureConfig RAINBOAK_TREE;
    public static final BaseTreeFeatureConfig LARGE_RAINBOAK_TREE;
    public static final BaseTreeFeatureConfig MUSHROOM_BROWN;
    public static final BaseTreeFeatureConfig MUSHROOM_RED;
    
    static {
        TWILIGHT_OAK = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LEAVES), (FoliagePlacer)new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), (AbstractTrunkPlacer)new StraightTrunkPlacer(4, 2, 0), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).func_225568_b_();
        SWAMPY_OAK = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LEAVES), (FoliagePlacer)new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), (AbstractTrunkPlacer)new StraightTrunkPlacer(4, 2, 0), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS, (Object)LeaveVineTreeDecorator.field_236871_b_)).func_225568_b_();
        CANOPY_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.CANOPY_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.CANOPY_LEAVES), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, -0.25f, 24), (AbstractTrunkPlacer)new BranchingTrunkPlacer(20, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (AbstractFeatureSizeType)new TwoLayerFeature(20, 0, 5)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY, (Object)TreeDecorators.LIVING_ROOTS)).func_236700_a_().func_225568_b_();
        CANOPY_TREE_FIREFLY = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.CANOPY_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.CANOPY_LEAVES), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, -0.25f, 24), (AbstractTrunkPlacer)new BranchingTrunkPlacer(20, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (AbstractFeatureSizeType)new TwoLayerFeature(20, 0, 5)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS, (Object)TreeDecorators.FIREFLY, (Object)new TrunkSideDecorator(4, 0.5f, (BlockStateProvider)new SimpleBlockStateProvider((BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)FireflyBlock.field_176387_N, (Comparable)Direction.NORTH))), (Object)new DangleFromTreeDecorator(0, 1, 2, 5, 15, (BlockStateProvider)new SimpleBlockStateProvider(((Block)TFBlocks.canopy_fence.get()).func_176223_P()), (BlockStateProvider)new SimpleBlockStateProvider(((Block)TFBlocks.firefly_jar.get()).func_176223_P())), (Object)new DangleFromTreeDecorator(0, 1, 2, 5, 15, (BlockStateProvider)new SimpleBlockStateProvider(Blocks.field_235341_dI_.func_176223_P()), (BlockStateProvider)new SimpleBlockStateProvider(((Block)TFBlocks.firefly_jar.get()).func_176223_P())))).func_236700_a_().func_225568_b_();
        CANOPY_TREE_DEAD = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.CANOPY_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.AIR), (FoliagePlacer)new LeafSpheroidFoliagePlacer(0.0f, 0.0f, FeatureSpread.func_242252_a(0), 0, 0, 0.0f, 0), (AbstractTrunkPlacer)new BranchingTrunkPlacer(20, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (AbstractFeatureSizeType)new TwoLayerFeature(20, 0, 5)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY, (Object)TreeDecorators.LIVING_ROOTS)).func_236700_a_().func_225568_b_();
        MANGROVE_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MANGROVE_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MANGROVE_LEAVES), (FoliagePlacer)new LeafSpheroidFoliagePlacer(2.5f, 1.5f, FeatureSpread.func_242252_a(0), 2, 0, -0.25f, 15), (AbstractTrunkPlacer)new TrunkRiser(5, new BranchingTrunkPlacer(6, 4, 0, 1, new BranchesConfig(0, 3, 6.0, 2.0, 0.3, 0.25), false)), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236701_a_(6).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY, (Object)new TreeRootsDecorator(3, 1, 12, (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MANGROVE_WOOD), (BlockStateProvider)new WeightedBlockStateProvider().func_227407_a_(BlockConstants.ROOTS, 4).func_227407_a_(((Block)TFBlocks.liveroot_block.get()).func_176223_P(), 1)), (Object)LeaveVineTreeDecorator.field_236871_b_)).func_225568_b_();
        DARKWOOD_LEAVES_PROVIDER = new SimpleBlockStateProvider(BlockConstants.DARKWOOD_LEAVES);
        DARKWOOD_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.DARKWOOD_LOG), (BlockStateProvider)TreeConfigurations.DARKWOOD_LEAVES_PROVIDER, (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 2.25f, FeatureSpread.func_242252_a(0), 1, 0, 0.45f, 36), (AbstractTrunkPlacer)new BranchingTrunkPlacer(6, 2, 2, 4, new BranchesConfig(4, 0, 10.0, 4.0, 0.23, 0.23), false), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236700_a_().func_225568_b_();
        DARKWOOD_LANTERN_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.DARKWOOD_LOG), (BlockStateProvider)TreeConfigurations.DARKWOOD_LEAVES_PROVIDER, (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 2.25f, FeatureSpread.func_242252_a(0), 1, 0, 0.45f, 36), (AbstractTrunkPlacer)new BranchingTrunkPlacer(6, 2, 2, 4, new BranchesConfig(4, 0, 10.0, 4.0, 0.23, 0.23), false), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS, (Object)new DangleFromTreeDecorator(0, 1, 2, 4, 2, (BlockStateProvider)new SimpleBlockStateProvider(Blocks.field_235341_dI_.func_176223_P()), (BlockStateProvider)new SimpleBlockStateProvider((BlockState)Blocks.field_222432_lU.func_176223_P().func_206870_a((Property)LanternBlock.field_220278_a, (Comparable)true))))).func_236700_a_().func_225568_b_();
        BIG_SPRUCE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.SPRUCE_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.SPRUCE_LEAVES), (FoliagePlacer)new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), FeatureSpread.func_242253_a(13, 4)), (AbstractTrunkPlacer)new GiantTrunkPlacer(13, 2, 14), (AbstractFeatureSizeType)new TwoLayerFeature(1, 1, 2)).func_225568_b_();
        TIME_TREE = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TIME_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TIME_LEAVES), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TIME_WOOD), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.time_sapling.get()).build();
        TRANSFORM_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TRANSFORM_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TRANSFORM_LEAVES), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, -0.25f, 0), (AbstractTrunkPlacer)new BranchingTrunkPlacer(6, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (AbstractFeatureSizeType)new TwoLayerFeature(20, 0, 5)).func_236700_a_().func_236703_a_((List)ImmutableList.of((Object)new TreeCorePlacer(3, (BlockStateProvider)new SimpleBlockStateProvider((BlockState)((Block)TFBlocks.transformation_log_core.get()).func_176223_P().func_206870_a((Property)TFLogBlock.field_176298_M, (Comparable)Direction.Axis.Y))))).func_225568_b_();
        MINING_TREE = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MINING_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MINING_LEAVES), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MINING_WOOD), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.mining_sapling.get()).build();
        SORT_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.SORT_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.SORT_LEAVES), (FoliagePlacer)new LeafSpheroidFoliagePlacer(1.5f, 2.25f, FeatureSpread.func_242252_a(0), 1, 0, 0.5f, 0), (AbstractTrunkPlacer)new StraightTrunkPlacer(3, 0, 0), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236700_a_().func_236703_a_((List)ImmutableList.of((Object)new TreeCorePlacer(1, (BlockStateProvider)new SimpleBlockStateProvider((BlockState)((Block)TFBlocks.sorting_log_core.get()).func_176223_P().func_206870_a((Property)TFLogBlock.field_176298_M, (Comparable)Direction.Axis.Y))))).func_225568_b_();
        DENSE_OAK = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LEAVES), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_WOOD), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.oak_sapling.get()).build();
        HOLLOW_TREE = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LEAVES), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_WOOD), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.hollow_oak_sapling.get()).build();
        RAINBOAK_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.RAINBOW_LEAVES), (FoliagePlacer)new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), (AbstractTrunkPlacer)new StraightTrunkPlacer(4, 2, 0), (AbstractFeatureSizeType)new TwoLayerFeature(1, 0, 1)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).func_225568_b_();
        LARGE_RAINBOAK_TREE = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.TOAK_LOG), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.RAINBOW_LEAVES), (FoliagePlacer)new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), (AbstractTrunkPlacer)new FancyTrunkPlacer(3, 11, 0), (AbstractFeatureSizeType)new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).func_225568_b_();
        MUSHROOM_BROWN = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MUSHROOM_STEM), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MUSHROOM_CAP_BROWN), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.25f, 0.0f, FeatureSpread.func_242252_a(1), 1, 0, 0.0f, 0), (AbstractTrunkPlacer)new BranchingTrunkPlacer(12, 5, 5, 6, new BranchesConfig(3, 1, 9.0, 1.0, 0.3, 0.2), true), (AbstractFeatureSizeType)new TwoLayerFeature(11, 0, 5)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY)).func_236700_a_().func_225568_b_();
        MUSHROOM_RED = new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MUSHROOM_STEM), (BlockStateProvider)new SimpleBlockStateProvider(BlockConstants.MUSHROOM_CAP_RED), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.25f, 1.75f, FeatureSpread.func_242252_a(1), 0, 0, -0.45f, 0), (AbstractTrunkPlacer)new BranchingTrunkPlacer(12, 5, 5, 6, new BranchesConfig(3, 1, 9.0, 1.0, 0.3, 0.2), true), (AbstractFeatureSizeType)new TwoLayerFeature(11, 0, 5)).func_236703_a_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY)).func_236700_a_().func_225568_b_();
    }
}
