// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFCicada extends kt
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public int singDuration;
    public boolean singing;
    public int singDelay;
    
    public void n_() {
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
                this.singDelay = 100 + this.i.r.nextInt(100);
            }
        }
    }
    
    public void doSingAnimation() {
        if (this.i.r.nextInt(5) == 0) {
            final double rx = this.j + this.i.r.nextFloat();
            final double ry = this.k + this.i.r.nextFloat();
            final double rz = this.l + this.i.r.nextFloat();
            this.i.a("note", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public void playSong() {
        this.i.a((double)this.j, (double)this.k, (double)this.l, "mob.tf.cicada", 1.0f, (this.i.r.nextFloat() - this.i.r.nextFloat()) * 0.2f + 1.0f);
    }
}
