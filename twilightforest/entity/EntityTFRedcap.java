// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFRedcapLightTNT;
import twilightforest.entity.ai.EntityAITFRedcapShy;

public class EntityTFRedcap extends qj
{
    public static ur heldPick;
    public static ur heldTNT;
    public static ur heldFlint;
    private boolean shy;
    private int tntLeft;
    
    public EntityTFRedcap(final yc world) {
        super(world);
        this.tntLeft = 0;
        this.aG = "/twilightforest/redcap.png";
        this.bH = 0.28f;
        this.a(0.9f, 1.4f);
        this.shy = true;
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(1, (nc)new mr((mi)this, (Class)pz.class, 2.0f, 0.28f, 0.5f));
        this.bn.a(2, (nc)new EntityAITFRedcapShy(this, this.bH));
        this.bn.a(3, (nc)new EntityAITFRedcapLightTNT(this, this.bH));
        this.bn.a(5, (nc)new nk((md)this, (Class)qx.class, this.bH, false));
        this.bn.a(6, (nc)new nw((mi)this, this.bH));
        this.bn.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bn.a(7, (nc)new nv((md)this));
        this.bo.a(1, (nc)new og((md)this, false));
        this.bo.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
        this.b(0, EntityTFRedcap.heldPick);
        this.b(1, new ur(up.ag));
        this.bp[0] = 0.2f;
        this.bp[1] = 0.2f;
    }
    
    public EntityTFRedcap(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 20;
    }
    
    protected String aY() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String aZ() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String ba() {
        return "mob.tf.redcap.die";
    }
    
    protected int bb() {
        return up.m.cj;
    }
    
    public boolean isShy() {
        return this.shy && this.bk <= 0;
    }
    
    public int getTntLeft() {
        return this.tntLeft;
    }
    
    public void setTntLeft(final int tntLeft) {
        this.tntLeft = tntLeft;
    }
    
    public ur getPick() {
        return EntityTFRedcap.heldPick;
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("TNTLeft", this.getTntLeft());
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setTntLeft(par1NBTTagCompound.e("TNTLeft"));
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
            final int chunkX = ke.c(this.t) >> 4;
            final int chunkZ = ke.c(this.v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.p) == TFFeature.hill1) {
                ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    static {
        EntityTFRedcap.heldPick = new ur(up.g, 1);
        EntityTFRedcap.heldTNT = new ur(amq.ap, 1);
        EntityTFRedcap.heldFlint = new ur(up.i, 1);
    }
}
