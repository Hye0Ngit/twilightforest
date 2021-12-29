// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.TFConfig;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class CicadaTileEntity extends TileEntity implements ITickableTileEntity
{
    private int yawDelay;
    public int currentYaw;
    private int desiredYaw;
    private int singDuration;
    private boolean singing;
    private int singDelay;
    
    public CicadaTileEntity() {
        super((TileEntityType)TFTileEntities.CICADA.get());
    }
    
    public void func_73660_a() {
        if (this.field_145850_b.field_72995_K) {
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
                    this.singDelay = 100 + this.field_145850_b.field_73012_v.nextInt(100);
                }
            }
        }
    }
    
    private void doSingAnimation() {
        if (this.field_145850_b.field_73012_v.nextInt(5) == 0) {
            final double rx = this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextFloat();
            final double ry = this.field_174879_c.func_177956_o() + this.field_145850_b.field_73012_v.nextFloat();
            final double rz = this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextFloat();
            this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197597_H, rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    private void playSong() {
        if (!(boolean)TFConfig.CLIENT_CONFIG.silentCicadas.get()) {
            this.field_145850_b.func_184134_a((double)this.field_174879_c.func_177958_n(), (double)this.field_174879_c.func_177956_o(), (double)this.field_174879_c.func_177952_p(), TFSounds.CICADA, SoundCategory.NEUTRAL, 1.0f, (this.field_145850_b.field_73012_v.nextFloat() - this.field_145850_b.field_73012_v.nextFloat()) * 0.2f + 1.0f, false);
        }
    }
}
