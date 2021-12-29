// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFRedcap extends yt
{
    private static final aai defaultHeldItem;
    protected boolean lefty;
    protected boolean redirect;
    protected boolean shy;
    
    public EntityTFRedcap(final wz world) {
        super(world);
        this.bm = "/twilightforest/redcap.png";
        this.cj = 0.5f;
        this.a(0.9f, 1.4f);
        this.c = 2;
        this.lefty = this.U.nextBoolean();
        this.shy = true;
    }
    
    public int d() {
        return 20;
    }
    
    public aai ae() {
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
    
    protected int f() {
        return ym.ag.bQ;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.U.nextInt(6) == 0) {
            this.b(ym.ag.bQ, 1 + i);
        }
        if (this.U.nextInt(9) == 0) {
            this.b(ym.g.bQ, 1 + i);
        }
    }
    
    protected void x_() {
        super.x_();
        if (this.ao != null) {
            final float enemyDist = this.ao.e((nk)this);
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
        final float difference = gh.e((this.ao.u - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    static {
        defaultHeldItem = new aai(ym.g, 1);
    }
}
