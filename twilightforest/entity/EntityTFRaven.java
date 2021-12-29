// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityTFRavenLookHelper;

public class EntityTFRaven extends EntityTFBird
{
    EntityTFRavenLookHelper ravenLook;
    
    public EntityTFRaven(final zv par1World) {
        super(par1World);
        this.ravenLook = new EntityTFRavenLookHelper((ng)this);
        this.aH = "/mods/twilightforest/textures/model/raven.png";
        this.a(0.3f, 0.7f);
        this.Y = 1.0f;
        this.aC().a(true);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new ox((nl)this, 0.38f));
        this.bo.a(2, (og)new ph((nl)this, 0.18f, we.T.cp, true));
        this.bo.a(5, (og)new pa((nl)this, 0.25f));
        this.bo.a(6, (og)new ol((ng)this, (Class)sk.class, 6.0f));
        this.bo.a(7, (og)new oz((ng)this));
    }
    
    public int aW() {
        return 10;
    }
    
    protected void bo() {
        super.bo();
        this.ravenLook.a();
    }
    
    public ns az() {
        return this.ravenLook;
    }
    
    protected String bb() {
        return "mob.tf.raven.caw";
    }
    
    protected String bc() {
        return "mob.tf.raven.squawk";
    }
    
    protected String bd() {
        return "mob.tf.raven.squawk";
    }
    
    @Override
    protected int be() {
        return TFItems.feather.cp;
    }
    
    public float bw() {
        return 0.3f;
    }
    
    protected boolean bm() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final ahz underMaterial = this.q.g(par1, par2 - 1, par3);
        if (underMaterial == ahz.j) {
            return 200.0f;
        }
        if (underMaterial == ahz.d) {
            return 15.0f;
        }
        if (underMaterial == ahz.b) {
            return 9.0f;
        }
        return this.q.q(par1, par2, par3) - 0.5f;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
