// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class FireflyBlockEntity extends BlockEntity
{
    private int yawDelay;
    public int currentYaw;
    private int desiredYaw;
    public float glowIntensity;
    private boolean glowing;
    private int glowDelay;
    
    public FireflyBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.FIREFLY.get(), pos, state);
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final FireflyBlockEntity te) {
        if (level.f_46443_) {
            if (te.anyPlayerInRange() && level.f_46441_.nextInt(20) == 0) {
                te.spawnParticles();
            }
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
            if (te.glowDelay > 0) {
                --te.glowDelay;
            }
            else {
                if (te.glowing && te.glowIntensity >= 1.0) {
                    te.glowing = false;
                }
                if (te.glowing && te.glowIntensity < 1.0) {
                    te.glowIntensity += (float)0.05;
                }
                if (!te.glowing && te.glowIntensity > 0.0f) {
                    te.glowIntensity -= (float)0.05;
                }
                if (!te.glowing && te.glowIntensity <= 0.0f) {
                    te.glowing = true;
                    te.glowDelay = level.f_46441_.nextInt(50);
                }
            }
        }
    }
    
    private boolean anyPlayerInRange() {
        return this.f_58857_.m_45924_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, 16.0, false) != null;
    }
    
    private void spawnParticles() {
        final double rx = this.f_58858_.m_123341_() + this.f_58857_.f_46441_.nextFloat();
        final double ry = this.f_58858_.m_123342_() + this.f_58857_.f_46441_.nextFloat();
        final double rz = this.f_58858_.m_123343_() + this.f_58857_.f_46441_.nextFloat();
        this.f_58857_.m_7106_((ParticleOptions)TFParticleType.FIREFLY.get(), rx, ry, rz, 0.0, 0.0, 0.0);
    }
}
