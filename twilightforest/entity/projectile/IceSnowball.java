// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import java.util.Iterator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.projectile.ItemSupplier;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class IceSnowball extends TFThrowable implements ItemSupplier
{
    private static final int DAMAGE = 2;
    
    public IceSnowball(final EntityType<? extends IceSnowball> type, final Level world) {
        super(type, world);
    }
    
    public IceSnowball(final Level world, final LivingEntity thrower) {
        super(TFEntities.ICE_SNOWBALL, world, thrower);
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.makeTrail();
    }
    
    protected float m_7139_() {
        return 0.006f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.m_20185_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dy = this.m_20186_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dz = this.m_20189_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123754_, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        super.m_6469_(source, amount);
        this.die();
        return true;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            for (int j = 0; j < 8; ++j) {
                this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123754_, this.m_20185_(), this.m_20186_(), this.m_20189_(), 0.0, 0.0, 0.0);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_6532_(final HitResult result) {
        if (result instanceof final EntityHitResult entityHitResult) {
            final Entity target = entityHitResult.m_82443_();
            if (!this.f_19853_.f_46443_ && target instanceof LivingEntity) {
                target.m_6469_(TFDamageSources.snowballFight((Entity)this, (LivingEntity)this.m_37282_()), 2.0f);
                if (target instanceof Player) {
                    for (final ItemStack stack : target.m_6168_()) {
                        stack.m_41622_(this.f_19796_.nextInt(1), (LivingEntity)target, user -> user.m_21166_(stack.getEquipmentSlot()));
                    }
                }
            }
        }
        this.die();
    }
    
    private void die() {
        if (!this.f_19853_.f_46443_) {
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
    
    public ItemStack m_7846_() {
        return new ItemStack((ItemLike)Items.f_42452_);
    }
}
