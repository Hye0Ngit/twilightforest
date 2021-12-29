// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature.tree;

import net.minecraft.world.ISeedReader;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.server.ServerWorld;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import javax.annotation.Nullable;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import java.util.Random;
import net.minecraft.block.trees.Tree;

public abstract class TFTree extends Tree
{
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> func_225546_b_(final Random random, final boolean b) {
        return null;
    }
    
    public abstract ConfiguredFeature<TFTreeFeatureConfig, ?> createTreeFeature();
    
    public boolean func_230339_a_(final ServerWorld world, final ChunkGenerator generator, final BlockPos pos, final BlockState state, final Random rand) {
        final ConfiguredFeature<TFTreeFeatureConfig, ?> feature = this.createTreeFeature();
        if (feature == null) {
            return false;
        }
        world.func_180501_a(pos, Blocks.field_150350_a.func_176223_P(), 4);
        ((TFTreeFeatureConfig)feature.field_222738_b).forcePlacement();
        if (feature.func_242765_a((ISeedReader)world, generator, rand, pos)) {
            return true;
        }
        world.func_180501_a(pos, state, 4);
        return false;
    }
}
