// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.RedcapEntity;
import net.minecraft.entity.LivingEntity;

public class RedcapShyGoal extends RedcapBaseGoal
{
    private LivingEntity entityTarget;
    private final float speed;
    private final boolean lefty;
    private double targetX;
    private double targetY;
    private double targetZ;
    private static final double minDistance = 3.0;
    private static final double maxDistance = 6.0;
    
    public RedcapShyGoal(final RedcapEntity entityTFRedcap, final float moveSpeed) {
        super(entityTFRedcap);
        this.lefty = (Math.random() < 0.5);
        this.speed = moveSpeed;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        final LivingEntity attackTarget = this.redcap.func_70638_az();
        if (attackTarget == null || !this.redcap.isShy() || attackTarget.func_70032_d((Entity)this.redcap) > 6.0 || attackTarget.func_70032_d((Entity)this.redcap) < 3.0 || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final Vector3d avoidPos = this.findCirclePoint((Entity)this.redcap, (Entity)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        this.targetX = avoidPos.field_72450_a;
        this.targetY = avoidPos.field_72448_b;
        this.targetZ = avoidPos.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.redcap.func_70661_as().func_75492_a(this.targetX, this.targetY, this.targetZ, (double)this.speed);
    }
    
    public boolean func_75253_b() {
        final LivingEntity attackTarget = this.redcap.func_70638_az();
        return attackTarget != null && this.entityTarget.func_70089_S() && !this.redcap.func_70661_as().func_75500_f() && this.redcap.isShy() && attackTarget.func_70032_d((Entity)this.redcap) < 6.0 && attackTarget.func_70032_d((Entity)this.redcap) > 3.0 && this.isTargetLookingAtMe(attackTarget);
    }
    
    public void func_75246_d() {
        this.redcap.func_70671_ap().func_75651_a((Entity)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void func_75251_c() {
        this.entityTarget = null;
        this.redcap.func_70661_as().func_75499_g();
    }
    
    private Vector3d findCirclePoint(final Entity circler, final Entity toCircle, final double radius, final double rotation) {
        final double vecx = circler.func_226277_ct_() - toCircle.func_226277_ct_();
        final double vecz = circler.func_226281_cx_() - toCircle.func_226281_cx_();
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = MathHelper.func_76134_b(rangle) * radius;
        final double dz = MathHelper.func_76126_a(rangle) * radius;
        return new Vector3d(toCircle.func_226277_ct_() + dx, circler.func_174813_aQ().field_72338_b, toCircle.func_226281_cx_() + dz);
    }
}
