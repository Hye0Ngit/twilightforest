// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFRedcap extends hm
{
    private static final jm defaultHeldItem;
    protected boolean lefty;
    protected boolean redirect;
    protected boolean shy;
    
    public EntityTFRedcap(final fq world) {
        super(world);
        this.ae = "/twilightforest/redcap.png";
        this.bb = 0.5f;
        this.b(0.9f, 1.4f);
        this.c = 2;
        this.lefty = this.bS.nextBoolean();
        this.shy = true;
    }
    
    public int c() {
        return 20;
    }
    
    public jm getHeldItem() {
        return EntityTFRedcap.defaultHeldItem;
    }
    
    protected String c_() {
        return "mob.zombie";
    }
    
    protected String m() {
        return "mob.zombiehurt";
    }
    
    protected String n() {
        return "mob.zombiedeath";
    }
    
    protected int e() {
        return hg.af.bN;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.bS.nextInt(6) == 0) {
            this.b(hg.af.bN, 1 + i);
        }
        if (this.bS.nextInt(9) == 0) {
            this.b(hg.f.bN, 1 + i);
        }
    }
    
    protected void m_() {
        super.m_();
        if (this.d != null) {
            final float enemyDist = this.d.h((se)this);
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
        final float difference = iy.e((this.d.bs - angle) % 360.0f);
        System.out.println("Difference in angle of approach is " + difference);
        return difference < 60.0f || difference > 300.0f;
    }
    
    static {
        defaultHeldItem = new jm(hg.f, 1);
    }
}
