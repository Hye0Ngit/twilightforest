// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.TwilightForestMod;

public class TileEntityTFSmoker extends any
{
    public long counter;
    
    public TileEntityTFSmoker() {
        this.counter = 0L;
    }
    
    public void g() {
        final long counter = this.counter + 1L;
        this.counter = counter;
        if (counter % 4L == 0L) {
            TwilightForestMod.proxy.spawnParticle("hugesmoke", this.l + 0.5, this.m + 0.95, this.n + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
        }
    }
}
