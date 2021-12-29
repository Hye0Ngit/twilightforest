// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityAITFMagicAttack extends nc
{
    public static final int SLIME = 4;
    public static final int LICH = 3;
    public static final int TOME = 2;
    public static final int NATURE = 1;
    xv worldObj;
    md entityHost;
    md attackTarget;
    int rangedAttackTime;
    float moveSpeed;
    int ticksLookingAtTarget;
    int rangedAttackID;
    int maxRangedAttackTime;
    float attackChance;
    
    public EntityAITFMagicAttack(final md par1EntityLiving, final float speed, final int id, final int time) {
        this(par1EntityLiving, speed, id, time, 1.0f);
    }
    
    public EntityAITFMagicAttack(final md par1EntityLiving, final float speed, final int id, final int time, final float chance) {
        this.rangedAttackTime = 0;
        this.ticksLookingAtTarget = 0;
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.p;
        this.moveSpeed = speed;
        this.rangedAttackID = id;
        this.maxRangedAttackTime = time;
        this.attackChance = chance;
        this.a(3);
    }
    
    public boolean a() {
        final md var1 = this.entityHost.aG();
        if (var1 == null || this.entityHost.aB().nextFloat() > this.attackChance) {
            return false;
        }
        this.attackTarget = var1;
        return true;
    }
    
    public boolean b() {
        return this.a() || !this.entityHost.az().f();
    }
    
    public void d() {
        this.attackTarget = null;
    }
    
    public void e() {
        final double maxRange = 100.0;
        final double targetDistance = this.entityHost.e(this.attackTarget.t, this.attackTarget.D.b, this.attackTarget.v);
        final boolean canSee = this.entityHost.aA().a((lq)this.attackTarget);
        if (canSee) {
            ++this.ticksLookingAtTarget;
        }
        else {
            this.ticksLookingAtTarget = 0;
        }
        if (targetDistance <= maxRange && this.ticksLookingAtTarget >= 20) {
            this.entityHost.az().g();
        }
        else {
            this.entityHost.az().a(this.attackTarget, this.moveSpeed);
        }
        this.entityHost.aw().a((lq)this.attackTarget, 30.0f, 30.0f);
        this.rangedAttackTime = Math.max(this.rangedAttackTime - 1, 0);
        if (this.rangedAttackTime <= 0 && targetDistance <= maxRange && canSee) {
            this.doRangedAttack();
            this.rangedAttackTime = this.maxRangedAttackTime;
        }
    }
    
    protected void doRangedAttack() {
        rh projectile = null;
        if (this.rangedAttackID == 1) {
            projectile = new EntityTFNatureBolt(this.worldObj, this.entityHost);
            this.worldObj.a((lq)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aB().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 2) {
            projectile = new EntityTFTomeBolt(this.worldObj, this.entityHost);
            this.worldObj.a((lq)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aB().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 3) {
            projectile = new EntityTFLichBolt(this.worldObj, this.entityHost);
            this.worldObj.a((lq)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aB().nextFloat() * 0.4f + 0.8f));
        }
        else if (this.rangedAttackID == 4) {
            projectile = new EntityTFSlimeProjectile(this.worldObj, this.entityHost);
            this.worldObj.a((lq)this.entityHost, "mob.slime.small", 1.0f, 1.0f / (this.entityHost.aB().nextFloat() * 0.4f + 0.8f));
        }
        if (projectile != null) {
            final double tx = this.attackTarget.t - this.entityHost.t;
            final double ty = this.attackTarget.u + this.attackTarget.e() - 1.100000023841858 - projectile.u;
            final double tz = this.attackTarget.v - this.entityHost.v;
            final float heightOffset = ke.a(tx * tx + tz * tz) * 0.2f;
            projectile.c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.worldObj.d((lq)projectile);
        }
    }
}
