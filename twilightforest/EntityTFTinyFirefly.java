// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFTinyFirefly extends si
{
    int lifeTime;
    int halfLife;
    float glowSize;
    
    public EntityTFTinyFirefly(final xd world, final double d, final double d1, final double d2) {
        super(world);
        this.c(d, d1, d2, 0.0f, 0.0f);
        this.lifeTime = 10 + this.U.nextInt(21);
        this.halfLife = this.lifeTime / 2;
        this.glowSize = 0.2f + this.U.nextFloat() * 0.6f;
    }
    
    public void J_() {
        super.J_();
        if (this.lifeTime <= 1) {
            this.A();
        }
        else {
            --this.lifeTime;
        }
    }
    
    public float getGlowBrightness() {
        if (this.lifeTime <= this.halfLife) {
            return this.lifeTime / (float)this.halfLife;
        }
        return 1.0f - (this.lifeTime - (float)this.halfLife) / this.halfLife;
    }
    
    protected void b() {
    }
    
    protected void a(final ady nbttagcompound) {
    }
    
    protected void b(final ady nbttagcompound) {
    }
}
