// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFHydraPart extends md
{
    public EntityTFHydra hydraObj;
    
    public EntityTFHydraPart(final yc world) {
        super(world);
        this.af = true;
    }
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.p);
        this.a(f, f1);
        this.hydraObj = hydra;
        this.setPartName(s);
        this.aG = "/twilightforest/hydra4.png";
        this.af = true;
    }
    
    protected void a() {
        super.a();
        this.ag.a(17, (Object)"");
    }
    
    public String getPartName() {
        return this.ag.e(17);
    }
    
    public void setPartName(final String name) {
        this.ag.b(17, (Object)name);
    }
    
    public void b(final bq nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("PartName", this.getPartName());
    }
    
    public void a(final bq nbttagcompound) {
        super.a(nbttagcompound);
        this.setPartName(nbttagcompound.i("PartName"));
    }
    
    public void j_() {
        if (this.hydraObj != null && this.hydraObj.aY > 190) {
            this.x();
        }
        if (this.hydraObj == null && this.ab > 1200) {
            this.x();
        }
        super.y();
        this.T = this.t;
        this.U = this.u;
        this.V = this.v;
        if (this.bt > 0) {
            final double var1 = this.t + (this.bu - this.t) / this.bt;
            final double var2 = this.u + (this.bv - this.u) / this.bt;
            final double var3 = this.v + (this.bw - this.v) / this.bt;
            final double var4 = ke.g(this.bx - this.z);
            this.z += (float)(var4 / this.bt);
            this.A += (float)((this.by - this.A) / this.bt);
            --this.bt;
            this.b(var1, var2, var3);
            this.b(this.z, this.A);
        }
        this.az = this.z;
        this.aA = this.B;
        while (this.z - this.B < -180.0f) {
            this.B -= 360.0f;
        }
        while (this.z - this.B >= 180.0f) {
            this.B += 360.0f;
        }
        while (this.ax - this.ay < -180.0f) {
            this.ay -= 360.0f;
        }
        while (this.ax - this.ay >= 180.0f) {
            this.ay += 360.0f;
        }
        while (this.A - this.C < -180.0f) {
            this.C -= 360.0f;
        }
        while (this.A - this.C >= 180.0f) {
            this.C += 360.0f;
        }
        while (this.az - this.aA < -180.0f) {
            this.aA -= 360.0f;
        }
        while (this.az - this.aA >= 180.0f) {
            this.aA += 360.0f;
        }
    }
    
    public int aT() {
        return 1000;
    }
    
    public boolean a(final lh damagesource, final int i) {
        return this.hydraObj != null && this.hydraObj.attackEntityFromPart(this, damagesource, i);
    }
    
    public boolean i(final lq entity) {
        return this == entity || this.hydraObj == entity;
    }
    
    protected void b(final float par1, final float par2) {
        this.z = par1 % 360.0f;
        this.A = par2 % 360.0f;
    }
}
