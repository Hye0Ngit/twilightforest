// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFRedcap extends qj
{
    public static um heldPick;
    public static um heldTNT;
    public static um heldFlint;
    private boolean shy;
    private int tntLeft;
    
    public EntityTFRedcap(final xv world) {
        super(world);
        this.tntLeft = 0;
        this.aF = "/twilightforest/redcap.png";
        this.bG = 0.28f;
        this.a(0.9f, 1.4f);
        this.shy = true;
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(1, (nc)new mr((mi)this, (Class)pz.class, 2.0f, 0.28f, 0.5f));
        this.bm.a(2, (nc)new EntityAITFRedcapShy(this, this.bG));
        this.bm.a(3, (nc)new EntityAITFRedcapLightTNT(this, this.bG));
        this.bm.a(5, (nc)new nk((md)this, (Class)qx.class, this.bG, false));
        this.bm.a(6, (nc)new nw((mi)this, this.bG));
        this.bm.a(7, (nc)new nh((md)this, (Class)qx.class, 8.0f));
        this.bm.a(7, (nc)new nv((md)this));
        this.bn.a(1, (nc)new og((md)this, false));
        this.bn.a(2, (nc)new oh((md)this, (Class)qx.class, 16.0f, 0, true));
        this.b(0, EntityTFRedcap.heldPick);
        this.b(1, new um(uk.ag));
        this.bo[0] = 0.2f;
        this.bo[1] = 0.2f;
    }
    
    public EntityTFRedcap(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean be() {
        return true;
    }
    
    public int aT() {
        return 20;
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
        return uk.m.cg;
    }
    
    public boolean isShy() {
        return this.shy && this.bj <= 0;
    }
    
    public int getTntLeft() {
        return this.tntLeft;
    }
    
    public void setTntLeft(final int tntLeft) {
        this.tntLeft = tntLeft;
    }
    
    public um getPick() {
        return EntityTFRedcap.heldPick;
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("TNTLeft", this.getTntLeft());
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setTntLeft(par1NBTTagCompound.e("TNTLeft"));
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
    
    static {
        EntityTFRedcap.heldPick = new um(uk.g, 1);
        EntityTFRedcap.heldTNT = new um(amj.ap, 1);
        EntityTFRedcap.heldFlint = new um(uk.i, 1);
    }
}
