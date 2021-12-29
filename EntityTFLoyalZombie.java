// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFLoyalZombie extends et
{
    public EntityTFLoyalZombie(final ge par1World) {
        super(par1World);
        this.ae = "/mob/zombie.png";
        this.bb = 0.3f;
        this.al().a(true);
        this.aL.a(1, (zc)new wj((ne)this));
        this.aL.a(3, (zc)new cz((ne)this, 0.4f));
        this.aL.a(4, (zc)new bl((ne)this, this.bb, true));
        this.aL.a(5, (zc)new tk((et)this, this.bb, 10.0f, 2.0f));
        this.aL.a(7, (zc)new nk((ka)this, this.bb));
        this.aL.a(9, (zc)new ul((ne)this, (Class)ih.class, 8.0f));
        this.aL.a(9, (zc)new bs((ne)this));
        this.aM.a(1, (zc)new gs((et)this));
        this.aM.a(2, (zc)new hk((et)this));
        this.aM.a(3, (zc)new jx((ne)this, true));
        this.aM.a(4, (zc)new aba((ne)this, (Class)ij.class, 16.0f, 0, true));
    }
    
    public br a(final br var1) {
        return null;
    }
    
    public int d() {
        return 40;
    }
    
    public boolean a(final tv par1Entity) {
        final int attackpower = 7;
        final boolean success = par1Entity.a(rq.a((ne)this), attackpower);
        if (success) {
            par1Entity.bq += 0.2000000059604645;
        }
        return success;
    }
    
    public void e() {
        if (!this.bi.F && this.b(kf.g) == null) {
            this.i(100);
        }
        super.e();
    }
    
    protected boolean n() {
        return !this.u_();
    }
    
    public int T() {
        return 3;
    }
    
    protected boolean c_() {
        return true;
    }
    
    protected String i() {
        return "mob.zombie";
    }
    
    protected String j() {
        return "mob.zombiehurt";
    }
    
    protected String k() {
        return "mob.zombiedeath";
    }
    
    protected int f() {
        return 0;
    }
    
    public cc v() {
        return cc.b;
    }
}
