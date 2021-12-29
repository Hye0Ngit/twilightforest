// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class TwilightWandBolt extends TFThrowable
{
    public TwilightWandBolt(final EntityType<? extends TwilightWandBolt> type, final Level world) {
        super(type, world);
    }
    
    public TwilightWandBolt(final Level world, final LivingEntity thrower) {
        super(TFEntities.WAND_BOLT, world, thrower);
        this.m_37251_((Entity)thrower, thrower.m_146909_(), thrower.m_146908_(), 0.0f, 1.5f, 1.0f);
    }
    
    public TwilightWandBolt(final Level worldIn, final double x, final double y, final double z) {
        super(TFEntities.WAND_BOLT, worldIn, x, y, z);
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
    
    protected float m_7139_() {
        return 0.003f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            final ParticleOptions particle = (ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, new ItemStack((ItemLike)Items.f_42584_));
            for (int i = 0; i < 8; ++i) {
                this.f_19853_.m_6493_(particle, false, this.m_20185_(), this.m_20186_(), this.m_20189_(), this.f_19796_.nextGaussian() * 0.05, this.f_19796_.nextDouble() * 0.2, this.f_19796_.nextGaussian() * 0.05);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_5790_(final EntityHitResult result) {
        super.m_5790_(result);
        if (!this.f_19853_.f_46443_) {
            result.m_82443_().m_6469_(DamageSource.m_19367_((Entity)this, this.m_37282_()), 6.0f);
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
    
    protected void m_8060_(final BlockHitResult result) {
        super.m_8060_(result);
        if (!this.f_19853_.f_46443_) {
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        super.m_6469_(source, amount);
        if (!this.f_19853_.f_46443_ && source.m_7639_() != null) {
            final Vec3 vec3d = source.m_7639_().m_20154_();
            this.m_6686_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.5f, 0.1f);
            if (source.m_7640_() instanceof LivingEntity) {
                this.m_5602_(source.m_7640_());
            }
            return true;
        }
        return false;
    }
}
