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
    
    public void func_145845_h() {
        final long counter = this.counter + 1L;
        this.counter = counter;
        if (counter % 4L == 0L) {
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "hugesmoke", this.field_145851_c + 0.5, this.field_145848_d + 0.95, this.field_145849_e + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
        }
    }
}
