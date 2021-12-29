// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.ai.EntityAITFFireBreath;

public class EntityTFFireBeetle extends tl
{
    public static final int BREATH_DURATION = 10;
    public static final int BREATH_DAMAGE = 2;
    
    public EntityTFFireBeetle(final abv world) {
        super(world);
        this.a(1.1f, 0.75f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(2, (pr)new EntityAITFFireBreath((of)this, 1.0f, 5.0f, 30, 0.1f));
        this.c.a(3, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    public EntityTFFireBeetle(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(25.0);
        this.a(to.d).a(0.23);
        this.a(to.e).a(4.0);
    }
    
    protected String r() {
        return null;
    }
    
    protected String aN() {
        return "mob.spider.say";
    }
    
    protected String aO() {
        return "mob.spider.death";
    }
    
    protected void a(final int var1, final int var2, final int var3, final int var4) {
        this.q.a((nm)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    protected int s() {
        return yb.O.cv;
    }
    
    public boolean isBreathing() {
        return this.ah.a(17) != 0;
    }
    
    public void setBreathing(final boolean flag) {
        if (flag) {
            this.ah.b(17, (Object)127);
        }
        else {
            this.ah.b(17, (Object)0);
        }
    }
    
    public void c() {
        super.c();
        if (this.isBreathing()) {
            final asz look = this.Z();
            final double dist = 0.9;
            final double px = this.u + look.c * dist;
            final double py = this.v + 0.25 + look.d * dist;
            final double pz = this.w + look.e * dist;
            for (int i = 0; i < 2; ++i) {
                double dx = look.c;
                double dy = look.d;
                double dz = look.e;
                final double spread = 5.0 + this.aC().nextDouble() * 2.5;
                final double velocity = 0.15 + this.aC().nextDouble() * 0.15;
                dx += this.aC().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.aC().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.aC().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.q.a(this.getFlameParticle(), px, py, pz, dx, dy, dz);
            }
            this.playBreathSound();
        }
    }
    
    public String getFlameParticle() {
        return "flame";
    }
    
    public void playBreathSound() {
        this.q.a(this.u + 0.5, this.v + 0.5, this.w + 0.5, "mob.ghast.fireball", this.ab.nextFloat() * 0.5f, this.ab.nextFloat() * 0.5f);
    }
    
    @SideOnly(Side.CLIENT)
    public int c(final float par1) {
        if (this.isBreathing()) {
            return 15728880;
        }
        return super.c(par1);
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public int bp() {
        return 500;
    }
    
    @SideOnly(Side.CLIENT)
    public float R() {
        return 1.1f;
    }
    
    public float f() {
        return 0.25f;
    }
    
    public oi aX() {
        return oi.c;
    }
    
    public void doBreathAttack(final nm target) {
        if (!target.E() && target.a(na.a, 2.0f)) {
            target.d(10);
        }
    }
}
