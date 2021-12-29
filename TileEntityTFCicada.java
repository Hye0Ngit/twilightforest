// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFCicada extends bq
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    public int singDuration;
    public boolean singing;
    public int singDelay;
    
    public void b() {
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
                this.singDelay = 100 + this.c.w.nextInt(100);
            }
        }
    }
    
    public void doSingAnimation() {
        if (this.c.w.nextInt(5) == 0) {
            final double rx = this.d + this.c.w.nextFloat();
            final double ry = this.e + this.c.w.nextFloat();
            final double rz = this.f + this.c.w.nextFloat();
            this.c.a("note", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public void playSong() {
        this.c.a((double)this.d, (double)this.e, (double)this.f, "mob.tf.cicada", 1.0f, (this.c.w.nextFloat() - this.c.w.nextFloat()) * 0.2f + 1.0f);
    }
}
