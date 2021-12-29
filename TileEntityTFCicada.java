// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFCicada extends ow
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public int singDuration;
    public boolean singing;
    public int singDelay;
    
    public void l_() {
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.k.w.nextInt(200);
                this.desiredYaw = this.k.w.nextInt(15) - this.k.w.nextInt(15);
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
                this.singDelay = 100 + this.k.w.nextInt(100);
            }
        }
    }
    
    public void doSingAnimation() {
        if (this.k.w.nextInt(5) == 0) {
            final double rx = this.l + this.k.w.nextFloat();
            final double ry = this.m + this.k.w.nextFloat();
            final double rz = this.n + this.k.w.nextFloat();
            this.k.a("note", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public void playSong() {
        this.k.a((double)this.l, (double)this.m, (double)this.n, "mob.tf.cicada", 1.0f, (this.k.w.nextFloat() - this.k.w.nextFloat()) * 0.2f + 1.0f);
    }
}
