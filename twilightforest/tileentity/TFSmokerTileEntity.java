// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TFSmokerTileEntity extends TileEntity implements ITickableTileEntity
{
    private long counter;
    
    public TFSmokerTileEntity() {
        super((TileEntityType)TFTileEntities.SMOKER.get());
        this.counter = 0L;
    }
    
    public void func_73660_a() {
        if (this.field_145850_b.field_72995_K) {
            final long counter = this.counter + 1L;
            this.counter = counter;
            if (counter % 4L == 0L) {
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.HUGE_SMOKE.get(), this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.95, this.field_174879_c.func_177952_p() + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
        }
    }
}
