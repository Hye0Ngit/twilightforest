// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class EntityTFBird extends br
{
    public float flapLength;
    public float flapIntensity;
    public float lastFlapIntensity;
    public float lastFlapLength;
    public float flapSpeed;
    
    public EntityTFBird(final ge par1World) {
        super(par1World);
        this.flapLength = 0.0f;
        this.flapIntensity = 0.0f;
        this.flapSpeed = 1.0f;
    }
    
    public boolean c_() {
        return true;
    }
    
    public void e() {
        super.e();
        this.lastFlapLength = this.flapLength;
        this.lastFlapIntensity = this.flapIntensity;
        this.flapIntensity += (float)((this.bx ? -1 : 4) * 0.3);
        if (this.flapIntensity < 0.0f) {
            this.flapIntensity = 0.0f;
        }
        if (this.flapIntensity > 1.0f) {
            this.flapIntensity = 1.0f;
        }
        if (!this.bx && this.flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        this.flapSpeed *= (float)0.9;
        if (!this.bx && this.bq < 0.0) {
            this.bq *= 0.6;
        }
        this.flapLength += this.flapSpeed * 2.0f;
    }
    
    protected void a(final float par1) {
    }
    
    protected boolean g_() {
        return false;
    }
    
    protected int f() {
        return id.K.bP;
    }
    
    public br a(final br var1) {
        return null;
    }
}
