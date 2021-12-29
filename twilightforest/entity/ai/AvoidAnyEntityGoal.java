// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.vector.Vector3d;
import java.util.List;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.EntityPredicates;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.entity.CreatureEntity;
import java.util.function.Predicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.Entity;

public class AvoidAnyEntityGoal<T extends Entity> extends Goal
{
    private final Predicate<Entity> builtTargetSelector;
    protected final CreatureEntity entity;
    private final double farSpeed;
    private final double nearSpeed;
    protected T avoidTarget;
    protected final float avoidDistance;
    protected Path path;
    protected final PathNavigator navigation;
    protected final Class<T> classToAvoid;
    protected final Predicate<Entity> avoidTargetSelector;
    
    public AvoidAnyEntityGoal(final CreatureEntity entityIn, final Class<T> classToAvoidIn, final float avoidDistanceIn, final double farSpeedIn, final double nearSpeedIn) {
        this(entityIn, classToAvoidIn, entity -> true, avoidDistanceIn, farSpeedIn, nearSpeedIn);
    }
    
    public AvoidAnyEntityGoal(final CreatureEntity entityIn, final Class<T> avoidClass, final Predicate<Entity> targetPredicate, final float distance, final double nearSpeedIn, final double farSpeedIn) {
        this.builtTargetSelector = new Predicate<Entity>() {
            @Override
            public boolean test(@Nullable final Entity input) {
                return input.func_70089_S() && AvoidAnyEntityGoal.this.entity.func_70635_at().func_75522_a(input) && !AvoidAnyEntityGoal.this.entity.func_184191_r(input);
            }
        };
        this.entity = entityIn;
        this.classToAvoid = avoidClass;
        this.avoidTargetSelector = targetPredicate;
        this.avoidDistance = distance;
        this.farSpeed = nearSpeedIn;
        this.nearSpeed = farSpeedIn;
        this.navigation = entityIn.func_70661_as();
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean func_75250_a() {
        final List<T> list = this.entity.field_70170_p.func_175647_a((Class)this.classToAvoid, this.entity.func_174813_aQ().func_72314_b((double)this.avoidDistance, 3.0, (double)this.avoidDistance), (Predicate)EntityPredicates.field_188444_d.and(this.builtTargetSelector).and(this.avoidTargetSelector));
        if (list.isEmpty()) {
            return false;
        }
        this.avoidTarget = list.get(0);
        final Vector3d vec3d = RandomPositionGenerator.func_75461_b(this.entity, 16, 7, this.entity.func_213303_ch());
        if (vec3d == null) {
            return false;
        }
        if (this.avoidTarget.func_70092_e(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c) < this.avoidTarget.func_70068_e((Entity)this.entity)) {
            return false;
        }
        this.path = this.navigation.func_225466_a(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 0);
        return this.path != null;
    }
    
    public boolean func_75253_b() {
        return !this.navigation.func_75500_f();
    }
    
    public void func_75249_e() {
        this.navigation.func_75484_a(this.path, this.farSpeed);
    }
    
    public void func_75251_c() {
        this.avoidTarget = null;
    }
    
    public void func_75246_d() {
        if (this.entity.func_70068_e((Entity)this.avoidTarget) < 49.0) {
            this.entity.func_70661_as().func_75489_a(this.nearSpeed);
        }
        else {
            this.entity.func_70661_as().func_75489_a(this.farSpeed);
        }
    }
}
