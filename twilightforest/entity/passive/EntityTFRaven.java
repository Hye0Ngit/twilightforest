// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityTFRavenLookHelper;

public class EntityTFRaven extends EntityTFTinyBird
{
    EntityTFRavenLookHelper ravenLook;
    
    public EntityTFRaven(final abv par1World) {
        super(par1World);
        this.ravenLook = new EntityTFRavenLookHelper((of)this);
        this.a(0.3f, 0.7f);
        this.Y = 1.0f;
        this.k().a(true);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new qi((om)this, 1.5));
        this.c.a(2, (pr)new qt((om)this, 0.8500000238418579, yb.U.cv, true));
        this.c.a(5, (pr)new ql((om)this, 1.0));
        this.c.a(6, (pr)new pw((of)this, (Class)ue.class, 6.0f));
        this.c.a(7, (pr)new qk((of)this));
    }
    
    @Override
    protected void ay() {
        super.ay();
        this.a(to.a).a(10.0);
        this.a(to.d).a(0.20000001192092895);
    }
    
    @Override
    protected void bh() {
        super.bh();
        this.ravenLook.a();
    }
    
    public pd h() {
        return this.ravenLook;
    }
    
    @Override
    protected String r() {
        return "TwilightForest:mob.raven.caw";
    }
    
    @Override
    protected String aN() {
        return "TwilightForest:mob.raven.squawk";
    }
    
    @Override
    protected String aO() {
        return "TwilightForest:mob.raven.squawk";
    }
    
    @Override
    protected int s() {
        return TFItems.feather.cv;
    }
    
    @Override
    public float bt() {
        return 0.3f;
    }
    
    @Override
    public boolean isSpooked() {
        return this.ay > 0;
    }
}
