// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import java.util.Iterator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class CheckAbovePatchFeature extends Feature<DiskConfiguration>
{
    public CheckAbovePatchFeature(final Codec<DiskConfiguration> pCodec) {
        super((Codec)pCodec);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<DiskConfiguration> ctx) {
        final DiskConfiguration config = (DiskConfiguration)ctx.m_159778_();
        final BlockPos blockpos = ctx.m_159777_();
        final WorldGenLevel level = ctx.m_159774_();
        boolean flag = false;
        final int i = blockpos.m_123342_();
        final int j = i + config.f_67621_;
        final int k = i - config.f_67621_ - 1;
        final boolean flag2 = config.f_67619_.m_60734_() instanceof FallingBlock;
        for (int l = config.f_67620_.m_142270_(ctx.m_159776_()), i2 = blockpos.m_123341_() - l; i2 <= blockpos.m_123341_() + l; ++i2) {
            for (int j2 = blockpos.m_123343_() - l; j2 <= blockpos.m_123343_() + l; ++j2) {
                final int k2 = i2 - blockpos.m_123341_();
                final int l2 = j2 - blockpos.m_123343_();
                if (k2 * k2 + l2 * l2 <= l * l) {
                    boolean flag3 = false;
                    for (int i3 = j; i3 >= k; --i3) {
                        final BlockPos blockpos2 = new BlockPos(i2, i3, j2);
                        final BlockState blockstate = level.m_8055_(blockpos2);
                        final Block block = blockstate.m_60734_();
                        boolean flag4 = false;
                        if (i3 > k) {
                            for (final BlockState blockstate2 : config.f_67622_) {
                                if (blockstate2.m_60713_(block) && (level.m_8055_(blockpos2.m_7494_()).m_60795_() || level.m_8055_(blockpos2.m_7494_()).m_60767_().m_76336_())) {
                                    level.m_7731_(blockpos2, config.f_67619_, 2);
                                    this.m_159739_(level, blockpos2);
                                    flag = true;
                                    flag4 = true;
                                    break;
                                }
                            }
                        }
                        if (flag2 && flag3 && blockstate.m_60795_()) {
                            final BlockState blockstate3 = config.f_67619_.m_60713_(Blocks.f_49993_) ? Blocks.f_50394_.m_49966_() : Blocks.f_50062_.m_49966_();
                            level.m_7731_(new BlockPos(i2, i3 + 1, j2), blockstate3, 2);
                        }
                        flag3 = flag4;
                    }
                }
            }
        }
        return flag;
    }
}
