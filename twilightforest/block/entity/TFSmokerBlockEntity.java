// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.EncasedSmokerBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TFSmokerBlockEntity extends BlockEntity
{
    private long counter;
    
    public TFSmokerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.SMOKER.get(), pos, state);
        this.counter = 0L;
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final TFSmokerBlockEntity te) {
        if (level.f_46443_) {
            final long counter = te.counter + 1L;
            te.counter = counter;
            if (counter % 4L == 0L) {
                if (state.m_60734_() == TFBlocks.ENCASED_SMOKER.get() && (boolean)state.m_61143_((Property)EncasedSmokerBlock.ACTIVE)) {
                    particles(level, pos, te);
                }
                else if (state.m_60734_() == TFBlocks.SMOKER.get()) {
                    particles(level, pos, te);
                }
            }
        }
    }
    
    public static void particles(final Level level, final BlockPos pos, final TFSmokerBlockEntity te) {
        level.m_7106_((ParticleOptions)TFParticleType.HUGE_SMOKE.get(), pos.m_123341_() + 0.5, pos.m_123342_() + 0.95, pos.m_123343_() + 0.5, Math.cos(te.counter / 10.0) * 0.05, 0.25, Math.sin(te.counter / 10.0) * 0.05);
    }
}
