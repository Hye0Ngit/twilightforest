// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.monster.Kobold;
import net.minecraft.world.phys.Vec3;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.LivingEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class PanicOnFlockDeathGoal extends Goal
{
    private PathfinderMob flockCreature;
    private float speed;
    private double fleeX;
    private double fleeY;
    private double fleeZ;
    private int fleeTimer;
    
    public PanicOnFlockDeathGoal(final PathfinderMob creature, final float speed) {
        this.flockCreature = creature;
        this.speed = speed;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        this.fleeTimer = 0;
    }
    
    public boolean m_8036_() {
        boolean yikes = this.fleeTimer > 0;
        final List<? extends PathfinderMob> flockList = this.flockCreature.f_19853_.m_45976_((Class)this.flockCreature.getClass(), this.flockCreature.m_142469_().m_82377_(4.0, 2.0, 4.0));
        for (final LivingEntity flocker : flockList) {
            if (flocker.f_20919_ > 0) {
                yikes = true;
                break;
            }
        }
        if (!yikes) {
            return false;
        }
        final Vec3 target = DefaultRandomPos.m_148403_(this.flockCreature, 5, 4);
        if (target == null) {
            return false;
        }
        this.fleeX = target.f_82479_;
        this.fleeY = target.f_82480_;
        this.fleeZ = target.f_82481_;
        return true;
    }
    
    public void m_8056_() {
        this.fleeTimer = 40;
        this.flockCreature.m_21573_().m_26519_(this.fleeX, this.fleeY, this.fleeZ, (double)this.speed);
        if (this.flockCreature instanceof final Kobold kobold) {
            kobold.setPanicked(true);
        }
    }
    
    public boolean m_8045_() {
        return this.fleeTimer > 0 && !this.flockCreature.m_21573_().m_26571_();
    }
    
    public void m_8037_() {
        --this.fleeTimer;
    }
    
    public void m_8041_() {
        this.fleeTimer -= 20;
        if (this.flockCreature instanceof final Kobold kobold) {
            kobold.setPanicked(false);
        }
    }
}
