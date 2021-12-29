// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import javax.annotation.Nullable;
import twilightforest.world.registration.ConfiguredFeatures;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;

public class RainboakTree extends AbstractTreeGrower
{
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> m_6486_(final Random random, final boolean b) {
        return ConfiguredFeatures.RAINBOW_OAK_TREE_BASE;
    }
}
