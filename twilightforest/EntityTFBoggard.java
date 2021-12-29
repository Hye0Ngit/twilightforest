// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFBoggard extends qj
{
    private boolean shy;
    
    public EntityTFBoggard(final xv world) {
        super(world);
        this.aF = "/mob/pigzombie.png";
        this.bG = 0.28f;
        this.a(0.8f, 1.1f);
        this.shy = true;
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(2, (nc)new EntityAITFChargeAttack((md)this, 0.55f));
        this.bm.a(3, (nc)new nk((md)this, (Class)qx.class, this.bG, false));
        this.bm.a(6, (nc)new nw((mi)this, this.bG));
        this.bm.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bm.a(7, (nc)new nv((md)this));
        this.bn.a(1, (nc)new og((md)this, false));
        this.bn.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, false));
    }
    
    public EntityTFBoggard(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 14;
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
        return uk.ag.cg;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.aa.nextInt(5) == 0) {
            this.b(TFItems.mazeMapFocus.cg, 1 + i);
        }
        if (this.aa.nextInt(6) == 0) {
            this.b(uk.ag.cg, 1 + i);
        }
        if (this.aa.nextInt(9) == 0) {
            this.b(uk.g.cg, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.bj <= 0;
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.t - this.a_.t;
        final double dz = this.v - this.a_.v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = ke.e((this.a_.z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
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
    
    public void e(final float par1, final float par2) {
        super.e(par1, par2);
        System.out.println("prevLegYaw = " + this.bf);
        System.out.println("legYaw = " + this.bg);
    }
}
