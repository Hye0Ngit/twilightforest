// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import java.util.Iterator;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class HydraMortarHead extends ThrowableProjectile
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public int fuse;
    private boolean megaBlast;
    
    public HydraMortarHead(final EntityType<? extends HydraMortarHead> type, final Level world) {
        super((EntityType)type, world);
        this.fuse = 80;
        this.megaBlast = false;
    }
    
    public HydraMortarHead(final EntityType<? extends HydraMortarHead> type, final Level world, final HydraHead head) {
        super((EntityType)type, (LivingEntity)head.getParent(), world);
        this.fuse = 80;
        this.megaBlast = false;
        final Vec3 vector = head.m_20154_();
        final double dist = 3.5;
        final double px = head.m_20185_() + vector.f_82479_ * dist;
        final double py = head.m_20186_() + 1.0 + vector.f_82480_ * dist;
        final double pz = head.m_20189_() + vector.f_82481_ * dist;
        this.m_7678_(px, py, pz, 0.0f, 0.0f);
        head.m_20256_(new Vec3(0.0, 0.0, 0.0));
        this.m_37251_((Entity)head, head.m_146909_(), head.m_146908_(), -20.0f, 0.5f, 1.0f);
        TwilightForestMod.LOGGER.debug("Launching mortar! Current head motion is {}, {}", (Object)head.m_20184_().m_7096_(), (Object)head.m_20184_().m_7094_());
    }
    
    protected void m_8097_() {
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (this.m_20096_()) {
            this.m_20184_().m_82542_(0.9, 0.9, 0.9);
            if (!this.f_19853_.f_46443_ && this.fuse-- <= 0) {
                this.detonate();
            }
        }
    }
    
    public void setToBlasting() {
        this.megaBlast = true;
    }
    
    protected void m_6532_(final HitResult ray) {
        if (ray instanceof final EntityHitResult entityHitResult) {
            if (!this.f_19853_.f_46443_ && (!(entityHitResult.m_82443_() instanceof HydraMortarHead) || ((HydraMortarHead)entityHitResult.m_82443_()).m_37282_() != this.m_37282_()) && entityHitResult.m_82443_() != this.m_37282_() && !this.isPartOfHydra(entityHitResult.m_82443_())) {
                this.detonate();
            }
        }
        else if (!this.megaBlast) {
            this.m_20334_(this.m_20184_().m_7096_(), 0.0, this.m_20184_().m_7094_());
            this.f_19861_ = true;
        }
        else {
            this.detonate();
        }
    }
    
    private boolean isPartOfHydra(final Entity entity) {
        return this.m_37282_() instanceof Hydra && entity instanceof HydraPart && ((HydraPart)entity).getParent() == this.m_37282_();
    }
    
    public float m_7077_(final Explosion explosion, final BlockGetter world, final BlockPos pos, final BlockState state, final FluidState fluid, final float p_180428_6_) {
        float resistance = super.m_7077_(explosion, world, pos, state, fluid, p_180428_6_);
        if (this.megaBlast && state.m_60734_() != Blocks.f_50752_ && state.m_60734_() != Blocks.f_50257_ && state.m_60734_() != Blocks.f_50258_) {
            resistance = Math.min(0.8f, resistance);
        }
        return resistance;
    }
    
    private void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this);
        final Explosion.BlockInteraction flag2 = flag ? Explosion.BlockInteraction.BREAK : Explosion.BlockInteraction.NONE;
        this.f_19853_.m_46518_((Entity)this, this.m_20185_(), this.m_20186_(), this.m_20189_(), explosionPower, flag, flag2);
        final DamageSource src = new IndirectEntityDamageSource("onFire", (Entity)this, this.m_37282_()).m_19383_().m_19366_();
        for (final Entity nearby : this.f_19853_.m_45933_((Entity)this, this.m_142469_().m_82377_(1.0, 1.0, 1.0))) {
            if (nearby.m_6469_(src, 18.0f) && !nearby.m_5825_()) {
                nearby.m_20254_(5);
            }
        }
        this.m_146870_();
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        super.m_6469_(source, amount);
        if (source.m_7639_() != null && !this.f_19853_.f_46443_) {
            final Vec3 vec3d = source.m_7639_().m_20154_();
            if (vec3d != null) {
                this.m_6686_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.5f, 0.1f);
                this.f_19861_ = false;
                this.fuse += 20;
            }
            if (source.m_7639_() instanceof LivingEntity) {
                this.m_5602_(source.m_7639_());
            }
            return true;
        }
        return false;
    }
    
    public boolean m_6060_() {
        return true;
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    public float m_6143_() {
        return 1.5f;
    }
    
    protected float m_7139_() {
        return 0.05f;
    }
    
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
