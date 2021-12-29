// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFRaven extends EntityTFBird
{
    EntityTFRavenLookHelper ravenLook;
    
    public EntityTFRaven(final yc par1World) {
        super(par1World);
        this.ravenLook = new EntityTFRavenLookHelper((md)this);
        this.aG = "/twilightforest/raven.png";
        this.a(0.3f, 0.7f);
        this.X = 1.0f;
        this.az().a(true);
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(1, (nc)new nt((mi)this, 0.38f));
        this.bn.a(2, (nc)new od((mi)this, 0.18f, up.S.cj, true));
        this.bn.a(5, (nc)new nw((mi)this, 0.25f));
        this.bn.a(6, (nc)new nh((md)this, (Class)qx.class, 6.0f));
        this.bn.a(7, (nc)new nv((md)this));
    }
    
    public int aT() {
        return 10;
    }
    
    protected void bl() {
        super.bl();
        this.ravenLook.a();
    }
    
    public mp aw() {
        return this.ravenLook;
    }
    
    protected String aY() {
        return "mob.tf.raven.caw";
    }
    
    protected String aZ() {
        return "mob.tf.raven.squawk";
    }
    
    protected String ba() {
        return "mob.tf.raven.squawk";
    }
    
    @Override
    protected int bb() {
        return TFItems.feather.cj;
    }
    
    public float bt() {
        return 0.3f;
    }
    
    protected boolean bj() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final agi underMaterial = this.p.g(par1, par2 - 1, par3);
        if (underMaterial == agi.j) {
            return 200.0f;
        }
        if (underMaterial == agi.d) {
            return 15.0f;
        }
        if (underMaterial == agi.b) {
            return 9.0f;
        }
        return this.p.p(par1, par2, par3) - 0.5f;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
