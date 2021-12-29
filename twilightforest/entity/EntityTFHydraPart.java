// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFHydraPart extends ng
{
    public EntityTFHydra hydraObj;
    
    public EntityTFHydraPart(final zv world) {
        super(world);
        this.ag = true;
    }
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.q);
        this.a(f, f1);
        this.hydraObj = hydra;
        this.setPartName(s);
        this.aH = "/mods/twilightforest/textures/model/hydra4.png";
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
    
    public void b(final bs nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("PartName", this.getPartName());
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        this.setPartName(nbttagcompound.i("PartName"));
    }
    
    public void l_() {
        if (this.hydraObj != null && this.hydraObj.aZ > 190) {
            this.w();
        }
        if (this.hydraObj == null && this.ac > 1200) {
            this.w();
        }
        super.x();
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        if (this.bu > 0) {
            final double var1 = this.u + (this.bv - this.u) / this.bu;
            final double var2 = this.v + (this.bw - this.v) / this.bu;
            final double var3 = this.w + (this.bx - this.w) / this.bu;
            final double var4 = kx.g(this.by - this.A);
            this.A += (float)(var4 / this.bu);
            this.B += (float)((this.bz - this.B) / this.bu);
            --this.bu;
            this.b(var1, var2, var3);
            this.b(this.A, this.B);
        }
        this.aA = this.A;
        this.aB = this.C;
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
        while (this.B - this.D < -180.0f) {
            this.D -= 360.0f;
        }
        while (this.B - this.D >= 180.0f) {
            this.D += 360.0f;
        }
        while (this.aA - this.aB < -180.0f) {
            this.aB -= 360.0f;
        }
        while (this.aA - this.aB >= 180.0f) {
            this.aB += 360.0f;
        }
    }
    
    public int aW() {
        return 1000;
    }
    
    public boolean a(final mg damagesource, final int i) {
        return this.hydraObj != null && this.hydraObj.attackEntityFromPart(this, damagesource, i);
    }
    
    public boolean i(final mp entity) {
        return this == entity || this.hydraObj == entity;
    }
    
    protected void b(final float par1, final float par2) {
        this.A = par1 % 360.0f;
        this.B = par2 % 360.0f;
    }
}
