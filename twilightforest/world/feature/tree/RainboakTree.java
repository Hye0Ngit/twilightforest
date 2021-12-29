// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature.tree;

import javax.annotation.Nullable;
import twilightforest.worldgen.ConfiguredFeatures;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import java.util.Random;
import net.minecraft.block.trees.Tree;

public class RainboakTree extends Tree
{
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> func_225546_b_(final Random random, final boolean b) {
        return ConfiguredFeatures.RAINBOW_OAK_TREE_BASE;
    }
}
