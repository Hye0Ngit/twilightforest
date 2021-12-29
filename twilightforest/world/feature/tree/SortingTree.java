// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature.tree;

import twilightforest.worldgen.ConfiguredFeatures;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import java.util.Random;
import net.minecraft.block.trees.Tree;

public class SortingTree extends Tree
{
    public ConfiguredFeature<BaseTreeFeatureConfig, ?> func_225546_b_(final Random rand, final boolean largeHive) {
        return ConfiguredFeatures.SORT_TREE_BASE;
    }
}
