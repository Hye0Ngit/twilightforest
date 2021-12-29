// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenDarkForestFeature extends Feature<RandomPatchConfiguration>
{
    public TFGenDarkForestFeature(final Codec<RandomPatchConfiguration> codec) {
        super((Codec)codec);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<RandomPatchConfiguration> ctx) {
        final WorldGenLevel reader = ctx.m_159774_();
        BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final RandomPatchConfiguration config = (RandomPatchConfiguration)ctx.m_159778_();
        boolean foundDirt = false;
        if (pos.m_123342_() <= 40) {
            for (int dy = pos.m_123342_(); dy >= WorldUtil.getSeaLevel(ctx.m_159775_()); --dy) {
                final Material materialUnder = reader.m_8055_(new BlockPos(pos.m_123341_(), dy - 1, pos.m_123343_())).m_60767_();
                if ((materialUnder == Material.f_76315_ || materialUnder == Material.f_76314_) && reader.m_8055_(pos) == Blocks.f_50016_.m_49966_()) {
                    foundDirt = true;
                    pos = new BlockPos(pos.m_123341_(), dy, pos.m_123343_());
                    break;
                }
                if (materialUnder == Material.f_76278_) {
                    break;
                }
                if (materialUnder == Material.f_76317_) {
                    break;
                }
            }
        }
        if (!foundDirt) {
            return false;
        }
        final BlockState blockstate = config.f_67903_.m_7112_(rand, pos);
        int i = 0;
        final BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
        for (int j = 0; j < config.f_67907_; ++j) {
            blockpos$mutable.m_122154_((Vec3i)pos, rand.nextInt(config.f_67908_ + 1) - rand.nextInt(config.f_67908_ + 1), rand.nextInt(config.f_67909_ + 1) - rand.nextInt(config.f_67909_ + 1), rand.nextInt(config.f_67910_ + 1) - rand.nextInt(config.f_67910_ + 1));
            final BlockPos blockpos1 = blockpos$mutable.m_7495_();
            final BlockState blockstate2 = reader.m_8055_(blockpos1);
            if ((reader.m_46859_((BlockPos)blockpos$mutable) || (config.f_67911_ && reader.m_8055_((BlockPos)blockpos$mutable).m_60767_().m_76336_())) && blockstate.m_60710_((LevelReader)reader, (BlockPos)blockpos$mutable) && (config.f_67905_.isEmpty() || config.f_67905_.contains(blockstate2.m_60734_())) && !config.f_67906_.contains(blockstate2) && (!config.f_67913_ || reader.m_6425_(blockpos1.m_142125_()).m_76153_((Tag)FluidTags.f_13131_) || reader.m_6425_(blockpos1.m_142126_()).m_76153_((Tag)FluidTags.f_13131_) || reader.m_6425_(blockpos1.m_142127_()).m_76153_((Tag)FluidTags.f_13131_) || reader.m_6425_(blockpos1.m_142128_()).m_76153_((Tag)FluidTags.f_13131_))) {
                config.f_67904_.m_7275_((LevelAccessor)reader, (BlockPos)blockpos$mutable, blockstate, rand);
                ++i;
            }
        }
        return i > 0;
    }
}
