// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.phys.Vec3;
import java.util.List;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.EntitySelector;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.entity.PathfinderMob;
import java.util.function.Predicate;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Entity;

public class AvoidAnyEntityGoal<T extends Entity> extends Goal
{
    private final Predicate<Entity> builtTargetSelector;
    protected final PathfinderMob entity;
    private final double farSpeed;
    private final double nearSpeed;
    protected T avoidTarget;
    protected final float avoidDistance;
    protected Path path;
    protected final PathNavigation navigation;
    protected final Class<T> classToAvoid;
    protected final Predicate<Entity> avoidTargetSelector;
    
    public AvoidAnyEntityGoal(final PathfinderMob entityIn, final Class<T> classToAvoidIn, final float avoidDistanceIn, final double farSpeedIn, final double nearSpeedIn) {
        this(entityIn, classToAvoidIn, entity -> true, avoidDistanceIn, farSpeedIn, nearSpeedIn);
    }
    
    public AvoidAnyEntityGoal(final PathfinderMob entityIn, final Class<T> avoidClass, final Predicate<Entity> targetPredicate, final float distance, final double nearSpeedIn, final double farSpeedIn) {
        this.builtTargetSelector = new Predicate<Entity>() {
            @Override
            public boolean test(@Nullable final Entity input) {
                return input.m_6084_() && AvoidAnyEntityGoal.this.entity.m_21574_().m_148306_(input) && !AvoidAnyEntityGoal.this.entity.m_7307_(input);
            }
        };
        this.entity = entityIn;
        this.classToAvoid = avoidClass;
        this.avoidTargetSelector = targetPredicate;
        this.avoidDistance = distance;
        this.farSpeed = nearSpeedIn;
        this.nearSpeed = farSpeedIn;
        this.navigation = entityIn.m_21573_();
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean m_8036_() {
        final List<T> list = this.entity.f_19853_.m_6443_((Class)this.classToAvoid, this.entity.m_142469_().m_82377_((double)this.avoidDistance, 3.0, (double)this.avoidDistance), (Predicate)EntitySelector.f_20406_.and(this.builtTargetSelector).and(this.avoidTargetSelector));
        if (list.isEmpty()) {
            return false;
        }
        this.avoidTarget = list.get(0);
        final Vec3 vec3d = DefaultRandomPos.m_148407_(this.entity, 16, 7, this.entity.m_20182_());
        if (vec3d == null) {
            return false;
        }
        if (this.avoidTarget.m_20275_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_) < this.avoidTarget.m_20280_((Entity)this.entity)) {
            return false;
        }
        this.path = this.navigation.m_26524_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 0);
        return this.path != null;
    }
    
    public boolean m_8045_() {
        return !this.navigation.m_26571_();
    }
    
    public void m_8056_() {
        this.navigation.m_26536_(this.path, this.farSpeed);
    }
    
    public void m_8041_() {
        this.avoidTarget = null;
    }
    
    public void m_8037_() {
        if (this.entity.m_20280_((Entity)this.avoidTarget) < 49.0) {
            this.entity.m_21573_().m_26517_(this.nearSpeed);
        }
        else {
            this.entity.m_21573_().m_26517_(this.farSpeed);
        }
    }
}
