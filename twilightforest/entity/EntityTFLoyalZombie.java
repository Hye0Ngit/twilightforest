// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFLoyalZombie extends no
{
    public EntityTFLoyalZombie(final zv par1World) {
        super(par1World);
        this.aH = "/mob/zombie.png";
        this.bI = 0.3f;
        this.aC().a(true);
        this.bo.a(1, (og)new od((ng)this));
        this.bo.a(3, (og)new ok((ng)this, 0.4f));
        this.bo.a(4, (og)new oo((ng)this, this.bI, true));
        this.bo.a(5, (og)new oe((no)this, this.bI, 10.0f, 2.0f));
        this.bo.a(7, (og)new pa((nl)this, this.bI));
        this.bo.a(9, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(9, (og)new oz((ng)this));
        this.bp.a(1, (og)new po((no)this));
        this.bp.a(2, (og)new pp((no)this));
        this.bp.a(3, (og)new pk((ng)this, true));
        this.bp.a(4, (og)new pl((ng)this, (Class)rv.class, 16.0f, 0, true));
    }
    
    public qb createChild(final mm entityanimal) {
        return null;
    }
    
    public int aW() {
        return 40;
    }
    
    public boolean m(final mp par1Entity) {
        final int attackpower = 7;
        final boolean success = par1Entity.a(mg.a((ng)this), attackpower);
        if (success) {
            par1Entity.y += 0.2000000059604645;
        }
        return success;
    }
    
    public void c() {
        if (!this.q.I && this.b(mk.g) == null) {
            this.d(100);
        }
        super.c();
    }
    
    protected boolean bm() {
        return !this.m();
    }
    
    public int aZ() {
        return 3;
    }
    
    protected boolean bh() {
        return true;
    }
    
    protected String bb() {
        return "mob.zombie.say";
    }
    
    protected String bc() {
        return "mob.zombie.hurt";
    }
    
    protected String bd() {
        return "mob.zombie.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.q.a((mp)this, "mob.zombie.step", 0.15f, 1.0f);
    }
    
    protected int be() {
        return 0;
    }
    
    public ni bF() {
        return ni.b;
    }
}
