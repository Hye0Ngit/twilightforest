// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFChargeAttack;

public class EntityTFMinotaur extends rv
{
    public EntityTFMinotaur(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/minotaur.png";
        this.bI = 0.25f;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(2, (og)new EntityAITFChargeAttack((ng)this, 0.55f));
        this.bo.a(3, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(7, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, false));
        this.c(0, new wg(we.K));
    }
    
    public int aW() {
        return 30;
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
    }
    
    protected boolean bh() {
        return true;
    }
    
    public boolean isCharging() {
        return this.ah.a(17) != 0;
    }
    
    public void setCharging(final boolean flag) {
        if (flag) {
            this.ah.b(17, (Object)127);
        }
        else {
            this.ah.b(17, (Object)0);
        }
    }
    
    public boolean m(final mp par1Entity) {
        final boolean success = super.m(par1Entity);
        if (success && this.isCharging()) {
            par1Entity.y += 0.4000000059604645;
            this.q.a((mp)this, "mob.irongolem.throw", 1.0f, 1.0f);
        }
        return success;
    }
    
    public void c() {
        super.c();
        if (this.isCharging()) {
            this.bi += (float)0.6;
        }
    }
    
    protected String bb() {
        return "mob.cow.say";
    }
    
    protected String bc() {
        return "mob.cow.hurt";
    }
    
    protected String bd() {
        return "mob.cow.hurt";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.q.a((mp)this, "mob.cow.step", 0.15f, 1.0f);
    }
    
    protected int be() {
        return TFItems.meefRaw.cp;
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int numDrops = this.ab.nextInt(2) + this.ab.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            if (this.ae()) {
                this.b(TFItems.meefSteak.cp, 1);
            }
            else {
                this.b(TFItems.meefRaw.cp, 1);
            }
        }
    }
    
    protected void l(final int par1) {
        this.b(TFItems.mazeMapFocus.cp, 1);
    }
    
    public void bJ() {
        this.bI();
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final mp par1Entity) {
        return 7;
    }
}
