// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFMagicAttack;

public class EntityTFSlimeBeetle extends rv
{
    public EntityTFSlimeBeetle(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/slimebeetle.png";
        this.bI = 0.23f;
        this.a(0.9f, 1.75f);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(2, (og)new nu((nl)this, (Class)sk.class, 2.0f, 0.23f, 0.4f));
        this.bo.a(3, (og)new EntityAITFMagicAttack((ng)this, this.bI, 4, 30));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(8, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 25;
    }
    
    protected String bb() {
        return null;
    }
    
    protected String bc() {
        return "mob.spider.say";
    }
    
    protected String bd() {
        return "mob.spider.death";
    }
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.q.a((mp)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    public void c() {
        super.c();
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final mp par1Entity) {
        return 4;
    }
    
    @SideOnly(Side.CLIENT)
    public float Q() {
        return 1.1f;
    }
    
    public float e() {
        return 0.25f;
    }
    
    public ni bF() {
        return ni.c;
    }
    
    protected int be() {
        return we.aN.cp;
    }
}
