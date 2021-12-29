// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.ai.EntityAITFFireBreath;

public class EntityTFFireBeetle extends qj
{
    public static final int BREATH_DURATION = 10;
    public static final int BREATH_DAMAGE = 2;
    
    public EntityTFFireBeetle(final yc world) {
        super(world);
        this.aG = "/twilightforest/firebeetle.png";
        this.bH = 0.23f;
        this.a(1.1f, 0.75f);
        this.bn.a(0, (nc)new mz((md)this));
        this.bn.a(2, (nc)new EntityAITFFireBreath((md)this, this.bH, 5.0f, 30, 0.1f));
        this.bn.a(3, (nc)new nk((md)this, (Class)qx.class, this.bH, false));
        this.bn.a(6, (nc)new nw((mi)this, this.bH));
        this.bo.a(1, (nc)new og((md)this, false));
        this.bo.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
    }
    
    public EntityTFFireBeetle(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
        this.ag.a(17, (Object)0);
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
    
    protected int bb() {
        return up.M.cj;
    }
    
    public boolean isBreathing() {
        return this.ag.a(17) != 0;
    }
    
    public void setBreathing(final boolean flag) {
        if (flag) {
            this.ag.b(17, (Object)127);
        }
        else {
            this.ag.b(17, (Object)0);
        }
    }
    
    public void c() {
        super.c();
        if (this.isBreathing()) {
            final aoj look = this.Z();
            final double dist = 0.9;
            final double px = this.t + look.c * dist;
            final double py = this.u + 0.25 + look.d * dist;
            final double pz = this.v + look.e * dist;
            for (int i = 0; i < 2; ++i) {
                double dx = look.c;
                double dy = look.d;
                double dz = look.e;
                final double spread = 5.0 + this.aB().nextDouble() * 2.5;
                final double velocity = 0.15 + this.aB().nextDouble() * 0.15;
                dx += this.aB().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.aB().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.aB().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.p.a(this.getFlameParticle(), px, py, pz, dx, dy, dz);
            }
            this.playBreathSound();
        }
    }
    
    public String getFlameParticle() {
        return "flame";
    }
    
    public void playBreathSound() {
        this.p.a(this.t + 0.5, this.u + 0.5, this.v + 0.5, "mob.ghast.fireball", this.aa.nextFloat() * 0.5f, this.aa.nextFloat() * 0.5f);
    }
    
    @SideOnly(Side.CLIENT)
    public int b(final float par1) {
        if (this.isBreathing()) {
            return 15728880;
        }
        return super.b(par1);
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
    
    public int bp() {
        return 500;
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
    
    public void doBreathAttack(final lq target) {
        if (!target.F() && target.a(lh.a, 2)) {
            target.c(10);
        }
    }
}
