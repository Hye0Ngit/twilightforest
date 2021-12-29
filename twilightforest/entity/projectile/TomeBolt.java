// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.projectile.ItemSupplier;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class TomeBolt extends TFThrowable implements ItemSupplier
{
    public TomeBolt(final EntityType<? extends TomeBolt> type, final Level world, final LivingEntity thrower) {
        super(type, world, thrower);
    }
    
    public TomeBolt(final EntityType<? extends TomeBolt> type, final Level world) {
        super(type, world);
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.makeTrail();
    }
    
    protected float m_7139_() {
        return 0.003f;
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.m_20185_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dy = this.m_20186_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dz = this.m_20189_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123797_, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            final ParticleOptions particle = (ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, new ItemStack((ItemLike)Items.f_42516_));
            for (int i = 0; i < 8; ++i) {
                this.f_19853_.m_6493_(particle, false, this.m_20185_(), this.m_20186_(), this.m_20189_(), this.f_19796_.nextGaussian() * 0.05, this.f_19796_.nextDouble() * 0.2, this.f_19796_.nextGaussian() * 0.05);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_6532_(final HitResult result) {
        if (!this.f_19853_.f_46443_) {
            if (result instanceof final EntityHitResult entityRay) {
                if (entityRay.m_82443_() instanceof LivingEntity && entityRay.m_82443_().m_6469_(this.f_19796_.nextBoolean() ? TFDamageSources.lostWords((Entity)this, (LivingEntity)this.m_37282_()) : TFDamageSources.schooled((Entity)this, (LivingEntity)this.m_37282_()), 3.0f)) {
                    final int duration = (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) ? 2 : ((this.f_19853_.m_46791_() == Difficulty.NORMAL) ? 6 : 8);
                    ((LivingEntity)entityRay.m_82443_()).m_7292_(new MobEffectInstance(MobEffects.f_19597_, duration * 20, 1));
                }
            }
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
    
    public ItemStack m_7846_() {
        return new ItemStack((ItemLike)Items.f_42516_);
    }
}
