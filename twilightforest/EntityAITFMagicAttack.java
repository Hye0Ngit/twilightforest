// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityAITFMagicAttack extends rc
{
    xd worldObj;
    acq entityHost;
    acq attackTarget;
    int rangedAttackTime;
    float field_48370_e;
    int field_48367_f;
    int rangedAttackID;
    int maxRangedAttackTime;
    
    public EntityAITFMagicAttack(final acq par1EntityLiving, final float par2, final int par3, final int par4) {
        this.rangedAttackTime = 0;
        this.field_48367_f = 0;
        this.entityHost = par1EntityLiving;
        this.worldObj = par1EntityLiving.k;
        this.field_48370_e = par2;
        this.rangedAttackID = par3;
        this.maxRangedAttackTime = par4;
        this.a(3);
    }
    
    public boolean a() {
        final acq var1 = this.entityHost.aT();
        if (var1 == null) {
            return false;
        }
        this.attackTarget = var1;
        return true;
    }
    
    public boolean b() {
        return this.a() || !this.entityHost.aM().e();
    }
    
    public void d() {
        this.attackTarget = null;
    }
    
    public void e() {
        final double var1 = 100.0;
        final double var2 = this.entityHost.f(this.attackTarget.o, this.attackTarget.y.b, this.attackTarget.q);
        final boolean var3 = this.entityHost.aN().a((nn)this.attackTarget);
        if (var3) {
            ++this.field_48367_f;
        }
        else {
            this.field_48367_f = 0;
        }
        if (var2 <= var1 && this.field_48367_f >= 20) {
            this.entityHost.aM().f();
        }
        else {
            this.entityHost.aM().a(this.attackTarget, this.field_48370_e);
        }
        this.entityHost.aJ().a((nn)this.attackTarget, 30.0f, 30.0f);
        this.rangedAttackTime = Math.max(this.rangedAttackTime - 1, 0);
        if (this.rangedAttackTime <= 0 && var2 <= var1 && var3) {
            this.doRangedAttack();
            this.rangedAttackTime = this.maxRangedAttackTime;
        }
    }
    
    protected void doRangedAttack() {
        if (this.rangedAttackID == 1) {
            final av projectile = new EntityTFNatureBolt(this.worldObj, this.entityHost);
            final double tx = this.attackTarget.o - this.entityHost.o;
            final double ty = this.attackTarget.p + this.attackTarget.I() - 1.100000023841858 - projectile.p;
            final double tz = this.attackTarget.q - this.entityHost.q;
            final float heightOffset = gk.a(tx * tx + tz * tz) * 0.2f;
            projectile.a(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.worldObj.a((nn)this.entityHost, "mob.ghast.fireball", 1.0f, 1.0f / (this.entityHost.aO().nextFloat() * 0.4f + 0.8f));
            this.worldObj.a((nn)projectile);
        }
    }
}
