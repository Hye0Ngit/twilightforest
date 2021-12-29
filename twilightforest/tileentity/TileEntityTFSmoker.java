// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFSmoker extends TileEntity implements ITickable
{
    private long counter;
    
    public TileEntityTFSmoker() {
        this.counter = 0L;
    }
    
    public void func_73660_a() {
        if (this.field_145850_b.field_72995_K) {
            final long counter = this.counter + 1L;
            this.counter = counter;
            if (counter % 4L == 0L) {
                TwilightForestMod.proxy.spawnParticle(TFParticleType.HUGE_SMOKE, this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.95, this.field_174879_c.func_177952_p() + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
        }
    }
}
