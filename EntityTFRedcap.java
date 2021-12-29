// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFRedcap extends ij
{
    private static final kp defaultHeldItem;
    protected boolean lefty;
    protected boolean redirect;
    protected boolean shy;
    
    public EntityTFRedcap(final ge world) {
        super(world);
        this.ae = "/twilightforest/redcap.png";
        this.bb = 0.5f;
        this.b(0.9f, 1.4f);
        this.c = 2;
        this.lefty = this.bS.nextBoolean();
        this.shy = true;
    }
    
    public EntityTFRedcap(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public int d() {
        return 20;
    }
    
    public kp getHeldItem() {
        return EntityTFRedcap.defaultHeldItem;
    }
    
    protected String i() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String j() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String k() {
        return "mob.tf.redcap.die";
    }
    
    protected int f() {
        return id.af.bP;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.bS.nextInt(5) == 0) {
            this.b(TFItems.mazeMapFocus.bP, 1 + i);
        }
        if (this.bS.nextInt(6) == 0) {
            this.b(id.af.bP, 1 + i);
        }
        if (this.bS.nextInt(9) == 0) {
            this.b(id.f.bP, 1 + i);
        }
    }
    
    protected void d_() {
        super.d_();
        if (this.d != null) {
            final float enemyDist = this.d.i((tv)this);
            if (enemyDist < 4.0f || !this.shy) {
                this.bb = 0.8f;
            }
            else {
                this.bb = 0.5f;
            }
            if (enemyDist > 4.0f && enemyDist < 6.0f && this.shy && this.isTargetLookingAtMe()) {
                this.aW = (this.lefty ? this.aX : (-this.aX));
                this.aX = 0.0f;
            }
        }
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.bm - this.d.bm;
        final double dz = this.bo - this.d.bo;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = kb.e((this.d.bs - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
            final int chunkX = kb.b(this.bm) >> 4;
            final int chunkZ = kb.b(this.bo) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.bi) == TFFeature.hill1) {
                ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    static {
        defaultHeldItem = new kp(id.f, 1);
    }
}
