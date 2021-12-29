// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import java.util.OptionalInt;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import twilightforest.world.components.feature.trees.treeplacers.TreeCorePlacer;
import twilightforest.block.TFLogBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.block.LanternBlock;
import twilightforest.world.components.feature.trees.treeplacers.TreeRootsDecorator;
import twilightforest.world.components.feature.trees.treeplacers.TrunkRiser;
import twilightforest.world.components.feature.trees.treeplacers.DangleFromTreeDecorator;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.block.Blocks;
import twilightforest.world.components.feature.trees.treeplacers.TrunkSideDecorator;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import twilightforest.block.FireflyBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.world.components.feature.trees.treeplacers.LeafSpheroidFoliagePlacer;
import twilightforest.world.components.feature.trees.treeplacers.BranchingTrunkPlacer;
import twilightforest.world.components.feature.trees.treeplacers.BranchesConfig;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.random.SimpleWeightedRandomList;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public final class TreeConfigurations
{
    private static final int canopyDistancing = 5;
    public static final TreeConfiguration TWILIGHT_OAK;
    public static final TreeConfiguration SWAMPY_OAK;
    private static final int LEAF_SHAG_FACTOR = 24;
    public static final TreeConfiguration CANOPY_TREE;
    public static final TreeConfiguration CANOPY_TREE_FIREFLY;
    public static final TreeConfiguration CANOPY_TREE_DEAD;
    public static final TreeConfiguration MANGROVE_TREE;
    public static final TreeConfiguration DARKWOOD_TREE;
    public static final TreeConfiguration HOMEGROWN_DARKWOOD_TREE;
    public static final TreeConfiguration DARKWOOD_LANTERN_TREE;
    public static final TreeConfiguration BIG_SPRUCE;
    public static final TFTreeFeatureConfig TIME_TREE;
    public static final TreeConfiguration TRANSFORM_TREE;
    public static final TFTreeFeatureConfig MINING_TREE;
    public static final TreeConfiguration SORT_TREE;
    public static final TFTreeFeatureConfig LARGE_WINTER;
    public static final TFTreeFeatureConfig DENSE_OAK;
    public static final TFTreeFeatureConfig HOLLOW_TREE;
    public static final TreeConfiguration RAINBOAK_TREE;
    public static final TreeConfiguration LARGE_RAINBOAK_TREE;
    public static final TreeConfiguration MUSHROOM_BROWN;
    public static final TreeConfiguration MUSHROOM_RED;
    
    static SimpleWeightedRandomList.Builder<BlockState> createBlockList() {
        return (SimpleWeightedRandomList.Builder<BlockState>)SimpleWeightedRandomList.m_146263_();
    }
    
    static {
        TWILIGHT_OAK = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LOG), (TrunkPlacer)new StraightTrunkPlacer(4, 2, 0), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_SAPLING), (FoliagePlacer)new BlobFoliagePlacer((IntProvider)ConstantInt.m_146483_(2), (IntProvider)ConstantInt.m_146483_(0), 3), (FeatureSize)new TwoLayersFeatureSize(1, 0, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).m_68251_();
        SWAMPY_OAK = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LOG), (TrunkPlacer)new StraightTrunkPlacer(4, 2, 0), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_SAPLING), (FoliagePlacer)new BlobFoliagePlacer((IntProvider)ConstantInt.m_146483_(2), (IntProvider)ConstantInt.m_146483_(0), 3), (FeatureSize)new TwoLayersFeatureSize(1, 0, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS, (Object)LeaveVineDecorator.f_69997_)).m_68251_();
        CANOPY_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_LOG), (TrunkPlacer)new BranchingTrunkPlacer(20, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 1.5f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, -0.25f, 24), (FeatureSize)new TwoLayersFeatureSize(20, 0, 5)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY, (Object)TreeDecorators.LIVING_ROOTS)).m_68244_().m_68251_();
        CANOPY_TREE_FIREFLY = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_LOG), (TrunkPlacer)new BranchingTrunkPlacer(20, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 1.5f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, -0.25f, 24), (FeatureSize)new TwoLayersFeatureSize(20, 1, 5)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS, (Object)TreeDecorators.FIREFLY, (Object)new TrunkSideDecorator(4, 0.5f, (BlockStateProvider)new SimpleStateProvider((BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)FireflyBlock.FACING, (Comparable)Direction.NORTH))), (Object)new DangleFromTreeDecorator(1, 1, 2, 5, 15, new WeightedStateProvider(createBlockList().m_146271_((Object)((Block)TFBlocks.CANOPY_FENCE.get()).m_49966_(), 3).m_146271_((Object)Blocks.f_50184_.m_49966_(), 1)), new WeightedStateProvider(createBlockList().m_146271_((Object)((Block)TFBlocks.FIREFLY_JAR.get()).m_49966_(), 10).m_146271_((Object)((Block)TFBlocks.CICADA_JAR.get()).m_49966_(), 1))))).m_68244_().m_68251_();
        CANOPY_TREE_DEAD = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_LOG), (TrunkPlacer)new BranchingTrunkPlacer(20, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.AIR), (BlockStateProvider)new SimpleStateProvider(BlockConstants.CANOPY_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(0.0f, 0.0f, (IntProvider)ConstantInt.m_146483_(0), 0, 0, 0.0f, 0), (FeatureSize)new TwoLayersFeatureSize(20, 0, 5)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY, (Object)TreeDecorators.LIVING_ROOTS)).m_68244_().m_68251_();
        MANGROVE_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.MANGROVE_LOG), (TrunkPlacer)new TrunkRiser(5, new BranchingTrunkPlacer(6, 4, 0, 1, new BranchesConfig(0, 3, 6.0, 2.0, 0.3, 0.25), false)), (BlockStateProvider)new SimpleStateProvider(BlockConstants.MANGROVE_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.MANGROVE_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(2.5f, 1.5f, (IntProvider)ConstantInt.m_146483_(0), 2, 0, -0.25f, 15), (FeatureSize)new TwoLayersFeatureSize(4, 1, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY, (Object)new TreeRootsDecorator(3, 1, 12, (BlockStateProvider)new SimpleStateProvider(((Block)TFBlocks.MANGROVE_ROOT.get()).m_49966_()), (BlockStateProvider)new WeightedStateProvider(SimpleWeightedRandomList.m_146263_().m_146271_((Object)BlockConstants.ROOTS, 4).m_146271_((Object)((Block)TFBlocks.LIVEROOT_BLOCK.get()).m_49966_(), 1).m_146270_())), (Object)LeaveVineDecorator.f_69997_)).m_68251_();
        DARKWOOD_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_LOG), (TrunkPlacer)new BranchingTrunkPlacer(6, 1, 1, 3, new BranchesConfig(4, 0, 8.0, 2.0, 0.23, 0.23), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.HARDENED_DARK_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 2.25f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, 0.45f, 36), (FeatureSize)new TwoLayersFeatureSize(4, 1, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).m_68244_().m_68251_();
        HOMEGROWN_DARKWOOD_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_LOG), (TrunkPlacer)new BranchingTrunkPlacer(6, 1, 1, 3, new BranchesConfig(4, 0, 8.0, 2.0, 0.23, 0.23), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 2.25f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, 0.45f, 36), (FeatureSize)new TwoLayersFeatureSize(4, 1, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).m_68244_().m_68251_();
        DARKWOOD_LANTERN_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_LOG), (TrunkPlacer)new BranchingTrunkPlacer(6, 1, 1, 3, new BranchesConfig(4, 0, 8.0, 2.0, 0.23, 0.23), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.DARKWOOD_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 2.25f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, 0.45f, 36), (FeatureSize)new TwoLayersFeatureSize(4, 1, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS, (Object)new DangleFromTreeDecorator(0, 1, 2, 4, 2, new WeightedStateProvider(createBlockList().m_146271_((Object)Blocks.f_50184_.m_49966_(), 1)), new WeightedStateProvider(createBlockList().m_146271_((Object)Blocks.f_50681_.m_49966_().m_61124_((Property)LanternBlock.f_153459_, (Comparable)true), 1))))).m_68244_().m_68251_();
        BIG_SPRUCE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.SPRUCE_LOG), (TrunkPlacer)new GiantTrunkPlacer(13, 2, 14), (BlockStateProvider)new SimpleStateProvider(BlockConstants.SPRUCE_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.SPRUCE_SAPLING), (FoliagePlacer)new MegaPineFoliagePlacer((IntProvider)ConstantInt.m_146483_(0), (IntProvider)ConstantInt.m_146483_(0), (IntProvider)UniformInt.m_146622_(13, 17)), (FeatureSize)new TwoLayersFeatureSize(4, 1, 2)).m_68251_();
        TIME_TREE = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TIME_LOG), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TIME_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TIME_WOOD), (BlockStateProvider)new SimpleStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.TIME_SAPLING.get()).build();
        TRANSFORM_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TRANSFORM_LOG), (TrunkPlacer)new BranchingTrunkPlacer(6, 5, 5, 7, new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TRANSFORM_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TRANSFORM_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.5f, 1.5f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, -0.25f, 0), (FeatureSize)new TwoLayersFeatureSize(4, 1, 5)).m_68244_().m_68249_((List)ImmutableList.of((Object)new TreeCorePlacer(3, (BlockStateProvider)new SimpleStateProvider((BlockState)((Block)TFBlocks.TRANSFORMATION_LOG_CORE.get()).m_49966_().m_61124_((Property)TFLogBlock.f_55923_, (Comparable)Direction.Axis.Y))))).m_68251_();
        MINING_TREE = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleStateProvider(BlockConstants.MINING_LOG), (BlockStateProvider)new SimpleStateProvider(BlockConstants.MINING_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.MINING_WOOD), (BlockStateProvider)new SimpleStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.MINING_SAPLING.get()).build();
        SORT_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.SORT_LOG), (TrunkPlacer)new StraightTrunkPlacer(3, 0, 0), (BlockStateProvider)new SimpleStateProvider(BlockConstants.SORT_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.SORT_SAPLING), (FoliagePlacer)new LeafSpheroidFoliagePlacer(1.5f, 2.25f, (IntProvider)ConstantInt.m_146483_(0), 1, 0, 0.5f, 0), (FeatureSize)new TwoLayersFeatureSize(1, 1, 1)).m_68244_().m_68249_((List)ImmutableList.of((Object)new TreeCorePlacer(2, (BlockStateProvider)new SimpleStateProvider((BlockState)((Block)TFBlocks.SORTING_LOG_CORE.get()).m_49966_().m_61124_((Property)TFLogBlock.f_55923_, (Comparable)Direction.Axis.Y))))).m_68251_();
        LARGE_WINTER = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleStateProvider(BlockConstants.SPRUCE_LOG), (BlockStateProvider)new SimpleStateProvider(BlockConstants.SPRUCE_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.SPRUCE_LOG), (BlockStateProvider)new SimpleStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)Blocks.f_50747_).build();
        DENSE_OAK = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LOG), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_WOOD), (BlockStateProvider)new SimpleStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.TWILIGHT_OAK_SAPLING.get()).build();
        HOLLOW_TREE = new TFTreeFeatureConfig.Builder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LOG), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_WOOD), (BlockStateProvider)new SimpleStateProvider(BlockConstants.ROOTS)).setSapling((SaplingBlock)TFBlocks.HOLLOW_OAK_SAPLING.get()).build();
        RAINBOAK_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LOG), (TrunkPlacer)new StraightTrunkPlacer(4, 2, 0), (BlockStateProvider)new SimpleStateProvider(BlockConstants.RAINBOW_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.RAINBOW_SAPLING), (FoliagePlacer)new BlobFoliagePlacer((IntProvider)ConstantInt.m_146483_(2), (IntProvider)ConstantInt.m_146483_(0), 3), (FeatureSize)new TwoLayersFeatureSize(1, 1, 1)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).m_68251_();
        LARGE_RAINBOAK_TREE = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.TF_OAK_LOG), (TrunkPlacer)new FancyTrunkPlacer(3, 11, 0), (BlockStateProvider)new SimpleStateProvider(BlockConstants.RAINBOW_LEAVES), (BlockStateProvider)new SimpleStateProvider(BlockConstants.RAINBOW_SAPLING), (FoliagePlacer)new FancyFoliagePlacer((IntProvider)ConstantInt.m_146483_(2), (IntProvider)ConstantInt.m_146483_(4), 4), (FeatureSize)new TwoLayersFeatureSize(4, 1, 0, OptionalInt.of(4))).m_68249_((List)ImmutableList.of((Object)TreeDecorators.LIVING_ROOTS)).m_68251_();
        MUSHROOM_BROWN = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.MUSHROOM_STEM), (TrunkPlacer)new BranchingTrunkPlacer(12, 5, 5, 6, new BranchesConfig(3, 1, 9.0, 1.0, 0.3, 0.2), true), (BlockStateProvider)new SimpleStateProvider(BlockConstants.MUSHROOM_CAP_BROWN), (BlockStateProvider)new SimpleStateProvider(BlockConstants.BROWN_MUSHROOM), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.25f, 0.0f, (IntProvider)ConstantInt.m_146483_(1), 1, 0, 0.0f, 0), (FeatureSize)new TwoLayersFeatureSize(11, 1, 5)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY)).m_68244_().m_68251_();
        MUSHROOM_RED = new TreeConfiguration.TreeConfigurationBuilder((BlockStateProvider)new SimpleStateProvider(BlockConstants.MUSHROOM_STEM), (TrunkPlacer)new BranchingTrunkPlacer(12, 5, 5, 6, new BranchesConfig(3, 1, 9.0, 1.0, 0.3, 0.2), true), (BlockStateProvider)new SimpleStateProvider(BlockConstants.MUSHROOM_CAP_RED), (BlockStateProvider)new SimpleStateProvider(BlockConstants.RED_MUSHROOM), (FoliagePlacer)new LeafSpheroidFoliagePlacer(4.25f, 1.75f, (IntProvider)ConstantInt.m_146483_(1), 0, 0, -0.45f, 0), (FeatureSize)new TwoLayersFeatureSize(11, 1, 5)).m_68249_((List)ImmutableList.of((Object)TreeDecorators.FIREFLY)).m_68244_().m_68251_();
    }
}
