// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFRedcap extends yy
{
    private static final aan defaultHeldItem;
    protected boolean lefty;
    protected boolean redirect;
    protected boolean shy;
    
    public EntityTFRedcap(final xd world) {
        super(world);
        this.bm = "/twilightforest/redcap.png";
        this.cj = 0.5f;
        this.a(0.9f, 1.4f);
        this.c = 2;
        this.lefty = this.U.nextBoolean();
        this.shy = true;
    }
    
    public EntityTFRedcap(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public int d() {
        return 20;
    }
    
    public aan ae() {
        return EntityTFRedcap.defaultHeldItem;
    }
    
    protected String m() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String n() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String o() {
        return "mob.tf.redcap.die";
    }
    
    protected int f() {
        return yr.ag.bQ;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.U.nextInt(5) == 0) {
            this.b(TFItems.mazeMapFocus.bQ, 1 + i);
        }
        if (this.U.nextInt(6) == 0) {
            this.b(yr.ag.bQ, 1 + i);
        }
        if (this.U.nextInt(9) == 0) {
            this.b(yr.g.bQ, 1 + i);
        }
    }
    
    protected void y_() {
        super.y_();
        if (this.ao != null) {
            final float enemyDist = this.ao.e((nn)this);
            if (enemyDist < 4.0f || !this.shy) {
                this.cj = 0.8f;
            }
            else {
                this.cj = 0.5f;
            }
            if (enemyDist > 4.0f && enemyDist < 6.0f && this.shy && this.isTargetLookingAtMe()) {
                this.ce = (this.lefty ? this.cf : (-this.cf));
                this.cf = 0.0f;
            }
        }
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.o - this.ao.o;
        final double dz = this.q - this.ao.q;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = gk.e((this.ao.u - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
            final int chunkX = gk.c(this.o) >> 4;
            final int chunkZ = gk.c(this.q) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.k) == TFFeature.hill1) {
                ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    static {
        defaultHeldItem = new aan(yr.g, 1);
    }
}
