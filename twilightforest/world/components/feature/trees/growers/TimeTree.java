// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import twilightforest.world.registration.ConfiguredFeatures;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TimeTree extends TFTree
{
    @Override
    public ConfiguredFeature<TFTreeFeatureConfig, ?> createTreeFeature() {
        return ConfiguredFeatures.TIME_TREE_BASE;
    }
}
