// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

public abstract class EntityTFBird extends ro
{
    public float flapLength;
    public float flapIntensity;
    public float lastFlapIntensity;
    public float lastFlapLength;
    public float flapSpeed;
    
    public EntityTFBird(final abv par1World) {
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
        this.flapIntensity += (float)((this.F ? -1 : 4) * 0.3);
        if (this.flapIntensity < 0.0f) {
            this.flapIntensity = 0.0f;
        }
        if (this.flapIntensity > 1.0f) {
            this.flapIntensity = 1.0f;
        }
        if (!this.F && this.flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        this.flapSpeed *= (float)0.9;
        if (!this.F && this.y < 0.0) {
            this.y *= 0.6;
        }
        this.flapLength += this.flapSpeed * 2.0f;
    }
    
    protected void b(final float par1) {
    }
    
    protected boolean e_() {
        return false;
    }
    
    protected int s() {
        return yb.N.cv;
    }
    
    public ro createChild(final nj entityanimal) {
        return null;
    }
    
    public boolean isBirdLanded() {
        return true;
    }
}
