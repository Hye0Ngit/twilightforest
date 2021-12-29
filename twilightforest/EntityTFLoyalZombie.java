// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFLoyalZombie extends ml
{
    public EntityTFLoyalZombie(final xv par1World) {
        super(par1World);
        this.aF = "/mob/zombie.png";
        this.bG = 0.3f;
        this.az().a(true);
        this.bm.a(1, (nc)new mz((md)this));
        this.bm.a(3, (nc)new ng((md)this, 0.4f));
        this.bm.a(4, (nc)new nk((md)this, this.bG, true));
        this.bm.a(5, (nc)new na((ml)this, this.bG, 10.0f, 2.0f));
        this.bm.a(7, (nc)new nw((mi)this, this.bG));
        this.bm.a(9, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bm.a(9, (nc)new nv((md)this));
        this.bn.a(1, (nc)new ok((ml)this));
        this.bn.a(2, (nc)new ol((ml)this));
        this.bn.a(3, (nc)new og((md)this, true));
        this.bn.a(4, (nc)new oh((md)this, (Class)qj.class, 16.0f, 0, true));
    }
    
    public ox func_90011_a(final ln entityanimal) {
        return null;
    }
    
    public int aT() {
        return 40;
    }
    
    public boolean m(final lq par1Entity) {
        final int attackpower = 7;
        final boolean success = par1Entity.a(lh.a((md)this), attackpower);
        if (success) {
            par1Entity.x += 0.2000000059604645;
        }
        return success;
    }
    
    public void c() {
        if (!this.p.J && this.b(ll.g) == null) {
            this.c(100);
        }
        super.c();
    }
    
    protected boolean bj() {
        return !this.m();
    }
    
    public int aW() {
        return 3;
    }
    
    protected boolean be() {
        return true;
    }
    
    protected String aY() {
        return "mob.zombie.say";
    }
    
    protected String aZ() {
        return "mob.zombie.hurt";
    }
    
    protected String ba() {
        return "mob.zombie.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.p.a((lq)this, "mob.zombie.step", 0.15f, 1.0f);
    }
    
    protected int bb() {
        return 0;
    }
    
    public mf bC() {
        return mf.b;
    }
}
