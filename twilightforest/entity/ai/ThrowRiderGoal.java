// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import twilightforest.network.ThrowPlayerPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import twilightforest.TFEventListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.Tag;
import twilightforest.data.EntityTagGenerator;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class ThrowRiderGoal extends MeleeAttackGoal
{
    private int throwTimer;
    private int timeout;
    private int cooldown;
    
    public ThrowRiderGoal(final PathfinderMob creature, final double speedIn, final boolean useLongMemory) {
        super(creature, speedIn, useLongMemory);
    }
    
    public boolean m_8036_() {
        return this.f_25540_.m_20197_().isEmpty() && super.m_8036_();
    }
    
    public void m_8056_() {
        this.throwTimer = 10 + this.f_25540_.m_21187_().nextInt(30);
        this.timeout = 80 + this.f_25540_.m_21187_().nextInt(40);
        super.m_8056_();
    }
    
    public void m_8037_() {
        --this.timeout;
        if (!this.f_25540_.m_20197_().isEmpty()) {
            --this.throwTimer;
        }
        else {
            super.m_8037_();
        }
    }
    
    protected void m_6739_(final LivingEntity victim, final double p_190102_2_) {
        final double d0 = this.m_6639_(victim);
        if (p_190102_2_ <= d0 && this.m_25565_() <= 0 && this.f_25540_.m_20197_().isEmpty() && this.cooldown-- == 0) {
            this.cooldown = 3;
            this.m_25563_();
            this.f_25540_.m_6674_(InteractionHand.MAIN_HAND);
            if (this.f_25540_.m_20197_().isEmpty()) {
                final Entity v = victim.m_20202_();
                if (v == null || !v.m_6095_().m_20609_((Tag)EntityTagGenerator.RIDES_OBSTRUCT_SNATCHING)) {
                    victim.m_8127_();
                    victim.m_7998_((Entity)this.f_25540_, true);
                }
            }
        }
    }
    
    public void m_8041_() {
        if (!this.f_25540_.m_20197_().isEmpty()) {
            final Entity rider = this.f_25540_.m_20197_().get(0);
            TFEventListener.allowDismount = true;
            rider.m_8127_();
            TFEventListener.allowDismount = false;
            Vec3 throwVec = this.f_25540_.m_20154_().m_82490_(2.0);
            throwVec = new Vec3(throwVec.f_82479_, 0.9, throwVec.f_82481_);
            rider.m_5997_(throwVec.f_82479_, throwVec.f_82480_, throwVec.f_82481_);
            if (rider instanceof final ServerPlayer player) {
                final ThrowPlayerPacket message = new ThrowPlayerPacket((float)throwVec.f_82479_, (float)throwVec.f_82480_, (float)throwVec.f_82481_);
                TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)message);
            }
        }
        super.m_8041_();
    }
    
    public boolean m_8045_() {
        return (this.throwTimer > 0 && !this.f_25540_.m_20197_().isEmpty()) || (this.timeout > 0 && super.m_8045_() && this.f_25540_.m_20197_().isEmpty());
    }
}
