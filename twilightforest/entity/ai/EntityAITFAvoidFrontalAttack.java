// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFAvoidFrontalAttack extends EntityAIBase
{
    EntityLiving entityTarget;
    EntityLiving me;
    float speed;
    boolean lefty;
    double xPosition;
    double yPosition;
    double zPosition;
    double minDistance;
    double maxDistance;
    
    public EntityAITFAvoidFrontalAttack(final EntityTFRedcap entityTFRedcap, final float moveSpeed) {
        this.minDistance = 3.0;
        this.maxDistance = 6.0;
        this.me = (EntityLiving)entityTFRedcap;
        this.speed = moveSpeed;
        this.lefty = this.me.field_70170_p.field_73012_v.nextBoolean();
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        final EntityLiving attackTarget = this.me.func_70638_az();
        if (attackTarget == null || attackTarget.func_70032_d((Entity)this.me) > this.maxDistance || attackTarget.func_70032_d((Entity)this.me) < this.minDistance || !this.isTargetLookingAtMe(attackTarget)) {
            return false;
        }
        this.entityTarget = attackTarget;
        final Vec3 avoidPos = this.findCirclePoint((Entity)this.me, (Entity)this.entityTarget, 5.0, this.lefty ? 1.0 : -1.0);
        if (avoidPos == null) {
            return false;
        }
        this.xPosition = avoidPos.field_72450_a;
        this.yPosition = avoidPos.field_72448_b;
        this.zPosition = avoidPos.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.me.func_70661_as().func_75492_a(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
    
    public boolean func_75253_b() {
        final EntityLiving attackTarget = this.me.func_70638_az();
        if (attackTarget == null) {
            return false;
        }
        if (!this.entityTarget.func_70089_S()) {
            return false;
        }
        if (this.me.func_70661_as().func_75500_f()) {
            return false;
        }
        final boolean shouldContinue = attackTarget.func_70032_d((Entity)this.me) < this.maxDistance && attackTarget.func_70032_d((Entity)this.me) > this.minDistance && this.isTargetLookingAtMe(attackTarget);
        return shouldContinue;
    }
    
    public void func_75246_d() {
        this.me.func_70671_ap().func_75651_a((Entity)this.entityTarget, 30.0f, 30.0f);
    }
    
    public void func_75251_c() {
        this.entityTarget = null;
        this.me.func_70661_as().func_75499_g();
    }
    
    protected Vec3 findCirclePoint(final Entity circler, final Entity toCircle, final double radius, final double rotation) {
        final double vecx = circler.field_70165_t - toCircle.field_70165_t;
        final double vecz = circler.field_70161_v - toCircle.field_70161_v;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)rotation;
        final double dx = MathHelper.func_76134_b(rangle) * radius;
        final double dz = MathHelper.func_76126_a(rangle) * radius;
        return this.me.field_70170_p.func_82732_R().func_72345_a(toCircle.field_70165_t + dx, circler.field_70121_D.field_72338_b, toCircle.field_70161_v + dz);
    }
    
    public boolean isTargetLookingAtMe(final EntityLiving target) {
        final double dx = this.me.field_70165_t - target.field_70165_t;
        final double dz = this.me.field_70161_v - target.field_70161_v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = MathHelper.func_76135_e((target.field_70177_z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
}
