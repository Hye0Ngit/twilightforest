// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.block.TFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTFTowerGolem extends tl
{
    private int attackTimer;
    
    public EntityTFTowerGolem(final abv par1World) {
        super(par1World);
        this.a(1.4f, 2.9f);
        this.k().a(true);
        this.c.a(1, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(2, (pr)new ql((om)this, 1.0));
        this.c.a(3, (pr)new pw((of)this, (Class)ue.class, 6.0f));
        this.c.a(3, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(40.0);
        this.a(to.d).a(0.25);
        this.a(to.e).a(9.0);
    }
    
    public int aP() {
        int var1 = super.aP() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    public boolean m(final nm par1Entity) {
        this.attackTimer = 10;
        this.q.a((nm)this, (byte)4);
        final boolean attackSuccess = super.m(par1Entity);
        if (attackSuccess) {
            par1Entity.y += 0.4000000059604645;
        }
        this.a("mob.irongolem.throw", 1.0f, 1.0f);
        return attackSuccess;
    }
    
    protected String r() {
        return "none";
    }
    
    protected String aN() {
        return "mob.irongolem.hit";
    }
    
    protected String aO() {
        return "mob.irongolem.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.irongolem.walk", 1.0f, 1.0f);
    }
    
    protected void n(final nm par1Entity) {
        if (par1Entity instanceof tg && this.aC().nextInt(10) == 0) {
            this.d((oe)par1Entity);
        }
        super.n(par1Entity);
    }
    
    public void c() {
        super.c();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.x * this.x + this.z * this.z > 2.500000277905201E-7 && this.ab.nextInt(5) == 0) {
            final int var1 = lr.c(this.u);
            final int var2 = lr.c(this.v - 0.20000000298023224 - this.N);
            final int var3 = lr.c(this.w);
            final int var4 = this.q.a(var1, var2, var3);
            if (var4 > 0) {
                this.q.a("tilecrack_" + var4 + "_" + this.q.h(var1, var2, var3), this.u + (this.ab.nextFloat() - 0.5) * this.O, this.E.b + 0.1, this.w + (this.ab.nextFloat() - 0.5) * this.O, 4.0 * (this.ab.nextFloat() - 0.5), 0.5, (this.ab.nextFloat() - 0.5) * 4.0);
            }
        }
        if (this.ab.nextBoolean()) {
            this.q.a("reddust", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * this.P - 0.25, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.0, 0.0);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final byte par1) {
        if (par1 == 4) {
            this.attackTimer = 10;
            this.a("mob.irongolem.throw", 1.0f, 1.0f);
        }
        else {
            super.a(par1);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    protected void b(final boolean par1, final int par2) {
        for (int var4 = this.ab.nextInt(3), i = 0; i < var4; ++i) {
            this.b(yb.q.cv, 1);
        }
        for (int var4 = this.ab.nextInt(3), i = 0; i < var4; ++i) {
            this.b(TFBlocks.towerWood.cF, 1);
        }
    }
    
    public int bv() {
        return 16;
    }
}
