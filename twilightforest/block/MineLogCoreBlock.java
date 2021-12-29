// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.item.OreMagnetItem;
import twilightforest.util.WorldUtil;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MineLogCoreBlock extends SpecialMagicLogBlock
{
    public MineLogCoreBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    void performTreeEffect(final Level world, final BlockPos pos, final Random rand) {
        final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 32);
        final int moved = OreMagnetItem.doMagnet(world, pos, dPos);
        if (moved > 0) {
            world.m_5594_((Player)null, pos, TFSounds.MAGNET_GRAB, SoundSource.BLOCKS, 0.1f, 1.0f);
        }
    }
}
