// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.ai.EntityAITFFireBreath;

public class EntityTFFireBeetle extends rv
{
    public static final int BREATH_DURATION = 10;
    public static final int BREATH_DAMAGE = 2;
    
    public EntityTFFireBeetle(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/firebeetle.png";
        this.bI = 0.23f;
        this.a(1.1f, 0.75f);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(2, (og)new EntityAITFFireBreath((ng)this, this.bI, 5.0f, 30, 0.1f));
        this.bo.a(3, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    public EntityTFFireBeetle(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
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
    
    protected int be() {
        return we.N.cp;
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
            final aqw look = this.Y();
            final double dist = 0.9;
            final double px = this.u + look.c * dist;
            final double py = this.v + 0.25 + look.d * dist;
            final double pz = this.w + look.e * dist;
            for (int i = 0; i < 2; ++i) {
                double dx = look.c;
                double dy = look.d;
                double dz = look.e;
                final double spread = 5.0 + this.aE().nextDouble() * 2.5;
                final double velocity = 0.15 + this.aE().nextDouble() * 0.15;
                dx += this.aE().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.aE().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.aE().nextGaussian() * 0.007499999832361937 * spread;
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
    public int b(final float par1) {
        if (this.isBreathing()) {
            return 15728880;
        }
        return super.b(par1);
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int bs() {
        return 500;
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
    
    public void doBreathAttack(final mp target) {
        if (!target.E() && target.a(mg.a, 2)) {
            target.d(10);
        }
    }
}
