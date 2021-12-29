// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenFallenLeaves extends Feature<NoneFeatureConfiguration>
{
    private final BlockState state;
    
    public TFGenFallenLeaves(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
        this.state = ((Block)TFBlocks.FALLEN_LEAVES.get()).m_49966_();
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel worldIn = ctx.m_159774_();
        final ChunkGenerator generator = ctx.m_159775_();
        BlockPos position = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        do {
            final BlockState state = worldIn.m_8055_(position.m_7495_());
            if (worldIn.m_46859_(position)) {
                if (state.m_60767_() == Material.f_76315_) {
                    break;
                }
                if (state.m_60767_() == Material.f_76314_) {
                    break;
                }
            }
            position = position.m_7495_();
        } while (position.m_123342_() > generator.m_142051_((LevelHeightAccessor)worldIn));
        for (int x = 0; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(3) == 0) {
                    boolean flag = false;
                    int y = 2;
                    do {
                        final BlockState state2 = worldIn.m_8055_(position.m_142082_(x, y, z).m_7495_());
                        if (worldIn.m_46859_(position.m_142082_(x, y, z)) && (state2.m_60767_() == Material.f_76315_ || state2.m_60767_() == Material.f_76314_)) {
                            flag = true;
                            break;
                        }
                    } while (--y >= -2);
                    if (flag) {
                        final BlockPos pos = position.m_142082_(x, y, z);
                        if (((BushBlock)this.state.m_60734_()).m_7898_(this.state, (LevelReader)worldIn, pos)) {
                            worldIn.m_7731_(pos, this.state, 18);
                        }
                    }
                }
            }
        }
        return true;
    }
}
