// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFRedcapLightTNT;
import twilightforest.entity.ai.EntityAITFRedcapShy;

public class EntityTFRedcap extends rv
{
    public static wg heldPick;
    public static wg heldTNT;
    public static wg heldFlint;
    private boolean shy;
    private int tntLeft;
    
    public EntityTFRedcap(final zv world) {
        super(world);
        this.tntLeft = 0;
        this.aH = "/mods/twilightforest/textures/model/redcap.png";
        this.bI = 0.28f;
        this.a(0.9f, 1.4f);
        this.shy = true;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new nu((nl)this, (Class)rl.class, 2.0f, 0.28f, 0.5f));
        this.bo.a(2, (og)new EntityAITFRedcapShy(this, this.bI));
        this.bo.a(3, (og)new EntityAITFRedcapLightTNT(this, this.bI));
        this.bo.a(5, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(7, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
        this.c(0, EntityTFRedcap.heldPick);
        this.c(1, new wg((we)we.ah));
        this.bq[0] = 0.2f;
        this.bq[1] = 0.2f;
    }
    
    public EntityTFRedcap(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 20;
    }
    
    protected String bb() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String bc() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String bd() {
        return "mob.tf.redcap.die";
    }
    
    protected int be() {
        return we.n.cp;
    }
    
    public boolean isShy() {
        return this.shy && this.bl <= 0;
    }
    
    public int getTntLeft() {
        return this.tntLeft;
    }
    
    public void setTntLeft(final int tntLeft) {
        this.tntLeft = tntLeft;
    }
    
    public wg getPick() {
        return EntityTFRedcap.heldPick;
    }
    
    public void b(final bs par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("TNTLeft", this.getTntLeft());
    }
    
    public void a(final bs par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setTntLeft(par1NBTTagCompound.e("TNTLeft"));
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
            final int chunkX = kx.c(this.u) >> 4;
            final int chunkZ = kx.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hill1) {
                ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    static {
        EntityTFRedcap.heldPick = new wg(we.h, 1);
        EntityTFRedcap.heldTNT = new wg(aou.aq, 1);
        EntityTFRedcap.heldFlint = new wg(we.j, 1);
    }
}
