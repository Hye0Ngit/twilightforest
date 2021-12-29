// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import twilightforest.world.registration.ConfiguredFeatures;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;

public class DarkCanopyTree extends AbstractTreeGrower
{
    public ConfiguredFeature<TreeConfiguration, ?> m_6486_(final Random rand, final boolean largeHive) {
        return ConfiguredFeatures.HOMEGROWN_DARKWOOD_TREE_BASE;
    }
}
