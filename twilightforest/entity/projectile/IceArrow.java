// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.effect.MobEffectInstance;
import twilightforest.potions.TFMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Blocks;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class IceArrow extends TFArrow
{
    public IceArrow(final EntityType<? extends IceArrow> type, final Level world) {
        super(type, world);
    }
    
    public IceArrow(final Level world, final Entity shooter) {
        super(TFEntities.ICE_ARROW, world, shooter);
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (this.f_19853_.f_46443_ && !this.f_36703_) {
            final BlockState stateId = Blocks.f_50125_.m_49966_();
            for (int i = 0; i < 4; ++i) {
                this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123814_, stateId), this.m_20185_() + this.m_20184_().m_7096_() * i / 4.0, this.m_20186_() + this.m_20184_().m_7098_() * i / 4.0, this.m_20189_() + this.m_20184_().m_7094_() * i / 4.0, -this.m_20184_().m_7096_(), -this.m_20184_().m_7098_() + 0.2, -this.m_20184_().m_7094_());
            }
        }
    }
    
    protected void m_6532_(final HitResult ray) {
        super.m_6532_(ray);
        if (ray instanceof EntityHitResult && !this.f_19853_.f_46443_ && ((EntityHitResult)ray).m_82443_() instanceof LivingEntity) {
            final int chillLevel = 2;
            ((LivingEntity)((EntityHitResult)ray).m_82443_()).m_7292_(new MobEffectInstance((MobEffect)TFMobEffects.FROSTY.get(), 200, chillLevel));
        }
    }
}
