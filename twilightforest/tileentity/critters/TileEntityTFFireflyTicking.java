// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.critters;

import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ITickable;

public class TileEntityTFFireflyTicking extends TileEntityTFFirefly implements ITickable
{
    private int yawDelay;
    public int currentYaw;
    private int desiredYaw;
    public float glowIntensity;
    private boolean glowing;
    private int glowDelay;
    
    public void func_73660_a() {
        if (this.field_145850_b.field_72995_K) {
            if (this.anyPlayerInRange() && this.field_145850_b.field_73012_v.nextInt(20) == 0) {
                this.spawnParticles();
            }
            if (this.yawDelay > 0) {
                --this.yawDelay;
            }
            else {
                if (this.currentYaw == 0 && this.desiredYaw == 0) {
                    this.yawDelay = 200 + this.field_145850_b.field_73012_v.nextInt(200);
                    this.desiredYaw = this.field_145850_b.field_73012_v.nextInt(15) - this.field_145850_b.field_73012_v.nextInt(15);
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
                    this.glowDelay = this.field_145850_b.field_73012_v.nextInt(50);
                }
            }
        }
    }
    
    private boolean anyPlayerInRange() {
        return this.field_145850_b.func_184137_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, 16.0, false) != null;
    }
    
    private void spawnParticles() {
        final double rx = this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextFloat();
        final double ry = this.field_174879_c.func_177956_o() + this.field_145850_b.field_73012_v.nextFloat();
        final double rz = this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextFloat();
        TwilightForestMod.proxy.spawnParticle(TFParticleType.FIREFLY, rx, ry, rz, 0.0, 0.0, 0.0);
    }
}
