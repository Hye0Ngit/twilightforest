// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTinyFirefly extends pt
{
    int lifeTime;
    int halfLife;
    public float glowSize;
    
    public EntityTFTinyFirefly(final yc world, final double d, final double d1, final double d2) {
        super(world);
        this.b(d, d1, d2, 0.0f, 0.0f);
        this.lifeTime = 10 + this.aa.nextInt(21);
        this.halfLife = this.lifeTime / 2;
        this.glowSize = 0.2f + this.aa.nextFloat() * 0.6f;
    }
    
    public void j_() {
        super.j_();
        if (this.lifeTime <= 1) {
            this.x();
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
    
    protected void a() {
    }
    
    protected void a(final bq nbttagcompound) {
    }
    
    protected void b(final bq nbttagcompound) {
    }
}
