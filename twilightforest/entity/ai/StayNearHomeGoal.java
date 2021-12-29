// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.Vec3;
import java.util.EnumSet;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class StayNearHomeGoal extends Goal
{
    private final PathfinderMob entity;
    private final float speed;
    
    public StayNearHomeGoal(final PathfinderMob entityTFYetiAlpha, final float sp) {
        this.entity = entityTFYetiAlpha;
        this.speed = sp;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean m_8036_() {
        return !this.entity.m_21533_();
    }
    
    public boolean m_8045_() {
        return !this.entity.m_21573_().m_26571_();
    }
    
    public void m_8056_() {
        if (this.entity.m_20238_(Vec3.m_82528_((Vec3i)this.entity.m_21534_())) > 256.0) {
            final Vec3 vec3 = DefaultRandomPos.m_148412_(this.entity, 14, 3, new Vec3(this.entity.m_21534_().m_123341_() + 0.5, (double)this.entity.m_21534_().m_123342_(), this.entity.m_21534_().m_123343_() + 0.5), 1.5707963705062866);
            if (vec3 != null) {
                this.entity.m_21573_().m_26519_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, (double)this.speed);
            }
        }
        else {
            this.entity.m_21573_().m_26519_(this.entity.m_21534_().m_123341_() + 0.5, (double)this.entity.m_21534_().m_123342_(), this.entity.m_21534_().m_123343_() + 0.5, (double)this.speed);
        }
    }
}
