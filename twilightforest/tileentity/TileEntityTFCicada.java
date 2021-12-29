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
    public void func_70316_g() {
        super.func_70316_g();
        if (this.yawDelay > 0) {
            --this.yawDelay;
        }
        else {
            if (this.currentYaw == 0 && this.desiredYaw == 0) {
                this.yawDelay = 200 + this.field_70331_k.field_73012_v.nextInt(200);
                this.desiredYaw = this.field_70331_k.field_73012_v.nextInt(15) - this.field_70331_k.field_73012_v.nextInt(15);
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
                this.singDelay = 100 + this.field_70331_k.field_73012_v.nextInt(100);
            }
        }
    }
    
    public void doSingAnimation() {
        if (this.field_70331_k.field_73012_v.nextInt(5) == 0) {
            final double rx = this.field_70329_l + this.field_70331_k.field_73012_v.nextFloat();
            final double ry = this.field_70330_m + this.field_70331_k.field_73012_v.nextFloat();
            final double rz = this.field_70327_n + this.field_70331_k.field_73012_v.nextFloat();
            this.field_70331_k.func_72869_a("note", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public void playSong() {
        if (!TwilightForestMod.silentCicadas) {
            this.field_70331_k.func_72908_a((double)this.field_70329_l, (double)this.field_70330_m, (double)this.field_70327_n, "TwilightForest:mob.cicada", 1.0f, (this.field_70331_k.field_73012_v.nextFloat() - this.field_70331_k.field_73012_v.nextFloat()) * 0.2f + 1.0f);
        }
    }
}
