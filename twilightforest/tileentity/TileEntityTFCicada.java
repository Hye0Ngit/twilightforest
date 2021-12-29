// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.TwilightForestMod;

public class TileEntityTFCicada extends TileEntityTFCritter
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public int singDuration;
    public boolean singing;
    public int singDelay;
    
    @Override
    public void g() {
        super.g();
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.k.t.nextInt(200);
                this.desiredYaw = this.k.t.nextInt(15) - this.k.t.nextInt(15);
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
        if (this.singDelay > 0) {
            --this.singDelay;
        }
        else {
            if (this.singing && this.singDuration == 0) {
                this.playSong();
            }
            if (this.singing && this.singDuration >= 100) {
                this.singing = false;
                this.singDuration = 0;
            }
            if (this.singing && this.singDuration < 100) {
                ++this.singDuration;
                this.doSingAnimation();
            }
            if (!this.singing && this.singDuration <= 0) {
                this.singing = true;
                this.singDelay = 100 + this.k.t.nextInt(100);
            }
        }
    }
    
    public void doSingAnimation() {
        if (this.k.t.nextInt(5) == 0) {
            final double rx = this.l + this.k.t.nextFloat();
            final double ry = this.m + this.k.t.nextFloat();
            final double rz = this.n + this.k.t.nextFloat();
            this.k.a("note", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public void playSong() {
        if (!TwilightForestMod.silentCicadas) {
            this.k.a((double)this.l, (double)this.m, (double)this.n, "mob.tf.cicada", 1.0f, (this.k.t.nextFloat() - this.k.t.nextFloat()) * 0.2f + 1.0f);
        }
    }
}
