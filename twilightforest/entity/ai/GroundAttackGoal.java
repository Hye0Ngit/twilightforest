// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.AABB;
import twilightforest.TFSounds;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.boss.Minoshroom;
import net.minecraft.world.entity.ai.goal.Goal;

public class GroundAttackGoal extends Goal
{
    private static final double MIN_RANGE_SQ = 2.0;
    private static final double MAX_RANGE_SQ = 48.0;
    private static final int FREQ = 24;
    private final Minoshroom attacker;
    private LivingEntity attackTarget;
    private int attackTick;
    
    public GroundAttackGoal(final Minoshroom entityTFMinoshroom) {
        this.attacker = entityTFMinoshroom;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        this.attackTarget = this.attacker.m_5448_();
        if (this.attackTarget == null) {
            return false;
        }
        final double distance = this.attacker.m_20280_((Entity)this.attackTarget);
        if (distance < 2.0 || distance > 48.0) {
            return false;
        }
        if (!this.attacker.m_20096_()) {
            return false;
        }
        if (this.attacker.m_142582_((Entity)this.attackTarget)) {
            return this.attacker.m_21187_().nextInt(24) == 0;
        }
        return this.attacker.m_21187_().nextInt(20) == 0;
    }
    
    public void m_8056_() {
        this.attackTick = 30 + this.attacker.m_21187_().nextInt(30);
        this.attacker.setMaxCharge(this.attackTick);
        this.attacker.setGroundAttackCharge(true);
    }
    
    public boolean m_8045_() {
        return this.attackTick >= 0;
    }
    
    public void m_8041_() {
        this.attackTick = 0;
        this.attackTarget = null;
    }
    
    public void m_8037_() {
        this.attacker.m_21563_().m_24960_((Entity)this.attackTarget, 30.0f, 30.0f);
        this.attacker.m_21566_().f_24981_ = MoveControl.Operation.WAIT;
        if (this.attackTick-- <= 0) {
            this.attacker.setGroundAttackCharge(false);
            this.attacker.m_5496_(TFSounds.MINOSHROOM_SLAM, 2.0f, 1.0f + this.attacker.m_21187_().nextFloat() * 0.1f);
            final AABB selection = new AABB((double)(this.attacker.m_142538_().m_123341_() - 7.5f), (double)this.attacker.m_142538_().m_123342_(), (double)(this.attacker.m_142538_().m_123343_() - 7.5f), (double)(this.attacker.m_142538_().m_123341_() + 7.5f), (double)(this.attacker.m_142538_().m_123342_() + 3.0f), (double)(this.attacker.m_142538_().m_123343_() + 7.5f));
            final List<Entity> hit = this.attacker.f_19853_.m_45976_((Class)Entity.class, selection);
            for (final Entity entity : hit) {
                if (entity == this.attacker) {
                    continue;
                }
                if (!(entity instanceof LivingEntity) || !entity.m_20096_()) {
                    continue;
                }
                entity.m_5997_(0.0, 0.23, 0.0);
                entity.m_6469_(DamageSource.m_19370_((LivingEntity)this.attacker).m_19380_(), (float)(this.attacker.m_21051_(Attributes.f_22281_).m_22135_() * 0.5));
            }
        }
    }
}
