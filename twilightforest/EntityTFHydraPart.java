// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHydraPart extends acq
{
    public final EntityTFHydra hydraObj;
    public final String name;
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.k);
        this.a(f, f1);
        this.hydraObj = hydra;
        this.name = s;
        this.bm = "/twilightforest/hydra4.png";
        this.ab = true;
    }
    
    public void J_() {
        super.B();
        this.N = this.o;
        this.O = this.p;
        this.P = this.q;
        this.bf = this.u;
        while (this.u - this.w < -180.0f) {
            this.w -= 360.0f;
        }
        while (this.u - this.w >= 180.0f) {
            this.w += 360.0f;
        }
        while (this.bd - this.be < -180.0f) {
            this.be -= 360.0f;
        }
        while (this.bd - this.be >= 180.0f) {
            this.be += 360.0f;
        }
        while (this.v - this.x < -180.0f) {
            this.x -= 360.0f;
        }
        while (this.v - this.x >= 180.0f) {
            this.x += 360.0f;
        }
        while (this.bf - this.bg < -180.0f) {
            this.bg -= 360.0f;
        }
        while (this.bf - this.bg >= 180.0f) {
            this.bg += 360.0f;
        }
    }
    
    public int d() {
        return 1000;
    }
    
    public boolean a(final md damagesource, final int i) {
        return this.hydraObj.a(damagesource, i);
    }
    
    public boolean a(final nn entity) {
        return this == entity || this.hydraObj == entity;
    }
}
