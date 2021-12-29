// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TileEntityTFMoonworm extends TileEntityTFCritter
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    
    public TileEntityTFMoonworm() {
        this.currentYaw = -1;
        this.yawDelay = 0;
        this.desiredYaw = 0;
    }
    
    @Override
    public void g() {
        super.g();
        if (this.currentYaw == -1) {
            this.currentYaw = this.k.u.nextInt(4) * 90;
        }
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.desiredYaw == 0) {
                this.yawDelay = 200 + this.k.u.nextInt(200);
                this.desiredYaw = this.k.u.nextInt(4) * 90;
            }
            ++this.currentYaw;
            if (this.currentYaw > 360) {
                this.currentYaw = 0;
            }
            if (this.currentYaw == this.desiredYaw) {
                this.desiredYaw = 0;
            }
        }
    }
}
