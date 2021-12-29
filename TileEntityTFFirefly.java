// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFFirefly extends kt
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public float glowIntensity;
    public boolean glowing;
    public int glowDelay;
    
    public void n_() {
        if (this.anyPlayerInRange() && this.i.r.nextInt(20) == 0) {
            this.doFireflyFX();
        }
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.i.r.nextInt(200);
                this.desiredYaw = this.i.r.nextInt(15) - this.i.r.nextInt(15);
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
                this.glowDelay = this.i.r.nextInt(50);
            }
        }
    }
    
    public boolean anyPlayerInRange() {
        return this.i.a(this.j + 0.5, this.k + 0.5, this.l + 0.5, 16.0) != null;
    }
    
    void doFireflyFX() {
        final double rx = this.j + this.i.r.nextFloat();
        final double ry = this.k + this.i.r.nextFloat();
        final double rz = this.l + this.i.r.nextFloat();
        final EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(this.i, rx, ry, rz);
        this.i.e((nk)tinyfly);
    }
}
