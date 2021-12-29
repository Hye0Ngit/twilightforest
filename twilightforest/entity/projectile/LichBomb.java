// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import twilightforest.entity.boss.Lich;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.projectile.ItemSupplier;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class LichBomb extends TFThrowable implements ItemSupplier
{
    public LichBomb(final EntityType<? extends LichBomb> type, final Level world) {
        super(type, world);
    }
    
    public LichBomb(final EntityType<? extends LichBomb> type, final Level world, final LivingEntity thrower) {
        super(type, world, thrower);
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.makeTrail();
    }
    
    private void makeTrail() {
        for (int i = 0; i < 1; ++i) {
            final double sx = 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble()) + this.m_20184_().m_7096_();
            final double sy = 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble()) + this.m_20184_().m_7098_();
            final double sz = 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble()) + this.m_20184_().m_7094_();
            final double dx = this.m_20185_() + sx;
            final double dy = this.m_20186_() + sy;
            final double dz = this.m_20189_() + sz;
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123744_, dx, dy, dz, sx * -0.25, sy * -0.25, sz * -0.25);
        }
    }
    
    public boolean m_6060_() {
        return true;
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    public float m_6143_() {
        return 1.0f;
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        super.m_6469_(source, amount);
        if (source.m_7640_() != null) {
            if (!source.m_19372_()) {
                this.explode();
            }
            return true;
        }
        return false;
    }
    
    private void explode() {
        if (!this.f_19853_.f_46443_) {
            this.f_19853_.m_7703_((Entity)this, TFDamageSources.LICH_BOMB, (ExplosionDamageCalculator)null, this.m_20185_(), this.m_20186_(), this.m_20189_(), 2.0f, false, Explosion.BlockInteraction.NONE);
            this.m_146870_();
        }
    }
    
    protected float m_7139_() {
        return 0.001f;
    }
    
    protected void m_6532_(final HitResult result) {
        if (result instanceof EntityHitResult && (((EntityHitResult)result).m_82443_() instanceof LichBolt || ((EntityHitResult)result).m_82443_() instanceof LichBomb || ((EntityHitResult)result).m_82443_() instanceof Lich)) {
            return;
        }
        this.explode();
    }
    
    public ItemStack m_7846_() {
        return new ItemStack((ItemLike)Items.f_42542_);
    }
}
