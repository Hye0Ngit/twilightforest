// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TFAchievementPage;

public class EntityTFBunny extends om implements nk
{
    public EntityTFBunny(final abv par1World) {
        super(par1World);
        this.a(0.3f, 0.7f);
        this.Y = 1.0f;
        this.k().a(true);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new qi((om)this, 2.0));
        this.c.a(2, (pr)new qt((om)this, 1.0, yb.U.cv, true));
        this.c.a(3, (pr)new pf((om)this, (Class)ue.class, 2.0f, 0.800000011920929, 1.3300000429153442));
        this.c.a(5, (pr)new ql((om)this, 0.800000011920929));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 6.0f));
        this.c.a(8, (pr)new qk((of)this));
        this.setBunnyType(this.ab.nextInt(4));
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(3.0);
        this.a(to.d).a(0.30000001192092896);
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
    }
    
    public boolean be() {
        return true;
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BunnyType", this.getBunnyType());
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBunnyType(par1NBTTagCompound.e("BunnyType"));
    }
    
    public int getBunnyType() {
        return this.ah.a(16);
    }
    
    public void setBunnyType(final int par1) {
        this.ah.b(16, (Object)(byte)par1);
    }
    
    public float bt() {
        return 0.3f;
    }
    
    protected boolean t() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final ajz underMaterial = this.q.g(par1, par2 - 1, par3);
        if (underMaterial == ajz.j) {
            return -1.0f;
        }
        if (underMaterial == ajz.d) {
            return -1.0f;
        }
        if (underMaterial == ajz.b) {
            return 10.0f;
        }
        return this.q.q(par1, par2, par3) - 0.5f;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
