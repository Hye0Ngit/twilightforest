// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFSmoker extends TileEntity
{
    public long counter;
    
    public TileEntityTFSmoker() {
        this.counter = 0L;
    }
    
    public void func_70316_g() {
        final long counter = this.counter + 1L;
        this.counter = counter;
        if (counter % 4L == 0L) {
            TwilightForestMod.proxy.spawnParticle("hugesmoke", this.field_70329_l + 0.5, this.field_70330_m + 0.95, this.field_70327_n + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
        }
    }
}
