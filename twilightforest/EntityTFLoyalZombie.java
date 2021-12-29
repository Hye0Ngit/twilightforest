// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFLoyalZombie extends wd
{
    public EntityTFLoyalZombie(final xd par1World) {
        super(par1World);
        this.bm = "/mob/zombie.png";
        this.cj = 0.3f;
        this.aM().a(true);
        this.bT.a(1, (rc)new aje((acq)this));
        this.bT.a(3, (rc)new bu((acq)this, 0.4f));
        this.bT.a(4, (rc)new ax((acq)this, this.cj, true));
        this.bT.a(5, (rc)new ni((wd)this, this.cj, 10.0f, 2.0f));
        this.bT.a(7, (rc)new acu((aaa)this, this.cj));
        this.bT.a(9, (rc)new ob((acq)this, (Class)yw.class, 8.0f));
        this.bT.a(9, (rc)new bd((acq)this));
        this.bU.a(1, (rc)new xk((wd)this));
        this.bU.a(2, (rc)new ya((wd)this));
        this.bU.a(3, (rc)new zy((acq)this, true));
        this.bU.a(4, (rc)new amf((acq)this, (Class)yy.class, 16.0f, 0, true));
    }
    
    public bc a(final bc var1) {
        return null;
    }
    
    public int d() {
        return 40;
    }
    
    public boolean c(final nn par1Entity) {
        final int attackpower = 7;
        final boolean success = par1Entity.a(md.a((acq)this), attackpower);
        if (success) {
            par1Entity.s += 0.2000000059604645;
        }
        return success;
    }
    
    public void e() {
        if (!this.k.F && this.b(aad.g) == null) {
            this.e(100);
        }
        super.e();
    }
    
    protected boolean c_() {
        return !this.G_();
    }
    
    public int au() {
        return 3;
    }
    
    protected boolean b_() {
        return true;
    }
    
    protected String m() {
        return "mob.zombie";
    }
    
    protected String n() {
        return "mob.zombiehurt";
    }
    
    protected String o() {
        return "mob.zombiedeath";
    }
    
    protected int f() {
        return 0;
    }
    
    public bk s() {
        return bk.b;
    }
}
