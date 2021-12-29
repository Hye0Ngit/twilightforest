// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public abstract class BaseIceMob extends Monster
{
    public BaseIceMob(final EntityType<? extends BaseIceMob> type, final Level worldIn) {
        super((EntityType)type, worldIn);
    }
    
    public void m_8107_() {
        if (!this.f_19861_ && this.m_20184_().m_7098_() < 0.0) {
            final Vec3 motion = this.m_20184_();
            this.m_20334_(motion.f_82479_, motion.f_82480_ * 0.6, motion.f_82481_);
        }
        super.m_8107_();
        if (this.f_19853_.f_46443_) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.3f;
                final float py = this.m_20192_() + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.5f;
                final float pz = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.3f;
                this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW_GUARDIAN.get(), this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.0, 0.0);
                if (this.f_19853_.m_46857_(this.m_142538_()).m_47505_(this.m_142538_()) > 1.0f || this.m_6060_()) {
                    this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123796_, this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.10000000149011612, 0.0);
                    this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123803_, this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.0, 0.0);
                }
            }
        }
        if (this.f_19853_.m_46857_(this.m_142538_()).m_47505_(this.m_142538_()) > 1.0f && this.f_19797_ % 20 == 0) {
            this.m_6469_(DamageSource.f_19307_, 1.0f);
        }
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_142535_(final float distance, final float damageMultiplier, final DamageSource source) {
        return false;
    }
    
    protected void m_7840_(final double y, final boolean onGroundIn, final BlockState state, final BlockPos pos) {
    }
}
