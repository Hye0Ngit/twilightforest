// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.Direction;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LeavesBlock;

public class MagicLeavesBlock extends LeavesBlock
{
    protected MagicLeavesBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random random) {
        if (state.m_60734_() == TFBlocks.TRANSFORMATION_LEAVES.get()) {
            for (int i = 0; i < 1; ++i) {
                this.sparkleRunes(world, pos, random);
            }
        }
    }
    
    private void sparkleRunes(final Level world, final BlockPos pos, final Random rand) {
        final double offset = 0.0625;
        final Direction side = Direction.m_122404_(rand);
        double rx = pos.m_123341_() + rand.nextFloat();
        double ry = pos.m_123342_() + rand.nextFloat();
        double rz = pos.m_123343_() + rand.nextFloat();
        if (side == Direction.DOWN && world.m_46859_(pos.m_7494_())) {
            ry = pos.m_123342_() + 1 + offset;
        }
        if (side == Direction.UP && world.m_46859_(pos.m_7495_())) {
            ry = pos.m_123342_() - offset;
        }
        if (side == Direction.NORTH && world.m_46859_(pos.m_142128_())) {
            rz = pos.m_123343_() + 1 + offset;
        }
        if (side == Direction.SOUTH && world.m_46859_(pos.m_142127_())) {
            rz = pos.m_123343_() - offset;
        }
        if (side == Direction.WEST && world.m_46859_(pos.m_142126_())) {
            rx = pos.m_123341_() + 1 + offset;
        }
        if (side == Direction.EAST && world.m_46859_(pos.m_142125_())) {
            rx = pos.m_123341_() - offset;
        }
        if (rx < pos.m_123341_() || rx > pos.m_123341_() + 1 || ry < pos.m_123342_() || ry > pos.m_123342_() + 1 || rz < pos.m_123343_() || rz > pos.m_123343_() + 1) {
            world.m_7106_((ParticleOptions)TFParticleType.LEAF_RUNE.get(), rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
}
