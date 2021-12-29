// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.entity.EntityTFLichBolt;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFNatureBolt;

public class EntityAITFMagicAttack extends og
{
    public static final int SLIME = 4;
    public static final int LICH = 3;
    public static final int TOME = 2;
    public static final int NATURE = 1;
    zv worldObj;
    ng entityHost;
    ng attackTarget;
    int rangedAttackTime;
    float moveSpeed;
    int ticksLookingAtTarget;
    int rangedAttackID;
    int maxRangedAttackTime;
    float attackChance;
    
    public EntityAITFMagicAttack(final ng par1EntityLiving, final float speed, final int id, final int time) {
        this(par1EntityLiving, speed, id, time, 1.0f);
    }
    
    public EntityAITFMagicAttack(final ng par1EntityLiving, final float speed, final int id, final int time, final float chance) {
        this.rangedAttackTime = 0;
        this.ticksLookingAtTarget = 0;
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.q;
        this.moveSpeed = speed;
        this.rangedAttackID = id;
        this.maxRangedAttackTime = time;
        this.attackChance = chance;
        this.a(3);
    }
    
    public boolean a() {
        final ng var1 = this.entityHost.aJ();
        if (var1 == null || this.entityHost.aE().nextFloat() > this.attackChance) {
            return false;
        }
        this.attackTarget = var1;
        return true;
    }
    
    public boolean b() {
        return this.a() || !this.entityHost.aC().f();
    }
    
    public void d() {
        this.attackTarget = null;
    }
    
    public void e() {
        final double maxRange = 100.0;
        final double targetDistance = this.entityHost.e(this.attackTarget.u, this.attackTarget.E.b, this.attackTarget.w);
        final boolean canSee = this.entityHost.aD().a((mp)this.attackTarget);
        if (canSee) {
            ++this.ticksLookingAtTarget;
        }
        else {
            this.ticksLookingAtTarget = 0;
        }
        if (targetDistance <= maxRange && this.ticksLookingAtTarget >= 20) {
            this.entityHost.aC().g();
        }
        else {
            this.entityHost.aC().a(this.attackTarget, this.moveSpeed);
        }
        this.entityHost.az().a((mp)this.attackTarget, 30.0f, 30.0f);
        this.rangedAttackTime = Math.max(this.rangedAttackTime - 1, 0);
        if (this.rangedAttackTime <= 0 && targetDistance <= maxRange && canSee) {
            this.doRangedAttack();
            this.rangedAttackTime = this.maxRangedAttackTime;
        }
    }
    
    protected void doRangedAttack() {
        sv projectile = null;
        if (this.rangedAttackID == 1) {
            projectile = new EntityTFNatureBolt(this.worldObj, this.entityHost);
            this.worldObj.a((mp)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aE().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 2) {
            projectile = new EntityTFTomeBolt(this.worldObj, this.entityHost);
            this.worldObj.a((mp)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aE().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 3) {
            projectile = new EntityTFLichBolt(this.worldObj, this.entityHost);
            this.worldObj.a((mp)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aE().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 4) {
            projectile = new EntityTFSlimeProjectile(this.worldObj, this.entityHost);
            this.worldObj.a((mp)this.entityHost, "mob.slime.small", 1.0f, 1.0f / (this.entityHost.aE().nextFloat() * 0.4f + 0.8f));
        }
        if (projectile != null) {
            final double tx = this.attackTarget.u - this.entityHost.u;
            final double ty = this.attackTarget.v + this.attackTarget.e() - 1.100000023841858 - projectile.v;
            final double tz = this.attackTarget.w - this.entityHost.w;
            final float heightOffset = kx.a(tx * tx + tz * tz) * 0.2f;
            projectile.c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.worldObj.d((mp)projectile);
        }
    }
}
