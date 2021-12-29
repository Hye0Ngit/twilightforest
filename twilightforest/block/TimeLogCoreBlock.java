// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerLevel;
import twilightforest.util.WorldUtil;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TimeLogCoreBlock extends SpecialMagicLogBlock
{
    public TimeLogCoreBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    void performTreeEffect(final Level world, final BlockPos pos, final Random rand) {
        for (int numticks = 24 * this.tickRate(), i = 0; i < numticks; ++i) {
            final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 16);
            final BlockState state = world.m_8055_(dPos);
            if (state.m_60823_()) {
                state.m_60735_((ServerLevel)world, dPos, rand);
            }
            final BlockEntity entity = world.m_7702_(dPos);
            if (entity != null) {
                final BlockEntityTicker<BlockEntity> ticker = (BlockEntityTicker<BlockEntity>)state.m_155944_(world, entity.m_58903_());
                if (ticker != null) {
                    ticker.m_155252_(world, pos, state, entity);
                }
            }
        }
    }
    
    @Override
    protected void playSound(final Level level, final BlockPos pos, final Random rand) {
        level.m_5594_((Player)null, pos, TFSounds.TIME_CORE, SoundSource.BLOCKS, 0.1f, 0.5f);
    }
}
