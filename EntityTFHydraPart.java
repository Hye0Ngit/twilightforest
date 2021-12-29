// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHydraPart extends ne
{
    public final EntityTFHydra hydraObj;
    public final String name;
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.bi);
        this.b(f, f1);
        this.hydraObj = hydra;
        this.name = s;
        this.ae = "/twilightforest/hydra4.png";
        this.bX = true;
    }
    
    public void F_() {
        this.bL = this.bm;
        this.bM = this.bn;
        this.bN = this.bo;
        while (this.bs - this.bu < -180.0f) {
            this.bu -= 360.0f;
        }
        while (this.bs - this.bu >= 180.0f) {
            this.bu += 360.0f;
        }
        while (this.V - this.W < -180.0f) {
            this.W -= 360.0f;
        }
        while (this.V - this.W >= 180.0f) {
            this.W += 360.0f;
        }
        while (this.bt - this.bv < -180.0f) {
            this.bv -= 360.0f;
        }
        while (this.bt - this.bv >= 180.0f) {
            this.bv += 360.0f;
        }
        super.aA();
    }
    
    public int d() {
        return 1000;
    }
    
    public boolean a(final rq damagesource, final int i) {
        return this.hydraObj.a(damagesource, i);
    }
    
    public boolean a_(final tv entity) {
        return this == entity || this.hydraObj == entity;
    }
}
