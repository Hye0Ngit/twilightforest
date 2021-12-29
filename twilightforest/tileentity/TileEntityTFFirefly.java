// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.passive.EntityTFTinyFirefly;

public class TileEntityTFFirefly extends TileEntityTFCritter
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public float glowIntensity;
    public boolean glowing;
    public int glowDelay;
    
    @Override
    public void h() {
        super.h();
        if (this.anyPlayerInRange() && this.k.s.nextInt(20) == 0) {
            this.doFireflyFX();
        }
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.k.s.nextInt(200);
                this.desiredYaw = this.k.s.nextInt(15) - this.k.s.nextInt(15);
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
                this.glowDelay = this.k.s.nextInt(50);
            }
        }
    }
    
    public boolean anyPlayerInRange() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 16.0) != null;
    }
    
    void doFireflyFX() {
        final double rx = this.l + this.k.s.nextFloat();
        final double ry = this.m + this.k.s.nextFloat();
        final double rz = this.n + this.k.s.nextFloat();
        final EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(this.k, rx, ry, rz);
        this.k.c((nm)tinyfly);
    }
}
