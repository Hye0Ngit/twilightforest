// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.entity.Entity;
import twilightforest.util.TFDamageSources;
import twilightforest.entity.boss.Lich;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class LichBolt extends TFThrowable
{
    public LichBolt(final EntityType<? extends LichBolt> type, final Level world) {
        super(type, world);
    }
    
    public LichBolt(final EntityType<? extends LichBolt> type, final Level world, final LivingEntity owner) {
        super(type, world, owner);
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.makeTrail();
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.m_20185_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dy = this.m_20186_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dz = this.m_20189_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double s1 = (this.f_19796_.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.f_19796_.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.f_19796_.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123811_, dx, dy, dz, s1, s2, s3);
        }
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    public float m_6143_() {
        return 1.0f;
    }
    
    public boolean m_6469_(final DamageSource damagesource, final float amount) {
        super.m_6469_(damagesource, amount);
        if (!this.f_19853_.f_46443_ && damagesource.m_7639_() != null) {
            final Vec3 vec3d = damagesource.m_7639_().m_20154_();
            this.m_6686_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.5f, 0.1f);
            if (damagesource.m_7640_() instanceof LivingEntity) {
                this.m_5602_(damagesource.m_7640_());
            }
            return true;
        }
        return false;
    }
    
    protected float m_7139_() {
        return 0.001f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            final ItemStack itemId = new ItemStack((ItemLike)Items.f_42584_);
            for (int i = 0; i < 8; ++i) {
                this.f_19853_.m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, itemId), this.m_20185_(), this.m_20186_(), this.m_20189_(), this.f_19796_.nextGaussian() * 0.05, this.f_19796_.nextDouble() * 0.2, this.f_19796_.nextGaussian() * 0.05);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_6532_(final HitResult result) {
        if (result instanceof final EntityHitResult hit) {
            final Entity entityHit = hit.m_82443_();
            if (entityHit instanceof LichBolt || entityHit instanceof LichBomb || (entityHit instanceof Lich && ((Lich)entityHit).isShadowClone())) {
                return;
            }
            if (!this.f_19853_.f_46443_) {
                if (entityHit instanceof LivingEntity) {
                    entityHit.m_6469_(TFDamageSources.LICH_BOLT, 6.0f);
                }
                this.f_19853_.m_7605_((Entity)this, (byte)3);
                this.m_146870_();
            }
        }
    }
}
