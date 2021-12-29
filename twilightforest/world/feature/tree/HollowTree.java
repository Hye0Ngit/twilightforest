// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature.tree;

import twilightforest.worldgen.ConfiguredFeatures;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class HollowTree extends TFTree
{
    @Override
    public ConfiguredFeature<TFTreeFeatureConfig, ?> createTreeFeature() {
        return ConfiguredFeatures.HOLLOW_TREE_BASE;
    }
}
