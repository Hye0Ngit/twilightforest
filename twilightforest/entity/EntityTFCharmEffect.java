// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;

public class EntityTFCharmEffect extends lq
{
    private static final int DATA_OWNER = 17;
    private static final int DATA_ITEMID = 16;
    private static final double DISTANCE = 1.75;
    private md orbiting;
    private double newPosX;
    private double newPosY;
    private double newPosZ;
    private double newRotationYaw;
    private double newRotationPitch;
    private int newPosRotationIncrements;
    public float offset;
    
    public EntityTFCharmEffect(final yc par1World) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.setItemID(TFItems.charmOfLife1.cj);
    }
    
    public EntityTFCharmEffect(final yc par1World, final md par2EntityLiving, final int itemID) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.orbiting = par2EntityLiving;
        this.setOwner(this.orbiting.an());
        this.setItemID(itemID);
        final aoj look = this.p.S().a(1.75, 0.0, 0.0);
        this.b(par2EntityLiving.t, par2EntityLiving.u + par2EntityLiving.e(), par2EntityLiving.v, par2EntityLiving.z, par2EntityLiving.A);
        this.t += look.c * 1.75;
        this.v += look.e * 1.75;
        this.b(this.t, this.u, this.v);
        this.M = 0.0f;
    }
    
    public void j_() {
        this.T = this.t;
        this.U = this.u;
        this.V = this.v;
        super.j_();
        if (this.newPosRotationIncrements > 0) {
            final double var1 = this.t + (this.newPosX - this.t) / this.newPosRotationIncrements;
            final double var2 = this.u + (this.newPosY - this.u) / this.newPosRotationIncrements;
            final double var3 = this.v + (this.newPosZ - this.v) / this.newPosRotationIncrements;
            final double var4 = ke.g(this.newRotationYaw - this.z);
            this.z += (float)(var4 / this.newPosRotationIncrements);
            this.A += (float)((this.newRotationPitch - this.A) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.b(var1, var2, var3);
            this.b(this.z, this.A);
        }
        final float rotation = this.ab / 5.0f + this.offset;
        if (this.orbiting == null) {
            this.orbiting = this.getOwner();
        }
        if (this.orbiting != null && !this.p.I) {
            this.b(this.orbiting.t, this.orbiting.u + this.orbiting.e(), this.orbiting.v, this.orbiting.z, this.orbiting.A);
            final aoj look = this.p.S().a(1.75, 0.0, 0.0);
            look.b(rotation);
            this.t += look.c;
            this.v += look.e;
            this.b(this.t, this.u, this.v);
        }
        if (this.getItemID() > 0) {
            for (int i = 0; i < 3; ++i) {
                final double dx = this.t + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
                final double dy = this.u + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
                final double dz = this.v + 0.5 * (this.aa.nextDouble() - this.aa.nextDouble());
                this.p.a("iconcrack_" + this.getItemID(), dx, dy, dz, 0.0, 0.2, 0.0);
            }
        }
        if (this.ab > 200 || this.orbiting == null || this.orbiting.L) {
            this.x();
        }
    }
    
    public void a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        this.M = 0.0f;
        this.newPosX = par1;
        this.newPosY = par3;
        this.newPosZ = par5;
        this.newRotationYaw = par7;
        this.newRotationPitch = par8;
        this.newPosRotationIncrements = par9;
    }
    
    protected void a() {
        this.ag.a(16, (Object)0);
        this.ag.a(17, (Object)"");
    }
    
    public String getOwnerName() {
        return this.ag.e(17);
    }
    
    public void setOwner(final String par1Str) {
        this.ag.b(17, (Object)par1Str);
    }
    
    public md getOwner() {
        return (md)this.p.a(this.getOwnerName());
    }
    
    public int getItemID() {
        return this.ag.c(16);
    }
    
    public void setItemID(final int par1Int) {
        this.ag.b(16, (Object)par1Int);
    }
    
    protected void a(final bq par1NBTTagCompound) {
        par1NBTTagCompound.a("Owner", this.getOwnerName());
        par1NBTTagCompound.a("ItemID", (short)this.getItemID());
    }
    
    protected void b(final bq par1NBTTagCompound) {
        this.setOwner(par1NBTTagCompound.i("Owner"));
        this.setItemID(par1NBTTagCompound.d("ItemID"));
    }
}
