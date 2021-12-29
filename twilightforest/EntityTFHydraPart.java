// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHydraPart extends md
{
    public EntityTFHydra hydraObj;
    
    public EntityTFHydraPart(final xv world) {
        super(world);
        this.af = true;
    }
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.p);
        this.a(f, f1);
        this.hydraObj = hydra;
        this.setPartName(s);
        this.aF = "/twilightforest/hydra4.png";
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
        if (this.hydraObj != null && this.hydraObj.aX > 190) {
            this.x();
        }
        if (this.hydraObj == null && this.ab > 1200) {
            this.x();
        }
        super.y();
        this.T = this.t;
        this.U = this.u;
        this.V = this.v;
        if (this.bs > 0) {
            final double var1 = this.t + (this.bt - this.t) / this.bs;
            final double var2 = this.u + (this.bu - this.u) / this.bs;
            final double var3 = this.v + (this.bv - this.v) / this.bs;
            final double var4 = ke.g(this.bw - this.z);
            this.z += (float)(var4 / this.bs);
            this.A += (float)((this.bx - this.A) / this.bs);
            --this.bs;
            this.b(var1, var2, var3);
            this.b(this.z, this.A);
        }
        this.ay = this.z;
        this.az = this.B;
        while (this.z - this.B < -180.0f) {
            this.B -= 360.0f;
        }
        while (this.z - this.B >= 180.0f) {
            this.B += 360.0f;
        }
        while (this.aw - this.ax < -180.0f) {
            this.ax -= 360.0f;
        }
        while (this.aw - this.ax >= 180.0f) {
            this.ax += 360.0f;
        }
        while (this.A - this.C < -180.0f) {
            this.C -= 360.0f;
        }
        while (this.A - this.C >= 180.0f) {
            this.C += 360.0f;
        }
        while (this.ay - this.az < -180.0f) {
            this.az -= 360.0f;
        }
        while (this.ay - this.az >= 180.0f) {
            this.az += 360.0f;
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
