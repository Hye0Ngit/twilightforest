// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.trees.growers;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.feature.config.TFTreeFeatureConfig;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;

public abstract class TFTree extends AbstractTreeGrower
{
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> m_6486_(final Random random, final boolean b) {
        return null;
    }
    
    public abstract ConfiguredFeature<TFTreeFeatureConfig, ?> createTreeFeature();
    
    public boolean m_6334_(final ServerLevel world, final ChunkGenerator generator, final BlockPos pos, final BlockState state, final Random rand) {
        final ConfiguredFeature<TFTreeFeatureConfig, ?> feature = this.createTreeFeature();
        if (feature == null) {
            return false;
        }
        world.m_7731_(pos, Blocks.f_50016_.m_49966_(), 4);
        ((TFTreeFeatureConfig)feature.f_65378_).forcePlacement();
        if (feature.m_65385_((WorldGenLevel)world, generator, rand, pos)) {
            return true;
        }
        world.m_7731_(pos, state, 4);
        return false;
    }
}
