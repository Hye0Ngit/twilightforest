// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.boss.UrGhast;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.LargeFireball;

public class UrGhastFireball extends LargeFireball implements ITFProjectile
{
    private final int power;
    
    public UrGhastFireball(final Level world, final UrGhast entityTFTowerBoss, final double x, final double y, final double z, final int power) {
        super(world, (LivingEntity)entityTFTowerBoss, x, y, z, power);
        this.power = power;
    }
    
    protected void m_6532_(final HitResult result) {
        if (result instanceof final EntityHitResult entityHitResult) {
            if (!this.f_19853_.f_46443_ && !(entityHitResult.m_82443_() instanceof AbstractHurtingProjectile)) {
                if (entityHitResult.m_82443_() != null) {
                    entityHitResult.m_82443_().m_6469_(DamageSource.m_19349_((Fireball)this, this.m_37282_()), 16.0f);
                    this.m_19970_((LivingEntity)this.m_37282_(), entityHitResult.m_82443_());
                }
                final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.f_19853_, this.m_37282_());
                this.f_19853_.m_46518_((Entity)null, this.m_20185_(), this.m_20186_(), this.m_20189_(), (float)this.power, flag, flag ? Explosion.BlockInteraction.BREAK : Explosion.BlockInteraction.NONE);
                this.m_146870_();
            }
        }
        else {
            final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.f_19853_, this.m_37282_());
            this.f_19853_.m_46518_((Entity)null, this.m_20185_(), this.m_20186_(), this.m_20189_(), (float)this.power, flag, Explosion.BlockInteraction.NONE);
            this.m_146870_();
        }
    }
    
    public void m_6686_(final double x, final double y, final double z, final float scale, final float dist) {
        final Vec3 vec3d = new Vec3(x, y, z).m_82541_().m_82520_(this.f_19796_.nextGaussian() * 0.007499999832361937 * dist, this.f_19796_.nextGaussian() * 0.007499999832361937 * dist, this.f_19796_.nextGaussian() * 0.007499999832361937 * dist).m_82490_((double)scale);
        this.m_20256_(vec3d);
        final float f = Mth.m_14116_((float)this.m_20238_(vec3d));
        this.m_146922_((float)(Mth.m_14136_(vec3d.f_82479_, z) * 57.2957763671875));
        this.m_146926_((float)(Mth.m_14136_(vec3d.f_82480_, (double)f) * 57.2957763671875));
        this.f_19859_ = this.m_146908_();
        this.f_19860_ = this.m_146909_();
    }
}
