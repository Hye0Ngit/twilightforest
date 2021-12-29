// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFFlockToSameKind;
import twilightforest.entity.ai.EntityAITFPanicOnFlockDeath;

public class EntityTFKobold extends qj
{
    private boolean shy;
    
    public EntityTFKobold(final yc world) {
        super(world);
        this.aG = "/twilightforest/kobold.png";
        this.bH = 0.28f;
        this.a(0.8f, 1.1f);
        this.shy = true;
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(1, (nc)new EntityAITFPanicOnFlockDeath((mi)this, 0.38f));
        this.bn.a(2, (nc)new ng((md)this, 0.28f));
        this.bn.a(3, (nc)new nk((md)this, (Class)qx.class, this.bH, false));
        this.bn.a(4, (nc)new EntityAITFFlockToSameKind((md)this, this.bH));
        this.bn.a(6, (nc)new nw((mi)this, this.bH));
        this.bn.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bn.a(7, (nc)new nv((md)this));
        this.bo.a(1, (nc)new og((md)this, true));
        this.bo.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    public EntityTFKobold(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
        this.ag.a(17, (Object)0);
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 13;
    }
    
    protected String aY() {
        return "mob.tf.kobold.kobold";
    }
    
    protected String aZ() {
        return "mob.tf.kobold.hurt";
    }
    
    protected String ba() {
        return "mob.tf.kobold.die";
    }
    
    protected int bb() {
        return up.T.cj;
    }
    
    protected void a(final boolean flag, final int i) {
        super.a(flag, i);
        if (this.aa.nextInt(2) == 0) {
            this.b(up.bq.cj, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.bk <= 0;
    }
    
    public boolean isPanicked() {
        return this.ag.a(17) != 0;
    }
    
    public void setPanicked(final boolean flag) {
        if (flag) {
            this.ag.b(17, (Object)127);
        }
        else {
            this.ag.b(17, (Object)0);
        }
    }
    
    public void c() {
        super.c();
        if (this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.p.a("splash", this.t + (this.aa.nextDouble() - 0.5) * this.N * 0.5, this.u + this.e(), this.v + (this.aa.nextDouble() - 0.5) * this.N * 0.5, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int bv() {
        return 8;
    }
    
    public int c(final lq par1Entity) {
        return 3;
    }
}
