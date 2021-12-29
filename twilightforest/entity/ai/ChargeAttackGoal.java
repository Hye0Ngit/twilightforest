// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import net.minecraft.world.phys.AABB;
import twilightforest.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraftforge.event.ForgeEventFactory;
import twilightforest.entity.ITFCharger;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class ChargeAttackGoal extends Goal
{
    private static final double MIN_RANGE_SQ = 16.0;
    private static final double MAX_RANGE_SQ = 64.0;
    private static final int FREQ = 1;
    private PathfinderMob charger;
    private LivingEntity chargeTarget;
    private double chargeX;
    private double chargeY;
    private double chargeZ;
    protected float speed;
    private final boolean canBreak;
    private int windup;
    private boolean hasAttacked;
    
    public ChargeAttackGoal(final PathfinderMob entityLiving, final float f, final boolean canBreak) {
        this.charger = entityLiving;
        this.speed = f;
        this.canBreak = canBreak;
        this.windup = 0;
        this.hasAttacked = false;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        this.chargeTarget = this.charger.m_5448_();
        if (this.chargeTarget == null) {
            return false;
        }
        final double distance = this.charger.m_20280_((Entity)this.chargeTarget);
        if (distance < 16.0 || distance > 64.0) {
            return false;
        }
        if (!this.charger.m_20096_()) {
            return false;
        }
        final Vec3 chargePos = this.findChargePoint((Entity)this.charger, (Entity)this.chargeTarget, 2.1);
        final boolean canSeeTargetFromDest = this.charger.m_21574_().m_148306_((Entity)this.chargeTarget);
        if (!canSeeTargetFromDest) {
            return false;
        }
        this.chargeX = chargePos.f_82479_;
        this.chargeY = chargePos.f_82480_;
        this.chargeZ = chargePos.f_82481_;
        return this.charger.m_21187_().nextInt(1) == 0;
    }
    
    public void m_8056_() {
        this.windup = 15 + this.charger.m_21187_().nextInt(30);
        this.charger.m_6858_(true);
    }
    
    public boolean m_8045_() {
        return this.windup > 0 || !this.charger.m_21573_().m_26571_();
    }
    
    public void m_8037_() {
        this.charger.m_21563_().m_24950_(this.chargeX, this.chargeY - 1.0, this.chargeZ, 10.0f, (float)this.charger.m_8132_());
        if (this.windup > 0) {
            if (--this.windup == 0) {
                this.charger.m_21573_().m_26519_(this.chargeX, this.chargeY, this.chargeZ, (double)this.speed);
            }
            else {
                final PathfinderMob charger = this.charger;
                charger.f_20924_ += (float)0.8;
                if (this.charger instanceof final ITFCharger itfCharger) {
                    itfCharger.setCharging(true);
                }
            }
        }
        else if (this.canBreak && !this.charger.f_19853_.f_46443_ && ForgeEventFactory.getMobGriefingEvent(this.charger.f_19853_, (Entity)this.charger)) {
            final AABB bb = this.charger.m_142469_();
            final int minx = Mth.m_14107_(bb.f_82288_ - 0.75);
            final int miny = Mth.m_14107_(bb.f_82289_ + 0.0);
            final int minz = Mth.m_14107_(bb.f_82290_ - 0.75);
            final int maxx = Mth.m_14107_(bb.f_82291_ + 0.75);
            final int maxy = Mth.m_14107_(bb.f_82292_ + 0.15);
            final int maxz = Mth.m_14107_(bb.f_82293_ + 0.75);
            final BlockPos min = new BlockPos(minx, miny, minz);
            final BlockPos max = new BlockPos(maxx, maxy, maxz);
            if (this.charger.f_19853_.m_46832_(min, max)) {
                for (final BlockPos pos : BlockPos.m_121940_(min, max)) {
                    if (EntityUtil.canDestroyBlock(this.charger.f_19853_, pos, (Entity)this.charger) && this.charger.f_19853_.m_7702_(pos) == null) {
                        this.charger.f_19853_.m_46961_(pos, true);
                    }
                }
            }
        }
        final double rangeSq = this.charger.m_20205_() * 2.1f * this.charger.m_20205_() * 2.1f;
        if (this.charger.m_20275_(this.chargeTarget.m_20185_(), this.chargeTarget.m_142469_().f_82289_, this.chargeTarget.m_20189_()) <= rangeSq && !this.hasAttacked) {
            this.hasAttacked = true;
            this.charger.m_7327_((Entity)this.chargeTarget);
        }
    }
    
    public void m_8041_() {
        this.windup = 0;
        this.chargeTarget = null;
        this.hasAttacked = false;
        this.charger.m_6858_(false);
        if (this.charger instanceof final ITFCharger itfCharger) {
            itfCharger.setCharging(false);
        }
    }
    
    protected Vec3 findChargePoint(final Entity attacker, final Entity target, final double overshoot) {
        final double vecx = target.m_20185_() - attacker.m_20185_();
        final double vecz = target.m_20189_() - attacker.m_20189_();
        final float rangle = (float)Math.atan2(vecz, vecx);
        final double distance = Mth.m_14116_((float)(vecx * vecx + vecz * vecz));
        final double dx = Mth.m_14089_(rangle) * (distance + overshoot);
        final double dz = Mth.m_14031_(rangle) * (distance + overshoot);
        return new Vec3(attacker.m_20185_() + dx, target.m_20186_(), attacker.m_20189_() + dz);
    }
}
