// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.EntityLivingBase;

public class EntityAITFRedcapShy extends EntityAITFRedcapBase
{
    private EntityLivingBase entityTarget;
    private final float speed;
    private final boolean lefty;
    private double targetX;
    private double targetY;
    private double targetZ;
    private static final double minDistance = 3.0;
    private static final double maxDistance = 6.0;
    
    public EntityAITFRedcapShy(final EntityTFRedcap entityTFRedcap, final float moveSpeed) {
        super(entityTFRedcap);
        this.lefty = (Math.random() < 0.5);
        this.speed = moveSpeed;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase attackTarget = this.redcap.func_70638_az();
        if (attackTarget == null || !this.redcap.isShy() || attackTarget.func_70032_d((Entity)this.redcap) > 6.0 || attackTarget.func_70032_d((Entity)this.redcap) < 3.0 || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final Vec3d avoidPos = this.findCirclePoint((Entity)this.redcap, (Entity)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        this.targetX = avoidPos.field_72450_a;
        this.targetY = avoidPos.field_72448_b;
        this.targetZ = avoidPos.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.redcap.func_70661_as().func_75492_a(this.targetX, this.targetY, this.targetZ, (double)this.speed);
    }
    
    public boolean func_75253_b() {
        final EntityLivingBase attackTarget = this.redcap.func_70638_az();
        return attackTarget != null && this.entityTarget.func_70089_S() && !this.redcap.func_70661_as().func_75500_f() && this.redcap.isShy() && attackTarget.func_70032_d((Entity)this.redcap) < 6.0 && attackTarget.func_70032_d((Entity)this.redcap) > 3.0 && this.isTargetLookingAtMe(attackTarget);
    }
    
    public void func_75246_d() {
        this.redcap.func_70671_ap().func_75651_a((Entity)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void func_75251_c() {
        this.entityTarget = null;
        this.redcap.func_70661_as().func_75499_g();
    }
    
    private Vec3d findCirclePoint(final Entity circler, final Entity toCircle, final double radius, final double rotation) {
        final double vecx = circler.field_70165_t - toCircle.field_70165_t;
        final double vecz = circler.field_70161_v - toCircle.field_70161_v;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = MathHelper.func_76134_b(rangle) * radius;
        final double dz = MathHelper.func_76126_a(rangle) * radius;
        return new Vec3d(toCircle.field_70165_t + dx, circler.func_174813_aQ().field_72338_b, toCircle.field_70161_v + dz);
    }
}
