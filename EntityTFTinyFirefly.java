// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFTinyFirefly extends sd
{
    int lifeTime;
    int halfLife;
    float glowSize;
    
    public EntityTFTinyFirefly(final ry world, final double d, final double d1, final double d2) {
        super(world);
        this.c(d, d1, d2, 0.0f, 0.0f);
        this.lifeTime = 10 + this.Y.nextInt(21);
        this.halfLife = this.lifeTime / 2;
        this.glowSize = 0.2f + this.Y.nextFloat() * 0.6f;
    }
    
    public void a() {
        super.a();
        if (this.lifeTime <= 1) {
            this.v();
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
    
    protected void b(final ik nbttagcompound) {
    }
    
    protected void a(final ik nbttagcompound) {
    }
}
