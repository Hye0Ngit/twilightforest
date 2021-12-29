// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class EntityTFSlimeBeetle extends qj
{
    public EntityTFSlimeBeetle(final xv world) {
        super(world);
        this.aF = "/twilightforest/slimebeetle.png";
        this.bG = 0.23f;
        this.a(0.9f, 1.75f);
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(2, (nc)new mr((mi)this, (Class)qx.class, 2.0f, 0.23f, 0.4f));
        this.bm.a(3, (nc)new EntityAITFMagicAttack((md)this, this.bG, 4, 30));
        this.bm.a(6, (nc)new nw((mi)this, this.bG));
        this.bm.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bm.a(8, (nc)new nv((md)this));
        this.bn.a(1, (nc)new og((md)this, false));
        this.bn.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 25;
    }
    
    protected String aY() {
        return null;
    }
    
    protected String aZ() {
        return "mob.spider.say";
    }
    
    protected String ba() {
        return "mob.spider.death";
    }
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.p.a((lq)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    public void c() {
        super.c();
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int c(final lq par1Entity) {
        return 4;
    }
    
    @SideOnly(Side.CLIENT)
    public float R() {
        return 1.1f;
    }
    
    public float e() {
        return 0.25f;
    }
    
    public mf bC() {
        return mf.c;
    }
    
    protected int bb() {
        return uk.aM.cg;
    }
}
