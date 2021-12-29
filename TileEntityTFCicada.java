// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFCicada extends qj
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public int singDuration;
    public boolean singing;
    public int singDelay;
    
    public void q_() {
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.k.r.nextInt(200);
                this.desiredYaw = this.k.r.nextInt(15) - this.k.r.nextInt(15);
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
                this.singDelay = 100 + this.k.r.nextInt(100);
            }
        }
    }
    
    public int k() {
        if (super.k() == 0) {
            this.p = -1;
        }
        return super.k();
    }
    
    public void doSingAnimation() {
        if (this.k.r.nextInt(5) == 0) {
            final double rx = this.l + this.k.r.nextFloat();
            final double ry = this.m + this.k.r.nextFloat();
            final double rz = this.n + this.k.r.nextFloat();
            this.k.a("note", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public void playSong() {
        this.k.a((double)this.l, (double)this.m, (double)this.n, "mob.tf.cicada", 1.0f, (this.k.r.nextFloat() - this.k.r.nextFloat()) * 0.2f + 1.0f);
    }
}
