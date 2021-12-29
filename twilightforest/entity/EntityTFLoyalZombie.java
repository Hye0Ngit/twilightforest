// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFLoyalZombie extends op
{
    public EntityTFLoyalZombie(final abv par1World) {
        super(par1World);
        this.a(0.6f, 1.8f);
        this.k().a(true);
        this.c.a(1, (pr)new po((of)this));
        this.c.a(3, (pr)new pv((of)this, 0.4f));
        this.c.a(4, (pr)new pz((om)this, 1.0, true));
        this.c.a(5, (pr)new pp((op)this, 1.0, 10.0f, 2.0f));
        this.c.a(7, (pr)new ql((om)this, 1.0));
        this.c.a(9, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(9, (pr)new qk((of)this));
        this.d.a(1, (pr)new rb((op)this));
        this.d.a(2, (pr)new rc((op)this));
        this.d.a(3, (pr)new qw((om)this, true));
        this.d.a(4, (pr)new qx((om)this, (Class)tl.class, 0, true));
    }
    
    public ro createChild(final nj entityanimal) {
        return null;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(40.0);
        this.a(to.d).a(0.3);
    }
    
    public boolean m(final nm par1Entity) {
        final int attackpower = 7;
        final boolean success = par1Entity.a(na.a((oe)this), (float)attackpower);
        if (success) {
            par1Entity.y += 0.2000000059604645;
        }
        return success;
    }
    
    public void c() {
        if (!this.q.I && this.b(nh.g) == null) {
            this.d(100);
        }
        super.c();
    }
    
    protected boolean t() {
        return !this.bT();
    }
    
    public int aP() {
        return 3;
    }
    
    protected boolean be() {
        return true;
    }
    
    protected String r() {
        return "mob.zombie.say";
    }
    
    protected String aN() {
        return "mob.zombie.hurt";
    }
    
    protected String aO() {
        return "mob.zombie.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.q.a((nm)this, "mob.zombie.step", 0.15f, 1.0f);
    }
    
    protected int s() {
        return 0;
    }
    
    public oi aX() {
        return oi.b;
    }
}
