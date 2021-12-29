// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.TFConfig;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CicadaBlockEntity extends BlockEntity
{
    private int yawDelay;
    public int currentYaw;
    private int desiredYaw;
    private int singDuration;
    private boolean singing;
    private int singDelay;
    
    public CicadaBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.CICADA.get(), pos, state);
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final CicadaBlockEntity te) {
        if (level.f_46443_) {
            if (te.yawDelay > 0) {
                --te.yawDelay;
            }
            else {
                if (te.currentYaw == 0 && te.desiredYaw == 0) {
                    te.yawDelay = 200 + level.f_46441_.nextInt(200);
                    te.desiredYaw = level.f_46441_.nextInt(15) - level.f_46441_.nextInt(15);
                }
                if (te.currentYaw < te.desiredYaw) {
                    ++te.currentYaw;
                }
                if (te.currentYaw > te.desiredYaw) {
                    --te.currentYaw;
                }
                if (te.currentYaw == te.desiredYaw) {
                    te.desiredYaw = 0;
                }
            }
            if (te.singDelay > 0) {
                --te.singDelay;
            }
            else {
                if (te.singing && te.singDuration == 0) {
                    te.playSong();
                }
                if (te.singing && te.singDuration >= 100) {
                    te.singing = false;
                    te.singDuration = 0;
                }
                if (te.singing && te.singDuration < 100) {
                    ++te.singDuration;
                    te.doSingAnimation();
                }
                if (!te.singing && te.singDuration <= 0) {
                    te.singing = true;
                    te.singDelay = 100 + level.f_46441_.nextInt(100);
                }
            }
        }
    }
    
    private void doSingAnimation() {
        if (this.f_58857_.f_46441_.nextInt(5) == 0) {
            final double rx = this.f_58858_.m_123341_() + this.f_58857_.f_46441_.nextFloat();
            final double ry = this.f_58858_.m_123342_() + this.f_58857_.f_46441_.nextFloat();
            final double rz = this.f_58858_.m_123343_() + this.f_58857_.f_46441_.nextFloat();
            this.f_58857_.m_7106_((ParticleOptions)ParticleTypes.f_123758_, rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    private void playSong() {
        if (!(boolean)TFConfig.CLIENT_CONFIG.silentCicadas.get()) {
            this.f_58857_.m_7785_((double)this.f_58858_.m_123341_(), (double)this.f_58858_.m_123342_(), (double)this.f_58858_.m_123343_(), TFSounds.CICADA, SoundSource.NEUTRAL, 1.0f, (this.f_58857_.f_46441_.nextFloat() - this.f_58857_.f_46441_.nextFloat()) * 0.2f + 1.0f, false);
        }
    }
}
