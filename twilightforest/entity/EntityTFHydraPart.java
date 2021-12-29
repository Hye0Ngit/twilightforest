// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFHydraPart extends of
{
    public EntityTFHydra hydraObj;
    
    public EntityTFHydraPart(final abv world) {
        super(world);
        this.ag = true;
    }
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.q);
        this.a(f, f1);
        this.hydraObj = hydra;
        this.setPartName(s);
        this.ag = true;
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)"");
    }
    
    public String getPartName() {
        return this.ah.e(17);
    }
    
    public void setPartName(final String name) {
        this.ah.b(17, (Object)name);
    }
    
    public void b(final bx nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("PartName", this.getPartName());
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        this.setPartName(nbttagcompound.i("PartName"));
    }
    
    public void l_() {
        if (this.hydraObj != null && this.hydraObj.aB > 190) {
            this.w();
        }
        if (this.hydraObj == null && this.ac > 1200) {
            this.w();
        }
        super.x();
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        if (this.bh > 0) {
            final double var1 = this.u + (this.bi - this.u) / this.bh;
            final double var2 = this.v + (this.bj - this.v) / this.bh;
            final double var3 = this.w + (this.bk - this.w) / this.bh;
            final double var4 = lr.g(this.bl - this.A);
            this.A += (float)(var4 / this.bh);
            this.B += (float)((this.bm - this.B) / this.bh);
            --this.bh;
            this.b(var1, var2, var3);
            this.b(this.A, this.B);
        }
        this.aP = this.A;
        this.aQ = this.C;
        while (this.A - this.C < -180.0f) {
            this.C -= 360.0f;
        }
        while (this.A - this.C >= 180.0f) {
            this.C += 360.0f;
        }
        while (this.aN - this.aO < -180.0f) {
            this.aO -= 360.0f;
        }
        while (this.aN - this.aO >= 180.0f) {
            this.aO += 360.0f;
        }
        while (this.B - this.D < -180.0f) {
            this.D -= 360.0f;
        }
        while (this.B - this.D >= 180.0f) {
            this.D += 360.0f;
        }
        while (this.aP - this.aQ < -180.0f) {
            this.aQ -= 360.0f;
        }
        while (this.aP - this.aQ >= 180.0f) {
            this.aQ += 360.0f;
        }
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(1000.0);
    }
    
    public boolean a(final na damagesource, final float i) {
        return this.hydraObj != null && this.hydraObj.attackEntityFromPart(this, damagesource, i);
    }
    
    public boolean h(final nm entity) {
        return this == entity || this.hydraObj == entity;
    }
    
    protected void b(final float par1, final float par2) {
        this.A = par1 % 360.0f;
        this.B = par2 % 360.0f;
    }
}
