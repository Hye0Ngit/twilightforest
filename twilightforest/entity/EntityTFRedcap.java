// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFRedcapLightTNT;
import twilightforest.entity.ai.EntityAITFRedcapShy;

public class EntityTFRedcap extends tl
{
    public static yd heldPick;
    public static yd heldTNT;
    public static yd heldFlint;
    private boolean shy;
    private int tntLeft;
    
    public EntityTFRedcap(final abv world) {
        super(world);
        this.tntLeft = 0;
        this.a(0.9f, 1.4f);
        this.shy = true;
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new pf((om)this, (Class)tb.class, 2.0f, 1.0, 2.0));
        this.c.a(2, (pr)new EntityAITFRedcapShy(this, 1.0f));
        this.c.a(3, (pr)new EntityAITFRedcapLightTNT(this, 1.0f));
        this.c.a(5, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
        this.c(0, EntityTFRedcap.heldPick);
        this.c(1, new yd((yb)yb.ai));
        this.e[0] = 0.2f;
        this.e[1] = 0.2f;
    }
    
    public EntityTFRedcap(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(20.0);
        this.a(to.d).a(0.28);
    }
    
    protected String r() {
        return "TwilightForest:mob.redcap.redcap";
    }
    
    protected String aN() {
        return "TwilightForest:mob.redcap.hurt";
    }
    
    protected String aO() {
        return "TwilightForest:mob.redcap.die";
    }
    
    protected int s() {
        return yb.o.cv;
    }
    
    public boolean isShy() {
        return this.shy && this.aT <= 0;
    }
    
    public int getTntLeft() {
        return this.tntLeft;
    }
    
    public void setTntLeft(final int tntLeft) {
        this.tntLeft = tntLeft;
    }
    
    public yd getPick() {
        return EntityTFRedcap.heldPick;
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("TNTLeft", this.getTntLeft());
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setTntLeft(par1NBTTagCompound.e("TNTLeft"));
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
            final int chunkX = lr.c(this.u) >> 4;
            final int chunkZ = lr.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hill1) {
                ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    static {
        EntityTFRedcap.heldPick = new yd(yb.i, 1);
        EntityTFRedcap.heldTNT = new yd(aqw.ar, 1);
        EntityTFRedcap.heldFlint = new yd(yb.k, 1);
    }
}
