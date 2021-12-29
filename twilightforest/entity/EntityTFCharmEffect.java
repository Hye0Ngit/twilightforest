// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;

public class EntityTFCharmEffect extends nm
{
    private static final int DATA_OWNER = 17;
    private static final int DATA_ITEMID = 16;
    private static final double DISTANCE = 1.75;
    private oe orbiting;
    private double newPosX;
    private double newPosY;
    private double newPosZ;
    private double newRotationYaw;
    private double newRotationPitch;
    private int newPosRotationIncrements;
    public float offset;
    
    public EntityTFCharmEffect(final abv par1World) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.setItemID(TFItems.charmOfLife1.cv);
    }
    
    public EntityTFCharmEffect(final abv par1World, final oe par2EntityLiving, final int itemID) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.orbiting = par2EntityLiving;
        this.setOwner(this.orbiting.am());
        this.setItemID(itemID);
        final asz look = this.q.V().a(1.75, 0.0, 0.0);
        this.b(par2EntityLiving.u, par2EntityLiving.v + par2EntityLiving.f(), par2EntityLiving.w, par2EntityLiving.A, par2EntityLiving.B);
        this.u += look.c * 1.75;
        this.w += look.e * 1.75;
        this.b(this.u, this.v, this.w);
        this.N = 0.0f;
    }
    
    public void l_() {
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        super.l_();
        if (this.newPosRotationIncrements > 0) {
            final double var1 = this.u + (this.newPosX - this.u) / this.newPosRotationIncrements;
            final double var2 = this.v + (this.newPosY - this.v) / this.newPosRotationIncrements;
            final double var3 = this.w + (this.newPosZ - this.w) / this.newPosRotationIncrements;
            final double var4 = lr.g(this.newRotationYaw - this.A);
            this.A += (float)(var4 / this.newPosRotationIncrements);
            this.B += (float)((this.newRotationPitch - this.B) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.b(var1, var2, var3);
            this.b(this.A, this.B);
        }
        final float rotation = this.ac / 5.0f + this.offset;
        if (this.orbiting == null) {
            this.orbiting = this.getOwner();
        }
        if (this.orbiting != null && !this.q.I) {
            this.b(this.orbiting.u, this.orbiting.v + this.orbiting.f(), this.orbiting.w, this.orbiting.A, this.orbiting.B);
            final asz look = this.q.V().a(1.75, 0.0, 0.0);
            look.b(rotation);
            this.u += look.c;
            this.w += look.e;
            this.b(this.u, this.v, this.w);
        }
        if (this.getItemID() > 0) {
            for (int i = 0; i < 3; ++i) {
                final double dx = this.u + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
                final double dy = this.v + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
                final double dz = this.w + 0.5 * (this.ab.nextDouble() - this.ab.nextDouble());
                this.q.a("iconcrack_" + this.getItemID(), dx, dy, dz, 0.0, 0.2, 0.0);
            }
        }
        if (this.ac > 200 || this.orbiting == null || this.orbiting.M) {
            this.w();
        }
    }
    
    public void a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        this.N = 0.0f;
        this.newPosX = par1;
        this.newPosY = par3;
        this.newPosZ = par5;
        this.newRotationYaw = par7;
        this.newRotationPitch = par8;
        this.newPosRotationIncrements = par9;
    }
    
    protected void a() {
        this.ah.a(16, (Object)0);
        this.ah.a(17, (Object)"");
    }
    
    public String getOwnerName() {
        return this.ah.e(17);
    }
    
    public void setOwner(final String par1Str) {
        this.ah.b(17, (Object)par1Str);
    }
    
    public oe getOwner() {
        return (oe)this.q.a(this.getOwnerName());
    }
    
    public int getItemID() {
        return this.ah.c(16);
    }
    
    public void setItemID(final int par1Int) {
        this.ah.b(16, (Object)par1Int);
    }
    
    protected void a(final bx par1NBTTagCompound) {
        par1NBTTagCompound.a("Owner", this.getOwnerName());
        par1NBTTagCompound.a("ItemID", (short)this.getItemID());
    }
    
    protected void b(final bx par1NBTTagCompound) {
        this.setOwner(par1NBTTagCompound.i("Owner"));
        this.setItemID(par1NBTTagCompound.d("ItemID"));
    }
}
