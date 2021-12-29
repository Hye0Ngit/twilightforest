// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFPenguin extends zg
{
    public EntityTFPenguin(final ge world) {
        super(world);
        this.ae = "/twilightforest/penguin.png";
        (this.aL = new tf()).a(0, (zc)new wj((ne)this));
        this.aL.a(1, (zc)new pb((ka)this, 0.38f));
        this.aL.a(2, (zc)new aak((br)this, 0.25f));
        this.aL.a(3, (zc)new zk((ka)this, 0.25f, id.aT.bP, false));
        this.aL.a(4, (zc)new gx((br)this, 0.28f));
        this.aL.a(5, (zc)new nk((ka)this, 0.25f));
        this.aL.a(6, (zc)new ul((ne)this, (Class)ih.class, 6.0f));
        this.aL.a(7, (zc)new dm((ne)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.aL.a(8, (zc)new bs((ne)this));
    }
    
    public EntityTFPenguin(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    protected String i() {
        return null;
    }
    
    public br a(final br par1EntityAnimal) {
        return (br)new EntityTFPenguin(this.bi);
    }
    
    public boolean a(final kp par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.c == id.aT.bP;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
