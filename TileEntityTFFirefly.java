// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFFirefly extends bq
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public float glowIntensity;
    public boolean glowing;
    public int glowDelay;
    
    public void b() {
        if (this.anyPlayerInRange() && this.c.w.nextInt(20) == 0) {
            this.doFireflyFX();
        }
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.c.w.nextInt(200);
                this.desiredYaw = this.c.w.nextInt(15) - this.c.w.nextInt(15);
            }
            if (this.currentYaw < this.desiredYaw) {
                ++this.currentYaw;
            }
            if (this.currentYaw > this.desiredYaw) {
                --this.currentYaw;
            }
            if (this.currentYaw == this.desiredYaw) {
                this.desiredYaw = 0;
            }
        }
        if (this.glowDelay > 0) {
            --this.glowDelay;
        }
        else {
            if (this.glowing && this.glowIntensity >= 1.0) {
                this.glowing = false;
            }
            if (this.glowing && this.glowIntensity < 1.0) {
                this.glowIntensity += (float)0.05;
            }
            if (!this.glowing && this.glowIntensity > 0.0f) {
                this.glowIntensity -= (float)0.05;
            }
            if (!this.glowing && this.glowIntensity <= 0.0f) {
                this.glowing = true;
                this.glowDelay = this.c.w.nextInt(50);
            }
        }
    }
    
    public boolean anyPlayerInRange() {
        return this.c.a(this.d + 0.5, this.e + 0.5, this.f + 0.5, 16.0) != null;
    }
    
    void doFireflyFX() {
        final double rx = this.d + this.c.w.nextFloat();
        final double ry = this.e + this.c.w.nextFloat();
        final double rz = this.f + this.c.w.nextFloat();
        final EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(this.c, rx, ry, rz);
        this.c.e((ia)tinyfly);
    }
}
