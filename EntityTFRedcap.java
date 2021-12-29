// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFRedcap extends zo
{
    private static final dk defaultHeldItem;
    protected boolean lefty;
    protected boolean redirect;
    protected boolean shy;
    
    public EntityTFRedcap(final ry world) {
        super(world);
        this.aA = "/twilightforest/redcap.png";
        this.bw = 0.5f;
        this.a(0.9f, 1.4f);
        this.a = 2;
        this.lefty = this.Y.nextBoolean();
        this.shy = true;
    }
    
    public int f_() {
        return 20;
    }
    
    public dk s() {
        return EntityTFRedcap.defaultHeldItem;
    }
    
    protected String e() {
        return "mob.zombie";
    }
    
    protected String f() {
        return "mob.zombiehurt";
    }
    
    protected String g() {
        return "mob.zombiedeath";
    }
    
    protected int k() {
        return acy.af.bM;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.Y.nextInt(6) == 0) {
            this.b(acy.af.bM, 1 + i);
        }
        if (this.Y.nextInt(9) == 0) {
            this.b(acy.f.bM, 1 + i);
        }
    }
    
    protected void n() {
        super.n();
        if (this.h != null) {
            final float enemyDist = this.h.c((ia)this);
            if (enemyDist < 4.0f || !this.shy) {
                this.bw = 0.8f;
            }
            else {
                this.bw = 0.5f;
            }
            if (enemyDist > 4.0f && enemyDist < 6.0f && this.shy && this.isTargetLookingAtMe()) {
                this.br = (this.lefty ? this.bs : (-this.bs));
                this.bs = 0.0f;
            }
        }
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.s - this.h.s;
        final double dz = this.u - this.h.u;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = me.e((this.h.y - angle) % 360.0f);
        System.out.println("Difference in angle of approach is " + difference);
        return difference < 60.0f || difference > 300.0f;
    }
    
    static {
        defaultHeldItem = new dk(acy.f, 1);
    }
}
