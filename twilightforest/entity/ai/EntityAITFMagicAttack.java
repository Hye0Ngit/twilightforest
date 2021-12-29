// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.entity.EntityTFLichBolt;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFNatureBolt;

public class EntityAITFMagicAttack extends pr
{
    public static final int SLIME = 4;
    public static final int LICH = 3;
    public static final int TOME = 2;
    public static final int NATURE = 1;
    abv worldObj;
    of entityHost;
    oe attackTarget;
    int rangedAttackTime;
    float moveSpeed;
    int ticksLookingAtTarget;
    int rangedAttackID;
    int maxRangedAttackTime;
    float attackChance;
    
    public EntityAITFMagicAttack(final of par1EntityLiving, final float speed, final int id, final int time) {
        this(par1EntityLiving, speed, id, time, 1.0f);
    }
    
    public EntityAITFMagicAttack(final of par1EntityLiving, final float speed, final int id, final int time, final float chance) {
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
        final oe var1 = this.entityHost.m();
        if (var1 == null || this.entityHost.aC().nextFloat() > this.attackChance) {
            return false;
        }
        this.attackTarget = var1;
        return true;
    }
    
    public boolean b() {
        return this.a() || !this.entityHost.k().g();
    }
    
    public void d() {
        this.attackTarget = null;
    }
    
    public void e() {
        final double maxRange = 100.0;
        final double targetDistance = this.entityHost.e(this.attackTarget.u, this.attackTarget.E.b, this.attackTarget.w);
        final boolean canSee = this.entityHost.l().a((nm)this.attackTarget);
        if (canSee) {
            ++this.ticksLookingAtTarget;
        }
        else {
            this.ticksLookingAtTarget = 0;
        }
        if (targetDistance <= maxRange && this.ticksLookingAtTarget >= 20) {
            this.entityHost.k().h();
        }
        else {
            this.entityHost.k().a((nm)this.attackTarget, (double)this.moveSpeed);
        }
        this.entityHost.h().a((nm)this.attackTarget, 30.0f, 30.0f);
        this.rangedAttackTime = Math.max(this.rangedAttackTime - 1, 0);
        if (this.rangedAttackTime <= 0 && targetDistance <= maxRange && canSee) {
            this.doRangedAttack();
            this.rangedAttackTime = this.maxRangedAttackTime;
        }
    }
    
    protected void doRangedAttack() {
        up projectile = null;
        if (this.rangedAttackID == 1) {
            projectile = new EntityTFNatureBolt(this.worldObj, (oe)this.entityHost);
            this.worldObj.a((nm)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aC().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 2) {
            projectile = new EntityTFTomeBolt(this.worldObj, (oe)this.entityHost);
            this.worldObj.a((nm)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aC().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 3) {
            projectile = new EntityTFLichBolt(this.worldObj, (oe)this.entityHost);
            this.worldObj.a((nm)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aC().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 4) {
            projectile = new EntityTFSlimeProjectile(this.worldObj, (oe)this.entityHost);
            this.worldObj.a((nm)this.entityHost, "mob.slime.small", 1.0f, 1.0f / (this.entityHost.aC().nextFloat() * 0.4f + 0.8f));
        }
        if (projectile != null) {
            final double tx = this.attackTarget.u - this.entityHost.u;
            final double ty = this.attackTarget.v + this.attackTarget.f() - 1.100000023841858 - projectile.v;
            final double tz = this.attackTarget.w - this.entityHost.w;
            final float heightOffset = lr.a(tx * tx + tz * tz) * 0.2f;
            projectile.c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.worldObj.d((nm)projectile);
        }
    }
}
