// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import twilightforest.world.registration.ConfiguredFeatures;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MinersTree extends TFTree
{
    @Override
    public ConfiguredFeature<TFTreeFeatureConfig, ?> createTreeFeature() {
        return ConfiguredFeatures.MINING_TREE_BASE;
    }
}
