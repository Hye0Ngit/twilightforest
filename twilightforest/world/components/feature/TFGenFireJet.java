// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenFireJet extends Feature<BlockStateConfiguration>
{
    public TFGenFireJet(final Codec<BlockStateConfiguration> configIn) {
        super((Codec)configIn);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<BlockStateConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final BlockStateConfiguration config = (BlockStateConfiguration)ctx.m_159778_();
        if (!FeatureUtil.isAreaSuitable(world, pos, 5, 2, 5)) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            final BlockPos dPos = pos.m_142082_(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (world.m_46859_(dPos) && world.m_46861_(dPos) && world.m_8055_(dPos.m_7495_()).m_60767_() == Material.f_76315_ && world.m_8055_(dPos.m_142126_().m_7495_()).m_60767_() == Material.f_76315_ && world.m_8055_(dPos.m_142125_().m_7495_()).m_60767_() == Material.f_76315_ && world.m_8055_(dPos.m_142128_().m_7495_()).m_60767_() == Material.f_76315_ && world.m_8055_(dPos.m_142127_().m_7495_()).m_60767_() == Material.f_76315_) {
                for (int gx = -2; gx <= 2; ++gx) {
                    for (int gz = -2; gz <= 2; ++gz) {
                        final BlockPos grassPos = dPos.m_142082_(gx, -1, gz);
                        world.m_7731_(grassPos, Blocks.f_50440_.m_49966_(), 0);
                    }
                }
                world.m_7731_(dPos.m_7495_(), config.f_67547_, 0);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        final BlockPos dPos2 = dPos.m_142082_(rx, -2, rz);
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.m_7731_(dPos2, Blocks.f_49991_.m_49966_(), 0);
                        }
                        else if (world.m_8055_(dPos2).m_60767_() != Material.f_76307_) {
                            world.m_7731_(dPos2, Blocks.f_50069_.m_49966_(), 0);
                        }
                        world.m_7731_(dPos2.m_7495_(), Blocks.f_50069_.m_49966_(), 0);
                    }
                }
            }
        }
        return true;
    }
}
