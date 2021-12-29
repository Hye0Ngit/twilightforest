// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import twilightforest.item.TFItems;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import java.util.Random;
import net.minecraft.core.particles.ParticleOptions;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.tags.Tag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Iterator;
import twilightforest.TFSounds;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.core.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class CubeOfAnnihilation extends ThrowableProjectile
{
    private boolean hasHitObstacle;
    
    public CubeOfAnnihilation(final EntityType<? extends CubeOfAnnihilation> type, final Level world) {
        super((EntityType)type, world);
        this.hasHitObstacle = false;
        this.m_5825_();
    }
    
    public CubeOfAnnihilation(final EntityType<? extends CubeOfAnnihilation> type, final Level world, final LivingEntity thrower) {
        super((EntityType)type, thrower, world);
        this.hasHitObstacle = false;
        this.m_5825_();
        this.m_37251_((Entity)thrower, thrower.m_146909_(), thrower.m_146908_(), 0.0f, 1.5f, 1.0f);
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    protected void m_8097_() {
    }
    
    protected float m_7139_() {
        return 0.0f;
    }
    
    protected void m_6532_(final HitResult ray) {
        if (this.f_19853_.f_46443_) {
            return;
        }
        if (ray instanceof EntityHitResult && ((EntityHitResult)ray).m_82443_() instanceof LivingEntity && ((EntityHitResult)ray).m_82443_().m_6469_(this.getDamageSource(), 10.0f)) {
            this.f_19797_ += 60;
        }
        if (ray instanceof final BlockHitResult raytrace) {
            if (raytrace.m_82425_() != null && !this.f_19853_.m_46859_(raytrace.m_82425_())) {
                this.affectBlocksInAABB(this.m_142469_().m_82377_(0.20000000298023224, 0.20000000298023224, 0.20000000298023224));
            }
        }
    }
    
    private DamageSource getDamageSource() {
        final LivingEntity thrower = (LivingEntity)this.m_37282_();
        if (thrower instanceof final Player player) {
            return DamageSource.m_19344_(player);
        }
        if (thrower != null) {
            return DamageSource.m_19370_(thrower);
        }
        return DamageSource.m_19361_((Entity)this, (Entity)null);
    }
    
    private void affectBlocksInAABB(final AABB box) {
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            final BlockState state = this.f_19853_.m_8055_(pos);
            if (!state.m_60795_()) {
                final Entity 37282_ = this.m_37282_();
                if (!(37282_ instanceof Player)) {
                    continue;
                }
                final Player player = (Player)37282_;
                if (!MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(this.f_19853_, pos, state, player))) {
                    if (this.canAnnihilate(pos, state)) {
                        this.f_19853_.m_7471_(pos, false);
                        this.m_5496_(TFSounds.BLOCK_ANNIHILATED, 0.125f, this.f_19796_.nextFloat() * 0.25f + 0.75f);
                        this.annihilateParticles(this.f_19853_, pos);
                    }
                    else {
                        this.hasHitObstacle = true;
                    }
                }
                else {
                    this.hasHitObstacle = true;
                }
            }
        }
    }
    
    private boolean canAnnihilate(final BlockPos pos, final BlockState state) {
        final Block block = state.m_60734_();
        return state.m_60620_((Tag)BlockTagGenerator.ANNIHILATION_INCLUSIONS) || (block.m_7325_() < 8.0f && state.m_60800_((BlockGetter)this.f_19853_, pos) >= 0.0f);
    }
    
    private void annihilateParticles(final Level world, final BlockPos pos) {
        final Random rand = world.m_5822_();
        if (world instanceof final ServerLevel serverLevel) {
            for (int dx = 0; dx < 3; ++dx) {
                for (int dy = 0; dy < 3; ++dy) {
                    for (int dz = 0; dz < 3; ++dz) {
                        final double x = pos.m_123341_() + (dx + 0.5) / 4.0;
                        final double y = pos.m_123342_() + (dy + 0.5) / 4.0;
                        final double z = pos.m_123343_() + (dz + 0.5) / 4.0;
                        final double speed = rand.nextGaussian() * 0.2;
                        serverLevel.m_8767_((ParticleOptions)TFParticleType.ANNIHILATE.get(), x, y, z, 1, 0.0, 0.0, 0.0, speed);
                    }
                }
            }
        }
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (!this.f_19853_.f_46443_) {
            if (this.m_37282_() == null) {
                this.m_142687_(Entity.RemovalReason.KILLED);
                return;
            }
            Vec3 destPoint = new Vec3(this.m_37282_().m_20185_(), this.m_37282_().m_20186_() + this.m_37282_().m_20192_(), this.m_37282_().m_20189_());
            final double distToPlayer = this.m_20270_(this.m_37282_());
            if (this.isReturning()) {
                if (distToPlayer < 2.0) {
                    this.m_142687_(Entity.RemovalReason.KILLED);
                }
            }
            else {
                destPoint = destPoint.m_82549_(this.m_37282_().m_20154_().m_82490_(16.0));
            }
            final Vec3 velocity = new Vec3(this.m_20185_() - destPoint.m_7096_(), this.m_20186_() + this.m_20206_() / 2.0f - destPoint.m_7098_(), this.m_20189_() - destPoint.m_7094_());
            this.m_20334_(-velocity.m_7096_(), -velocity.m_7098_(), -velocity.m_7094_());
            final float currentSpeed = Mth.m_14116_((float)(this.m_20184_().m_7096_() * this.m_20184_().m_7096_() + this.m_20184_().m_7098_() * this.m_20184_().m_7098_() + this.m_20184_().m_7094_() * this.m_20184_().m_7094_()));
            final float maxSpeed = 0.5f;
            if (currentSpeed > maxSpeed) {
                this.m_20256_(new Vec3(this.m_20184_().m_7096_() / (currentSpeed / maxSpeed), this.m_20184_().m_7098_() / (currentSpeed / maxSpeed), this.m_20184_().m_7094_() / (currentSpeed / maxSpeed)));
            }
            else {
                final float slow = 0.5f;
                this.m_20184_().m_82542_((double)slow, (double)slow, (double)slow);
            }
            this.affectBlocksInAABB(this.m_142469_().m_82377_(0.20000000298023224, 0.20000000298023224, 0.20000000298023224));
        }
    }
    
    public void m_142687_(final Entity.RemovalReason reason) {
        super.m_142687_(reason);
        final LivingEntity thrower = (LivingEntity)this.m_37282_();
        if (thrower != null && thrower.m_21211_().m_41720_() == TFItems.CUBE_OF_ANNIHILATION.get()) {
            thrower.m_5810_();
        }
    }
    
    private boolean isReturning() {
        if (!this.hasHitObstacle && this.m_37282_() != null) {
            final Entity 37282_ = this.m_37282_();
            if (37282_ instanceof final Player player) {
                return !player.m_6117_();
            }
        }
        return true;
    }
    
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
