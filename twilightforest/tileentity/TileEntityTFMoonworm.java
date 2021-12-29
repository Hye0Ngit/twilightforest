// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

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
    public void func_70316_g() {
        super.func_70316_g();
        if (this.currentYaw == -1) {
            this.currentYaw = this.field_70331_k.field_73012_v.nextInt(4) * 90;
        }
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.desiredYaw == 0) {
                this.yawDelay = 200 + this.field_70331_k.field_73012_v.nextInt(200);
                this.desiredYaw = this.field_70331_k.field_73012_v.nextInt(4) * 90;
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
