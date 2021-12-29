// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public abstract class EntityTFBird extends ox
{
    public float flapLength;
    public float flapIntensity;
    public float lastFlapIntensity;
    public float lastFlapLength;
    public float flapSpeed;
    
    public EntityTFBird(final xv par1World) {
        super(par1World);
        this.flapLength = 0.0f;
        this.flapIntensity = 0.0f;
        this.flapSpeed = 1.0f;
    }
    
    public boolean be() {
        return true;
    }
    
    public void c() {
        super.c();
        this.lastFlapLength = this.flapLength;
        this.lastFlapIntensity = this.flapIntensity;
        this.flapIntensity += (float)((this.E ? -1 : 4) * 0.3);
        if (this.flapIntensity < 0.0f) {
            this.flapIntensity = 0.0f;
        }
        if (this.flapIntensity > 1.0f) {
            this.flapIntensity = 1.0f;
        }
        if (!this.E && this.flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        this.flapSpeed *= (float)0.9;
        if (!this.E && this.x < 0.0) {
            this.x *= 0.6;
        }
        this.flapLength += this.flapSpeed * 2.0f;
    }
    
    protected void a(final float par1) {
    }
    
    protected boolean f_() {
        return false;
    }
    
    protected int bb() {
        return uk.L.cg;
    }
    
    public ox func_90011_a(final ln entityanimal) {
        return null;
    }
}
